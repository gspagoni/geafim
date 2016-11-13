package org.spago.gsi.geafimrest.service;
import java.util.ArrayList;
import java.util.List;

import org.spago.gsi.geafimrest.model.Agency;
import org.spago.gsi.geafimrest.utility.*;

import java.sql.*;

public class AgencyService {
	public Connection conn = null;
	public CallableStatement cs = null;
	public ResultSet rs = null;

	public List<Agency> getAllAgency()
	{
		// declare the return list of buildingType
		List<Agency> list = new ArrayList<Agency>();
		// This is the SP to be called
		String query = "{ call readAllAgency}";	
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
				Agency agency = new Agency();
				agency.setID(rs.getInt(1));
				agency.setAgencyName(rs.getNString(2));
				agency.setStreet(rs.getNString(3));
				agency.setStreetNumber(rs.getNString(4));
				agency.setZipCode(rs.getNString(5));
				agency.setCity(rs.getNString(6));
				agency.setCountry(rs.getNString(7));
				agency.setState(rs.getNString(8));
				agency.setTelephone(rs.getNString(9));
				agency.setMobile(rs.getNString(10));
				agency.setEmail(rs.getNString(11));
				list.add(agency);
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

		//return the list of Agency
		return list;
		
	}

	public Agency getAgencyById(int id)
	{
		Agency agency = new Agency();
		// This is the SP to be called
		String query = "{ call readAgencyById(?)}";	
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
				agency.setID(rs.getInt(1));
				agency.setAgencyName(rs.getNString(2));
				agency.setStreet(rs.getNString(3));
				agency.setStreetNumber(rs.getNString(4));
				agency.setZipCode(rs.getNString(5));
				agency.setCity(rs.getNString(6));
				agency.setCountry(rs.getNString(7));
				agency.setState(rs.getNString(8));
				agency.setTelephone(rs.getNString(9));
				agency.setMobile(rs.getNString(10));
				agency.setEmail(rs.getNString(11));
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

		//return the list of Agency
		return agency;
		
		
	}

	public Agency addAgency(Agency iAgency)
	{
		Agency agency = new Agency();
		// This is the SP to be called
		String query = "{ call createAgency(?,?,?,?,?,?,?,?,?,?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setString(1, iAgency.getAgencyName());
			cs.setString(2, iAgency.getStreet());
			cs.setString(3, iAgency.getStreetNumber());
			cs.setString(4, iAgency.getZipCode());
			cs.setString(5, iAgency.getCity());
			cs.setString(6, iAgency.getCountry());
			cs.setString(7, iAgency.getState());
			cs.setString(8, iAgency.getTelephone());
			cs.setString(9, iAgency.getMobile());
			cs.setString(10,iAgency.getEmail());
			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{
				agency.setID(rs.getInt(1));
				agency.setAgencyName(rs.getNString(2));
				agency.setStreet(rs.getNString(3));
				agency.setStreetNumber(rs.getNString(4));
				agency.setZipCode(rs.getNString(5));
				agency.setCity(rs.getNString(6));
				agency.setCountry(rs.getNString(7));
				agency.setState(rs.getNString(8));
				agency.setTelephone(rs.getNString(9));
				agency.setMobile(rs.getNString(10));
				agency.setEmail(rs.getNString(11));
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

		//return the created Agency
		return agency;								
	}

	public Agency updateAgency(Agency iAgency)
	{
		Agency agency = new Agency();
		// This is the SP to be called
		String query = "{ call updateAgencyById(?,?,?,?,?,?,?,?,?,?,?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setInt(1, iAgency.getID());
			cs.setString(2, iAgency.getAgencyName());
			cs.setString(3, iAgency.getStreet());
			cs.setString(4, iAgency.getStreetNumber());
			cs.setString(5, iAgency.getZipCode());
			cs.setString(6, iAgency.getCity());
			cs.setString(7, iAgency.getCountry());
			cs.setString(8, iAgency.getState());
			cs.setString(9, iAgency.getTelephone());
			cs.setString(10, iAgency.getMobile());
			cs.setString(11,iAgency.getEmail());
			
			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{
				agency.setID(rs.getInt(1));
				agency.setAgencyName(rs.getNString(2));
				agency.setStreet(rs.getNString(3));
				agency.setStreetNumber(rs.getNString(4));
				agency.setZipCode(rs.getNString(5));
				agency.setCity(rs.getNString(6));
				agency.setCountry(rs.getNString(7));
				agency.setState(rs.getNString(8));
				agency.setTelephone(rs.getNString(9));
				agency.setMobile(rs.getNString(10));
				agency.setEmail(rs.getNString(11));
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

		//return the list of Agency
		return agency;								
	}

	public void deleteAgencyById(int id)
	{
		// This is the SP to be called
		String query = "{ call deleteAgencyById(?)}";	
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
