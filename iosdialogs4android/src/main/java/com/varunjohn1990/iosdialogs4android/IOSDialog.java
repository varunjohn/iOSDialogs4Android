package com.varunjohn1990.iosdialogs4android;

import android.content.Context;
import android.view.View;

/**
 * Created by Varun John on August 2018.
 */
public class IOSDialog {

    public interface Listener {
        void onClick(IOSDialog iosDialog);
    }

    private String title;
    private String message;
    private String positiveButtonText;
    private String negativeButtonText;
    private Listener positiveClickListener;
    private Listener negativeClickListener;
    private Listener cancelListener;
    private boolean enableAnimation = true;
    private boolean cancelable = true;
    private View view;

    static IOSDialogActivity iosDialogActivity;

    private Context context;

    private IOSDialog(Context context) {
        this.context = context;
    }

    public void show() {
        IOSDialogActivity.openActivity(context, this);
    }

    public void dismiss() {
        if (iosDialogActivity != null) {
            iosDialogActivity.dismiss();
        }
    }

    public View getView() {
        return view;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getPositiveButtonText() {
        return positiveButtonText;
    }

    public String getNegativeButtonText() {
        return negativeButtonText;
    }

    public Listener getPositiveClickListener() {
        return positiveClickListener;
    }

    public Listener getNegativeClickListener() {
        return negativeClickListener;
    }

    public Listener getCancelListener() {
        return cancelListener;
    }

    public boolean isEnableAnimation() {
        return enableAnimation;
    }

    public boolean isCancelable() {
        return cancelable;
    }

    public static class Builder {

        private IOSDialog iosDialog;
        private Context context;

        public Builder(Context context) {
            this.context = context;
            iosDialog = new IOSDialog(context);
        }

        public IOSDialog build() {
            return iosDialog;
        }

        public Builder title(String title) {
            iosDialog.title = title;
            return this;
        }

        public Builder message(String message) {
            iosDialog.message = message;
            return this;
        }

        public Builder title(int titleResourceId) {
            iosDialog.title = context.getString(titleResourceId);
            return this;
        }

        public Builder message(int messageResourceId) {
            iosDialog.message = context.getString(messageResourceId);
            return this;
        }

        public Builder positiveButtonText(String positiveButtonText) {
            iosDialog.positiveButtonText = positiveButtonText;
            return this;
        }

        public Builder negativeButtonText(String negativeButtonText) {
            iosDialog.negativeButtonText = negativeButtonText;
            return this;
        }

        public Builder positiveButtonText(int positiveButtonTextResourceId) {
            iosDialog.positiveButtonText = context.getString(positiveButtonTextResourceId);
            return this;
        }

        public Builder negativeButtonText(int negativeButtonTextResourceId) {
            iosDialog.negativeButtonText = context.getString(negativeButtonTextResourceId);
            return this;
        }

        public Builder positiveClickListener(Listener positiveClickListener) {
            iosDialog.positiveClickListener = positiveClickListener;
            return this;
        }

        public Builder negativeClickListener(Listener negativeClickListener) {
            iosDialog.negativeClickListener = negativeClickListener;
            return this;
        }

        public Builder cancelListener(Listener cancelListener) {
            iosDialog.cancelListener = cancelListener;
            return this;
        }

        public Builder enableAnimation(boolean enableAnimation) {
            iosDialog.enableAnimation = enableAnimation;
            return this;
        }

        public Builder cancelable(boolean cancelable) {
            iosDialog.cancelable = cancelable;
            return this;
        }
    }

}
