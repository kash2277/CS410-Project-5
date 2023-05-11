# CS410-Project-5
End-User Manual:
The end-user manual provides instructions on how to setup, build, run and the code. Below are the steps:

				PROJECT JOYSTICK
                    
Project Description:- 
Your IoT device (which is running an atSign) will be sensing inputs from a joystick (buttons and the joystick module). 
Send this critical data to your app (which is running an atSign) so that this data can be sent securely over the Internet. 

Project resources required :-
Java Development Kit (JDK),VScode,ESP32,PS2 Joystick Sensor Module

Project folders :-
CS410/Project joystick,JAVA


 
	**1)CS410/Project joystick documentation **
  
  For sending Joystick data from ESP32

**Installation:-**

-Install VSCode and the PlatformIO VSCode extension.

-You will need an ESP32 and a USB-A to micro-USB cable data cable to connect it to your computer.

-The atPlatform only supports the Arduino framework for the ESP32.

-Open VSCode and Go to the PlatformIO Home 

-Install the Espressif32 platform by clicking on the Platforms > Embedded tab and searching for Espressif32 and clicking on the Install button.


**Building the Project:**

 -Go to Projects and press + Create New Project. 
 
 -Give a name to your project, select the Espressif ESP32 Dev Module board, and select the "Arduino" framework.Select a location for your project and click "Finish."
 
 -Go back to the PlatformIO Home and click on the Libraries tab. Search for at_client by JeremyTubongbanua and click on the Install button. This will install the at_client library in your project. Do the same for the ArduinoJson library by Benoit Blanchon.

**Extract the folders from CS410/Project-5 into your project.**

In data folder in the root of the project,copy the .atKeys file into the data folder.The at_sign keys can be found in link https://my.atsign.com/login by creating atsign account.

In constants.h file in include folder in project joystick,change the connection credentials as per the machine the connected to ESP32.
SSID "******"
PASSWORD "******"


**Uploading the Project:**

Open the main.cpp file in the src folder and 

-Make sure to change the value of joystick pins for input reading according to your joystick connection with ESP32 and the name of the sender, recipient atsign keys and new at_key name for the message.

-Run "Build" under "Project Tasks.”This will give if there are any errors in the project.

-Now upload the project to the ESP32. First, put the ESP32 into download mode by holding down the BOOT button and pressing the RESET button while still holding the BOOT button. It should be in download mode as long as you are holding BOOT down. 

-Run "Upload and Monitor" under "Project Tasks”.Your output should be similar to the snippet below. If it is not, ensure that the .atKeys are uploaded and that you are using the correct SSID and Password.


**OUTPUT SNIPPET**

Attempting to connect to *******
..
Connected!
IP address: 12345678901

Connected to root.atsign.org:64

 06rcyYJpJkKtcK8eBDGYevE7S+n10E1qM2UJz+m58Uc8VUSR8pCYc6b50xmMaQLUjNeQqt2PqyH+gNaKjgQ6UeBdvYpJ01bPawFalTk8k8eu0q6ZGKfbAaAuXMDMvwIDAQAB import: 0
 
complete: 0

public key check: 0

plain_text: SRKOLulFV7WKPY1BAaCnRDgFJiUVkvciFXtZSUaBxDw=

73 52 6b 30 6c 75 6c 46 56 37 57 46 50 59 31 42 41 61 43 6e 52 44 67 46 4a 69 55 56 6b 76 63 69 46 58 74 5a 53 55 61 42 78 44 77 3d

seed: 0

encrypt: 0

command: update:@leopeaceful21:shared key@technological25 ShF7qKvtNTeGd3zrhceacnLeLeh/qG0K3XMt04PZ1aVIP9VyX9ctQsNZ2mmoXXCE32W
LT+s/B9ZA3cK Yg4RovYacK10qyKYknDOnBbI+YLhA2v+03JWNT sm4G/84FSBsAd/aLWzIGD/ME+5WnCifYd5qS9ZGI83PRdvdJF2VBWLCY6J3Aks11ljmqPI5e2vQv6lyI3Hjsh1M3FQ/voDfUI1YO fLATNeK3IaMRe leAqgGNm/Pqptd9HbpFrNCP1CvyKDV×7a/Ck/7IU/tgP90ykdTdkOtPGAvSkTa/eSVmCdCbYDdEiY×saSBurEJZu+5+AUAnPEjS+Np/4BUAA== encrypted value: "XhYx7hrVksX+geObiBBJR70TMUgBLaJb3e(D7 r042jU="

command: "up

date: @leopeaceful21: testatechnological25 XhYx7hrVksX+geObiBBJR70TMUgBLaJb3eD7 r042¡U=" 


response: "17"


When you have receive a value for the response as shown in above snippet, the response value indicates the number of connections made to send data from ESP32 indicating response is success.






	**2) JAVA documentation **


For Receiving Data and displaying it in a JAVA SWING(GUI) Application

**Installation:-**


-Download and install the Java Development Kit (JDK) on your system.

-Download and install an Integrated Development Environment (IDE) for Java development.VScode suggested. -Install required JAVA extensions.

-Download the code as a zip file and extract it to a folder

-Open the IDE and create a new project.

-Add the downloaded Java code files to the project.

**RUN:**

-change the name of the sender, recipient atsign keys.

-make sure at_keys in keys folder inside JAVA folder are your at_keys

-Run the Java executable file to start the console.




**OUTPUT:**

JAVA SWING App!



The console should display the joystick values received from the server using an atprotocol.The label shows single point console that moves according to the joystick module movements.

X and Y indicates horizontal and vertical movements of joystick.The X and Y default values is the default position of console on the Joystick Module and z = 1 indicates the button is pressed.

Move the joystick to change the position of the console label on the GUI console.

Press the button on the joystick to change the color of the black console label to red on the GUI console label.
 


