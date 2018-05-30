# Android-Asynchronous-Http-Client-In-Kotlin
Implementing Android Asynchronous Http Client in Kotlin using Loopj library

### Introduction:

Loopj is an Android library for making asynchronous HTTP requests. I like it for its ease of use and simplicity. Created by James Smith, it's also known as "Android Asynchronous HTTP Client", and it's used by companies like Instagram, Pinterest, and many others. It's a good entry point to the world of HTTP libraries, and will help you understand important concepts very easily.

To learn to use this library, we are going to create MovieTrivia, a simple app that connects to a web service to retrieve information about movies or TV shows and displays this information to the user.

## 1. Setup
To start, create a new Android Studio project, with an empty activity. To include Loopj, copy the dependency from the official website. You can find the dependency under the "Installation and basic usage" section of the website (or just copy the string below). 

`compile 'com.loopj.android:android-async-http:1.4.9`

The message "Sync Now" will pop up in the upper right-hand corner. Click it so Gradle will download the library and make it available to your project.

Because the app will connect to the internet, we must declare the appropriate permission for the user to authorise. Open your AndroidManifest.xml file and, just before the application tag, write:

`<uses-permission android:name="android.permission.INTERNET"/>`

Now you are ready to start using Loopj in your app.

## Installation & Basic Usage

### Add maven dependency using Gradle buildscript in format

`
dependencies {
  compile 'com.loopj.android:android-async-http:1.4.9'
}
`

### Import the http package.

`import com.loopj.android.http.*;`

### Create a new AsyncHttpClient instance and make a request:

    AsyncHttpClient client = new AsyncHttpClient();

    client.get("https://www.google.com", new AsyncHttpResponseHandler() {

    @Override
    public void onStart() {
        // called before request is started
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
        // called when response HTTP status is "200 OK"
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
        // called when response HTTP status is "4XX" (eg. 401, 403, 404)
    }

    @Override
    public void onRetry(int retryNo) {
        // called when request is retried
	}
    });
### Resource Link:

[https://code.tutsplus.com/tutorials/an-introduction-to-loopj--cms-26781](https://code.tutsplus.com/tutorials/an-introduction-to-loopj--cms-26781)

[http://loopj.com/android-async-http/](http://loopj.com/android-async-http/)

![](https://raw.githubusercontent.com/Priyanka-Mohanty/Android-Asynchronous-Http-Client-In-Kotlin/master/Screenshot_20180530-121011.png)

![](https://raw.githubusercontent.com/Priyanka-Mohanty/Android-Asynchronous-Http-Client-In-Kotlin/master/Screenshot_20180530-121015.png)
