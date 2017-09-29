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
        new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).contains(1);
        new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).contains(2);

        try {
            new IntArrayAssertion(null, new FailDescription()).contains(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).contains(3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription().addMessage("Message")).contains(3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).doesNotContain(3);

        try {
            new IntArrayAssertion(null, new FailDescription()).doesNotContain(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).doesNotContain(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription().addMessage("Message")).doesNotContain(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAll(1);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsAll(1, 3);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsAll(4, 2);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsAll(Arrays.asList(4, 2));

        try {
            new IntArrayAssertion(null, new FailDescription()).containsAll(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(null, new FailDescription()).containsAll(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAll((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAll();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAll((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAll(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAll(2, 3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription().addMessage("Message")).containsAll(2, 3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAll(Arrays.asList(2, 3));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription().addMessage("Message")).containsAll(Arrays.asList(2, 3));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAllInOrder(1);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsAllInOrder(1, 3, 4);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsAllInOrder(Arrays.asList(1, 3, 4));

        try {
            new IntArrayAssertion(null, new FailDescription()).containsAllInOrder(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAllInOrder((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAllInOrder();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAllInOrder(2, 3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAllInOrder(2, 1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription().addMessage("Message")).containsAllInOrder(2, 1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription().addMessage("Message")).containsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsExactly(1, 2);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsExactly(1, 2, 3, 4);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsExactly(1, 3, 2, 4);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsExactly(Arrays.asList(1, 3, 2, 4));
        new IntArrayAssertion(new int[0], new FailDescription()).containsExactly();
        new IntArrayAssertion(new int[0], new FailDescription()).containsExactly(new ArrayList<Integer>());

        try {
            new IntArrayAssertion(null, new FailDescription()).containsExactly(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(null, new FailDescription()).containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsExactly((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsExactly(2, 3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsExactly();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsExactly(1, 1, 3, 2);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription().addMessage("Message")).containsExactly(1, 1, 3, 2);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription().addMessage("Message")).containsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsExactlyInOrder(1, 2);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder(1, 2, 3, 4);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder(Arrays.asList(1, 2, 3, 4));
        new IntArrayAssertion(new int[0], new FailDescription()).containsExactlyInOrder();
        new IntArrayAssertion(new int[0], new FailDescription()).containsExactlyInOrder(new ArrayList<Integer>());

        try {
            new IntArrayAssertion(null, new FailDescription()).containsExactlyInOrder(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsExactlyInOrder((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsExactlyInOrder(2, 1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder(1, 2, 3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsExactlyInOrder();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription().addMessage("Message")).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription().addMessage("Message")).containsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAny(2, 3);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsAny(2);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsAny(4);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsAny(5, 3);
        new IntArrayAssertion(new int[]{1, 2, 3, 4}, new FailDescription()).containsAny(Arrays.asList(5, 3));

        try {
            new IntArrayAssertion(null, new FailDescription()).containsAny(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(null, new FailDescription()).containsAny(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAny((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAny();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAny((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAny(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAny(3, 4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription().addMessage("Message")).containsAny(3, 4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsAny(Arrays.asList(3, 4));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription().addMessage("Message")).containsAny(Arrays.asList(3, 4));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsNone(3);
        new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsNone(3, 4);
        new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsNone(Arrays.asList(3, 4));

        try {
            new IntArrayAssertion(null, new FailDescription()).containsNone(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(null, new FailDescription()).containsNone(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsNone((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsNone();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsNone((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsNone(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsNone(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsNone(2, 1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription().addMessage("Message")).containsNone(2, 1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).containsNone(Arrays.asList(2, 1));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription().addMessage("Message")).containsNone(Arrays.asList(2, 1));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void createListAssertionTest() {
        new IntArrayAssertion(new int[0], new FailDescription()).createListAssertion().isEmpty();
        new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).createListAssertion().isNotEmpty();

        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription()).createListAssertion().isEmpty();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>.");
        }
        try {
            new IntArrayAssertion(new int[]{1, 2}, new FailDescription().addMessage("Message")).createListAssertion().isEmpty();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>.");
        }
    }

}
