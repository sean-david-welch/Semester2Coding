package taba;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.IOException;

public class MqttNewsPublisher {
    private static final System.Logger logger = System.getLogger(MqttNewsPublisher.class.getName());

    public static void main(String[] args) {
        // Local MQTT broker
        String brokerUrl = "tcp://localhost:1883";
        String clientId = "newsPublisher";

        Process mosquittoProcess = startMosquittoBroker();

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
        } finally {
            stopMosquittoBroker(mosquittoProcess);
        }
    }

    // Method to start the Mosquitto broker using the system's command line
    private static Process startMosquittoBroker() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Command to start Mosquitto broker
        processBuilder.command("mosquitto");

        try {
            Process process = processBuilder.start();  // Start Mosquitto as a process
            System.out.println("Mosquitto broker started successfully.");

            // Wait for 3 seconds to ensure the broker starts
            Thread.sleep(3000);
            // Return the process so we can shut it down later
            return process;

        } catch (IOException | InterruptedException e) {
            System.out.println("Failed to start Mosquitto broker: " + e.getMessage());
            return null;
        }
    }

    private static void stopMosquittoBroker(Process process) {
        if (process != null) {
            System.out.println("Shutting down Mosquitto broker...");
            // Kill the Mosquitto process
            process.destroy();
            System.out.println("Mosquitto broker stopped.");
        }
    }
}
