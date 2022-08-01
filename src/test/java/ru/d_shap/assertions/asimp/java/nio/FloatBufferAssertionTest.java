///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions library provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions library.
//
// Assertions library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.FloatBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 2, 2, 4)).isNotNull().isEmpty().isInstanceOf(FloatBuffer.class);

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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}, 0, 0, 4)).isNotNull().isRewindAndEmpty().isInstanceOf(FloatBuffer.class);

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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).isNotNull().isNullOrEmpty().isInstanceOf(FloatBuffer.class);

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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).isNotNull().isRewindAndNullOrEmpty().isInstanceOf(FloatBuffer.class);

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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().isNotEmpty().isInstanceOf(FloatBuffer.class);

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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().isRewindAndNotEmpty().isInstanceOf(FloatBuffer.class);

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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f})).contains(Float.NaN);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f})).contains(Float.POSITIVE_INFINITY);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f})).contains(Float.NEGATIVE_INFINITY);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f})).contains(3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().contains(2.0f).isInstanceOf(FloatBuffer.class);

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
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, Float.POSITIVE_INFINITY})).contains(Float.NEGATIVE_INFINITY);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<-Infinity> but was:<[1.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, Float.POSITIVE_INFINITY}), "Message").contains(Float.NEGATIVE_INFINITY);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<-Infinity> but was:<[1.0f, Infinity]>");
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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().rewindAndContains(2.0f).isInstanceOf(FloatBuffer.class);

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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY})).doesNotContain(Float.NEGATIVE_INFINITY);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY})).doesNotContain(3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().doesNotContain(3.0f).isInstanceOf(FloatBuffer.class);

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
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY})).doesNotContain(Float.POSITIVE_INFINITY);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<Infinity> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY}), "Message").doesNotContain(Float.POSITIVE_INFINITY);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<Infinity> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndDoesNotContain(3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndDoesNotContain(5.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().rewindAndDoesNotContain(3.0f).isInstanceOf(FloatBuffer.class);

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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f})).containsAll(Float.NEGATIVE_INFINITY, Float.NaN);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().containsAll(1.0f, 2.0f).isInstanceOf(FloatBuffer.class);

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
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY})).containsAll(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY}), "Message").containsAll(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAll(DataHelper.createIterable(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAll(DataHelper.createIterable(1.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAll(DataHelper.createIterable(4.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f})).containsAll(DataHelper.createIterable(Float.NEGATIVE_INFINITY, Float.NaN));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().containsAll(DataHelper.createIterable(1.0f, 2.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().containsAll(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAll(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAll(DataHelper.<Float>createIterable());
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
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsAll(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsAll(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsAll(DataHelper.createIterable(1.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1.0f, 2.0f]> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsAll(DataHelper.createIterable(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAll(DataHelper.createIterable(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAll(DataHelper.createIterable(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY})).containsAll(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY}), "Message").containsAll(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().rewindAndContainsAll(1.0f, 2.0f).isInstanceOf(FloatBuffer.class);

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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAll(DataHelper.createIterable(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAll(DataHelper.createIterable(1.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAll(DataHelper.createIterable(4.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsAll(DataHelper.createIterable(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().rewindAndContainsAll(DataHelper.createIterable(1.0f, 2.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().rewindAndContainsAll(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAll(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAll(DataHelper.<Float>createIterable());
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
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsAll(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsAll(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsAll(DataHelper.createIterable(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAll(DataHelper.createIterable(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAll(DataHelper.createIterable(2.0f, 3.0f));
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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f})).containsAllInOrder(Float.NaN, Float.NEGATIVE_INFINITY, 3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().containsAllInOrder(1.0f, 2.0f).isInstanceOf(FloatBuffer.class);

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
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY})).containsAllInOrder(Float.POSITIVE_INFINITY, Float.NaN);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY}), "Message").containsAllInOrder(Float.POSITIVE_INFINITY, Float.NaN);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(DataHelper.createIterable(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAllInOrder(DataHelper.createIterable(1.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f})).containsAllInOrder(DataHelper.createIterable(Float.NaN, Float.NEGATIVE_INFINITY, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().containsAllInOrder(DataHelper.createIterable(1.0f, 2.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().containsAllInOrder(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAllInOrder(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAllInOrder(DataHelper.<Float>createIterable());
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
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsAllInOrder(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsAllInOrder(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(DataHelper.createIterable(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsAllInOrder(DataHelper.createIterable(1.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1.0f, 2.0f]> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsAllInOrder(DataHelper.createIterable(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(DataHelper.createIterable(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAllInOrder(DataHelper.createIterable(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY})).containsAllInOrder(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NaN));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY}), "Message").containsAllInOrder(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NaN));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().rewindAndContainsAllInOrder(1.0f, 2.0f).isInstanceOf(FloatBuffer.class);

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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(DataHelper.createIterable(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAllInOrder(DataHelper.createIterable(1.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsAllInOrder(DataHelper.createIterable(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().rewindAndContainsAllInOrder(DataHelper.createIterable(1.0f, 2.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().rewindAndContainsAllInOrder(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAllInOrder(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(DataHelper.<Float>createIterable());
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
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsAllInOrder(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsAllInOrder(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(DataHelper.createIterable(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsAllInOrder(DataHelper.createIterable(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(DataHelper.createIterable(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAllInOrder(DataHelper.createIterable(2.0f, 1.0f));
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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f})).containsExactly(Float.NEGATIVE_INFINITY, Float.NaN, 3.0f, Float.POSITIVE_INFINITY);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().containsExactly(1.0f, 2.0f).isInstanceOf(FloatBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1.0f, 2.0f]>");
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
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY})).containsExactly(Float.NaN, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}), "Message").containsExactly(Float.NaN, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly(DataHelper.createIterable(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactly(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactly(DataHelper.createIterable(1.0f, 3.0f, 2.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsExactly(DataHelper.<Float>createIterable());
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f})).containsExactly(DataHelper.createIterable(Float.NEGATIVE_INFINITY, Float.NaN, 3.0f, Float.POSITIVE_INFINITY));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().containsExactly(DataHelper.createIterable(1.0f, 2.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().containsExactly(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactly(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactly(DataHelper.<Float>createIterable());
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
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly(DataHelper.createIterable(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactly(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsExactly(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsExactly(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactly(DataHelper.createIterable(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 1.0f, 3.0f, 2.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), "Message").containsExactly(DataHelper.createIterable(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 1.0f, 3.0f, 2.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY})).containsExactly(DataHelper.createIterable(Float.NaN, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}), "Message").containsExactly(DataHelper.createIterable(Float.NaN, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().rewindAndContainsExactly(1.0f, 2.0f).isInstanceOf(FloatBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1.0f, 2.0f]>");
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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly(DataHelper.createIterable(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactly(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactly(DataHelper.createIterable(1.0f, 3.0f, 2.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsExactly(DataHelper.<Float>createIterable());
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsExactly(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().rewindAndContainsExactly(DataHelper.createIterable(1.0f, 2.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().rewindAndContainsExactly(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactly(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactly(DataHelper.<Float>createIterable());
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
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly(DataHelper.createIterable(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactly(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsExactly(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactly(DataHelper.createIterable(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 1.0f, 3.0f, 2.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), "Message").rewindAndContainsExactly(DataHelper.createIterable(1.0f, 1.0f, 3.0f, 2.0f));
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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f})).containsExactlyInOrder(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().containsExactlyInOrder(1.0f, 2.0f).isInstanceOf(FloatBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1.0f, 2.0f]>");
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
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY})).containsExactlyInOrder(Float.POSITIVE_INFINITY, Float.NaN, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}), "Message").containsExactlyInOrder(Float.POSITIVE_INFINITY, Float.NaN, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsExactlyInOrder(DataHelper.<Float>createIterable());
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f})).containsExactlyInOrder(DataHelper.createIterable(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().containsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().containsExactlyInOrder(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactlyInOrder(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<Float>createIterable());
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
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(DataHelper.createIterable(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsExactlyInOrder(DataHelper.createIterable(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 3.0f, 1.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), "Message").containsExactlyInOrder(DataHelper.createIterable(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 3.0f, 1.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY})).containsExactlyInOrder(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NaN, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}), "Message").containsExactlyInOrder(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NaN, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().rewindAndContainsExactlyInOrder(1.0f, 2.0f).isInstanceOf(FloatBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1.0f, 2.0f]>");
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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsExactlyInOrder(DataHelper.<Float>createIterable());
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().rewindAndContainsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().rewindAndContainsExactlyInOrder(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactlyInOrder(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(DataHelper.<Float>createIterable());
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
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 3.0f, 1.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f}), "Message").rewindAndContainsExactlyInOrder(DataHelper.createIterable(2.0f, 3.0f, 1.0f, 4.0f));
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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.NEGATIVE_INFINITY, 3.0f})).containsAny(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().containsAny(2.0f, 3.0f).isInstanceOf(FloatBuffer.class);

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
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY})).containsAny(Float.NEGATIVE_INFINITY, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}), "Message").containsAny(Float.NEGATIVE_INFINITY, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAny(DataHelper.createIterable(2.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAny(DataHelper.createIterable(2.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAny(DataHelper.createIterable(4.0f, 1.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).containsAny(DataHelper.createIterable(5.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.NEGATIVE_INFINITY, 3.0f})).containsAny(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().containsAny(DataHelper.createIterable(2.0f, 3.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().containsAny(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAny(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAny(DataHelper.<Float>createIterable());
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
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsAny(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsAny(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsAny(DataHelper.createIterable(1.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1.0f, 3.0f]> but was:<[4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsAny(DataHelper.createIterable(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAny(DataHelper.createIterable(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0f, 4.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAny(DataHelper.createIterable(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0f, 4.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY})).containsAny(DataHelper.createIterable(Float.NEGATIVE_INFINITY, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}), "Message").containsAny(DataHelper.createIterable(Float.NEGATIVE_INFINITY, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().rewindAndContainsAny(2.0f, 3.0f).isInstanceOf(FloatBuffer.class);

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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAny(DataHelper.createIterable(2.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAny(DataHelper.createIterable(2.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAny(DataHelper.createIterable(4.0f, 1.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f})).rewindAndContainsAny(DataHelper.createIterable(5.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsAny(DataHelper.createIterable(1.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().rewindAndContainsAny(DataHelper.createIterable(2.0f, 3.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().rewindAndContainsAny(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAny(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAny(DataHelper.<Float>createIterable());
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
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsAny(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsAny(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsAny(DataHelper.createIterable(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAny(DataHelper.createIterable(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0f, 4.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAny(DataHelper.createIterable(3.0f, 4.0f));
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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.NEGATIVE_INFINITY, 3.0f})).containsNone(Float.POSITIVE_INFINITY, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().containsNone(3.0f, 7.0f).isInstanceOf(FloatBuffer.class);

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
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY})).containsNone(Float.NaN, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}), "Message").containsNone(Float.NaN, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(DataHelper.createIterable(3.0f, 7.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(DataHelper.createIterable(3.0f, 4.0f, 5.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsNone(DataHelper.createIterable(1.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsNone(DataHelper.createIterable(4.0f, 5.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, Float.NEGATIVE_INFINITY, 3.0f})).containsNone(DataHelper.createIterable(Float.POSITIVE_INFINITY, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().containsNone(DataHelper.createIterable(3.0f, 7.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().containsNone(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsNone(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsNone(DataHelper.<Float>createIterable());
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
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).containsNone(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").containsNone(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(DataHelper.createIterable(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsNone(DataHelper.createIterable(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY})).containsNone(DataHelper.createIterable(Float.NaN, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}), "Message").containsNone(DataHelper.createIterable(Float.NaN, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().rewindAndContainsNone(3.0f, 7.0f).isInstanceOf(FloatBuffer.class);

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
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(DataHelper.createIterable(3.0f, 7.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(DataHelper.createIterable(3.0f, 4.0f, 5.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsNone(DataHelper.createIterable(4.0f, 5.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNotNull().rewindAndContainsNone(DataHelper.createIterable(3.0f, 7.0f)).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().rewindAndContainsNone(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsNone(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsNone(DataHelper.<Float>createIterable());
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
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).rewindAndContainsNone(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").rewindAndContainsNone(DataHelper.<Float>createIterable());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsNone(DataHelper.createIterable(1.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1.0f, 3.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(DataHelper.createIterable(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsNone(DataHelper.createIterable(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[1.0f, 2.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), value, "Message").isSameAs(createFloatBuffer(new float[]{1.0f, 2.0f}));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<[1.0f, 2.0f]> but was:<[1.0f, 2.0f]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<[1.0f, 2.0f]>");
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
