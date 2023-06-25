package framework;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.textfield.Autocapitalize;
import com.vaadin.flow.component.textfield.Autocomplete;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

public class ChainedTextField extends TextField {

    public TextField ChainedTextField(
            String label,
            String initialValue,
            String placeholder) {
        return new TextField(label, initialValue, placeholder);
    }

    public TextField ChainedTextField(ValueChangeListener<? super ComponentValueChangeEvent<TextField, String>> listener) {
        return new TextField(listener);
    }

    public TextField ChainedTextField(String label, ValueChangeListener<? super ComponentValueChangeEvent<TextField, String>> listener) {
        return new TextField(label, listener);
    }

    public TextField ChainedTextField(String label, String initialValue, ValueChangeListener<? super ComponentValueChangeEvent<TextField, String>> listener) {
        return new TextField(label, initialValue, listener);
    }

    public TextField ChainedTextField() {
        return new TextField();
    }

    public TextField ChainedTextField(String label) {
        return new TextField(label);
    }

    public TextField ChainedTextField(String label, String placeholder) {
        return new TextField(label, placeholder);
    }

    public ChainedTextField withMaxLength(int maxLength) {
        super.setMaxLength(maxLength);
        return this;
    }

    public ChainedTextField withMinLength(int minLength) {
        super.setMinLength(minLength);
        return this;
    }

    public ChainedTextField withRequired(boolean required) {
        super.setRequired(required);
        return this;
    }

    public ChainedTextField withPattern(String pattern) {
        super.setPattern(pattern);
        return this;
    }

    public ChainedTextField withValue(String value) {
        super.setValue(value);
        return this;
    }

    public ChainedTextField withRequiredIndicatorVisible(boolean requiredIndicatorVisible) {
        super.setRequiredIndicatorVisible(requiredIndicatorVisible);
        return this;
    }

    public ChainedTextField withThemeName(String themeName) {
        super.setThemeName(themeName);
        return this;
    }

    public ChainedTextField withThemeName(String themeName, boolean set) {
        super.setThemeName(themeName, set);
        return this;
    }

    public ChainedTextField withAllowedCharPattern(String pattern) {
        super.setAllowedCharPattern(pattern);
        return this;
    }

    public ChainedTextField withValueChangeMode(ValueChangeMode valueChangeMode) {
        super.setValueChangeMode(valueChangeMode);
        return this;
    }

    public ChainedTextField withValueChangeTimeout(int valueChangeTimeout) {
        super.setValueChangeTimeout(valueChangeTimeout);
        return this;
    }

    public ChainedTextField withPlaceholder(String placeholder) {
        super.setPlaceholder(placeholder);
        return this;
    }

    public ChainedTextField withAutofocus(boolean autofocus) {
        super.setAutofocus(autofocus);
        return this;
    }

    public ChainedTextField withTitle(String title) {
        super.setTitle(title);
        return this;
    }

    public ChainedTextField withAutoselect(boolean autoselect) {
        super.setAutoselect(autoselect);
        return this;
    }

    public ChainedTextField withValueChangeListener(ValueChangeListener<? super ComponentValueChangeEvent<TextField, String>> listener) {
        super.addValueChangeListener(listener);
        return this;
    }

    protected <T extends ComponentEvent<?>> ChainedTextField withListener(Class<T> eventType, ComponentEventListener<T> listener) {
        super.addListener(eventType, listener);
        return this;
    }

    public ChainedTextField withId(String id) {
        super.setId(id);
        return this;
    }

    protected <T> ChainedTextField with(PropertyDescriptor<T, ?> descriptor, T value) {
        super.set(descriptor, value);
        return this;
    }

    public ChainedTextField withVisible(boolean visible) {
        super.setVisible(visible);
        return this;
    }

    public ChainedTextField withAttachListener(ComponentEventListener<AttachEvent> listener) {
        super.addAttachListener(listener);
        return this;
    }

    public ChainedTextField withCompositionStartListener(ComponentEventListener<CompositionStartEvent> listener) {
        super.addCompositionStartListener(listener);
        return this;
    }

    public ChainedTextField withCompositionUpdateListener(ComponentEventListener<CompositionUpdateEvent> listener) {
        super.addCompositionUpdateListener(listener);
        return this;
    }

    public ChainedTextField withCompositionEndListener(ComponentEventListener<CompositionEndEvent> listener) {
        super.addCompositionEndListener(listener);
        return this;
    }

    public ChainedTextField withDetachListener(ComponentEventListener<DetachEvent> listener) {
        super.addDetachListener(listener);
        return this;
    }

    public ChainedTextField withTabIndex(int tabIndex) {
        super.setTabIndex(tabIndex);
        return this;
    }

    public ChainedTextField withFocusShortcut(Key key, KeyModifier... keyModifiers) {
        super.addFocusShortcut(key, keyModifiers);
        return this;
    }

    public ChainedTextField withFocusListener(ComponentEventListener<FocusEvent<TextField>> listener) {
        super.addFocusListener(listener);
        return this;
    }

    public ChainedTextField withEnabled(boolean enabled) {
        super.setEnabled(enabled);
        return this;
    }

