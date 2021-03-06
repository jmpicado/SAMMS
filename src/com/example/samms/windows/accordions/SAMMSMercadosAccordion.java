package com.example.samms.windows.accordions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import com.vaadin.data.Item;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.Reindeer;

public class SAMMSMercadosAccordion extends SAMMSAccordion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public SAMMSMercadosAccordion() {
		super();
		// TODO Auto-generated constructor stub
		built();
		try {
			fillingTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void fillingTable() throws Exception {
		URL val = this.getClass().getResource("./data/mercados.json");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(val.getFile()), "UTF8"));
		String sCadena = "";String sJSON = "";
	    while ((sCadena = buffer.readLine())!=null) {
	    	sJSON = sJSON + sCadena; 
	    }
	    buffer.close();
	    
	    // Creating a JSONObject from a String 
	    JSONObject nodeRoot  = new JSONObject(sJSON); 
	    // Creating a sub-JSONObject from another JSONObject
	    JSONArray nodeArray = nodeRoot.getJSONArray("mercados");

//	    // Getting the value of a attribute in a JSONObject
//	    String sSDR = nodeStats.getString("sdr");
		//Values
		for (int i = 0; i< nodeArray.length(); i++){
			JSONObject obj = nodeArray.getJSONObject(i);
			table_Relaciones.addItem(new Object[]{obj.get("MERCADO"),obj.get("CODIGO_MERCADO")}, i+1);
		}		
		
		
	}

	private void built() {
		this.setImmediate(false);
		this.setWidth("660px");
		this.setHeight("140px");
		// label_IN
		// table_Relaciones
				table_Relaciones = new Table("");
				table_Relaciones.setSizeFull();
				table_Relaciones.addStyleName(Reindeer.TABLE_STRONG);
				table_Relaciones.setImmediate(true);
				// Define two columns for the built-in container
				table_Relaciones.addContainerProperty("MERCADO", String.class, null);
				table_Relaciones.addContainerProperty("CODIGO_MERCADO", String.class, null);
				
				// Allow selecting items from the table.
				table_Relaciones.setSelectable(true);
				
				this.addComponent(table_Relaciones/*,"top:40.0px;bottom:170.0px;left:380.0px;"*/);
				//this.addComponent(table_Relaciones);
		
	}

}
