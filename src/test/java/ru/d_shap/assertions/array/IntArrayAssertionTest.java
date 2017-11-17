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
 * Tests for {@link IntArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayAssertionTest extends AssertionTest {

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
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).contains(1);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).contains(2);

        try {
            initialize(Raw.intArrayAssertion(), null).contains(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).contains(3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").contains(3);
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
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).doesNotContain(3);

        try {
            initialize(Raw.intArrayAssertion(), null).doesNotContain(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).doesNotContain(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").doesNotContain(1);
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
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll(1);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAll(1, 3);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAll(4, 2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAll(Arrays.asList(4, 2));

        try {
            initialize(Raw.intArrayAssertion(), null).containsAll(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAll(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAll((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAll((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll(2, 3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAll(2, 3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll(Arrays.asList(2, 3));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAll(Arrays.asList(2, 3));
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
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(1);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAllInOrder(1, 3, 4);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAllInOrder(Arrays.asList(1, 3, 4));

        try {
            initialize(Raw.intArrayAssertion(), null).containsAllInOrder(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAllInOrder((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(2, 3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(2, 1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAllInOrder(2, 1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAllInOrder(Arrays.asList(2, 1));
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
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly(1, 2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(1, 2, 3, 4);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(1, 3, 2, 4);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(Arrays.asList(1, 3, 2, 4));
        initialize(Raw.intArrayAssertion(), new int[0]).containsExactly();
        initialize(Raw.intArrayAssertion(), new int[0]).containsExactly(new ArrayList<Integer>());

        try {
            initialize(Raw.intArrayAssertion(), null).containsExactly(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactly((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly(2, 3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(1, 1, 3, 2);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}, "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}, "Message").containsExactly(Arrays.asList(1, 1, 3, 2));
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
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder(1, 2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList(1, 2, 3, 4));
        initialize(Raw.intArrayAssertion(), new int[0]).containsExactlyInOrder();
        initialize(Raw.intArrayAssertion(), new int[0]).containsExactlyInOrder(new ArrayList<Integer>());

        try {
            initialize(Raw.intArrayAssertion(), null).containsExactlyInOrder(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactlyInOrder((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder(2, 1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
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
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny(2, 3);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(4);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(5, 3);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(Arrays.asList(5, 3));

        try {
            initialize(Raw.intArrayAssertion(), null).containsAny(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAny(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAny((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAny((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny(3, 4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAny(3, 4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny(Arrays.asList(3, 4));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAny(Arrays.asList(3, 4));
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
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(3);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(3, 4);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(Arrays.asList(3, 4));

        try {
            initialize(Raw.intArrayAssertion(), null).containsNone(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsNone(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsNone((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsNone((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(2, 1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsNone(2, 1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(Arrays.asList(2, 1));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsNone(Arrays.asList(2, 1));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.intArrayAssertion(), null).isNull();

        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).isNull();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").isNull();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[1, 2]>.");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        int[] value = new int[]{1, 2};
        initialize(Raw.intArrayAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.intArrayAssertion(), value).isSameAs(new int[]{1, 2});
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), value, "Message").isSameAs(new int[]{1, 2});
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), value).isSameAs("test");
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        int[] value = new int[]{1, 2};
        initialize(Raw.intArrayAssertion(), value).isNotSameAs(new int[]{1, 2});
        initialize(Raw.intArrayAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.intArrayAssertion(), value).isNotSameAs(value);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1, 2]>.");
        }
        try {
            initialize(Raw.intArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[1, 2]>.");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.intArrayAssertion(), null).asString(null));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.intArrayAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.intArrayAssertion(), null).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(initialize(Raw.intArrayAssertion(), null).asString(new int[]{1, 2})).isEqualTo("[1, 2]");
    }

}
