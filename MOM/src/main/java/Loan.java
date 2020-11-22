import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import static java.lang.Thread.sleep;

public class Loan {
    private String broker       = "tcp://192.168.1.149:1883";
    private String[] banks = {"bank1","bank2","bank3"};

    private int loanCost[] = new int[3] ;
    private int loanAmount;


    public Loan(int loanAmount) {
        this.loanAmount = loanAmount;
    }

//Kan laves om til to array banknavn[] / loanCost[]
    public void setBank1LoanCost(int bank1LoanCost) {
        this.loanCost[0] = bank1LoanCost;
    }

    public void setBank2LoanCost(int bank2LoanCost) {
        this.loanCost[1] = bank2LoanCost;
    }

    public void setBank3LoanCost(int bank3LoanCost) {
        this.loanCost[2] = bank3LoanCost;
    }

    public String getLowestOffer(){
        int cheapestLoanOffer = 0;

        for(int x = 0 ; x<loanCost.length;x++){
            if(loanCost[cheapestLoanOffer] > loanCost[x] )cheapestLoanOffer = x;
        }
        String temp = "Billigst tilbud er fra " + banks[cheapestLoanOffer] + " , hvor der koster " + loanCost[cheapestLoanOffer] + " at låne";
        return temp;
    }

    public void requestLoanCost()  {
        GetLoanOffers gt = new GetLoanOffers(this );
        gt.start();
        sendLoanRequest(loanAmount);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gt.doStop();
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
            //System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            //System.out.println("Connected");
            //System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());

            sampleClient.publish(topic, message);
            //System.out.println("Message published");
            sampleClient.disconnect();
            //System.out.println("Disconnected");
            //System.exit(0);
        } catch(MqttException me) {
            //System.out.println("reason "+me.getReasonCode());
            //System.out.println("msg "+me.getMessage());
            //System.out.println("loc "+me.getLocalizedMessage());
            //System.out.println("cause "+me.getCause());
            //System.out.println("excep "+me);
            me.printStackTrace();
        }
    }
}
