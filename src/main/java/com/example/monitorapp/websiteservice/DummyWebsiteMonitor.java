package com.example.monitorapp.websiteservice;

import java.util.Random;

/**
 * Example class for demonstration and testing purposes.
 * Pretends to fetch a website by selecting a random dummy HTML string
 */
public class DummyWebsiteMonitor extends AbstractWebsiteMonitor {
    private static final Random RANDOM = new Random();
    private static final String[] STATES = new String[]{
            "<html><head></head><body>State1</body></html>",
            "<html><head></head><body>State2</body></html>"
    };

    public DummyWebsiteMonitor(String url) {
        super(url);
    }

    @Override
    protected String fetchWebsiteState() {
        return STATES[RANDOM.nextInt(STATES.length)];
    }
}
