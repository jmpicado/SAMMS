

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;


public class ObjectJSONInstrument {

	public static void main( String [] args ) throws Exception  {
String url_tOracleConnection_1 = "jdbc:oracle:thin:@localhost:1521:XE";
		
		java.lang.Class.forName("oracle.jdbc.OracleDriver");
	
		Connection conexion = java.sql.DriverManager.getConnection(url_tOracleConnection_1,
					"samms",
					"jmpicado"
					);
		String sentenciaCache = null;PreparedStatement selectCache=null;ResultSet resultadoCache =null;JSONArray list=null;Integer contador=null;
		sentenciaCache = 
				"select * from T_INSTRUMENT";

//			selectCache = conexion.prepareStatement(sentenciaCache);
//			//Ejecutamos la query
//			resultadoCache = selectCache.executeQuery();
//			//Recorremos todos los registros encontrados y los insertamos en T_INSIDER
//			Integer contador=0;
//			list = new JSONArray();
//
//			while (resultadoCache.next()) {
//				String INSTRUMENTID = resultadoCache.getString("INSTRUMENTID");
//				String INSTRUMENTCLASSID = resultadoCache.getString("INSTRUMENTCLASSID");
//				String SHORTDESCRIPTION = resultadoCache.getString("SHORTDESCRIPTION");
//				String ISSUERID = resultadoCache.getString("ISSUERID");
//				String STOCKOWNERRIGHTS = resultadoCache.getString("STOCKOWNERRIGHTS");
//				String INSTRUMENTNOTES = resultadoCache.getString("INSTRUMENTNOTES");
//
//				JSONObject obj=new JSONObject();
//				  obj.put("INSTRUMENTID",INSTRUMENTID);
//				  obj.put("INSTRUMENTCLASSID",INSTRUMENTCLASSID);
//				  obj.put("SHORTDESCRIPTION",SHORTDESCRIPTION);
//				  obj.put("ISSUERID",ISSUERID);
//				  obj.put("STOCKOWNERRIGHTS",STOCKOWNERRIGHTS);
//				  obj.put("INSTRUMENTNOTES",INSTRUMENTNOTES);
//				  list.put(obj);
//			}
//			System.out.print("{\n\"instrumentos\":\n");
//			System.out.print(list+"\n");
//			System.out.print("}");
			
		sentenciaCache = 
					"select * from T_TRADABLEINSTRUMENT";

			selectCache = conexion.prepareStatement(sentenciaCache);
			//Ejecutamos la query
			resultadoCache = selectCache.executeQuery();
			//Recorremos todos los registros encontrados y los insertamos en T_INSIDER
			contador=0;
			list = new JSONArray();

			while (resultadoCache.next()) {
				String INSTRUMENTID = resultadoCache.getString("INSTRUMENTID");
				String MARKETID = resultadoCache.getString("MARKETID");
				String SYMBOL = resultadoCache.getString("SYMBOL");

				JSONObject obj=new JSONObject();
				  obj.put("INSTRUMENTID",INSTRUMENTID);
				  obj.put("MARKETID",MARKETID);
				  obj.put("SYMBOL",SYMBOL);
				  list.put(obj);
			}
		System.out.print("{\n\"tradables\":\n");
		System.out.print(list+"\n");
		System.out.print("}");	
			
		conexion.close();	
	}

}
