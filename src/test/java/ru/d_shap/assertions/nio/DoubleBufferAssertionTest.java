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
package ru.d_shap.assertions.nio;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.Arrays;

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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[0]));

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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsAll(1.0, 3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsAll(4.0, 2.0);

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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAll();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAll();
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsAll(Arrays.asList(1.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsAll(Arrays.asList(4.0, 2.0));

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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAll(new ArrayList<Double>());
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsAll(1.0, 3.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsAll(4.0, 2.0);
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAll();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAll();
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsAll(Arrays.asList(1.0, 3.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsAll(Arrays.asList(4.0, 2.0));
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAll(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAll(new ArrayList<Double>());
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsAllInOrder(1.0, 3.0, 4.0);

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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAllInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAllInOrder();
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsAllInOrder(Arrays.asList(1.0, 3.0, 4.0));

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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAllInOrder(new ArrayList<Double>());
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(1.0, 3.0, 4.0);
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAllInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAllInOrder();
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(Arrays.asList(1.0, 3.0, 4.0));
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAllInOrder(new ArrayList<Double>());
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactly(1.0, 2.0, 3.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactly(1.0, 3.0, 2.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[0])).containsExactly();

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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactly((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsExactly((double[]) null);
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").containsExactly(1.0, 1.0, 3.0, 2.0);
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1.0, 3.0, 2.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[0])).containsExactly(new ArrayList<Double>());

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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsExactly((Iterable<Double>) null);
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactly(1.0, 2.0, 3.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactly(1.0, 3.0, 2.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[0])).rewindAndContainsExactly();
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactly((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsExactly((double[]) null);
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(1.0, 1.0, 3.0, 2.0);
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1.0, 3.0, 2.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[0])).rewindAndContainsExactly(new ArrayList<Double>());
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsExactly((Iterable<Double>) null);
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[0])).containsExactlyInOrder();

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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsExactlyInOrder((double[]) null);
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactlyInOrder(1.0, 2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[0])).containsExactlyInOrder(new ArrayList<Double>());

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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsExactlyInOrder((Iterable<Double>) null);
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[0])).rewindAndContainsExactlyInOrder();
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsExactlyInOrder((double[]) null);
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[0])).rewindAndContainsExactlyInOrder(new ArrayList<Double>());
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsExactlyInOrder((Iterable<Double>) null);
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsAny(2.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsAny(4.0, 1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsAny(5.0, 3.0);

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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAny();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAny();
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsAny(Arrays.asList(2.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsAny(Arrays.asList(4.0, 1.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).containsAny(Arrays.asList(5.0, 3.0));

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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAny(new ArrayList<Double>());
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsAny(2.0, 4.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsAny(4.0, 1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsAny(5.0, 3.0);
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAny();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAny();
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
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList(2.0, 4.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList(4.0, 1.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList(5.0, 3.0));
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsAny(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAny(new ArrayList<Double>());
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsNone();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsNone();
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsNone(new ArrayList<Double>());
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsNone();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsNone();
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
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).rewindAndContainsNone(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsNone(new ArrayList<Double>());
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
        Assertions.assertThat(buffer).rewindAndDoesNotContain(0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAll(4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAll(2, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAllInOrder(4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAllInOrder(2, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsExactly(4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsExactly(1, 2, 3, 4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsExactlyInOrder(4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAny(1, 5, 7);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAny(1, 7, 9);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsNone(1, 9);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsNone(7, 9);
        Assertions.assertThat(buffer).hasPosition(3);
    }

}
