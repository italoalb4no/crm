package framework;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ChainedVerticalLayout extends VerticalLayout {
    public ChainedVerticalLayout(Component... children) {
        super(children);
    }

    public ChainedVerticalLayout() {
        super();
    }

    public VerticalLayout CustomVerticalLayout() {
        return new VerticalLayout();
    }

    public ChainedVerticalLayout withSpacing(boolean spacing) {
        super.setSpacing(spacing);
        return this;
    }

    public ChainedVerticalLayout withPadding(boolean padding) {
        super.setPadding(padding);
        return this;
    }

    public ChainedVerticalLayout withDefaultHorizontalComponentAlignment(Alignment alignment) {
        super.setDefaultHorizontalComponentAlignment(alignment);
        return this;
    }

    public ChainedVerticalLayout withAlignItems(Alignment alignment) {
        super.setAlignItems(alignment);
        return this;
    }

    public ChainedVerticalLayout withAlignSelf(Alignment alignment, HasElement... components) {
        super.setAlignSelf(alignment, components);
        return this;
    }

    public ChainedVerticalLayout withId(String id) {
        super.setId(id);
        return this;
    }

    public ChainedVerticalLayout withWidth(String width) {
        super.setWidth(width);
        return this;
    }

    public ChainedVerticalLayout withWidth(float width, Unit unit) {
        super.setWidth(width, unit);
        return this;
    }

    public ChainedVerticalLayout withMinWidth(String minWidth) {
        super.setMinWidth(minWidth);
        return this;
    }

    public ChainedVerticalLayout withMinWidth(float minWidth, Unit unit) {
        super.setMinWidth(minWidth, unit);
        return this;
    }

    public ChainedVerticalLayout withMaxWidth(String maxWidth) {
        super.setMaxWidth(maxWidth);
        return this;
    }

    public ChainedVerticalLayout withMaxWidth(float maxWidth, Unit unit) {
        super.setMaxWidth(maxWidth, unit);
        return this;
    }

    public ChainedVerticalLayout withHeight(String height) {
        super.setHeight(height);
        return this;
    }

    public ChainedVerticalLayout withHeight(float height, Unit unit) {
        super.setHeight(height, unit);
        return this;
    }

    public ChainedVerticalLayout withMinHeight(String minHeight) {
        super.setMinHeight(minHeight);
        return this;
    }

    public ChainedVerticalLayout withMinHeight(float minHeight, Unit unit) {
        super.setMinHeight(minHeight, unit);
        return this;
    }

    public ChainedVerticalLayout withMaxHeight(String maxHeight) {
        super.setMaxHeight(maxHeight);
        return this;
    }

    public ChainedVerticalLayout withMaxHeight(float maxHeight, Unit unit) {
        super.setMaxHeight(maxHeight, unit);
        return this;
    }

    public ChainedVerticalLayout withSizeFull() {
        super.setSizeFull();
        return this;
    }

    public ChainedVerticalLayout withWidthFull() {
        super.setWidthFull();
        return this;
    }

    public ChainedVerticalLayout withHeightFull() {
        super.setHeightFull();
        return this;
    }

    public ChainedVerticalLayout withSizeUndefined() {
        super.setSizeUndefined();
        return this;
    }

    public ChainedVerticalLayout withClassName(String className) {
        super.addClassName(className);
        return this;
    }

    public ChainedVerticalLayout withClassNames(String... classNames) {
        super.addClassNames(classNames);
        return this;
    }

    public ChainedVerticalLayout withClassName(String className, boolean set) {
        super.setClassName(className, set);
        return this;
    }

    public ChainedVerticalLayout withMargin(boolean margin) {
        super.setMargin(margin);
        return this;
    }
}
