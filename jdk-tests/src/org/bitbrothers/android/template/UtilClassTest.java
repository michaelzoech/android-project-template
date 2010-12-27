package org.bitbrothers.android.template;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UtilClassTest {

    @Test
    public void doSomething_shouldAddTheNumbers() throws Exception {
        assertThat(UtilClass.doSomething(1, 2), is(3));
    }
}
