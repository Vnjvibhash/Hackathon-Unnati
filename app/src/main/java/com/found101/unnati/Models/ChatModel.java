package com.found101.unnati.Models;

public class ChatModel {
    private String text;
    private String time;
    private int viewType;

    public ChatModel(String text, String time, int viewType) {
        this.text = text;
        this.time = time;
        this.viewType = viewType;
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    public int getViewType() {
        return viewType;
    }
}