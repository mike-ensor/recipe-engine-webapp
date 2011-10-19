package com.clickconcepts.data.model;

import javax.persistence.Embeddable;

@Embeddable
public class FoodItemQuantity {

    private FoodItem foodItem;
    private int quantity;

    private FoodItemQuantity() {
        foodItem = FoodItem.INVALID;
    }

    public FoodItemQuantity(FoodItem foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
