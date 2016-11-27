package org.spago.gsi.geafimrest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Building {

	private int ID;
	private String street;
	private String streetNumber;
	private String zipCode;
	private String city;
	private String country;
	private String state;
	private String sheet;
	private String particle;
	private String subaltern;
	private String categoryZone;
	private int classe;
	private String consistency;
	private String surface;
	private BigDecimal cadastralIncome;
	private String planimetry;
	private int FK_buildingType;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSheet() {
		return sheet;
	}
	public void setSheet(String sheet) {
		this.sheet = sheet;
	}
	public String getParticle() {
		return particle;
	}
	public void setParticle(String particle) {
		this.particle = particle;
	}
	public String getSubaltern() {
		return subaltern;
	}
	public void setSubaltern(String subaltern) {
		this.subaltern = subaltern;
	}
	public String getCategoryZone() {
		return categoryZone;
	}
	public void setCategoryZone(String categoryZone) {
		this.categoryZone = categoryZone;
	}
	public int getClasse() {
		return classe;
	}
	public void setClasse(int classe) {
		this.classe = classe;
	}
	public String getConsistency() {
		return consistency;
	}
	public void setConsistency(String consistency) {
		this.consistency = consistency;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	public BigDecimal getCadastralIncome() {
		return cadastralIncome;
	}
	public void setCadastralIncome(BigDecimal cadastralIncome) {
		this.cadastralIncome = cadastralIncome;
	}
	public String getPlanimetry() {
		return planimetry;
	}
	public void setPlanimetry(String planimetry) {
		this.planimetry = planimetry;
	}
	public int getFK_buildingType() {
		return FK_buildingType;
	}
	public void setFK_buildingType(int fK_buildingType) {
		FK_buildingType = fK_buildingType;
	}
	
	

}
