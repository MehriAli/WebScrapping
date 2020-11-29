package tekup.project.service;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tekup.project.model.Dto;

@Service
@AllArgsConstructor
public class ScrappingWiki {
	private final String URL = "http://127.0.0.1:5000/wiki";
	private final ChromeDriver driver;
	private List<Dto> laptop;
	
	
	
	
	public List<Dto> scrapeWiki() {
		driver.get(URL);
		WebElement content=driver.findElementByTagName("body");
		String inf=content.getText();
		
		final String SEPARATEUR = ",";
		String mots[] = inf.split(SEPARATEUR);
		
		for (int i = 0,j=1; i < mots.length; i++,j++) {
			String str=mots[i+2];
			String words[]=str.split(" ");
			String marque=words[2];
			
			String str1=mots[i+3]; 
			String words1[]=str1.split(";"); 
			String prix=words1[1]; 
			String disponibil=words1[0];
			
			Long myId=(long)j;
			laptop.add(new Dto(myId,mots[i],mots[i+1],marque,mots[i+2],prix+"DT",disponibil));
			i=i+4;
        }
		
			
		
		return laptop;
	}

}
