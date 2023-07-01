package com.example.application.views.list;

import com.example.application.data.service.CrmService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import framework.ChainedVerticalLayout;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;

@PermitAll
@Route(value = "/customers", layout = MainLayout.class)
@PageTitle("Customers")
public class CustomersView extends ChainedVerticalLayout {

    private final ChainedVerticalLayout mainLayout;
    @Autowired
    private final CrmService omniService;

    public CustomersView(@Autowired CrmService omniService) {
        this.mainLayout = new ChainedVerticalLayout();
        this.mainLayout.setSizeFull();
        this.omniService = omniService;

        this.mainLayout.add(new Text("Customers"));

        this.add(this.mainLayout);
    }
}
