import java.lang.System;

/**
 * Changes from the diagram:
 *
 * The Subscription class stores the user it is for,
 * in order to send a notification in the update function.
 *
 * The Subscription object has an additional lastCheckedTime timestamp,
 * in order to recognize enough time to issue a new update check has passed.
 *
 * The update function has the systems website monitor as parameter,
 * in order to perform website update checks.
 */
public class Subscription {
    private final User user;
    private String url;
    private Preferences preferences;
    private long lastCheckedTime;

    public Subscription(User user, String url, Preferences preferences) {
        this.user = user;
        this.url = url;
        this.preferences = preferences;
    }

    public void update(WebsiteMonitor websiteMonitor) {
        long now = System.currentTimeMillis();

        // calculate pause time between update checks in ms
        float msPerMinute = 60.0F * 1000.0F;
        float updatesPerMinute = this.preferences.getFrequency();
        long updateTimePause = (long)(msPerMinute / updatesPerMinute);

        if (now >= this.lastCheckedTime + updateTimePause) {
            this.lastCheckedTime = now;

            String content = websiteMonitor.getUpdates(this.url);

            if (!content.isEmpty()) {
                Notification notification = new Notification(content);

                CommunicationChannel notificationChannel = this.preferences.getNotificationChannel();
                notificationChannel.sendNotification(this.user, notification);
            }
        }
    }

    public void setUrl(String url) {
        this.url = url;
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
