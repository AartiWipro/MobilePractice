# "AmazonDemo" 

## Created Amazon framework using TestNG and Page object model

## Tool / Technologies used :
```
* Eclipse IDE for Enterprise Java Developers 2019-06 (4.12.0)
* JAVA Jdk 11.0.7 
* Node v12  
* Appium 1.15
* Android SDK 3.6.3
* Java client 7.2.0
```

For other maven dependency please Refer pom.xml file.

## Flow of the Work assignment
```
* Launch the Amazon app.
* Click on hamburger Menu.
* Click on Settings tab.
* Navigate to Settings page and click on Country/region as Australia.
* Finish
```

## How To Verify the changes (Running testcases ): 

```
First Way:
* Go to  src\test\java\testCase\VerifyCountryRegion.java
* Inside file right click --->Run (Eclipse IDE functionality)

Second Way:
* Using testng.xml file 
* Right click --->Run
```

## Important Variables & terminology need to follow
* global.properties => contains name of the APK files and device name (For Dynamic handling)
* Need to change name device => "Your device name". 
* Root directory apk application location : .\app
* Utilities class => Contains all Common functions (PATH: \src\main\java\utilities\Utilities.java )
* Assertion package => compare class => Assertions & Validations 
* listener class => contains ExtentReports and checking the failed status via screenshots 

## Important Note :
I am using real android device for automation testing, as I am not able to launch emulator from android studio.So need to connect real
andriod mobile device with laptop using USB.

   
