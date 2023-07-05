package com.italoalbano.crm.application.views.list;

import com.italoalbano.crm.application.components.dialogs.ItemCreationDialog;
import com.italoalbano.crm.application.data.entity.ItemEntity;
import com.italoalbano.crm.application.data.service.CrmService;
import com.italoalbano.framework.ChainedButton;
import com.italoalbano.framework.ChainedVerticalLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PermitAll
@Route(value = "/products", layout = MainLayout.class)
@PageTitle("Products")
public class ProductsView extends ChainedVerticalLayout {

    private final ChainedVerticalLayout mainLayout;
    private final boolean initialize;
    @Autowired
    private final CrmService crmService;

    public ProductsView(@Autowired CrmService crmService) {
        this.mainLayout = new ChainedVerticalLayout();
        this.mainLayout.setSizeFull();
        this.crmService = crmService;

        ChainedButton createBtn = new ChainedButton(
                "Create",
                VaadinIcon.PLUS.create(),
                click -> {
                    ItemCreationDialog itemCreationDialog = new ItemCreationDialog(this.crmService);
                    itemCreationDialog.open();
                });
        createBtn.withStyle().set("position", "absolute").set("right", "0.5em");

        this.initialize = true;

        HorizontalLayout topLayout = new HorizontalLayout(
                this.getSecondaryNavigation(),
                createBtn);
        this.add(topLayout, this.mainLayout);
    }

    private Tabs getSecondaryNavigation() {
        Tabs tabs = new Tabs();
        Tab allTab = new Tab("All");
        allTab.getElement().addEventListener(
                "click",
                click -> this.allItemsSection());
        Tab unavailableTab = new Tab("Unavailable");
        unavailableTab.getElement()
                .addEventListener(
                        "click",
                        event -> this.unavailableItemsSection());

        tabs.add(
                allTab,
                unavailableTab
        );
        tabs.setSizeFull();

        if (this.initialize) {
            this.allItemsSection();
        }

        return tabs;
    }

    private void allItemsSection() {
        Grid<ItemEntity> grid = this.createGrid();

        List<ItemEntity> items = this.crmService.getItemService().getAllItems();
        grid.setItems(items);

        this.mainLayout.removeAll();
        this.mainLayout.add(grid);
    }

    private void unavailableItemsSection() {
        Grid<ItemEntity> grid = this.createGrid();

        List<ItemEntity> items = this.crmService
                .getItemService()
                .getAllItems();
        grid.setItems(items);

    }

    private Grid<ItemEntity> createGrid() {
        Grid<ItemEntity> grid = new Grid<>(ItemEntity.class, false);
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addColumn(ItemEntity::getId)
                .setHeader("ID")
                .setResizable(true);
        grid.addColumn(ItemEntity::getCreationDate)
                .setHeader("Creation Date")
                .setResizable(true);
        grid.addColumn(ItemEntity::getName)
                .setHeader("Name")
                .setResizable(true);
        grid.addColumn(ItemEntity::getDescription)
                .setHeader("Description")
                .setResizable(true)
                .setAutoWidth(true)
                .setFlexGrow(0);
        return grid;
    }
}
