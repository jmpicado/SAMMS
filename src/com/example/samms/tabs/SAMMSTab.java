package com.example.samms.tabs;

import com.example.samms.SammsUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class SAMMSTab extends VerticalLayout {

	protected SammsUI sammsUI;
	
	
	//Primer Componente: una tabla
	protected Table table_Relaciones ;
	//Segundo Componente: una layer horizontal
	protected HorizontalLayout horLayout = new HorizontalLayout();
	

	public SAMMSTab(SammsUI sammsUI) {
		this.sammsUI = sammsUI;
		horLayout = new HorizontalLayout();
		horLayout.setHeight("50px");
		// common part: create layout
		this.setImmediate(true);
		this.setMargin(true);
		this.setSizeFull();
		this.setWidth("100%");
		this.setHeight("80%");
		this.setSpacing(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
