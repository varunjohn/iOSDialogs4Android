# iOSDialogs4Android
Its a library to show iOS like AlertView in Android as Dialogs with similar animations.

![ezgif-2-83e6a67994e5](https://user-images.githubusercontent.com/24667361/75472665-d96f6700-59b9-11ea-886a-809d4fe92249.gif)

## Gradle dependency

[ ![Download](https://api.bintray.com/packages/varunjohn1990/Maven/iosdialogs4android/images/download.svg) ](https://bintray.com/varunjohn1990/Maven/iosdialogs4android/_latestVersion)

Add this dependency in your app level build.gradle file

```
implementation 'com.varunjohn1990.libraries:iosdialogs4android:2.0.0'
```

## How to use

Just use this friendly builder pattern to show the Dialog.

### For simple message
```
  new IOSDialog.Builder(this)
                .message(R.string.dialog_message) // String or String Resource ID
                .build()
                .show();
```

### For 2 options

```
  new IOSDialog.Builder(context)
                .title("iOS Dialogs")              // String or String Resource ID
                .message(R.string.dialog_message)  // String or String Resource ID
                .positiveButtonText("Yeah, sure")  // String or String Resource ID
                .negativeButtonText("No Thanks")   // String or String Resource ID
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
                })
                .build()
                .show();
```

### For multiple options

```
List<IOSDialogButton> iosDialogButtons = new ArrayList<>();
iosDialogButtons.add(new IOSDialogButton(1, "Add new user", true, IOSDialogButton.TYPE_POSITIVE));
iosDialogButtons.add(new IOSDialogButton(2, "Check user status"));
iosDialogButtons.add(new IOSDialogButton(3, "Logout all user", false, IOSDialogButton.TYPE_NEGATIVE));

new IOSDialog.Builder(this)
                .title("iOS Dialogs")              // String or String Resource ID
                .message(R.string.dialog_message)  // String or String Resource ID
                .multiOptions(true)                // Set this true other it will not work
                .multiOptionsListeners(new IOSDialogMultiOptionsListeners() {
                    @Override
                    public void onClick(IOSDialog iosDialog, IOSDialogButton iosDialogButton) {
                        iosDialog.dismiss();

                        switch (iosDialogButton.getId()) {
                            case 1:
                                Toast.makeText(context, "Add new user", Toast.LENGTH_SHORT).show();
                            case 2:
                                Toast.makeText(context, "Check user status", Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                Toast.makeText(context, "Logout all user", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .iosDialogButtonList(iosDialogButtons)
                .build()
                .show();
```

### All available options

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
