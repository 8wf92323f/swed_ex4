package com.example.monitorapp.websiteservice;

public interface WebsiteMonitor {
    String getState();

    void update();

    void attachObserver(WebsiteObserver observer);

    void detachObserver(WebsiteObserver observer);
}
