

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;


public class ObjectJSONMarkets {

	public static void main( String [] args ) throws Exception  {
String url_tOracleConnection_1 = "jdbc:oracle:thin:@localhost:1521:XE";
		
		java.lang.Class.forName("oracle.jdbc.OracleDriver");
	
		Connection conexion = java.sql.DriverManager.getConnection(url_tOracleConnection_1,
					"samms",
					"jmpicado"
					);
		String sentenciaCache = 
				"select * from T_MARKETS_AUX";

			PreparedStatement selectCache = conexion.prepareStatement(sentenciaCache);
			//Ejecutamos la query
			ResultSet resultadoCache = selectCache.executeQuery();
			//Recorremos todos los registros encontrados y los insertamos en T_INSIDER
			Integer contador=0;
			JSONArray list = new JSONArray();

			while (resultadoCache.next()) {
				String CODIGO_MERCADO = resultadoCache.getString("CODIGO_MERCADO");
				String MARKETID = resultadoCache.getString("MARKETID");
				JSONObject obj=new JSONObject();
				  obj.put("CODIGO_MERCADO",CODIGO_MERCADO);
				  obj.put("MARKETID",MARKETID);
				  list.put(obj);
			}
			System.out.print("{\n\"markets\":\n");
			System.out.print(list+"\n");
			System.out.print("}");
			
			
			sentenciaCache = "select * from T_MERCADOS_CNMV";

			selectCache = conexion.prepareStatement(sentenciaCache);
			//Ejecutamos la query
			resultadoCache = selectCache.executeQuery();
			//Recorremos todos los registros encontrados y los insertamos en T_INSIDER
			contador=0;
			list = new JSONArray();

			while (resultadoCache.next()) {
				String CODIGO_MERCADO = resultadoCache.getString("CODIGO_MERCADO");
				String MERCADO = resultadoCache.getString("DESC_MERCADO");
				JSONObject obj=new JSONObject();
				  obj.put("CODIGO_MERCADO",CODIGO_MERCADO);
				  obj.put("MERCADO",MERCADO);
				  list.put(obj);
			}
			System.out.print("{\n\"mercados\":\n");
			System.out.print(list+"\n");
			System.out.print("}");	
				
				
		conexion.close();	
	}

}
