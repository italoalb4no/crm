package com.example.application.data.service;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import framework.ChainedVerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "/analytics")
@PageTitle("Analytics")
public class AnalyticsView extends ChainedVerticalLayout {
    private final ChainedVerticalLayout mainLayout;
    @Autowired
    private final CrmService omniService;

    public AnalyticsView(@Autowired CrmService omniService) {
        this.mainLayout = new ChainedVerticalLayout();
        this.mainLayout.setSizeFull();
        this.omniService = omniService;

        this.mainLayout.add(new Text("Analytics"));

        this.add(this.mainLayout);
    }
}
