package com.example.monitorapp.websiteservice;

import com.example.monitorapp.websiteservice.comparison.Strategy;

public interface WebsiteMonitor {
    String getState();

    void update();

    void attachObserver(WebsiteObserver observer);

    void detachObserver(WebsiteObserver observer);

    void setStrategy(Strategy strategy);
}
