package com.example.samms.menus;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

public class SAMMSMenu {
	
	public static void createTreeContent(MenuBar barmenu, AbsoluteLayout layout ) {
		layout.addComponent(barmenu, "top:10.0px;left:37.0px;");
		barmenu.setWidth("583px");
		        
		// A feedback component
		final Label selection = new Label("-");
		layout.addComponent(selection);
	
		// Define a common menu command for all the menu items
		MenuBar.Command mycommand = new MenuBar.Command() {
		    MenuItem previous = null;
	
		    public void menuSelected(MenuItem selectedItem) {
//		        selection.setValue("Ordered a " +
//		                selectedItem.getText() +
//		                " from menu.");
//	
//		        if (previous != null)
//		            previous.setStyleName(null);
//		        selectedItem.setStyleName("highlight");
//		        previous = selectedItem;
		    }  
		};
		        
		// Put some items in the menu
		MenuItem drinks = barmenu.addItem("Issuers", null, null);
		// Submenu item with a sub-submenu
		MenuItem hots = drinks.addItem("Hot", null, mycommand);
		//hots.addItem("Tea",new ThemeResource("icons/tea-16px.ico"),    mycommand);
		//hots.addItem("Coffee",new ThemeResource("icons/coffee-16px.ico"), mycommand);
		
		barmenu.addItem("Insiders", null, mycommand);
		barmenu.addItem("Persons", null, mycommand);
	}
}
