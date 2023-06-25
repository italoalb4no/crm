package framework;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.formlayout.FormLayout;

import java.util.Collection;
import java.util.List;

public class ChainedFormLayout extends FormLayout {

    public FormLayout ChainedFormLayout() {
        return new ChainedFormLayout();
    }

    public ChainedFormLayout withColspan(Component component, int colspan) {
        super.setColspan(component, colspan);
        return this;
    }

    public ChainedFormLayout with(Component component, int colspan) {
        super.add(component, colspan);
        return this;
    }

    public ChainedFormLayout withResponsiveSteps(List<ResponsiveStep> steps) {
        super.setResponsiveSteps(steps);
        return this;
    }

    public ChainedFormLayout withResponsiveSteps(ResponsiveStep... steps) {
        super.setResponsiveSteps(steps);
        return this;
    }

    public ChainedFormLayout withFormItem(Component field, String label) {
        super.addFormItem(field, label);
        return this;
    }

    public ChainedFormLayout withFormItem(Component field, Component label) {
        super.addFormItem(field, label);
        return this;
    }

    public ChainedFormLayout withClickListener(ComponentEventListener<ClickEvent<FormLayout>> listener) {
        super.addClickListener(listener);
        return this;
    }

    public ChainedFormLayout withClickShortcut(Key key, KeyModifier... keyModifiers) {
        super.addClickShortcut(key, keyModifiers);
        return this;
    }

    public ChainedFormLayout withId(String id) {
        super.setId(id);
        return this;
    }

    protected <T> ChainedFormLayout with(PropertyDescriptor<T, ?> descriptor, T value) {
        super.set(descriptor, value);
        return this;
    }

    public ChainedFormLayout withAttachListener(ComponentEventListener<AttachEvent> listener) {
        super.addAttachListener(listener);
        return this;
    }

    public ChainedFormLayout withDetachListener(ComponentEventListener<DetachEvent> listener) {
        super.addDetachListener(listener);
        return this;
    }

    public ChainedFormLayout with(Component... components) {
        super.add(components);
        return this;
    }

    public ChainedFormLayout with(Collection<Component> components) {
        super.add(components);
        return this;
    }

    public ChainedFormLayout with(String text) {
        super.add(text);
        return this;
    }

    public ChainedFormLayout withEnabled(boolean enabled) {
        super.setEnabled(enabled);
        return this;
    }

    public ChainedFormLayout withWidth(String width) {
        super.setWidth(width);
        return this;
    }

    public ChainedFormLayout withWidth(float width, Unit unit) {
        super.setWidth(width, unit);
        return this;
    }

    public ChainedFormLayout withMinWidth(String minWidth) {
        super.setMinWidth(minWidth);
        return this;
    }

    public ChainedFormLayout withMinWidth(float minWidth, Unit unit) {
        super.setMinWidth(minWidth, unit);
        return this;
    }

    public ChainedFormLayout withMaxWidth(String maxWidth) {
        super.setMaxWidth(maxWidth);
        return this;
    }

    public ChainedFormLayout withMaxWidth(float maxWidth, Unit unit) {
        super.setMaxWidth(maxWidth, unit);
        return this;
    }

    public ChainedFormLayout withHeight(String height) {
        super.setHeight(height);
        return this;
    }

    public ChainedFormLayout withHeight(float height, Unit unit) {
        super.setHeight(height, unit);
        return this;
    }

    public ChainedFormLayout withMinHeight(String minHeight) {
        super.setMinHeight(minHeight);
        return this;
    }

    public ChainedFormLayout withMinHeight(float minHeight, Unit unit) {
        super.setMinHeight(minHeight, unit);
        return this;
    }

    public ChainedFormLayout withMaxHeight(String maxHeight) {
        super.setMaxHeight(maxHeight);
        return this;
    }

    public ChainedFormLayout withMaxHeight(float maxHeight, Unit unit) {
        super.setMaxHeight(maxHeight, unit);
        return this;
    }

    public ChainedFormLayout withSizeFull() {
        super.setSizeFull();
        return this;
    }

    public ChainedFormLayout withWidthFull() {
        super.setWidthFull();
        return this;
    }

    public ChainedFormLayout withHeightFull() {
        super.setHeightFull();
        return this;
    }

    public ChainedFormLayout withSizeUndefined() {
        super.setSizeUndefined();
        return this;
    }

    public ChainedFormLayout withClassName(String className) {
        super.addClassName(className);
        return this;
    }

    public ChainedFormLayout withVisible(boolean visible) {
        super.setVisible(visible);
        return this;
    }
}
