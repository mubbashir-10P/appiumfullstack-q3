# Appium Fullstack training course content.
| S.no  | Branch Name   | Description   | Branch URL   |
|:-----:| :------------: | :------------: | :------------: |
|   1   |Session-1  |Introduction to Appium/Desired capabilities.   | https://github.com/mubbashir-10P/appiumfullstack-q3/tree/session-1  |
|   2   |Session-2   |UIAutomator2 - Selectors   |https://github.com/mubbashir-10P/appiumfullstack-q3/tree/session-2   |
|   3   |Session-3   |Android Gestures   |https://github.com/mubbashir-10P/appiumfullstack-q3/tree/session-3   |
|   4   | Session-4  |Framework Development- Project Structure - POM   |https://github.com/mubbashir-10P/appiumfullstack-q3/tree/session-4   |
|   5   | Session-5   |Read android capabilities from config file.   |https://github.com/mubbashir-10P/appiumfullstack-q3/tree/session-5   |
|   6   | Session-6  | Start Appium from Code - Added more test cases |https://github.com/mubbashir-10P/appiumfullstack-q3/tree/session-6   |
|   7   |Session-7   |Log4j2- testNG listeneres.    | https://github.com/mubbashir-10P/appiumfullstack-q3/tree/session-7  |
|   8   |Session-8 |Extent Report - Screenshots |https://github.com/mubbashir-10P/appiumfullstack-q3/tree/session-8   |
|   9   |Session-9 |Continous Integration via Jenkins|  |
|  10   |Bonus | Test data handling | | 

# Appium Installation Guide.

## Steps

##### 1. Install Node.js
- Download and install Node.js from [Node.js](https://nodejs.org/en/)
- Check if Node.js is installed by running the following command in the terminal:
```bash
node -v
```
- Check if npm is installed by running the following command in the terminal:
```bash
npm -v
```

##### 2. Install Appium
- Install Appium by running the following command in the terminal:
```bash
npm install -g appium
npm install -g appium@next
```
- Install Appium Doctor by running the following command in the terminal [This tool helps diagnose and fix common Appium installation ]:
```bash
npm install -g appium-doctor
npm appium-doctor   # To check if Appium doctor is installed correctly
```
- Install Appium Desktop by downloading the Appium Desktop from [Appium Desktop]
```bash
npm install -g appium-desktop
```
- Start Appium Server by running the following command in the terminal:
```bash
appium
```

##### 3. Install UiAutomator2 Plugin
- Install UiAutomator2 Plugin by running the following command in the terminal:
```bash
appium driver install uiautomator2
```
- Update Uiautomator2 plugin by running the following command in the terminal:
```bash
appium driver update uiautomator2
```
- List All the plugins installed in appium server by running the following command in the terminal:
```bash
appium driver list
```
##### 4. Install Appium Inspector
- Download and install Appium Inspector from [Appium Inspector](https://github.com/appium/appium-inspector/releases/download/v2024.2.2/Appium-Inspector-windows-2024.2.2.exe)

##### 5. Update Appium Server (Optional: Only if you want to update Appium Server)
- Update Appium Server by running the following command in the terminal:
```bash
npm install --location=global appium
```
- List appium servers installed by running the following command in the terminal:
```bash
npm list appium -g 
```
