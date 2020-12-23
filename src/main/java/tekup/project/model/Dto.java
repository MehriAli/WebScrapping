package tekup.project.model;

import lombok.Data;

@Data
public class Dto {
	
	private Long id;
	private String lien;
	private String image;
	private String marque;
	private String breifDescription;
	private Integer prix;
	private String dispo;
	private String site;
	
	public Dto() {
		super();
	}

	
	public Dto(Long id, String lien, String image, String marque, String breifDescription, Integer prix, String dispo, String site) {
		super();
		this.id = id;
		this.lien = lien;
		this.image = image;
		this.marque = marque;
		this.breifDescription = breifDescription;
		this.prix = prix;
		this.dispo = dispo;
		this.site = site;
	}
	

}

