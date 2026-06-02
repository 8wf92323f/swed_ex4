package com.example.monitorapp;

import com.example.monitorapp.communication.CommunicationChannel;
import com.example.monitorapp.communication.EmailCommunicationChannel;
import com.example.monitorapp.user.Preferences;
import com.example.monitorapp.user.User;

public class Main {
    public static void main(String[] args) {
        Application application = new Application();
        CommunicationChannel emailCommunicationChannel = new EmailCommunicationChannel();

        User john = new User("John Doe");
        john.registerSubscription("www.example1.com", new Preferences(1.0F, emailCommunicationChannel));
        //john.registerSubscription("www.example2.com", new Preferences(2.0F, emailCommunicationChannel));
        application.addUser(john);

        User jane = new User("Jane Doe");
        //jane.registerSubscription("www.example1.com", new Preferences(1.0f, emailCommunicationChannel));
        application.addUser(jane);

        application.run();
    }
}
