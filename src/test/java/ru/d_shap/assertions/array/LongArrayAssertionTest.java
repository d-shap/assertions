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
 * Tests for {@link LongArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public LongArrayAssertionTest() {
        super();
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        new LongArrayAssertion(new long[]{1L, 2L}, null).contains(1L);
        new LongArrayAssertion(new long[]{1L, 2L}, null).contains(2L);

        try {
            new LongArrayAssertion(null, null).contains(1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).contains(3L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, "Message").contains(3L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new LongArrayAssertion(new long[]{1L, 2L}, null).doesNotContain(3L);

        try {
            new LongArrayAssertion(null, null).doesNotContain(1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).doesNotContain(1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, "Message").doesNotContain(1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new LongArrayAssertion(new long[]{1L, 2L}, null).containsAll(1L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsAll(1L, 3L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsAll(4L, 2L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsAll(Arrays.asList(4L, 2L));

        try {
            new LongArrayAssertion(null, null).containsAll(1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(null, null).containsAll(new ArrayList<Long>());
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAll((long[]) null);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAll();
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAll((Iterable<Long>) null);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAll(new ArrayList<Long>());
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAll(2L, 3L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, "Message").containsAll(2L, 3L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAll(Arrays.asList(2L, 3L));
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, "Message").containsAll(Arrays.asList(2L, 3L));
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new LongArrayAssertion(new long[]{1L, 2L}, null).containsAllInOrder(1L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsAllInOrder(1L, 3L, 4L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsAllInOrder(Arrays.asList(1L, 3L, 4L));

        try {
            new LongArrayAssertion(null, null).containsAllInOrder(1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(null, null).containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAllInOrder((long[]) null);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAllInOrder();
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAllInOrder(2L, 3L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAllInOrder(2L, 1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, "Message").containsAllInOrder(2L, 1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, "Message").containsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new LongArrayAssertion(new long[]{1L, 2L}, null).containsExactly(1L, 2L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsExactly(1L, 2L, 3L, 4);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsExactly(1L, 3L, 2L, 4L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsExactly(Arrays.asList(1L, 3L, 2L, 4L));
        new LongArrayAssertion(new long[0], null).containsExactly();
        new LongArrayAssertion(new long[0], null).containsExactly(new ArrayList<Long>());

        try {
            new LongArrayAssertion(null, null).containsExactly(1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(null, null).containsExactly(new ArrayList<Long>());
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsExactly((long[]) null);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsExactly((Iterable<Long>) null);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsExactly(2L, 3L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsExactly();
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsExactly(new ArrayList<Long>());
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, "Message").containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, "Message").containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new LongArrayAssertion(new long[]{1L, 2L}, null).containsExactlyInOrder(1L, 2L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsExactlyInOrder(1, 2L, 3L, 4);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L));
        new LongArrayAssertion(new long[0], null).containsExactlyInOrder();
        new LongArrayAssertion(new long[0], null).containsExactlyInOrder(new ArrayList<Long>());

        try {
            new LongArrayAssertion(null, null).containsExactlyInOrder(1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(null, null).containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsExactlyInOrder((long[]) null);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsExactlyInOrder(2L, 1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsExactlyInOrder(1L, 2L, 3L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsExactlyInOrder();
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, "Message").containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, "Message").containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new LongArrayAssertion(new long[]{1L, 2L}, null).containsAny(2L, 3L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsAny(2L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsAny(4L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsAny(5L, 3L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, null).containsAny(Arrays.asList(5L, 3L));

        try {
            new LongArrayAssertion(null, null).containsAny(1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(null, null).containsAny(new ArrayList<Long>());
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAny((long[]) null);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAny();
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAny((Iterable<Long>) null);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAny(new ArrayList<Long>());
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAny(3L, 4L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, "Message").containsAny(3L, 4L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsAny(Arrays.asList(3L, 4L));
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, "Message").containsAny(Arrays.asList(3L, 4L));
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new LongArrayAssertion(new long[]{1L, 2L}, null).containsNone(3L);
        new LongArrayAssertion(new long[]{1L, 2L}, null).containsNone(3L, 4L);
        new LongArrayAssertion(new long[]{1L, 2L}, null).containsNone(Arrays.asList(3L, 4L));

        try {
            new LongArrayAssertion(null, null).containsNone(1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(null, null).containsNone(new ArrayList<Long>());
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsNone((long[]) null);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsNone();
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsNone((Iterable<Long>) null);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsNone(new ArrayList<Long>());
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsNone(1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsNone(2L, 1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, "Message").containsNone(2L, 1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).containsNone(Arrays.asList(2L, 1L));
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, "Message").containsNone(Arrays.asList(2L, 1L));
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new LongArrayAssertion(new long[0], null).createCollectionAssertion().isEmpty();
        new LongArrayAssertion(new long[]{1L, 2L}, null).createCollectionAssertion().isNotEmpty();

        try {
            new LongArrayAssertion(new long[]{1L, 2L}, null).createCollectionAssertion().isEmpty();
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, "Message").createCollectionAssertion().isEmpty();
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>");
        }
    }

}
