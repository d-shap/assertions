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
        new ByteArrayAssertion(new byte[]{1, 2}, null).contains(1);
        new ByteArrayAssertion(new byte[]{1, 2}, null).contains(2);

        try {
            new ByteArrayAssertion(null, null).contains(1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).contains(3);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, "Message").contains(3);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new ByteArrayAssertion(new byte[]{1, 2}, null).doesNotContain(3);

        try {
            new ByteArrayAssertion(null, null).doesNotContain(1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).doesNotContain(1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, "Message").doesNotContain(1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new ByteArrayAssertion(new byte[]{1, 2}, null).containsAll((byte) 1);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsAll((byte) 1, (byte) 3);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsAll((byte) 4, (byte) 2);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsAll(4, 2);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsAll(Arrays.asList((byte) 4, (byte) 2));

        try {
            new ByteArrayAssertion(null, null).containsAll((byte) 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, null).containsAll(1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, null).containsAll(new ArrayList<Byte>());
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAll((byte[]) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAll((int[]) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAll((Iterable<Byte>) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAll();
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAll(new int[0]);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAll(new ArrayList<Byte>());
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAll((byte) 2, (byte) 3);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, "Message").containsAll((byte) 2, (byte) 3);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAll(2, 3);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, "Message").containsAll(2, 3);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, "Message").containsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new ByteArrayAssertion(new byte[]{1, 2}, null).containsAllInOrder((byte) 1);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsAllInOrder((byte) 1, (byte) 3, (byte) 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsAllInOrder(1, 3, 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsAllInOrder(Arrays.asList((byte) 1, (byte) 3, (byte) 4));

        try {
            new ByteArrayAssertion(null, null).containsAllInOrder((byte) 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, null).containsAllInOrder(1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, null).containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAllInOrder((byte[]) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAllInOrder((int[]) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAllInOrder();
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAllInOrder(new int[0]);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAllInOrder((byte) 2, (byte) 3);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, "Message").containsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAllInOrder(2, 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, "Message").containsAllInOrder(2, 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, "Message").containsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactly((byte) 1, (byte) 2);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactly((byte) 1, (byte) 3, (byte) 2, (byte) 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactly(1, 3, 2, 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactly(Arrays.asList((byte) 1, (byte) 3, (byte) 2, (byte) 4));
        new ByteArrayAssertion(new byte[0], null).containsExactly();
        new ByteArrayAssertion(new byte[0], null).containsExactly(new int[0]);
        new ByteArrayAssertion(new byte[0], null).containsExactly(new ArrayList<Byte>());

        try {
            new ByteArrayAssertion(null, null).containsExactly((byte) 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, null).containsExactly(1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, null).containsExactly(new ArrayList<Byte>());
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactly((byte[]) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactly((int[]) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactly((Iterable<Byte>) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactly((byte) 2, (byte) 3);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactly();
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactly(new int[0]);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactly(new ArrayList<Byte>());
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, "Message").containsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactly(1, 1, 3, 2);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, "Message").containsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactlyInOrder((byte) 1, (byte) 2);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactlyInOrder(1, 2, 3, 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        new ByteArrayAssertion(new byte[0], null).containsExactlyInOrder();
        new ByteArrayAssertion(new byte[0], null).containsExactlyInOrder(new int[0]);
        new ByteArrayAssertion(new byte[0], null).containsExactlyInOrder(new ArrayList<Byte>());

        try {
            new ByteArrayAssertion(null, null).containsExactlyInOrder((byte) 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, null).containsExactlyInOrder(1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, null).containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactlyInOrder((byte[]) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactlyInOrder((int[]) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactlyInOrder((byte) 2, (byte) 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactlyInOrder();
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactlyInOrder(new int[0]);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, "Message").containsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new ByteArrayAssertion(new byte[]{1, 2}, null).containsAny((byte) 2, (byte) 3);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsAny((byte) 2);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsAny((byte) 4);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsAny((byte) 5, (byte) 3);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsAny(5, 3);
        new ByteArrayAssertion(new byte[]{1, 2, 3, 4}, null).containsAny(Arrays.asList((byte) 5, (byte) 3));

        try {
            new ByteArrayAssertion(null, null).containsAny((byte) 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, null).containsAny(1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, null).containsAny(new ArrayList<Byte>());
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAny((byte[]) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAny((int[]) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAny((Iterable<Byte>) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAny();
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAny(new int[0]);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAny(new ArrayList<Byte>());
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAny((byte) 3, (byte) 4);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, "Message").containsAny((byte) 3, (byte) 4);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAny(3, 4);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, "Message").containsAny(3, 4);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, "Message").containsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new ByteArrayAssertion(new byte[]{1, 2}, null).containsNone((byte) 3);
        new ByteArrayAssertion(new byte[]{1, 2}, null).containsNone((byte) 3, (byte) 4);
        new ByteArrayAssertion(new byte[]{1, 2}, null).containsNone(3, 4);
        new ByteArrayAssertion(new byte[]{1, 2}, null).containsNone(Arrays.asList((byte) 3, (byte) 4));

        try {
            new ByteArrayAssertion(null, null).containsNone((byte) 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, null).containsNone(1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(null, null).containsNone(new ArrayList<Byte>());
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsNone((byte[]) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsNone((int[]) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsNone((Iterable<Byte>) null);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsNone();
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsNone(new int[0]);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsNone(new ArrayList<Byte>());
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsNone((byte) 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsNone((byte) 2, (byte) 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, "Message").containsNone((byte) 2, (byte) 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsNone(2, 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, "Message").containsNone(2, 1);
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).containsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, "Message").containsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new ByteArrayAssertion(new byte[0], null).createCollectionAssertion().isEmpty();
        new ByteArrayAssertion(new byte[]{1, 2}, null).createCollectionAssertion().isNotEmpty();

        try {
            new ByteArrayAssertion(new byte[]{1, 2}, null).createCollectionAssertion().isEmpty();
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1, 2}, "Message").createCollectionAssertion().isEmpty();
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>");
        }
    }

}
