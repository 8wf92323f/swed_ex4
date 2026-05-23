import java.lang.System;

/**
 * Example class for demonstration purposes.
 * The Class pretends like it sends emails by printing it to the console.
 */
public class EmailCommunicationChannel implements CommunicationChannel {
    @Override
    public void sendNotification(User user, Notification notification) {
        String address = user.getName().toLowerCase().replace(' ', '.') + "@examplemail.com";
        String message = notification.getContent();

        System.out.println("Email sent to " + address);
        System.out.println("Content:");
        System.out.println(message);
        System.out.println();
    }
}
