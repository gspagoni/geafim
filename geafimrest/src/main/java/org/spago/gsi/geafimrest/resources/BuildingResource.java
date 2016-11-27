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

import org.spago.gsi.geafimrest.model.Building;
import org.spago.gsi.geafimrest.service.BuildingService;

@Path("/building")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	

public class BuildingResource {

	BuildingService buildingService = new BuildingService();
	
	
	@GET
	public List<Building> getBuilding()
	{
		return buildingService.getAllBuilding();
	}
	
	@GET
	@Path("/{builId}")
	public Building getBuildingById(@PathParam("builId") int id)
	{		
		return buildingService.getBuildingById(id);
	}
	
	@POST
	public Response addBuilding(Building building, @Context UriInfo uriInfo)
	{
		Building newBuilding = buildingService.addBuilding(building);
		String newId = String.valueOf(newBuilding.getID());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
						.entity(newBuilding)
						.build();
	}
	
	@PUT
	@Path("/{builId}")
	public Building updateBuilding(@PathParam("builId") int id, Building building)
	{
		building.setID(id);
		return buildingService.updateBuilding(building);
	}
	
	@DELETE
	@Path("/{builId}")
	public void deleteBuilding(@PathParam("builId") int id)
	{
		buildingService.deleteBuildingById(id);		
	}
	
}
