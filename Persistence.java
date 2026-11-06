package com.vehiclerental.model;

public interface Persistence {
    void saveData(String fileName);
    void loadData(String fileName);
}