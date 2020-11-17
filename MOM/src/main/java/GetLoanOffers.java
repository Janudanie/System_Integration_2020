import org.eclipse.paho.client.mqttv3.*;

public class GetLoanOffers extends Thread{
    private String broker       = "tcp://192.168.1.149:1883";

    private boolean doStop = false;
    public synchronized void doStop() {
        this.doStop = true;
    }
    private synchronized boolean keepRunning() {
        return this.doStop == false;
    }

    public void run(){

        try {
            MqttClient client = new MqttClient(broker, "test");
            MqttCallback callback = new MqttCallback() {

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    String temp = message.toString();
                    String bank = temp.substring(0,5);
                    String loanCost = temp.substring(6,temp.length());
                    System.out.println(bank + ":" + loanCost);
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                }

                @Override
                public void connectionLost(Throwable cause) {
                    cause.printStackTrace();

                }
            };

            client.connect();
            client.subscribe("loanOffer");
            client.setCallback(callback);
            while(keepRunning()){
            }

            client.disconnect();
            client.close();

        }
        catch(MqttException me){
            System.out.println(me);
        }
    }
}
