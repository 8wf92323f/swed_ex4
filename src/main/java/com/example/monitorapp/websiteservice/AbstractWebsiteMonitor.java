package com.example.monitorapp.websiteservice;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWebsiteMonitor implements WebsiteMonitor {
    private final List<WebsiteObserver> observers = new ArrayList<>();
    protected final String url;
    private String websiteState = null;

    public AbstractWebsiteMonitor(String url) {
        this.url = url;
    }

    @Override
    public void update() {
        String newWebsiteState = this.fetchWebsiteState();

        if (newWebsiteState != null && !newWebsiteState.equals(this.websiteState)) {
            this.websiteState = newWebsiteState;

            this.observers.forEach(WebsiteObserver::update);
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

    protected abstract String fetchWebsiteState();
}
