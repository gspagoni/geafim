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

import org.spago.gsi.geafimrest.model.BuildingType;
import org.spago.gsi.geafimrest.service.BuildingTypeService;

@Path("/buildingtype")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	

public class BuildingTypeResource {
	
	BuildingTypeService buildTypeService = new BuildingTypeService();
	
	
	@GET
	public List<BuildingType> getBuildingType()
	{
		return buildTypeService.getAllBuildingType();
	}

	@GET
	@Path("/{buildId}")
	public BuildingType getBuildingTypeById(@PathParam("buildId") int id)
	{		
		return buildTypeService.getBuildingTypeById(id);
	}
	
	@POST
	public Response addBuildingType(BuildingType buildType, @Context UriInfo uriInfo)
	{
		BuildingType newbuildType = buildTypeService.addBuildingType(buildType);
		String newId = String.valueOf(newbuildType.getID());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
						.entity(newbuildType)
						.build();
	}
	
	@PUT
	@Path("/{buildId}")
	public BuildingType updateBuildingType(@PathParam("buildId") int id, BuildingType buildType)
	{
		buildType.setID(id);
		return buildTypeService.updateBuildingType(buildType);
	}
	
	@DELETE
	@Path("/{buildId}")
	public void deleteBuildingType(@PathParam("buildId") int id)
	{
		buildTypeService.deleteBuildingTypeById(id);		
	}
	
	
}
