

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;


public class ObjectJSONOrdersBook {

	public static void main( String [] args ) throws Exception  {
String url_tOracleConnection_1 = "jdbc:oracle:thin:@localhost:1521:XE";
		
		java.lang.Class.forName("oracle.jdbc.OracleDriver");
	
		Connection conexion = java.sql.DriverManager.getConnection(url_tOracleConnection_1,
					"samms",
					"jmpicado"
					);
		String sentenciaCache = 
				"select * from T_ORDERBOOK  where INSTRUMENTID = 'ES0682045929'";

			PreparedStatement selectCache = conexion.prepareStatement(sentenciaCache);
			//Ejecutamos la query
			ResultSet resultadoCache = selectCache.executeQuery();
			//Recorremos todos los registros encontrados y los insertamos en T_INSIDER
			Integer contador=0;
			JSONArray list = new JSONArray();

			while (resultadoCache.next()) {
				String INSTRUMENTID = resultadoCache.getString("INSTRUMENTID");
				String MARKETID = resultadoCache.getString("MARKETID");
				String PRICE = resultadoCache.getString("PRICE");
				String QTY = resultadoCache.getString("QTY");
				String INTERMEDIARYID = resultadoCache.getString("INTERMEDIARYID");
				String SIDE = resultadoCache.getString("SIDE");
				JSONObject obj=new JSONObject();
				  obj.put("INSTRUMENTID",INSTRUMENTID);
				  obj.put("MARKETID",MARKETID);
				  obj.put("PRICE",PRICE);
				  obj.put("QTY",QTY);
				  obj.put("INTERMEDIARYID",INTERMEDIARYID);
				  obj.put("SIDE",SIDE);
				  list.put(obj);
			}
			System.out.print("{\n\"libro_ordenes\":\n");
			System.out.print(list+"\n");
			System.out.print("}");
			
		conexion.close();	
	}

}
