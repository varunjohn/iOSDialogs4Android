package com.varunjohn1990.dialog_ios;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.varunjohn1990.iosdialogs4android.IOSDialog;


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
        new IOSDialog.Builder(context)
                .message(R.string.dialog_message)  // String or String Resource ID
                .positiveButtonText("Ok")  // String or String Resource ID
                .cancelable(true)                  // Dialog will dismiss if clicked outside
                .enableAnimation(true)             // To enable enter and exit animations
                .positiveClickListener(new IOSDialog.Listener() {
                    @Override
                    public void onClick(IOSDialog iosDialog) {
                        iosDialog.dismiss();
                        Toast.makeText(context, "Thanks :)", Toast.LENGTH_SHORT).show();
                    }
                })
                .build()
                .show();
    }

    public void type2(View view) {
        new IOSDialog.Builder(context)
                .title("iOS Dialogs")              // String or String Resource ID
                .message(R.string.dialog_message)  // String or String Resource ID
                .positiveButtonText("Ok")  // String or String Resource ID
                .cancelable(true)                  // Dialog will dismiss if clicked outside
                .enableAnimation(true)             // To enable enter and exit animations
                .positiveClickListener(new IOSDialog.Listener() {
                    @Override
                    public void onClick(IOSDialog iosDialog) {
                        iosDialog.dismiss();
                        Toast.makeText(context, "Thanks :)", Toast.LENGTH_SHORT).show();
                    }
                })
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
}
