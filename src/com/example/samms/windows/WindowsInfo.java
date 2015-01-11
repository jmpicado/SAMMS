package com.example.samms.windows;

import com.example.samms.windows.accordions.SAMMSTabAccordion;
import com.vaadin.data.Item;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

//Define a sub-window by inheritance
public class WindowsInfo extends Window {
	public WindowsInfo(Item item) {
		super("Properties/Details"); // Set window caption
		center();
		// Some basic content for the window
		VerticalLayout content = new VerticalLayout();
		content.setWidth("670px");
		content.setHeight("400px");
			// Create the Accordion.
			Accordion accordion = new Accordion();
			// Have it take all space available in the layout.
			accordion.setSizeFull();
			// Some components to put in the Accordion.
		
			// Add the components as tabs in the Accordion.
			accordion.addTab(new SAMMSTabAccordion(item), "Main Properties", null);
			accordion.addTab(new SAMMSTabAccordion(item), "Other Properties", null);

		content.addComponent(accordion);
		content.setMargin(true);
			
			// Trivial logic for closing the sub-window
			Button ok = new Button("OK")	;
			ok.setWidth("100px");
			ok.addClickListener(new ClickListener() {
				public void buttonClick(ClickEvent event) {
					close(); // Close the sub-window
				}
			});
			content.addComponent(ok);
			content.setComponentAlignment(ok, Alignment.MIDDLE_CENTER);
		setContent(content);
		// Disable the close button
		setClosable(true);	
	}
}
