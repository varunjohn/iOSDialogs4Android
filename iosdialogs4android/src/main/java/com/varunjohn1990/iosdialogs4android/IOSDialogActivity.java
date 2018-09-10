package com.varunjohn1990.iosdialogs4android;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

/**
 * Created by Varun John on August 2018.
 */
class IOSDialogActivity extends AppCompatActivity implements View.OnClickListener {

    public static void openActivity(Context context, IOSDialog iosDialog) {
        IOSDialogActivity.iosDialog = iosDialog;
        context.startActivity(new Intent(context, IOSDialogActivity.class));
    }

    private Context context;
    private static IOSDialog iosDialog;

    private View layoutDialog;
    private View layoutContent;
    private View layoutNegative;
    private TextView textViewTitle;
    private TextView textViewMessage;
    private TextView textViewNegative;
    private TextView textViewPositive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iosdialog);

        layoutDialog = findViewById(R.id.layoutDialog);
        layoutContent = findViewById(R.id.layoutContent);
        layoutNegative = findViewById(R.id.layoutNegative);

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewMessage = findViewById(R.id.textViewMessage);
        textViewNegative = findViewById(R.id.textViewNegative);
        textViewPositive = findViewById(R.id.textViewPositive);

        IOSDialog.iosDialogActivity = this;

        if (iosDialog.isEnableAnimation()) {
            layoutDialog.setScaleX(1.3f);
            layoutDialog.setScaleY(1.3f);
            layoutContent.setAlpha(0);
            layoutContent.animate().alpha(1f).setDuration(300).setInterpolator(new DecelerateInterpolator()).start();
            layoutDialog.animate().scaleX(1f).scaleY(1f).setDuration(250).setInterpolator(new DecelerateInterpolator()).start();
        }

        if (iosDialog.getTitle() != null) {
            textViewTitle.setText(iosDialog.getTitle());
        } else {
            textViewTitle.setVisibility(View.GONE);
        }

        if (iosDialog.getMessage() != null) {
            textViewMessage.setText(iosDialog.getMessage());
        } else {
            textViewMessage.setText("");
        }

        if (iosDialog.getPositiveButtonText() != null) {
            textViewPositive.setText(iosDialog.getPositiveButtonText());
        } else {
            textViewPositive.setText("Ok");
        }

        if (iosDialog.getNegativeButtonText() != null) {
            textViewNegative.setText(iosDialog.getNegativeButtonText());
        } else {
            textViewNegative.setText("");
            layoutNegative.setVisibility(View.GONE);
        }

        textViewPositive.setOnClickListener(this);
        textViewNegative.setOnClickListener(this);

    }

    public void onOutsideClick(View view) {
        if (iosDialog.isCancelable()) {

            if (iosDialog.getCancelListener() != null) {
                iosDialog.getCancelListener().onClick(iosDialog);
            }

            onBackPressed();
        }
    }

    private boolean isAnimationExitDone;

    @Override
    public void onBackPressed() {

        if (isAnimationExitDone || !iosDialog.isEnableAnimation()) {
//            super.onBackPressed();
            overridePendingTransition(0, 0);
            finish();
            overridePendingTransition(0, 0);
        }

        layoutContent.animate().alpha(0f).setDuration(200).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isAnimationExitDone = true;
                onBackPressed();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        }).setInterpolator(new AccelerateInterpolator()).start();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.textViewPositive) {
            if (iosDialog.getPositiveClickListener() != null) {
                iosDialog.getPositiveClickListener().onClick(iosDialog);
            } else {
                dismiss();
            }

        } else if (id == R.id.textViewNegative) {
            if (iosDialog.getNegativeClickListener() != null) {
                iosDialog.getNegativeClickListener().onClick(iosDialog);
            } else {
                dismiss();
            }
        } else {
        }
    }

    public void dismiss() {
        onBackPressed();
    }
}
