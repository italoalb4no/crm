package com.example.application.views.list;

import com.example.application.data.service.CrmService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import framework.ChainedVerticalLayout;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;

@PermitAll
@Route(value = "/project-analytics", layout = MainLayout.class)
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
