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
        new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).contains(1);
        new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).contains(2);

        try {
            new ShortArrayAssertion(null, new FailDescription()).contains(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).contains(3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription("Message")).contains(3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).doesNotContain(3);

        try {
            new ShortArrayAssertion(null, new FailDescription()).doesNotContain(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).doesNotContain(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription("Message")).doesNotContain(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAll((short) 1);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsAll((short) 1, (short) 3);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsAll((short) 4, (short) 2);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsAll(4, 2);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsAll(Arrays.asList((short) 4, (short) 2));

        try {
            new ShortArrayAssertion(null, new FailDescription()).containsAll((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, new FailDescription()).containsAll(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, new FailDescription()).containsAll(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAll((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAll((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAll((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAll();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAll(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAll(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAll((short) 2, (short) 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription("Message")).containsAll((short) 2, (short) 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAll(2, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription("Message")).containsAll(2, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription("Message")).containsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAllInOrder((short) 1);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsAllInOrder((short) 1, (short) 3, (short) 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsAllInOrder(1, 3, 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsAllInOrder(Arrays.asList((short) 1, (short) 3, (short) 4));

        try {
            new ShortArrayAssertion(null, new FailDescription()).containsAllInOrder((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, new FailDescription()).containsAllInOrder(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAllInOrder((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAllInOrder((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAllInOrder();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAllInOrder(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAllInOrder((short) 2, (short) 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription("Message")).containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAllInOrder(2, 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription("Message")).containsAllInOrder(2, 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription("Message")).containsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactly((short) 1, (short) 2);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactly((short) 1, (short) 2, (short) 3, (short) 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactly((short) 1, (short) 3, (short) 2, (short) 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactly(1, 3, 2, 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactly(Arrays.asList((short) 1, (short) 3, (short) 2, (short) 4));
        new ShortArrayAssertion(new short[0], new FailDescription()).containsExactly();
        new ShortArrayAssertion(new short[0], new FailDescription()).containsExactly(new int[0]);
        new ShortArrayAssertion(new short[0], new FailDescription()).containsExactly(new ArrayList<Short>());

        try {
            new ShortArrayAssertion(null, new FailDescription()).containsExactly((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, new FailDescription()).containsExactly(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, new FailDescription()).containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactly((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactly((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactly((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactly((short) 2, (short) 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactly();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactly(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription("Message")).containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactly(1, 1, 3, 2);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription("Message")).containsExactly(1, 1, 3, 2);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription("Message")).containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactlyInOrder((short) 1, (short) 2);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder(1, 2, 3, 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4));
        new ShortArrayAssertion(new short[0], new FailDescription()).containsExactlyInOrder();
        new ShortArrayAssertion(new short[0], new FailDescription()).containsExactlyInOrder(new int[0]);
        new ShortArrayAssertion(new short[0], new FailDescription()).containsExactlyInOrder(new ArrayList<Short>());

        try {
            new ShortArrayAssertion(null, new FailDescription()).containsExactlyInOrder((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, new FailDescription()).containsExactlyInOrder(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactlyInOrder((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactlyInOrder((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactlyInOrder((short) 2, (short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder((short) 1, (short) 2, (short) 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactlyInOrder();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactlyInOrder(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription("Message")).containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription("Message")).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription("Message")).containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAny((short) 2, (short) 3);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsAny((short) 2);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsAny((short) 4);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsAny((short) 5, (short) 3);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsAny(5, 3);
        new ShortArrayAssertion(new short[]{1, 2, 3, 4}, new FailDescription()).containsAny(Arrays.asList((short) 5, (short) 3));

        try {
            new ShortArrayAssertion(null, new FailDescription()).containsAny((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, new FailDescription()).containsAny(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, new FailDescription()).containsAny(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAny((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAny((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAny((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAny();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAny(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAny(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAny((short) 3, (short) 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription("Message")).containsAny((short) 3, (short) 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAny(3, 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription("Message")).containsAny(3, 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription("Message")).containsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsNone((short) 3);
        new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsNone((short) 3, (short) 4);
        new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsNone(3, 4);
        new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsNone(Arrays.asList((short) 3, (short) 4));

        try {
            new ShortArrayAssertion(null, new FailDescription()).containsNone((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, new FailDescription()).containsNone(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(null, new FailDescription()).containsNone(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsNone((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsNone((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsNone((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsNone();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsNone(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsNone(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsNone((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsNone((short) 2, (short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription("Message")).containsNone((short) 2, (short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsNone(2, 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription("Message")).containsNone(2, 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).containsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription("Message")).containsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void createListAssertionTest() {
        new ShortArrayAssertion(new short[0], new FailDescription()).createListAssertion().isEmpty();
        new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).createListAssertion().isNotEmpty();

        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription()).createListAssertion().isEmpty();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>.");
        }
        try {
            new ShortArrayAssertion(new short[]{1, 2}, new FailDescription("Message")).createListAssertion().isEmpty();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>.");
        }
    }

}
