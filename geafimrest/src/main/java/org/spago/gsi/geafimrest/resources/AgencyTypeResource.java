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

import org.spago.gsi.geafimrest.model.AgencyType;
import org.spago.gsi.geafimrest.service.AgencyTypeService;

@Path("/agencytype")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	

public class AgencyTypeResource {
	
	AgencyTypeService agTypeService = new AgencyTypeService();
	
	
	@GET
	public List<AgencyType> getAgencyType()
	{
		return agTypeService.getAllAgencyType();
	}

	@GET
	@Path("/{agId}")
	public AgencyType getAgencyTypeById(@PathParam("agId") int id)
	{		
		return agTypeService.getAgencyTypeById(id);
	}
	
	@POST
	public Response addAgencyType(AgencyType agType, @Context UriInfo uriInfo)
	{
		AgencyType newagType = agTypeService.addAgencyType(agType);
		String newId = String.valueOf(newagType.getID());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
						.entity(newagType)
						.build();
	}
	
	@PUT
	@Path("/{agId}")
	public AgencyType updateAgencyType(@PathParam("agId") int id, AgencyType agType)
	{
		agType.setID(id);
		return agTypeService.updateAgencyType(agType);
	}
	
	@DELETE
	@Path("/{agId}")
	public void deleteAgencyType(@PathParam("agId") int id)
	{
		agTypeService.deleteAgencyTypeById(id);		
	}
	
	
}
