package tekup.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tekup.project.service.Scrapping;

@RestController
public class WebElement {

	
	@Autowired
	private Scrapping scr;
	
	@GetMapping("/getTitle")
	public String getTitles() {
		return scr.scrapeTitle();
	}
	@GetMapping("/getFlight")
	public String getFlight() {
		return scr.scrapeFlight();
	}
}
