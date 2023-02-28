package com.poncho.testnumber.entity;

public class RequestEntity {
    private int number;
    private boolean random;
    private boolean history;
    private String historyInfo;

    public RequestEntity(boolean random, boolean history, int number, String historyInfo) {
        this.random = random;
        this.history = history;
        this.number = number;
        this.historyInfo = historyInfo;
    }

    public boolean isHistory() {
        return history;
    }

    public boolean isRandom() {
        return random;
    }

    public int getNumber() {
        return number;
    }

    public String getHistoryInfo() {
        return  historyInfo;
    }
}
