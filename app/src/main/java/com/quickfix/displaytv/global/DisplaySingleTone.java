package com.quickfix.displaytv.global;

public class DisplaySingleTone {

    public static DisplaySingleTone displaySingleTone;

    public int getFirstType() {
        return firstType;
    }

    public void setFirstType(int firstType) {
        this.firstType = firstType;
    }

    private int firstType=-1;
    public static DisplaySingleTone getInstance() {
        if (displaySingleTone == null) {
            displaySingleTone = new DisplaySingleTone();
        }
        return displaySingleTone;
    }
}
