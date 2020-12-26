package com.example.qrorder;

import androidx.recyclerview.widget.RecyclerView;

public class FoodMenu {
    private String foodName;
    private String foodPrice;
    private String fooddesc;
    private String restaurantName;

    public FoodMenu(String foodName, String foodPrice, String fooddesc, String restaurantName) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.fooddesc = fooddesc;
        this.restaurantName = restaurantName;
    }

    public String getFooddesc() {
        return fooddesc;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public String getRestaurantName() {
        return restaurantName;
    }


}
