package com.example.monitorapp.user;

import com.example.monitorapp.communication.CommunicationTarget;

import java.util.ArrayList;
import java.util.List;

public class User implements CommunicationTarget {
    private final String name;
    private final List<Subscription> subscriptions;

    public User(String name) {
        this.name = name;
        this.subscriptions = new ArrayList<>();
    }

    public void registerSubscription(String url, Preferences preferences) {
        this.subscriptions.add(new Subscription(this, url, preferences));
    }

    public void cancelSubscription(String url) {
        for (Subscription subscription : this.subscriptions) {
            if (subscription.getUrl().equals(url)) {
                this.subscriptions.remove(subscription);
                subscription.cancel();
            }
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String getEmail() {
        return this.getName().toLowerCase().replace(' ', '.') + "@examplemail.com";
    }
}
