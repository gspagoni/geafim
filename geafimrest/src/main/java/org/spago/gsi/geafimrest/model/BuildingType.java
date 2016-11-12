package org.spago.gsi.geafimrest.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BuildingType {
	
	private int ID;
	private String Description;

	public BuildingType()
	{}
	
	public BuildingType(int ID, String Description)
	{
		this.ID = ID;
		this.Description = Description;
		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	


}
