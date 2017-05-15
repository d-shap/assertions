///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
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

/**
 * Tests for {@link IntArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayAssertionTest {

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
    public void containsTest() {
        new IntArrayAssertion(new int[]{1, 2}, null).contains(1);
        new IntArrayAssertion(new int[]{1, 2}, null).contains(2);

        try {
            new IntArrayAssertion(null, null).contains(1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).contains(3);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, "Message").contains(3);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new IntArrayAssertion(new int[]{1, 2}, null).doesNotContain(3);

        try {
            new IntArrayAssertion(null, null).doesNotContain(1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).doesNotContain(1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, "Message").doesNotContain(1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new IntArrayAssertion(new int[]{1, 2}, null).containsAll(1);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsAll(1, 3);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsAll(4, 2);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsAll(Arrays.asList(4, 2));

        try {
            new IntArrayAssertion(null, null).containsAll(1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(null, null).containsAll(new ArrayList<Integer>());
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAll((int[]) null);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAll();
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAll((Iterable<Integer>) null);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAll(new ArrayList<Integer>());
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAll(2, 3);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, "Message").containsAll(2, 3);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAll(Arrays.asList(2, 3));
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, "Message").containsAll(Arrays.asList(2, 3));
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new IntArrayAssertion(new int[]{1, 2}, null).containsAllInOrder(1);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsAllInOrder(1, 3, 4);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsAllInOrder(Arrays.asList(1, 3, 4));

        try {
            new IntArrayAssertion(null, null).containsAllInOrder(1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(null, null).containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAllInOrder((int[]) null);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAllInOrder();
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAllInOrder(2, 3);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAllInOrder(2, 1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, "Message").containsAllInOrder(2, 1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, "Message").containsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new IntArrayAssertion(new int[]{1, 2}, null).containsExactly(1, 2);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsExactly(1, 2, 3, 4);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsExactly(1, 3, 2, 4);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsExactly(Arrays.asList(1, 3, 2, 4));
        new IntArrayAssertion(new int[0], null).containsExactly();
        new IntArrayAssertion(new int[0], null).containsExactly(new ArrayList<Integer>());

        try {
            new IntArrayAssertion(null, null).containsExactly(1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(null, null).containsExactly(new ArrayList<Integer>());
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsExactly((int[]) null);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsExactly((Iterable<Integer>) null);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsExactly(2, 3);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsExactly();
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsExactly(new ArrayList<Integer>());
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsExactly(1, 1, 3, 2);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, "Message").containsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new IntArrayAssertion(new int[]{1, 2}, null).containsExactlyInOrder(1, 2);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsExactlyInOrder(1, 2, 3, 4);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsExactlyInOrder(Arrays.asList(1, 2, 3, 4));
        new IntArrayAssertion(new int[0], null).containsExactlyInOrder();
        new IntArrayAssertion(new int[0], null).containsExactlyInOrder(new ArrayList<Integer>());

        try {
            new IntArrayAssertion(null, null).containsExactlyInOrder(1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(null, null).containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsExactlyInOrder((int[]) null);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsExactlyInOrder(2, 1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsExactlyInOrder(1, 2, 3);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsExactlyInOrder();
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new IntArrayAssertion(new int[]{1, 2}, null).containsAny(2, 3);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsAny(2);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsAny(4);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsAny(5, 3);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, null).containsAny(Arrays.asList(5, 3));

        try {
            new IntArrayAssertion(null, null).containsAny(1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(null, null).containsAny(new ArrayList<Integer>());
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAny((int[]) null);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAny();
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAny((Iterable<Integer>) null);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAny(new ArrayList<Integer>());
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAny(3, 4);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, "Message").containsAny(3, 4);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsAny(Arrays.asList(3, 4));
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, "Message").containsAny(Arrays.asList(3, 4));
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new IntArrayAssertion(new int[]{1, 2}, null).containsNone(3);
        new IntArrayAssertion(new int[]{1, 2}, null).containsNone(3, 4);
        new IntArrayAssertion(new int[]{1, 2}, null).containsNone(Arrays.asList(3, 4));

        try {
            new IntArrayAssertion(null, null).containsNone(1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(null, null).containsNone(new ArrayList<Integer>());
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsNone((int[]) null);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsNone();
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsNone((Iterable<Integer>) null);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsNone(new ArrayList<Integer>());
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsNone(1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsNone(2, 1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, "Message").containsNone(2, 1);
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, null).containsNone(Arrays.asList(2, 1));
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, "Message").containsNone(Arrays.asList(2, 1));
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new IntArrayAssertion(new int[0], null).createCollectionAssertion().isEmpty();
        new IntArrayAssertion(new int[]{1, 2}, null).createCollectionAssertion().isNotEmpty();

        try {
            new IntArrayAssertion(new int[]{1, 2}, null).createCollectionAssertion().isEmpty();
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, "Message").createCollectionAssertion().isEmpty();
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>");
        }
    }

}
