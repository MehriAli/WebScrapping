package tekup.project.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tekup.project.model.Dto;

import tekup.project.service.ScrappingTunisianet;
import tekup.project.service.ScrappingMytek;
import tekup.project.service.ScrappingWiki;

@RestController
public class LaptopScrap {

	@Autowired
	private ScrappingTunisianet scrapTN;
	@Autowired
	private ScrappingMytek scrapMYTek;
	@Autowired
	private ScrappingWiki scrapWiki;

	// here you find tunisianet's items
	@GetMapping("/tunisiaNet")
	public List<Dto> tunisiaNetLapTop() {
		return scrapTN.scrapelaptop();
	}

	@GetMapping("/tunisiaNetdesktop")
	public List<Dto> tunisiaNetDeskTop() {
		return scrapTN.scrapedesktop();
	}

	// here you find mytek's items
	@GetMapping("/mytek")
	public List<Dto> mytekLapTop() {
		return scrapMYTek.scrapeMytek();
	}

	@GetMapping("/mytekDesktop")
	public List<Dto> mytekDesktop() {
		return scrapMYTek.scrapeMytekDesktop();
	}

	// here you find wiki's items
	@GetMapping("/wiki")
	public List<Dto> wikiLapTop() {
		return scrapWiki.scrapeWiki();
	}

	@GetMapping("/wikiDesktop")
	public List<Dto> wikiDesktop() {
		return scrapWiki.scrapeWikiDesktop();
	}

	
	// here you find a sorted list for each categorie

	@GetMapping("/sortedlist")
	public List<Dto> getSortedList() {

		List<Dto> union = new ArrayList<Dto>();

		List<Dto> x = new ArrayList<Dto>(scrapTN.scrapelaptop());
		List<Dto> y = new ArrayList<Dto>(scrapMYTek.scrapeMytek());
		List<Dto> z = new ArrayList<Dto>(scrapWiki.scrapeWiki());

		union.addAll(x);
		union.addAll(y);
		union.addAll(z);

		Comparator<Dto> compareByPrice = (Dto o1, Dto o2) -> o1.getPrix().compareTo(o2.getPrix());
		union.sort(compareByPrice);

		return union;
	}

	@GetMapping("/sortedlistDesktop")
	public List<Dto> getSortedListDesktop() {
		List<Dto> union = new ArrayList<Dto>();

		List<Dto> x = new ArrayList<Dto>(scrapTN.scrapedesktop());
		List<Dto> y = new ArrayList<Dto>(scrapMYTek.scrapeMytekDesktop());
		List<Dto> z = new ArrayList<Dto>(scrapWiki.scrapeWikiDesktop());

		y.forEach(a -> a.setId(a.getId() + 12));
		z.forEach(a -> a.setId(a.getId() + 24));

		union.addAll(x);
		union.addAll(y);
		union.addAll(z);

		Comparator<Dto> compareByPrice = (Dto o1, Dto o2) -> o1.getPrix().compareTo(o2.getPrix());
		union.sort(compareByPrice);

		return union;
	}

}
