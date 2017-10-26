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
 * Tests for {@link ByteArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public ByteArrayAssertionTest() {
        super();
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).contains(1);
        new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).contains(2);

        try {
            new ByteArrayAssertion(null, new FailDescription()).contains(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).contains(3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription("Message")).contains(3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).doesNotContain(3);

        try {
            new ByteArrayAssertion(null, new FailDescription()).doesNotContain(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).doesNotContain(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription("Message")).doesNotContain(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAll((byte) 1);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsAll((byte) 1, (byte) 3);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsAll((byte) 4, (byte) 2);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsAll(4, 2);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsAll(Arrays.asList((byte) 4, (byte) 2));

        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAll((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAll(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAll((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAll((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAll((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAll((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAll((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAll((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAll();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAll(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription("Message")).containsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAll(2, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription("Message")).containsAll(2, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription("Message")).containsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAllInOrder((byte) 1);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsAllInOrder((byte) 1, (byte) 3, (byte) 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsAllInOrder(1, 3, 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsAllInOrder(Arrays.asList((byte) 1, (byte) 3, (byte) 4));

        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAllInOrder((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAllInOrder(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAllInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAllInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAllInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAllInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAllInOrder();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAllInOrder(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAllInOrder((byte) 2, (byte) 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription("Message")).containsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAllInOrder(2, 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription("Message")).containsAllInOrder(2, 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription("Message")).containsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactly((byte) 1, (byte) 2);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactly((byte) 1, (byte) 3, (byte) 2, (byte) 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactly(1, 3, 2, 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactly(Arrays.asList((byte) 1, (byte) 3, (byte) 2, (byte) 4));
        new ByteArrayAssertion(new byte[0], new FailDescription()).containsExactly();
        new ByteArrayAssertion(new byte[0], new FailDescription()).containsExactly(new int[0]);
        new ByteArrayAssertion(new byte[0], new FailDescription()).containsExactly(new ArrayList<Byte>());

        try {
            new ByteArrayAssertion(null, new FailDescription()).containsExactly((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsExactly(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsExactly((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsExactly((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactly((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactly((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactly((byte) 2, (byte) 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactly();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactly(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription("Message")).containsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactly(1, 1, 3, 2);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription("Message")).containsExactly(1, 1, 3, 2);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription("Message")).containsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactlyInOrder((byte) 1, (byte) 2);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder(1, 2, 3, 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        new ByteArrayAssertion(new byte[0], new FailDescription()).containsExactlyInOrder();
        new ByteArrayAssertion(new byte[0], new FailDescription()).containsExactlyInOrder(new int[0]);
        new ByteArrayAssertion(new byte[0], new FailDescription()).containsExactlyInOrder(new ArrayList<Byte>());

        try {
            new ByteArrayAssertion(null, new FailDescription()).containsExactlyInOrder((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsExactlyInOrder(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsExactlyInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactlyInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactlyInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactlyInOrder();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactlyInOrder(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription("Message")).containsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription("Message")).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription("Message")).containsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAny((byte) 2, (byte) 3);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsAny((byte) 2);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsAny((byte) 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsAny((byte) 5, (byte) 3);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsAny(5, 3);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, new FailDescription()).containsAny(Arrays.asList((byte) 5, (byte) 3));

        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAny((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAny(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAny((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAny((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsAny((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAny((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAny((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAny((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAny();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAny(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription("Message")).containsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAny(3, 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription("Message")).containsAny(3, 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription("Message")).containsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsNone((byte) 3);
        new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsNone((byte) 3, (byte) 4);
        new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsNone(3, 4);
        new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsNone(Arrays.asList((byte) 3, (byte) 4));

        try {
            new ByteArrayAssertion(null, new FailDescription()).containsNone((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsNone(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsNone((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsNone((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, new FailDescription()).containsNone((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsNone((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsNone((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsNone((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsNone();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsNone(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsNone((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription("Message")).containsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsNone(2, 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription("Message")).containsNone(2, 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).containsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription("Message")).containsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new ByteArrayAssertion(null, new FailDescription()).isNull();

        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription()).isNull();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, new FailDescription("Message")).isNull();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        byte[] value = new byte[]{1, 2};
        new ByteArrayAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new ByteArrayAssertion(value, new FailDescription()).isSameAs(new byte[]{1, 2});
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(value, new FailDescription("Message")).isSameAs(new byte[]{1, 2});
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        byte[] value = new byte[]{1, 2};
        new ByteArrayAssertion(value, new FailDescription()).isNotSameAs(new byte[]{1, 2});
        new ByteArrayAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new ByteArrayAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1, 2]>.");
        }
        try {
            new ByteArrayAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ByteArrayAssertion(null, new FailDescription()).asString(null)).isNull();
        Assertions.assertThat(new ByteArrayAssertion(null, new FailDescription()).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(new ByteArrayAssertion(null, new FailDescription()).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(new ByteArrayAssertion(null, new FailDescription()).asString(new byte[]{1, 2})).isEqualTo("[1, 2]");
    }

}
