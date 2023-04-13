package com.example.application.components.dialogs;

import com.example.application.data.service.CrmService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.data.value.ValueChangeMode;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class NewItemDialog extends CustomDialog {

    private final CrmService omniService;

    private final VerticalLayout mainLayout;
    private Button nextSectionBtn;

    public NewItemDialog(@Autowired CrmService omniService) {
        super(false, false, true, true);
        this.omniService = omniService;
        this.setWidth(80, Unit.PERCENTAGE);
        this.setHeight(70, Unit.PERCENTAGE);

        List<String> sections = new ArrayList<>();
        sections.add("Main information");
        this.setHeader(sections);

        this.mainLayout = new VerticalLayout();
        this.mainLayout.setSizeFull();
        this.add(this.mainLayout);

        this.mainInfoSection();
    }

    private void mainInfoSection() {
        this.highlightSection(1);

        this.mainLayout.removeAll();

        this.getFooter().removeAll();
        this.nextSectionBtn = new Button("Go on", VaadinIcon.ARROW_RIGHT.create());
        this.getFooter().add(this.nextSectionBtn);
        this.nextSectionBtn.setEnabled(false);
        this.nextSectionBtn.addClickListener(e -> this.secondSection());

        TextField productName = new TextField("Product name");
        BigDecimalField priceField = new BigDecimalField("Price");
        priceField.setSuffixComponent(new Text("$"));
        priceField.setWidth(50, Unit.PERCENTAGE);
        TextArea description = new TextArea("Description");

        description.setMaxLength(500);
        description.setValueChangeMode(ValueChangeMode.EAGER);
        description.addValueChangeListener(e -> {
            e.getSource()
                    .setHelperText(e.getValue().length() + "/" + 500);
        });

        FormLayout formLayout = new FormLayout(productName, priceField, description);
        // formLayout.setColspan(priceField, 1);
        formLayout.setSizeFull();

        VerticalLayout leftContainer = new VerticalLayout(formLayout);
        leftContainer.setHeightFull();
        leftContainer.setWidth(50, Unit.PERCENTAGE);

        MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
        Upload upload = new Upload(buffer);
        upload.setSizeFull();

        upload.addSucceededListener(event -> {
            String fileName = event.getFileName();
            InputStream inputStream = buffer.getInputStream(fileName);

            // Do something with the file data
            // processFile(inputStream, fileName);
        });

        VerticalLayout rightContainer = new VerticalLayout(upload);
        rightContainer.setHeightFull();
        rightContainer.setWidth(50, Unit.PERCENTAGE);

        SplitLayout splitLayout = new SplitLayout(leftContainer, rightContainer);
        splitLayout.setSizeFull();

        this.mainLayout.add(splitLayout);

    }

    private void secondSection() {

    }
}
