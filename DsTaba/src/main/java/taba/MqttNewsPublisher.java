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

            // First Message - Ireland Rugby News
            String topic1 = "Ireland/Sports/Rugby";
            String newsItem1 = "Breaking News: Ireland defeats New Zealand in the Rugby Test Match";
            MqttMessage message1 = new MqttMessage(newsItem1.getBytes());
            message1.setQos(2); // Set quality of service level

            // Publish the first message
            client.publish(topic1, message1);
            System.out.println("News published to: " + topic1);

            // Second Message - USA Markets News
            String topic2 = "USA/Business/Markets";
            String newsItem2 = "Tesla up 25% in one day after new plans for FSD rollout";
            MqttMessage message2 = new MqttMessage(newsItem2.getBytes());
            message2.setQos(2); // Set quality of service level

            // Publish the second message
            client.publish(topic2, message2);
            System.out.println("News published to: " + topic2);

            // Disconnect after publishing
            client.disconnect();
        } catch (MqttException e) {
            logger.log(System.Logger.Level.ERROR, "An error occurred in the message queueing service", e);
        }
    }
}
