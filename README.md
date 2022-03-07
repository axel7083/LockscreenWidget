# LockscreenWidget

Samsung Lockscreen widget implementation.

Lockscreen             |  Settings
:-------------------------:|:-------------------------:
![](https://github.com/axel7083/LockscreenWidget/blob/main/screenshots/lockscreen.jpg)  |  ![](https://github.com/axel7083/LockscreenWidget/blob/main/screenshots/settings.jpg)
 
Since some Samsung application which are not installed by default could add a Lock Screen widget, it was certainly possible to add our own if Samsung did not put extra security to prevent us from doing it. Thankfully, anyone can add a “FaceWidget”.

## Compatible
- Samsung Galaxy S10 (Android 11)

If you tested on your samsung device, and it works, please open an issue for telling me.

# Under the Hood

The Lock screen Face Widgets are very dissimilar to Home Screen widget. The Samsung implementation are using [RemoteViews](https://developer.android.com/reference/android/widget/RemoteViews) which have some limitation, making it hard to port Home Screen widgets.

## Permission 
Samsung define a custom permission that is needed in the AndroidManifest.xml 
```xml
<uses-permission android:name="com.samsung.systemui.permission.FACE_WIDGET" />
```

## Config file

You need to create a file in `res/raw/facewidget.json` with the following content (you can change it)

```json
{
  "record": {
    "type": 0, <= Unknown (optional) 
    "menuInSetting": 1, <= Position by default (mandatory)
    "labelResNameInSetting": "app_name", <= The name displayed (mandatory)
    "changeCurrentPage": true, <= Unknown (optional) 
    "systemUserOnly": true, <= Unknown (optional) 
    "additionalInfo": true, <= Unknown (optional) 
    "actionDetailSetting": "com.github.axel7083.facewidget.settings.FACE_WIDGET" <= The action intent used for settings (optional) 
  }
}
```

## Broadcast Receiver

You need to create a (static) broadcast receiver, to handle the `com.samsung.android.intent.action.REQUEST_SERVICEBOX_REMOTEVIEWS` action (using intent-filter). It is sent to require you to build and sent the Remoteview to the systemui.
After building the view, it needs to be send broadcast to package 'com.android.systemui' with the `com.samsung.android.intent.action.RESPONSE_SERVICEBOX_REMOTEVIEWS` action.

## Checking if our widget is activated

In the LockUtils.java class, the function isWidgetChecked can be used.
It checked the [Settings.System](https://developer.android.com/reference/android/provider/Settings.System) using the key `face_widget_order`
