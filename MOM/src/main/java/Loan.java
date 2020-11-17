import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import static java.lang.Thread.sleep;

public class Loan {
    private String broker       = "tcp://192.168.1.149:1883";


    private int bank1LoanCost;
    private int bank2LoanCost;
    private int bank3LoanCost;
    private int loanAmount;

    public Loan(int loanAmount) {
        this.loanAmount = loanAmount;
    }


    public void setBank1LoanCost(int bank1LoanCost) {
        this.bank1LoanCost = bank1LoanCost;
    }

    public void setBank2LoanCost(int bank2LoanCost) {
        this.bank2LoanCost = bank2LoanCost;
    }

    public void setBank3LoanCost(int bank3LoanCost) {
        this.bank3LoanCost = bank3LoanCost;
    }

    public void requestLoanCost()  {
        GetLoanOffers gt = new GetLoanOffers();
        gt.start();

        sendLoanRequest(loanAmount);
      while (true){}


    }




    private void sendLoanRequest(int loanRequest){

        String topic        = "loanRequest";
        String content      =  "" + loanRequest;

        String clientId     = "BankClient";
        MemoryPersistence persistence = new MemoryPersistence();


        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());

            sampleClient.publish(topic, message);
            System.out.println("Message published");
            sampleClient.disconnect();
            System.out.println("Disconnected");
            //System.exit(0);
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }

    }
}
