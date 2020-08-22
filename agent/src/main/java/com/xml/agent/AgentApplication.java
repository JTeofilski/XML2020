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
	
	private static String dbOrigin = "jdbc:postgresql://localhost:5432/postgres";
    private static String dbDest = "jdbc:postgresql://localhost:5432/postgresAgent";
    private static String tableToMerge = "agent";
    private static String tableToMerge2 = "marka_vozila";
    private static String tableToMerge3 = "vrsta_goriva";
    
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(AgentApplication.class, args);
		
		 Connection dbConnOrigin = DriverManager.getConnection(dbOrigin, "postgres", "postgres");
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
	        
	        String sqlToExecute2 = "SELECT * FROM " + tableToMerge2;
	        ResultSet assets2 = dbOriginStat.executeQuery(sqlToExecute2);
	        ResultSetMetaData rsMeta2 = assets2.getMetaData();

	 while(assets2.next()){
	            String insertSQL  = "INSERT INTO " + tableToMerge2 + " VALUES(";

	            for(int i = 1; i <= rsMeta2.getColumnCount(); i++){
	                String value = assets2.getString(i);
	                if(assets2.wasNull()){
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
	 String sqlToExecute3 = "SELECT * FROM " + tableToMerge3;
     ResultSet assets3 = dbOriginStat.executeQuery(sqlToExecute3);
     ResultSetMetaData rsMeta3 = assets3.getMetaData();

while(assets3.next()){
         String insertSQL  = "INSERT INTO " + tableToMerge3 + " VALUES(";

         for(int i = 1; i <= rsMeta3.getColumnCount(); i++){
             String value = assets3.getString(i);
             if(assets3.wasNull()){
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
	        return;
	    }

}
