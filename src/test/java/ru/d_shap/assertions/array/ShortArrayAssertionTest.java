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
 * Tests for {@link ShortArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public ShortArrayAssertionTest() {
        super();
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        new ShortArrayAssertion(new short[]{1, 2}, null).contains(1);
        new ShortArrayAssertion(new short[]{1, 2}, null).contains(2);

        try {
            new ShortArrayAssertion(null, null).contains(1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).contains(3);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, "Message").contains(3);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new ShortArrayAssertion(new short[]{1, 2}, null).doesNotContain(3);

        try {
            new ShortArrayAssertion(null, null).doesNotContain(1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).doesNotContain(1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, "Message").doesNotContain(1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new ShortArrayAssertion(new short[]{1, 2}, null).containsAll((short) 1);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsAll((short) 1, (short) 3);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsAll((short) 4, (short) 2);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsAll(4, 2);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsAll(Arrays.asList((short) 4, (short) 2));

        try {
            new ShortArrayAssertion(null, null).containsAll((short) 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, null).containsAll(1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, null).containsAll(new ArrayList<Short>());
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAll((short[]) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAll((int[]) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAll((Iterable<Short>) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAll();
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAll(new int[0]);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAll(new ArrayList<Short>());
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAll((short) 2, (short) 3);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, "Message").containsAll((short) 2, (short) 3);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAll(2, 3);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, "Message").containsAll(2, 3);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, "Message").containsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new ShortArrayAssertion(new short[]{1, 2}, null).containsAllInOrder((short) 1);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsAllInOrder((short) 1, (short) 3, (short) 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsAllInOrder(1, 3, 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsAllInOrder(Arrays.asList((short) 1, (short) 3, (short) 4));

        try {
            new ShortArrayAssertion(null, null).containsAllInOrder((short) 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, null).containsAllInOrder(1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, null).containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAllInOrder((short[]) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAllInOrder((int[]) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAllInOrder();
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAllInOrder(new int[0]);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAllInOrder((short) 2, (short) 3);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, "Message").containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAllInOrder(2, 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, "Message").containsAllInOrder(2, 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, "Message").containsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new ShortArrayAssertion(new short[]{1, 2}, null).containsExactly((short) 1, (short) 2);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactly((short) 1, (short) 2, (short) 3, (short) 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactly((short) 1, (short) 3, (short) 2, (short) 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactly(1, 3, 2, 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactly(Arrays.asList((short) 1, (short) 3, (short) 2, (short) 4));
        new ShortArrayAssertion(new short[0], null).containsExactly();
        new ShortArrayAssertion(new short[0], null).containsExactly(new int[0]);
        new ShortArrayAssertion(new short[0], null).containsExactly(new ArrayList<Short>());

        try {
            new ShortArrayAssertion(null, null).containsExactly((short) 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, null).containsExactly((int) 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, null).containsExactly(new ArrayList<Short>());
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsExactly((short[]) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsExactly((int[]) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsExactly((Iterable<Short>) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsExactly((short) 2, (short) 3);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsExactly();
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsExactly(new int[0]);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsExactly(new ArrayList<Short>());
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, "Message").containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactly(1, 1, 3, 2);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, "Message").containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new ShortArrayAssertion(new short[]{1, 2}, null).containsExactlyInOrder((short) 1, (short) 2);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactlyInOrder(1, 2, 3, 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4));
        new ShortArrayAssertion(new short[0], null).containsExactlyInOrder();
        new ShortArrayAssertion(new short[0], null).containsExactlyInOrder(new int[0]);
        new ShortArrayAssertion(new short[0], null).containsExactlyInOrder(new ArrayList<Short>());

        try {
            new ShortArrayAssertion(null, null).containsExactlyInOrder((short) 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, null).containsExactlyInOrder(1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, null).containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsExactlyInOrder((short[]) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsExactlyInOrder((int[]) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsExactlyInOrder((short) 2, (short) 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactlyInOrder((short) 1, (short) 2, (short) 3);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsExactlyInOrder();
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsExactlyInOrder(new int[0]);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, "Message").containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new ShortArrayAssertion(new short[]{1, 2}, null).containsAny((short) 2, (short) 3);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsAny((short) 2);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsAny((short) 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsAny((short) 5, (short) 3);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsAny(5, 3);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, null).containsAny(Arrays.asList((short) 5, (short) 3));

        try {
            new ShortArrayAssertion(null, null).containsAny((short) 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, null).containsAny(1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, null).containsAny(new ArrayList<Short>());
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAny((short[]) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAny((int[]) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAny((Iterable<Short>) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAny();
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAny(new int[0]);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAny(new ArrayList<Short>());
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAny((short) 3, (short) 4);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, "Message").containsAny((short) 3, (short) 4);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAny(3, 4);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, "Message").containsAny(3, 4);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, "Message").containsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new ShortArrayAssertion(new short[]{1, 2}, null).containsNone((short) 3);
        new ShortArrayAssertion(new short[]{1, 2}, null).containsNone((short) 3, (short) 4);
        new ShortArrayAssertion(new short[]{1, 2}, null).containsNone(3, 4);
        new ShortArrayAssertion(new short[]{1, 2}, null).containsNone(Arrays.asList((short) 3, (short) 4));

        try {
            new ShortArrayAssertion(null, null).containsNone((short) 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, null).containsNone(1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, null).containsNone(new ArrayList<Short>());
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsNone((short[]) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsNone((int[]) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsNone((Iterable<Short>) null);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsNone();
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsNone(new int[0]);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsNone(new ArrayList<Short>());
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsNone((short) 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsNone((short) 2, (short) 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, "Message").containsNone((short) 2, (short) 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsNone(2, 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, "Message").containsNone(2, 1);
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).containsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, "Message").containsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new ShortArrayAssertion(new short[0], null).createCollectionAssertion().isEmpty();
        new ShortArrayAssertion(new short[]{1, 2}, null).createCollectionAssertion().isNotEmpty();

        try {
            new ShortArrayAssertion(new short[]{1, 2}, null).createCollectionAssertion().isEmpty();
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, "Message").createCollectionAssertion().isEmpty();
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>");
        }
    }

}
