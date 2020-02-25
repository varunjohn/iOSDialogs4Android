package com.varunjohn1990.iosdialogs4android;

import android.graphics.Color;

import java.io.Serializable;

public class IOSDialogButton implements Serializable {

    public static final int TYPE_POSITIVE = 1;
    public static final int TYPE_NEGATIVE = 2;

    private int id;
    private String text;
    private boolean makeBold;
    private int type;

    public IOSDialogButton(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public IOSDialogButton(int id, String text, boolean makeBold, int type) {
        this.id = id;
        this.text = text;
        this.makeBold = makeBold;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isMakeBold() {
        return makeBold;
    }

    public int getType() {
        return type;
    }
}
