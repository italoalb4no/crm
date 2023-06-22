package com.example.application.components.dialogs;

import com.example.application.data.entity.CustomerEntity;
import com.example.application.data.service.CrmService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OrderCreationDialog1 extends CustomDialog {
    private final CrmService omniService;

    private SplitLayout splitLayout;
    private Button nextSectionBtn;
    private Button previousSectionBtn;

    public OrderCreationDialog1(@Autowired CrmService omniService) {
        super(
                false,
                false,
                true,
                true);
        this.omniService = omniService;
        this.setWidth(75, Unit.PERCENTAGE);
        this.setHeight(55, Unit.PERCENTAGE);

        List<String> sections = new ArrayList<>();
        sections.add("Customer Details");
        sections.add("Items");
        sections.add("Shipment");
        sections.add("Payment and Confirmation");
        this.setHeader(sections);

        this.customerSection();
    }

    private void customerSection() {
        this.highlightSection(0);
        this.removeAll();

        this.nextSectionBtn = new Button(
                "Go on",
                VaadinIcon.ARROW_RIGHT.create(),
                click -> this.itemsSelection());
        this.nextSectionBtn.setEnabled(false);

        this.getFooter().removeAll();
        this.getFooter().add(this.nextSectionBtn);

        HorizontalLayout leftTitle = new HorizontalLayout();
        Icon userIcon = new Icon(VaadinIcon.USER);
        userIcon.addClassName(LumoUtility.Margin.Left.AUTO);
        leftTitle.add(new Text("Existing customer"), userIcon);
        leftTitle.getStyle()
                .set("padding", "1.2em")
                .set("background", "#808080")
                .set("color", "white");
        leftTitle.setWidthFull();
        leftTitle.addClassName(LumoUtility.BorderRadius.LARGE);

        HorizontalLayout rightTitle = new HorizontalLayout();
        Icon plusIcon = new Icon(VaadinIcon.PLUS);
        plusIcon.addClassName(LumoUtility.Margin.Left.AUTO);
        rightTitle.add(new Text("New customer"), plusIcon);
        rightTitle.getStyle()
                .set("padding", "1.2em")
                .set("background", "#808080")
                .set("color", "white");
        rightTitle.setWidthFull();
        rightTitle.addClassName(LumoUtility.BorderRadius.LARGE);

        Button newCustomerBtn = new Button(
                "Create new customer",
                VaadinIcon.PLUS.create(),
                click -> {
                    CustomerCreationDialog customerCreationDialog = new CustomerCreationDialog(this.omniService);
                    customerCreationDialog.open();
                }
        );
        newCustomerBtn.getStyle()
                .set("background", "#5D60EF")
                .set("color", "white")
                .set("padding", "1.2em")
                .set("top", "2em");
        newCustomerBtn.addClassNames(LumoUtility.BorderRadius.LARGE);
        newCustomerBtn.setWidth(90, Unit.PERCENTAGE);

        ComboBox.ItemFilter<CustomerEntity> filter = (customer, filterString) -> (
                customer.getFirstName() + " " + customer.getLastName())
                .toLowerCase().indexOf(filterString.toLowerCase()) > -1;

        ComboBox<CustomerEntity> comboBox = new ComboBox<>("CustomerEntity");
        comboBox.setPlaceholder("Select customer");
        comboBox.setItems(filter, this.omniService.getCustomerService().getAllCustomers());
        comboBox.setItemLabelGenerator(
                customer -> customer.getFirstName() + " " + customer.getLastName());
        comboBox.setWidth(90, Unit.PERCENTAGE);
        comboBox.addValueChangeListener(click -> this.nextSectionBtn.setEnabled(true));

        Button refreshBtn = new Button(
                VaadinIcon.REFRESH.create(),
                click -> comboBox.setItems(
                        filter,
                        this.omniService.getCustomerService().getAllCustomers()
                )
        );

        HorizontalLayout searchSection = new HorizontalLayout(comboBox, refreshBtn);
        searchSection.setWidthFull();
        searchSection.setAlignItems(FlexComponent.Alignment.BASELINE);


        this.createSplitLayout(
                new VerticalLayout(leftTitle, searchSection),
                new VerticalLayout(rightTitle, newCustomerBtn));

        this.splitLayout.setSizeFull();
        this.add(this.splitLayout);

    }

    private void itemsSelection() {
        this.highlightSection(1);
        this.removeAll();
        this.previousSectionBtn = new Button(
                "Go back",
                VaadinIcon.ARROW_LEFT.create(),
                click -> this.customerSection()
        );
        this.previousSectionBtn.addClassName(LumoUtility.Margin.Right.AUTO);
        this.nextSectionBtn = new Button(
                "Go on",
                VaadinIcon.ARROW_RIGHT.create(),
                click -> this.lolSection()
        );

        this.getFooter().removeAll();
        this.getFooter().add(this.previousSectionBtn, this.nextSectionBtn);

        this.createSplitLayout(new VerticalLayout(), new VerticalLayout());
    }

    private void lolSection() {
        this.highlightSection(3);
    }

    private void createSplitLayout(VerticalLayout leftContainer, VerticalLayout rightContainer) {
        leftContainer.setAlignItems(FlexComponent.Alignment.CENTER);
        leftContainer.setHeightFull();
        leftContainer.setWidth(50, Unit.PERCENTAGE);

        rightContainer.setAlignItems(FlexComponent.Alignment.CENTER);
        rightContainer.setHeightFull();
        rightContainer.setWidth(50, Unit.PERCENTAGE);

        this.splitLayout = new SplitLayout(leftContainer, rightContainer);
        this.splitLayout.setSizeFull();
    }

}
