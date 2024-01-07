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
 * Tests for {@link CharArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharArrayAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CharArrayAssertionTest() {
        super();
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.charArrayAssertion(), new char[]{});

        try {
            initializeWithRawActual(Raw.charArrayAssertion(), new Object());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[C> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.charArrayAssertion(), new Object(), "Message");
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[C> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.charArrayAssertion(), new char[]{}).isEmpty();
        initialize(Raw.charArrayAssertion(), new char[]{}).isNotNull().isEmpty().isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().isEmpty();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).isEmpty();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").isEmpty();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isEmpty();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").isEmpty();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.charArrayAssertion(), null).isNullOrEmpty();
        initialize(Raw.charArrayAssertion(), new char[]{}).isNullOrEmpty();
        initialize(Raw.charArrayAssertion(), new char[]{}).isNotNull().isNullOrEmpty().isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().isNullOrEmpty();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isNullOrEmpty();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").isNullOrEmpty();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isNotEmpty();
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isNotNull().isNotEmpty().isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().isNotEmpty();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).isNotEmpty();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").isNotEmpty();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).isNotEmpty();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").isNotEmpty();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).contains('1');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).contains('2');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isNotNull().contains('2').isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().contains('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).contains('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").contains('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).contains('3');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3(51)> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").contains('3');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3(51)> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).doesNotContain('3');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isNotNull().doesNotContain('3').isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().doesNotContain('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).doesNotContain('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").doesNotContain('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).doesNotContain('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1(49)> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").doesNotContain('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1(49)> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayCharTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll('1', '2');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAll('1', '3');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAll('4', '2');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).isNotNull().containsAll('4', '2').isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsAll('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAll('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAll('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAll((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAll((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAll((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAll((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAll();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAll();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll('2', '3');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAll('2', '3');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayIntTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll(49, 50);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAll(49, 51);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAll(52, 50);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).isNotNull().containsAll(52, 50).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsAll(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAll(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAll(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAll((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAll((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAll((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAll((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAll(new int[]{});
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAll(new int[]{});
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll(50, 51);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAll(50, 51);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll(100000, 100001);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[100000, 100001]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAll(100000, 100001);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[100000, 100001]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll(DataHelper.createIterable('1', '2'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAll(DataHelper.createIterable('1', '3'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAll(DataHelper.createIterable('4', '2'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).isNotNull().containsAll(DataHelper.createIterable('4', '2')).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsAll(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAll(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAll(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAll((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAll((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAll((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAll((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAll(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAll(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll(DataHelper.createIterable('2', '3'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAll(DataHelper.createIterable('2', '3'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayCharTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder('1', '2');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAllInOrder('1', '3', '4');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).isNotNull().containsAllInOrder('1', '3', '4').isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsAllInOrder('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAllInOrder('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAllInOrder('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAllInOrder((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAllInOrder((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAllInOrder((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAllInOrder((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAllInOrder();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAllInOrder();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder('2', '3');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder('2', '1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAllInOrder('2', '1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayIntTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder(49, 50);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAllInOrder(49, 51, 52);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).isNotNull().containsAllInOrder(49, 51, 52).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsAllInOrder(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAllInOrder(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAllInOrder(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAllInOrder((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAllInOrder((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAllInOrder((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAllInOrder((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAllInOrder(new int[]{});
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAllInOrder(new int[]{});
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder(50, 51);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder(50, 49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAllInOrder(50, 49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder(100000, 100001);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[100000, 100001]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAllInOrder(100000, 100001);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[100000, 100001]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder(DataHelper.createIterable('1', '2'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAllInOrder(DataHelper.createIterable('1', '3', '4'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).isNotNull().containsAllInOrder(DataHelper.createIterable('1', '3', '4')).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsAllInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAllInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAllInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAllInOrder((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAllInOrder((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAllInOrder((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAllInOrder((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAllInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAllInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder(DataHelper.createIterable('2', '3'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder(DataHelper.createIterable('2', '1'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAllInOrder(DataHelper.createIterable('2', '1'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayCharTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly('1', '2');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly('1', '2', '3', '4');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly('1', '3', '2', '4');
        initialize(Raw.charArrayAssertion(), new char[]{}).containsExactly();
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isNotNull().containsExactly('1', '2').isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsExactly('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactly('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsExactly('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactly((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsExactly((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsExactly((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsExactly((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly('2', '3');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly('1', '2', '3', '4', '5');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly('1', '1', '3', '2');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}, "Message").containsExactly('1', '1', '3', '2');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayIntTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly(49, 50);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly(49, 50, 51, 52);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly(49, 51, 50, 52);
        initialize(Raw.charArrayAssertion(), new char[]{}).containsExactly(new int[]{});
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isNotNull().containsExactly(49, 50).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsExactly(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactly(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsExactly(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactly((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsExactly((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsExactly((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsExactly((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly(50, 51);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly(49, 50, 51, 52, 53);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly(new int[]{});
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly(49, 49, 51, 50);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}, "Message").containsExactly(49, 49, 51, 50);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly(100000, 100001);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[100000, 100001]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}, "Message").containsExactly(100000, 100001);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[100000, 100001]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly(DataHelper.createIterable('1', '2'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly(DataHelper.createIterable('1', '2', '3', '4'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly(DataHelper.createIterable('1', '3', '2', '4'));
        initialize(Raw.charArrayAssertion(), new char[]{}).containsExactly(DataHelper.<Character>createIterable());
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isNotNull().containsExactly(DataHelper.createIterable('1', '2')).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsExactly(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactly(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsExactly(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactly((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsExactly((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsExactly((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsExactly((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly(DataHelper.createIterable('2', '3'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly(DataHelper.createIterable('1', '2', '3', '4', '5'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly(DataHelper.createIterable('1', '1', '3', '2'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}, "Message").containsExactly(DataHelper.createIterable('1', '1', '3', '2'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayCharTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder('1', '2');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder('1', '2', '3', '4');
        initialize(Raw.charArrayAssertion(), new char[]{}).containsExactlyInOrder();
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isNotNull().containsExactlyInOrder('1', '2').isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsExactlyInOrder('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactlyInOrder('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsExactlyInOrder('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactlyInOrder((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsExactlyInOrder((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsExactlyInOrder((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsExactlyInOrder((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder('2', '1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder('1', '2', '3');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}, "Message").containsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayIntTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder(49, 50);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(49, 50, 51, 52);
        initialize(Raw.charArrayAssertion(), new char[]{}).containsExactlyInOrder(new int[]{});
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isNotNull().containsExactlyInOrder(49, 50).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsExactlyInOrder(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactlyInOrder(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsExactlyInOrder(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactlyInOrder((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsExactlyInOrder((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder(50, 49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(49, 50, 51);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder(new int[]{});
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}, "Message").containsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(100000, 100001);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[100000, 100001]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}, "Message").containsExactlyInOrder(100000, 100001);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[100000, 100001]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder(DataHelper.createIterable('1', '2'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(DataHelper.createIterable('1', '2', '3', '4'));
        initialize(Raw.charArrayAssertion(), new char[]{}).containsExactlyInOrder(DataHelper.<Character>createIterable());
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isNotNull().containsExactlyInOrder(DataHelper.createIterable('1', '2')).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsExactlyInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactlyInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder(DataHelper.createIterable('2', '1'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(DataHelper.createIterable('1', '2', '3'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(DataHelper.createIterable('1', '2', '3', '4', '5'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(DataHelper.createIterable('2', '3', '1', '4'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}, "Message").containsExactlyInOrder(DataHelper.createIterable('2', '3', '1', '4'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayCharTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny('2', '3');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAny('2', '1');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAny('4', '2');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAny('5', '3');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).isNotNull().containsAny('5', '3').isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsAny('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAny('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAny('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAny((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAny((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAny((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAny((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAny();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAny();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny('3', '4');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAny('3', '4');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayIntTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny(50, 51);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAny(50, 49);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAny(52, 50);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAny(53, 51);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).isNotNull().containsAny(53, 51).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsAny(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAny(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAny(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAny((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAny((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAny((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAny((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAny(new int[]{});
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAny(new int[]{});
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny(51, 52);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAny(51, 52);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny(100000, 100001);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[100000, 100001]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAny(100000, 100001);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[100000, 100001]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny(DataHelper.createIterable('2', '3'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAny(DataHelper.createIterable('2', '1'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAny(DataHelper.createIterable('4', '2'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAny(DataHelper.createIterable('5', '3'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).isNotNull().containsAny(DataHelper.createIterable('5', '3')).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsAny(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAny(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAny(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAny((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsAny((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAny((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAny((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsAny(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsAny(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny(DataHelper.createIterable('3', '4'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAny(DataHelper.createIterable('3', '4'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayCharTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone('3', '7');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone('3', '4', '5');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isNotNull().containsNone('3', '4', '5').isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsNone('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsNone('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsNone('1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsNone((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsNone((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsNone((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsNone((char[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsNone();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsNone();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone('2', '1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsNone('2', '1');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayIntTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone(51, 55);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone(51, 52, 53);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone(100000, 100001);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isNotNull().containsNone(100000, 100001).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsNone(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsNone(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsNone(49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsNone((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsNone((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsNone((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsNone((int[]) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsNone(new int[]{});
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsNone(new int[]{});
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone(50, 49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsNone(50, 49);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone(DataHelper.createIterable('3', '7'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone(DataHelper.createIterable('3', '4', '5'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isNotNull().containsNone(DataHelper.createIterable('3', '4', '5')).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().containsNone(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsNone(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsNone(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsNone((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").containsNone((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsNone((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsNone((Iterable<Character>) null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).containsNone(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").containsNone(DataHelper.<Character>createIterable());
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone(DataHelper.createIterable('2', '1'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsNone(DataHelper.createIterable('2', '1'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).toLength().isEqualTo(2);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).toLength().isGreaterThan(1);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).toLength().isLessThan(3);

        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).toLength().isEqualTo(4);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).toLength().isGreaterThan(3);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).toLength().isLessThan(5);

        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).isNotNull().toLength().isEqualTo(4);

        try {
            Raw.charArrayAssertion().toLength();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).toLength();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").toLength();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).toLength()).isEqualTo(0);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").toLength()).isEqualTo(0);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).toLength().isEqualTo(4);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").toLength().isEqualTo(4);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void toLengthMatcherTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).toLength(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).toLength(Matchers.is(Matchers.greaterThan(1)));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).toLength(Matchers.is(Matchers.lessThan(3)));

        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).toLength(Matchers.equalTo(4));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).toLength(Matchers.greaterThan(3));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).toLength(Matchers.lessThan(5));

        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).isNotNull().toLength(Matchers.equalTo(4)).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().toLength(Matchers.equalTo(0));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).toLength(Matchers.equalTo(0));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").toLength(Matchers.equalTo(0));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).toLength(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").toLength(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).toLength(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").toLength(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).toLength(Matchers.equalTo(4));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").toLength(Matchers.equalTo(4));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\nExpected: <4>\n     but: was <2>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).hasLength(2);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).hasLength(4);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).isNotNull().hasLength(4).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().hasLength(0);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).hasLength(0);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").hasLength(0);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).hasLength(4);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").hasLength(4);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.charArrayAssertion(), null).isNull();

        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).isNull();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").isNull();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        char[] value = new char[]{'1', '2'};
        initialize(Raw.charArrayAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.charArrayAssertion(), value).isSameAs(new char[]{'1', '2'});
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), value, "Message").isSameAs(new char[]{'1', '2'});
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        char[] value = new char[]{'1', '2'};
        initialize(Raw.charArrayAssertion(), value).isNotSameAs(new char[]{'1', '2'});

        try {
            initialize(Raw.charArrayAssertion(), value).isNotSameAs(value);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<[1(49), 2(50)]>");
        }
    }

}
