

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;


public class ObjectJSONIntermediariosIssuers {

	public static void main( String [] args ) throws Exception  {
String url_tOracleConnection_1 = "jdbc:oracle:thin:@localhost:1521:XE";
		
		java.lang.Class.forName("oracle.jdbc.OracleDriver");
	
		Connection conexion = java.sql.DriverManager.getConnection(url_tOracleConnection_1,
					"samms",
					"jmpicado"
					);
		String sentenciaCache = 
				"select * from t_intermediary where ROWNUM <=10000";

			PreparedStatement selectCache = conexion.prepareStatement(sentenciaCache);
			//Ejecutamos la query
			ResultSet resultadoCache = selectCache.executeQuery();
			//Recorremos todos los registros encontrados y los insertamos en T_INSIDER
			Integer contador=0;
			JSONArray list = new JSONArray();

			while (resultadoCache.next()) {
				String RECID = resultadoCache.getString("RECID");
				String INSIDERNIN = resultadoCache.getString("INTERMEDIARYID");
				String COMPANYNIN = resultadoCache.getString("PERSONNAME");
				String INSIDERCLASSID = resultadoCache.getString("NINTYPE");
				JSONObject obj=new JSONObject();
				  obj.put("RECID",RECID);
				  obj.put("INTERMEDIARYID",INSIDERNIN);
				  obj.put("PERSONNAME",COMPANYNIN);
				  obj.put("NINTYPE",INSIDERCLASSID);
				  list.put(obj);
			}
			System.out.print("{\n\"intermediarios\":\n");
			System.out.print(list+"\n");
			System.out.print("}");
			
			sentenciaCache = 
					"select * from t_issuer where ROWNUM <=10000";

				selectCache = conexion.prepareStatement(sentenciaCache);
				//Ejecutamos la query
				resultadoCache = selectCache.executeQuery();
				//Recorremos todos los registros encontrados y los insertamos en T_INSIDER
				contador=0;
				list = new JSONArray();

				while (resultadoCache.next()) {
					String RECID = resultadoCache.getString("RECID");
					String ISSUERID = resultadoCache.getString("ISSUERID");
					String ISSUERCLASSID = resultadoCache.getString("ISSUERCLASSID");
					String TAXCODE = resultadoCache.getString("TAXCODE");
					String PERSONNAME = resultadoCache.getString("PERSONNAME");
					JSONObject obj=new JSONObject();
					  obj.put("RECID",RECID);
					  obj.put("ISSUERID",ISSUERID);
					  obj.put("ISSUERCLASSID",ISSUERCLASSID);
					  obj.put("TAXCODE",TAXCODE);
					  obj.put("PERSONNAME",PERSONNAME);
					  list.put(obj);
				}
				System.out.print("{\n\"issuers\":\n");
				System.out.print(list+"\n");
				System.out.print("}");	
			
		conexion.close();	
	}

}
