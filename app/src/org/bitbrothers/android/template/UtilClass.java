package org.bitbrothers.android.template;

import android.graphics.RectF;

public class UtilClass {

    private final RectF rect = new RectF();

    public float calculateWidth(float left, float right) {
        rect.left = left;
        rect.right = right;
        return rect.width();
    }

    public static int doSomething(int a, int b) {
        return a + b;
    }

}
