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