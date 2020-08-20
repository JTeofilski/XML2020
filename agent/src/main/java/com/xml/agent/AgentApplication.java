package com.xml.agent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgentApplication {
	
/*	private static String dbOrigin = "jdbc:postgresql://localhost:5432/postgres";
    private static String dbDest = "jdbc:postgresql://localhost:5432/postgresAgent";
    private static String tableToMerge = "agent";
*/
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(AgentApplication.class, args);
		
	/*	 Connection dbConnOrigin = DriverManager.getConnection(dbOrigin, "postgres", "postgres");
	        Statement dbOriginStat = dbConnOrigin.createStatement();

	        Connection dbConnDest = DriverManager.getConnection(dbDest, "postgres", "postgres");
	        Statement dbDestStat = dbConnDest.createStatement();

	        String sqlToExecute = "SELECT * FROM " + tableToMerge;
	        ResultSet assets = dbOriginStat.executeQuery(sqlToExecute);
	        ResultSetMetaData rsMeta = assets.getMetaData();

	 while(assets.next()){
	            String insertSQL  = "INSERT INTO " + tableToMerge + " VALUES(";

	            for(int i = 1; i <= rsMeta.getColumnCount(); i++){
	                String value = assets.getString(i);
	                if(assets.wasNull()){
	                    insertSQL += "NULL,";
	                }else{
	                    insertSQL += "'" + value + "',";
	                }               
	            }
	            insertSQL =insertSQL.substring(0, insertSQL.length()-1) + ")";

	            try{
	                dbDestStat.executeUpdate(insertSQL);
	            }catch(SQLException e){
	                //TODO: attempt to update the row in the event of duplicate key
	            }


	        }
	        return;*/
	    }

}
