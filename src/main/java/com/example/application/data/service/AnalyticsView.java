package com.example.application.data.service;

import com.example.application.data.service.CrmService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "/analytics")
@PageTitle("Analytics")
public class AnalyticsView extends VerticalLayout {
    private final VerticalLayout mainLayout;
    @Autowired
    private final CrmService omniService;

    public AnalyticsView(@Autowired CrmService omniService) {
        this.mainLayout = new VerticalLayout();
        this.mainLayout.setSizeFull();
        this.omniService = omniService;

        this.mainLayout.add(new Text("Analytics"));

        this.add(this.mainLayout);
    }
}
