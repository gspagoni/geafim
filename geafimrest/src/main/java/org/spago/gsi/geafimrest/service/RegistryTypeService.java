package org.spago.gsi.geafimrest.service;

import java.util.ArrayList;
import java.util.List;

import org.spago.gsi.geafimrest.model.RegistryType;
import org.spago.gsi.geafimrest.utility.*;

import java.sql.*;

public class RegistryTypeService {
	public Connection conn = null;
	public CallableStatement cs = null;
	public ResultSet rs = null;
	
	public List<RegistryType> getAllRegistryType()
	{
		// declare the return list of registryType
		List<RegistryType> list = new ArrayList<RegistryType>();
		// This is the SP to be called
		String query = "{ call readAllRegistryType}";	
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
				RegistryType regType = new RegistryType();
				regType.setID(rs.getInt(1));
				regType.setDescription(rs.getNString(2));
				list.add(regType);
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

		//return the list of RegistryType
		return list;
		
	}
	
	public RegistryType getRegistryTypeById(int id)
	{
		RegistryType regType = new RegistryType();
		// This is the SP to be called
		String query = "{ call readRegistryTypeById(?)}";	
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
				regType.setID(rs.getInt(1));
				regType.setDescription(rs.getNString(2));
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

		//return the list of RegistryType
		return regType;
		
		
	}

	public RegistryType addRegistryType(RegistryType iRegType)
	{
		RegistryType regType = new RegistryType();
		// This is the SP to be called
		String query = "{ call createRegistryType(?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setString(1, iRegType.getDescription());;
			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{
				regType.setID(rs.getInt(1));
				regType.setDescription(rs.getNString(2));
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

		//return the list of RegistryType
		return regType;								
	}

	public RegistryType updateRegistryType(RegistryType iRegType)
	{
		RegistryType regType = new RegistryType();
		// This is the SP to be called
		String query = "{ call updateRegistryTypeById(?,?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setInt(1, iRegType.getID());
			cs.setString(2, iRegType.getDescription());;
			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{
				regType.setID(rs.getInt(1));
				regType.setDescription(rs.getNString(2));
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

		//return the list of RegistryType
		return regType;								
	}

	public void deleteRegistryTypeById(int id)
	{
		// This is the SP to be called
		String query = "{ call deleteRegistryTypeById(?)}";	
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
