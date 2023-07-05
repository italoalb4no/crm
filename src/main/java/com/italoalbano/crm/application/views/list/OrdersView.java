package com.italoalbano.crm.application.views.list;

import com.italoalbano.crm.application.components.dialogs.OrderCreationDialog;
import com.italoalbano.crm.application.data.entity.ItemEntity;
import com.italoalbano.crm.application.data.entity.OrderEntity;
import com.italoalbano.crm.application.data.service.CrmService;
import com.italoalbano.framework.*;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PermitAll
@Route(value = "/orders", layout = MainLayout.class)
@PageTitle("Orders")
public class OrdersView extends ChainedVerticalLayout {

    private final ChainedVerticalLayout mainLayout;
    private final CrmService omniService;
    private final ChainedTextField searchBar;
    private final ChainedButton createBtn;
    private final ChainedButton searchBtn;
    private final ChainedVerticalLayout gridContainer;

    private ChainedGrid<ItemEntity> grid;

    private Tabs tabFilters;

    @Autowired
    public OrdersView(CrmService omniService) {

        this.omniService = omniService;

        this.createBtn = new ChainedButton(
                "Create",
                VaadinIcon.PLUS.create(),
                click -> {
                    new OrderCreationDialog(this.omniService).open();
                }
        )
                .withThemeName(ButtonVariant.LUMO_PRIMARY.getVariantName())
                .withClassName(LumoUtility.Margin.Left.AUTO);

        ChainedSpan title = new ChainedSpan("Search for orders")
                .withClassNames(
                        LumoUtility.FontSize.XXLARGE,
                        LumoUtility.FontWeight.BOLD);

        this.searchBtn = new ChainedButton(
                "Search",
                VaadinIcon.SEARCH.create());
        this.searchBar = new ChainedTextField()
                .withPlaceholder("Search by order id or client's name")
                .withWidthFull();

        this.createDefaultGrid();

        this.gridContainer = new ChainedVerticalLayout(this.grid)
                .withSizeFull();

        this.createFilters();

        this.mainLayout = new ChainedVerticalLayout(
                new ChainedHorizontalLayout(
                        this.searchBar,
                        this.searchBtn
                )
                        .withWidthFull(),
                this.tabFilters,
                this.gridContainer
                        .withSizeFull())
                .withSizeFull();

        this.add(
                new ChainedHorizontalLayout(title, this.createBtn)
                        .withAlignItems(Alignment.BASELINE)
                        .withWidthFull(),
                this.mainLayout);
        this.setSizeFull();
    }

    private void createDefaultGrid() {
        this.grid = new ChainedGrid<ItemEntity>()
                .withClassNames(
                        LumoUtility.BorderRadius.MEDIUM,
                        LumoUtility.Overflow.HIDDEN);
        this.grid.withColumn(ItemEntity::getName)
                .setResizable(true)
                .setHeader("Name");
        this.grid.withColumn(ItemEntity::getDescription)
                .setResizable(true)
                .setHeader("Description");
        this.grid.withColumn(ItemEntity::getCreationDate)
                .setResizable(true)
                .setHeader("Creation date");

        this.grid.withItems(
                this.omniService
                        .getItemService().getAllItems());
    }

    private void createFilters() {
        this.tabFilters = new Tabs();
        for (Filter filter : Filter.values()) {
            this.tabFilters.add(new Tab(filter.name()));
        }

    }

    private Tabs getSecondaryNavigation() {
        Tabs tabs = new Tabs();
        Tab allTab = new Tab("All");
        allTab.getElement()
                .addEventListener(
                        "click",
                        event -> this.allOrdersSection());
        Tab openTab = new Tab("Open");
        openTab.getElement()
                .addEventListener(
                        "click",
                        event -> this.openOrdersSection());
        Tab completedTab = new Tab("Completed");
        completedTab.getElement()
                .addEventListener(
                        "click",
                        event -> this.completedOrdersSection());
        Tab cancelledTab = new Tab("Cancelled");
        cancelledTab.getElement()
                .addEventListener(
                        "click",
                        event -> this.cancelledOrdersSection());

        tabs.add(
                allTab,
                openTab,
                completedTab,
                cancelledTab
        );
        tabs.setSizeFull();

        return tabs;
    }

    private void openOrdersSection() {
        Grid<OrderEntity> grid = this.createGrid();

        List<OrderEntity> orders = this.omniService
                .getOrderService()
                .getAllOrders();
        grid.setItems(orders);

    }

    private void completedOrdersSection() {
        Grid<OrderEntity> grid = this.createGrid();

        List<OrderEntity> orders = this.omniService
                .getOrderService()
                .getAllOrders();
        grid.setItems(orders);

    }

    private void cancelledOrdersSection() {
        Grid<OrderEntity> grid = this.createGrid();

        List<OrderEntity> orders = this.omniService
                .getOrderService()
                .getAllOrders();
        grid.setItems(orders);

    }

    private void allOrdersSection() {
        Grid<OrderEntity> grid = this.createGrid();

        List<OrderEntity> orders = this.omniService
                .getOrderService()
                .getAllOrders();
        grid.setItems(orders);

        this.mainLayout.removeAll();
        this.mainLayout.add(grid);
    }

    private Grid<OrderEntity> createGrid() {
        Grid<OrderEntity> grid = new Grid<>(OrderEntity.class, false);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addColumn(OrderEntity::getId)
                .setHeader("ID")
                .setResizable(true);
        grid.addColumn(OrderEntity::getCreationDate)
                .setHeader("Creation Date")
                .setResizable(true);
        grid.addColumn(OrderEntity::getCustomer)
                .setHeader("CustomerEntity ID")
                .setResizable(true);
        grid.addColumn(OrderEntity::isFullfilled)
                .setHeader("Fullfilled")
                .setResizable(true)
                .setAutoWidth(true)
                .setFlexGrow(0);
        return grid;
    }

    enum Filter {
        ALL,
        OPEN,
        PENDING,
        CLOSED
    }
}