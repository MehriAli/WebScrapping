package tekup.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dto {
	
	private Long id;
	private String lien;
	private String image;
	private String marque;
	private String breifDescription;
	private String prix;
	private String dispo;
}
