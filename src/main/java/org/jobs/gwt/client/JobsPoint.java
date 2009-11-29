package org.jobs.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class JobsPoint implements EntryPoint {

	public void onModuleLoad() {

		final Button button = new Button("Say Hello", new ClickHandler() {

			public void onClick(ClickEvent event) {
				Window.alert("Hello, AJAX11111");
			}
			
		});
		
		final Grid table = new Grid(5, 6);
		table.setCellPadding(0);
		table.setCellSpacing(0);
		table.setTitle("The title of grid.");

		table.setBorderWidth(1);
		HTML label = new HTML("<b>Title0</b>");
		
		table.setText(0, 0, label.getText());
		table.setText(0, 1, "Title1 ");
		table.setText(0, 2, "Title2 ");
		table.setText(0, 3, "Title3 ");
		table.setText(0, 4, "Title3 ");
		table.setText(0, 5, "Title3 ");

		HorizontalPanel panelTop = new HorizontalPanel();
		panelTop.add(button);

		HorizontalPanel panelCenter = new HorizontalPanel();
		panelCenter.add(table);

		DockPanel dock = new DockPanel();
		dock.setBorderWidth(3);
		dock.setSpacing(4);
		dock.setHorizontalAlignment(DockPanel.ALIGN_CENTER);
		dock.add(panelTop, DockPanel.NORTH);
		dock.add(table, DockPanel.SOUTH);

		RootPanel.get("order_list").add(dock);
	}
}
