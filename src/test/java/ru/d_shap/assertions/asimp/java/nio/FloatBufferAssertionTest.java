///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions framework.
//
// Assertions framework is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions framework is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link FloatBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatBufferAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FloatBufferAssertionTest() {
        super();
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}));

        try {
            initializeWithRawActual(Raw.floatBufferAssertion(), new Object());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.nio.FloatBuffer> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.floatBufferAssertion(), new Object(), "Message");
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.nio.FloatBuffer> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).isEmpty();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 2)).isEmpty();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 2, 2, 4)).isEmpty();

        try {
            Raw.floatBufferAssertion().isEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).isEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").isEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}, 0, 4, 4)).isEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[0.0f, 0.0f, 0.0f, 0.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1)).isEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1), "Message").isEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isRewindAndEmptyTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).isRewindAndEmpty();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 0)).isRewindAndEmpty();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 0, 4)).isRewindAndEmpty();

        try {
            Raw.floatBufferAssertion().isRewindAndEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).isRewindAndEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").isRewindAndEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}, 0, 4, 4)).isRewindAndEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[0.0f, 0.0f, 0.0f, 0.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isRewindAndEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1)).isRewindAndEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1), "Message").isRewindAndEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).isNullOrEmpty();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 2)).isNullOrEmpty();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 2, 2, 4)).isNullOrEmpty();
        initialize(Raw.floatBufferAssertion(), null).isNullOrEmpty();

        try {
            Raw.floatBufferAssertion().isNullOrEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}, 0, 4, 4)).isNullOrEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[0.0f, 0.0f, 0.0f, 0.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNullOrEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1)).isNullOrEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1), "Message").isNullOrEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isRewindAndNullOrEmptyTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).isRewindAndNullOrEmpty();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 0)).isRewindAndNullOrEmpty();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 0, 4)).isRewindAndNullOrEmpty();
        initialize(Raw.floatBufferAssertion(), null).isRewindAndNullOrEmpty();

        try {
            Raw.floatBufferAssertion().isRewindAndNullOrEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}, 0, 4, 4)).isRewindAndNullOrEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[0.0f, 0.0f, 0.0f, 0.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isRewindAndNullOrEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1)).isRewindAndNullOrEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1), "Message").isRewindAndNullOrEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotEmpty();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1)).isNotEmpty();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}, 0, 4, 4)).isNotEmpty();

        try {
            Raw.floatBufferAssertion().isNotEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).isNotEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).isNotEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 2)).isNotEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 2, 2, 4)).isNotEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 2, 2, 4), "Message").isNotEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isRewindAndNotEmptyTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isRewindAndNotEmpty();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 1)).isRewindAndNotEmpty();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}, 0, 4, 4)).isRewindAndNotEmpty();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 2)).isRewindAndNotEmpty();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 2, 2, 4)).isRewindAndNotEmpty();

        try {
            Raw.floatBufferAssertion().isRewindAndNotEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).isRewindAndNotEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").isRewindAndNotEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).isRewindAndNotEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").isRewindAndNotEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).contains(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).contains(2.0f);

        try {
            Raw.floatBufferAssertion().contains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).contains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").contains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).contains(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<2.0f> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).contains(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4.0f> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).contains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3.0f> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").contains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3.0f> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContains(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContains(2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContains(2.0f);

        try {
            Raw.floatBufferAssertion().rewindAndContains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContains(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4.0f> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3.0f> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3.0f> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).doesNotContain(3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).doesNotContain(2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).doesNotContain(5.0f);

        try {
            Raw.floatBufferAssertion().doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).doesNotContain(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2.0f> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1.0f> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1.0f> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndDoesNotContain(3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndDoesNotContain(5.0f);

        try {
            Raw.floatBufferAssertion().rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndDoesNotContain(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2.0f> but was:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndDoesNotContain(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2.0f> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1.0f> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1.0f> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAll(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAll(1.0f, 3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAll(4.0f, 2.0f);

        try {
            Raw.floatBufferAssertion().containsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsAll();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsAll();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsAll(1.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1.0f, 2.0f]> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsAll(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAll(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAll(Arrays.asList(1.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAll(Arrays.asList(4.0f, 2.0f));

        try {
            Raw.floatBufferAssertion().containsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsAll(Arrays.asList(1.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1.0f, 2.0f]> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsAll(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAll(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAll(1.0f, 3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAll(4.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsAll(1.0f, 2.0f);

        try {
            Raw.floatBufferAssertion().rewindAndContainsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsAll();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsAll();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsAll(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAll(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAll(Arrays.asList(1.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAll(Arrays.asList(4.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsAll(Arrays.asList(1.0f, 2.0f));

        try {
            Raw.floatBufferAssertion().rewindAndContainsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsAll(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAllInOrder(1.0f, 3.0f, 4.0f);

        try {
            Raw.floatBufferAssertion().containsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsAllInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsAllInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsAllInOrder(1.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1.0f, 2.0f]> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsAllInOrder(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAllInOrder(Arrays.asList(1.0f, 3.0f, 4.0f));

        try {
            Raw.floatBufferAssertion().containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsAllInOrder(Arrays.asList(1.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1.0f, 2.0f]> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsAllInOrder(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAllInOrder(1.0f, 3.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsAllInOrder(1.0f, 2.0f);

        try {
            Raw.floatBufferAssertion().rewindAndContainsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsAllInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsAllInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsAllInOrder(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAllInOrder(Arrays.asList(1.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsAllInOrder(Arrays.asList(1.0f, 2.0f));

        try {
            Raw.floatBufferAssertion().rewindAndContainsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsAllInOrder(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactly(1.0f, 2.0f, 3.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactly(1.0f, 3.0f, 2.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsExactly();

        try {
            Raw.floatBufferAssertion().containsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 1.0f, 3.0f, 2.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), "Message").containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 1.0f, 3.0f, 2.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactly(Arrays.asList(1.0f, 3.0f, 2.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsExactly(new ArrayList<Float>());

        try {
            Raw.floatBufferAssertion().containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 1.0f, 3.0f, 2.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), "Message").containsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 1.0f, 3.0f, 2.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactly(1.0f, 3.0f, 2.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsExactly();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);

        try {
            Raw.floatBufferAssertion().rewindAndContainsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 1.0f, 3.0f, 2.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), "Message").rewindAndContainsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 1.0f, 3.0f, 2.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactly(Arrays.asList(1.0f, 3.0f, 2.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsExactly(new ArrayList<Float>());
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));

        try {
            Raw.floatBufferAssertion().rewindAndContainsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 1.0f, 3.0f, 2.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), "Message").rewindAndContainsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 1.0f, 3.0f, 2.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsExactlyInOrder();

        try {
            Raw.floatBufferAssertion().containsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 3.0f, 1.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), "Message").containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 3.0f, 1.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsExactlyInOrder(new ArrayList<Float>());

        try {
            Raw.floatBufferAssertion().containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 3.0f, 1.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), "Message").containsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 3.0f, 1.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsExactlyInOrder();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);

        try {
            Raw.floatBufferAssertion().rewindAndContainsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 3.0f, 1.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), "Message").rewindAndContainsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 3.0f, 1.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsExactlyInOrder(new ArrayList<Float>());
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));

        try {
            Raw.floatBufferAssertion().rewindAndContainsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 3.0f, 1.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 3.0f, 1.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAny(2.0f, 3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAny(2.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAny(4.0f, 1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAny(5.0f, 3.0f);

        try {
            Raw.floatBufferAssertion().containsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsAny();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsAny();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsAny(1.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1.0f, 3.0f]> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsAny(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0f, 4.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0f, 4.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAny(Arrays.asList(2.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAny(Arrays.asList(2.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAny(Arrays.asList(4.0f, 1.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAny(Arrays.asList(5.0f, 3.0f));

        try {
            Raw.floatBufferAssertion().containsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsAny(Arrays.asList(1.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1.0f, 3.0f]> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsAny(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0f, 4.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0f, 4.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAny(2.0f, 3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAny(2.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAny(4.0f, 1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAny(5.0f, 3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsAny(1.0f, 3.0f);

        try {
            Raw.floatBufferAssertion().rewindAndContainsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsAny();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsAny();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsAny(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0f, 4.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0f, 4.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAny(Arrays.asList(2.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAny(Arrays.asList(2.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAny(Arrays.asList(4.0f, 1.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAny(Arrays.asList(5.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsAny(Arrays.asList(1.0f, 3.0f));

        try {
            Raw.floatBufferAssertion().rewindAndContainsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsAny(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0f, 4.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0f, 4.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(3.0f, 7.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(3.0f, 4.0f, 5.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsNone(1.0f, 3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsNone(4.0f, 5.0f);

        try {
            Raw.floatBufferAssertion().containsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsNone();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsNone();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(Arrays.asList(3.0f, 7.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(Arrays.asList(3.0f, 4.0f, 5.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsNone(Arrays.asList(1.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsNone(Arrays.asList(4.0f, 5.0f));

        try {
            Raw.floatBufferAssertion().containsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(3.0f, 7.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(3.0f, 4.0f, 5.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsNone(4.0f, 5.0f);

        try {
            Raw.floatBufferAssertion().rewindAndContainsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsNone();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsNone();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsNone(1.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1.0f, 3.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(Arrays.asList(3.0f, 7.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(Arrays.asList(3.0f, 4.0f, 5.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsNone(Arrays.asList(4.0f, 5.0f));

        try {
            Raw.floatBufferAssertion().rewindAndContainsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsNone(Arrays.asList(1.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1.0f, 3.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toPositionTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition().isEqualTo(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition().isGreaterThan(2);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition().isLessThan(6);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).toPosition().isEqualTo(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).toPosition().isGreaterThan(0);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).toPosition().isLessThan(4);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toPosition().isEqualTo(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toPosition().isGreaterThan(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toPosition().isLessThan(5);

        try {
            Raw.floatBufferAssertion().toPosition();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toPosition();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toPosition();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toPosition()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toPosition().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toPositionMatcherTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).toPosition(Matchers.equalTo(1));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).toPosition(Matchers.greaterThan(0));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).toPosition(Matchers.lessThan(2));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toPosition(Matchers.equalTo(3));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toPosition(Matchers.greaterThan(2));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toPosition(Matchers.lessThan(4));

        try {
            Raw.floatBufferAssertion().toPosition(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toPosition(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toPosition(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toPosition(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toPosition(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toPosition(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").toPosition(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toPosition(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasPositionTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasPosition(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).hasPosition(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).hasPosition(3);

        try {
            Raw.floatBufferAssertion().hasPosition(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasPosition(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasPosition(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasPosition(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").hasPosition(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toLimitTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit().isEqualTo(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit().isGreaterThan(2);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit().isLessThan(6);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toLimit().isEqualTo(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toLimit().isGreaterThan(0);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toLimit().isLessThan(4);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toLimit().isEqualTo(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toLimit().isGreaterThan(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toLimit().isLessThan(5);

        try {
            Raw.floatBufferAssertion().toLimit();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toLimit();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toLimit();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toLimit()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toLimit().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toLimitMatcherTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toLimit(Matchers.equalTo(1));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toLimit(Matchers.greaterThan(0));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toLimit(Matchers.lessThan(2));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toLimit(Matchers.equalTo(3));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toLimit(Matchers.greaterThan(2));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toLimit(Matchers.lessThan(4));

        try {
            Raw.floatBufferAssertion().toLimit(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toLimit(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toLimit(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toLimit(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toLimit(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toLimit(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").toLimit(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toLimit(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasLimitTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasLimit(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).hasLimit(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).hasLimit(3);

        try {
            Raw.floatBufferAssertion().hasLimit(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasLimit(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasLimit(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasLimit(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").hasLimit(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toCapacityTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity().isEqualTo(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity().isGreaterThan(2);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity().isLessThan(6);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toCapacity().isEqualTo(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toCapacity().isGreaterThan(2);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toCapacity().isLessThan(6);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toCapacity().isEqualTo(5);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toCapacity().isGreaterThan(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toCapacity().isLessThan(7);

        try {
            Raw.floatBufferAssertion().toCapacity();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toCapacity();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toCapacity();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toCapacity()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toCapacity().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toCapacityMatcherTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toCapacity(Matchers.equalTo(3));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toCapacity(Matchers.greaterThan(2));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toCapacity(Matchers.lessThan(4));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toCapacity(Matchers.equalTo(5));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toCapacity(Matchers.greaterThan(4));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toCapacity(Matchers.lessThan(6));

        try {
            Raw.floatBufferAssertion().toCapacity(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toCapacity(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toCapacity(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toCapacity(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toCapacity(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toCapacity(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").toCapacity(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toCapacity(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasCapacityTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasCapacity(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).hasCapacity(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).hasCapacity(5);

        try {
            Raw.floatBufferAssertion().hasCapacity(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasCapacity(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasCapacity(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasCapacity(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").hasCapacity(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasPropertiesTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasProperties(3, 3, 3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).hasProperties(1, 3, 3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).hasProperties(3, 3, 5);

        try {
            Raw.floatBufferAssertion().hasProperties(1, 1, 1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasProperties(1, 1, 1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasProperties(1, 1, 1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasProperties(4, 3, 3);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").hasProperties(4, 3, 3);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasProperties(3, 4, 3);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").hasProperties(3, 4, 3);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasProperties(3, 3, 4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").hasProperties(3, 3, 4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toRemainingTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toRemaining().isEqualTo(0);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toRemaining().isGreaterThan(-1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toRemaining().isLessThan(3);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 3)).toRemaining().isEqualTo(2);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 3)).toRemaining().isGreaterThan(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 3)).toRemaining().isLessThan(5);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 2, 5)).toRemaining().isEqualTo(0);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 2, 5)).toRemaining().isGreaterThan(-1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 2, 5)).toRemaining().isLessThan(3);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 2, 4, 5)).toRemaining().isEqualTo(2);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 2, 4, 5)).toRemaining().isGreaterThan(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 2, 4, 5)).toRemaining().isLessThan(5);

        try {
            Raw.floatBufferAssertion().toRemaining();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toRemaining();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toRemaining();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3)).toRemaining()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3), "Message").toRemaining()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3)).toRemaining().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3), "Message").toRemaining().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toRemainingMatcherTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toRemaining(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toRemaining(Matchers.is(Matchers.greaterThan(-1)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toRemaining(Matchers.is(Matchers.lessThan(1)));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 3)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 3)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 3)).toRemaining(Matchers.lessThan(3));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 2, 5)).toRemaining(Matchers.equalTo(0));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 2, 5)).toRemaining(Matchers.greaterThan(-1));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 2, 5)).toRemaining(Matchers.lessThan(1));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 2, 4, 5)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 2, 4, 5)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 2, 4, 5)).toRemaining(Matchers.lessThan(3));

        try {
            Raw.floatBufferAssertion().toRemaining(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toRemaining(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toRemaining(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toRemaining(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toRemaining(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toRemaining(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").toRemaining(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3)).toRemaining(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3), "Message").toRemaining(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasRemainingTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasRemaining(0);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 3)).hasRemaining(2);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 2, 5)).hasRemaining(0);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 2, 4, 5)).hasRemaining(2);

        try {
            Raw.floatBufferAssertion().hasRemaining(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasRemaining(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasRemaining(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3)).hasRemaining(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3), "Message").hasRemaining(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isDirectTest() {
        initialize(Raw.floatBufferAssertion(), ByteBuffer.allocateDirect(12).asFloatBuffer()).isDirect();

        try {
            Raw.floatBufferAssertion().isDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).isDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").isDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), ByteBuffer.allocate(12).asFloatBuffer()).isDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be direct.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), ByteBuffer.allocate(12).asFloatBuffer(), "Message").isDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be direct.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isNotDirectTest() {
        initialize(Raw.floatBufferAssertion(), ByteBuffer.allocate(12).asFloatBuffer()).isNotDirect();

        try {
            Raw.floatBufferAssertion().isNotDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).isNotDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").isNotDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), ByteBuffer.allocateDirect(12).asFloatBuffer()).isNotDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be direct.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), ByteBuffer.allocateDirect(12).asFloatBuffer(), "Message").isNotDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be direct.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isReadOnlyTest() {
        FloatBuffer buffer = ByteBuffer.allocate(12).asFloatBuffer();
        FloatBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.floatBufferAssertion(), readOnlyBuffer).isReadOnly();

        try {
            Raw.floatBufferAssertion().isReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).isReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").isReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), buffer).isReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be read only.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), buffer, "Message").isReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be read only.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isNotReadOnlyTest() {
        FloatBuffer buffer = ByteBuffer.allocate(12).asFloatBuffer();
        FloatBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.floatBufferAssertion(), buffer).isNotReadOnly();

        try {
            Raw.floatBufferAssertion().isNotReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).isNotReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").isNotReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), readOnlyBuffer).isNotReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be read only.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), readOnlyBuffer, "Message").isNotReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be read only.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.floatBufferAssertion(), null).isNull();

        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNull();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").isNull();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        FloatBuffer value = createFloatBuffer(new float[]{1.0f, 2.0f});
        initialize(Raw.floatBufferAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.floatBufferAssertion(), value).isSameAs(createFloatBuffer(new float[]{1.0f, 2.0f}));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<[1.0f, 2.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), value, "Message").isSameAs(createFloatBuffer(new float[]{1.0f, 2.0f}));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<[1.0f, 2.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        FloatBuffer value = createFloatBuffer(new float[]{1.0f, 2.0f});
        initialize(Raw.floatBufferAssertion(), value).isNotSameAs(createFloatBuffer(new float[]{1.0f, 2.0f}));

        try {
            initialize(Raw.floatBufferAssertion(), value).isNotSameAs(value);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void positionTest() {
        FloatBuffer buffer = createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).contains(4.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContains(2.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).doesNotContain(2.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndDoesNotContain(0.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAll(4.0f, 5.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAll(2.0f, 5.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAllInOrder(4.0f, 5.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAllInOrder(2.0f, 5.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsExactly(4.0f, 5.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsExactlyInOrder(4.0f, 5.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAny(1.0f, 5.0f, 7.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAny(1.0f, 7.0f, 9.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsNone(1.0f, 9.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsNone(7.0f, 9.0f);
        Assertions.assertThat(buffer).hasPosition(3);
    }

}
