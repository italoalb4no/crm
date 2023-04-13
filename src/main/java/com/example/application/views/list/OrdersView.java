package com.example.application.views.list;

import com.example.application.components.dialogs.NewOrderDialog;
import com.example.application.data.entity.OrderEntity;
import com.example.application.data.entity.UserEntity;
import com.example.application.data.service.CrmService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PermitAll
@Route(value = "/orders", layout = MainLayout.class)
@PageTitle("Orders")
public class OrdersView extends VerticalLayout {

    private final VerticalLayout mainLayout;
    private final boolean initialize;
    @Autowired
    private final CrmService omniService;

    public OrdersView(@Autowired CrmService omniService) {
        this.mainLayout = new VerticalLayout();
        this.omniService = omniService;

        Button createBtn = new Button("Create", VaadinIcon.PLUS.create(), e -> {
            NewOrderDialog newOrderDialog = new NewOrderDialog(this.omniService);
            newOrderDialog.open();
        });
        createBtn.getStyle().set("position", "absolute").set("right", "0.5em");

        this.initialize = true;

        HorizontalLayout topLayout = new HorizontalLayout(this.getSecondaryNavigation(), createBtn);
        this.add(topLayout, this.mainLayout);
    }

    private static Renderer<UserEntity> createCustomerRenderer() {
        return LitRenderer.<UserEntity>of(
                        "<vaadin-horizontal-layout style=\"align-items: center;\" theme=\"spacing\">"
                                + "<vaadin-avatar img=\"${item.pictureUrl}\" name=\"${item.fullName}\" alt=\"UserEntity avatar\"></vaadin-avatar>"
                                + "  <vaadin-vertical-layout style=\"line-height: var(--lumo-line-height-m);\">"
                                + "    <span> ${item.fullName} </span>"
                                + "    <span style=\"font-size: var(--lumo-font-size-s); color: var(--lumo-secondary-text-color);\">"
                                + "      ${item.email}" + "    </span>"
                                + "  </vaadin-vertical-layout>"
                                + "</vaadin-horizontal-layout>")
                .withProperty("fullName", UserEntity::getFirstName)
                .withProperty("email", UserEntity::getEmail);
    }

    private Tabs getSecondaryNavigation() {
        Tabs tabs = new Tabs();
        Tab allTab = new Tab("All");
        allTab.getElement().addEventListener("click", event -> this.allOrdersSection());
        Tab openTab = new Tab("Open");
        openTab.getElement().addEventListener("click", event -> this.openOrdersSection());
        Tab completedTab = new Tab("Completed");
        completedTab.getElement().addEventListener("click", event -> this.completedOrdersSection());
        Tab cancelledTab = new Tab("Cancelled");
        cancelledTab.getElement().addEventListener("click", event -> this.cancelledOrdersSection());

        tabs.add(
                allTab,
                openTab,
                completedTab,
                cancelledTab
        );
        tabs.setSizeFull();

        if (this.initialize) {
            this.allOrdersSection();
        }

        return tabs;
    }

    private void openOrdersSection() {
        Grid<OrderEntity> grid = this.createGrid();

        List<OrderEntity> orders = this.omniService.getOrderService().getAllOrders();
        grid.setItems(orders);

    }

    private void completedOrdersSection() {
        Grid<OrderEntity> grid = this.createGrid();

        List<OrderEntity> orders = this.omniService.getOrderService().getAllOrders();
        grid.setItems(orders);

    }

    private void cancelledOrdersSection() {
        Grid<OrderEntity> grid = this.createGrid();

        List<OrderEntity> orders = this.omniService.getOrderService().getAllOrders();
        grid.setItems(orders);

    }

    private void allOrdersSection() {
        Grid<OrderEntity> grid = this.createGrid();

        List<OrderEntity> orders = this.omniService.getOrderService().getAllOrders();
        grid.setItems(orders);

        this.mainLayout.removeAll();
        this.mainLayout.add(grid);
    }

    private Grid<OrderEntity> createGrid() {
        Grid<OrderEntity> grid = new Grid<>(OrderEntity.class, false);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addColumn(OrderEntity::getId).setHeader("ID").setResizable(true);
        grid.addColumn(OrderEntity::getCreationDate).setHeader("Creation Date").setResizable(true);
        grid.addColumn(OrderEntity::getCustomer).setHeader("CustomerEntity ID").setResizable(true);
        grid.addColumn(OrderEntity::isFullfilled)
                .setHeader("Fullfilled")
                .setResizable(true)
                .setAutoWidth(true)
                .setFlexGrow(0);
        return grid;
    }

}