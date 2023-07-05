package com.italoalbano.framework;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ChainedHorizontalLayout extends HorizontalLayout {
    public ChainedHorizontalLayout(Component... children) {
        super(children);
    }

    public HorizontalLayout ChainedHorizontalLayout() {
        return new HorizontalLayout();
    }

    public ChainedHorizontalLayout withSpacing(boolean spacing) {
        super.setSpacing(spacing);
        return this;
    }

    public ChainedHorizontalLayout withPadding(boolean padding) {
        super.setPadding(padding);
        return this;
    }

    public ChainedHorizontalLayout withDefaultVerticalComponentAlignment(Alignment alignment) {
        super.setDefaultVerticalComponentAlignment(alignment);
        return this;
    }

    public ChainedHorizontalLayout withAlignItems(Alignment alignment) {
        super.setAlignItems(alignment);
        return this;
    }

    public ChainedHorizontalLayout withAlignSelf(Alignment alignment, HasElement... components) {
        super.setAlignSelf(alignment, components);
        return this;
    }

    public ChainedHorizontalLayout withId(String id) {
        super.setId(id);
        return this;
    }

    public ChainedHorizontalLayout withWidth(String width) {
        super.setWidth(width);
        return this;
    }

    public ChainedHorizontalLayout withWidth(float width, Unit unit) {
        super.setWidth(width, unit);
        return this;
    }

    public ChainedHorizontalLayout withMinWidth(String minWidth) {
        super.setMinWidth(minWidth);
        return this;
    }

    public ChainedHorizontalLayout withMinWidth(float minWidth, Unit unit) {
        super.setMinWidth(minWidth, unit);
        return this;
    }

    public ChainedHorizontalLayout withMaxWidth(String maxWidth) {
        super.setMaxWidth(maxWidth);
        return this;
    }

    public ChainedHorizontalLayout withMaxWidth(float maxWidth, Unit unit) {
        super.setMaxWidth(maxWidth, unit);
        return this;
    }

    public ChainedHorizontalLayout withHeight(String height) {
        super.setHeight(height);
        return this;
    }

    public ChainedHorizontalLayout withHeight(float height, Unit unit) {
        super.setHeight(height, unit);
        return this;
    }

    public ChainedHorizontalLayout withMinHeight(String minHeight) {
        super.setMinHeight(minHeight);
        return this;
    }

    public ChainedHorizontalLayout withMinHeight(float minHeight, Unit unit) {
        super.setMinHeight(minHeight, unit);
        return this;
    }

    public ChainedHorizontalLayout withMaxHeight(String maxHeight) {
        super.setMaxHeight(maxHeight);
        return this;
    }

    public ChainedHorizontalLayout withMaxHeight(float maxHeight, Unit unit) {
        super.setMaxHeight(maxHeight, unit);
        return this;
    }

    public ChainedHorizontalLayout withSizeFull() {
        super.setSizeFull();
        return this;
    }

    public ChainedHorizontalLayout withWidthFull() {
        super.setWidthFull();
        return this;
    }

    public ChainedHorizontalLayout withHeightFull() {
        super.setHeightFull();
        return this;
    }

    public ChainedHorizontalLayout withSizeUndefined() {
        super.setSizeUndefined();
        return this;
    }

    public ChainedHorizontalLayout withClassName(String className) {
        super.addClassName(className);
        return this;
    }

    public ChainedHorizontalLayout withClassNames(String... classNames) {
        super.addClassNames(classNames);
        return this;
    }

    public ChainedHorizontalLayout withClassName(String className, boolean set) {
        super.setClassName(className, set);
        return this;
    }

    public ChainedHorizontalLayout withMargin(boolean margin) {
        super.setMargin(margin);
        return this;
    }
}
