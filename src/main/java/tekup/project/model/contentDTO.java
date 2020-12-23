package tekup.project.model;

import lombok.Data;

@Data
public class contentDTO {

	private String content;
	private String id;
	
	
	
	
	public contentDTO() {
		super();
	}
	
	public contentDTO(String content, String id) {
		super();
		this.content = content;
		this.id = id;
	}





	
	
	
	
}

