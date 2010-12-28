package org.bitbrothers.android.template;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CustomRobolectricTestRunner.class)
public class RobolectricSampleTest {

    @Test
    public void calcWidthThroughRectF_shouldUseShadowImplemenation() throws Exception {
        UtilClass uc = new UtilClass();
        assertThat(uc.calculateWidth(1f, 3f), is(2f));
    }
}
