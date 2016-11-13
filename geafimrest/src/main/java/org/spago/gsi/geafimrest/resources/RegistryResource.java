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

import org.spago.gsi.geafimrest.model.Registry;
import org.spago.gsi.geafimrest.service.RegistryService;

@Path("/registry")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	

public class RegistryResource {

	RegistryService registryService = new RegistryService();
	
	
	@GET
	public List<Registry> getRegistry()
	{
		return registryService.getAllRegistry();
	}

	@GET
	@Path("/{regId}")
	public Registry getRegistryById(@PathParam("regId") int id)
	{		
		return registryService.getRegistryById(id);
	}
	
	@POST
	public Response addRegistry(Registry registry, @Context UriInfo uriInfo)
	{
		Registry newregistry = registryService.addRegistry(registry);
		String newId = String.valueOf(newregistry.getID());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
						.entity(newregistry)
						.build();
	}
	
	@PUT
	@Path("/{regId}")
	public Registry updateRegistry(@PathParam("regId") int id, Registry registry)
	{
		registry.setID(id);
		return registryService.updateRegistry(registry);
	}
	
	@DELETE
	@Path("/{regId}")
	public void deleteRegistry(@PathParam("regId") int id)
	{
		registryService.deleteRegistryById(id);		
	}
	
}
