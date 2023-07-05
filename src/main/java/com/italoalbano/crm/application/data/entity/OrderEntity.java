package com.italoalbano.crm.application.data.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(
            name = "id",
            updatable = false,
            nullable = false,
            columnDefinition = "VARCHAR(36)")
    private UUID id;
    @Column(nullable = false)
    private LocalDate creationDate;
    @Column(nullable = false)
    private boolean isFullfilled;
    @Column(nullable = false)
    private boolean isCancelled;
    @Column(nullable = false)
    private boolean paid;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "id")
    @ManyToOne(targetEntity = CustomerEntity.class)
    private CustomerEntity customer;
    @ManyToMany(targetEntity = ItemEntity.class)
    @JoinTable(name = "ORDER_ITEMS",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private List<ItemEntity> items = new ArrayList<>();

    public OrderEntity() {
    }

    public OrderEntity(UUID id, LocalDate creationDate, boolean isFullfilled, boolean isCancelled, boolean paid, CustomerEntity customer, List<ItemEntity> items) {
        this.id = id;
        this.creationDate = creationDate;
        this.isFullfilled = isFullfilled;
        this.isCancelled = isCancelled;
        this.paid = paid;
        this.customer = customer;
        this.items = items;
    }

    public OrderEntity(OrderEntity order) {
        this.id = order.id;
        this.creationDate = order.creationDate;
        this.isFullfilled = order.isFullfilled;
        this.isCancelled = order.isCancelled;
        this.paid = order.paid;
        this.customer = order.customer;
        this.items = order.items;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isFullfilled() {
        return this.isFullfilled;
    }

    public void setFullfilled(boolean fullfilled) {
        this.isFullfilled = fullfilled;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }

    public boolean isPaid() {
        return this.paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public CustomerEntity getCustomer() {
        return this.customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public List<ItemEntity> getItems() {
        return this.items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }
}