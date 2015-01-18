

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;


public class ObjectJSON4 {

	public static void main( String [] args ) throws Exception  {
String url_tOracleConnection_1 = "jdbc:oracle:thin:@localhost:1521:XE";
		
		java.lang.Class.forName("oracle.jdbc.OracleDriver");
	
		Connection conexion = java.sql.DriverManager.getConnection(url_tOracleConnection_1,
					"samms",
					"jmpicado"
					);
		String sentenciaCache = 
				"select * from T_SISTNEGOCIACION";

			PreparedStatement selectCache = conexion.prepareStatement(sentenciaCache);
			//Ejecutamos la query
			ResultSet resultadoCache = selectCache.executeQuery();
			//Recorremos todos los registros encontrados y los insertamos en T_INSIDER
			Integer contador=0;
			JSONArray list = new JSONArray();

			while (resultadoCache.next()) {
				String CODSISTEMANEG = resultadoCache.getString("CODSISTEMANEG");
				String FECINICIO = resultadoCache.getString("FECINICIO");
				String INSTITUCION = resultadoCache.getString("INSTITUCION");
				String CONUNTRYCODE = resultadoCache.getString("CONUNTRYCODE");
				JSONObject obj=new JSONObject();
				  obj.put("CODSISTEMANEG",CODSISTEMANEG);
				  obj.put("FECINICIO",FECINICIO);
				  obj.put("INSTITUCION",INSTITUCION);
				  obj.put("CONUNTRYCODE",CONUNTRYCODE);
				  list.put(obj);
			}
			System.out.print("{\n\"sistemasnegociacion\":\n");
			System.out.print(list+"\n");
			System.out.print("}");
			
		conexion.close();	
	}

}
