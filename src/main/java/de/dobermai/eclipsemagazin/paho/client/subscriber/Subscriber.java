package de.dobermai.eclipsemagazin.paho.client.subscriber;

import de.dobermai.eclipsemagazin.paho.client.util.Utils;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * @author Dominik Obermaier
 */
public class Subscriber {

    public static final String BROKER_URL = "tcp://broker.mqttdashboard.com:1883";

    //We have to generate a unique Client id.
    String clientId = Utils.getMacAddress() + "-sub";
    private MqttClient mqttClient;

    public Subscriber() {

        try {
            mqttClient = new MqttClient(BROKER_URL, clientId);
            mqttClient.setCallback(new SubscribeCallback());
            mqttClient.connect();

            mqttClient.subscribe("#");

        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String...args) {
        new Subscriber();
    }

}
