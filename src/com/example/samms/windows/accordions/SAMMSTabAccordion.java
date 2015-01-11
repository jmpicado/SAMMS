package com.example.samms.windows.accordions;

import com.vaadin.data.Item;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Label;

public class SAMMSTabAccordion extends AbsoluteLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label label_IN;
	private Label label_CN;
	private Label label_ICN;

	public SAMMSTabAccordion(Item item) {
		super();
		// TODO Auto-generated constructor stub
		built();
		values(item);
	}

	private void values(Item item) {
		// TODO Auto-generated method stub
		label_IN.setValue((String) item.getItemProperty("INSIDERNIN").getValue());
		label_CN.setValue((String) item.getItemProperty("COMPANYNIN").getValue());
		label_ICN.setValue((String) item.getItemProperty("INSIDERCOMPANYNIN").getValue());
	}

	private void built() {
		this.setImmediate(false);
		this.setWidth("660px");
		this.setHeight("140px");
		// label_IN
				label_IN = new Label();
				label_IN.setCaption("InsiderNIN");
				label_IN.setImmediate(false);				label_IN.setWidth("120px");				label_IN.setHeight("-1px");

				this.addComponent(label_IN, "top:40.0px;left:40.0px;");
				
				// label_CN
				label_CN = new Label();
				label_CN.setCaption("CompanyNIN");
				label_CN.setImmediate(false);				label_CN.setWidth("120px");				label_CN.setHeight("100.0%");
				this.addComponent(label_CN,"top:40.0px;bottom:160.0px;left:220.0px;");
				
				// label_ICN
				label_ICN = new Label();
				label_ICN.setCaption("InsiderCompanyNIN");
				label_ICN.setImmediate(false);
				label_ICN.setWidth("120px");
				label_ICN.setHeight("100.0%");
				this.addComponent(label_ICN,"top:40.0px;bottom:170.0px;left:380.0px;");
		
	}

}
