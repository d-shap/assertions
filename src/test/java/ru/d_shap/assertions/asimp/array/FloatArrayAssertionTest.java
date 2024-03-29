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
 * Tests for {@link FloatArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatArrayAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FloatArrayAssertionTest() {
        super();
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{});

        try {
            initializeWithRawActual(Raw.floatArrayAssertion(), new Object());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[F> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.floatArrayAssertion(), new Object(), "Message");
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[F> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{}).isEmpty();
        initialize(Raw.floatArrayAssertion(), new float[]{}).isNotNull().isEmpty().isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().isEmpty();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).isEmpty();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").isEmpty();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).isEmpty();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").isEmpty();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.floatArrayAssertion(), null).isNullOrEmpty();
        initialize(Raw.floatArrayAssertion(), new float[]{}).isNullOrEmpty();
        initialize(Raw.floatArrayAssertion(), new float[]{}).isNotNull().isNullOrEmpty().isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().isNullOrEmpty();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).isNullOrEmpty();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").isNullOrEmpty();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).isNotEmpty();
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).isNotNull().isNotEmpty().isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().isNotEmpty();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).isNotEmpty();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").isNotEmpty();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).isNotEmpty();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").isNotEmpty();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).contains(1.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).contains(2.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f}).contains(Float.NaN);
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f}).contains(Float.POSITIVE_INFINITY);
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f}).contains(Float.NEGATIVE_INFINITY);
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f}).contains(3.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).isNotNull().contains(2.0f).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().contains(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).contains(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").contains(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).contains(3.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3.0f> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").contains(3.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3.0f> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, Float.POSITIVE_INFINITY}).contains(Float.NEGATIVE_INFINITY);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<-Infinity> but was:<[1.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, Float.POSITIVE_INFINITY}, "Message").contains(Float.NEGATIVE_INFINITY);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<-Infinity> but was:<[1.0f, Infinity]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).doesNotContain(3.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY}).doesNotContain(Float.NEGATIVE_INFINITY);
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY}).doesNotContain(3.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).isNotNull().doesNotContain(3.0f).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().doesNotContain(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).doesNotContain(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").doesNotContain(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).doesNotContain(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1.0f> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").doesNotContain(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1.0f> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY}).doesNotContain(Float.POSITIVE_INFINITY);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<Infinity> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY}, "Message").doesNotContain(Float.POSITIVE_INFINITY);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<Infinity> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAll(1.0f, 2.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAll(1.0f, 3.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAll(4.0f, 2.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f}).containsAll(Float.NEGATIVE_INFINITY, Float.NaN);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).isNotNull().containsAll(4.0f, 2.0f).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().containsAll(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAll(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAll(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAll((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAll((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsAll((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsAll((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsAll();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsAll();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAll(2.0f, 3.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAll(2.0f, 3.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY}).containsAll(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY}, "Message").containsAll(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAll(DataHelper.createIterable(1.0f, 2.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAll(DataHelper.createIterable(1.0f, 3.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAll(DataHelper.createIterable(4.0f, 2.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f}).containsAll(DataHelper.createIterable(Float.NEGATIVE_INFINITY, Float.NaN));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).isNotNull().containsAll(DataHelper.createIterable(4.0f, 2.0f)).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().containsAll(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAll(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAll(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAll((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAll((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsAll((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsAll((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsAll(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsAll(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAll(DataHelper.createIterable(2.0f, 3.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAll(DataHelper.createIterable(2.0f, 3.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY}).containsAll(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY}, "Message").containsAll(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder(1.0f, 2.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAllInOrder(1.0f, 3.0f, 4.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f}).containsAllInOrder(Float.NaN, Float.NEGATIVE_INFINITY, 3.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).isNotNull().containsAllInOrder(1.0f, 3.0f, 4.0f).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().containsAllInOrder(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAllInOrder(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAllInOrder(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAllInOrder((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAllInOrder((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsAllInOrder((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsAllInOrder((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsAllInOrder();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsAllInOrder();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder(2.0f, 3.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder(2.0f, 1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAllInOrder(2.0f, 1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY}).containsAllInOrder(Float.POSITIVE_INFINITY, Float.NaN);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY}, "Message").containsAllInOrder(Float.POSITIVE_INFINITY, Float.NaN);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder(DataHelper.createIterable(1.0f, 2.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAllInOrder(DataHelper.createIterable(1.0f, 3.0f, 4.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f}).containsAllInOrder(DataHelper.createIterable(Float.NaN, Float.NEGATIVE_INFINITY, 3.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).isNotNull().containsAllInOrder(DataHelper.createIterable(1.0f, 3.0f, 4.0f)).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().containsAllInOrder(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAllInOrder(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAllInOrder(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAllInOrder((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAllInOrder((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsAllInOrder((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsAllInOrder((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsAllInOrder(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsAllInOrder(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder(DataHelper.createIterable(2.0f, 3.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder(DataHelper.createIterable(2.0f, 1.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAllInOrder(DataHelper.createIterable(2.0f, 1.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY}).containsAllInOrder(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NaN));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY}, "Message").containsAllInOrder(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NaN));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactly(1.0f, 2.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(1.0f, 2.0f, 3.0f, 4.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(1.0f, 3.0f, 2.0f, 4.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{}).containsExactly();
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f}).containsExactly(Float.NEGATIVE_INFINITY, Float.NaN, 3.0f, Float.POSITIVE_INFINITY);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).isNotNull().containsExactly(1.0f, 2.0f).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().containsExactly(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactly(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactly(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactly((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactly((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsExactly((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsExactly((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactly(2.0f, 3.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactly();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 1.0f, 3.0f, 2.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}, "Message").containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 1.0f, 3.0f, 2.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}).containsExactly(Float.NaN, 3.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}, "Message").containsExactly(Float.NaN, 3.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactly(DataHelper.createIterable(1.0f, 2.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(DataHelper.createIterable(1.0f, 3.0f, 2.0f, 4.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{}).containsExactly(DataHelper.<Float>createIterable());
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f}).containsExactly(DataHelper.createIterable(Float.NEGATIVE_INFINITY, Float.NaN, 3.0f, Float.POSITIVE_INFINITY));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).isNotNull().containsExactly(DataHelper.createIterable(1.0f, 2.0f)).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().containsExactly(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactly(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactly(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactly((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactly((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsExactly((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsExactly((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactly(DataHelper.createIterable(2.0f, 3.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0f, 3.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactly(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(DataHelper.createIterable(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 1.0f, 3.0f, 2.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}, "Message").containsExactly(DataHelper.createIterable(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0f, 1.0f, 3.0f, 2.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}).containsExactly(DataHelper.createIterable(Float.NaN, 3.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}, "Message").containsExactly(DataHelper.createIterable(Float.NaN, 3.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactlyInOrder(1.0f, 2.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{}).containsExactlyInOrder();
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f}).containsExactlyInOrder(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).isNotNull().containsExactlyInOrder(1.0f, 2.0f).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().containsExactlyInOrder(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactlyInOrder(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactlyInOrder(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactlyInOrder((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactlyInOrder((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsExactlyInOrder((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsExactlyInOrder((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactlyInOrder();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 3.0f, 1.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}, "Message").containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 3.0f, 1.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}).containsExactlyInOrder(Float.POSITIVE_INFINITY, Float.NaN, 3.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}, "Message").containsExactlyInOrder(Float.POSITIVE_INFINITY, Float.NaN, 3.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{}).containsExactlyInOrder(DataHelper.<Float>createIterable());
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f}).containsExactlyInOrder(DataHelper.createIterable(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).isNotNull().containsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f)).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().containsExactlyInOrder(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactlyInOrder(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactlyInOrder(DataHelper.createIterable(2.0f, 1.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f, 3.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(DataHelper.createIterable(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0f, 2.0f, 3.0f, 4.0f, 5.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactlyInOrder(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(DataHelper.createIterable(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 3.0f, 1.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}, "Message").containsExactlyInOrder(DataHelper.createIterable(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0f, 3.0f, 1.0f, 4.0f]> but was:<[1.0f, 2.0f, 3.0f, 4.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}).containsExactlyInOrder(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NaN, 3.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}, "Message").containsExactlyInOrder(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NaN, 3.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAny(2.0f, 3.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAny(2.0f, 4.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAny(4.0f, 1.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAny(5.0f, 3.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.NEGATIVE_INFINITY, 3.0f}).containsAny(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).isNotNull().containsAny(5.0f, 3.0f).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().containsAny(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAny(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAny(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAny((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAny((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsAny((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsAny((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsAny();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsAny();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAny(3.0f, 4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0f, 4.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAny(3.0f, 4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0f, 4.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}).containsAny(Float.NEGATIVE_INFINITY, 4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}, "Message").containsAny(Float.NEGATIVE_INFINITY, 4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAny(DataHelper.createIterable(2.0f, 3.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAny(DataHelper.createIterable(2.0f, 4.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAny(DataHelper.createIterable(4.0f, 1.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAny(DataHelper.createIterable(5.0f, 3.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.NEGATIVE_INFINITY, 3.0f}).containsAny(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).isNotNull().containsAny(DataHelper.createIterable(5.0f, 3.0f)).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().containsAny(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAny(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAny(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAny((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAny((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsAny((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsAny((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsAny(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsAny(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAny(DataHelper.createIterable(3.0f, 4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0f, 4.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAny(DataHelper.createIterable(3.0f, 4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0f, 4.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}).containsAny(DataHelper.createIterable(Float.NEGATIVE_INFINITY, 4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}, "Message").containsAny(DataHelper.createIterable(Float.NEGATIVE_INFINITY, 4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone(3.0f, 7.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone(3.0f, 4.0f, 5.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.NEGATIVE_INFINITY, 3.0f}).containsNone(Float.POSITIVE_INFINITY, 4.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).isNotNull().containsNone(3.0f, 4.0f, 5.0f).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().containsNone(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsNone(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsNone(1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsNone((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsNone((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsNone((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsNone((float[]) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsNone();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsNone();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone(2.0f, 1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsNone(2.0f, 1.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}).containsNone(Float.NaN, 4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}, "Message").containsNone(Float.NaN, 4.0f);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone(DataHelper.createIterable(3.0f, 7.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone(DataHelper.createIterable(3.0f, 4.0f, 5.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, Float.NEGATIVE_INFINITY, 3.0f}).containsNone(DataHelper.createIterable(Float.POSITIVE_INFINITY, 4.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).isNotNull().containsNone(DataHelper.createIterable(3.0f, 4.0f, 5.0f)).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().containsNone(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsNone(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsNone(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsNone((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsNone((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsNone((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsNone((Iterable<Float>) null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).containsNone(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").containsNone(DataHelper.<Float>createIterable());
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone(DataHelper.createIterable(2.0f, 1.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsNone(DataHelper.createIterable(2.0f, 1.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0f, 1.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}).containsNone(DataHelper.createIterable(Float.NaN, 4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{Float.NaN, 3.0f, Float.POSITIVE_INFINITY}, "Message").containsNone(DataHelper.createIterable(Float.NaN, 4.0f));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).toLength().isEqualTo(2);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).toLength().isGreaterThan(1);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).toLength().isLessThan(3);

        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).toLength().isEqualTo(4);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).toLength().isGreaterThan(3);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).toLength().isLessThan(5);

        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).isNotNull().toLength().isEqualTo(4);

        try {
            Raw.floatArrayAssertion().toLength();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).toLength();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").toLength();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).toLength()).isEqualTo(0);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").toLength()).isEqualTo(0);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).toLength().isEqualTo(4);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").toLength().isEqualTo(4);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void toLengthMatcherTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).toLength(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).toLength(Matchers.is(Matchers.greaterThan(1)));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).toLength(Matchers.is(Matchers.lessThan(3)));

        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).toLength(Matchers.equalTo(4));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).toLength(Matchers.greaterThan(3));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).toLength(Matchers.lessThan(5));

        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).isNotNull().toLength(Matchers.equalTo(4)).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().toLength(Matchers.equalTo(0));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).toLength(Matchers.equalTo(0));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").toLength(Matchers.equalTo(0));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).toLength(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").toLength(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}).toLength(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{}, "Message").toLength(null);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).toLength(Matchers.equalTo(4));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").toLength(Matchers.equalTo(4));
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\nExpected: <4>\n     but: was <2>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).hasLength(2);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).hasLength(4);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).isNotNull().hasLength(4).isInstanceOf(float[].class);

        try {
            Raw.floatArrayAssertion().hasLength(0);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).hasLength(0);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").hasLength(0);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).hasLength(4);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").hasLength(4);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.floatArrayAssertion(), null).isNull();

        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).isNull();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").isNull();
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        float[] value = new float[]{1.0f, 2.0f};
        initialize(Raw.floatArrayAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.floatArrayAssertion(), value).isSameAs(new float[]{1.0f, 2.0f});
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[1.0f, 2.0f]> but was:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), value, "Message").isSameAs(new float[]{1.0f, 2.0f});
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<[1.0f, 2.0f]> but was:<[1.0f, 2.0f]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        float[] value = new float[]{1.0f, 2.0f};
        initialize(Raw.floatArrayAssertion(), value).isNotSameAs(new float[]{1.0f, 2.0f});

        try {
            initialize(Raw.floatArrayAssertion(), value).isNotSameAs(value);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[1.0f, 2.0f]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(FloatArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<[1.0f, 2.0f]>");
        }
    }

}
