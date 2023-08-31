package com.italoalbano.crm.application.components.dialogs;

import com.italoalbano.crm.application.data.entity.ItemEntity;
import com.italoalbano.crm.application.data.service.CrmService;
import com.italoalbano.crm.application.dto.DocumentDTO;
import com.italoalbano.framework.*;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ItemCreationDialog extends CustomDialog {

    private final CrmService crmService;
    private final ChainedVerticalLayout mainLayout;
    private final ItemEntity item;
    private HashSet<DocumentDTO> documents;
    private Button nextSectionBtn;

    @Autowired
    public ItemCreationDialog(CrmService crmService) {
        super(
                false,
                false,
                true,
                true
        );
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
        this.nextSectionBtn = new Button(
                "Go on",
                VaadinIcon.ARROW_RIGHT.create());
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
        ChainedTextArea description = new ChainedTextArea("Description")
                .withMaxLength(500)
                .withValueChangeMode(ValueChangeMode.EAGER)
                .withValueChangeListener(e -> {
                    e.getSource().setHelperText(e.getValue().length() + "/" + 500);
                });

        ChainedFormLayout formLayout = new ChainedFormLayout(
                productName,
                priceField,
                description)
                .withSizeFull();

        ChainedVerticalLayout leftContainer = new ChainedVerticalLayout(formLayout)
                .withHeightFull()
                .withWidth(50, Unit.PERCENTAGE);

        MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
        Upload upload = new Upload(buffer);
        upload.setSizeFull();

        upload.addSucceededListener(event -> {
            String fileName = event.getFileName();
            InputStream inputStream = buffer.getInputStream(fileName);

            DocumentDTO documentDTO = new DocumentDTO(
                    null,
                    fileName,
                    event.getMIMEType(),
                    null,
                    event.getContentLength(),
                    inputStream
            );

            this.documents.add(documentDTO);
        });

        ChainedHorizontalLayout documentsPreview = new ChainedHorizontalLayout()
                .withWidthFull()
                .withHeight(20, Unit.PERCENTAGE)
                .withClassNames(LumoUtility.Overflow.HIDDEN, LumoUtility.Background.CONTRAST_5);

        ChainedVerticalLayout rightContainer = new ChainedVerticalLayout(upload, documentsPreview)
                .withHeightFull()
                .withWidth(50, Unit.PERCENTAGE);

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
