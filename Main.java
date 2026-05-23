public class Main {
    public static void main(String[] args) {
        System system = new System();

        User user = new User("John Doe");
        system.addUser(user);

        Preferences preferences = new Preferences(60.0F, new EmailCommunicationChannel());
        user.registerSubscription("examplewebsite.com", preferences);

        system.update();
    }
}
