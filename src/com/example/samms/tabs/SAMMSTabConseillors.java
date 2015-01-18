package com.example.samms.tabs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.samms.SammsUI;
import com.example.samms.windows.WindowsInfo;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

public class SAMMSTabConseillors extends SAMMSTab {

	Table table_Relaciones ;
	
	TextField filter_1;	TextField filter_2;	TextField filter_3;	TextField filter_4;TextField filter_5;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public SAMMSTabConseillors(SammsUI sammsUI) {
		super(sammsUI);
//		this.setIcon(new ThemeResource("resources/clock.jpg"));
//		this.setCaption("Clock");
		
		try {
			buildMainLayout();
			fillingTable();
			events();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * 
	 */
	private void events() {
		table_Relaciones.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            private static final long serialVersionUID = 1L;

            public void itemClick(ItemClickEvent event) {
                if (event.isDoubleClick()) {
                     // The item was double-clicked, event.getItem() returns the target.
                	WindowsInfo sub = new WindowsInfo(event.getItem());
                	// Add it to the root component
                	UI.getCurrent().addWindow(sub);
                }
            }
        });
		
	}


	private void fillingTable() throws Exception {
		URL val = this.getClass().getResource("./data/consejeros.json");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(val.getFile()), "UTF8"));
		String sCadena = "";String sJSON = "";
	    while ((sCadena = buffer.readLine())!=null) {
	    	sJSON = sJSON + sCadena; 
	    }
	    buffer.close();
	    
	    // Creating a JSONObject from a String 
	    JSONObject nodeRoot  = new JSONObject(sJSON); 
	    // Creating a sub-JSONObject from another JSONObject
	    JSONArray nodeArray = nodeRoot.getJSONArray("relaciones");

//	    // Getting the value of a attribute in a JSONObject
//	    String sSDR = nodeStats.getString("sdr");
		//Values
		for (int i = 0; i< nodeArray.length(); i++){
			JSONObject obj = nodeArray.getJSONObject(i);
			table_Relaciones.addItem(new Object[]{obj.get("RECID"),obj.get("INSIDERNIN"), obj.get("INSIDERCLASSID"),
							obj.get("INSIDERCOMPANYNIN"),obj.get("COMPANYNIN")}, i+1);
		}		
		
		
	}


	@AutoGenerated
	private void buildMainLayout() throws Exception {
		// table_Relaciones
		table_Relaciones = new Table("Insider Table");
		table_Relaciones.addStyleName(Reindeer.TABLE_STRONG);
		table_Relaciones.setImmediate(true);
		table_Relaciones.setSizeFull();
//		table_Relaciones.setWidth("820px");
//		table_Relaciones.setHeight("100.0%");
		// Define two columns for the built-in container
		table_Relaciones.addContainerProperty("RECID", String.class, null);
		table_Relaciones.addContainerProperty("INSIDERNIN", String.class, null);
		table_Relaciones.addContainerProperty("INSIDERCLASSID", String.class, null);
		table_Relaciones.addContainerProperty("INSIDERCOMPANYNIN", String.class, null);
		table_Relaciones.addContainerProperty("COMPANYNIN", String.class, null);
		// Allow selecting items from the table.
		table_Relaciones.setSelectable(true);

		// Filters
		filter_1 = new TextField();
		filter_1.setCaption("Filter(RECID)");	filter_1.setImmediate(false);filter_1.setNullSettingAllowed(true);		
		filter_1.setWidth("100px");		filter_1.setHeight("-1px");
		filter_2 = new TextField();
		filter_2.setCaption("Filter(INSIDERNIN)");filter_2.setImmediate(false);filter_2.setNullSettingAllowed(true);
		filter_2.setWidth("250px");		filter_2.setHeight("-1px");
		filter_3 = new TextField();
		filter_3.setCaption("Filter(INSIDERCLASSID)");filter_3.setImmediate(false);filter_3.setNullSettingAllowed(true);
		filter_3.setWidth("180px");		filter_3.setHeight("-1px");
		filter_4 = new TextField();
		filter_4.setCaption("Filter(INSIDERCNIN)");filter_4.setImmediate(false);filter_4.setNullSettingAllowed(true);
		filter_4.setWidth("180px");		filter_4.setHeight("-1px");
		filter_5 = new TextField();
		filter_5.setCaption("Filter(COMPANYNIN)");filter_5.setImmediate(false);filter_5.setNullSettingAllowed(true);
		filter_5.setWidth("180px");		filter_5.setHeight("-1px");
		
		Button button_1 = new Button();
		button_1.setCaption("Filter");
		button_1.setImmediate(false);
		button_1.setWidth("-1px");
		button_1.setHeight("-1px");
		button_1.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				//Notification.show("Do not press this button again");
				IndexedContainer container = (IndexedContainer) table_Relaciones.getContainerDataSource();
				String filterS1 = (String) filter_1.getValue();String filterS2 = (String) filter_2.getValue();String filterS3 = (String) filter_3.getValue();
				String filterS4 = (String) filter_4.getValue();String filterS5 = (String) filter_5.getValue();
				Filter filter1 = new SimpleStringFilter("RECID",filterS1, true, false);Filter filter2 = new SimpleStringFilter("INSIDERNIN",filterS2, true, false);
				Filter filter3 = new SimpleStringFilter("INSIDERCLASSID",filterS3, true, false);Filter filter4 = new SimpleStringFilter("INSIDERCOMPANYNIN",filterS4, true, false);
				Filter filter5 = new SimpleStringFilter("COMPANYNIN",filterS5, true, false);
				if ( !filterS1.isEmpty() )
					container.addContainerFilter(filter1);
				if ( !filterS2.isEmpty() )
					container.addContainerFilter(filter2);
				if ( !filterS3.isEmpty() )
					container.addContainerFilter(filter3);
				if ( !filterS4.isEmpty() )
					container.addContainerFilter(filter4);
				if ( !filterS5.isEmpty() )
					container.addContainerFilter(filter5);
				
			}
		});
		Button button_Reset = new Button();
		button_Reset.setCaption("Reset");
		button_Reset.setImmediate(false);
		button_Reset.setWidth("-1px");
		button_Reset.setHeight("-1px");
		button_Reset.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				//Notification.show("Do not press this button again");
				IndexedContainer container = (IndexedContainer) table_Relaciones.getContainerDataSource();
				container.removeAllContainerFilters();
				
			}
		});
		
		//ADDDING...................
		this.addComponent(table_Relaciones);
		this.addComponent(horLayout);
		//this.addComponent(formLayout);
		horLayout.addComponent(filter_1);horLayout.addComponent(filter_2);horLayout.addComponent(filter_3);horLayout.addComponent(filter_4);horLayout.addComponent(filter_5);
		horLayout.addComponent(button_1);horLayout.addComponent(button_Reset);
		horLayout.setComponentAlignment(filter_1, Alignment.TOP_LEFT);horLayout.setComponentAlignment(filter_2, Alignment.TOP_CENTER);
		horLayout.setComponentAlignment(button_1, Alignment.BOTTOM_RIGHT);horLayout.setComponentAlignment(button_Reset, Alignment.BOTTOM_RIGHT);
		this.setComponentAlignment(table_Relaciones, Alignment.TOP_LEFT);
		this.setComponentAlignment(horLayout, Alignment.TOP_LEFT);
		

		
	}

}
