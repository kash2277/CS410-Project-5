#include <Arduino.h>
#include <WiFiClientSecure.h>
#include <SPIFFS.h>
#include "at_client.h"

#include "constants.h"

const int JOYSTICK_X_PIN = 35; 
const int JOYSTICK_Y_PIN = 34;
const int JOYSTICK_B_PIN = 22; 

    const auto *at_sign = new AtSign("@technological25"); 
	const auto *java = new AtSign("@leopeaceful21");

    const auto keys = keys_reader::read_keys(*at_sign); 
    

    auto *at_client = new AtClient(*at_sign, keys);  
    

	const auto *at_key = new AtKey("JTD", at_sign, java);

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

    String data = String(x_value) + "," + String(y_value) + "," + String(b_state);

    at_client->put_ak(*at_key, data.c_str());
    
    delay(1000);
}