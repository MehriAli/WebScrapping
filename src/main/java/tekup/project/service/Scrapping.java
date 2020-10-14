package tekup.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Scrapping {

	private final String URL = "https://www.vol-direct.fr/vols/resultats/PAR-ROM/2020-10-24/00/ROM-PAR/2020-10-31/00/0/1-0-0?sid=FFR6_5f86b7877d113&source=c2VhcmNoLWZvcm18";
	private final ChromeDriver driver;
	List<String> myInfos;
	
	
	public String scrapeTitle() {
		driver.get(URL);		
		String title = driver.getTitle();		
		return title ;
	}
	
	public String scrapeFlight() {
		driver.get(URL);
		
		WebElement content=driver.findElementByClassName("small");
		
		String inf=content.findElement(By.tagName("span")).getText();
	
			
		
		return inf;
	}

}



