package com.example.monitorapp.websiteservice;

import java.util.Random;

/**
 * Example class for demonstration purposes.
 * The class pretends to detect a notification 10% of the time.
 */
public class WebsiteMonitorImplementation implements WebsiteMonitor {
    private static final Random RANDOM = new Random();
    private static final String[] MESSAGES = new String[]{
            "Website updated",
            "Website published new article",
            "Website published new product",
            "Website has sale"
    };

    @Override
    public String getUpdates(String url) {
        if (RANDOM.nextInt(100) < 10) {
            return "New Notification from website: " + MESSAGES[RANDOM.nextInt(MESSAGES.length)];
        }

        return "";
    }
}
