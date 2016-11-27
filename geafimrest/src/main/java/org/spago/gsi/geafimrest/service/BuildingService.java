package org.spago.gsi.geafimrest.service;
import java.util.ArrayList;
import java.util.List;

import org.spago.gsi.geafimrest.model.Building;
import org.spago.gsi.geafimrest.utility.*;

import java.sql.*;

public class BuildingService {
	public Connection conn = null;
	public CallableStatement cs = null;
	public ResultSet rs = null;

	public List<Building> getAllBuilding()
	{
		// declare the return list of Building
		List<Building> list = new ArrayList<Building>();
		// This is the SP to be called
		String query = "{ call readAllBuilding}";	
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
				Building building = new Building();
				
				building.setID(rs.getInt(1));
				building.setStreet(rs.getNString(2));
				building.setStreetNumber(rs.getNString(3));
				building.setZipCode(rs.getNString(4));
				building.setCity(rs.getNString(5));
				building.setCountry(rs.getNString(6));
				building.setState(rs.getNString(7));
				building.setSheet(rs.getNString(8));
				building.setParticle(rs.getNString(9));
				building.setSubaltern(rs.getNString(10));
				building.setCategoryZone(rs.getNString(11));
				building.setClasse(rs.getInt(12));
				building.setConsistency(rs.getNString(13));
				building.setSurface(rs.getNString(14));
				building.setCadastralIncome(rs.getBigDecimal(15));
				building.setFK_buildingType(rs.getInt(16));
				building.setPlanimetry(rs.getNString(17));
				list.add(building);
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

		//return the list of Building
		return list;
		
	}
	
 	public Building getBuildingById(int id)
	{
		Building building = new Building();
		// This is the SP to be called
		String query = "{ call readBuildingById(?)}";	
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
				building.setID(rs.getInt(1));
				building.setStreet(rs.getNString(2));
				building.setStreetNumber(rs.getNString(3));
				building.setZipCode(rs.getNString(4));
				building.setCity(rs.getNString(5));
				building.setCountry(rs.getNString(6));
				building.setState(rs.getNString(7));
				building.setSheet(rs.getNString(8));
				building.setParticle(rs.getNString(9));
				building.setSubaltern(rs.getNString(10));
				building.setCategoryZone(rs.getNString(11));
				building.setClasse(rs.getInt(12));
				building.setConsistency(rs.getNString(13));
				building.setSurface(rs.getNString(14));
				building.setCadastralIncome(rs.getBigDecimal(15));
				building.setFK_buildingType(rs.getInt(16));
				building.setPlanimetry(rs.getNString(17));
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

		//return the Building
		return building;
				
	}
	
	public Building addBuilding(Building iBuilding)
	{
		Building building = new Building();
		// This is the SP to be called
		String query = "{ call createBuilding(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setString(1, iBuilding.getStreet());
			cs.setString(2, iBuilding.getStreetNumber());
			cs.setString(3, iBuilding.getZipCode());
			cs.setString(4, iBuilding.getCity());
			cs.setString(5, iBuilding.getCountry());
			cs.setString(6, iBuilding.getState());
			cs.setString(7, iBuilding.getSheet());
			cs.setString(8, iBuilding.getParticle());
			cs.setString(9, iBuilding.getSubaltern());
			cs.setString(10, iBuilding.getCategoryZone());
			cs.setInt(11,iBuilding.getClasse());
			cs.setString(12, iBuilding.getConsistency());
			cs.setString(13, iBuilding.getSurface());
			cs.setBigDecimal(14, iBuilding.getCadastralIncome());
			cs.setString(15, iBuilding.getPlanimetry());
			cs.setInt(16, iBuilding.getFK_buildingType());

			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{
				if(rs.getInt(1)>0)
				{
					building.setID(rs.getInt(1));
					building.setStreet(rs.getNString(2));
					building.setStreetNumber(rs.getNString(3));
					building.setZipCode(rs.getNString(4));
					building.setCity(rs.getNString(5));
					building.setCountry(rs.getNString(6));
					building.setState(rs.getNString(7));
					building.setSheet(rs.getNString(8));
					building.setParticle(rs.getNString(9));
					building.setSubaltern(rs.getNString(10));
					building.setCategoryZone(rs.getNString(11));
					building.setClasse(rs.getInt(12));
					building.setConsistency(rs.getNString(13));
					building.setSurface(rs.getNString(14));
					building.setCadastralIncome(rs.getBigDecimal(15));
					building.setFK_buildingType(rs.getInt(16));
					building.setPlanimetry(rs.getNString(17));
				}
				else
				{
					building.setID(rs.getInt(1));		
					building.setFK_buildingType(iBuilding.getFK_buildingType());
					building.setState(rs.getNString(2));					
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

		//return the created Building
		return building;								
	}

	public Building updateBuilding(Building iBuilding)
	{
		Building building = new Building();
		// This is the SP to be called
		String query = "{ call updateBuildingById(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	
		// Open a connection to DB
		if(conn == null)
			conn = JdbcSqlServerConnection.getConnection();
		
		try
		{
			// Prepare the call for SP
			cs = conn.prepareCall(query);
			cs.setInt(1, iBuilding.getID());
			cs.setString(2, iBuilding.getStreet());
			cs.setString(3, iBuilding.getStreetNumber());
			cs.setString(4, iBuilding.getZipCode());
			cs.setString(5, iBuilding.getCity());
			cs.setString(6, iBuilding.getCountry());
			cs.setString(7, iBuilding.getState());
			cs.setString(8, iBuilding.getSheet());
			cs.setString(9, iBuilding.getParticle());
			cs.setString(10, iBuilding.getSubaltern());
			cs.setString(11, iBuilding.getCategoryZone());
			cs.setInt(12,iBuilding.getClasse());
			cs.setString(13, iBuilding.getConsistency());
			cs.setString(14, iBuilding.getSurface());
			cs.setBigDecimal(15, iBuilding.getCadastralIncome());
			cs.setString(16, iBuilding.getPlanimetry());
			cs.setInt(17, iBuilding.getFK_buildingType());
			
			// make SP call
			rs = cs.executeQuery();
			//loop the recordset
			while(rs.next())
			{
				building.setID(rs.getInt(1));
				building.setStreet(rs.getNString(2));
				building.setStreetNumber(rs.getNString(3));
				building.setZipCode(rs.getNString(4));
				building.setCity(rs.getNString(5));
				building.setCountry(rs.getNString(6));
				building.setState(rs.getNString(7));
				building.setSheet(rs.getNString(8));
				building.setParticle(rs.getNString(9));
				building.setSubaltern(rs.getNString(10));
				building.setCategoryZone(rs.getNString(11));
				building.setClasse(rs.getInt(12));
				building.setConsistency(rs.getNString(13));
				building.setSurface(rs.getNString(14));
				building.setCadastralIncome(rs.getBigDecimal(15));
				building.setFK_buildingType(rs.getInt(16));
				building.setPlanimetry(rs.getNString(17));
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

		//return the Building
		return building;								
	}

	public void deleteBuildingById(int id)
	{
		// This is the SP to be called
		String query = "{ call deleteBuildingById(?)}";	
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
