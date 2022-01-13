package com.example.speedcalc;

import java.util.ArrayList;

public class DataHolder {
    private static ArrayList<Expression> data;
    
    private static final DataHolder holder = new DataHolder();
    public static DataHolder getInstance() {
        return holder;
    }

    public static ArrayList<Expression> getData() {
        return data;
    }

    public static void addData(Expression expr) {
        data.add(expr);
    }

    public static void clearData() {
        data.clear();
    }
}
