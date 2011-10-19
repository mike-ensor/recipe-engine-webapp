package com.clickconcepts.data.model;

import com.google.common.collect.Lists;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Date;
import java.util.List;

@Document
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    @Lob
    private String directions;

    private Date updated;

    private Date created;

    private List<FoodItemQuantity> items;

    private Recipe() {
        this.items = Lists.newLinkedList();
    }

    public Recipe(String name) {
        this.name = name;
        this.updated = new Date();
        this.created = new Date();
        this.items = Lists.newLinkedList();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<FoodItemQuantity> getItems() {
        return items;
    }

    public void setItems(List<FoodItemQuantity> items) {
        this.items = items;
    }
}
