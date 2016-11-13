package org.spago.gsi.geafimrest.service;
import java.util.ArrayList;
import java.util.List;

import org.spago.gsi.geafimrest.model.Registry;
import org.spago.gsi.geafimrest.utility.*;

import java.sql.*;

public class RegistryService {
	public Connection conn = null;
	public CallableStatement cs = null;
	public ResultSet rs = null;

	public List<Registry> getAllRegistry()
	{
		// declare the return list of Registry
		List<Registry> list = new ArrayList<Registry>();
		// This is the SP to be called
		String query = "{ call readAllRegistry}";	
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
				Registry registry = new Registry();
				
				registry.setID(rs.getInt(1));
				registry.setTaxCode(rs.getNString(2));
				registry.setFirstName(rs.getNString(3));
				registry.setLastName(rs.getNString(4));
				registry.setDateOfBirth(rs.getDate(5));
				registry.setPlaceOfBirth(rs.getNString(6));
				registry.setCountry(rs.getNString(7));
				registry.setState(rs.getNString(8));
				registry.setSex(rs.getNString(9));
				registry.setTelephone(rs.getNString(10));
				registry.setMobile(rs.getNString(11));
				registry.setEmail(rs.getNString(12));
				registry.setFk_IdRegType(rs.getInt(13));
				list.add(registry);
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

		//return the list of Registry
		return list;
		
	}
	
	public Registry getRegistryById(int id)
	{
		Registry registry = new Registry();
		// This is the SP to be called
		String query = "{ call readRegistryById(?)}";	
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
				registry.setID(rs.getInt(1));
				registry.setTaxCode(rs.getNString(2));
				registry.setFirstName(rs.getNString(3));
				registry.setLastName(rs.getNString(4));
				registry.setDateOfBirth(rs.getDate(5));
				registry.setPlaceOfBirth(rs.getNString(6));
				registry.setCountry(rs.getNString(7));
				registry.setState(rs.getNString(8));
				registry.setSex(rs.getNString(9));
				registry.setTelephone(rs.getNString(10));
				registry.setMobile(rs.getNString(11));
				registry.setEmail(rs.getNString(12));
				registry.setFk_IdRegType(rs.getInt(13));
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

		//return the Registry
		return registry;
		
		
	}

	public Registry addRegistry(Registry iRegistry)
	{
		Registry registry = new Registry();
		// This is the SP to be called
		String query = "{ call createRegistry(?,?,?,?,?,?,?,?,?,?,?,?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setString(1, iRegistry.getTaxCode());
			cs.setString(2, iRegistry.getFirstName());
			cs.setString(3, iRegistry.getLastName());
			cs.setDate(4,   iRegistry.getDateOfBirth());
			cs.setString(5, iRegistry.getPlaceOfBirth());
			cs.setString(6, iRegistry.getCountry());
			cs.setString(7, iRegistry.getState());
			cs.setString(8, iRegistry.getSex());
			cs.setString(9, iRegistry.getTelephone());
			cs.setString(10, iRegistry.getMobile());
			cs.setString(11,iRegistry.getEmail());
			cs.setInt(12, iRegistry.getFk_IdRegType());
			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{
				registry.setID(rs.getInt(1));
				registry.setTaxCode(rs.getNString(2));
				registry.setFirstName(rs.getNString(3));
				registry.setLastName(rs.getNString(4));
				registry.setDateOfBirth(rs.getDate(5));
				registry.setPlaceOfBirth(rs.getNString(6));
				registry.setCountry(rs.getNString(7));
				registry.setState(rs.getNString(8));
				registry.setSex(rs.getNString(9));
				registry.setTelephone(rs.getNString(10));
				registry.setMobile(rs.getNString(11));
				registry.setEmail(rs.getNString(12));
				registry.setFk_IdRegType(rs.getInt(13));
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

		//return the created Registry
		return registry;								
	}

	public Registry updateRegistry(Registry iRegistry)
	{
		Registry registry = new Registry();
		// This is the SP to be called
		String query = "{ call updateRegistryById(?,?,?,?,?,?,?,?,?,?,?,?,?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setInt(1, iRegistry.getID());
			cs.setString(2, iRegistry.getTaxCode());
			cs.setString(3, iRegistry.getFirstName());
			cs.setString(4, iRegistry.getLastName());
			cs.setDate(5,   iRegistry.getDateOfBirth());
			cs.setString(6, iRegistry.getPlaceOfBirth());
			cs.setString(7, iRegistry.getCountry());
			cs.setString(8, iRegistry.getState());
			cs.setString(9, iRegistry.getSex());
			cs.setString(10, iRegistry.getTelephone());
			cs.setString(11, iRegistry.getMobile());
			cs.setString(12,iRegistry.getEmail());
			cs.setInt(13, iRegistry.getFk_IdRegType());
			
			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{
				registry.setID(rs.getInt(1));
				registry.setTaxCode(rs.getNString(2));
				registry.setFirstName(rs.getNString(3));
				registry.setLastName(rs.getNString(4));
				registry.setDateOfBirth(rs.getDate(5));
				registry.setPlaceOfBirth(rs.getNString(6));
				registry.setCountry(rs.getNString(7));
				registry.setState(rs.getNString(8));
				registry.setSex(rs.getNString(9));
				registry.setTelephone(rs.getNString(10));
				registry.setMobile(rs.getNString(11));
				registry.setEmail(rs.getNString(12));
				registry.setFk_IdRegType(rs.getInt(13));				
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

		//return the Registry
		return registry;								
	}

	public void deleteRegistryById(int id)
	{
		// This is the SP to be called
		String query = "{ call deleteRegistryById(?)}";	
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
