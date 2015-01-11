package com.example.samms.trees;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import com.vaadin.data.Item;
import com.vaadin.ui.Tree;

public class SAMMSTreePersonCODESNIN extends Tree {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SAMMSTreePersonCODESNIN(String caption) {
		super(caption);
		try {
			fillingTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}
	
	private void fillingTable() throws Exception {
		URL val = this.getClass().getResource("./data/codes.json");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(val.getFile()), "UTF8"));
		String sCadena = "";String sJSON = "";
	    while ((sCadena = buffer.readLine())!=null) {
	    	sJSON = sJSON + sCadena; 
	    }
	    buffer.close();
	    
	    // Creating a JSONObject from a String 
	    JSONObject nodeRoot  = new JSONObject(sJSON); 
	    // Creating a sub-JSONObject from another JSONObject
	    JSONArray nodeArray = nodeRoot.getJSONArray("codes");

//	    // Getting the value of a attribute in a JSONObject
	    this.addContainerProperty("CODE", String.class, null);
		//Values
		for (int i = 0; i< nodeArray.length(); i++){
			JSONObject obj = nodeArray.getJSONObject(i);
			String CODE = (String)obj.get("CODE");
			
			Item item = this.addItem(CODE);
			if (item!=null){
				item.getItemProperty("CODE").setValue(CODE);
				String PERSONNIN = (String) obj.get("PERSONNIN");String DESC =  (String) obj.get("DESCRIPTION");
				item = this.addItem(PERSONNIN+"-"+DESC);
				if (item!=null)
					item.getItemProperty("CODE").setValue(CODE);
				this.setParent(PERSONNIN+"-"+DESC, obj.get("CODE"));
			}
		}		
		
	}

	

}
