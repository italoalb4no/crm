package com.italoalbano.crm.application.views.list;

import com.italoalbano.crm.application.data.service.CrmService;
import com.italoalbano.framework.ChainedVerticalLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
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
