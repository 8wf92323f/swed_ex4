package com.example.monitorapp.websiteservice.comparison;

/**
 * Compared two HTML strings by comparing the actual HTML content,
 * i.e. if both websites produce the same website structure, they are equal.
 */
public class HtmlContentStrategy implements Strategy {
    @Override
    public boolean compare(String html1, String html2) {
        throw new UnsupportedOperationException("TODO");
    }
}
