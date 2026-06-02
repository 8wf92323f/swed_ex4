package com.example.monitorapp.websiteservice;

import com.example.monitorapp.websiteservice.comparison.Strategy;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWebsiteMonitor implements WebsiteMonitor {
    private final List<WebsiteObserver> observers = new ArrayList<>();
    private final String url;
    private Strategy strategy = (s1, s2) -> false;
    private String websiteState = null;

    public AbstractWebsiteMonitor(String url) {
        this.url = url;
    }

    @Override
    public void update() {
        String newWebsiteState = this.fetchWebsiteState();

        if (newWebsiteState == null) return;

        if (this.websiteState == null || this.strategy.compare(this.websiteState, newWebsiteState)) {
            this.websiteState = newWebsiteState;

            for (WebsiteObserver observer : this.observers) {
                observer.update();
            }
        }
    }

    @Override
    public void attachObserver(WebsiteObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void detachObserver(WebsiteObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public String getState() {
        return this.websiteState;
    }

    @Override
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public String getUrl() {
        return this.url;
    }

    protected abstract String fetchWebsiteState();
}
