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

import java.nio.DoubleBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link DoubleBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleBufferAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DoubleBufferAssertionTest() {
        super();
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}));

        try {
            initializeWithRawActual(Raw.doubleBufferAssertion(), new Object());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.nio.DoubleBuffer> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.doubleBufferAssertion(), new Object(), "Message");
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.nio.DoubleBuffer> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).isEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 2)).isEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 2, 2, 4)).isEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 2, 2, 4)).isNotNull().isEmpty().isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().isEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).isEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").isEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}, 0, 4, 4)).isEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[0.0, 0.0, 0.0, 0.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).isEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").isEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isRewindAndEmptyTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).isRewindAndEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 0, 0)).isRewindAndEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 0, 0, 4)).isRewindAndEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 0, 0, 4)).isNotNull().isRewindAndEmpty().isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().isRewindAndEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).isRewindAndEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").isRewindAndEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}, 0, 4, 4)).isRewindAndEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[0.0, 0.0, 0.0, 0.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isRewindAndEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).isRewindAndEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").isRewindAndEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).isNullOrEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 2)).isNullOrEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 2, 2, 4)).isNullOrEmpty();
        initialize(Raw.doubleBufferAssertion(), null).isNullOrEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).isNotNull().isNullOrEmpty().isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().isNullOrEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}, 0, 4, 4)).isNullOrEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[0.0, 0.0, 0.0, 0.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNullOrEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).isNullOrEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").isNullOrEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isRewindAndNullOrEmptyTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).isRewindAndNullOrEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 0, 0)).isRewindAndNullOrEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 0, 0, 4)).isRewindAndNullOrEmpty();
        initialize(Raw.doubleBufferAssertion(), null).isRewindAndNullOrEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).isNotNull().isRewindAndNullOrEmpty().isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().isRewindAndNullOrEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}, 0, 4, 4)).isRewindAndNullOrEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[0.0, 0.0, 0.0, 0.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isRewindAndNullOrEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).isRewindAndNullOrEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").isRewindAndNullOrEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).isNotEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}, 0, 4, 4)).isNotEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().isNotEmpty().isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().isNotEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).isNotEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).isNotEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 2)).isNotEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 2, 2, 4)).isNotEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 2, 2, 4), "Message").isNotEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isRewindAndNotEmptyTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isRewindAndNotEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).isRewindAndNotEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}, 0, 4, 4)).isRewindAndNotEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 2)).isRewindAndNotEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 2, 2, 4)).isRewindAndNotEmpty();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().isRewindAndNotEmpty().isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().isRewindAndNotEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).isRewindAndNotEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").isRewindAndNotEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).isRewindAndNotEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").isRewindAndNotEmpty();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).contains(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).contains(2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0})).contains(Double.NaN);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0})).contains(Double.POSITIVE_INFINITY);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0})).contains(Double.NEGATIVE_INFINITY);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0})).contains(3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().contains(2.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().contains(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).contains(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").contains(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).contains(2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<2.0> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).contains(4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).contains(3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").contains(3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, Double.POSITIVE_INFINITY})).contains(Double.NEGATIVE_INFINITY);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<-Infinity> but was:<[1.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, Double.POSITIVE_INFINITY}), "Message").contains(Double.NEGATIVE_INFINITY);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<-Infinity> but was:<[1.0, Infinity]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContains(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContains(2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContains(2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().rewindAndContains(2.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().rewindAndContains(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContains(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContains(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContains(4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContains(3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContains(3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).doesNotContain(3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).doesNotContain(2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).doesNotContain(5.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY})).doesNotContain(Double.NEGATIVE_INFINITY);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY})).doesNotContain(3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().doesNotContain(3.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().doesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).doesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").doesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).doesNotContain(2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).doesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").doesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY})).doesNotContain(Double.POSITIVE_INFINITY);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<Infinity> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY}), "Message").doesNotContain(Double.POSITIVE_INFINITY);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<Infinity> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndDoesNotContain(3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndDoesNotContain(5.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().rewindAndDoesNotContain(3.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().rewindAndDoesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndDoesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndDoesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndDoesNotContain(2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2.0> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndDoesNotContain(2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndDoesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndDoesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAll(1.0, 2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAll(1.0, 3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAll(4.0, 2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0})).containsAll(Double.NEGATIVE_INFINITY, Double.NaN);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().containsAll(1.0, 2.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().containsAll(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsAll(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsAll(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAll();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAll();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsAll(1.0, 2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsAll(4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAll(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAll(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY})).containsAll(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY}), "Message").containsAll(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAll(DataHelper.createIterable(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAll(DataHelper.createIterable(1.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAll(DataHelper.createIterable(4.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0})).containsAll(DataHelper.createIterable(Double.NEGATIVE_INFINITY, Double.NaN));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().containsAll(DataHelper.createIterable(1.0, 2.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().containsAll(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsAll(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsAll(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAll(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAll(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsAll(DataHelper.createIterable(1.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsAll(DataHelper.createIterable(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAll(DataHelper.createIterable(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAll(DataHelper.createIterable(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY})).containsAll(DataHelper.createIterable(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY}), "Message").containsAll(DataHelper.createIterable(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllArrayTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAll(1.0, 2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAll(1.0, 3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAll(4.0, 2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsAll(1.0, 2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().rewindAndContainsAll(1.0, 2.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().rewindAndContainsAll(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsAll(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsAll(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAll();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAll();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsAll(4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAll(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAll(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAll(DataHelper.createIterable(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAll(DataHelper.createIterable(1.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAll(DataHelper.createIterable(4.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsAll(DataHelper.createIterable(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().rewindAndContainsAll(DataHelper.createIterable(1.0, 2.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().rewindAndContainsAll(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsAll(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsAll(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAll(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAll(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsAll(DataHelper.createIterable(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAll(DataHelper.createIterable(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAll(DataHelper.createIterable(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAllInOrder(1.0, 2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAllInOrder(1.0, 3.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0})).containsAllInOrder(Double.NaN, Double.NEGATIVE_INFINITY, 3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().containsAllInOrder(1.0, 2.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().containsAllInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsAllInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsAllInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAllInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAllInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAllInOrder(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsAllInOrder(1.0, 2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsAllInOrder(4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAllInOrder(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAllInOrder(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY})).containsAllInOrder(Double.POSITIVE_INFINITY, Double.NaN);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY}), "Message").containsAllInOrder(Double.POSITIVE_INFINITY, Double.NaN);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAllInOrder(DataHelper.createIterable(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAllInOrder(DataHelper.createIterable(1.0, 3.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0})).containsAllInOrder(DataHelper.createIterable(Double.NaN, Double.NEGATIVE_INFINITY, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().containsAllInOrder(DataHelper.createIterable(1.0, 2.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().containsAllInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsAllInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsAllInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAllInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAllInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAllInOrder(DataHelper.createIterable(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsAllInOrder(DataHelper.createIterable(1.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsAllInOrder(DataHelper.createIterable(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAllInOrder(DataHelper.createIterable(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAllInOrder(DataHelper.createIterable(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY})).containsAllInOrder(DataHelper.createIterable(Double.POSITIVE_INFINITY, Double.NaN));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY}), "Message").containsAllInOrder(DataHelper.createIterable(Double.POSITIVE_INFINITY, Double.NaN));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderArrayTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAllInOrder(1.0, 2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAllInOrder(1.0, 3.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsAllInOrder(1.0, 2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().rewindAndContainsAllInOrder(1.0, 2.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().rewindAndContainsAllInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsAllInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAllInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAllInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAllInOrder(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsAllInOrder(4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAllInOrder(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAllInOrder(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAllInOrder(DataHelper.createIterable(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAllInOrder(DataHelper.createIterable(1.0, 3.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsAllInOrder(DataHelper.createIterable(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().rewindAndContainsAllInOrder(DataHelper.createIterable(1.0, 2.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().rewindAndContainsAllInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsAllInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAllInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAllInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAllInOrder(DataHelper.createIterable(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsAllInOrder(DataHelper.createIterable(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAllInOrder(DataHelper.createIterable(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAllInOrder(DataHelper.createIterable(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactly(1.0, 2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactly(1.0, 2.0, 3.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactly(1.0, 3.0, 2.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsExactly();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0})).containsExactly(Double.NEGATIVE_INFINITY, Double.NaN, 3.0, Double.POSITIVE_INFINITY);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().containsExactly(1.0, 2.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().containsExactly(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsExactly(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsExactly(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsExactly((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsExactly((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsExactly((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsExactly((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactly(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactly();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), "Message").containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY})).containsExactly(Double.NaN, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}), "Message").containsExactly(Double.NaN, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactly(DataHelper.createIterable(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactly(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactly(DataHelper.createIterable(1.0, 3.0, 2.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsExactly(DataHelper.<Double>createIterable());
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0})).containsExactly(DataHelper.createIterable(Double.NEGATIVE_INFINITY, Double.NaN, 3.0, Double.POSITIVE_INFINITY));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().containsExactly(DataHelper.createIterable(1.0, 2.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().containsExactly(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsExactly(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsExactly(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactly(DataHelper.createIterable(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactly(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactly(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsExactly(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsExactly(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactly(DataHelper.createIterable(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), "Message").containsExactly(DataHelper.createIterable(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY})).containsExactly(DataHelper.createIterable(Double.NaN, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}), "Message").containsExactly(DataHelper.createIterable(Double.NaN, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyArrayTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactly(1.0, 2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactly(1.0, 2.0, 3.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactly(1.0, 3.0, 2.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsExactly();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().rewindAndContainsExactly(1.0, 2.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().rewindAndContainsExactly(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsExactly(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsExactly(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsExactly((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsExactly((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsExactly((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsExactly((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactly(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactly();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), "Message").rewindAndContainsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactly(DataHelper.createIterable(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactly(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactly(DataHelper.createIterable(1.0, 3.0, 2.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsExactly(DataHelper.<Double>createIterable());
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsExactly(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0, 5.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().rewindAndContainsExactly(DataHelper.createIterable(1.0, 2.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().rewindAndContainsExactly(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsExactly(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsExactly(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactly(DataHelper.createIterable(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactly(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactly(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsExactly(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactly(DataHelper.createIterable(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), "Message").rewindAndContainsExactly(DataHelper.createIterable(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactlyInOrder(1.0, 2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsExactlyInOrder();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0})).containsExactlyInOrder(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().containsExactlyInOrder(1.0, 2.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().containsExactlyInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsExactlyInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsExactlyInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactlyInOrder(1.0, 2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactlyInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), "Message").containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY})).containsExactlyInOrder(Double.POSITIVE_INFINITY, Double.NaN, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}), "Message").containsExactlyInOrder(Double.POSITIVE_INFINITY, Double.NaN, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactlyInOrder(DataHelper.createIterable(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactlyInOrder(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsExactlyInOrder(DataHelper.<Double>createIterable());
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0})).containsExactlyInOrder(DataHelper.createIterable(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().containsExactlyInOrder(DataHelper.createIterable(1.0, 2.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().containsExactlyInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsExactlyInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactlyInOrder(DataHelper.createIterable(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactlyInOrder(DataHelper.createIterable(1.0, 2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactlyInOrder(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactlyInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsExactlyInOrder(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsExactlyInOrder(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactlyInOrder(DataHelper.createIterable(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), "Message").containsExactlyInOrder(DataHelper.createIterable(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY})).containsExactlyInOrder(DataHelper.createIterable(Double.POSITIVE_INFINITY, Double.NaN, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}), "Message").containsExactlyInOrder(DataHelper.createIterable(Double.POSITIVE_INFINITY, Double.NaN, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderArrayTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactlyInOrder(1.0, 2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsExactlyInOrder();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().rewindAndContainsExactlyInOrder(1.0, 2.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().rewindAndContainsExactlyInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsExactlyInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactlyInOrder(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactlyInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), "Message").rewindAndContainsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsExactlyInOrder(DataHelper.<Double>createIterable());
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0, 5.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().rewindAndContainsExactlyInOrder(DataHelper.createIterable(1.0, 2.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().rewindAndContainsExactlyInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsExactlyInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1.0, 2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactlyInOrder(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), "Message").rewindAndContainsExactlyInOrder(DataHelper.createIterable(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAny(2.0, 3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAny(2.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAny(4.0, 1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAny(5.0, 3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.NEGATIVE_INFINITY, 3.0})).containsAny(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().containsAny(2.0, 3.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().containsAny(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsAny(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsAny(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAny();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAny();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsAny(1.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1.0, 3.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsAny(4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAny(3.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAny(3.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY})).containsAny(Double.NEGATIVE_INFINITY, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}), "Message").containsAny(Double.NEGATIVE_INFINITY, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0]> but was:<[NaN, 3.0, Infinity]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAny(DataHelper.createIterable(2.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAny(DataHelper.createIterable(2.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAny(DataHelper.createIterable(4.0, 1.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAny(DataHelper.createIterable(5.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.NEGATIVE_INFINITY, 3.0})).containsAny(DataHelper.createIterable(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().containsAny(DataHelper.createIterable(2.0, 3.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().containsAny(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsAny(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsAny(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAny(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAny(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsAny(DataHelper.createIterable(1.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1.0, 3.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsAny(DataHelper.createIterable(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAny(DataHelper.createIterable(3.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAny(DataHelper.createIterable(3.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY})).containsAny(DataHelper.createIterable(Double.NEGATIVE_INFINITY, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}), "Message").containsAny(DataHelper.createIterable(Double.NEGATIVE_INFINITY, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0]> but was:<[NaN, 3.0, Infinity]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyArrayTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAny(2.0, 3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAny(2.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAny(4.0, 1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAny(5.0, 3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsAny(1.0, 3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().rewindAndContainsAny(2.0, 3.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().rewindAndContainsAny(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsAny(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsAny(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAny();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAny();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsAny(4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAny(3.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAny(3.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAny(DataHelper.createIterable(2.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAny(DataHelper.createIterable(2.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAny(DataHelper.createIterable(4.0, 1.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAny(DataHelper.createIterable(5.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsAny(DataHelper.createIterable(1.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().rewindAndContainsAny(DataHelper.createIterable(2.0, 3.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().rewindAndContainsAny(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsAny(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsAny(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAny(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAny(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsAny(DataHelper.createIterable(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAny(DataHelper.createIterable(3.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAny(DataHelper.createIterable(3.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsNone(3.0, 7.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsNone(3.0, 4.0, 5.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsNone(1.0, 3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsNone(4.0, 5.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.NEGATIVE_INFINITY, 3.0})).containsNone(Double.POSITIVE_INFINITY, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().containsNone(3.0, 7.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().containsNone(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsNone(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsNone(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsNone();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsNone();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsNone(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsNone(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY})).containsNone(Double.NaN, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}), "Message").containsNone(Double.NaN, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0]> but was:<[NaN, 3.0, Infinity]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsNone(DataHelper.createIterable(3.0, 7.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsNone(DataHelper.createIterable(3.0, 4.0, 5.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsNone(DataHelper.createIterable(1.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsNone(DataHelper.createIterable(4.0, 5.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, Double.NEGATIVE_INFINITY, 3.0})).containsNone(DataHelper.createIterable(Double.POSITIVE_INFINITY, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().containsNone(DataHelper.createIterable(3.0, 7.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().containsNone(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsNone(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsNone(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsNone(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsNone(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsNone(DataHelper.createIterable(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsNone(DataHelper.createIterable(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY})).containsNone(DataHelper.createIterable(Double.NaN, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}), "Message").containsNone(DataHelper.createIterable(Double.NaN, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0]> but was:<[NaN, 3.0, Infinity]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneArrayTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsNone(3.0, 7.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsNone(3.0, 4.0, 5.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsNone(4.0, 5.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().rewindAndContainsNone(3.0, 7.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().rewindAndContainsNone(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsNone(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsNone(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsNone();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsNone();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsNone(1.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsNone(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsNone(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsNone(DataHelper.createIterable(3.0, 7.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsNone(DataHelper.createIterable(3.0, 4.0, 5.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsNone(DataHelper.createIterable(4.0, 5.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNotNull().rewindAndContainsNone(DataHelper.createIterable(3.0, 7.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().rewindAndContainsNone(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsNone(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsNone(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsNone(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsNone(DataHelper.<Double>createIterable());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsNone(DataHelper.createIterable(1.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsNone(DataHelper.createIterable(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsNone(DataHelper.createIterable(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.doubleBufferAssertion(), null).isNull();

        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).isNull();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").isNull();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        DoubleBuffer value = createDoubleBuffer(new double[]{1.0, 2.0});
        initialize(Raw.doubleBufferAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.doubleBufferAssertion(), value).isSameAs(createDoubleBuffer(new double[]{1.0, 2.0}));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[1.0, 2.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), value, "Message").isSameAs(createDoubleBuffer(new double[]{1.0, 2.0}));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<[1.0, 2.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        DoubleBuffer value = createDoubleBuffer(new double[]{1.0, 2.0});
        initialize(Raw.doubleBufferAssertion(), value).isNotSameAs(createDoubleBuffer(new double[]{1.0, 2.0}));

        try {
            initialize(Raw.doubleBufferAssertion(), value).isNotSameAs(value);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void positionTest() {
        DoubleBuffer buffer = createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).contains(4.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContains(2.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).doesNotContain(2.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndDoesNotContain(0.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAll(4.0, 5.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAll(2.0, 5.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAllInOrder(4.0, 5.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAllInOrder(2.0, 5.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsExactly(4.0, 5.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsExactlyInOrder(4.0, 5.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAny(1.0, 5.0, 7.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAny(1.0, 7.0, 9.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsNone(1.0, 9.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsNone(7.0, 9.0);
        Assertions.assertThat(buffer).hasPosition(3);
    }

}
