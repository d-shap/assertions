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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

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
        initialize(Raw.charArrayAssertion(), new char[0]);

        try {
            initializeWithRawActual(Raw.charArrayAssertion(), new Object());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.charArrayAssertion(), new Object(), "Message");
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).contains('1');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).contains('2');

        try {
            Raw.charArrayAssertion().contains('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).contains('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).contains('3');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").contains('3');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).doesNotContain('3');

        try {
            Raw.charArrayAssertion().doesNotContain('3');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).doesNotContain('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).doesNotContain('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").doesNotContain('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
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

        try {
            Raw.charArrayAssertion().containsAll('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAll('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAll((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll();
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll('2', '3');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAll('2', '3');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
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

        try {
            Raw.charArrayAssertion().containsAll(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAll(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAll((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll(new int[0]);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll(50, 51);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAll(50, 51);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll(Arrays.asList('1', '2'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAll(Arrays.asList('1', '3'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAll(Arrays.asList('4', '2'));

        try {
            Raw.charArrayAssertion().containsAll(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAll(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAll((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayCharTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder('1', '2');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAllInOrder('1', '3', '4');

        try {
            Raw.charArrayAssertion().containsAllInOrder('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAllInOrder('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAllInOrder((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder();
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder('2', '3');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder('2', '1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAllInOrder('2', '1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayIntTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder(49, 50);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAllInOrder(49, 51, 52);

        try {
            Raw.charArrayAssertion().containsAllInOrder(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAllInOrder(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAllInOrder((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder(new int[0]);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder(50, 51);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder(50, 49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAllInOrder(50, 49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder(Arrays.asList('1', '2'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAllInOrder(Arrays.asList('1', '3', '4'));

        try {
            Raw.charArrayAssertion().containsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAllInOrder((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder(Arrays.asList('2', '3'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
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
        initialize(Raw.charArrayAssertion(), new char[0]).containsExactly();

        try {
            Raw.charArrayAssertion().containsExactly('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactly('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactly((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly('2', '3');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly();
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly('1', '1', '3', '2');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}, "Message").containsExactly('1', '1', '3', '2');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
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
        initialize(Raw.charArrayAssertion(), new char[0]).containsExactly(new int[0]);

        try {
            Raw.charArrayAssertion().containsExactly(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactly(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactly((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly(50, 51);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly(49, 50, 51, 52, 53);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly(new int[0]);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly(49, 49, 51, 50);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}, "Message").containsExactly(49, 49, 51, 50);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly(Arrays.asList('1', '2'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly(Arrays.asList('1', '2', '3', '4'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly(Arrays.asList('1', '3', '2', '4'));
        initialize(Raw.charArrayAssertion(), new char[0]).containsExactly(new ArrayList<Character>());

        try {
            Raw.charArrayAssertion().containsExactly(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactly(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactly((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly(Arrays.asList('2', '3'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactly(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}, "Message").containsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayCharTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder('1', '2');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder('1', '2', '3', '4');
        initialize(Raw.charArrayAssertion(), new char[0]).containsExactlyInOrder();

        try {
            Raw.charArrayAssertion().containsExactlyInOrder('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactlyInOrder('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactlyInOrder((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder('2', '1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder('1', '2', '3');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder();
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}, "Message").containsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayIntTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder(49, 50);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(49, 50, 51, 52);
        initialize(Raw.charArrayAssertion(), new char[0]).containsExactlyInOrder(new int[0]);

        try {
            Raw.charArrayAssertion().containsExactlyInOrder(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactlyInOrder(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactlyInOrder((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder(50, 49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(49, 50, 51);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder(new int[0]);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}, "Message").containsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder(Arrays.asList('1', '2'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(Arrays.asList('1', '2', '3', '4'));
        initialize(Raw.charArrayAssertion(), new char[0]).containsExactlyInOrder(new ArrayList<Character>());

        try {
            Raw.charArrayAssertion().containsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(Arrays.asList('1', '2', '3'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}, "Message").containsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
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

        try {
            Raw.charArrayAssertion().containsAny('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAny('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAny((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny();
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny('3', '4');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAny('3', '4');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
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

        try {
            Raw.charArrayAssertion().containsAny(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAny(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAny((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny(new int[0]);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny(51, 52);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAny(51, 52);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny(Arrays.asList('2', '3'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAny(Arrays.asList('2', '1'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAny(Arrays.asList('4', '2'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2', '3', '4'}).containsAny(Arrays.asList('5', '3'));

        try {
            Raw.charArrayAssertion().containsAny(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAny(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsAny((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayCharTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone('3', '7');
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone('3', '4', '5');

        try {
            Raw.charArrayAssertion().containsNone('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsNone('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsNone((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone();
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone('2', '1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsNone('2', '1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayIntTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone(51, 55);
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone(51, 52, 53);

        try {
            Raw.charArrayAssertion().containsNone(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsNone(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsNone((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone(new int[0]);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone(50, 49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsNone(50, 49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone(Arrays.asList('3', '7'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone(Arrays.asList('3', '4', '5'));

        try {
            Raw.charArrayAssertion().containsNone(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsNone(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).containsNone((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).containsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").containsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
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
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").isNull();
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[1, 2]>");
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
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), value, "Message").isSameAs(new char[]{'1', '2'});
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>");
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
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1, 2]>");
        }
        try {
            initialize(Raw.charArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.charArrayAssertion(), null).asString(null));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.charArrayAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.charArrayAssertion(), null).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(initialize(Raw.charArrayAssertion(), null).asString(new char[]{'1', '2'})).isEqualTo("[1, 2]");
    }

}
