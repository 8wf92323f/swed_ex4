package com.example.monitorapp.websiteservice.comparison;

/**
 * Compared two HTML strings by comparing the string lengths.
 */
public class SizeStrategy implements Strategy {
    @Override
    public boolean compare(String html1, String html2) {
        return html1.length() == html2.length();
    }
}
