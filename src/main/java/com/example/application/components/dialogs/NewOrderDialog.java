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

public class NewOrderDialog extends CustomDialog {
    private final CrmService omniService;

    public NewOrderDialog(@Autowired CrmService omniService) {
        super(false, false, true, true);
        this.omniService = omniService;
        this.setWidth(75, Unit.PERCENTAGE);
        this.setHeight(55, Unit.PERCENTAGE);

        List<String> sections = new ArrayList<>();
        sections.add("CustomerEntity Details");
        sections.add("Items");
        sections.add("Shipment");
        sections.add("Payment and Confirmation");
        this.setHeader(sections);

        this.add(this.customerSection());
    }

    private VerticalLayout customerSection() {
        this.highlightSection(1);

        VerticalLayout container = new VerticalLayout();

        HorizontalLayout leftTitle = new HorizontalLayout();
        Icon userIcon = new Icon(VaadinIcon.USER);
        userIcon.addClassName(LumoUtility.Margin.Left.AUTO);
        leftTitle.add(new Text("Existing customer"), userIcon);
        leftTitle.getStyle().set("padding", "1.2em").set("background", "#808080").set("color", "white");
        leftTitle.setWidthFull();
        leftTitle.addClassName(LumoUtility.BorderRadius.LARGE);

        HorizontalLayout rightTitle = new HorizontalLayout();
        Icon plusIcon = new Icon(VaadinIcon.PLUS);
        plusIcon.addClassName(LumoUtility.Margin.Left.AUTO);
        rightTitle.add(new Text("New customer"), plusIcon);
        rightTitle.getStyle().set("padding", "1.2em").set("background", "#808080").set("color", "white");
        rightTitle.setWidthFull();
        rightTitle.addClassName(LumoUtility.BorderRadius.LARGE);

        Button newCustomerBtn = new Button("Create new customer", VaadinIcon.PLUS.create(), e -> {
            NewCustomerDialog newCustomerDialog = new NewCustomerDialog(this.omniService);
            newCustomerDialog.open();
        });
        newCustomerBtn.getStyle()
                .set("background", "#5D60EF")
                .set("color", "white")
                .set("padding", "1.2em")
                .set("top", "2em");
        newCustomerBtn.addClassNames(LumoUtility.BorderRadius.LARGE);
        newCustomerBtn.setWidth(90, Unit.PERCENTAGE);

        ComboBox.ItemFilter<CustomerEntity> filter = (customer,
                                                      filterString) -> (
                customer.getFirstName() + " " + customer.getLastName())
                .toLowerCase().indexOf(filterString.toLowerCase()) > -1;

        ComboBox<CustomerEntity> comboBox = new ComboBox<>("CustomerEntity");
        comboBox.setPlaceholder("Select customer");
        comboBox.setItems(filter, this.omniService.getCustomerService().getAllCustomers());
        comboBox.setItemLabelGenerator(
                customer -> customer.getFirstName() + " " + customer.getLastName());
        comboBox.setWidth(90, Unit.PERCENTAGE);

        Button refreshBtn = new Button(
                VaadinIcon.REFRESH.create(),
                e -> comboBox.setItems(filter, this.omniService.getCustomerService().getAllCustomers()));

        HorizontalLayout searchSection = new HorizontalLayout(comboBox, refreshBtn);
        searchSection.setWidthFull();
        searchSection.setAlignItems(FlexComponent.Alignment.BASELINE);

        container.setSizeFull();

        VerticalLayout leftContainer = new VerticalLayout(leftTitle, searchSection);
        leftContainer.setAlignItems(FlexComponent.Alignment.CENTER);
        leftContainer.setHeightFull();
        leftContainer.setWidth(50, Unit.PERCENTAGE);

        VerticalLayout rightContainer = new VerticalLayout(rightTitle, newCustomerBtn);
        rightContainer.setAlignItems(FlexComponent.Alignment.CENTER);
        rightContainer.setHeightFull();
        rightContainer.setWidth(50, Unit.PERCENTAGE);

        SplitLayout splitLayout = new SplitLayout(leftContainer, rightContainer);
        splitLayout.setSizeFull();

        Button nextSectionBtn = new Button("Go on", VaadinIcon.ARROW_RIGHT.create(), e -> this.itemsSelection());
        nextSectionBtn.addClassName(LumoUtility.Margin.Left.AUTO);
        nextSectionBtn.getStyle().set("color", "#5D60EF");
        nextSectionBtn.setEnabled(false);

        container.add(splitLayout, nextSectionBtn);

        return container;
    }

    private void itemsSelection() {

    }
}
