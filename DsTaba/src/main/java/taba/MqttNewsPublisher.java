package taba;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttNewsPublisher {
    private static final System.Logger logger = System.getLogger(MqttNewsPublisher.class.getName());

    public static void main(String[] args) {
        String brokerUrl = "tcp://broker.hivemq.com:1883"; // Public HiveMQ broker
        String clientId = "newsPublisher";

        // Try-with-resources block to ensure the MqttClient is closed automatically
        try (MqttClient client = new MqttClient(brokerUrl, clientId)) {
            client.connect();

            // Create a topic, e.g., "USA/Sports/Football"
            String country = "USA";
            String category = "Sports";
            String eventType = "Football";
            String topic = country + "/" + category + "/" + eventType;

            // Publish a message (news item)
            String newsItem = "Breaking News: Football finals happening tonight!";
            MqttMessage message = new MqttMessage(newsItem.getBytes());
            message.setQos(2); // Set quality of service level

            // Publish the message to the topic
            client.publish(topic, message);
            System.out.println("News published to topic: " + topic);

            // Disconnect after publishing (not strictly needed with try-with-resources, but good for clarity)
            client.disconnect();
        } catch (MqttException e) {
            logger.log(System.Logger.Level.ERROR, "An error occurred in the message queueing service", e);
        }
    }
}
