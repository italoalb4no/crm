package com.italoalbano.crm.application.components;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;

public class AddressForm extends FormLayout {

    private TextField firstAddressLine;
    private TextField secondAddressLine;
    private TextField cityField;
    private TextField regionField;
    private TextField provinceField;
    private TextField zipCodeField;
    private TextField countryField;
    private FormLayout formLayout;

    public AddressForm() {
        super();
        this.firstAddressLine = new TextField("First address line (required)");
        this.firstAddressLine.setRequired(true);
        this.secondAddressLine = new TextField("Second address line");
        this.provinceField = new TextField("Province (required)");
        this.provinceField.setRequired(true);
        this.cityField = new TextField("City (required)");
        this.cityField.setRequired(true);
        this.regionField = new TextField("Region (required)");
        this.regionField.setRequired(true);
        this.zipCodeField = new TextField("Zip or postal code (required)");
        this.zipCodeField.setRequired(true);
        this.countryField = new TextField("Country (required)");
        this.countryField.setRequired(true);
        this.add(
                this.firstAddressLine, this.secondAddressLine, this.regionField, this.cityField, this.provinceField, this.zipCodeField, this.countryField);
        this.setResponsiveSteps(
                // Use one column by default
                new ResponsiveStep("0", 1),
                // Use two columns, if layout's width exceeds 500px
                new ResponsiveStep("500px", 2));
        // Stretch the username field over 2 columns
        this.setColspan(this.firstAddressLine, 2);
        this.setColspan(this.secondAddressLine, 2);

    }

    public TextField getFirstAddressLine() {
        return this.firstAddressLine;
    }

    public void setFirstAddressLine(TextField firstAddressLine) {
        this.firstAddressLine = firstAddressLine;
    }

    public TextField getSecondAddressLine() {
        return this.secondAddressLine;
    }

    public void setSecondAddressLine(TextField secondAddressLine) {
        this.secondAddressLine = secondAddressLine;
    }

    public TextField getCityField() {
        return this.cityField;
    }

    public void setCityField(TextField cityField) {
        this.cityField = cityField;
    }

    public TextField getRegionField() {
        return this.regionField;
    }

    public void setRegionField(TextField regionField) {
        this.regionField = regionField;
    }

    public TextField getProvinceField() {
        return this.provinceField;
    }

    public void setProvinceField(TextField provinceField) {
        this.provinceField = provinceField;
    }

    public TextField getZipCodeField() {
        return this.zipCodeField;
    }

    public void setZipCodeField(TextField zipCodeField) {
        this.zipCodeField = zipCodeField;
    }

    public TextField getCountryField() {
        return this.countryField;
    }

    public void setCountryField(TextField countryField) {
        this.countryField = countryField;
    }

    public FormLayout getFormLayout() {
        return this.formLayout;
    }

    public void setFormLayout(FormLayout formLayout) {
        this.formLayout = formLayout;
    }
}