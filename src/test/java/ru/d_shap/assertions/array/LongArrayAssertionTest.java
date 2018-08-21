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

import org.hamcrest.Matchers;
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
        initialize(Raw.longArrayAssertion(), new long[]{});

        try {
            initializeWithRawActual(Raw.longArrayAssertion(), new Object());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.longArrayAssertion(), new Object(), "Message");
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.longArrayAssertion(), new long[]{}).isEmpty();

        try {
            Raw.longArrayAssertion().isEmpty();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).isEmpty();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").isEmpty();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).isEmpty();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").isEmpty();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.longArrayAssertion(), null).isNullOrEmpty();
        initialize(Raw.longArrayAssertion(), new long[]{}).isNullOrEmpty();

        try {
            Raw.longArrayAssertion().isNullOrEmpty();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).isNullOrEmpty();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").isNullOrEmpty();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).isNotEmpty();

        try {
            Raw.longArrayAssertion().isNotEmpty();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).isNotEmpty();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).isNotEmpty();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").isNotEmpty();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").contains(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).contains(3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3L> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").contains(3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3L> but was:<[1L, 2L]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").doesNotContain(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).doesNotContain(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1L> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").doesNotContain(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1L> but was:<[1L, 2L]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsAll(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAll((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsAll((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsAll((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsAll((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsAll();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsAll();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAll(2L, 3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsAll(2L, 3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsAll(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAll((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsAll((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsAll((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsAll((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsAll(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsAll(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsAllInOrder(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAllInOrder((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsAllInOrder((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsAllInOrder((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsAllInOrder((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsAllInOrder();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsAllInOrder();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAllInOrder(2L, 3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAllInOrder(2L, 1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsAllInOrder(2L, 1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAllInOrder(Arrays.asList(2L, 3L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
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
        initialize(Raw.longArrayAssertion(), new long[]{}).containsExactly();

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsExactly(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsExactly((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsExactly((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsExactly((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsExactly((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactly(2L, 3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactly();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 1L, 3L, 2L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}, "Message").containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1L, 1L, 3L, 2L]> but was:<[1L, 2L, 3L, 4L]>");
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
        initialize(Raw.longArrayAssertion(), new long[]{}).containsExactly(new ArrayList<Long>());

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsExactly(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsExactly((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsExactly((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsExactly((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsExactly((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactly(Arrays.asList(2L, 3L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactly(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 1L, 3L, 2L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}, "Message").containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1L, 1L, 3L, 2L]> but was:<[1L, 2L, 3L, 4L]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactlyInOrder(1L, 2L);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(1L, 2L, 3L, 4L);
        initialize(Raw.longArrayAssertion(), new long[]{}).containsExactlyInOrder();

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsExactlyInOrder(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsExactlyInOrder((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsExactlyInOrder((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsExactlyInOrder((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsExactlyInOrder((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactlyInOrder(2L, 1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(1L, 2L, 3L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactlyInOrder();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 3L, 1L, 4L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}, "Message").containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 3L, 1L, 4L]> but was:<[1L, 2L, 3L, 4L]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactlyInOrder(Arrays.asList(1L, 2L));
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L));
        initialize(Raw.longArrayAssertion(), new long[]{}).containsExactlyInOrder(new ArrayList<Long>());

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactlyInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 3L, 1L, 4L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}, "Message").containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 3L, 1L, 4L]> but was:<[1L, 2L, 3L, 4L]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsAny(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAny((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsAny((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsAny((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsAny((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsAny();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsAny();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAny(3L, 4L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3L, 4L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsAny(3L, 4L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3L, 4L]> but was:<[1L, 2L]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsAny(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsAny((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsAny((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsAny((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsAny((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsAny(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsAny(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3L, 4L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3L, 4L]> but was:<[1L, 2L]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsNone(1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsNone((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsNone((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsNone((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsNone((long[]) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsNone();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsNone();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsNone(2L, 1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsNone(2L, 1L);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsNone(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).containsNone((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").containsNone((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsNone((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsNone((Iterable<Long>) null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).containsNone(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").containsNone(new ArrayList<Long>());
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).containsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").containsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).toLength().isEqualTo(2);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).toLength().isGreaterThan(1);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).toLength().isLessThan(3);

        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).toLength().isEqualTo(4);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).toLength().isGreaterThan(3);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).toLength().isLessThan(5);

        try {
            Raw.longArrayAssertion().toLength();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toLength();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toLength();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).toLength()).isEqualTo(0);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").toLength()).isEqualTo(0);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).toLength().isEqualTo(4);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").toLength().isEqualTo(4);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void toLengthMatcherTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).toLength(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).toLength(Matchers.is(Matchers.greaterThan(1)));
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).toLength(Matchers.is(Matchers.lessThan(3)));

        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).toLength(Matchers.equalTo(4));
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).toLength(Matchers.greaterThan(3));
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).toLength(Matchers.lessThan(5));

        try {
            Raw.longArrayAssertion().toLength(Matchers.equalTo(0));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toLength(Matchers.equalTo(0));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toLength(Matchers.equalTo(0));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toLength(null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toLength(null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).toLength(null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").toLength(null);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).toLength(Matchers.equalTo(4));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").toLength(Matchers.equalTo(4));
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\nExpected: <4>\n     but: was <2>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).hasLength(2);
        initialize(Raw.longArrayAssertion(), new long[]{1L, 2L, 3L, 4L}).hasLength(4);

        try {
            Raw.longArrayAssertion().hasLength(0);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).hasLength(0);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").hasLength(0);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).hasLength(4);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").hasLength(4);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").isNull();
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1L, 2L]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<[1L, 2L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), value, "Message").isSameAs(new long[]{1L, 2L});
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<[1L, 2L]> but was:<[1L, 2L]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("LongArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<[1L, 2L]>");
        }
    }

}
