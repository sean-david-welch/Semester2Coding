package taba;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttNewsSubscriber {
    private static final System.Logger logger = System.getLogger(MqttNewsSubscriber.class.getName());

    public static void main(String[] args) {
        // Local MQTT broker
        String brokerUrl = "tcp://localhost:1883";
        // Unique ID for the subscriber client
        String clientId = "newsSubscriber";

        try (MqttClient client = new MqttClient(brokerUrl, clientId)) {

            // Setting the callback to handle incoming messages and connection loss
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    // Callback if the connection is lost
                    logger.log(System.Logger.Level.ERROR,"Connection lost: " + cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) {
                    // This method is invoked when a message arrives
                    logger.log(System.Logger.Level.INFO,"Received news from topic: " + topic);
                    logger.log(System.Logger.Level.INFO,"Message: " + new String(message.getPayload()));
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    // Not needed for subscriber, only for publishers
                }
            });

            client.connect();  // Connect to the MQTT broker

            // Subscribe to the first topic: Ireland/Sports/Rugby
            String subscriptionTopic1 = "Ireland/Sports/Rugby";
            client.subscribe(subscriptionTopic1);
            logger.log(System.Logger.Level.INFO,"Subscribed to topic: " + subscriptionTopic1);

            // Subscribe to the second topic: USA/Business/Markets
            String subscriptionTopic2 = "USA/Business/Markets";
            client.subscribe(subscriptionTopic2);
            logger.log(System.Logger.Level.INFO,"Subscribed to topic: " + subscriptionTopic2);

            // Keep the application running to receive messages indefinitely
            logger.log(System.Logger.Level.INFO,"Listening for messages. Press Ctrl+C to exit.");
            Thread.sleep(Long.MAX_VALUE);  // Keeps the subscriber alive indefinitely

        } catch (MqttException | InterruptedException e) {
            // Log the error if the subscription or message reception fails
            logger.log(System.Logger.Level.ERROR, "An error occurred in the MQTT subscriber", e);
        }
    }
}
