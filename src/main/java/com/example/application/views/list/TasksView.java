package com.example.application.views.list;

import com.example.application.data.service.CrmService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;

@PermitAll
@Route(value = "/tasks", layout = MainLayout.class)
@PageTitle("Tasks")
public class TasksView extends VerticalLayout {
    private final VerticalLayout mainLayout;
    @Autowired
    private final CrmService omniService;

    public TasksView(@Autowired CrmService omniService) {
        this.mainLayout = new VerticalLayout();
        this.mainLayout.setSizeFull();
        this.omniService = omniService;

        this.mainLayout.add(new Text("Tasks"));

        this.add(this.mainLayout);
    }
}