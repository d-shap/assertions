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
 * Tests for {@link BooleanArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class BooleanArrayAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public BooleanArrayAssertionTest() {
        super();
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{});

        try {
            initializeWithRawActual(Raw.booleanArrayAssertion(), new Object());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[Z> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.booleanArrayAssertion(), new Object(), "Message");
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[Z> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{}).isEmpty();
        initialize(Raw.booleanArrayAssertion(), new boolean[]{}).isNotNull().isEmpty().isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().isEmpty();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).isEmpty();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").isEmpty();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}).isEmpty();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[T, F]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}, "Message").isEmpty();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[T, F]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.booleanArrayAssertion(), null).isNullOrEmpty();
        initialize(Raw.booleanArrayAssertion(), new boolean[]{}).isNullOrEmpty();
        initialize(Raw.booleanArrayAssertion(), new boolean[]{}).isNotNull().isNullOrEmpty().isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().isNullOrEmpty();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}).isNullOrEmpty();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[T, F]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}, "Message").isNullOrEmpty();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[T, F]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}).isNotEmpty();
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}).isNotNull().isNotEmpty().isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().isNotEmpty();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).isNotEmpty();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").isNotEmpty();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).isNotEmpty();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").isNotEmpty();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}).contains(true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}).contains(false);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}).isNotNull().contains(false).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().contains(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).contains(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").contains(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).contains(false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<F> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").contains(false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<F> but was:<[T, T]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).doesNotContain(false);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).isNotNull().doesNotContain(false).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().doesNotContain(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).doesNotContain(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").doesNotContain(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).doesNotContain(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<T> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").doesNotContain(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<T> but was:<[T, T]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAll(true, true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAll(true, false);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAll(false, true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).isNotNull().containsAll(false, true).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().containsAll(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAll(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAll(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAll((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAll((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsAll((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsAll((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsAll();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsAll();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAll(false, false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[F, F]> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAll(false, false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[F, F]> but was:<[T, T]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAll(DataHelper.createIterable(true, true));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAll(DataHelper.createIterable(true, false));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAll(DataHelper.createIterable(false, true));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).isNotNull().containsAll(DataHelper.createIterable(false, true)).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().containsAll(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAll(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAll(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAll((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAll((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsAll((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsAll((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsAll(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsAll(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAll(DataHelper.createIterable(false, false));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[F, F]> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAll(DataHelper.createIterable(false, false));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[F, F]> but was:<[T, T]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAllInOrder(true, true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAllInOrder(true, false);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).isNotNull().containsAllInOrder(true, false).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().containsAllInOrder(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAllInOrder(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAllInOrder(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAllInOrder((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAllInOrder((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsAllInOrder((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsAllInOrder((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsAllInOrder();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsAllInOrder();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAllInOrder(false, false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[F, F]> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}).containsAllInOrder(false, true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[F, T]> but was:<[T, F]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}, "Message").containsAllInOrder(false, true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[F, T]> but was:<[T, F]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAllInOrder(DataHelper.createIterable(true, true));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAllInOrder(DataHelper.createIterable(true, false));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).isNotNull().containsAllInOrder(DataHelper.createIterable(true, false)).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().containsAllInOrder(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAllInOrder(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAllInOrder(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAllInOrder((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAllInOrder((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsAllInOrder((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsAllInOrder((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsAllInOrder(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsAllInOrder(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAllInOrder(DataHelper.createIterable(false, false));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[F, F]> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}).containsAllInOrder(DataHelper.createIterable(false, true));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[F, T]> but was:<[T, F]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}, "Message").containsAllInOrder(DataHelper.createIterable(false, true));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[F, T]> but was:<[T, F]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactly(true, true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(true, false, true, false);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(false, false, true, true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsExactly();
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).isNotNull().containsExactly(true, true).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().containsExactly(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactly(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactly(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactly((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactly((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsExactly((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsExactly((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactly(false, false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[F, F]> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(true, true, false, false, false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[T, T, F, F, F]> but was:<[T, T, F, F]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactly();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(true, true, true, false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[T, T, T, F]> but was:<[T, T, F, F]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}, "Message").containsExactly(true, true, true, false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[T, T, T, F]> but was:<[T, T, F, F]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactly(DataHelper.createIterable(true, true));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(DataHelper.createIterable(true, false, true, false));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(DataHelper.createIterable(false, false, true, true));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsExactly(DataHelper.<Boolean>createIterable());
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).isNotNull().containsExactly(DataHelper.createIterable(true, true)).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().containsExactly(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactly(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactly(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactly((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactly((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsExactly((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsExactly((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactly(DataHelper.createIterable(false, false));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[F, F]> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(DataHelper.createIterable(true, true, false, false, false));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[T, T, F, F, F]> but was:<[T, T, F, F]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactly(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(DataHelper.createIterable(true, true, true, false));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[T, T, T, F]> but was:<[T, T, F, F]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}, "Message").containsExactly(DataHelper.createIterable(true, true, true, false));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[T, T, T, F]> but was:<[T, T, F, F]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactlyInOrder(true, true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(true, true, false, false);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsExactlyInOrder();
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).isNotNull().containsExactlyInOrder(true, true).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().containsExactlyInOrder(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactlyInOrder(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactlyInOrder(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactlyInOrder((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactlyInOrder((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsExactlyInOrder((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsExactlyInOrder((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactlyInOrder(false, false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[F, F]> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(true, true, false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[T, T, F]> but was:<[T, T, F, F]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(true, true, false, false, false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[T, T, F, F, F]> but was:<[T, T, F, F]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactlyInOrder();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(true, false, true, false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[T, F, T, F]> but was:<[T, T, F, F]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}, "Message").containsExactlyInOrder(true, false, true, false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[T, F, T, F]> but was:<[T, T, F, F]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactlyInOrder(DataHelper.createIterable(true, true));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(DataHelper.createIterable(true, true, false, false));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsExactlyInOrder(DataHelper.<Boolean>createIterable());
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).isNotNull().containsExactlyInOrder(DataHelper.createIterable(true, true)).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().containsExactlyInOrder(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactlyInOrder(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactlyInOrder((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactlyInOrder((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsExactlyInOrder((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsExactlyInOrder((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactlyInOrder(DataHelper.createIterable(false, false));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[F, F]> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(DataHelper.createIterable(true, true, false));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[T, T, F]> but was:<[T, T, F, F]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(DataHelper.createIterable(true, true, false, false, false));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[T, T, F, F, F]> but was:<[T, T, F, F]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactlyInOrder(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(DataHelper.createIterable(true, false, true, false));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[T, F, T, F]> but was:<[T, T, F, F]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}, "Message").containsExactlyInOrder(DataHelper.createIterable(true, false, true, false));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[T, F, T, F]> but was:<[T, T, F, F]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAny(true, true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAny(true, true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAny(false, false);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAny(true, false);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).isNotNull().containsAny(true, false).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().containsAny(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAny(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAny(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAny((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAny((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsAny((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsAny((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsAny();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsAny();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAny(false, false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[F, F]> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAny(false, false);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[F, F]> but was:<[T, T]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAny(DataHelper.createIterable(true, true));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAny(DataHelper.createIterable(true, true));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAny(DataHelper.createIterable(false, false));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAny(DataHelper.createIterable(true, false));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).isNotNull().containsAny(DataHelper.createIterable(true, false)).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().containsAny(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAny(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAny(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAny((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAny((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsAny((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsAny((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsAny(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsAny(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAny(DataHelper.createIterable(false, false));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[F, F]> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAny(DataHelper.createIterable(false, false));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[F, F]> but was:<[T, T]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(false, false);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(false, false, false);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).isNotNull().containsNone(false, false, false).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().containsNone(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsNone(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsNone(true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsNone((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsNone((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsNone((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsNone((boolean[]) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsNone();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsNone();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(true, true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[T, T]> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(false, true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[F, T]> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsNone(false, true);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[F, T]> but was:<[T, T]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(DataHelper.createIterable(false, false));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(DataHelper.createIterable(false, false, false));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).isNotNull().containsNone(DataHelper.createIterable(false, false, false)).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().containsNone(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsNone(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsNone(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsNone((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsNone((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsNone((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsNone((Iterable<Boolean>) null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).containsNone(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").containsNone(DataHelper.<Boolean>createIterable());
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(DataHelper.createIterable(true, true));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[T, T]> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(DataHelper.createIterable(false, true));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[F, T]> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsNone(DataHelper.createIterable(false, true));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[F, T]> but was:<[T, T]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).toLength().isEqualTo(2);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).toLength().isGreaterThan(1);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).toLength().isLessThan(3);

        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).toLength().isEqualTo(4);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).toLength().isGreaterThan(3);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).toLength().isLessThan(5);

        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).isNotNull().toLength().isEqualTo(4);

        try {
            Raw.booleanArrayAssertion().toLength();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).toLength();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").toLength();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).toLength()).isEqualTo(0);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").toLength()).isEqualTo(0);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).toLength().isEqualTo(4);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").toLength().isEqualTo(4);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void toLengthMatcherTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).toLength(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).toLength(Matchers.is(Matchers.greaterThan(1)));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).toLength(Matchers.is(Matchers.lessThan(3)));

        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).toLength(Matchers.equalTo(4));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).toLength(Matchers.greaterThan(3));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).toLength(Matchers.lessThan(5));

        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).isNotNull().toLength(Matchers.equalTo(4)).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().toLength(Matchers.equalTo(0));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).toLength(Matchers.equalTo(0));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").toLength(Matchers.equalTo(0));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).toLength(null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").toLength(null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}).toLength(null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{}, "Message").toLength(null);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).toLength(Matchers.equalTo(4));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").toLength(Matchers.equalTo(4));
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\nExpected: <4>\n     but: was <2>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).hasLength(2);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).hasLength(4);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).isNotNull().hasLength(4).isInstanceOf(boolean[].class);

        try {
            Raw.booleanArrayAssertion().hasLength(0);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).hasLength(0);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").hasLength(0);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).hasLength(4);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").hasLength(4);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.booleanArrayAssertion(), null).isNull();

        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).isNull();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").isNull();
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[T, T]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        boolean[] value = new boolean[]{true, true};
        initialize(Raw.booleanArrayAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.booleanArrayAssertion(), value).isSameAs(new boolean[]{true, true});
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[T, T]> but was:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), value, "Message").isSameAs(new boolean[]{true, true});
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<[T, T]> but was:<[T, T]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        boolean[] value = new boolean[]{true, true};
        initialize(Raw.booleanArrayAssertion(), value).isNotSameAs(new boolean[]{true, true});

        try {
            initialize(Raw.booleanArrayAssertion(), value).isNotSameAs(value);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[T, T]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(BooleanArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<[T, T]>");
        }
    }

}