    public ChainedTextField withHelperText(String helperText) {
        super.setHelperText(helperText);
        return this;
    }

    public ChainedTextField withHelperComponent(Component component) {
        super.setHelperComponent(component);
        return this;
    }

    public ChainedTextField withLabel(String label) {
        super.setLabel(label);
        return this;
    }

    public ChainedTextField withWidth(String width) {
        super.setWidth(width);
        return this;
    }

    public ChainedTextField withWidth(float width, Unit unit) {
        super.setWidth(width, unit);
        return this;
    }

    public ChainedTextField withMinWidth(String minWidth) {
        super.setMinWidth(minWidth);
        return this;
    }

    public ChainedTextField withMinWidth(float minWidth, Unit unit) {
        super.setMinWidth(minWidth, unit);
        return this;
    }

    public ChainedTextField withMaxWidth(String maxWidth) {
        super.setMaxWidth(maxWidth);
        return this;
    }

    public ChainedTextField withMaxWidth(float maxWidth, Unit unit) {
        super.setMaxWidth(maxWidth, unit);
        return this;
    }

    public ChainedTextField withHeight(String height) {
        super.setHeight(height);
        return this;
    }

    public ChainedTextField withHeight(float height, Unit unit) {
        super.setHeight(height, unit);
        return this;
    }

    public ChainedTextField withMinHeight(String minHeight) {
        super.setMinHeight(minHeight);
        return this;
    }

    public ChainedTextField withMinHeight(float minHeight, Unit unit) {
        super.setMinHeight(minHeight, unit);
        return this;
    }

    public ChainedTextField withMaxHeight(String maxHeight) {
        super.setMaxHeight(maxHeight);
        return this;
    }

    public ChainedTextField withMaxHeight(float maxHeight, Unit unit) {
        super.setMaxHeight(maxHeight, unit);
        return this;
    }

    public ChainedTextField withSizeFull() {
        super.setSizeFull();
        return this;
    }

    public ChainedTextField withWidthFull() {
        super.setWidthFull();
        return this;
    }

    public ChainedTextField withHeightFull() {
        super.setHeightFull();
        return this;
    }

    public ChainedTextField withSizeUndefined() {
        super.setSizeUndefined();
        return this;
    }

    public ChainedTextField withClassName(String className) {
        super.setClassName(className);
        return this;
    }

    public ChainedTextField withClassName(String className, boolean set) {
        super.setClassName(className, set);
        return this;
    }

    public ChainedTextField withReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        return this;
    }

    public ChainedTextField withInputListener(ComponentEventListener<InputEvent> listener) {
        super.addInputListener(listener);
        return this;
    }

    public ChainedTextField withKeyDownListener(ComponentEventListener<KeyDownEvent> listener) {
        super.addKeyDownListener(listener);
        return this;
    }

    public ChainedTextField withKeyPressListener(ComponentEventListener<KeyPressEvent> listener) {
        super.addKeyPressListener(listener);
        return this;
    }

    public ChainedTextField withKeyUpListener(ComponentEventListener<KeyUpEvent> listener) {
        super.addKeyUpListener(listener);
        return this;
    }

    public ChainedTextField withKeyDownListener(
            Key key,
            ComponentEventListener<KeyDownEvent> listener,
            KeyModifier... modifiers) {
        super.addKeyDownListener(key, listener, modifiers);
        return this;
    }

    public ChainedTextField withKeyPressListener(
            Key key,
            ComponentEventListener<KeyPressEvent> listener,
            KeyModifier... modifiers) {
        super.addKeyPressListener(key, listener, modifiers);
        return this;
    }

    public ChainedTextField withKeyUpListener(Key key, ComponentEventListener<KeyUpEvent> listener, KeyModifier... modifiers) {
        super.addKeyUpListener(key, listener, modifiers);
        return this;
    }

    public ChainedTextField withClearButtonVisible(boolean clearButtonVisible) {
        super.setClearButtonVisible(clearButtonVisible);
        return this;
    }

    public ChainedTextField withClientValidatedEventListener(ComponentEventListener<ClientValidatedEvent> listener) {
        super.addClientValidatedEventListener(listener);
        return this;
    }

    public ChainedTextField withPrefixComponent(Component component) {
        super.setPrefixComponent(component);
        return this;
    }

    public ChainedTextField withSuffixComponent(Component component) {
        super.setSuffixComponent(component);
        return this;
    }

    public ChainedTextField withTooltipText(String text) {
        super.setTooltipText(text);
        return this;
    }

    public ChainedTextField withErrorMessage(String errorMessage) {
        super.setErrorMessage(errorMessage);
        return this;
    }

    public ChainedTextField withInvalid(boolean invalid) {
        super.setInvalid(invalid);
        return this;
    }

    public ChainedTextField withAutocapitalize(Autocapitalize autocapitalize) {
        super.setAutocapitalize(autocapitalize);
        return this;
    }

    public ChainedTextField withAutocomplete(Autocomplete autocomplete) {
        super.setAutocomplete(autocomplete);
        return this;
    }

    public ChainedTextField withAutocorrect(boolean autocorrect) {
        super.setAutocorrect(autocorrect);
        return this;
    }
}
