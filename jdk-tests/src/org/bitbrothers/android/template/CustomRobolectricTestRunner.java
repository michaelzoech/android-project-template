package org.bitbrothers.android.template;

import java.lang.reflect.Method;

import org.junit.runners.model.InitializationError;

import android.app.Application;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;

public class CustomRobolectricTestRunner extends RobolectricTestRunner {
    public CustomRobolectricTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass, "../app/AndroidManifest.xml", "../app/res");
    }

    @Override
    public void beforeTest(Method method) {
        Robolectric.bindShadowClass(ShadowRectF.class);
    }

    @Override
    protected Application createApplication() {
        return super.createApplication();
    }
}
