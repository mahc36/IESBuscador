package dto;

public class ProgramDTO {
	private int id;
	private String name;
	private String academic_level;
	private String modality;
	private int credits;
	private int credit_cost;
	private String knowledge_area;
	private int id_campus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcademic_level() {
		return academic_level;
	}
	public void setAcademic_level(String academic_level) {
		this.academic_level = academic_level;
	}
	public String getModality() {
		return modality;
	}
	public void setModality(String modality) {
		this.modality = modality;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public int getCredit_cost() {
		return credit_cost;
	}
	public void setCredit_cost(int credit_cost) {
		this.credit_cost = credit_cost;
	}
	public String getKnowledge_area() {
		return knowledge_area;
	}
	public void setKnowledge_area(String knowledge_area) {
		this.knowledge_area = knowledge_area;
	}
	public int getId_campus() {
		return id_campus;
	}
	public void setId_campus(int id_campus) {
		this.id_campus = id_campus;
	}
}
