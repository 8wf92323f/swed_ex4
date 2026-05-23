import java.util.ArrayList;
import java.util.List;

/**
 * Changes from the diagram:
 *
 * addUser function for adding users to the monitoring system
 */
public class System {
    private final List<User> users;
    private final WebsiteMonitor websiteMonitor;

    public System() {
        this.users = new ArrayList<>();
        this.websiteMonitor = new WebsiteMonitorImplementation();
    }

    public void update() {
        while (true) {
            for (User user : this.users) {
                user.update(this.websiteMonitor);
            }
        }
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
