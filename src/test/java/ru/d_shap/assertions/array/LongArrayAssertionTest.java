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
        new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).contains(1L);
        new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).contains(2L);

        try {
            new LongArrayAssertion(null, new FailDescription()).contains(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).contains(3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription("Message")).contains(3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).doesNotContain(3L);

        try {
            new LongArrayAssertion(null, new FailDescription()).doesNotContain(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).doesNotContain(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription("Message")).doesNotContain(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAll(1L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsAll(1L, 3L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsAll(4L, 2L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsAll(Arrays.asList(4L, 2L));

        try {
            new LongArrayAssertion(null, new FailDescription()).containsAll(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(null, new FailDescription()).containsAll(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAll((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAll();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAll((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAll(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAll(2L, 3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription("Message")).containsAll(2L, 3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription("Message")).containsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAllInOrder(1L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsAllInOrder(1L, 3L, 4L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsAllInOrder(Arrays.asList(1L, 3L, 4L));

        try {
            new LongArrayAssertion(null, new FailDescription()).containsAllInOrder(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAllInOrder((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAllInOrder();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAllInOrder(2L, 3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAllInOrder(2L, 1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription("Message")).containsAllInOrder(2L, 1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription("Message")).containsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsExactly(1L, 2L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsExactly(1L, 2L, 3L, 4);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsExactly(1L, 3L, 2L, 4L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsExactly(Arrays.asList(1L, 3L, 2L, 4L));
        new LongArrayAssertion(new long[0], new FailDescription()).containsExactly();
        new LongArrayAssertion(new long[0], new FailDescription()).containsExactly(new ArrayList<Long>());

        try {
            new LongArrayAssertion(null, new FailDescription()).containsExactly(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(null, new FailDescription()).containsExactly(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsExactly((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsExactly((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsExactly(2L, 3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsExactly();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsExactly(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription("Message")).containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription("Message")).containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsExactlyInOrder(1L, 2L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsExactlyInOrder(1, 2L, 3L, 4);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L));
        new LongArrayAssertion(new long[0], new FailDescription()).containsExactlyInOrder();
        new LongArrayAssertion(new long[0], new FailDescription()).containsExactlyInOrder(new ArrayList<Long>());

        try {
            new LongArrayAssertion(null, new FailDescription()).containsExactlyInOrder(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsExactlyInOrder((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsExactlyInOrder(2L, 1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsExactlyInOrder(1L, 2L, 3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsExactlyInOrder();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription("Message")).containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription("Message")).containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAny(2L, 3L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsAny(2L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsAny(4L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsAny(5L, 3L);
        new LongArrayAssertion(new long[]{1L, 2L, 3L, 4L}, new FailDescription()).containsAny(Arrays.asList(5L, 3L));

        try {
            new LongArrayAssertion(null, new FailDescription()).containsAny(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(null, new FailDescription()).containsAny(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAny((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAny();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAny((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAny(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAny(3L, 4L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription("Message")).containsAny(3L, 4L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription("Message")).containsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsNone(3L);
        new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsNone(3L, 4L);
        new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsNone(Arrays.asList(3L, 4L));

        try {
            new LongArrayAssertion(null, new FailDescription()).containsNone(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(null, new FailDescription()).containsNone(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsNone((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsNone();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsNone((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsNone(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsNone(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsNone(2L, 1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription("Message")).containsNone(2L, 1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).containsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription("Message")).containsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new LongArrayAssertion(null, new FailDescription()).isNull();

        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription()).isNull();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(new long[]{1L, 2L}, new FailDescription("Message")).isNull();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[1, 2]>.");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        long[] value = new long[]{1L, 2L};
        new LongArrayAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new LongArrayAssertion(value, new FailDescription()).isSameAs(new long[]{1L, 2L});
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(value, new FailDescription("Message")).isSameAs(new long[]{1L, 2L});
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        long[] value = new long[]{1L, 2L};
        new LongArrayAssertion(value, new FailDescription()).isNotSameAs(new long[]{1L, 2L});
        new LongArrayAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new LongArrayAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1, 2]>.");
        }
        try {
            new LongArrayAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[1, 2]>.");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new LongArrayAssertion(null, new FailDescription()).asString(null, true)).isNull();
        Assertions.assertThat(new LongArrayAssertion(null, new FailDescription()).asString(new StringBuilder("test"), true)).isEqualTo("test");
        Assertions.assertThat(new LongArrayAssertion(null, new FailDescription()).asString(Arrays.asList("val1", "val2", "val3"), true)).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(new LongArrayAssertion(null, new FailDescription()).asString(new long[]{1L, 2L}, true)).isEqualTo("[1, 2]");

        Assertions.assertThat(new LongArrayAssertion(null, new FailDescription()).asString(null, false)).isNull();
        Assertions.assertThat(new LongArrayAssertion(null, new FailDescription()).asString(new StringBuilder("test"), false)).isEqualTo("test");
        Assertions.assertThat(new LongArrayAssertion(null, new FailDescription()).asString(Arrays.asList("val1", "val2", "val3"), false)).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(new LongArrayAssertion(null, new FailDescription()).asString(new long[]{1L, 2L}, false)).isEqualTo("[1, 2]");
    }

}
