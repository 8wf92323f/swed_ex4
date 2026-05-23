public class Preferences {
    private float frequency;
    private CommunicationChannel notificationChannel;

    public Preferences(float frequency, CommunicationChannel notificationChannel) {
        this.frequency = frequency;
        this.notificationChannel = notificationChannel;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public void setNotificationChannel(CommunicationChannel notificationChannel) {
        this.notificationChannel = notificationChannel;
    }

    public float getFrequency() {
        return this.frequency;
    }

    public CommunicationChannel getNotificationChannel() {
        return this.notificationChannel;
    }
}
