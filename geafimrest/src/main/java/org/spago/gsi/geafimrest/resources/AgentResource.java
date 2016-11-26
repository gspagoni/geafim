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

import org.spago.gsi.geafimrest.model.Agent;
import org.spago.gsi.geafimrest.service.AgentService;

@Path("/agent")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	
	

public class AgentResource {
	AgentService agentService = new AgentService();
	
	
	@GET
	public List<Agent> getAgent()
	{
		return agentService.getAllAgent();
	}

	@GET
	@Path("/{agId}")
	public Agent getAgentById(@PathParam("agId") int id)
	{		
		return agentService.getAgentById(id);
	}
	
	@POST
	public Response addAgent(Agent agent, @Context UriInfo uriInfo)
	{
		Agent newAgent = agentService.addAgent(agent);
		String newId = String.valueOf(newAgent.getIdAgent());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
						.entity(newAgent)
						.build();
	}

	@PUT
	@Path("/{agId}")
	public Agent updateAgent(@PathParam("agId") int id, Agent agent)
	{
		agent.setIdAgent(id);
		return agentService.updateAgent(agent);
	}

	@DELETE
	@Path("/{agId}")
	public void deleteAgent(@PathParam("agId") int id)
	{
		agentService.deleteAgentById(id);		
	}
	
}
