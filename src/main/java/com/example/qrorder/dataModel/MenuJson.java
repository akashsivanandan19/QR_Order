package com.example.qrorder.dataModel;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MenuJson {

    public static String menuJson1 = "[\n" +
            "{\n" +
            "\"itmId\":\"1\",\n" +
            "\"imgId\":\"1\",\n" +
            "\"name\":\"Mocha Fried Chicken\",\n" +
            "\"desc\":\"Peri Peri marinated fried chicken pops\",\n" +
            "\"price\":350\n" +
            "},\n" +
            "\n" +

            "{\n" +
            "\"itmId\":\"2\",\n" +
            "\"imgId\":\"2\",\n" +
            "\"name\":\"Manchow Soup\",\n" +
            "\"desc\":\"A Chinese style thick vegetable soup topped with noodles\",\n" +
            "\"price\":190\n" +
            "},\n" +
            "\n" +

            "{\n" +
            "\"itmId\":\"3\",\n" +
            "\"imgId\":\"3\",\n" +
            "\"name\":\"Mocha China Box\",\n" +
            "\"desc\":\"Chili garlic fried rice served with black pepper sauce\",\n" +
            "\"price\":270\n" +
            "},\n" +
            "\n" +

            "{\n" +
            "\"itmId\":\"4\",\n" +
            "\"imgId\":\"4\",\n" +
            "\"name\":\"Fried Momos\",\n" +
            "\"desc\":\"Tandoori momos served with sharp chili sauce\",\n" +
            "\"price\":190\n" +
            "},\n" +
            "\n" +

            "{\n" +
            "\"itmId\":\"5\",\n" +
            "\"imgId\":\"5\",\n" +
            "\"name\":\"Mocha Shake\",\n" +
            "\"desc\":\"Our version of the ever popular cold coffee\",\n" +
            "\"price\":210\n" +
            "},\n" +
            "\n" +



            "{\n" +
            "\"itmId\":\"6\",\n" +
            "\"imgId\":\"6\",\n" +
            "\"name\":\"Peach Iced Tea\",\n" +
            "\"desc\":\"A refreshing peach infused iced tea\",\n" +
            "\"price\":160\n" +
            "},\n" +
            "\n" +



            "{\n" +
            "\"itmId\":\"7\",\n" +
            "\"imgId\":\"7\",\n" +
            "\"name\":\"Farm Fresh Pizza\",\n" +
            "\"desc\":\"Mushrooms, corn, assorted bell peppers,black olives, Jalapenos and cheese\",\n" +
            "\"price\":375\n" +
            "},\n" +
            "\n" +

            "{\n" +
            "\"itmId\":\"8\",\n" +
            "\"imgId\":\"8\",\n" +
            "\"name\":\"Burmese Khao Suey\",\n" +
            "\"desc\":\"A one pot meal with noodles cooked in coconut gravy served with condiments\",\n" +
            "\"price\":295\n" +
            "}\n" +
            "\n" +


            "]";

    public static String menuJson2 = "[\n" +
            "{\n" +
            "\"itmId\":\"1\",\n" +
            "\"imgId\":\"1\",\n" +
            "\"name\":\"Mocha Fried Chicken\",\n" +
            "\"desc\":\"Peri Peri marinated fried chicken pops\",\n" +
            "\"price\":350\n" +
            "},\n" +
            "\n" +

            "{\n" +
            "\"itmId\":\"2\",\n" +
            "\"imgId\":\"2\",\n" +
            "\"name\":\"Manchow Soup\",\n" +
            "\"desc\":\"A Chinese style thick vegetable soup topped with noodles\",\n" +
            "\"price\":190\n" +
            "},\n" +
            "\n" +

            "{\n" +
            "\"itmId\":\"3\",\n" +
            "\"imgId\":\"3\",\n" +
            "\"name\":\"Mocha China Box\",\n" +
            "\"desc\":\"Chili garlic fried rice served with black pepper sauce\",\n" +
            "\"price\":270\n" +
            "},\n" +
            "\n" +

            "{\n" +
            "\"itmId\":\"4\",\n" +
            "\"imgId\":\"4\",\n" +
            "\"name\":\"Fried Momos\",\n" +
            "\"desc\":\"Tandoori momos served with sharp chili sauce\",\n" +
            "\"price\":190\n" +
            "},\n" +
            "\n" +

            "{\n" +
            "\"itmId\":\"5\",\n" +
            "\"imgId\":\"5\",\n" +
            "\"name\":\"Mocha Shake\",\n" +
            "\"desc\":\"Our version of the ever popular cold coffee\",\n" +
            "\"price\":210\n" +
            "},\n" +
            "\n" +



            "{\n" +
            "\"itmId\":\"6\",\n" +
            "\"imgId\":\"6\",\n" +
            "\"name\":\"Peach Iced Tea\",\n" +
            "\"desc\":\"A refreshing peach infused iced tea\",\n" +
            "\"price\":160\n" +
            "},\n" +
            "\n" +



            "{\n" +
            "\"itmId\":\"7\",\n" +
            "\"imgId\":\"7\",\n" +
            "\"name\":\"Farm Fresh Pizza\",\n" +
            "\"desc\":\"Mushrooms, corn, assorted bell peppers,black olives, Jalapenos and cheese\",\n" +
            "\"price\":375\n" +
            "},\n" +
            "\n" +

            "{\n" +
            "\"itmId\":\"8\",\n" +
            "\"imgId\":\"8\",\n" +
            "\"name\":\"Burmese Khao Suey\",\n" +
            "\"desc\":\"A one pot meal with noodles cooked in coconut gravy served with condiments\",\n" +
            "\"price\":295\n" +
            "}\n" +
            "\n" +


            "]";






    public static final Type menu_list_type = new TypeToken<List<MenuItem>>() {
        }.getType();

    }
