package com.example.application.components.dialogs;

import com.example.application.data.entity.DocumentEntity;
import com.example.application.data.entity.ItemEntity;
import com.example.application.data.service.CrmService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.data.value.ValueChangeMode;
import framework.ChainedVerticalLayout;
import framework.CustomDialog;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ItemCreationDialog extends CustomDialog {

    private final CrmService crmService;
    private final ChainedVerticalLayout mainLayout;
    private final ItemEntity item;
    private Button nextSectionBtn;

    @Autowired
    public ItemCreationDialog(CrmService crmService) {
        super(
                false,
                false,
                true,
                true);
        this.crmService = crmService;
        this.setWidth(80, Unit.PERCENTAGE);
        this.setHeight(70, Unit.PERCENTAGE);

        List<String> sections = new ArrayList<>();
        sections.add("Main information");
        this.setHeader(sections);

        this.mainLayout = new ChainedVerticalLayout()
                .withSizeFull();
        this.add(this.mainLayout);

        this.item = new ItemEntity();

        this.mainInfoSection();
    }

    private void mainInfoSection() {
        this.highlightSection(0);

        this.mainLayout.removeAll();

        this.getFooter().removeAll();
        this.nextSectionBtn = new Button("Go on", VaadinIcon.ARROW_RIGHT.create());
        this.getFooter().add(this.nextSectionBtn);
        this.nextSectionBtn.setEnabled(false);

        TextField productName = new TextField("Product name");
        productName.setRequired(true);

        BigDecimalField priceField = new BigDecimalField("Price");
        priceField.setRequired(true);
        priceField.setSuffixComponent(new Div(new Text("$")));
        priceField.setWidth(50, Unit.PERCENTAGE);

        productName.addValueChangeListener(textField -> {
            if (!textField.getHasValue().isEmpty() && priceField.getValue() != null) {
                this.nextSectionBtn.setEnabled(true);
            }
        });
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

            DocumentEntity document = new DocumentEntity();
            document.setMimeType(event.getMIMEType());
            document.setSize(event.getContentLength());
            document.setName(fileName);

        });

        VerticalLayout rightContainer = new VerticalLayout(upload);
        rightContainer.setHeightFull();
        rightContainer.setWidth(50, Unit.PERCENTAGE);

        SplitLayout splitLayout = new SplitLayout(leftContainer, rightContainer);
        splitLayout.setSizeFull();

        this.mainLayout.add(splitLayout);

        this.nextSectionBtn.addClickListener(click -> {
            if (!productName.getValue().trim().isEmpty() && priceField.getValue() != null) {
                this.secondSection();
            }
        });
    }

    private void secondSection() {

    }
}
