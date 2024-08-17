# **Clicker**

Clicker is a straightforward and effective app designed to help you train your cat using clicker techniques. Unlike many other apps, Clicker is completely free and ad-free.

## **Features**-**Simple and Intuitive**: Click and you will hear a sound. It's that simple. No need to navigate through menus or settings.
Made because I couldn't find a simple clicker app that was free and ad-free,

## **Getting Started**

To start using Clicker, follow these steps:

### **1. Clone the Repository**

First, clone this repository to your local machine:

```bash
git clone https://github.com/Samer-Ismael/Clicker.git

```

### **2. Build the app**

```bash
./gradlew clean build
```

### **3. Assemble the APK**

```bash
./gradlew assembleDebug
```


## **Installing**

You can ether get the APK and install it on your device, like just sending the APK to your device and installing it.
Or you can use the following steps to install the APK using ADB.

### **4. Retrieve the APK**

```bash
app/build/outputs/apk/debug/app-debug.apk
```

### **5. Install the APK**

```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```
