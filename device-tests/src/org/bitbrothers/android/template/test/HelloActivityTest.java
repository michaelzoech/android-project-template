/**
 * Copyright 2011 Michael Zoech
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bitbrothers.android.template.test;

import org.bitbrothers.android.template.HelloActivity;

import android.test.ActivityInstrumentationTestCase2;

import com.jayway.android.robotium.solo.Solo;

public class HelloActivityTest extends ActivityInstrumentationTestCase2<HelloActivity> {

    private HelloActivity activity;
    private Solo solo;

    public HelloActivityTest() {
        super(HelloActivity.class.getPackage().getName(), HelloActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
        solo = new Solo(getInstrumentation(), activity);
    }

    @Override
    protected void tearDown() throws Exception {
        try {
            solo.finalize();
        } catch (Throwable e) {
            throw new Exception(e);
        }
        super.tearDown();
    }

    public void testShowsHelloWorldOnStart() {
        solo.waitForText(solo.getString(org.bitbrothers.android.template.R.string.hello), 1, 4000);
    }
}
