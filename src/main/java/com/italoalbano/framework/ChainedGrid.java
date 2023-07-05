package com.italoalbano.framework;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridSelectionModel;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.dnd.GridDropMode;
import com.vaadin.flow.data.provider.BackEndDataProvider;
import com.vaadin.flow.data.provider.CallbackDataProvider;
import com.vaadin.flow.data.provider.DataGenerator;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.function.SerializableBiFunction;
import com.vaadin.flow.function.SerializableFunction;
import com.vaadin.flow.function.SerializablePredicate;
import com.vaadin.flow.function.ValueProvider;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class ChainedGrid<T> extends Grid<T> {

    public ChainedGrid() {
        super();
    }

    public ChainedGrid(int pageSize) {
        super(pageSize);
    }

    public ChainedGrid(Class beanType, boolean autoCreateColumns) {
        super(beanType, autoCreateColumns);
    }

    public ChainedGrid(Class beanType) {
        super(beanType);
    }

    protected ChainedGrid(
            Class beanType,
            SerializableBiFunction updateQueueBuilder,
            DataCommunicatorBuilder dataCommunicatorBuilder) {
        super(beanType, updateQueueBuilder, dataCommunicatorBuilder);
    }

    protected ChainedGrid(
            int pageSize,
            SerializableBiFunction updateQueueBuilder,
            DataCommunicatorBuilder dataCommunicatorBuilder) {
        super(pageSize, updateQueueBuilder, dataCommunicatorBuilder);
    }

    public Column withColumn(String propertyName) {
        return super.addColumn(propertyName);
    }

    protected Column withColumn(
            String propertyName,
            BiFunction columnFactory) {
        return super.addColumn(propertyName, columnFactory);
    }

    public void withColumns(String... propertyNames) {
        super.addColumns(propertyNames);
    }

    public void withSortableColumns(String... propertyNames) {
        super.setSortableColumns(propertyNames);
    }

    public ChainedGrid withThemeVariants(GridVariant... variants) {
        super.addThemeVariants(variants);
        return this;
    }

    public ChainedGrid withDataProvider(DataProvider dataProvider) {
        super.setDataProvider(dataProvider);
        return this;
    }

    public ChainedGrid withItems(DataProvider dataProvider) {
        super.setItems(dataProvider);
        return this;
    }

    public Column<T> withColumn(ValueProvider<T, ?> valueProvider) {
        return super.addColumn(valueProvider);
    }

    protected <C extends Column<T>> C withColumn(
            ValueProvider<T, ?> valueProvider,
            BiFunction<Renderer<T>, String, C> columnFactory) {
        return super.addColumn(valueProvider, columnFactory);
    }

    public <V extends Component> Column<T> withComponentColumn(ValueProvider<T, V> componentProvider) {
        return super.addComponentColumn(componentProvider);
    }

    public <V extends Comparable<? super V>> Column<T> withColumn(
            ValueProvider<T, V> valueProvider,
            String... sortingProperties) {
        return super.addColumn(valueProvider, sortingProperties);
    }

    public Column<T> withColumn(Renderer<T> renderer) {
        return super.addColumn(renderer);
    }

    protected <C extends Column<T>> C withColumn(
            Renderer<T> renderer,
            BiFunction<Renderer<T>, String, C> columnFactory) {
        return super.addColumn(renderer, columnFactory);
    }

    public ChainedGrid withItems(BackEndDataProvider dataProvider) {
        super.setItems(dataProvider);
        return this;
    }

    public ChainedGrid withPageSize(int pageSize) {
        super.setPageSize(pageSize);
        return this;
    }

    protected ChainedGrid withSelectionModel(
            GridSelectionModel model,
            SelectionMode selectionMode) {
        super.setSelectionModel(model, selectionMode);
        return this;
    }

    public ChainedGrid withSelectionMode(SelectionMode selectionMode) {
        super.setSelectionMode(selectionMode);
        return this;
    }

    public ChainedGrid withItemDetailsRenderer(Renderer renderer) {
        super.setItemDetailsRenderer(renderer);
        return this;
    }

    public ChainedGrid withColumnReorderingAllowed(boolean columnReorderingAllowed) {
        super.setColumnReorderingAllowed(columnReorderingAllowed);
        return this;
    }

    public ChainedGrid withDetailsVisible(T item, boolean visible) {
        super.setDetailsVisible(item, visible);
        return this;
    }

    public ChainedGrid withDetailsVisibleOnClick(boolean detailsVisibleOnClick) {
        super.setDetailsVisibleOnClick(detailsVisibleOnClick);
        return this;
    }

    public ChainedGrid withMultiSort(boolean multiSort) {
        super.setMultiSort(multiSort);
        return this;
    }

    public ChainedGrid withMultiSort(
            boolean multiSort,
            MultiSortPriority priority) {
        super.setMultiSort(multiSort, priority);
        return this;
    }

    public ChainedGrid withMultiSort(
            boolean multiSort,
            boolean onShiftClickOnly) {
        super.setMultiSort(multiSort, onShiftClickOnly);
        return this;
    }

    public ChainedGrid withMultiSort(
            boolean multiSort,
            MultiSortPriority priority,
            boolean onShiftClickOnly) {
        super.setMultiSort(multiSort, priority, onShiftClickOnly);
        return this;
    }

    public ChainedGrid withAllRowsVisible(boolean allRowsVisible) {
        super.setAllRowsVisible(allRowsVisible);
        return this;
    }

    public ChainedGrid withValueProvider(
            String property,
            ValueProvider valueProvider) {
        super.addValueProvider(property, valueProvider);
        return this;
    }

    public ChainedGrid withDataGenerator(DataGenerator dataGenerator) {
        super.addDataGenerator(dataGenerator);
        return this;
    }

    public ChainedGrid withItemClickListener(ComponentEventListener listener) {
        super.addItemClickListener(listener);
        return this;
    }

    public ChainedGrid withColumnResizeListener(ComponentEventListener listener) {
        super.addColumnResizeListener(listener);
        return this;
    }

    public ChainedGrid withItemDoubleClickListener(ComponentEventListener listener) {
        super.addItemDoubleClickListener(listener);
        return this;
    }

    public ChainedGrid withCellFocusListener(ComponentEventListener listener) {
        super.addCellFocusListener(listener);
        return this;
    }

    public ChainedGrid withClassNameGenerator(SerializableFunction classNameGenerator) {
        super.setClassNameGenerator(classNameGenerator);
        return this;
    }

    public ChainedGrid withPartNameGenerator(SerializableFunction partNameGenerator) {
        super.setPartNameGenerator(partNameGenerator);
        return this;
    }

    protected ChainedGrid withUniqueKeyProperty(String uniqueKeyProperty) {
        super.setUniqueKeyProperty(uniqueKeyProperty);
        return this;
    }

    public ChainedGrid withDropListener(ComponentEventListener listener) {
        super.addDropListener(listener);
        return this;
    }

    public ChainedGrid withDragStartListener(ComponentEventListener listener) {
        super.addDragStartListener(listener);
        return this;
    }

    public ChainedGrid withDragEndListener(ComponentEventListener listener) {
        super.addDragEndListener(listener);
        return this;
    }

    public ChainedGrid withDropMode(GridDropMode dropMode) {
        super.setDropMode(dropMode);
        return this;
    }

    public ChainedGrid withRowsDraggable(boolean rowsDraggable) {
        super.setRowsDraggable(rowsDraggable);
        return this;
    }

    public ChainedGrid withDropFilter(SerializablePredicate dropFilter) {
        super.setDropFilter(dropFilter);
        return this;
    }

    public ChainedGrid withDragFilter(SerializablePredicate dragFilter) {
        super.setDragFilter(dragFilter);
        return this;
    }

    public ChainedGrid withDragDataGenerator(
            String type,
            SerializableFunction dragDataGenerator) {
        super.setDragDataGenerator(type, dragDataGenerator);
        return this;
    }

    public ChainedGrid withSelectionDragDetails(
            int draggedItemsCount,
            Map dragData) {
        super.setSelectionDragDetails(draggedItemsCount, dragData);
        return this;
    }

    public ChainedGrid withColumnReorderListener(ComponentEventListener listener) {
        super.addColumnReorderListener(listener);
        return this;
    }

    public ChainedGrid withColumnOrder(Column[] columns) {
        super.setColumnOrder(columns);
        return this;
    }

    public ChainedGrid withColumnOrder(List list) {
        super.setColumnOrder(list);
        return this;
    }

    public ChainedGrid withNestedNullBehavior(NestedNullBehavior nestedNullBehavior) {
        super.setNestedNullBehavior(nestedNullBehavior);
        return this;
    }

    public ChainedGrid withBlurListener(ComponentEventListener listener) {
        super.addBlurListener(listener);
        return this;
    }

    public ChainedGrid withId(String id) {
        super.setId(id);
        return this;
    }

    public ChainedGrid withVisible(boolean visible) {
        super.setVisible(visible);
        return this;
    }

    public ChainedGrid withAttachListener(ComponentEventListener<AttachEvent> listener) {
        super.addAttachListener(listener);
        return this;
    }

    public ChainedGrid withDetachListener(ComponentEventListener<DetachEvent> listener) {
        super.addDetachListener(listener);
        return this;
    }

    public ChainedGrid withTabIndex(int tabIndex) {
        super.setTabIndex(tabIndex);
        return this;
    }

    public ChainedGrid withFocusShortcut(Key key, KeyModifier... keyModifiers) {
        super.addFocusShortcut(key, keyModifiers);
        return this;
    }

    public ChainedGrid withFocusListener(ComponentEventListener listener) {
        super.addFocusListener(listener);
        return this;
    }

    public ChainedGrid withEnabled(boolean enabled) {
        super.setEnabled(enabled);
        return this;
    }

    public ChainedGrid withWidth(String width) {
        super.setWidth(width);
        return this;
    }

    public ChainedGrid withWidth(float width, Unit unit) {
        super.setWidth(width, unit);
        return this;
    }

    public ChainedGrid withMinWidth(String minWidth) {
        super.setMinWidth(minWidth);
        return this;
    }

    public ChainedGrid withMinWidth(float minWidth, Unit unit) {
        super.setMinWidth(minWidth, unit);
        return this;
    }

    public ChainedGrid withMaxWidth(String maxWidth) {
        super.setMaxWidth(maxWidth);
        return this;
    }

    public ChainedGrid withMaxWidth(float maxWidth, Unit unit) {
        super.setMaxWidth(maxWidth, unit);
        return this;
    }

    public ChainedGrid withHeight(String height) {
        super.setHeight(height);
        return this;
    }

    public ChainedGrid withHeight(float height, Unit unit) {
        super.setHeight(height, unit);
        return this;
    }

    public ChainedGrid withMinHeight(String minHeight) {
        super.setMinHeight(minHeight);
        return this;
    }

    public ChainedGrid withMinHeight(float minHeight, Unit unit) {
        super.setMinHeight(minHeight, unit);
        return this;
    }

    public ChainedGrid withMaxHeight(String maxHeight) {
        super.setMaxHeight(maxHeight);
        return this;
    }

    public ChainedGrid withMaxHeight(float maxHeight, Unit unit) {
        super.setMaxHeight(maxHeight, unit);
        return this;
    }

    public ChainedGrid withSizeFull() {
        super.setSizeFull();
        return this;
    }

    public ChainedGrid withWidthFull() {
        super.setWidthFull();
        return this;
    }

    public ChainedGrid withHeightFull() {
        super.setHeightFull();
        return this;
    }

    public ChainedGrid withSizeUndefined() {
        super.setSizeUndefined();
        return this;
    }

    public ChainedGrid withClassName(String className) {
        super.addClassName(className);
        return this;
    }

    public ChainedGrid withClassNames(String... classNames) {
        super.addClassNames(classNames);
        return this;
    }

    public ChainedGrid withClassName(String className, boolean set) {
        super.setClassName(className, set);
        return this;
    }

    public ChainedGrid withThemeName(String themeName) {
        super.setThemeName(themeName);
        return this;
    }

    public ChainedGrid withThemeName(String themeName, boolean set) {
        super.setThemeName(themeName, set);
        return this;
    }

    public ChainedGrid withItems(CallbackDataProvider.FetchCallback fetchCallback) {
        super.setItems(fetchCallback);
        return this;
    }

    public ChainedGrid withItems(
            CallbackDataProvider.FetchCallback fetchCallback,
            CallbackDataProvider.CountCallback countCallback) {
        super.setItems(fetchCallback, countCallback);
        return this;
    }

    public ChainedGrid withItems(Collection items) {
        super.setItems(items);
        return this;
    }

    public ChainedGrid withItems(T[] items) {
        super.setItems(items);
        return this;
    }
}
