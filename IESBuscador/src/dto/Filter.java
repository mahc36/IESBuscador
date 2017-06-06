package dto;

public class Filter {
	private boolean publ;
	private boolean priv;
	private String city;
	private boolean acred;
	private boolean noacred;

	public boolean isPubl() {
		return publ;
	}
	public void setPubl(boolean publ) {
		this.publ = publ;
	}
	public boolean isPriv() {
		return priv;
	}
	public void setPriv(boolean priv) {
		this.priv = priv;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isAcred() {
		return acred;
	}
	public void setAcred(boolean acred) {
		this.acred = acred;
	}
	public boolean isNoacred() {
		return noacred;
	}
	public void setNoacred(boolean noacred) {
		this.noacred = noacred;
	}
	
}
