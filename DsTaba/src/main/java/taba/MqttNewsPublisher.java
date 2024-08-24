package taba;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttNewsPublisher {

    public static void main(String[] args) {
        String brokerUrl = "tcp://broker.hivemq.com:1883"; // Public HiveMQ broker
        String clientId = "newsPublisher";
        
        try {
            MqttClient client = new MqttClient(brokerUrl, clientId);
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

            // Disconnect after publishing
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
