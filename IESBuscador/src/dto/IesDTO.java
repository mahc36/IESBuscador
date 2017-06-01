package dto;

public class IesDTO {
	private int id;
	private String name;
	private String slogan;
	private String escudo;
	private String caracter;
	private boolean accreditation;
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
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public String getEscudo() {
		return escudo;
	}
	public void setEscudo(String escudo) {
		this.escudo = escudo;
	}
	public String getCaracter() {
		return caracter;
	}
	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}
	public boolean isAccreditation() {
		return accreditation;
	}
	public void setAccreditation(boolean accreditation) {
		this.accreditation = accreditation;
	}
}
