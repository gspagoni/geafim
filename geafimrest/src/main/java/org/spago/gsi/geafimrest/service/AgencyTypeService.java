package org.spago.gsi.geafimrest.service;
import java.util.ArrayList;
import java.util.List;

import org.spago.gsi.geafimrest.model.AgencyType;
import org.spago.gsi.geafimrest.utility.*;

import java.sql.*;

public class AgencyTypeService {
	public Connection conn = null;
	public CallableStatement cs = null;
	public ResultSet rs = null;

	public List<AgencyType> getAllAgencyType()
	{
		// declare the return list of buildingType
		List<AgencyType> list = new ArrayList<AgencyType>();
		// This is the SP to be called
		String query = "{ call readAllAgencyType}";	
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
				AgencyType agType = new AgencyType();
				agType.setID(rs.getInt(1));
				agType.setAgencyName(rs.getNString(2));
				agType.setStreet(rs.getNString(3));
				agType.setStreetNumber(rs.getNString(4));
				agType.setZipCode(rs.getNString(5));
				agType.setCity(rs.getNString(6));
				agType.setCountry(rs.getNString(7));
				agType.setState(rs.getNString(8));
				agType.setTelephone(rs.getNString(9));
				agType.setMobile(rs.getNString(10));
				agType.setEmail(rs.getNString(11));
				list.add(agType);
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

		//return the list of AgencyType
		return list;
		
	}

	public AgencyType getAgencyTypeById(int id)
	{
		AgencyType agType = new AgencyType();
		// This is the SP to be called
		String query = "{ call readAgencyTypeById(?)}";	
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
				agType.setID(rs.getInt(1));
				agType.setAgencyName(rs.getNString(2));
				agType.setStreet(rs.getNString(3));
				agType.setStreetNumber(rs.getNString(4));
				agType.setZipCode(rs.getNString(5));
				agType.setCity(rs.getNString(6));
				agType.setCountry(rs.getNString(7));
				agType.setState(rs.getNString(8));
				agType.setTelephone(rs.getNString(9));
				agType.setMobile(rs.getNString(10));
				agType.setEmail(rs.getNString(11));
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

		//return the list of AgencyType
		return agType;
		
		
	}

	public AgencyType addAgencyType(AgencyType iAgType)
	{
		AgencyType agType = new AgencyType();
		// This is the SP to be called
		String query = "{ call createAgencyType(?,?,?,?,?,?,?,?,?,?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setString(1, iAgType.getAgencyName());
			cs.setString(2, iAgType.getStreet());
			cs.setString(3, iAgType.getStreetNumber());
			cs.setString(4, iAgType.getZipCode());
			cs.setString(5, iAgType.getCity());
			cs.setString(6, iAgType.getCountry());
			cs.setString(7, iAgType.getState());
			cs.setString(8, iAgType.getTelephone());
			cs.setString(9, iAgType.getMobile());
			cs.setString(10,iAgType.getEmail());
			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{
				agType.setID(rs.getInt(1));
				agType.setAgencyName(rs.getNString(2));
				agType.setStreet(rs.getNString(3));
				agType.setStreetNumber(rs.getNString(4));
				agType.setZipCode(rs.getNString(5));
				agType.setCity(rs.getNString(6));
				agType.setCountry(rs.getNString(7));
				agType.setState(rs.getNString(8));
				agType.setTelephone(rs.getNString(9));
				agType.setMobile(rs.getNString(10));
				agType.setEmail(rs.getNString(11));
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

		//return the created AgencyType
		return agType;								
	}

	public AgencyType updateAgencyType(AgencyType iAgType)
	{
		AgencyType agType = new AgencyType();
		// This is the SP to be called
		String query = "{ call updateAgencyTypeById(?,?,?,?,?,?,?,?,?,?,?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setInt(1, iAgType.getID());
			cs.setString(2, iAgType.getAgencyName());
			cs.setString(3, iAgType.getStreet());
			cs.setString(4, iAgType.getStreetNumber());
			cs.setString(5, iAgType.getZipCode());
			cs.setString(6, iAgType.getCity());
			cs.setString(7, iAgType.getCountry());
			cs.setString(8, iAgType.getState());
			cs.setString(9, iAgType.getTelephone());
			cs.setString(10, iAgType.getMobile());
			cs.setString(11,iAgType.getEmail());
			
			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{
				agType.setID(rs.getInt(1));
				agType.setAgencyName(rs.getNString(2));
				agType.setStreet(rs.getNString(3));
				agType.setStreetNumber(rs.getNString(4));
				agType.setZipCode(rs.getNString(5));
				agType.setCity(rs.getNString(6));
				agType.setCountry(rs.getNString(7));
				agType.setState(rs.getNString(8));
				agType.setTelephone(rs.getNString(9));
				agType.setMobile(rs.getNString(10));
				agType.setEmail(rs.getNString(11));
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

		//return the list of AgencyType
		return agType;								
	}

	public void deleteAgencyTypeById(int id)
	{
		// This is the SP to be called
		String query = "{ call deleteAgencyTypeById(?)}";	
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
