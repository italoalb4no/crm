package com.italoalbano.framework;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dialog.Dialog;

import java.util.Collection;

public class ChainedDialog extends Dialog {

    public Dialog ChainedDialog() {
        return new Dialog();
    }

    public ChainedDialog withWidth(String value) {
        super.setWidth(value);
        return this;
    }

    public ChainedDialog withMinWidth(String value) {
        super.setMinWidth(value);
        return this;
    }

    public ChainedDialog withMaxWidth(String value) {
        super.setMaxWidth(value);
        return this;
    }

    public ChainedDialog withHeight(String value) {
        super.setHeight(value);
        return this;
    }

    public ChainedDialog withMinHeight(String value) {
        super.setMinHeight(value);
        return this;
    }

    public ChainedDialog withMaxHeight(String value) {
        super.setMaxHeight(value);
        return this;
    }

    public ChainedDialog withDialogCloseActionListener(ComponentEventListener<DialogCloseActionEvent> listener) {
        super.addDialogCloseActionListener(listener);
        return this;
    }

    public ChainedDialog withResizeListener(ComponentEventListener<DialogResizeEvent> listener) {
        super.addResizeListener(listener);
        return this;
    }

    public ChainedDialog with(Collection<Component> components) {
        super.add(components);
        return this;
    }

    public ChainedDialog withComponentAtIndex(int index, Component component) {
        super.addComponentAtIndex(index, component);
        return this;
    }

    public ChainedDialog withCloseOnEsc(boolean closeOnEsc) {
        super.setCloseOnEsc(closeOnEsc);
        return this;
    }

    public ChainedDialog withCloseOnOutsideClick(boolean closeOnOutsideClick) {
        super.setCloseOnOutsideClick(closeOnOutsideClick);
        return this;
    }

    public ChainedDialog withModal(boolean modal) {
        super.setModal(modal);
        return this;
    }

    public ChainedDialog withDraggable(boolean draggable) {
        super.setDraggable(draggable);
        return this;
    }

    public ChainedDialog withResizable(boolean resizable) {
        super.setResizable(resizable);
        return this;
    }

    public ChainedDialog withHeaderTitle(String title) {
        super.setHeaderTitle(title);
        return this;
    }

    public ChainedDialog withVisible(boolean visible) {
        super.setVisible(visible);
        return this;
    }

    public ChainedDialog withOpenedChangeListener(ComponentEventListener<OpenedChangeEvent> listener) {
        super.addOpenedChangeListener(listener);
        return this;
    }

    public ChainedDialog withAttachListener(ComponentEventListener<AttachEvent> listener) {
        super.addAttachListener(listener);
        return this;
    }

    public ChainedDialog withDetachListener(ComponentEventListener<DetachEvent> listener) {
        super.addDetachListener(listener);
        return this;
    }

    protected ChainedDialog withAriaLabel(String ariaLabel) {
        super.setAriaLabel(ariaLabel);
        return this;
    }

    public ChainedDialog withClassName(String className) {
        super.setClassName(className);
        return this;
    }

    public ChainedDialog with(Component... components) {
        super.add(components);
        return this;
    }

    public ChainedDialog with(String text) {
        super.add(text);
        return this;
    }

    public ChainedDialog withWidth(float width, Unit unit) {
        super.setWidth(width, unit);
        return this;
    }

    public ChainedDialog withMinWidth(float minWidth, Unit unit) {
        super.setMinWidth(minWidth, unit);
        return this;
    }

    public ChainedDialog withMaxWidth(float maxWidth, Unit unit) {
        super.setMaxWidth(maxWidth, unit);
        return this;
    }

    public ChainedDialog withHeight(float height, Unit unit) {
        super.setHeight(height, unit);
        return this;
    }

    public ChainedDialog withMinHeight(float minHeight, Unit unit) {
        super.setMinHeight(minHeight, unit);
        return this;
    }

    public ChainedDialog withMaxHeight(float maxHeight, Unit unit) {
        super.setMaxHeight(maxHeight, unit);
        return this;
    }

    public ChainedDialog withSizeFull() {
        super.setSizeFull();
        return this;
    }

    public ChainedDialog withWidthFull() {
        super.setWidthFull();
        return this;
    }

    public ChainedDialog withHeightFull() {
        super.setHeightFull();
        return this;
    }

    public ChainedDialog withSizeUndefined() {
        super.setSizeUndefined();
        return this;
    }

    public ChainedDialog withClassName(String className, boolean set) {
        super.setClassName(className, set);
        return this;
    }

    public ChainedDialog withThemeName(String themeName) {
        super.setThemeName(themeName);
        return this;
    }

    public ChainedDialog withThemeName(String themeName, boolean set) {
        super.setThemeName(themeName, set);
        return this;
    }

    public ChainedDialog withThemeNames(String... themeNames) {
        super.addThemeNames(themeNames);
        return this;
    }
}
