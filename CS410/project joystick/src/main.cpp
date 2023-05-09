#include <Arduino.h>
#include <WiFiClientSecure.h>
#include <SPIFFS.h>
#include "at_client.h"

#include "constants.h"

// Defining the pins for the joystick

const int JOYSTICK_X_PIN = 35; 
const int JOYSTICK_Y_PIN = 34;
const int JOYSTICK_B_PIN = 36; 

    // Defining the at_sign for the sender and receiver

     const auto *at_sign = new AtSign("@technological25"); 
	const auto *java = new AtSign("@leopeaceful21");

    const auto keys = keys_reader::read_keys(*at_sign); // Read the keys for authentication 
    
    auto *at_client = new AtClient(*at_sign, keys);     // Creating a new at_client
    

	const auto *at_key = new AtKey("JTD", at_sign, java); // Creating a new at_key for the message


void setup()
{
 
    pinMode(JOYSTICK_X_PIN, INPUT);
    pinMode(JOYSTICK_Y_PIN, INPUT); 
    pinMode(JOYSTICK_B_PIN, INPUT);


    
    at_client->pkam_authenticate(SSID, PASSWORD);  

}

void loop()
{   
     
    int x_value = analogRead(JOYSTICK_X_PIN);
    int y_value = analogRead(JOYSTICK_Y_PIN);
    int b_state = digitalRead(JOYSTICK_B_PIN);


   
    String data = String(x_value) + "," + String(y_value) + "," + String(b_state);  // Creating a string with the joystick values


     
    at_client->put_ak(*at_key, data.c_str());  
    
    delay(100);
}
