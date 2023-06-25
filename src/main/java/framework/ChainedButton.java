package framework;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public class ChainedButton extends Button {

    public Button ChainedButton() {
        return new Button();
    }

    public Button ChainedButton(String text) {
        return new Button(text);
    }

    public Button ChainedButton(
            String text,
            Component icon,
            ComponentEventListener<ClickEvent<Button>> clickListener) {
        return new Button(text, icon, clickListener);
    }

    public Button ChainedButton(
            Component icon,
            ComponentEventListener<ClickEvent<Button>> clickListener) {
        return new Button(icon, clickListener);
    }

    public Button ChainedButton(
            String text,
            ComponentEventListener<ClickEvent<Button>> clickListener) {
        return new Button(text, clickListener);
    }

    public Button ChainedButton(String text, Component icon) {
        return new Button(text, icon);
    }

    public Button ChainedButton(Component icon) {
        return new Button(icon);
    }

    public ChainedButton withText(String text) {
        super.setText(text);
        return this;
    }

    public ChainedButton withIcon(Component icon) {
        super.setIcon(icon);
        return this;
    }

    public ChainedButton withIconAfterText(boolean iconAfterText) {
        super.setIconAfterText(iconAfterText);
        return this;
    }

    public ChainedButton withAutofocus(boolean autofocus) {
        super.setAutofocus(autofocus);
        return this;
    }

    public ChainedButton withDisableOnClick(boolean disableOnClick) {
        super.setDisableOnClick(disableOnClick);
        return this;
    }

    protected <T> ChainedButton with(
            PropertyDescriptor<T, ?> descriptor,
            T value) {
        super.set(descriptor, value);
        return this;
    }

    public ChainedButton withVisible(boolean visible) {
        super.setVisible(visible);
        return this;
    }

    public ChainedButton withAttachListener(ComponentEventListener<AttachEvent> listener) {
        super.addAttachListener(listener);
        return this;
    }

    public ChainedButton withDetachListener(ComponentEventListener<DetachEvent> listener) {
        super.addDetachListener(listener);
        return this;
    }

    public ChainedButton withTabIndex(int tabIndex) {
        super.setTabIndex(tabIndex);
        return this;
    }

    public ChainedButton withEnabled(boolean enabled) {
        super.setEnabled(enabled);
        return this;
    }

    public ChainedButton withWidth(String width) {
        super.setWidth(width);
        return this;
    }

    public ChainedButton withWidth(float width, Unit unit) {
        super.setWidth(width, unit);
        return this;
    }

    public ChainedButton withMinWidth(String minWidth) {
        super.setMinWidth(minWidth);
        return this;
    }

    public ChainedButton withMinWidth(float minWidth, Unit unit) {
        super.setMinWidth(minWidth, unit);
        return this;
    }

    public ChainedButton withMaxWidth(String maxWidth) {
        super.setMaxWidth(maxWidth);
        return this;
    }

    public ChainedButton withMaxWidth(float maxWidth, Unit unit) {
        super.setMaxWidth(maxWidth, unit);
        return this;
    }

    public ChainedButton withHeight(String height) {
        super.setHeight(height);
        return this;
    }

    public ChainedButton withHeight(float height, Unit unit) {
        super.setHeight(height, unit);
        return this;
    }

    public ChainedButton withMinHeight(String minHeight) {
        super.setMinHeight(minHeight);
        return this;
    }

    public ChainedButton withMinHeight(float minHeight, Unit unit) {
        super.setMinHeight(minHeight, unit);
        return this;
    }

    public ChainedButton withMaxHeight(String maxHeight) {
        super.setMaxHeight(maxHeight);
        return this;
    }

    public ChainedButton withMaxHeight(float maxHeight, Unit unit) {
        super.setMaxHeight(maxHeight, unit);
        return this;
    }

    public ChainedButton withSizeFull() {
        super.setSizeFull();
        return this;
    }

    public ChainedButton withWidthFull() {
        super.setWidthFull();
        return this;
    }

    public ChainedButton withHeightFull() {
        super.setHeightFull();
        return this;
    }

    public ChainedButton withSizeUndefined() {
        super.setSizeUndefined();
        return this;
    }

    public ChainedButton withClassName(String className, boolean set) {
        super.setClassName(className, set);
        return this;
    }

    public ChainedButton withClassNames(String... classNames) {
        super.addClassNames(classNames);
        return this;
    }

    public ChainedButton withWhiteSpace(WhiteSpace value) {
        super.setWhiteSpace(value);
        return this;
    }

    public ChainedButton withThemeName(String themeName) {
        super.setThemeName(themeName);
        return this;
    }

    public ChainedButton withThemeName(String themeName, boolean set) {
        super.setThemeName(themeName, set);
        return this;
    }

    public ChainedButton withPrefixComponent(Component component) {
        super.setPrefixComponent(component);
        return this;
    }

    public ChainedButton withSuffixComponent(Component component) {
        super.setSuffixComponent(component);
        return this;
    }

    public ChainedButton withThemeVariants(ButtonVariant... variants) {
        super.addThemeVariants(variants);
        return this;
    }

}
