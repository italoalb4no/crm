package framework;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.textfield.Autocapitalize;
import com.vaadin.flow.component.textfield.Autocomplete;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.value.ValueChangeMode;

public class ChainedTextArea extends TextArea {

    public TextArea ChainedTextArea(String label, String initialValue, String placeholder) {
        return new TextArea(label, initialValue, placeholder);
    }

    public TextArea ChainedTextArea(ValueChangeListener<? super ComponentValueChangeEvent<TextArea, String>> listener) {
        return new TextArea(listener);
    }

    public TextArea ChainedTextArea(String label, ValueChangeListener<? super ComponentValueChangeEvent<TextArea, String>> listener) {
        return new TextArea(label, listener);
    }

    public TextArea ChainedTextArea(String label, String initialValue, ValueChangeListener<? super ComponentValueChangeEvent<TextArea, String>> listener) {
        return new TextArea(label, initialValue, listener);
    }

    public TextArea ChainedTextArea() {
        return new TextArea();
    }

    public TextArea ChainedTextArea(String label) {
        return new TextArea(label);
    }

    public TextArea ChainedTextArea(String label, String placeholder) {
        return new TextArea(label, placeholder);
    }

    public ChainedTextArea withMaxLength(int maxLength) {
        super.setMaxLength(maxLength);
        return this;
    }

    public ChainedTextArea withMinLength(int minLength) {
        super.setMinLength(minLength);
        return this;
    }

    public ChainedTextArea withRequired(boolean required) {
        super.setRequired(required);
        return this;
    }

    public ChainedTextArea withPattern(String pattern) {
        super.setPattern(pattern);
        return this;
    }

    public ChainedTextArea withValue(String value) {
        super.setValue(value);
        return this;
    }

    public ChainedTextArea withRequiredIndicatorVisible(boolean requiredIndicatorVisible) {
        super.setRequiredIndicatorVisible(requiredIndicatorVisible);
        return this;
    }

    public ChainedTextArea withThemeName(String themeName) {
        super.setThemeName(themeName);
        return this;
    }

    public ChainedTextArea withThemeName(String themeName, boolean set) {
        super.setThemeName(themeName, set);
        return this;
    }

    public ChainedTextArea withAllowedCharPattern(String pattern) {
        super.setAllowedCharPattern(pattern);
        return this;
    }

    public ChainedTextArea withValueChangeMode(ValueChangeMode valueChangeMode) {
        super.setValueChangeMode(valueChangeMode);
        return this;
    }

    public ChainedTextArea withValueChangeTimeout(int valueChangeTimeout) {
        super.setValueChangeTimeout(valueChangeTimeout);
        return this;
    }

    public ChainedTextArea withPlaceholder(String placeholder) {
        super.setPlaceholder(placeholder);
        return this;
    }

    public ChainedTextArea withAutofocus(boolean autofocus) {
        super.setAutofocus(autofocus);
        return this;
    }

    public ChainedTextArea withTitle(String title) {
        super.setTitle(title);
        return this;
    }

    public ChainedTextArea withAutoselect(boolean autoselect) {
        super.setAutoselect(autoselect);
        return this;
    }

    public ChainedTextArea withValueChangeListener(ValueChangeListener<? super ComponentValueChangeEvent<TextArea, String>> listener) {
        super.addValueChangeListener(listener);
        return this;
    }

    protected <T extends ComponentEvent<?>> ChainedTextArea withListener(Class<T> eventType, ComponentEventListener<T> listener) {
        super.addListener(eventType, listener);
        return this;
    }

    public ChainedTextArea withId(String id) {
        super.setId(id);
        return this;
    }

    protected <T> ChainedTextArea with(PropertyDescriptor<T, ?> descriptor, T value) {
        super.set(descriptor, value);
        return this;
    }

    public ChainedTextArea withVisible(boolean visible) {
        super.setVisible(visible);
        return this;
    }

    public ChainedTextArea withAttachListener(ComponentEventListener<AttachEvent> listener) {
        super.addAttachListener(listener);
        return this;
    }

    public ChainedTextArea withCompositionStartListener(ComponentEventListener<CompositionStartEvent> listener) {
        super.addCompositionStartListener(listener);
        return this;
    }

    public ChainedTextArea withCompositionUpdateListener(ComponentEventListener<CompositionUpdateEvent> listener) {
        super.addCompositionUpdateListener(listener);
        return this;
    }

    public ChainedTextArea withCompositionEndListener(ComponentEventListener<CompositionEndEvent> listener) {
        super.addCompositionEndListener(listener);
        return this;
    }

    public ChainedTextArea withDetachListener(ComponentEventListener<DetachEvent> listener) {
        super.addDetachListener(listener);
        return this;
    }

    public ChainedTextArea withTabIndex(int tabIndex) {
        super.setTabIndex(tabIndex);
        return this;
    }

    public ChainedTextArea withFocusShortcut(Key key, KeyModifier... keyModifiers) {
        super.addFocusShortcut(key, keyModifiers);
        return this;
    }

    public ChainedTextArea withFocusListener(ComponentEventListener<FocusEvent<TextArea>> listener) {
        super.addFocusListener(listener);
        return this;
    }

    public ChainedTextArea withEnabled(boolean enabled) {
        super.setEnabled(enabled);
        return this;
    }

