# "AmazonDemo" 

### Created Amazon framework using TestNG and Page object model where  VerifyCountryRegion.class is the main class responsible for updating the country /Region.

Tool / Technologies used :
1. Eclipse IDE for Enterprise Java Developers.
   Version: 2019-06 (4.12.0)
2. JAVA Jdk 11.0.7 
3. Node v12  
4. Appium 1.15
5. Android SDK 3.6.3
6. Java client 7.2.0

For other maven dependency please Refer pom.xml file.
 
Flow of the Work assignment
```
	Step 1. Launch the Amazon app.
 	Step 2.	Click on hamburger Menu.
 	Step 3.	Click on Settings tab.
 	Step 4.	Navigate to Settings page and click on Country/region as Australia.
 	Step 5: Finish
```

How To Verify the changes (Running testcases ): 

```
1 Way : go to Path : src\test\java\testCase\VerifyCountryRegion.java
right click --->Run

2. Way Using testng.xml file 
right click --->Run
```


globle.properties is containing name of the APK files and device name (For Dynamic handling)
Need to change name device= "Your device name". 
.apk application location : .\app

Utilities class having all Common functions  
Path : \src\main\java\utilities\Utilities.java

Used listener For Reporting User ExtentReports and checking the failed status 

<listener class-name = "resources.Listeners"/>
<listener class-name="extentReports.ExtentReportNG"/>


Important Note : I am using real android device for automation testing, as i am not able to launch emulator from android studio. 

   