package com.example.application.views.list;

import com.example.application.data.entity.UserEntity;
import com.example.application.security.SecurityService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.springframework.beans.factory.annotation.Autowired;

@CssImport(value = "./styles/customStyles.css", include = "lumo-utility")
public class MainLayout extends AppLayout implements BeforeEnterObserver {
    private final SecurityService securityService;
    private final HorizontalLayout header;
    private final Span titleContainer;
    private Tabs tabs;
    private UserEntity userInSession;
    private Tab dashboardTab;
    private Tab ordersTab;
    private Tab customersTab;
    private Tab productsTab;
    private Tab documentsTab;
    private Tab tasksTab;
    private Tab analyticsTab;

    public MainLayout(@Autowired SecurityService securityService) {
        this.securityService = securityService;

        this.titleContainer = new Span();
        this.titleContainer.getElement().getThemeList().add("badge");
        this.titleContainer.getElement().getStyle().set("background", "none").set("color", "#5D60EF");
        this.titleContainer.addClassNames(LumoUtility.FontSize.XLARGE, LumoUtility.FontWeight.BOLD);

        this.createPrimaryNavigation();

        DrawerToggle toggle = new DrawerToggle();

        this.header = new HorizontalLayout(toggle, this.titleContainer);
        this.header.setWidthFull();
        this.createNavbar();
        this.header.setPadding(true);
        this.header.setFlexGrow(3);
        this.header.addClassName(LumoUtility.Padding.SMALL);
        this.addToDrawer(this.tabs);
        this.addToNavbar(this.header);
        this.setPrimarySection(Section.DRAWER);

    }

    private void createNavbar() {

//        if (this.securityService.getAuthenticatedUser() != null) {
//            this.userInSession = this.userDetailsService.loadUserObjectByUsername(this.securityService.getAuthenticatedUser().getUsername());
//            String initials = this.userInSession.getFirstName().substring(0, 1).toUpperCase() + this.userInSession.getLastName().substring(0, 1).toUpperCase();
//
//            Button initialsBadge = new Button(initials);
//            initialsBadge.setHeightFull();
//            initialsBadge.getElement().getThemeList().add("badge");
//            initialsBadge.addClassNames(LumoUtility.FontSize.XLARGE, LumoUtility.FontWeight.BOLD, LumoUtility.BorderRadius.LARGE);
//            MenuBar menuBar = new MenuBar();
//            menuBar.addClassNames(LumoUtility.Margin.Left.AUTO);
//            menuBar.addThemeVariants(MenuBarVariant.LUMO_TERTIARY_INLINE);
//
//            MenuItem menuItem = menuBar.addItem(initialsBadge);
//            SubMenu subMenu = menuItem.getSubMenu();
//            subMenu.addItem("Profile");
//            subMenu.addItem("Settings");
//            subMenu.addItem("Help");
//            subMenu.addItem("Sign out", menuItemClickEvent -> this.securityService.logout());
//
//
//            // TODO implement the search bar
//            TextField searchBar = new TextField();
//            searchBar.addClassNames(
//                    LumoUtility.BorderRadius.LARGE,
//                    LumoUtility.Overflow.HIDDEN);
//            searchBar.setPlaceholder("Search");
//
//            this.header.add(searchBar, menuBar);
//            this.header.setFlexGrow(1, searchBar);
//
//        }

    }

    private void createPrimaryNavigation() {
        this.tabs = new Tabs();
        this.tabs.setWidthFull();
        this.tabs.addSelectedChangeListener(e -> {
            this.titleContainer.setText(e.getSelectedTab().getId().orElse(""));
            this.tabs.getChildren().forEach(tab -> tab.getElement().getStyle().set("background", "white").set("color", "gray").set("padding", "1em"));
            this.tabs.getSelectedTab().getStyle().set("background", "#5D60EF").set("color", "white").set("padding", "1.2em");
        });

        RouterLink dashboardLink = this.createLink(VaadinIcon.DASHBOARD, "Dashboard");
        dashboardLink.setRoute(DashboardView.class);
        this.dashboardTab = this.createTab(dashboardLink, "Dashboard");

        RouterLink ordersLink = this.createLink(VaadinIcon.CART, "Orders");
        ordersLink.setRoute(OrdersView.class);
        this.ordersTab = this.createTab(ordersLink, "Orders");

        RouterLink customersLink = this.createLink(VaadinIcon.USER_HEART, "Customers");
        customersLink.setRoute(CustomersView.class);
        this.customersTab = this.createTab(customersLink, "Customers");

        RouterLink productsLink = this.createLink(VaadinIcon.PACKAGE, "Products");
        productsLink.setRoute(ProductsView.class);
        this.productsTab = this.createTab(productsLink, "Products");

        RouterLink documentsLink = this.createLink(VaadinIcon.RECORDS, "Documents");
        documentsLink.setRoute(DocumentsView.class);
        this.documentsTab = this.createTab(documentsLink, "Documents");

        RouterLink tasksLink = this.createLink(VaadinIcon.TASKS, "Tasks");
        tasksLink.setRoute(TasksView.class);
        this.tasksTab = this.createTab(tasksLink, "Tasks");

        RouterLink analyticsLink = this.createLink(VaadinIcon.CHART, "Analytics");
        analyticsLink.setRoute(AnalyticsView.class);
        this.analyticsTab = this.createTab(analyticsLink, "Analytics");

        this.tabs.add(
                this.dashboardTab,
                this.ordersTab,
                this.customersTab,
                this.productsTab,
                this.documentsTab,
                this.tasksTab,
                this.analyticsTab
        );
        this.tabs.setOrientation(Tabs.Orientation.VERTICAL);

    }

    private RouterLink createLink(VaadinIcon icon, String name) {
        RouterLink link = new RouterLink();
        link.add(this.createIcon(icon), new Span(name));
        link.setTabIndex(-1);
        return link;
    }

    private Tab createTab(RouterLink link, String label) {
        Tab tab = new Tab(link);
        tab.addClassName("tabDefault");
        tab.setId(label);
        return tab;
    }

    private Icon createIcon(VaadinIcon svg) {
        Icon icon = new Icon(svg);
        icon.getStyle().set("box-sizing", "border-box")
                .set("margin-inline-end", "var(--lumo-space-m)")
                .set("padding", "var(--lumo-space-xs)");
        return icon;
    }


    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        switch (beforeEnterEvent.getLocation().getPath()) {
            case "dashboard" -> this.tabs.setSelectedTab(this.dashboardTab);
            case "orders" -> this.tabs.setSelectedTab(this.ordersTab);
            case "customers" -> this.tabs.setSelectedTab(this.customersTab);
            case "products" -> this.tabs.setSelectedTab(this.productsTab);
            case "documents" -> this.tabs.setSelectedTab(this.documentsTab);
            case "tasks" -> this.tabs.setSelectedTab(this.tasksTab);
            case "analytics" -> this.tabs.setSelectedTab(this.analyticsTab);
            //default -> this.tabs.setSelectedTab(this.dashboardTab);
        }
    }
}
