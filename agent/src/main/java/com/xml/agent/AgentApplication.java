package com.xml.agent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AgentApplication {
	
	private static String dbOrigin = "jdbc:postgresql://localhost:5432/postgres";
    private static String dbDest = "jdbc:postgresql://localhost:5432/postgresAgent";
    private static String tableToMerge = "agent";
    private static String tableToMerge2 = "marka_vozila";
    private static String tableToMerge3 = "vrsta_goriva";
    private static String tableToMerge4 = "tip_menjaca";
    private static String tableToMerge5 = "model_vozila";
    private static String tableToMerge6 = "klasa_automobila";
    private static String tableToMerge7 = "cenovnik";
    private static String tableToMerge8 = "poruka";
    private static String tableToMerge9 = "zahtev_za_iznajmljivanje";
    
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
String sqlToExecute4 = "SELECT * FROM " + tableToMerge4;
ResultSet assets4 = dbOriginStat.executeQuery(sqlToExecute4);
ResultSetMetaData rsMeta4 = assets4.getMetaData();

while(assets4.next()){
    String insertSQL  = "INSERT INTO " + tableToMerge4 + " VALUES(";

    for(int i = 1; i <= rsMeta4.getColumnCount(); i++){
        String value = assets4.getString(i);
        if(assets4.wasNull()){
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
String sqlToExecute5 = "SELECT * FROM " + tableToMerge5;
ResultSet assets5 = dbOriginStat.executeQuery(sqlToExecute5);
ResultSetMetaData rsMeta5 = assets5.getMetaData();

while(assets5.next()){
    String insertSQL  = "INSERT INTO " + tableToMerge5 + " VALUES(";

    for(int i = 1; i <= rsMeta5.getColumnCount(); i++){
        String value = assets5.getString(i);
        if(assets5.wasNull()){
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
String sqlToExecute6 = "SELECT * FROM " + tableToMerge6;
ResultSet assets6 = dbOriginStat.executeQuery(sqlToExecute6);
ResultSetMetaData rsMeta6 = assets6.getMetaData();

while(assets6.next()){
    String insertSQL  = "INSERT INTO " + tableToMerge6 + " VALUES(";

    for(int i = 1; i <= rsMeta6.getColumnCount(); i++){
        String value = assets6.getString(i);
        if(assets6.wasNull()){
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
String sqlToExecute7 = "SELECT * FROM " + tableToMerge7;
ResultSet assets7 = dbOriginStat.executeQuery(sqlToExecute7);
ResultSetMetaData rsMeta7 = assets7.getMetaData();

while(assets7.next()){
    String insertSQL  = "INSERT INTO " + tableToMerge7 + " VALUES(";

    for(int i = 1; i <= rsMeta7.getColumnCount(); i++){
        String value = assets7.getString(i);
        if(assets7.wasNull()){
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
String sqlToExecute8 = "SELECT * FROM " + tableToMerge8;
ResultSet assets8 = dbOriginStat.executeQuery(sqlToExecute8);
ResultSetMetaData rsMeta8 = assets8.getMetaData();

while(assets8.next()){
    String insertSQL  = "INSERT INTO " + tableToMerge8 + " VALUES(";

    for(int i = 1; i <= rsMeta8.getColumnCount(); i++){
        String value = assets8.getString(i);
        if(assets8.wasNull()){
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
String sqlToExecute9 = "SELECT * FROM " + tableToMerge9;
ResultSet assets9 = dbOriginStat.executeQuery(sqlToExecute9);
ResultSetMetaData rsMeta9 = assets9.getMetaData();

while(assets9.next()){
    String insertSQL  = "INSERT INTO " + tableToMerge9 + " VALUES(";

    for(int i = 1; i <= rsMeta9.getColumnCount(); i++){
        String value = assets9.getString(i);
        if(assets9.wasNull()){
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
