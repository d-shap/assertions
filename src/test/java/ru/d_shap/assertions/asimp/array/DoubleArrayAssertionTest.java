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
package ru.d_shap.assertions.asimp.array;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

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
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[D> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.doubleArrayAssertion(), new Object(), "Message");
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[D> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{}).isEmpty();
        initialize(Raw.doubleArrayAssertion(), new double[]{}).isNotNull().isEmpty().isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().isEmpty();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).isEmpty();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").isEmpty();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isEmpty();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").isEmpty();
            Assertions.fail(DoubleArrayAssertion.class);
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
        initialize(Raw.doubleArrayAssertion(), new double[]{}).isNotNull().isNullOrEmpty().isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().isNullOrEmpty();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isNullOrEmpty();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").isNullOrEmpty();
            Assertions.fail(DoubleArrayAssertion.class);
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
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isNotNull().isNotEmpty().isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().isNotEmpty();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).isNotEmpty();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").isNotEmpty();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).isNotEmpty();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").isNotEmpty();
            Assertions.fail(DoubleArrayAssertion.class);
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
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0}).contains(Double.NaN);
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0}).contains(Double.POSITIVE_INFINITY);
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0}).contains(Double.NEGATIVE_INFINITY);
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0}).contains(3.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isNotNull().contains(2.0).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().contains(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).contains(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").contains(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).contains(3.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").contains(3.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, Double.POSITIVE_INFINITY}).contains(Double.NEGATIVE_INFINITY);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<-Infinity> but was:<[1.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, Double.POSITIVE_INFINITY}, "Message").contains(Double.NEGATIVE_INFINITY);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<-Infinity> but was:<[1.0, Infinity]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).doesNotContain(3.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY}).doesNotContain(Double.NEGATIVE_INFINITY);
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY}).doesNotContain(3.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isNotNull().doesNotContain(3.0).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().doesNotContain(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).doesNotContain(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").doesNotContain(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).doesNotContain(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").doesNotContain(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY}).doesNotContain(Double.POSITIVE_INFINITY);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<Infinity> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY}, "Message").doesNotContain(Double.POSITIVE_INFINITY);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<Infinity> but was:<[NaN, Infinity]>");
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
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0}).containsAll(Double.NEGATIVE_INFINITY, Double.NaN);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).isNotNull().containsAll(4.0, 2.0).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().containsAll(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAll(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAll(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAll((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAll((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAll((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAll((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAll();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAll();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAll(2.0, 3.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAll(2.0, 3.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY}).containsAll(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY}, "Message").containsAll(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAll(DataHelper.createIterable(1.0, 2.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAll(DataHelper.createIterable(1.0, 3.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAll(DataHelper.createIterable(4.0, 2.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0}).containsAll(DataHelper.createIterable(Double.NEGATIVE_INFINITY, Double.NaN));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).isNotNull().containsAll(DataHelper.createIterable(4.0, 2.0)).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().containsAll(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAll(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAll(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAll((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAll((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAll((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAll((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAll(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAll(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAll(DataHelper.createIterable(2.0, 3.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAll(DataHelper.createIterable(2.0, 3.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY}).containsAll(DataHelper.createIterable(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY}, "Message").containsAll(DataHelper.createIterable(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(1.0, 2.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAllInOrder(1.0, 3.0, 4.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0}).containsAllInOrder(Double.NaN, Double.NEGATIVE_INFINITY, 3.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).isNotNull().containsAllInOrder(1.0, 3.0, 4.0).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().containsAllInOrder(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAllInOrder(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAllInOrder(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAllInOrder((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAllInOrder((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAllInOrder((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAllInOrder((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAllInOrder();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAllInOrder();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(2.0, 3.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(2.0, 1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAllInOrder(2.0, 1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY}).containsAllInOrder(Double.POSITIVE_INFINITY, Double.NaN);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY}, "Message").containsAllInOrder(Double.POSITIVE_INFINITY, Double.NaN);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(DataHelper.createIterable(1.0, 2.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAllInOrder(DataHelper.createIterable(1.0, 3.0, 4.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0}).containsAllInOrder(DataHelper.createIterable(Double.NaN, Double.NEGATIVE_INFINITY, 3.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).isNotNull().containsAllInOrder(DataHelper.createIterable(1.0, 3.0, 4.0)).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().containsAllInOrder(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAllInOrder(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAllInOrder(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAllInOrder((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAllInOrder((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAllInOrder((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAllInOrder((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAllInOrder(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAllInOrder(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(DataHelper.createIterable(2.0, 3.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(DataHelper.createIterable(2.0, 1.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAllInOrder(DataHelper.createIterable(2.0, 1.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY}).containsAllInOrder(DataHelper.createIterable(Double.POSITIVE_INFINITY, Double.NaN));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY}, "Message").containsAllInOrder(DataHelper.createIterable(Double.POSITIVE_INFINITY, Double.NaN));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
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
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0}).containsExactly(Double.NEGATIVE_INFINITY, Double.NaN, 3.0, Double.POSITIVE_INFINITY);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isNotNull().containsExactly(1.0, 2.0).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().containsExactly(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactly(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactly(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactly((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactly((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsExactly((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsExactly((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly(2.0, 3.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}).containsExactly(Double.NaN, 3.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}, "Message").containsExactly(Double.NaN, 3.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly(DataHelper.createIterable(1.0, 2.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(DataHelper.createIterable(1.0, 3.0, 2.0, 4.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{}).containsExactly(DataHelper.<Double>createIterable());
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0}).containsExactly(DataHelper.createIterable(Double.NEGATIVE_INFINITY, Double.NaN, 3.0, Double.POSITIVE_INFINITY));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isNotNull().containsExactly(DataHelper.createIterable(1.0, 2.0)).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().containsExactly(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactly(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactly(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactly((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactly((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsExactly((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsExactly((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly(DataHelper.createIterable(2.0, 3.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(DataHelper.createIterable(1.0, 1.0, 3.0, 2.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactly(DataHelper.createIterable(1.0, 1.0, 3.0, 2.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}).containsExactly(DataHelper.createIterable(Double.NaN, 3.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}, "Message").containsExactly(DataHelper.createIterable(Double.NaN, 3.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
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
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0}).containsExactlyInOrder(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isNotNull().containsExactlyInOrder(1.0, 2.0).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().containsExactlyInOrder(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactlyInOrder(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactlyInOrder(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactlyInOrder((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactlyInOrder((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsExactlyInOrder((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsExactlyInOrder((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(1.0, 2.0, 3.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}).containsExactlyInOrder(Double.POSITIVE_INFINITY, Double.NaN, 3.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}, "Message").containsExactlyInOrder(Double.POSITIVE_INFINITY, Double.NaN, 3.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder(DataHelper.createIterable(1.0, 2.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{}).containsExactlyInOrder(DataHelper.<Double>createIterable());
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0}).containsExactlyInOrder(DataHelper.createIterable(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isNotNull().containsExactlyInOrder(DataHelper.createIterable(1.0, 2.0)).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().containsExactlyInOrder(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactlyInOrder(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder(DataHelper.createIterable(2.0, 1.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(DataHelper.createIterable(1.0, 2.0, 3.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(DataHelper.createIterable(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(DataHelper.createIterable(2.0, 3.0, 1.0, 4.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactlyInOrder(DataHelper.createIterable(2.0, 3.0, 1.0, 4.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}).containsExactlyInOrder(DataHelper.createIterable(Double.POSITIVE_INFINITY, Double.NaN, 3.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}, "Message").containsExactlyInOrder(DataHelper.createIterable(Double.POSITIVE_INFINITY, Double.NaN, 3.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0]> but was:<[NaN, 3.0, Infinity]>");
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
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.NEGATIVE_INFINITY, 3.0}).containsAny(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).isNotNull().containsAny(5.0, 3.0).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().containsAny(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAny(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAny(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAny((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAny((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAny((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAny((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAny();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAny();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAny(3.0, 4.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAny(3.0, 4.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}).containsAny(Double.NEGATIVE_INFINITY, 4.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}, "Message").containsAny(Double.NEGATIVE_INFINITY, 4.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0]> but was:<[NaN, 3.0, Infinity]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAny(DataHelper.createIterable(2.0, 3.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAny(DataHelper.createIterable(2.0, 4.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAny(DataHelper.createIterable(4.0, 1.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAny(DataHelper.createIterable(5.0, 3.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.NEGATIVE_INFINITY, 3.0}).containsAny(DataHelper.createIterable(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).isNotNull().containsAny(DataHelper.createIterable(5.0, 3.0)).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().containsAny(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAny(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAny(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAny((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsAny((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAny((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAny((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsAny(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsAny(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAny(DataHelper.createIterable(3.0, 4.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAny(DataHelper.createIterable(3.0, 4.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}).containsAny(DataHelper.createIterable(Double.NEGATIVE_INFINITY, 4.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}, "Message").containsAny(DataHelper.createIterable(Double.NEGATIVE_INFINITY, 4.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0]> but was:<[NaN, 3.0, Infinity]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(3.0, 7.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(3.0, 4.0, 5.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.NEGATIVE_INFINITY, 3.0}).containsNone(Double.POSITIVE_INFINITY, 4.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isNotNull().containsNone(3.0, 4.0, 5.0).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().containsNone(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsNone(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsNone(1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsNone((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsNone((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsNone((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsNone((double[]) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsNone();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsNone();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(2.0, 1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsNone(2.0, 1.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}).containsNone(Double.NaN, 4.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}, "Message").containsNone(Double.NaN, 4.0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0]> but was:<[NaN, 3.0, Infinity]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(DataHelper.createIterable(3.0, 7.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(DataHelper.createIterable(3.0, 4.0, 5.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, Double.NEGATIVE_INFINITY, 3.0}).containsNone(DataHelper.createIterable(Double.POSITIVE_INFINITY, 4.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isNotNull().containsNone(DataHelper.createIterable(3.0, 4.0, 5.0)).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().containsNone(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsNone(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsNone(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsNone((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").containsNone((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsNone((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsNone((Iterable<Double>) null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).containsNone(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").containsNone(DataHelper.<Double>createIterable());
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(DataHelper.createIterable(2.0, 1.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsNone(DataHelper.createIterable(2.0, 1.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}).containsNone(DataHelper.createIterable(Double.NaN, 4.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0]> but was:<[NaN, 3.0, Infinity]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{Double.NaN, 3.0, Double.POSITIVE_INFINITY}, "Message").containsNone(DataHelper.createIterable(Double.NaN, 4.0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0]> but was:<[NaN, 3.0, Infinity]>");
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

        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).isNotNull().toLength().isEqualTo(4);

        try {
            Raw.doubleArrayAssertion().toLength();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).toLength();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").toLength();
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toLength()).isEqualTo(0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").toLength()).isEqualTo(0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toLength().isEqualTo(4);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").toLength().isEqualTo(4);
            Assertions.fail(DoubleArrayAssertion.class);
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

        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).isNotNull().toLength(Matchers.equalTo(4)).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().toLength(Matchers.equalTo(0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).toLength(Matchers.equalTo(0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").toLength(Matchers.equalTo(0));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).toLength(null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").toLength(null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).toLength(null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").toLength(null);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toLength(Matchers.equalTo(4));
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").toLength(Matchers.equalTo(4));
            Assertions.fail(DoubleArrayAssertion.class);
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
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).isNotNull().hasLength(4).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().hasLength(0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).hasLength(0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").hasLength(0);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).hasLength(4);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").hasLength(4);
            Assertions.fail(DoubleArrayAssertion.class);
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
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").isNull();
            Assertions.fail(DoubleArrayAssertion.class);
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
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[1.0, 2.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), value, "Message").isSameAs(new double[]{1.0, 2.0});
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<[1.0, 2.0]> but was:<[1.0, 2.0]>");
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
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(DoubleArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<[1.0, 2.0]>");
        }
    }

}
