package com.example.samms.menus;

import java.io.Serializable;

import com.example.samms.windows.WindowsIndex;
import com.example.samms.windows.WindowsMarketsIntermediarios;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;

public class SAMMSMenu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Component _lastComponent = null;
	
	public class SAMMSComand implements MenuBar.Command{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		TabSheet _tabsheet;
		SAMMSMenu _menu;
		
		public SAMMSComand(TabSheet tabsheet, SAMMSMenu menu) {
			super();
			_tabsheet = tabsheet;_menu=menu;
		}

		@Override
		public void menuSelected(MenuItem selectedItem) {
			
			if (_lastComponent!=null)
				_menu._mainLayout.removeComponent(_lastComponent);
			_lastComponent = _tabsheet;
			_mainLayout.addComponent(_lastComponent,"top:50.0px;left:300.0px;");
			
		}
		
		
	};
	
	AbsoluteLayout _mainLayout;
	
	public void createTreeContent(MenuBar barmenu, TabSheet tabsheet1, TabSheet tabsheet2, 
										TabSheet tabsheet3, AbsoluteLayout mainLayout ) {

		_mainLayout = mainLayout;
		// A feedback component
//		final Label selection = new Label("-");
//		tabsheet.addComponent(selection);
	
		// Define a common menu command for all the menu items
		MenuBar.Command mycommand1 = new SAMMSComand(tabsheet1,this);
		MenuBar.Command mycommand2 = new SAMMSComand(tabsheet2,this);
		MenuBar.Command mycommand3 = new MenuBar.Command() {
			public void menuSelected(MenuItem selectedItem) {
				WindowsIndex sub = new WindowsIndex(null);
		    	// Add it to the root component
		    	UI.getCurrent().addWindow(sub); 
				
			}
		};
		MenuBar.Command mycommand4 = new MenuBar.Command() {
			public void menuSelected(MenuItem selectedItem) {
				WindowsMarketsIntermediarios sub = new WindowsMarketsIntermediarios(null);
		    	// Add it to the root component
		    	UI.getCurrent().addWindow(sub); 
				
			}
		};
		MenuBar.Command mycommand5 = new SAMMSComand(tabsheet3,this);
		
		//Items on the Menu
		MenuItem persons = barmenu.addItem("Persons", null, null);
		// Submenu item with a sub-submenu
		MenuItem conseilhors = persons.addItem("Issuers/Intermediaries..", null, mycommand2);
		MenuItem issuers = persons.addItem("Conseillors..", null, mycommand1);
		
		MenuItem indexes = barmenu.addItem("Indexes", null, null);
		MenuItem indexesSM = indexes.addItem("General", null, mycommand3);
		
		MenuItem markets = barmenu.addItem("Markets", null, null);
		MenuItem marketsSM = markets.addItem("General", null, mycommand4);
		
		MenuItem trades = barmenu.addItem("Trades", null, null);
		MenuItem tradesSM = indexes.addItem("General", null, null);

		MenuItem orderBook = barmenu.addItem("Orders Book", null, null);
		MenuItem orderBookSM = orderBook.addItem("General", null, mycommand5);

	}
}
