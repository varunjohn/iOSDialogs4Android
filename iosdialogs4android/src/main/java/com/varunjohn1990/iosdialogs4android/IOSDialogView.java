package com.varunjohn1990.iosdialogs4android;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

/**
 * Created by Varun John on August 2018.
 * Github : https://github.com/varunjohn
 */
public class IOSDialogView extends AppCompatActivity implements View.OnClickListener {

    protected static void open(Context context, IOSDialog iosDialog) {
        IOSDialogView.iosDialog = iosDialog;
        context.startActivity(new Intent(context, IOSDialogView.class));
    }

    private Context context;
    private static IOSDialog iosDialog;

    private View layoutDialog;
    private View layoutContent;
    private View layoutNegative;

    private TextView textViewTitle, textViewMessage, textViewNegative, textViewPositive;

    private LinearLayout layout2Options, layoutMultipleOptions;

    float dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iosdialog);

        context = this;

        dp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, context.getResources().getDisplayMetrics());

        layoutDialog = findViewById(R.id.layoutDialog);
        layoutContent = findViewById(R.id.layoutContent);
        layoutNegative = findViewById(R.id.layoutNegative);

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewMessage = findViewById(R.id.textViewMessage);
        textViewNegative = findViewById(R.id.textViewNegative);
        textViewPositive = findViewById(R.id.textViewPositive);

        layout2Options = findViewById(R.id.layout2Options);
        layoutMultipleOptions = findViewById(R.id.layoutMultipleOptions);

        IOSDialog.iosDialogView = this;

        if (iosDialog.isEnableAnimation()) {
            layoutDialog.setScaleX(1.4f);
            layoutDialog.setScaleY(1.4f);
            layoutContent.setAlpha(0);
            layoutContent.animate().alpha(1f).setDuration(400).setInterpolator(new DecelerateInterpolator()).start();
            layoutDialog.animate().scaleX(1f).scaleY(1f).setDuration(300).setInterpolator(new DecelerateInterpolator()).start();
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

        if (!iosDialog.isMultiOptions()) {

            layout2Options.setVisibility(View.VISIBLE);
            layoutMultipleOptions.setVisibility(View.GONE);

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

        } else {

            layout2Options.setVisibility(View.GONE);
            layoutMultipleOptions.setVisibility(View.VISIBLE);

            if (iosDialog.getIosDialogButtons() != null && !iosDialog.getIosDialogButtons().isEmpty()) {
                layoutMultipleOptions.removeAllViews();
                for (final IOSDialogButton iosDialogButton : iosDialog.getIosDialogButtons()) {

                    LinearLayout separator = new LinearLayout(context);
                    separator.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, Math.round(1 * dp)));
                    separator.setBackgroundColor(ContextCompat.getColor(context, R.color.separator_ios_dialog));

                    layoutMultipleOptions.addView(separator);

                    final TextView button = new TextView(context);
                    button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) (48 * dp)));
                    button.setBackgroundResource(R.drawable.click_highlight);
                    button.setClickable(true);
                    button.setText(iosDialogButton.getText());
                    button.setMaxLines(1);
                    button.setGravity(Gravity.CENTER);
                    button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                    button.setShadowLayer(1,1,1, ContextCompat.getColor(context, R.color.text_shadow));

                    if (iosDialogButton.getType() == IOSDialogButton.TYPE_NEGATIVE) {
                        button.setTextColor(ContextCompat.getColor(context, R.color.action_button_negative_ios_dialog));
                    } else {
                        button.setTextColor(ContextCompat.getColor(context, R.color.action_button_ios_dialog));
                    }

                    if (iosDialogButton.isMakeBold()) {
                        button.setTypeface(Typeface.DEFAULT_BOLD);
                    }

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (iosDialog.getIosDialogMultiOptionsListeners() != null) {
                                iosDialog.getIosDialogMultiOptionsListeners().onClick(iosDialog, iosDialogButton);
                            } else {
                                dismiss();
                            }
                        }
                    });

                    layoutMultipleOptions.addView(button);
                }
            }
        }
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
