# iOSDialogs4Android
Its a library to show iOS like AlertView in Android as Dialogs with similar animations.

![iosdialogs4android sample](https://user-images.githubusercontent.com/24667361/45210567-9abd8c80-b2ad-11e8-8e49-f35eb09d9e3b.gif)

## Gradle dependency

Add this dependency in your app level build.gradle file

[ ![Download](https://api.bintray.com/packages/varunjohn1990/Maven/iosdialogs4android/images/download.svg) ](https://bintray.com/varunjohn1990/Maven/iosdialogs4android/_latestVersion)

```
implementation 'com.varunjohn1990.libraries:iosdialogs4android:1.0.1'
```



## How to use

Just use this friendly builder pattern to show the Dialog. 

```
  new IOSDialog.Builder(context)
                .title("iOS Dialogs")              // String or String Resource ID
                .message(R.string.dialog_message)  // String or String Resource ID
                .positiveButtonText("Yeah, sure")  // String or String Resource ID
                .negativeButtonText("No Thanks")   // String or String Resource ID
                .cancelable(true)                  // Dialog will dismiss if clicked outside
                .enableAnimation(true)             // To enable enter and exit animations
                .positiveClickListener(new IOSDialog.Listener() {
                    @Override
                    public void onClick(IOSDialog iosDialog) {
                        iosDialog.dismiss();
                        Toast.makeText(context, "Thanks :)", Toast.LENGTH_SHORT).show();
                    }
                }).negativeClickListener(new IOSDialog.Listener() {
                    @Override
                    public void onClick(IOSDialog iosDialog) {
                        iosDialog.dismiss();
                        Toast.makeText(context, ":(", Toast.LENGTH_SHORT).show();
                    }
                }).cancelListener(new IOSDialog.Listener() {
                    @Override
                    public void onClick(IOSDialog iosDialog) {
                        Toast.makeText(context, "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                })
                .build()
                .show();
```


## About Me

Varun John<br />
Sr. Android Developer<br />
varunjohn1990@gmail.com<br />
Skype varun.john1990<br />
Follow me https://github.com/varunjohn for other samples and libraries like these

**If you like this library then please add a star :)**


## License
```
   Copyright 2018 Varun John

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
