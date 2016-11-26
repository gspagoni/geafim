package org.spago.gsi.geafimrest.service;
import java.util.ArrayList;
import java.util.List;

import org.spago.gsi.geafimrest.model.Agency;
import org.spago.gsi.geafimrest.model.Agent;
import org.spago.gsi.geafimrest.model.Registry;
import org.spago.gsi.geafimrest.utility.*;

import java.sql.*;

public class AgentService {
	public Connection conn = null;
	public CallableStatement cs = null;
	public ResultSet rs = null;

	public List<Agent> getAllAgent()
	{
		// declare the return list of Agent
		List<Agent> list = new ArrayList<Agent>();
		// This is the SP to be called
		String query = "{ call readAllAgent}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{
				Agent agent = new Agent();
				Registry registry = new Registry();
				Agency agency = new Agency();
				
				agent.setIdAgent(rs.getInt(1));
				
				registry.setID(rs.getInt(2));
				registry.setTaxCode(rs.getNString(3));
				registry.setFirstName(rs.getNString(4));
				registry.setLastName(rs.getNString(5));
				registry.setDateOfBirth(rs.getDate(6));
				registry.setPlaceOfBirth(rs.getNString(7));
				registry.setCountry(rs.getNString(8));
				registry.setState(rs.getNString(9));
				registry.setSex(rs.getNString(10));
				registry.setTelephone(rs.getNString(11));
				registry.setMobile(rs.getNString(12));
				registry.setEmail(rs.getNString(13));
				registry.setFk_IdRegType(rs.getInt(14));				
				agent.setRegistry(registry);
				
				agency.setID(rs.getInt(15));
				agency.setAgencyName(rs.getNString(16));
				agency.setStreet(rs.getNString(17));
				agency.setStreetNumber(rs.getNString(18));
				agency.setZipCode(rs.getNString(19));
				agency.setCity(rs.getNString(20));
				agency.setCountry(rs.getNString(21));
				agency.setState(rs.getNString(22));
				agency.setTelephone(rs.getNString(23));
				agency.setMobile(rs.getNString(24));
				agency.setEmail(rs.getNString(25));				
				agent.setAgency(agency);
				
				list.add(agent);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		//close che db coonection
		if(conn!=null)
			try {
				JdbcSqlServerConnection.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		//return the list of Agent
		return list;
		
	}

	public Agent getAgentById(int id)
	{
		Agent agent = new Agent();
		Registry registry = new Registry();		
		Agency agency = new Agency();
		
		// This is the SP to be called
		String query = "{ call readAgentById(?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setInt(1, id);
			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{
				agent.setIdAgent(rs.getInt(1));
				
				registry.setID(rs.getInt(2));
				registry.setTaxCode(rs.getNString(3));
				registry.setFirstName(rs.getNString(4));
				registry.setLastName(rs.getNString(5));
				registry.setDateOfBirth(rs.getDate(6));
				registry.setPlaceOfBirth(rs.getNString(7));
				registry.setCountry(rs.getNString(8));
				registry.setState(rs.getNString(9));
				registry.setSex(rs.getNString(10));
				registry.setTelephone(rs.getNString(11));
				registry.setMobile(rs.getNString(12));
				registry.setEmail(rs.getNString(13));
				registry.setFk_IdRegType(rs.getInt(14));				
				agent.setRegistry(registry);
				
				agency.setID(rs.getInt(15));
				agency.setAgencyName(rs.getNString(16));
				agency.setStreet(rs.getNString(17));
				agency.setStreetNumber(rs.getNString(18));
				agency.setZipCode(rs.getNString(19));
				agency.setCity(rs.getNString(20));
				agency.setCountry(rs.getNString(21));
				agency.setState(rs.getNString(22));
				agency.setTelephone(rs.getNString(23));
				agency.setMobile(rs.getNString(24));
				agency.setEmail(rs.getNString(25));				
				agent.setAgency(agency);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		//close che db coonection
		if(conn!=null)
			try {
				JdbcSqlServerConnection.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		//return the list of Agent
		return agent;
		
		
	}
	
	public Agent addAgent(Agent iAgent)
	{
		// Store data read from DB
		Agent agent = new Agent();
		Registry registry = new Registry();		
		Agency agency = new Agency();
		
		int idResult;
		
		// This is the SP to be called
		String query = "{ call createAgent(?,?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setInt(1, iAgent.getIdAgency());
			cs.setInt(2, iAgent.getIdRegistry());
			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{

				idResult = rs.getInt(1);
				if(idResult==0)
				{
					agent.setIdAgent(rs.getInt(1));
					registry.setID(rs.getInt(2));
					agent.setRegistry(registry);
					agency.setID(rs.getInt(3));
					agent.setAgency(agency);
					agent.setRetValue(rs.getNString(4));				
				}
				else
				{
					agent.setIdAgent(rs.getInt(1));
					
					registry.setID(rs.getInt(2));
					registry.setTaxCode(rs.getNString(3));
					registry.setFirstName(rs.getNString(4));
					registry.setLastName(rs.getNString(5));
					registry.setDateOfBirth(rs.getDate(6));
					registry.setPlaceOfBirth(rs.getNString(7));
					registry.setCountry(rs.getNString(8));
					registry.setState(rs.getNString(9));
					registry.setSex(rs.getNString(10));
					registry.setTelephone(rs.getNString(11));
					registry.setMobile(rs.getNString(12));
					registry.setEmail(rs.getNString(13));
					registry.setFk_IdRegType(rs.getInt(14));				
					agent.setRegistry(registry);
					
					agency.setID(rs.getInt(15));
					agency.setAgencyName(rs.getNString(16));
					agency.setStreet(rs.getNString(17));
					agency.setStreetNumber(rs.getNString(18));
					agency.setZipCode(rs.getNString(19));
					agency.setCity(rs.getNString(20));
					agency.setCountry(rs.getNString(21));
					agency.setState(rs.getNString(22));
					agency.setTelephone(rs.getNString(23));
					agency.setMobile(rs.getNString(24));
					agency.setEmail(rs.getNString(25));				
					agent.setAgency(agency);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		//close che db coonection
		if(conn!=null)
			try {
				JdbcSqlServerConnection.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		//return the created Agent
		return agent;								
	}
	
	public Agent updateAgent(Agent iAgent)
	{
		Agent agent = new Agent();
		Agency agency = new Agency();
		Registry registry = new Registry();
		
		// This is the SP to be called
		String query = "{ call updateAgentById(?,?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setInt(1, iAgent.getIdAgent());
			cs.setInt(2, iAgent.getIdAgency());
			
			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{
					agent.setIdAgent(rs.getInt(1));
					
					registry.setID(rs.getInt(2));
					registry.setTaxCode(rs.getNString(3));
					registry.setFirstName(rs.getNString(4));
					registry.setLastName(rs.getNString(5));
					registry.setDateOfBirth(rs.getDate(6));
					registry.setPlaceOfBirth(rs.getNString(7));
					registry.setCountry(rs.getNString(8));
					registry.setState(rs.getNString(9));
					registry.setSex(rs.getNString(10));
					registry.setTelephone(rs.getNString(11));
					registry.setMobile(rs.getNString(12));
					registry.setEmail(rs.getNString(13));
					registry.setFk_IdRegType(rs.getInt(14));				
					agent.setRegistry(registry);
					
					agency.setID(rs.getInt(15));
					agency.setAgencyName(rs.getNString(16));
					agency.setStreet(rs.getNString(17));
					agency.setStreetNumber(rs.getNString(18));
					agency.setZipCode(rs.getNString(19));
					agency.setCity(rs.getNString(20));
					agency.setCountry(rs.getNString(21));
					agency.setState(rs.getNString(22));
					agency.setTelephone(rs.getNString(23));
					agency.setMobile(rs.getNString(24));
					agency.setEmail(rs.getNString(25));				
					agent.setAgency(agency);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		//close che db coonection
		if(conn!=null)
			try {
				JdbcSqlServerConnection.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		//return the list of Agent
		return agent;								
	}
	
	public void deleteAgentById(int id)
	{
		// This is the SP to be called
		String query = "{ call deleteAgentById(?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setInt(1, id);
			// make SP call
			rs = cs.executeQuery();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		//close che db coonection
		if(conn!=null)
			try {
				JdbcSqlServerConnection.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
	}
	
}
