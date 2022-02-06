package com.shane.mathack.util;

import com.shane.mathack.util.expression.Expression;

import java.util.ArrayList;


// TODO 
//      1. rename data var and getdata() method 
//      2. make sure to understand how this works, I think getInstance() and addData() are not written correctly

public class DataHolder {
    private static ArrayList<Expression> data = new ArrayList<>();
    private static int numOfTasks = 10;
    
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

    public static int getNumOfTasks() {
        return numOfTasks;
    }

    public static void setNumOfTasks(int num) {
        numOfTasks = num;
    }

    public static void clearData() {
        if (data != null) {
            data.clear();
        }
    }
}
