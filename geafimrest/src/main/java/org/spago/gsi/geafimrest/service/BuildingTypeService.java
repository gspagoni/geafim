package org.spago.gsi.geafimrest.service;
import java.util.ArrayList;
import java.util.List;

import org.spago.gsi.geafimrest.model.BuildingType;
import org.spago.gsi.geafimrest.utility.*;

import java.sql.*;

public class BuildingTypeService {
	public Connection conn = null;
	public CallableStatement cs = null;
	public ResultSet rs = null;

	public List<BuildingType> getAllBuildingType()
	{
		// declare the return list of buildingType
		List<BuildingType> list = new ArrayList<BuildingType>();
		// This is the SP to be called
		String query = "{ call readAllBuildingType}";	
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
				BuildingType buildType = new BuildingType();
				buildType.setID(rs.getInt(1));
				buildType.setDescription(rs.getNString(2));
				list.add(buildType);
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

		//return the list of BuildingType
		return list;
		
	}
	
	public BuildingType getBuildingTypeById(int id)
	{
		BuildingType buildType = new BuildingType();
		// This is the SP to be called
		String query = "{ call readBuildingTypeById(?)}";	
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
				buildType.setID(rs.getInt(1));
				buildType.setDescription(rs.getNString(2));
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

		//return the list of BuildingType
		return buildType;
		
		
	}

	public BuildingType addBuildingType(BuildingType iBuildType)
	{
		BuildingType buildType = new BuildingType();
		// This is the SP to be called
		String query = "{ call createBuildingType(?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setString(1, iBuildType.getDescription());;
			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{
				buildType.setID(rs.getInt(1));
				buildType.setDescription(rs.getNString(2));
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

		//return the created BuildingType
		return buildType;								
	}

	public BuildingType updateBuildingType(BuildingType iBuildType)
	{
		BuildingType buildType = new BuildingType();
		// This is the SP to be called
		String query = "{ call updateBuildingTypeById(?,?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setInt(1, iBuildType.getID());
			cs.setString(2, iBuildType.getDescription());;
			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{
				buildType.setID(rs.getInt(1));
				buildType.setDescription(rs.getNString(2));
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

		//return the list of BuildingType
		return buildType;								
	}

	public void deleteBuildingTypeById(int id)
	{
		// This is the SP to be called
		String query = "{ call deleteBuildingTypeById(?)}";	
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
