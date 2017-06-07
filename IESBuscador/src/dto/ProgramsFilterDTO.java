package dto;

public class ProgramsFilterDTO {
	private String programName;
	private String academicLevel;
	private String modality;
	private int credit;
	private int creditCost;
	private String knowledgeArea;
	private String campusName;
	private String campusCity;
	private String campusLocation;
	private String iesName;
	private String iesEscudo;
	private String iesCaracter;
	private boolean iesAccreditation;
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getAcademicLevel() {
		return academicLevel;
	}
	public void setAcademicLevel(String academicLevel) {
		this.academicLevel = academicLevel;
	}
	public String getModality() {
		return modality;
	}
	public void setModality(String modality) {
		this.modality = modality;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getCreditCost() {
		return creditCost;
	}
	public void setCreditCost(int creditCost) {
		this.creditCost = creditCost;
	}
	public String getKnowledgeArea() {
		return knowledgeArea;
	}
	public void setKnowledgeArea(String knowledgeArea) {
		this.knowledgeArea = knowledgeArea;
	}
	public String getCampusName() {
		return campusName;
	}
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
	public String getCampusCity() {
		return campusCity;
	}
	public void setCampusCity(String campusCity) {
		this.campusCity = campusCity;
	}
	public String getCampusLocation() {
		return campusLocation;
	}
	public void setCampusLocation(String campusLocation) {
		this.campusLocation = campusLocation;
	}
	public String getIesName() {
		return iesName;
	}
	public void setIesName(String iesName) {
		this.iesName = iesName;
	}
	public String getIesEscudo() {
		return iesEscudo;
	}
	public void setIesEscudo(String iesEscudo) {
		this.iesEscudo = iesEscudo;
	}
	public String getIesCaracter() {
		return iesCaracter;
	}
	public void setIesCaracter(String iesCaracter) {
		this.iesCaracter = iesCaracter;
	}
	public boolean isIesAccreditation() {
		return iesAccreditation;
	}
	public void setIesAccreditation(boolean iesAccreditation) {
		this.iesAccreditation = iesAccreditation;
	}
}
