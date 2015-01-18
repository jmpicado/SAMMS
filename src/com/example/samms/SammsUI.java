package com.example.samms;

import javax.servlet.annotation.WebServlet;

import com.example.samms.menus.SAMMSMenu;
import com.example.samms.tabs.SAMMSTabConseillors;
import com.example.samms.tabs.SAMMSTabDchosVoto;
import com.example.samms.tabs.SAMMSTabIssuers;
import com.example.samms.tabs.SAMMSTabIntermediarios;
import com.example.samms.trees.SAMMSTreePersonCODESNIN;
import com.example.samms.trees.SAMMSTreePersonNINCODES;
import com.example.samms.windows.accordions.SAMMSMarketsAccordion;
import com.example.samms.windows.accordions.SAMMSNegotiationSystemAccordion;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings("serial")
@Theme("reindeer")
public class SammsUI extends UI {

	public MenuBar barmenu; 
	
	public SAMMSTreePersonNINCODES tree_1;
	public TextField filter_1;public TextField filter_2;
	public SAMMSTreePersonCODESNIN tree_2; 
	
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = SammsUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@AutoGenerated
	private AbsoluteLayout _mainLayout;
	
	@Override
	protected void init(VaadinRequest request) {
		// common part: create layout
		_mainLayout = new AbsoluteLayout();
		_mainLayout.addStyleName(Reindeer.LAYOUT_BLUE);
		_mainLayout.setImmediate(false);
		_mainLayout.setWidth("100%");
		_mainLayout.setHeight("100%");
		setContent(_mainLayout);

	
        //Trees over menus
        tree_1 = new SAMMSTreePersonNINCODES("CODES");
		tree_1.setImmediate(false);tree_1.setSizeUndefined();
		Panel menuContainer = new Panel("PERSONNIN -> CODES-DESCRIPTION ", tree_1);
		menuContainer.setWidth("300px");menuContainer.setHeight("250px");
		_mainLayout.addComponent(menuContainer, "top:50.0px;left:20.0px;");

		tree_2 = new SAMMSTreePersonCODESNIN("CODES2");
		tree_2.setImmediate(false);
		tree_2.setSizeUndefined();
		Panel menuContainer2 = new Panel("CODE -> PERSONNIN-DESCRIPTION ", tree_2);
		menuContainer2.setWidth("300px");menuContainer2.setHeight("250px");
		_mainLayout.addComponent(menuContainer2, "top:350.0px;left:20.0px;");

		//Trees Filters
		filter_1 = new TextField();
		filter_1.setCaption("Filter(PERSONNIN)");	filter_1.setImmediate(false);filter_1.setNullSettingAllowed(true);		
		filter_1.setWidth("100px");		filter_1.setHeight("-1px");
		_mainLayout.addComponent(filter_1, "top:620.0px;left:20.0px;");
		filter_2 = new TextField();
		filter_2.setCaption("Filter(CODE)");	filter_2.setImmediate(false);filter_2.setNullSettingAllowed(true);		
		filter_2.setWidth("100px");		filter_2.setHeight("-1px");
		_mainLayout.addComponent(filter_2, "top:620.0px;left:130.0px;");

		Button button_1 = new Button();
		button_1.setCaption("Filter");		button_1.setImmediate(false);		button_1.setWidth("50px");		button_1.setHeight("-1px");
		Button button_Reset = new Button();
		button_Reset.setCaption("Reset");button_Reset.setImmediate(false);button_Reset.setWidth("50px");button_Reset.setHeight("-1px");
		_mainLayout.addComponent(button_1, "top:670.0px;left:40.0px;");
		_mainLayout.addComponent(button_Reset, "top:670.0px;left:100.0px;");
				
		//TabSheets
		TabSheet tabsheet1 = new TabSheet();
		tabsheet1.setHeight("700.0px");tabsheet1.setWidth("1000.0px");
		// Create the first tab
		SAMMSTabConseillors l1 = new SAMMSTabConseillors(this);
		tabsheet1.addTab(l1, "Insider Conseillors");
		// This tab gets its caption from the component caption
		SAMMSTabDchosVoto tab2 = new SAMMSTabDchosVoto(this);
		tabsheet1.addTab(tab2, "Insider Others");
		
		TabSheet tabsheet2 = new TabSheet();
		tabsheet2.setHeight("700.0px");tabsheet2.setWidth("1000.0px");
		SAMMSTabIssuers tab3 = new SAMMSTabIssuers(this);
		tabsheet2.addTab(tab3, "Issuers");
		SAMMSTabIntermediarios tab4 = new SAMMSTabIntermediarios(this);
		tabsheet2.addTab(tab4, "Intermediarios");
		
		
		
		//Menus
        barmenu = new MenuBar();
        _mainLayout.addComponent(barmenu, "top:10.0px;left:37.0px;");
		barmenu.setWidth("383px");
		SAMMSMenu menu = new SAMMSMenu();
        menu.createTreeContent(barmenu, tabsheet1,tabsheet2,_mainLayout);
        
        //Accordion.
		Accordion accordion = new Accordion();
		accordion.setWidth("400px");accordion.setHeight("250px");
		// Have it take all space available in the layout.
		accordion.setSizeFull();
		// Some components to put in the Accordion.
	
		// Add the components as tabs in the Accordion.
		accordion.addTab(new SAMMSNegotiationSystemAccordion(), "Negotiation Systems", null);
		accordion.addTab(new SAMMSMarketsAccordion(), "Markets", null);

		_mainLayout.addComponent(accordion, "top:50.0px;left:1300.0px;");

		//Events
		setEvents(button_1, button_Reset);
	}

	private void setEvents(Button button_1, Button button_Reset) {
		button_1.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				//Notification.show("Do not press this button again");
				HierarchicalContainer  container = (HierarchicalContainer ) tree_1.getContainerDataSource();
				String filterS = (String) filter_1.getValue();
				if (!filterS.isEmpty()){
					Filter filter= new SimpleStringFilter("PERSONNIN",filterS, true, false);
					container.addContainerFilter(filter);
				}
				
				HierarchicalContainer  container2 = (HierarchicalContainer ) tree_2.getContainerDataSource();
				String filterS2 = (String) filter_2.getValue();
				if (!filterS2.isEmpty()){
					Filter filter2 = new SimpleStringFilter("CODE",filterS2, true, false);
					container2.addContainerFilter(filter2);
				}

			}
		});

		button_Reset.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				HierarchicalContainer  container = (HierarchicalContainer ) tree_1.getContainerDataSource();
				container.removeAllContainerFilters();
				HierarchicalContainer  container2 = (HierarchicalContainer ) tree_2.getContainerDataSource();
				container2.removeAllContainerFilters();
			}
		});
		
	}

}