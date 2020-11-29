package tekup.project.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tekup.project.model.Dto;
import tekup.project.service.Scrapping;
import tekup.project.service.ScrappingMytek;
import tekup.project.service.ScrappingWiki;

@RestController
public class LaptopScrap {

	@Autowired
	private Scrapping scrapTN;
	@Autowired
	private ScrappingMytek scrapMYTek;
	@Autowired
	private ScrappingWiki scrapWiki;
	
	
	
	@GetMapping("/tunisiaNet")
	public List<Dto> tunisiaNetLapTop() {
		return scrapTN.scrapelaptop();
	}
	
	
	@GetMapping("/mytek")
	public List<Dto> mytekLapTop() {
		return scrapMYTek.scrapeMytek();
	}
	
	@GetMapping("/wiki")
	public List<Dto> wikiLapTop() {
		return scrapWiki.scrapeWiki();
	}
	
}
