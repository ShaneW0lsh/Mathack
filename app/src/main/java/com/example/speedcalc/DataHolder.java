package com.example.speedcalc;

public class DataHolder {
    private ArrayList<Expression> data;
    
    private static final DataHolder holder = new DataHolder();
    public static DataHolder getInstance() {
        return this.holder;
    }

    public ArrayList<Expression> getData() {
        return this.data;
    }

    public void addData(Expression expr) {
        this.data.add(expr);
    }
}
