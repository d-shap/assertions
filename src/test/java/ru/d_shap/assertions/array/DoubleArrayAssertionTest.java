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
package ru.d_shap.assertions.array;

import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link DoubleArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleArrayAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DoubleArrayAssertionTest() {
        super();
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{});

        try {
            initializeWithRawActual(Raw.doubleArrayAssertion(), new Object());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.doubleArrayAssertion(), new Object(), "Message");
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{}).isEmpty();

        try {
            Raw.doubleArrayAssertion().isEmpty();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).isEmpty();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").isEmpty();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isEmpty();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").isEmpty();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.doubleArrayAssertion(), null).isNullOrEmpty();
        initialize(Raw.doubleArrayAssertion(), new double[]{}).isNullOrEmpty();

        try {
            Raw.doubleArrayAssertion().isNullOrEmpty();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isNullOrEmpty();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").isNullOrEmpty();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isNotEmpty();

        try {
            Raw.doubleArrayAssertion().isNotEmpty();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).isNotEmpty();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).isNotEmpty();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").isNotEmpty();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).contains(1.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).contains(2.0);

        try {
            Raw.doubleArrayAssertion().contains(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).contains(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").contains(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).contains(3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").contains(3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).doesNotContain(3.0);

        try {
            Raw.doubleArrayAssertion().doesNotContain(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).doesNotContain(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").doesNotContain(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).doesNotContain(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").doesNotContain(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAll(1.0, 2.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAll(1.0, 3.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAll(4.0, 2.0);

        try {
            Raw.doubleArrayAssertion().containsAll(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAll(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAll(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAll((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAll((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAll((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAll((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAll();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAll();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAll(2.0, 3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAll(2.0, 3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAll(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAll(Arrays.asList(1.0, 3.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAll(Arrays.asList(4.0, 2.0));

        try {
            Raw.doubleArrayAssertion().containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAll((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAll((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAll((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAll((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(1.0, 2.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAllInOrder(1.0, 3.0, 4.0);

        try {
            Raw.doubleArrayAssertion().containsAllInOrder(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAllInOrder(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAllInOrder(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAllInOrder((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAllInOrder((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAllInOrder((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAllInOrder((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAllInOrder();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAllInOrder();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(2.0, 3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(2.0, 1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAllInOrder(2.0, 1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAllInOrder(Arrays.asList(1.0, 3.0, 4.0));

        try {
            Raw.doubleArrayAssertion().containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly(1.0, 2.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(1.0, 2.0, 3.0, 4.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(1.0, 3.0, 2.0, 4.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{}).containsExactly();

        try {
            Raw.doubleArrayAssertion().containsExactly(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactly(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactly(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactly((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactly((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsExactly((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsExactly((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly(2.0, 3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(Arrays.asList(1.0, 3.0, 2.0, 4.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{}).containsExactly(new ArrayList<Double>());

        try {
            Raw.doubleArrayAssertion().containsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder(1.0, 2.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{}).containsExactlyInOrder();

        try {
            Raw.doubleArrayAssertion().containsExactlyInOrder(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactlyInOrder(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactlyInOrder(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(1.0, 2.0, 3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{}).containsExactlyInOrder(new ArrayList<Double>());

        try {
            Raw.doubleArrayAssertion().containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAny(2.0, 3.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAny(2.0, 4.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAny(4.0, 1.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAny(5.0, 3.0);

        try {
            Raw.doubleArrayAssertion().containsAny(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAny(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAny(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAny((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAny((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAny((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAny((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAny();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAny();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAny(3.0, 4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAny(3.0, 4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAny(Arrays.asList(2.0, 3.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAny(Arrays.asList(2.0, 4.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAny(Arrays.asList(4.0, 1.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAny(Arrays.asList(5.0, 3.0));

        try {
            Raw.doubleArrayAssertion().containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAny((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAny((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAny((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAny((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(3.0, 7.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(3.0, 4.0, 5.0);

        try {
            Raw.doubleArrayAssertion().containsNone(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsNone(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsNone(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsNone((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsNone((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsNone((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsNone((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsNone();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsNone();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(2.0, 1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsNone(2.0, 1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(Arrays.asList(3.0, 7.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(Arrays.asList(3.0, 4.0, 5.0));

        try {
            Raw.doubleArrayAssertion().containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsNone((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsNone((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsNone((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsNone((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toLength().isEqualTo(2);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toLength().isGreaterThan(1);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toLength().isLessThan(3);

        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).toLength().isEqualTo(4);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).toLength().isGreaterThan(3);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).toLength().isLessThan(5);

        try {
            Raw.doubleArrayAssertion().toLength();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).toLength();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").toLength();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toLength()).isEqualTo(0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").toLength()).isEqualTo(0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toLength().isEqualTo(4);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").toLength().isEqualTo(4);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void toLengthMatcherTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toLength(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toLength(Matchers.is(Matchers.greaterThan(1)));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toLength(Matchers.is(Matchers.lessThan(3)));

        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).toLength(Matchers.equalTo(4));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).toLength(Matchers.greaterThan(3));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).toLength(Matchers.lessThan(5));

        try {
            Raw.doubleArrayAssertion().toLength(Matchers.equalTo(0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).toLength(Matchers.equalTo(0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").toLength(Matchers.equalTo(0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).toLength(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").toLength(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).toLength(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").toLength(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toLength(Matchers.equalTo(4));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").toLength(Matchers.equalTo(4));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\nExpected: <4>\n     but: was <2>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).hasLength(2);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).hasLength(4);

        try {
            Raw.doubleArrayAssertion().hasLength(0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).hasLength(0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").hasLength(0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).hasLength(4);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").hasLength(4);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.doubleArrayAssertion(), null).isNull();

        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isNull();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").isNull();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        double[] value = new double[]{1.0, 2.0};
        initialize(Raw.doubleArrayAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.doubleArrayAssertion(), value).isSameAs(new double[]{1.0, 2.0});
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<[1.0, 2.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), value, "Message").isSameAs(new double[]{1.0, 2.0});
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<[1.0, 2.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        double[] value = new double[]{1.0, 2.0};
        initialize(Raw.doubleArrayAssertion(), value).isNotSameAs(new double[]{1.0, 2.0});

        try {
            initialize(Raw.doubleArrayAssertion(), value).isNotSameAs(value);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<[1.0, 2.0]>");
        }
    }

}
