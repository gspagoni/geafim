package org.spago.gsi.geafimrest.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.spago.gsi.geafimrest.model.Agency;
import org.spago.gsi.geafimrest.service.AgencyService;

@Path("/agency")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	

public class AgencyResource {
	
	AgencyService agTypeService = new AgencyService();
	
	
	@GET
	public List<Agency> getAgency()
	{
		return agTypeService.getAllAgency();
	}

	@GET
	@Path("/{agId}")
	public Agency getAgencyById(@PathParam("agId") int id)
	{		
		return agTypeService.getAgencyById(id);
	}
	
	@POST
	public Response addAgency(Agency agType, @Context UriInfo uriInfo)
	{
		Agency newagType = agTypeService.addAgency(agType);
		String newId = String.valueOf(newagType.getID());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
						.entity(newagType)
						.build();
	}
	
	@PUT
	@Path("/{agId}")
	public Agency updateAgency(@PathParam("agId") int id, Agency agType)
	{
		agType.setID(id);
		return agTypeService.updateAgency(agType);
	}
	
	@DELETE
	@Path("/{agId}")
	public void deleteAgency(@PathParam("agId") int id)
	{
		agTypeService.deleteAgencyById(id);		
	}
	
	
}
