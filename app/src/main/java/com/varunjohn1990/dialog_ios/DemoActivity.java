package com.varunjohn1990.dialog_ios;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.varunjohn1990.iosdialogs4android.IOSDialog;
import com.varunjohn1990.iosdialogs4android.IOSDialogButton;
import com.varunjohn1990.iosdialogs4android.IOSDialogMultiOptionsListeners;

import java.util.ArrayList;
import java.util.List;


public class DemoActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        context = this;
    }

    public void showDialog(View view) {
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
    }

    public void type1(View view) {
        new IOSDialog.Builder(this)
                .message(R.string.dialog_message)
                .build()
                .show();
    }

    public void type2(View view) {
        new IOSDialog.Builder(context)
                .title("Android OS")
                .message(R.string.description)
                .cancelable(false)
                .build()
                .show();
    }

    public void type3(View view) {
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
    }

    public void type4(View view) {
        List<IOSDialogButton> iosDialogButtons = new ArrayList<>();

        iosDialogButtons.add(new IOSDialogButton(1, "Add new user", true, IOSDialogButton.TYPE_POSITIVE));
        iosDialogButtons.add(new IOSDialogButton(2, "Check user status"));
        iosDialogButtons.add(new IOSDialogButton(3, "Logout all user", false, IOSDialogButton.TYPE_NEGATIVE));
        iosDialogButtons.add(new IOSDialogButton(4, "Remove user by id", true, IOSDialogButton.TYPE_NEGATIVE));

        new IOSDialog.Builder(this)
                .title("Android OS")
                .message(R.string.dialog_message)
                .multiOptions(true)
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
                        }
                    }
                })
                .iosDialogButtonList(iosDialogButtons)
                .build()
                .show();
    }
}
