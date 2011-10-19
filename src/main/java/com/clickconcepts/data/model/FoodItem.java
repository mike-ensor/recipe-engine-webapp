package com.clickconcepts.data.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Transient;

@Document
public class FoodItem {

    @Transient
    public static final FoodItem INVALID = new FoodItem() {
        @Override
        public boolean isValid() {
            return false;
        }
    };

    @Id
    private String id;
    private String name;

    public FoodItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private FoodItem() {
        this.id = null;
        this.name = "INVALID";
    }

    @Transient
    public boolean isValid() {
        return true;
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
}
