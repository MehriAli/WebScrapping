package tekup.project.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tekup.project.model.Dto;

import tekup.project.service.ScrappingTNDesktop;
import tekup.project.service.ScrappingTNDisqExt;
import tekup.project.service.ScrappingTNDisqInt;


import tekup.project.service.ScrappingWikiLaptop;

@RestController
public class OneItem {
	
	
	
	@Autowired
	private ScrappingTNDisqExt serviceDisqueExt;
	@Autowired
	private ScrappingTNDisqInt serviceDisqueInt;
	@Autowired
	private ScrappingTNDesktop serviceDesktop;
	
	@Autowired
	private ScrappingWikiLaptop servicewikLaptop;
	
	
	
	
	
	@GetMapping("/test999")
	public List<Dto> getSortedList() {

		List<Dto> union = new ArrayList<Dto>();

		List<Dto> x = new ArrayList<Dto>(serviceDesktop.scrapelaptop());
		List<Dto> y = new ArrayList<Dto>(serviceDisqueExt.scrapelaptop());
		List<Dto> z = new ArrayList<Dto>(serviceDisqueInt.scrapelaptop());

		union.addAll(x);
		union.addAll(y);
		union.addAll(z);

		Comparator<Dto> compareByPrice = (Dto o1, Dto o2) -> o1.getPrix().compareTo(o2.getPrix());
		union.sort(compareByPrice);

		return union;
	}
	
	@GetMapping("/testii")
	public List<Dto> testig(){
		return servicewikLaptop.scrapelaptop();
	}
	
	
}
