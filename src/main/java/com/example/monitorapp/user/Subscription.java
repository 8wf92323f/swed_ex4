package com.example.monitorapp.user;

import com.example.monitorapp.Application;
import com.example.monitorapp.communication.CommunicationChannel;
import com.example.monitorapp.communication.Notification;
import com.example.monitorapp.websiteservice.WebsiteMonitor;
import com.example.monitorapp.websiteservice.WebsiteObserver;

public class Subscription implements WebsiteObserver {
    private final User user;
    private String url;
    private WebsiteMonitor websiteMonitor;
    private Preferences preferences;
    private String websiteState = null;

    public Subscription(User user, String url, Preferences preferences) {
        this.user = user;
        this.url = url;
        this.preferences = preferences;

        this.websiteMonitor = Application.getMonitorFor(this.url);
        this.websiteMonitor.attachObserver(this);
    }

    public void update() {
        this.websiteState = this.websiteMonitor.getState();

        String message = this.url + " changed:\n" + this.websiteState;
        Notification notification = new Notification(message);

        CommunicationChannel notificationChannel = this.preferences.getNotificationChannel();
        notificationChannel.sendNotification(this.user, notification, this.preferences.getFrequency());
    }

    public void cancel() {
        this.websiteMonitor.detachObserver(this);
    }

    public void setUrl(String url) {
        if (!url.equals(this.url)) {
            this.websiteMonitor.detachObserver(this);

            this.websiteState = null;
            this.url = url;

            this.websiteMonitor = Application.getMonitorFor(url);
            this.websiteMonitor.attachObserver(this);
        }
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public String getUrl() {
        return this.url;
    }

    public Preferences getPreferences() {
        return this.preferences;
    }
}
