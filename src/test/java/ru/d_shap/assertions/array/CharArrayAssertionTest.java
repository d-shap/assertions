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

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

/**
 * Tests for {@link CharArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharArrayAssertionTest {

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
    public void containsTest() {
        new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).contains('1');
        new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).contains('2');

        try {
            new CharArrayAssertion(null, new FailDescription()).contains('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).contains('3');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription("Message")).contains('3');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).doesNotContain('3');

        try {
            new CharArrayAssertion(null, new FailDescription()).doesNotContain('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).doesNotContain('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription("Message")).doesNotContain('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAll('1');
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsAll('1', '3');
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsAll('4', '2');
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsAll(52, 50);
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsAll(Arrays.asList('4', '2'));

        try {
            new CharArrayAssertion(null, new FailDescription()).containsAll('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(null, new FailDescription()).containsAll(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(null, new FailDescription()).containsAll(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAll((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAll((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAll((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAll();
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAll(new int[0]);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAll(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAll('2', '3');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription("Message")).containsAll('2', '3');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAll(50, 51);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription("Message")).containsAll(50, 51);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription("Message")).containsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAllInOrder('1');
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsAllInOrder('1', '3', '4');
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsAllInOrder(49, 51, 52);
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsAllInOrder(Arrays.asList('1', '3', '4'));

        try {
            new CharArrayAssertion(null, new FailDescription()).containsAllInOrder('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(null, new FailDescription()).containsAllInOrder(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAllInOrder((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAllInOrder((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAllInOrder((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAllInOrder();
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAllInOrder(new int[0]);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAllInOrder('2', '3');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAllInOrder('2', '1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription("Message")).containsAllInOrder('2', '1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAllInOrder(50, 49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription("Message")).containsAllInOrder(50, 49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription("Message")).containsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactly('1', '2');
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactly('1', '2', '3', '4');
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactly('1', '3', '2', '4');
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactly(49, 51, 50, 52);
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactly(Arrays.asList('1', '3', '2', '4'));
        new CharArrayAssertion(new char[0], new FailDescription()).containsExactly();
        new CharArrayAssertion(new char[0], new FailDescription()).containsExactly(new int[0]);
        new CharArrayAssertion(new char[0], new FailDescription()).containsExactly(new ArrayList<Character>());

        try {
            new CharArrayAssertion(null, new FailDescription()).containsExactly('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(null, new FailDescription()).containsExactly(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(null, new FailDescription()).containsExactly(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactly((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactly((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactly((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactly('2', '3');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactly();
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactly(new int[0]);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactly(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactly('1', '1', '3', '2');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription("Message")).containsExactly('1', '1', '3', '2');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactly(49, 49, 51, 50);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription("Message")).containsExactly(49, 49, 51, 50);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription("Message")).containsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactlyInOrder('1', '2');
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactlyInOrder('1', '2', '3', '4');
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactlyInOrder(49, 50, 51, 52);
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactlyInOrder(Arrays.asList('1', '2', '3', '4'));
        new CharArrayAssertion(new char[0], new FailDescription()).containsExactlyInOrder();
        new CharArrayAssertion(new char[0], new FailDescription()).containsExactlyInOrder(new int[0]);
        new CharArrayAssertion(new char[0], new FailDescription()).containsExactlyInOrder(new ArrayList<Character>());

        try {
            new CharArrayAssertion(null, new FailDescription()).containsExactlyInOrder('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(null, new FailDescription()).containsExactlyInOrder(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactlyInOrder((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactlyInOrder((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactlyInOrder('2', '1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactlyInOrder('1', '2', '3');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactlyInOrder();
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactlyInOrder(new int[0]);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription("Message")).containsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription("Message")).containsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription("Message")).containsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAny('2', '3');
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsAny('2');
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsAny('4');
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsAny('5', '3');
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsAny(53, 51);
        new CharArrayAssertion(new char[]{'1', '2', '3', '4'}, new FailDescription()).containsAny(Arrays.asList('5', '3'));

        try {
            new CharArrayAssertion(null, new FailDescription()).containsAny('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(null, new FailDescription()).containsAny(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(null, new FailDescription()).containsAny(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAny((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAny((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAny((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAny();
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAny(new int[0]);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAny(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAny('3', '4');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription("Message")).containsAny('3', '4');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAny(51, 52);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription("Message")).containsAny(51, 52);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription("Message")).containsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsNone('3');
        new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsNone('3', '4');
        new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsNone(51, 52);
        new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsNone(Arrays.asList('3', '4'));

        try {
            new CharArrayAssertion(null, new FailDescription()).containsNone('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(null, new FailDescription()).containsNone(49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(null, new FailDescription()).containsNone(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsNone((char[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsNone((int[]) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsNone((Iterable<Character>) null);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsNone();
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsNone(new int[0]);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsNone(new ArrayList<Character>());
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsNone('1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsNone('2', '1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription("Message")).containsNone('2', '1');
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsNone(50, 49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription("Message")).containsNone(50, 49);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).containsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription("Message")).containsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new CharArrayAssertion(null, new FailDescription()).isNull();

        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription()).isNull();
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(new char[]{'1', '2'}, new FailDescription("Message")).isNull();
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[1, 2]>.");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        char[] value = new char[]{'1', '2'};
        new CharArrayAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new CharArrayAssertion(value, new FailDescription()).isSameAs(new char[]{'1', '2'});
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(value, new FailDescription("Message")).isSameAs(new char[]{'1', '2'});
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        char[] value = new char[]{'1', '2'};
        new CharArrayAssertion(value, new FailDescription()).isNotSameAs(new char[]{'1', '2'});
        new CharArrayAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new CharArrayAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1, 2]>.");
        }
        try {
            new CharArrayAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("CharArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[1, 2]>.");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new CharArrayAssertion(null, new FailDescription()).asString(null, true)).isNull();
        Assertions.assertThat(new CharArrayAssertion(null, new FailDescription()).asString(new StringBuilder("test"), true)).isEqualTo("test");
        Assertions.assertThat(new CharArrayAssertion(null, new FailDescription()).asString(Arrays.asList("val1", "val2", "val3"), true)).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(new CharArrayAssertion(null, new FailDescription()).asString(new char[]{'1', '2'}, true)).isEqualTo("[1, 2]");

        Assertions.assertThat(new CharArrayAssertion(null, new FailDescription()).asString(null, false)).isNull();
        Assertions.assertThat(new CharArrayAssertion(null, new FailDescription()).asString(new StringBuilder("test"), false)).isEqualTo("test");
        Assertions.assertThat(new CharArrayAssertion(null, new FailDescription()).asString(Arrays.asList("val1", "val2", "val3"), false)).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(new CharArrayAssertion(null, new FailDescription()).asString(new char[]{'1', '2'}, false)).isEqualTo("[1, 2]");
    }

}
