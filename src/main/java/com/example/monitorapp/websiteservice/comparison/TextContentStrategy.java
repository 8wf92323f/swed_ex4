package com.example.monitorapp.websiteservice.comparison;

/**
 * Compared two HTML strings by comparing the full strings.
 */
public class TextContentStrategy implements Strategy{
    @Override
    public boolean compare(String html1, String html2) {
        return html1.equals(html2);
    }
}
