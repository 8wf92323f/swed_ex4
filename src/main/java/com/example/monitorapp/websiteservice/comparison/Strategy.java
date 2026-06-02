package com.example.monitorapp.websiteservice.comparison;

public interface Strategy {
    /**
     * @return true if both HTML sites are considered equal
     */
    boolean compare(String html1, String html2);
}
