

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;


public class ObjectJSON6 {

	public static void main( String [] args ) throws Exception  {
String url_tOracleConnection_1 = "jdbc:oracle:thin:@localhost:1521:XE";
		
		java.lang.Class.forName("oracle.jdbc.OracleDriver");
	
		Connection conexion = java.sql.DriverManager.getConnection(url_tOracleConnection_1,
					"samms",
					"jmpicado"
					);
		String sentenciaCache = 
				"select * from T_INTERMEDIARYMARKET";

			PreparedStatement selectCache = conexion.prepareStatement(sentenciaCache);
			//Ejecutamos la query
			ResultSet resultadoCache = selectCache.executeQuery();
			//Recorremos todos los registros encontrados y los insertamos en T_INSIDER
			Integer contador=0;
			JSONArray list = new JSONArray();

			while (resultadoCache.next()) {
				String INTERMEDIARYID = resultadoCache.getString("INTERMEDIARYID");
				String MARKETID = resultadoCache.getString("MARKETID");
				String INTERMEDIARYNAME = resultadoCache.getString("INTERMEDIARYNAME");
				JSONObject obj=new JSONObject();
				  obj.put("INTERMEDIARYID",INTERMEDIARYID);
				  obj.put("MARKETID",MARKETID);
				  obj.put("INTERMEDIARYNAME",INTERMEDIARYNAME);
				  list.put(obj);
			}
			System.out.print("{\n\"intermediariosmercados\":\n");
			System.out.print(list+"\n");
			System.out.print("}");
			
		conexion.close();	
	}

}
