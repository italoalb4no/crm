package framework;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.shared.Registration;

import java.util.Collection;

public class ChainedSpan extends Span {

    public ChainedSpan() {
        super();
    }

    public ChainedSpan(Component... components) {
        super(components);
    }

    public ChainedSpan(String text) {
        super(text);
    }

    public Registration addClickListener(ComponentEventListener<ClickEvent<Span>> listener) {
        return super.addClickListener(listener);
    }

    public ShortcutRegistration addClickShortcut(Key key, KeyModifier... keyModifiers) {
        return super.addClickShortcut(key, keyModifiers);
    }

    public ChainedSpan withTitle(String title) {
        super.setTitle(title);
        return this;
    }

    protected <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType, ComponentEventListener<T> listener) {
        return super.addListener(eventType, listener);
    }

    public ChainedSpan withId(String id) {
        super.setId(id);
        return this;
    }

    public ChainedSpan withVisible(boolean visible) {
        super.setVisible(visible);
        return this;
    }

    public ChainedSpan withAttachListener(ComponentEventListener<AttachEvent> listener) {
        super.addAttachListener(listener);
        return this;
    }

    public ChainedSpan with(Component... components) {
        super.add(components);
        return this;
    }

    public ChainedSpan with(Collection<Component> components) {
        super.add(components);
        return this;
    }

    public ChainedSpan with(String text) {
        super.add(text);
        return this;
    }

    public ChainedSpan withComponentAtIndex(int index, Component component) {
        super.addComponentAtIndex(index, component);
        return this;
    }

    public ChainedSpan withComponentAsFirst(Component component) {
        super.addComponentAsFirst(component);
        return this;
    }

    public ChainedSpan withEnabled(boolean enabled) {
        super.setEnabled(enabled);
        return this;
    }

    public ChainedSpan withWidth(String width) {
        super.setWidth(width);
        return this;
    }

    public ChainedSpan withWidth(float width, Unit unit) {
        super.setWidth(width, unit);
        return this;
    }

    public ChainedSpan withMinWidth(String minWidth) {
        super.setMinWidth(minWidth);
        return this;
    }

    public ChainedSpan withMinWidth(float minWidth, Unit unit) {
        super.setMinWidth(minWidth, unit);
        return this;
    }

    public ChainedSpan withMaxWidth(String maxWidth) {
        super.setMaxWidth(maxWidth);
        return this;
    }

    public ChainedSpan withMaxWidth(float maxWidth, Unit unit) {
        super.setMaxWidth(maxWidth, unit);
        return this;
    }

    public ChainedSpan withHeight(String height) {
        super.setHeight(height);
        return this;
    }

    public ChainedSpan withHeight(float height, Unit unit) {
        super.setHeight(height, unit);
        return this;
    }

    public ChainedSpan withMinHeight(String minHeight) {
        super.setMinHeight(minHeight);
        return this;
    }

    public ChainedSpan withMinHeight(float minHeight, Unit unit) {
        super.setMinHeight(minHeight, unit);
        return this;
    }

    public ChainedSpan withMaxHeight(String maxHeight) {
        super.setMaxHeight(maxHeight);
        return this;
    }

    public ChainedSpan withMaxHeight(float maxHeight, Unit unit) {
        super.setMaxHeight(maxHeight, unit);
        return this;
    }

    public ChainedSpan withSizeFull() {
        super.setSizeFull();
        return this;
    }

    public ChainedSpan withWidthFull() {
        super.setWidthFull();
        return this;
    }

    public ChainedSpan withHeightFull() {
        super.setHeightFull();
        return this;
    }

    public ChainedSpan withClassName(String className) {
        super.addClassName(className);
        return this;
    }

    public ChainedSpan withClassName(String className, boolean set) {
        super.setClassName(className, set);
        return this;
    }

    public ChainedSpan withClassNames(String... classNames) {
        super.addClassNames(classNames);
        return this;
    }

    public ChainedSpan withText(String text) {
        super.setText(text);
        return this;
    }
}
