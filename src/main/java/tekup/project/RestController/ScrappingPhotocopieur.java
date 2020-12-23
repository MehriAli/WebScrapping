package tekup.project.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tekup.project.model.Dto;

import tekup.project.service.ScrappingMytekPhotocopieur;
import tekup.project.service.ScrappingTNPhotocopieur;
import tekup.project.service.ScrappingWikiPhotocopieur;

@RestController
public class ScrappingPhotocopieur {

	
	@Autowired
	private ScrappingTNPhotocopieur serviceTN;
	@Autowired
	private ScrappingMytekPhotocopieur serviceMytek;
	@Autowired
	private ScrappingWikiPhotocopieur serviceWiki;
	
	
	@GetMapping("/Photocopieur")
	public List<Dto> getSortedList() {

		List<Dto> union = new ArrayList<Dto>();

		//List<Dto> x = new ArrayList<Dto>(serviceTN.scrapelaptop());
		List<Dto> y = new ArrayList<Dto>(serviceMytek.scrapelaptop());
		//List<Dto> z = new ArrayList<Dto>(serviceWiki.scrapelaptop());

		//union.addAll(x);
		union.addAll(y);
		//union.addAll(z);

		Comparator<Dto> compareByPrice = (Dto o1, Dto o2) -> o1.getPrix().compareTo(o2.getPrix());
		union.sort(compareByPrice);

		return union;
	}
}
