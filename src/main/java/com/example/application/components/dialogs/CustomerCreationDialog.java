package com.example.application.components.dialogs;

import com.example.application.components.AddressForm;
import com.example.application.data.entity.AddressEntity;
import com.example.application.data.entity.CustomerEntity;
import com.example.application.data.service.CrmService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.theme.lumo.LumoUtility;
import framework.CustomDialog;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerCreationDialog extends CustomDialog {

    private final CrmService omniService;
    private final VerticalLayout mainLayout;
    private final CustomerEntity customer;
    private Button nextSectionBtn;
    private Button previousSectionBtn;
    private Boolean privateCustomer;

    public CustomerCreationDialog(@Autowired CrmService omniService) {
        super(false, false, true, true);
        this.omniService = omniService;
        this.setWidth(80, Unit.PERCENTAGE);
        this.setHeight(70, Unit.PERCENTAGE);

        // Top section
        HorizontalLayout topContainer = new HorizontalLayout();
        topContainer.setWidthFull();
        topContainer.setHeight("auto");

        this.mainLayout = new VerticalLayout();
        this.mainLayout.setSizeFull();
        this.add(this.mainLayout);

        this.nextSectionBtn = new Button("Go on", VaadinIcon.ARROW_RIGHT.create());
        this.nextSectionBtn.addClassNames(LumoUtility.Margin.Left.AUTO, LumoUtility.Margin.Top.AUTO);

        List<String> sections = new ArrayList<>();
        sections.add("Choose the kind of customer");
        sections.add("Main information");
        sections.add("AddressEntity information");
        sections.add("Summary");
        sections.add("Summary");
        this.setHeader(sections);

        this.customer = new CustomerEntity();

        this.firstSection();
    }

    private void firstSection() {
        // Set or reset
        this.mainLayout.removeAll();
        this.nextSectionBtn = new Button("Go on", VaadinIcon.ARROW_RIGHT.create());

        this.highlightSection(0);

        this.getFooter().removeAll();
        this.getFooter().add(this.nextSectionBtn);
        this.nextSectionBtn.setEnabled(false);
        this.nextSectionBtn.addClickListener(e -> this.secondSection());

        Button leftButton = new Button("Private or Sole Trader", VaadinIcon.USER_HEART.create());
        leftButton.getStyle().set("background", "grey").set("color", "white").set("padding", "2.5em");
        leftButton.setWidth(90, Unit.PERCENTAGE);
        leftButton.addClassNames(LumoUtility.BorderRadius.LARGE, LumoUtility.Margin.Top.AUTO);

        Button rightButton = new Button("Company", VaadinIcon.BUILDING.create());
        rightButton.getStyle().set("background", "grey").set("color", "white").set("padding", "2.5em");
        rightButton.setWidth(90, Unit.PERCENTAGE);
        rightButton.addClassNames(LumoUtility.BorderRadius.LARGE, LumoUtility.Margin.Top.AUTO);

        leftButton.addClickListener(e -> {
            leftButton.getStyle().set("background", "#5D60EF");
            rightButton.getStyle().set("background", "grey");
            this.nextSectionBtn.setEnabled(true);
            this.privateCustomer = true;
        });
        rightButton.addClickListener(e -> {
            rightButton.getStyle().set("background", "#5D60EF");
            leftButton.getStyle().set("background", "grey");
            this.nextSectionBtn.setEnabled(true);
            this.privateCustomer = false;
        });

        Details leftDetails = new Details(
                new Span("About private customers"),
                new Text("A private customer includes any kind of customer that does not represent a Limited Company")
        );
        leftDetails.setWidth(90, Unit.PERCENTAGE);
        leftDetails.setOpened(true);

        Details rightDetails = new Details(
                new Span("About companies"),
                new Text("A company is a legal entity representing an association of people, whether natural, legal or a mixture of both, with a specific objective")
        );
        rightDetails.setWidth(90, Unit.PERCENTAGE);
        rightDetails.setOpened(true);

        VerticalLayout leftSection = new VerticalLayout(
                leftDetails,
                leftButton);
        leftSection.setHeightFull();

        VerticalLayout rightSection = new VerticalLayout(
                rightDetails,
                rightButton);
        rightSection.setHeightFull();

        HorizontalLayout kindSelector = new HorizontalLayout(leftSection, rightSection);
        kindSelector.setSizeFull();
        kindSelector.setAlignItems(FlexComponent.Alignment.CENTER);
        kindSelector.setPadding(true);

        this.mainLayout.add(kindSelector);
    }

    private void secondSection() {

        this.highlightSection(1);

        this.mainLayout.removeAll();
        this.previousSectionBtn = new Button("Go back", VaadinIcon.ARROW_LEFT.create());
        this.previousSectionBtn.addClickListener(e -> this.firstSection());
        this.previousSectionBtn.addClassName(LumoUtility.Margin.Right.AUTO);
        this.getFooter().removeAll();
        this.getFooter().add(this.previousSectionBtn);

        if (this.privateCustomer != null) {
            if (this.privateCustomer) {

                TextField firstNameField = new TextField("First name (required)");
                firstNameField.setRequired(true);
                TextField lastNameField = new TextField("Last name (required)");
                lastNameField.setRequired(true);
                DatePicker dateOfBirth = new DatePicker("Date of birth");
                dateOfBirth.setMax(LocalDate.now());
                EmailField emailField = new EmailField("Email AddressEntity (required)");
                emailField.setRequiredIndicatorVisible(true);
                TextField mobilePhoneField = new TextField("Mobile Phone Number (required)");
                mobilePhoneField.setRequired(true);
                TextField landlinePhoneField = new TextField("Landline Phone Number");
                TextField fiscalCodeField = new TextField("Fiscal code");
                TextField vatNumberField = new TextField("VAT number");

                // Re-populate values if already inserted previously
                if (this.customer.getEmail() != null) {
                    dateOfBirth.setValue(this.customer.getDateOfBirth());
                    emailField.setValue(this.customer.getEmail());
                    firstNameField.setValue(this.customer.getFirstName());
                    lastNameField.setValue(this.customer.getLastName());
                    fiscalCodeField.setValue(this.customer.getFiscalCode());
                    vatNumberField.setValue(this.customer.getVatNumber());
                    mobilePhoneField.setValue(this.customer.getMobileNumber());
                    landlinePhoneField.setValue(this.customer.getLandlineNumber());
                }

                FormLayout formLayout = new FormLayout();
                formLayout.add(
                        firstNameField, lastNameField, dateOfBirth, emailField, fiscalCodeField, landlinePhoneField, mobilePhoneField, vatNumberField);
                formLayout.setResponsiveSteps(
                        // Use one column by default
                        new FormLayout.ResponsiveStep("0", 1),
                        // Use two columns, if layout's width exceeds 500px
                        new FormLayout.ResponsiveStep("500px", 3));
                // Stretch the username field over 2 columns
                formLayout.setColspan(emailField, 2);

                dateOfBirth.addInvalidChangeListener(e -> this.showError("Enter a valid date"));
                this.nextSectionBtn = new Button("Go on", VaadinIcon.ARROW_RIGHT.create());
                this.nextSectionBtn.addClickListener(e -> {
                    if (!firstNameField.isEmpty() && !firstNameField.isInvalid()
                            && !lastNameField.isEmpty() && !lastNameField.isInvalid()
                            && !mobilePhoneField.isEmpty() && !mobilePhoneField.isInvalid()
                            && !emailField.isEmpty() && !emailField.isInvalid()) {
                        // Check if the email has already been set previously
                        // And if the user has already inserted this email
                        // there is no need to launch another query
                        if (!this.omniService.getCustomerService().isEmailAddressAlreadyRegistered(emailField.getValue())) {

                            this.customer.setPrivateCustomer(true);
                            this.customer.setCreationDate(LocalDate.now());
                            this.customer.setDateOfBirth(dateOfBirth.getValue());
                            this.customer.setEmail(emailField.getValue());
                            this.customer.setFirstName(firstNameField.getValue());
                            this.customer.setLastName(lastNameField.getValue());
                            this.customer.setEmail(emailField.getValue());
                            this.customer.setFiscalCode(fiscalCodeField.getValue());
                            this.customer.setVatNumber(vatNumberField.getValue());
                            this.customer.setMobileNumber(mobilePhoneField.getValue());
                            this.customer.setLandlineNumber(landlinePhoneField.getValue());

                            this.thirdSection();
                        } else {
                            this.showError("Email address already registered");
                        }
                    } else {
                        this.showError("Insert valid data for all required fields");
                    }
                });
                this.getFooter().add(this.nextSectionBtn);
                this.mainLayout.add(formLayout);

            } else {
                // Form for Limited companies

            }
        }

    }

    private void thirdSection() {
        this.highlightSection(2);

        this.mainLayout.removeAll();
        this.previousSectionBtn = new Button("Go back", VaadinIcon.ARROW_LEFT.create());
        this.previousSectionBtn.addClickListener(e -> this.secondSection());
        this.previousSectionBtn.addClassName(LumoUtility.Margin.Right.AUTO);
        this.getFooter().removeAll();
        this.getFooter().add(this.previousSectionBtn);

        if (this.privateCustomer != null) {
            if (this.privateCustomer) {

                AddressForm domicileFormLayout = new AddressForm();
                AddressForm residenceFormLayout = new AddressForm();

                Details domicileDetails = new Details("Domicile", domicileFormLayout);
                domicileDetails.setOpened(true);
                domicileDetails.setHeight("auto");

                Details residenceDetails = new Details("Residence", residenceFormLayout);
                residenceDetails.setOpened(false);

                Checkbox singularAddress = new Checkbox("Residential address coincides with the domicile");
                singularAddress.addValueChangeListener(e -> residenceDetails.setEnabled(!e.getValue()));

                this.mainLayout.add(domicileDetails, singularAddress, residenceDetails);

                this.nextSectionBtn = new Button("Go on", VaadinIcon.ARROW_RIGHT.create());
                this.nextSectionBtn.addClickListener(e -> {
                    if (domicileFormLayout.getFirstAddressLine().isInvalid() ||
                            domicileFormLayout.getFirstAddressLine().isEmpty() ||
                            domicileFormLayout.getRegionField().isInvalid() ||
                            domicileFormLayout.getRegionField().isEmpty() ||
                            domicileFormLayout.getProvinceField().isInvalid() ||
                            domicileFormLayout.getProvinceField().isEmpty() ||
                            domicileFormLayout.getCityField().isInvalid() ||
                            domicileFormLayout.getCityField().isEmpty() ||
                            domicileFormLayout.getZipCodeField().isInvalid() ||
                            domicileFormLayout.getZipCodeField().isEmpty() ||
                            domicileFormLayout.getCountryField().isInvalid() ||
                            domicileFormLayout.getCountryField().isEmpty()
                    ) {
                        this.showError("Insert valid data for all required fields about your domicile");
                    } else {
                        // Domicile has been put correctly
                        AddressEntity domicile = new AddressEntity();
                        domicile.setCity(domicileFormLayout.getCityField().getValue());
                        domicile.setCountry(domicileFormLayout.getCountryField().getValue());
                        domicile.setRegion(domicileFormLayout.getRegionField().getValue());
                        domicile.setProvince(domicileFormLayout.getProvinceField().getValue());
                        domicile.setFirstAddressLine(domicileFormLayout.getFirstAddressLine().getValue());
                        domicile.setSecondAddressLine(domicileFormLayout.getSecondAddressLine().getValue());
                        domicile.setZipCode(domicileFormLayout.getZipCodeField().getValue());

                        this.customer.setDomicile(domicile);

                        if (residenceDetails.isEnabled()) {
                            if (residenceFormLayout.getFirstAddressLine().isInvalid() ||
                                    residenceFormLayout.getFirstAddressLine().isEmpty() ||
                                    residenceFormLayout.getRegionField().isInvalid() ||
                                    residenceFormLayout.getRegionField().isEmpty() ||
                                    residenceFormLayout.getProvinceField().isInvalid() ||
                                    residenceFormLayout.getProvinceField().isEmpty() ||
                                    residenceFormLayout.getCityField().isInvalid() ||
                                    residenceFormLayout.getCityField().isEmpty() ||
                                    residenceFormLayout.getZipCodeField().isInvalid() ||
                                    residenceFormLayout.getZipCodeField().isEmpty() ||
                                    residenceFormLayout.getCountryField().isInvalid() ||
                                    residenceFormLayout.getCountryField().isEmpty()
                            ) {
                                this.showError("Insert valid data for all required fields about your residence");
                            } else {
                                AddressEntity residence = new AddressEntity();
                                residence.setCity(residenceFormLayout.getCityField().getValue());
                                residence.setCountry(residenceFormLayout.getCountryField().getValue());
                                residence.setRegion(residenceFormLayout.getRegionField().getValue());
                                residence.setProvince(residenceFormLayout.getProvinceField().getValue());
                                residence.setFirstAddressLine(residenceFormLayout.getFirstAddressLine().getValue());
                                residence.setSecondAddressLine(residenceFormLayout.getSecondAddressLine().getValue());
                                residence.setZipCode(residenceFormLayout.getZipCodeField().getValue());

                                this.customer.setResidence(residence);
                                this.fourthSection();
                            }
                        } else {

                            AddressEntity residence = new AddressEntity(this.customer.getDomicile());
                            this.customer.setResidence(residence);

                            this.fourthSection();
                        }
                    }
                });
                this.getFooter().add(this.nextSectionBtn);

                if (this.customer.getDomicile() != null) {
                    domicileFormLayout.getFirstAddressLine()
                            .setValue(this.customer.getDomicile().getFirstAddressLine());
                    domicileFormLayout.getSecondAddressLine()
                            .setValue(this.customer.getDomicile().getSecondAddressLine());
                    domicileFormLayout.getRegionField()
                            .setValue(this.customer.getDomicile().getRegion());
                    domicileFormLayout.getCountryField()
                            .setValue(this.customer.getDomicile().getCountry());
                    domicileFormLayout.getZipCodeField()
                            .setValue(this.customer.getDomicile().getZipCode());
                    domicileFormLayout.getCityField()
                            .setValue(this.customer.getDomicile().getCity());
                    domicileFormLayout.getProvinceField()
                            .setValue(this.customer.getDomicile().getProvince());

                    if (!this.customer.getDomicile().getId().equals(this.customer.getResidence().getId())) {
                        residenceFormLayout.getFirstAddressLine()
                                .setValue(this.customer.getResidence().getFirstAddressLine());
                        residenceFormLayout.getSecondAddressLine()
                                .setValue(this.customer.getResidence().getSecondAddressLine());
                        residenceFormLayout.getRegionField()
                                .setValue(this.customer.getResidence().getRegion());
                        residenceFormLayout.getCountryField()
                                .setValue(this.customer.getResidence().getCountry());
                        residenceFormLayout.getZipCodeField()
                                .setValue(this.customer.getResidence().getZipCode());
                        residenceFormLayout.getCityField()
                                .setValue(this.customer.getResidence().getCity());
                    } else {
                        singularAddress.setEnabled(true);
                        singularAddress.setValue(true);
                    }
                }

            } else {
                // Company
            }
        }
    }

    private void fourthSection() {
        this.highlightSection(3);

        this.mainLayout.removeAll();
        this.previousSectionBtn = new Button("Go back", VaadinIcon.ARROW_LEFT.create());
        this.previousSectionBtn.addClickListener(e -> this.thirdSection());
        this.previousSectionBtn.addClassName(LumoUtility.Margin.Right.AUTO);
        this.getFooter().removeAll();
        this.getFooter().add(this.previousSectionBtn);

        if (this.privateCustomer) {
            Span firstName = this.createSpan(
                    "First name: ",
                    this.customer.getFirstName());
            Span lastName = this.createSpan(
                    "Last name: ",
                    this.customer.getLastName());
            Span dateOfBirth = this.createSpan(
                    "Date of birth: ",
                    (this.customer.getDateOfBirth() == null ?
                            "Not provided" :
                            this.customer.getDateOfBirth().toString()));
            Span email = this.createSpan(
                    "Email: ",
                    this.customer.getEmail());
            Span landlineNumber = this.createSpan(
                    "Landline number: ",
                    (this.customer.getLandlineNumber().isEmpty() ?
                            "Not provided" :
                            this.customer.getLandlineNumber()));
            Span mobileNumber = this.createSpan(
                    "Mobile number: ",
                    this.customer.getMobileNumber());
            Span fiscalCode = this.createSpan(
                    "Fiscal Code: ",
                    (this.customer.getFiscalCode().isEmpty() ?
                            "Not provided" :
                            this.customer.getFiscalCode()));
            Span vatNumber = this.createSpan(
                    "VAT number: ",
                    (this.customer.getVatNumber().isEmpty() ?
                            "Not provided" :
                            this.customer.getVatNumber()));

            FormLayout mainInfoForm = new FormLayout(
                    firstName,
                    lastName,
                    dateOfBirth,
                    email,
                    landlineNumber,
                    mobileNumber,
                    fiscalCode,
                    vatNumber);
            mainInfoForm.setWidthFull();
            mainInfoForm.addClassName(LumoUtility.Padding.LARGE);

            Span domicileFirstAddressLine = this.createSpan(
                    "First address line: ",
                    this.customer.getDomicile().getFirstAddressLine());
            Span domicileSecondAddressLine = this.createSpan(
                    "Last address line: ",
                    this.customer.getDomicile().getSecondAddressLine());
            Span domicileRegion = this.createSpan(
                    "Region: ",
                    this.customer.getDomicile().getRegion());
            Span domicileProvince = this.createSpan(
                    "Province: ",
                    this.customer.getDomicile().getProvince());
            Span domicileCity = this.createSpan(
                    "City: ",
                    this.customer.getDomicile().getCity());
            Span domicileZipCode = this.createSpan(
                    "Zip Code: ",
                    this.customer.getDomicile().getZipCode());

            FormLayout domicileForm = new FormLayout(
                    domicileFirstAddressLine,
                    domicileSecondAddressLine,
                    domicileRegion,
                    domicileProvince,
                    domicileCity,
                    domicileZipCode);
            domicileForm.setWidthFull();
            domicileForm.addClassName(LumoUtility.Padding.LARGE);

            Span residenceFirstAddressLine = this.createSpan(
                    "First address line: ",
                    this.customer.getResidence().getFirstAddressLine());
            Span residenceSecondAddressLine = this.createSpan(
                    "Last address line: ",
                    this.customer.getResidence().getSecondAddressLine());
            Span residenceRegion = this.createSpan(
                    "Region: ",
                    this.customer.getResidence().getRegion());
            Span residenceProvince = this.createSpan(
                    "Province: ",
                    this.customer.getResidence().getProvince());
            Span residenceCity = this.createSpan(
                    "City: ",
                    this.customer.getResidence().getCity());
            Span residenceZipCode = this.createSpan(
                    "Zip Code: ",
                    this.customer.getResidence().getZipCode());

            FormLayout residenceForm = new FormLayout(
                    residenceFirstAddressLine,
                    residenceSecondAddressLine,
                    residenceRegion,
                    residenceProvince,
                    residenceCity,
                    residenceZipCode);
            residenceForm.setWidthFull();
            residenceForm.addClassName(LumoUtility.Padding.LARGE);

            Details domicileDetails = new Details("Domicile", domicileForm);
            Details residenceDetails = new Details("Residence", residenceForm);

            Span mainInfoBadge = new Span("Main Information");
            mainInfoBadge.getElement().getThemeList().add("badge primary");
            mainInfoBadge.addClassName(LumoUtility.FontSize.LARGE);
            Span addressBadge = new Span("Residence and domicile");
            addressBadge.getElement().getThemeList().add("badge primary");
            addressBadge.addClassName(LumoUtility.FontSize.LARGE);

            Details mainInfoDetails = new Details(mainInfoBadge, mainInfoForm);
            mainInfoDetails.setWidth(90, Unit.PERCENTAGE);
            mainInfoDetails.setOpened(true);
            Details addressDetails = new Details(addressBadge, domicileDetails, residenceDetails);
            addressDetails.setWidth(90, Unit.PERCENTAGE);
            addressDetails.setOpened(true);

            this.mainLayout.add(mainInfoDetails, addressDetails);

            Button confirmBtn = new Button(
                    "Confirm",
                    VaadinIcon.ARROW_RIGHT.create(),
                    e -> this.confirmation());
            confirmBtn.addClassName(LumoUtility.Margin.Left.AUTO);
            this.getFooter().add(confirmBtn);
        }
    }

    private void confirmation() {
        this.mainLayout.removeAll();
        this.getHeader().removeAll();
        this.getFooter().removeAll();

        if (this.privateCustomer) {

            if (!this.customer.getDomicile().getId().equals(this.customer.getResidence().getId())) {
                // If domicile id doesn't equal to the residence id
                // then i need to store the residence address in DB
                // but only if it's not already in the DB
                if (!this.omniService.getAddressService().isAddressAlreadyRegistered(
                        this.customer.getResidence().getFirstAddressLine(),
                        this.customer.getResidence().getZipCode())) {
                    try {
                        this.omniService.getAddressService().createAddress(this.customer.getResidence());
                    } catch (Exception ex) {
                        this.showError("The address couldn't be created");
                    }
                }
            }

            if (!this.omniService.getAddressService().isAddressAlreadyRegistered(
                    this.customer.getDomicile().getFirstAddressLine(),
                    this.customer.getDomicile().getZipCode())) {
                try {
                    this.omniService.getAddressService().createAddress(this.customer.getDomicile());
                } catch (Exception ex) {
                    this.showError("The address couldn't be created");
                }
            }

            try {
                this.omniService.getCustomerService().createCustomer(this.customer);
            } catch (Exception ex) {
                this.showError("The customer couldn't be created");
            }

        } else {
            // TODO add address of the company
        }

        Notification notification = Notification.show("CustomerEntity registered correctly");
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        this.close();
    }

    private Span createSpan(String label, String info) {
        Span spanLabel = new Span(label);
        spanLabel.getElement().getThemeList().add("badge large");

        Span span = new Span(spanLabel, new Text(" " + info));
        span.addClassName(LumoUtility.FontWeight.BOLD);
        return span;
    }

    private void showError(String error) {
        Notification notification = Notification.show(error);
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
    }

}
