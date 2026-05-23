import java.util.ArrayList;
import java.util.List;

/**
 * Deviations from the diagram:
 *
 * The User has an additional getName function.
 *
 * The update function has the systems website monitor as parameter,
 * in order to pass it as a parameter for the Subscriptions update function.
 */
public class User {
    private final String name;
    private final List<Subscription> subscriptions;

    public User(String name) {
        this.name = name;
        this.subscriptions = new ArrayList<>();
    }

    public void registerSubscription(String url, Preferences preferences) {
        this.subscriptions.add(new Subscription(this, url, preferences));
    }

    public void cancelSubscription(String url) {
        this.subscriptions.removeIf(subscription -> subscription.getUrl().equals(url));
    }

    public void update(WebsiteMonitor websiteMonitor) {
        for (Subscription subscription : this.subscriptions) {
            subscription.update(websiteMonitor);
        }
    }

    public String getName() {
        return this.name;
    }
}
