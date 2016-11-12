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

import org.spago.gsi.geafimrest.model.RegistryType;
import org.spago.gsi.geafimrest.service.RegistryTypeService;

@Path("/basicauth/registrytype")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	

public class RegistryTypeResourceBasicAuth {

	RegistryTypeService regTypeService = new RegistryTypeService();
	
	
	@GET
	public List<RegistryType> getRegistryType()
	{
		return regTypeService.getAllRegistryType();
	}

	@GET
	@Path("/{regId}")
	public RegistryType getRegistryTypeById(@PathParam("regId") int id)
	{		
		return regTypeService.getRegistryTypeById(id);
	}
	
	@POST
	public Response addRegistryType(RegistryType regType, @Context UriInfo uriInfo)
	{
		RegistryType newRegType = regTypeService.addRegistryType(regType);
		String newId = String.valueOf(newRegType.getID());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
						.entity(newRegType)
						.build();
	}
	
	@PUT
	@Path("/{regId}")
	public RegistryType updateRegistryType(@PathParam("regId") int id, RegistryType regType)
	{
		regType.setID(id);
		return regTypeService.updateRegistryType(regType);
	}
	
	@DELETE
	@Path("/{regId}")
	public void deleteRegistryType(@PathParam("regId") int id)
	{
		regTypeService.deleteRegistryTypeById(id);		
	}
	
	
	
}
