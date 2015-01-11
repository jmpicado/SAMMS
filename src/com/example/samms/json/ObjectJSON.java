package com.example.samms.json;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;


public class ObjectJSON {

	public static void main( String [] args ) throws Exception  {
String url_tOracleConnection_1 = "jdbc:oracle:thin:@localhost:1521:XE";
		
		java.lang.Class.forName("oracle.jdbc.OracleDriver");
	
		Connection conexion = java.sql.DriverManager.getConnection(url_tOracleConnection_1,
					"samms",
					"jmpicado"
					);
		String sentenciaCache = 
				"select * from t_insider where ROWNUM <=10";

			PreparedStatement selectCache = conexion.prepareStatement(sentenciaCache);
			//Ejecutamos la query
			ResultSet resultadoCache = selectCache.executeQuery();
			//Recorremos todos los registros encontrados y los insertamos en T_INSIDER
			Integer contador=0;
			JSONArray list = new JSONArray();

			while (resultadoCache.next()) {
				String RECID = resultadoCache.getString("RECID");
				String INSIDERNIN = resultadoCache.getString("INSIDERNIN");
				String COMPANYNIN = resultadoCache.getString("COMPANYNIN");
				String INSIDERCLASSID = resultadoCache.getString("INSIDERCLASSID");
				String INSIDERCOMPANYNIN = resultadoCache.getString("INSIDERCOMPANYNIN");
				JSONObject obj=new JSONObject();
				  obj.put("RECID",RECID);
				  obj.put("INSIDERNIN",INSIDERNIN);
				  obj.put("COMPANYNIN",COMPANYNIN);
				  obj.put("INSIDERCLASSID",INSIDERCLASSID);
				  obj.put("INSIDERCOMPANYNIN",INSIDERCOMPANYNIN);
				  list.put(obj);
			}
			System.out.print("{\n\"employees\":\n");
			System.out.print(list+"\n");
			System.out.print("}");
			
		conexion.close();	
	}

}
