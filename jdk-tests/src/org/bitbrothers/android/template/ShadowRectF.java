package org.bitbrothers.android.template;

import static com.xtremelabs.robolectric.Robolectric.shadowOf_;
import android.graphics.RectF;

import com.xtremelabs.robolectric.util.Implementation;
import com.xtremelabs.robolectric.util.Implements;
import com.xtremelabs.robolectric.util.RealObject;

@Implements(RectF.class)
public class ShadowRectF {

    @RealObject
    private RectF real;

    public void __constructor__(int left, int top, int right, int bottom) {
        real.left = left;
        real.top = top;
        real.right = right;
        real.bottom = bottom;
    }

    @Implementation
    public float width() {
        return real.right - real.left;
    }

    @Implementation
    public float height() {
        return real.bottom - real.top;
    }

    @Implementation
    public void set(RectF src) {
        real.left = src.left;
        real.top = src.top;
        real.right = src.right;
        real.bottom = src.bottom;
    }

    @Implementation
    public void offset(float dx, float dy) {
        real.left += dx;
        real.top += dy;
        real.right += dx;
        real.bottom += dy;
    }

    @Override
    @Implementation
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Object o = shadowOf_(obj);
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        if (this == o) {
            return true;
        }
        RectF r = (RectF) obj;
        return real.left == r.left && real.top == r.top && real.right == r.right && real.bottom == r.bottom;
    }

    @Override
    @Implementation
    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("RectF(");
        sb.append(real.left);
        sb.append(", ");
        sb.append(real.top);
        sb.append(" - ");
        sb.append(real.right);
        sb.append(", ");
        sb.append(real.bottom);
        sb.append(")");
        return sb.toString();
    }
}
