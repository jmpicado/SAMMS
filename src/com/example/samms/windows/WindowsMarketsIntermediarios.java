package com.example.samms.windows;

import com.example.samms.tabs.SAMMSTab5;
import com.vaadin.data.Item;
import com.vaadin.ui.Window;

//Define a sub-window by inheritance
public class WindowsMarketsIntermediarios extends Window {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WindowsMarketsIntermediarios(Item item) {
		super("MarketsIntermediaries"); // Set window caption
		center();
		// Some basic content for the window
		SAMMSTab5 content = new SAMMSTab5(null);
		content.setWidth("850px");
		content.setHeight("400px");

		setContent(content);
		// Disable the close button
		setClosable(true);	
	}
}
