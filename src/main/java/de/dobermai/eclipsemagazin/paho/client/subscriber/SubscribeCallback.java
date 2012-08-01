package de.dobermai.eclipsemagazin.paho.client.subscriber;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/**
 * @author Dominik Obermaier
 */
public class SubscribeCallback implements MqttCallback {

    @Override
    public void connectionLost(Throwable cause) {
        //This is called when the connection is lost. We could reconnect here.
    }

    @Override
    public void messageArrived(MqttTopic topic, MqttMessage message) throws Exception {
        System.out.println("Message arrived. Topic: " + topic.getName() + "  Message: " + message.toString());

        if ("homeautomation/LWT".equals(topic.getName())) {
            System.err.println("Publisher gone!");
        }
    }

    @Override
    public void deliveryComplete(MqttDeliveryToken token) {
        //no-op
    }
}
