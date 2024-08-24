package taba;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttNewsSubscriber {
    private static final System.Logger logger = System.getLogger(MqttNewsPublisher.class.getName());

    public static void main(String[] args) {
        String brokerUrl = "tcp://broker.hivemq.com:1883"; // Public HiveMQ broker
        String clientId = "newsSubscriber";

        // Try-with-resources block to ensure the MqttClient is closed automatically
        try (MqttClient client = new MqttClient(brokerUrl, clientId)) {

            // Set a callback to handle incoming messages
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Connection lost: " + cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("Received news from topic: " + topic);
                    System.out.println("Message: " + new String(message.getPayload()));
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    // Not used for subscribers
                }
            });

            client.connect();

            // Subscribe to a specific topic, e.g., "USA/Sports/#" for all sports news in the USA
            String country = "USA";
            String category = "Sports";
            String subscriptionTopic = country + "/" + category + "/#"; // Wildcard for all sports events

            client.subscribe(subscriptionTopic);
            System.out.println("Subscribed to topic: " + subscriptionTopic);

            // Keep the application running to receive messages
            System.out.println("Listening for messages. Press Ctrl+C to exit.");
            Thread.sleep(Long.MAX_VALUE); // Keeps the subscriber alive indefinitely

        } catch (MqttException | InterruptedException e) {
            logger.log(System.Logger.Level.ERROR, "An error occurred in the message queueing subscriber", e);
        }
    }
}
