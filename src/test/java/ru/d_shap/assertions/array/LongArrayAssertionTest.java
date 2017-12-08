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
 * Tests for {@link LongArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongArrayAssertionTest extends AssertionTest {

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
    public void actualValueValidatorTest() {
        initialize(Raw.longArrayAssertion(), new long[0]);

        try {
            initializeWithRawActual(Raw.longArrayAssertion(), new Object());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.longArrayAssertion(), new Object(), "Message");
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).contains(1L);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).contains(2L);

        try {
            Raw.longArrayAssertion().contains(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).contains(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).contains(3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").contains(3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).doesNotContain(3L);

        try {
            Raw.longArrayAssertion().doesNotContain(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).doesNotContain(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).doesNotContain(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").doesNotContain(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAll(1L, 2L);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsAll(1L, 3L);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsAll(4L, 2L);

        try {
            Raw.longArrayAssertion().containsAll(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAll(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAll((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAll((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAll();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAll(2L, 3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsAll(2L, 3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAll(Arrays.asList(1L, 2L));
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsAll(Arrays.asList(1L, 3L));
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsAll(Arrays.asList(4L, 2L));

        try {
            Raw.longArrayAssertion().containsAll(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAll(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAll((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAll((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAll(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAllInOrder(1L, 2L);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsAllInOrder(1L, 3L, 4L);

        try {
            Raw.longArrayAssertion().containsAllInOrder(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAllInOrder(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAllInOrder((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAllInOrder((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAllInOrder();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAllInOrder(2L, 3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAllInOrder(2L, 1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsAllInOrder(2L, 1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAllInOrder(Arrays.asList(1L, 2L));
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsAllInOrder(Arrays.asList(1L, 3L, 4L));

        try {
            Raw.longArrayAssertion().containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAllInOrder(Arrays.asList(2L, 3L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactly(1L, 2L);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactly(1L, 2L, 3L, 4L);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactly(1L, 3L, 2L, 4L);
        initialize(Raw.longArrayAssertion(), new long[0]).containsExactly();

        try {
            Raw.longArrayAssertion().containsExactly(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsExactly(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsExactly((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactly((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactly(2L, 3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactly();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}, "Message").containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactly(Arrays.asList(1L, 2L));
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactly(Arrays.asList(1L, 2L, 3L, 4L));
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactly(Arrays.asList(1L, 3L, 2L, 4L));
        initialize(Raw.longArrayAssertion(), new long[0]).containsExactly(new ArrayList<Long>());

        try {
            Raw.longArrayAssertion().containsExactly(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsExactly(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsExactly((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactly((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactly(Arrays.asList(2L, 3L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactly(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}, "Message").containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactlyInOrder(1L, 2L);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(1L, 2L, 3L, 4L);
        initialize(Raw.longArrayAssertion(), new long[0]).containsExactlyInOrder();

        try {
            Raw.longArrayAssertion().containsExactlyInOrder(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsExactlyInOrder(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsExactlyInOrder((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactlyInOrder((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactlyInOrder(2L, 1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(1L, 2L, 3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactlyInOrder();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}, "Message").containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactlyInOrder(Arrays.asList(1L, 2L));
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L));
        initialize(Raw.longArrayAssertion(), new long[0]).containsExactlyInOrder(new ArrayList<Long>());

        try {
            Raw.longArrayAssertion().containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactlyInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}, "Message").containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAny(2L, 3L);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsAny(2L, 4L);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsAny(4L, 1L);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsAny(5L, 3L);

        try {
            Raw.longArrayAssertion().containsAny(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAny(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAny((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAny((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAny();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAny(3L, 4L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsAny(3L, 4L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAny(Arrays.asList(2L, 3L));
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsAny(Arrays.asList(2L, 4L));
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsAny(Arrays.asList(4L, 1L));
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsAny(Arrays.asList(5L, 3L));

        try {
            Raw.longArrayAssertion().containsAny(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAny(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAny((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAny((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAny(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsNone(3L, 7L);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsNone(3L, 4L, 5L);

        try {
            Raw.longArrayAssertion().containsNone(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsNone(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsNone((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsNone((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsNone();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsNone(2L, 1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsNone(2L, 1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsNone(Arrays.asList(3L, 7L));
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsNone(Arrays.asList(3L, 4L, 5L));

        try {
            Raw.longArrayAssertion().containsNone(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsNone(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsNone((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsNone((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsNone(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.longArrayAssertion(), null).isNull();

        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).isNull();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").isNull();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        long[] value = new long[]{1L, 2L};
        initialize(Raw.longArrayAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.longArrayAssertion(), value).isSameAs(new long[]{1L, 2L});
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), value, "Message").isSameAs(new long[]{1L, 2L});
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        long[] value = new long[]{1L, 2L};
        initialize(Raw.longArrayAssertion(), value).isNotSameAs(new long[]{1L, 2L});

        try {
            initialize(Raw.longArrayAssertion(), value).isNotSameAs(value);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1, 2]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.longArrayAssertion(), null).asString(null));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.longArrayAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.longArrayAssertion(), null).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(initialize(Raw.longArrayAssertion(), null).asString(new long[]{1L, 2L})).isEqualTo("[1, 2]");
    }

}