    public ChainedTextArea withHelperText(String helperText) {
        super.setHelperText(helperText);
        return this;
    }

    public ChainedTextArea withHelperComponent(Component component) {
        super.setHelperComponent(component);
        return this;
    }

    public ChainedTextArea withLabel(String label) {
        super.setLabel(label);
        return this;
    }

    public ChainedTextArea withWidth(String width) {
        super.setWidth(width);
        return this;
    }

    public ChainedTextArea withWidth(float width, Unit unit) {
        super.setWidth(width, unit);
        return this;
    }

    public ChainedTextArea withMinWidth(String minWidth) {
        super.setMinWidth(minWidth);
        return this;
    }

    public ChainedTextArea withMinWidth(float minWidth, Unit unit) {
        super.setMinWidth(minWidth, unit);
        return this;
    }

    public ChainedTextArea withMaxWidth(String maxWidth) {
        super.setMaxWidth(maxWidth);
        return this;
    }

    public ChainedTextArea withMaxWidth(float maxWidth, Unit unit) {
        super.setMaxWidth(maxWidth, unit);
        return this;
    }

    public ChainedTextArea withHeight(String height) {
        super.setHeight(height);
        return this;
    }

    public ChainedTextArea withHeight(float height, Unit unit) {
        super.setHeight(height, unit);
        return this;
    }

    public ChainedTextArea withMinHeight(String minHeight) {
        super.setMinHeight(minHeight);
        return this;
    }

    public ChainedTextArea withMinHeight(float minHeight, Unit unit) {
        super.setMinHeight(minHeight, unit);
        return this;
    }

    public ChainedTextArea withMaxHeight(String maxHeight) {
        super.setMaxHeight(maxHeight);
        return this;
    }

    public ChainedTextArea withMaxHeight(float maxHeight, Unit unit) {
        super.setMaxHeight(maxHeight, unit);
        return this;
    }

    public ChainedTextArea withSizeFull() {
        super.setSizeFull();
        return this;
    }

    public ChainedTextArea withWidthFull() {
        super.setWidthFull();
        return this;
    }

    public ChainedTextArea withHeightFull() {
        super.setHeightFull();
        return this;
    }

    public ChainedTextArea withSizeUndefined() {
        super.setSizeUndefined();
        return this;
    }

    public ChainedTextArea withClassName(String className) {
        super.setClassName(className);
        return this;
    }

    public ChainedTextArea withClassName(String className, boolean set) {
        super.setClassName(className, set);
        return this;
    }

    public ChainedTextArea withReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        return this;
    }

    public ChainedTextArea withInputListener(ComponentEventListener<InputEvent> listener) {
        super.addInputListener(listener);
        return this;
    }

    public ChainedTextArea withKeyDownListener(ComponentEventListener<KeyDownEvent> listener) {
        super.addKeyDownListener(listener);
        return this;
    }

    public ChainedTextArea withKeyPressListener(ComponentEventListener<KeyPressEvent> listener) {
        super.addKeyPressListener(listener);
        return this;
    }

    public ChainedTextArea withKeyUpListener(ComponentEventListener<KeyUpEvent> listener) {
        super.addKeyUpListener(listener);
        return this;
    }

    public ChainedTextArea withKeyDownListener(
            Key key,
            ComponentEventListener<KeyDownEvent> listener,
            KeyModifier... modifiers) {
        super.addKeyDownListener(key, listener, modifiers);
        return this;
    }

    public ChainedTextArea withKeyPressListener(
            Key key,
            ComponentEventListener<KeyPressEvent> listener,
            KeyModifier... modifiers) {
        super.addKeyPressListener(key, listener, modifiers);
        return this;
    }

    public ChainedTextArea withKeyUpListener(Key key, ComponentEventListener<KeyUpEvent> listener, KeyModifier... modifiers) {
        super.addKeyUpListener(key, listener, modifiers);
        return this;
    }

    public ChainedTextArea withClearButtonVisible(boolean clearButtonVisible) {
        super.setClearButtonVisible(clearButtonVisible);
        return this;
    }

    public ChainedTextArea withClientValidatedEventListener(ComponentEventListener<ClientValidatedEvent> listener) {
        super.addClientValidatedEventListener(listener);
        return this;
    }

    public ChainedTextArea withPrefixComponent(Component component) {
        super.setPrefixComponent(component);
        return this;
    }

    public ChainedTextArea withSuffixComponent(Component component) {
        super.setSuffixComponent(component);
        return this;
    }

    public ChainedTextArea withTooltipText(String text) {
        super.setTooltipText(text);
        return this;
    }

    public ChainedTextArea withErrorMessage(String errorMessage) {
        super.setErrorMessage(errorMessage);
        return this;
    }

    public ChainedTextArea withInvalid(boolean invalid) {
        super.setInvalid(invalid);
        return this;
    }

    public ChainedTextArea withAutocapitalize(Autocapitalize autocapitalize) {
        super.setAutocapitalize(autocapitalize);
        return this;
    }

    public ChainedTextArea withAutocomplete(Autocomplete autocomplete) {
        super.setAutocomplete(autocomplete);
        return this;
    }

    public ChainedTextArea withAutocorrect(boolean autocorrect) {
        super.setAutocorrect(autocorrect);
        return this;
    }
}
