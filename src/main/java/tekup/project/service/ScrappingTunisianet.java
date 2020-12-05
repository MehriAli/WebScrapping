package tekup.project.service;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tekup.project.model.Dto;

@Service
@AllArgsConstructor
public class ScrappingTunisianet {
	private ChromeDriver driver;
	private List<Dto> laptop;
	private final String URL = "http://127.0.0.1:5000/tunisianet";
	private final String URL_Desktop = "http://127.0.0.1:5000/tunisianetDesktop";
	
	
	public List<Dto> scrapelaptop() {
		driver.get(URL);
		WebElement content = driver.findElementByTagName("body");
		String inf = content.getText();
		final String SEPARATEUR = ",";
		String mots[] = inf.split(SEPARATEUR);

		for (int i = 0 , j=1; j<13; i++,j++) {
			String str = mots[i + 2];
			String words[] = str.split(" ");
			String marque = words[0]+" "+words[1]+" "+words[2]+" "+words[3];
			String str1 = mots[i + 3];
			String words1[] = str1.split(";");

			String disponibil = words1[0];

			String prix = "";
			String monprix = words1[1];
			String prix1[] = monprix.split(" ");
			for (int p = 0; p < prix1.length; p++) {
				prix = prix + prix1[p];
			}
			int price = Integer.parseInt(prix);
			
			Long myId=(long)j;
			laptop.add(new Dto(myId,mots[i], mots[i + 1], marque, mots[i + 2], price, disponibil));
			i = i + 4;
		}

		return laptop.subList(0, 12);
	}
	
	
	public List<Dto> scrapedesktop() {
		driver.get(URL_Desktop);
		WebElement content = driver.findElementByTagName("body");
		String inf = content.getText();
		final String SEPARATEUR = ",";
		String mots[] = inf.split(SEPARATEUR);

		for (int i = 0 , j=1; j<13; i++,j++) {
			String str = mots[i + 2];
			String words[] = str.split(" ");
			String marque = words[0]+" "+words[1]+" "+words[2]+" "+words[3];
			String str1 = mots[i + 3];
			String words1[] = str1.split(";");

			String disponibil = words1[0];

			String prix = "";
			String monprix = words1[1];
			String prix1[] = monprix.split(" ");
			for (int p = 0; p < prix1.length; p++) {
				prix = prix + prix1[p];
			}
			int price = Integer.parseInt(prix);
			
			Long myId=(long)j;
			laptop.add(new Dto(myId,mots[i], mots[i + 1], marque, mots[i + 2], price, disponibil));
			i = i + 4;
		}

		return laptop.subList(0, 12);
	}

}