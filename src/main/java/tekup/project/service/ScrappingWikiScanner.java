package tekup.project.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import tekup.project.model.Dto;
import tekup.project.model.contentDTO;

@Service
@AllArgsConstructor
public class ScrappingWikiScanner {

	

	
	private List<Dto> laptop;

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	

	public List<Dto> scrapelaptop() {
		String uri = "http://127.0.0.1:5000/wikiScanner";
		
		
		
		contentDTO a=webClientBuilder.build()
						.get()
						.uri(uri)
						.retrieve()
						.bodyToMono(contentDTO.class)
						.block();
		
		String inf = a.getContent();
		final String SEPARATEUR = ",";
		String mots[] = inf.split(SEPARATEUR);
		for (int i = 0, j = 1; j < 13; i++, j++) {
			String str = mots[i + 2];
			String words[] = str.split(" ");
			String marque = words[0] + " " + words[1] + " " + words[2] + " " + words[3];
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

			Long myId = (long) j;
			laptop.add(new Dto(myId, mots[i], mots[i + 1], marque, mots[i + 2], price, disponibil,"Wiki"));
			i = i + 4;
		}
		return laptop.subList(0, 12);
	}

	}