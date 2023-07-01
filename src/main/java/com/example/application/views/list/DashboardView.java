package com.example.application.views.list;

import com.example.application.data.service.CrmService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import framework.ChainedVerticalLayout;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;

@PermitAll
@Route(value = "dashboard", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@PageTitle("Dashboard")
public class DashboardView extends ChainedVerticalLayout {

    private final ChainedVerticalLayout mainLayout;
    @Autowired
    private final CrmService omniService;

    @Autowired
    public DashboardView(@Autowired CrmService omniService) {
        this.mainLayout = new ChainedVerticalLayout();
        this.mainLayout.setSizeFull();
        this.omniService = omniService;

        this.mainLayout.add(new Text("Dashboard"));

        this.add(this.mainLayout);

    }

}
