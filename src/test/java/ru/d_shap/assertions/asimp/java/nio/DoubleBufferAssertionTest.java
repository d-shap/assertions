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
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

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
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.doubleBufferAssertion(), new Object(), "Message");
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
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
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContains(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContains(2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContains(2.0);

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
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndDoesNotContain(3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndDoesNotContain(5.0);

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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAll();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAll();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
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
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAll(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAll(Arrays.asList(1.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAll(Arrays.asList(4.0, 2.0));

        try {
            Raw.doubleBufferAssertion().containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsAll(new ArrayList<Double>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsAll(Arrays.asList(1.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsAll(Arrays.asList(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAll();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAll();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAll(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAll(Arrays.asList(1.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAll(Arrays.asList(4.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsAll(Arrays.asList(1.0, 2.0));

        try {
            Raw.doubleBufferAssertion().rewindAndContainsAll(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsAll(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsAll(new ArrayList<Double>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAll(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAll(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsAll(Arrays.asList(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAll(Arrays.asList(2.0, 3.0));
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAllInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAllInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
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
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAllInOrder(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAllInOrder(Arrays.asList(1.0, 3.0, 4.0));

        try {
            Raw.doubleBufferAssertion().containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsAllInOrder(new ArrayList<Double>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAllInOrder(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsAllInOrder(Arrays.asList(1.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsAllInOrder(Arrays.asList(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAllInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAllInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAllInOrder(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAllInOrder(Arrays.asList(1.0, 3.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsAllInOrder(Arrays.asList(1.0, 2.0));

        try {
            Raw.doubleBufferAssertion().rewindAndContainsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(new ArrayList<Double>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAllInOrder(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsAllInOrder(Arrays.asList(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAllInOrder(Arrays.asList(2.0, 1.0));
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsExactly((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
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
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactly(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactly(Arrays.asList(1.0, 3.0, 2.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsExactly(new ArrayList<Double>());

        try {
            Raw.doubleBufferAssertion().containsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsExactly(new ArrayList<Double>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactly(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), "Message").containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsExactly((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactly(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactly(Arrays.asList(1.0, 3.0, 2.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsExactly(new ArrayList<Double>());
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));

        try {
            Raw.doubleBufferAssertion().rewindAndContainsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsExactly(new ArrayList<Double>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactly(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), "Message").rewindAndContainsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
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
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactlyInOrder(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsExactlyInOrder(new ArrayList<Double>());

        try {
            Raw.doubleBufferAssertion().containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<Double>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactlyInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), "Message").containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactlyInOrder(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsExactlyInOrder(new ArrayList<Double>());
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));

        try {
            Raw.doubleBufferAssertion().rewindAndContainsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(new ArrayList<Double>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactlyInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAny();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAny();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
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
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAny(Arrays.asList(2.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAny(Arrays.asList(2.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAny(Arrays.asList(4.0, 1.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).containsAny(Arrays.asList(5.0, 3.0));

        try {
            Raw.doubleBufferAssertion().containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsAny(new ArrayList<Double>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsAny(Arrays.asList(1.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1.0, 3.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsAny(Arrays.asList(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAny();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAny();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAny(Arrays.asList(2.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAny(Arrays.asList(2.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAny(Arrays.asList(4.0, 1.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0})).rewindAndContainsAny(Arrays.asList(5.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsAny(Arrays.asList(1.0, 3.0));

        try {
            Raw.doubleBufferAssertion().rewindAndContainsAny(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsAny(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsAny(new ArrayList<Double>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsAny(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsAny(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsAny(Arrays.asList(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAny(Arrays.asList(3.0, 4.0));
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsNone();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsNone();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
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
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsNone(Arrays.asList(3.0, 7.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsNone(Arrays.asList(3.0, 4.0, 5.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).containsNone(Arrays.asList(1.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).containsNone(Arrays.asList(4.0, 5.0));

        try {
            Raw.doubleBufferAssertion().containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").containsNone(new ArrayList<Double>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsNone();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsNone();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsNone(Arrays.asList(3.0, 7.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsNone(Arrays.asList(3.0, 4.0, 5.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3)).rewindAndContainsNone(Arrays.asList(4.0, 5.0));

        try {
            Raw.doubleBufferAssertion().rewindAndContainsNone(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).rewindAndContainsNone(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").rewindAndContainsNone(new ArrayList<Double>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).rewindAndContainsNone(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").rewindAndContainsNone(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3)).rewindAndContainsNone(Arrays.asList(1.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toPositionTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toPosition().isEqualTo(3);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toPosition().isGreaterThan(2);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toPosition().isLessThan(6);

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1)).toPosition().isEqualTo(1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1)).toPosition().isGreaterThan(0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1)).toPosition().isLessThan(4);

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toPosition().isEqualTo(3);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toPosition().isGreaterThan(1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toPosition().isLessThan(5);

        try {
            Raw.doubleBufferAssertion().toPosition();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toPosition();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toPosition();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toPosition()).isEqualTo(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3), "Message").toPosition()).isEqualTo(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toPosition().isEqualTo(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3), "Message").toPosition().isEqualTo(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toPositionMatcherTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toPosition(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toPosition(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toPosition(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1)).toPosition(Matchers.equalTo(1));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1)).toPosition(Matchers.greaterThan(0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1)).toPosition(Matchers.lessThan(2));

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toPosition(Matchers.equalTo(3));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toPosition(Matchers.greaterThan(2));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toPosition(Matchers.lessThan(4));

        try {
            Raw.doubleBufferAssertion().toPosition(Matchers.equalTo(0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toPosition(Matchers.equalTo(0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toPosition(Matchers.equalTo(0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toPosition(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toPosition(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).toPosition(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").toPosition(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toPosition(Matchers.equalTo(4));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3), "Message").toPosition(Matchers.equalTo(4));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasPositionTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).hasPosition(3);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1)).hasPosition(1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).hasPosition(3);

        try {
            Raw.doubleBufferAssertion().hasPosition(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasPosition(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasPosition(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).hasPosition(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3), "Message").hasPosition(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toLimitTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toLimit().isEqualTo(3);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toLimit().isGreaterThan(2);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toLimit().isLessThan(6);

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 1)).toLimit().isEqualTo(1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 1)).toLimit().isGreaterThan(0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 1)).toLimit().isLessThan(4);

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toLimit().isEqualTo(3);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toLimit().isGreaterThan(1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toLimit().isLessThan(5);

        try {
            Raw.doubleBufferAssertion().toLimit();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toLimit();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toLimit();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toLimit()).isEqualTo(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3), "Message").toLimit()).isEqualTo(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toLimit().isEqualTo(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3), "Message").toLimit().isEqualTo(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toLimitMatcherTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toLimit(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toLimit(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toLimit(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 1)).toLimit(Matchers.equalTo(1));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 1)).toLimit(Matchers.greaterThan(0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 1)).toLimit(Matchers.lessThan(2));

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toLimit(Matchers.equalTo(3));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toLimit(Matchers.greaterThan(2));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toLimit(Matchers.lessThan(4));

        try {
            Raw.doubleBufferAssertion().toLimit(Matchers.equalTo(0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toLimit(Matchers.equalTo(0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toLimit(Matchers.equalTo(0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toLimit(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toLimit(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).toLimit(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").toLimit(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toLimit(Matchers.equalTo(4));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3), "Message").toLimit(Matchers.equalTo(4));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasLimitTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).hasLimit(3);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 1)).hasLimit(1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).hasLimit(3);

        try {
            Raw.doubleBufferAssertion().hasLimit(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasLimit(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasLimit(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).hasLimit(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3), "Message").hasLimit(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toCapacityTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toCapacity().isEqualTo(3);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toCapacity().isGreaterThan(2);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toCapacity().isLessThan(6);

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 1)).toCapacity().isEqualTo(3);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 1)).toCapacity().isGreaterThan(2);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 1)).toCapacity().isLessThan(6);

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toCapacity().isEqualTo(5);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toCapacity().isGreaterThan(1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toCapacity().isLessThan(7);

        try {
            Raw.doubleBufferAssertion().toCapacity();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toCapacity();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toCapacity();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toCapacity()).isEqualTo(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3), "Message").toCapacity()).isEqualTo(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toCapacity().isEqualTo(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3), "Message").toCapacity().isEqualTo(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toCapacityMatcherTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toCapacity(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toCapacity(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toCapacity(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 1)).toCapacity(Matchers.equalTo(3));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 1)).toCapacity(Matchers.greaterThan(2));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 1)).toCapacity(Matchers.lessThan(4));

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toCapacity(Matchers.equalTo(5));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toCapacity(Matchers.greaterThan(4));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).toCapacity(Matchers.lessThan(6));

        try {
            Raw.doubleBufferAssertion().toCapacity(Matchers.equalTo(0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toCapacity(Matchers.equalTo(0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toCapacity(Matchers.equalTo(0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toCapacity(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toCapacity(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).toCapacity(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").toCapacity(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toCapacity(Matchers.equalTo(4));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3), "Message").toCapacity(Matchers.equalTo(4));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasCapacityTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).hasCapacity(3);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 1)).hasCapacity(3);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).hasCapacity(5);

        try {
            Raw.doubleBufferAssertion().hasCapacity(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasCapacity(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasCapacity(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).hasCapacity(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3), "Message").hasCapacity(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasPropertiesTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).hasProperties(3, 3, 3);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1)).hasProperties(1, 3, 3);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 3, 5)).hasProperties(3, 3, 5);

        try {
            Raw.doubleBufferAssertion().hasProperties(1, 1, 1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasProperties(1, 1, 1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasProperties(1, 1, 1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).hasProperties(4, 3, 3);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3), "Message").hasProperties(4, 3, 3);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).hasProperties(3, 4, 3);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3), "Message").hasProperties(3, 4, 3);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).hasProperties(3, 3, 4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3), "Message").hasProperties(3, 3, 4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toRemainingTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toRemaining().isEqualTo(0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toRemaining().isGreaterThan(-1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toRemaining().isLessThan(3);

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 3)).toRemaining().isEqualTo(2);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 3)).toRemaining().isGreaterThan(1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 3)).toRemaining().isLessThan(5);

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 2, 5)).toRemaining().isEqualTo(0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 2, 5)).toRemaining().isGreaterThan(-1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 2, 5)).toRemaining().isLessThan(3);

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 2, 4, 5)).toRemaining().isEqualTo(2);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 2, 4, 5)).toRemaining().isGreaterThan(1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 2, 4, 5)).toRemaining().isLessThan(5);

        try {
            Raw.doubleBufferAssertion().toRemaining();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toRemaining();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toRemaining();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 0, 3, 3)).toRemaining()).isEqualTo(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 0, 3, 3), "Message").toRemaining()).isEqualTo(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 0, 3, 3)).toRemaining().isEqualTo(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 0, 3, 3), "Message").toRemaining().isEqualTo(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toRemainingMatcherTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toRemaining(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toRemaining(Matchers.is(Matchers.greaterThan(-1)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).toRemaining(Matchers.is(Matchers.lessThan(1)));

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 3)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 3)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 3)).toRemaining(Matchers.lessThan(3));

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 2, 5)).toRemaining(Matchers.equalTo(0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 2, 5)).toRemaining(Matchers.greaterThan(-1));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 2, 5)).toRemaining(Matchers.lessThan(1));

        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 2, 4, 5)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 2, 4, 5)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 2, 4, 5)).toRemaining(Matchers.lessThan(3));

        try {
            Raw.doubleBufferAssertion().toRemaining(Matchers.equalTo(0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toRemaining(Matchers.equalTo(0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toRemaining(Matchers.equalTo(0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toRemaining(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toRemaining(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).toRemaining(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").toRemaining(null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 0, 3, 3)).toRemaining(Matchers.equalTo(4));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 0, 3, 3), "Message").toRemaining(Matchers.equalTo(4));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasRemainingTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 3)).hasRemaining(0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 1, 3)).hasRemaining(2);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 4, 2, 5)).hasRemaining(0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 2, 4, 5)).hasRemaining(2);

        try {
            Raw.doubleBufferAssertion().hasRemaining(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasRemaining(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasRemaining(1);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 0, 3, 3)).hasRemaining(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0, 3.0}, 0, 3, 3), "Message").hasRemaining(4);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isDirectTest() {
        initialize(Raw.doubleBufferAssertion(), ByteBuffer.allocateDirect(12).asDoubleBuffer()).isDirect();

        try {
            Raw.doubleBufferAssertion().isDirect();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).isDirect();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").isDirect();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), ByteBuffer.allocate(12).asDoubleBuffer()).isDirect();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be direct.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), ByteBuffer.allocate(12).asDoubleBuffer(), "Message").isDirect();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be direct.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isNotDirectTest() {
        initialize(Raw.doubleBufferAssertion(), ByteBuffer.allocate(12).asDoubleBuffer()).isNotDirect();

        try {
            Raw.doubleBufferAssertion().isNotDirect();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).isNotDirect();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").isNotDirect();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), ByteBuffer.allocateDirect(12).asDoubleBuffer()).isNotDirect();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be direct.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), ByteBuffer.allocateDirect(12).asDoubleBuffer(), "Message").isNotDirect();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be direct.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isReadOnlyTest() {
        DoubleBuffer buffer = ByteBuffer.allocate(12).asDoubleBuffer();
        DoubleBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.doubleBufferAssertion(), readOnlyBuffer).isReadOnly();

        try {
            Raw.doubleBufferAssertion().isReadOnly();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).isReadOnly();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").isReadOnly();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), buffer).isReadOnly();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be read only.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), buffer, "Message").isReadOnly();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be read only.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isNotReadOnlyTest() {
        DoubleBuffer buffer = ByteBuffer.allocate(12).asDoubleBuffer();
        DoubleBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.doubleBufferAssertion(), buffer).isNotReadOnly();

        try {
            Raw.doubleBufferAssertion().isNotReadOnly();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).isNotReadOnly();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").isNotReadOnly();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), readOnlyBuffer).isNotReadOnly();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be read only.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), readOnlyBuffer, "Message").isNotReadOnly();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be read only.");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<[1.0, 2.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), value, "Message").isSameAs(createDoubleBuffer(new double[]{1.0, 2.0}));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<[1.0, 2.0]> but was:<[1.0, 2.0]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<[1.0, 2.0]>");
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
