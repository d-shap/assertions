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
 * Tests for {@link IntArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntArrayAssertionTest() {
        super();
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.intArrayAssertion(), new int[]{});

        try {
            initializeWithRawActual(Raw.intArrayAssertion(), new Object());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[I> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.intArrayAssertion(), new Object(), "Message");
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[I> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.intArrayAssertion(), new int[]{}).isEmpty();
        initialize(Raw.intArrayAssertion(), new int[]{}).isNotNull().isEmpty().isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().isEmpty();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).isEmpty();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").isEmpty();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).isEmpty();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").isEmpty();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.intArrayAssertion(), null).isNullOrEmpty();
        initialize(Raw.intArrayAssertion(), new int[]{}).isNullOrEmpty();
        initialize(Raw.intArrayAssertion(), new int[]{}).isNotNull().isNullOrEmpty().isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().isNullOrEmpty();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).isNullOrEmpty();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").isNullOrEmpty();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).isNotEmpty();
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).isNotNull().isNotEmpty().isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().isNotEmpty();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).isNotEmpty();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").isNotEmpty();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).isNotEmpty();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").isNotEmpty();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).contains(1);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).contains(2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).isNotNull().contains(2).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().contains(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).contains(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").contains(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).contains(3);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").contains(3);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).doesNotContain(3);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).isNotNull().doesNotContain(3).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().doesNotContain(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).doesNotContain(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").doesNotContain(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).doesNotContain(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").doesNotContain(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll(1, 2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAll(1, 3);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAll(4, 2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).isNotNull().containsAll(4, 2).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().containsAll(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAll(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAll(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAll((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAll((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsAll((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsAll((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsAll();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsAll();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll(2, 3);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAll(2, 3);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll(DataHelper.createIterable(1, 2));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAll(DataHelper.createIterable(1, 3));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAll(DataHelper.createIterable(4, 2));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).isNotNull().containsAll(DataHelper.createIterable(4, 2)).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().containsAll(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAll(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAll(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAll((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAll((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsAll((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsAll((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsAll(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsAll(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll(DataHelper.createIterable(2, 3));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAll(DataHelper.createIterable(2, 3));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(1, 2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAllInOrder(1, 3, 4);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).isNotNull().containsAllInOrder(1, 3, 4).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().containsAllInOrder(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAllInOrder(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAllInOrder(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAllInOrder((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAllInOrder((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsAllInOrder((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsAllInOrder((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsAllInOrder();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsAllInOrder();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(2, 3);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(2, 1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAllInOrder(2, 1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(DataHelper.createIterable(1, 2));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAllInOrder(DataHelper.createIterable(1, 3, 4));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).isNotNull().containsAllInOrder(DataHelper.createIterable(1, 3, 4)).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().containsAllInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAllInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAllInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsAllInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsAllInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(DataHelper.createIterable(2, 3));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(DataHelper.createIterable(2, 1));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAllInOrder(DataHelper.createIterable(2, 1));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly(1, 2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(1, 2, 3, 4);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(1, 3, 2, 4);
        initialize(Raw.intArrayAssertion(), new int[]{}).containsExactly();
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).isNotNull().containsExactly(1, 2).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().containsExactly(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactly(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactly(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactly((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactly((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsExactly((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsExactly((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly(2, 3);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(1, 1, 3, 2);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}, "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly(DataHelper.createIterable(1, 2));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(DataHelper.createIterable(1, 2, 3, 4));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(DataHelper.createIterable(1, 3, 2, 4));
        initialize(Raw.intArrayAssertion(), new int[]{}).containsExactly(DataHelper.<Integer>createIterable());
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).isNotNull().containsExactly(DataHelper.createIterable(1, 2)).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().containsExactly(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactly(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactly(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactly((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactly((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsExactly((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsExactly((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly(DataHelper.createIterable(2, 3));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(DataHelper.createIterable(1, 2, 3, 4, 5));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(DataHelper.createIterable(1, 1, 3, 2));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}, "Message").containsExactly(DataHelper.createIterable(1, 1, 3, 2));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder(1, 2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.intArrayAssertion(), new int[]{}).containsExactlyInOrder();
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).isNotNull().containsExactlyInOrder(1, 2).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().containsExactlyInOrder(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactlyInOrder(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactlyInOrder(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactlyInOrder((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsExactlyInOrder((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder(2, 1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder(DataHelper.createIterable(1, 2));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(DataHelper.createIterable(1, 2, 3, 4));
        initialize(Raw.intArrayAssertion(), new int[]{}).containsExactlyInOrder(DataHelper.<Integer>createIterable());
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).isNotNull().containsExactlyInOrder(DataHelper.createIterable(1, 2)).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().containsExactlyInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactlyInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder(DataHelper.createIterable(2, 1));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(DataHelper.createIterable(1, 2, 3));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(DataHelper.createIterable(1, 2, 3, 4, 5));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(DataHelper.createIterable(2, 3, 1, 4));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(DataHelper.createIterable(2, 3, 1, 4));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny(2, 3);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(2, 4);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(4, 1);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(5, 3);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).isNotNull().containsAny(5, 3).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().containsAny(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAny(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAny(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAny((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAny((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsAny((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsAny((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsAny();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsAny();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny(3, 4);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAny(3, 4);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny(DataHelper.createIterable(2, 3));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(DataHelper.createIterable(2, 4));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(DataHelper.createIterable(4, 1));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(DataHelper.createIterable(5, 3));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).isNotNull().containsAny(DataHelper.createIterable(5, 3)).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().containsAny(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAny(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAny(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAny((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAny((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsAny((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsAny((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsAny(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsAny(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny(DataHelper.createIterable(3, 4));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAny(DataHelper.createIterable(3, 4));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(3, 7);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(3, 4, 5);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).isNotNull().containsNone(3, 4, 5).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().containsNone(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsNone(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsNone(1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsNone((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsNone((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsNone((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsNone((int[]) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsNone();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsNone();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(2, 1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsNone(2, 1);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(DataHelper.createIterable(3, 7));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(DataHelper.createIterable(3, 4, 5));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).isNotNull().containsNone(DataHelper.createIterable(3, 4, 5)).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().containsNone(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsNone(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsNone(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsNone((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsNone((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsNone((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsNone((Iterable<Integer>) null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).containsNone(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").containsNone(DataHelper.<Integer>createIterable());
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(DataHelper.createIterable(2, 1));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsNone(DataHelper.createIterable(2, 1));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).toLength().isEqualTo(2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).toLength().isGreaterThan(1);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).toLength().isLessThan(3);

        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).toLength().isEqualTo(4);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).toLength().isGreaterThan(3);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).toLength().isLessThan(5);

        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).isNotNull().toLength().isEqualTo(4);

        try {
            Raw.intArrayAssertion().toLength();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).toLength();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").toLength();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intArrayAssertion(), new int[]{1, 2}).toLength()).isEqualTo(0);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").toLength()).isEqualTo(0);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).toLength().isEqualTo(4);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").toLength().isEqualTo(4);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void toLengthMatcherTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).toLength(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).toLength(Matchers.is(Matchers.greaterThan(1)));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).toLength(Matchers.is(Matchers.lessThan(3)));

        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).toLength(Matchers.equalTo(4));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).toLength(Matchers.greaterThan(3));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).toLength(Matchers.lessThan(5));

        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).isNotNull().toLength(Matchers.equalTo(4)).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().toLength(Matchers.equalTo(0));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).toLength(Matchers.equalTo(0));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").toLength(Matchers.equalTo(0));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).toLength(null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").toLength(null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).toLength(null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").toLength(null);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).toLength(Matchers.equalTo(4));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").toLength(Matchers.equalTo(4));
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\nExpected: <4>\n     but: was <2>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).hasLength(2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).hasLength(4);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).isNotNull().hasLength(4).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().hasLength(0);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).hasLength(0);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").hasLength(0);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).hasLength(4);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").hasLength(4);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.intArrayAssertion(), null).isNull();

        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).isNull();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").isNull();
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        int[] value = new int[]{1, 2};
        initialize(Raw.intArrayAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.intArrayAssertion(), value).isSameAs(new int[]{1, 2});
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[1, 2]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), value, "Message").isSameAs(new int[]{1, 2});
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<[1, 2]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        int[] value = new int[]{1, 2};
        initialize(Raw.intArrayAssertion(), value).isNotSameAs(new int[]{1, 2});

        try {
            initialize(Raw.intArrayAssertion(), value).isNotSameAs(value);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(IntArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<[1, 2]>");
        }
    }

}
