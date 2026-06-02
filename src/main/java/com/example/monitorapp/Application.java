package com.example.monitorapp;

import com.example.monitorapp.user.User;
import com.example.monitorapp.websiteservice.DummyWebsiteMonitor;
import com.example.monitorapp.websiteservice.WebsiteMonitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Application {
    private static Application singleton = null;
    private final List<User> users = new ArrayList<>();
    private final Map<String, WebsiteMonitor> monitors = new HashMap<>();

    public Application() {
        if (singleton != null) throw new UnsupportedOperationException("Application class follow singleton design!");

        singleton = this;
    }

    public void run() {
        while (true) {
            this.monitors.values().forEach(WebsiteMonitor::update);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Interrupted Exception: " + e.getMessage());
                break;
            }
        }
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public static WebsiteMonitor getMonitorFor(String url) {
        if (singleton == null) {
            throw new IllegalStateException("Should not call getMonitorFor before initializing the application!");
        }

        return singleton.monitors.computeIfAbsent(url, DummyWebsiteMonitor::new);
    }
}
