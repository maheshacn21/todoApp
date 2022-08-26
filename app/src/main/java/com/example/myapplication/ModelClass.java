package com.example.myapplication;

public class ModelClass {
   private boolean box;

    public boolean isBox() {
        return box;
    }

    public void setBox(boolean box) {
        this.box = box;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String task,date;

}
