#include <ESP8266WiFi.h>
//#include <WiFiClient.h>
#include <PubSubClient.h>

#include <iostream>
#include <cstring>
#include <string>  

#ifndef STASSID
#define STASSID "***"
#define STAPSK "***"
#endif

const char* mqtt_server = "192.168.1.149";

const char* ssid = STASSID;
const char* password = STAPSK;


WiFiClient espClient;
PubSubClient client(espClient);


void callback(char* topic, byte* payload, unsigned int length) {
String x = (char*) payload ;
int loanRequest = x.toInt();
sendLoans(loanRequest);
}


void reconnect() {
 // Loop until we're reconnected
 while (!client.connected()) {
 Serial.print("Attempting MQTT connection...");
 // Attempt to connect

 String bankId = "banks";
 char mynameis[13];
 bankId.toCharArray(mynameis,bankId.length()+1);

 if (client.connect(mynameis)) {
  Serial.println("connected");
  // ... and subscribe to topic
  client.subscribe("loanRequest");
 } else {
  Serial.print("failed, rc=");
  Serial.print(client.state());
  Serial.println(" try again in 5 seconds");
  // Wait 5 seconds before retrying
  delay(5000);
  }
 }
}


void setup(void) {

  Serial.begin(115200);
  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);
  Serial.println("");

  // Wait for connection
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.print("Connected to ");
  Serial.println(ssid);
  Serial.print("IP address: ");
  Serial.println(WiFi.localIP());
  
  //setup MQTT server
  delay(1000);
  client.setServer(mqtt_server, 1883);
  client.setCallback(callback);
}





// this function makes 3 bankoffers, based on 
void sendLoans(int loanRequest){
  Serial.println("doing math");
  Serial.println(loanRequest);
  //loan 1
  int intrest1 = 105;
  int cost1 = 1000;
  int loanOffer1 = (loanRequest * intrest1) / 100 + cost1; 
  //loan 2
  int intrest2 = 110;
  int cost2 = 500;
  int loanOffer2 = (loanRequest * intrest2) / 100 + cost2; 
  //loan 3
  int intrest3 = 125;
  int cost3 = 0;
  int loanOffer3 = (loanRequest * intrest3) / 100 + cost3; 
  
  Serial.println("done math");
  // Make the strings of offers to send out
  String bank1 = "bank1";
  String bank2 = "bank2";
  String bank3 = "bank3";
  String loanOffer1String = bank1 + ":" + loanOffer1;
  String loanOffer2String = bank2 + ":" + loanOffer2;
  String loanOffer3String = bank3 + ":" + loanOffer3;

  Serial.println("Done math strings");
  char msg[50];
  //send out the loan offers on channel loanOffer
  loanOffer1String.toCharArray(msg,loanOffer1String.length()+1);  
  client.publish("loanOffer",msg);

  //delay(500);

  loanOffer2String.toCharArray(msg,loanOffer2String.length()+1);  
  client.publish("loanOffer",msg);

  //delay(500);

  loanOffer3String.toCharArray(msg,loanOffer3String.length()+1);  
  client.publish("loanOffer",msg);
}



void loop(void) {
if (!client.connected()) {
  reconnect();
  }
client.loop();
}
