package org.spago.gsi.geafimrest.model;
import javax.xml.bind.annotation.XmlRootElement;

import org.spago.gsi.geafimrest.model.Registry;
import org.spago.gsi.geafimrest.model.Agency;;

@XmlRootElement
public class Agent {

	private int idAgent;
	private int idAgency;
	private int idRegistry;
	private Agency agency;
	private Registry registry;
	private String retValue;
	public int getIdAgent() {
		return idAgent;
	}
	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}
	public int getIdAgency() {
		return idAgency;
	}
	public void setIdAgency(int idAgency) {
		this.idAgency = idAgency;
	}
	public int getIdRegistry() {
		return idRegistry;
	}
	public void setIdRegistry(int idRegistry) {
		this.idRegistry = idRegistry;
	}
	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	public Registry getRegistry() {
		return registry;
	}
	public void setRegistry(Registry registry) {
		this.registry = registry;
	}
	public String getRetValue() {
		return retValue;
	}
	public void setRetValue(String retValue) {
		this.retValue = retValue;
	}

	
}
