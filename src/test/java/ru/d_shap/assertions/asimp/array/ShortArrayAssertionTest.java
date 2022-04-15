///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions library provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions library.
//
// Assertions library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.asimp.array;

import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ShortArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortArrayAssertionTest extends AssertionTest {

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
    public void actualValueValidatorTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{});

        try {
            initializeWithRawActual(Raw.shortArrayAssertion(), new Object());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[S> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.shortArrayAssertion(), new Object(), "Message");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[S> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{}).isEmpty();

        try {
            Raw.shortArrayAssertion().isEmpty();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).isEmpty();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").isEmpty();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).isEmpty();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").isEmpty();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.shortArrayAssertion(), null).isNullOrEmpty();
        initialize(Raw.shortArrayAssertion(), new short[]{}).isNullOrEmpty();

        try {
            Raw.shortArrayAssertion().isNullOrEmpty();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).isNullOrEmpty();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").isNullOrEmpty();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).isNotEmpty();

        try {
            Raw.shortArrayAssertion().isNotEmpty();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).isNotEmpty();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).isNotEmpty();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").isNotEmpty();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).contains(1);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).contains(2);

        try {
            Raw.shortArrayAssertion().contains(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).contains(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").contains(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).contains(3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3s> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").contains(3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3s> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).doesNotContain(3);

        try {
            Raw.shortArrayAssertion().doesNotContain(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).doesNotContain(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").doesNotContain(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).doesNotContain(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1s> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").doesNotContain(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1s> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayShortTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll((short) 1, (short) 2);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAll((short) 1, (short) 3);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAll((short) 4, (short) 2);

        try {
            Raw.shortArrayAssertion().containsAll((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAll((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAll((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAll((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAll((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAll((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAll((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAll();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAll();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll((short) 2, (short) 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAll((short) 2, (short) 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayIntTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll(1, 2);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAll(1, 3);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAll(4, 2);

        try {
            Raw.shortArrayAssertion().containsAll(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAll(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAll(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAll((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAll((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAll((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAll((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAll(new int[]{});
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAll(new int[]{});
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll(2, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAll(2, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll(100000, 100001);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[100000, 100001]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAll(100000, 100001);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[100000, 100001]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll(Arrays.asList((short) 1, (short) 2));
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAll(Arrays.asList((short) 1, (short) 3));
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAll(Arrays.asList((short) 4, (short) 2));

        try {
            Raw.shortArrayAssertion().containsAll(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAll(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAll(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAll((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAll((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAll((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAll((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAll(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAll(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayShortTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder((short) 1, (short) 2);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAllInOrder((short) 1, (short) 3, (short) 4);

        try {
            Raw.shortArrayAssertion().containsAllInOrder((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAllInOrder((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAllInOrder((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAllInOrder((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAllInOrder((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAllInOrder((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAllInOrder((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAllInOrder();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAllInOrder();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder((short) 2, (short) 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayIntTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder(1, 2);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAllInOrder(1, 3, 4);

        try {
            Raw.shortArrayAssertion().containsAllInOrder(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAllInOrder(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAllInOrder(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAllInOrder((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAllInOrder((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAllInOrder((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAllInOrder((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAllInOrder(new int[]{});
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAllInOrder(new int[]{});
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder(2, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder(2, 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAllInOrder(2, 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder(100000, 100001);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[100000, 100001]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAllInOrder(100000, 100001);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[100000, 100001]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder(Arrays.asList((short) 1, (short) 2));
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAllInOrder(Arrays.asList((short) 1, (short) 3, (short) 4));

        try {
            Raw.shortArrayAssertion().containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayShortTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly((short) 1, (short) 2);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly((short) 1, (short) 2, (short) 3, (short) 4);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly((short) 1, (short) 3, (short) 2, (short) 4);
        initialize(Raw.shortArrayAssertion(), new short[]{}).containsExactly();

        try {
            Raw.shortArrayAssertion().containsExactly((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsExactly((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsExactly((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsExactly((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsExactly((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsExactly((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsExactly((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly((short) 2, (short) 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayIntTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly(1, 2);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly(1, 2, 3, 4);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly(1, 3, 2, 4);
        initialize(Raw.shortArrayAssertion(), new short[]{}).containsExactly(new int[]{});

        try {
            Raw.shortArrayAssertion().containsExactly(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsExactly(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsExactly(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsExactly((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsExactly((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsExactly((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsExactly((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly(2, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly(new int[]{});
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly(1, 1, 3, 2);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly(100000, 100001);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[100000, 100001]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").containsExactly(100000, 100001);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[100000, 100001]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly(Arrays.asList((short) 1, (short) 2));
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly(Arrays.asList((short) 1, (short) 3, (short) 2, (short) 4));
        initialize(Raw.shortArrayAssertion(), new short[]{}).containsExactly(new ArrayList<Short>());

        try {
            Raw.shortArrayAssertion().containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsExactly((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsExactly((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsExactly((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsExactly((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayShortTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder((short) 1, (short) 2);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
        initialize(Raw.shortArrayAssertion(), new short[]{}).containsExactlyInOrder();

        try {
            Raw.shortArrayAssertion().containsExactlyInOrder((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsExactlyInOrder((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsExactlyInOrder((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsExactlyInOrder((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsExactlyInOrder((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsExactlyInOrder((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsExactlyInOrder((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder((short) 2, (short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder((short) 1, (short) 2, (short) 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayIntTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder(1, 2);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.shortArrayAssertion(), new short[]{}).containsExactlyInOrder(new int[]{});

        try {
            Raw.shortArrayAssertion().containsExactlyInOrder(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsExactlyInOrder(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsExactlyInOrder(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsExactlyInOrder((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsExactlyInOrder((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder(2, 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder(new int[]{});
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(100000, 100001);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[100000, 100001]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(100000, 100001);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[100000, 100001]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2));
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortArrayAssertion(), new short[]{}).containsExactlyInOrder(new ArrayList<Short>());

        try {
            Raw.shortArrayAssertion().containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayShortTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny((short) 2, (short) 3);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAny((short) 2, (short) 3);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAny((short) 4, (short) 1);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAny((short) 5, (short) 3);

        try {
            Raw.shortArrayAssertion().containsAny((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAny((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAny((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAny((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAny((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAny((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAny((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAny();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAny();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny((short) 3, (short) 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAny((short) 3, (short) 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayIntTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny(2, 3);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAny(2, 3);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAny(4, 1);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAny(5, 3);

        try {
            Raw.shortArrayAssertion().containsAny(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAny(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAny(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAny((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAny((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAny((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAny((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAny(new int[]{});
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAny(new int[]{});
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny(3, 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAny(3, 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny(100000, 100001);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[100000, 100001]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAny(100000, 100001);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[100000, 100001]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny(Arrays.asList((short) 2, (short) 3));
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAny(Arrays.asList((short) 2, (short) 3));
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAny(Arrays.asList((short) 4, (short) 1));
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsAny(Arrays.asList((short) 5, (short) 3));

        try {
            Raw.shortArrayAssertion().containsAny(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAny(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAny(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsAny((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsAny((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAny((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAny((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsAny(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsAny(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayShortTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone((short) 3, (short) 7);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone((short) 3, (short) 4, (short) 5);

        try {
            Raw.shortArrayAssertion().containsNone((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsNone((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsNone((short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsNone((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsNone((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsNone((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsNone((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsNone();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsNone();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone((short) 2, (short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsNone((short) 2, (short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayIntTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone(3, 7);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone(3, 4, 5);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone(100000, 100001);

        try {
            Raw.shortArrayAssertion().containsNone(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsNone(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsNone(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsNone((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsNone((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsNone((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsNone((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsNone(new int[]{});
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsNone(new int[]{});
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone(2, 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsNone(2, 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone(Arrays.asList((short) 3, (short) 7));
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone(Arrays.asList((short) 3, (short) 4, (short) 5));

        try {
            Raw.shortArrayAssertion().containsNone(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsNone(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsNone(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).containsNone((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").containsNone((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsNone((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsNone((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).containsNone(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").containsNone(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toLength().isEqualTo(2);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toLength().isGreaterThan(1);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toLength().isLessThan(3);

        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).toLength().isEqualTo(4);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).toLength().isGreaterThan(3);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).toLength().isLessThan(5);

        try {
            Raw.shortArrayAssertion().toLength();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toLength();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toLength();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toLength()).isEqualTo(0);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toLength()).isEqualTo(0);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toLength().isEqualTo(4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toLength().isEqualTo(4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void toLengthMatcherTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toLength(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toLength(Matchers.is(Matchers.greaterThan(1)));
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toLength(Matchers.is(Matchers.lessThan(3)));

        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).toLength(Matchers.equalTo(4));
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).toLength(Matchers.greaterThan(3));
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).toLength(Matchers.lessThan(5));

        try {
            Raw.shortArrayAssertion().toLength(Matchers.equalTo(0));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toLength(Matchers.equalTo(0));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toLength(Matchers.equalTo(0));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toLength(null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toLength(null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).toLength(null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").toLength(null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toLength(Matchers.equalTo(4));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toLength(Matchers.equalTo(4));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\nExpected: <4>\n     but: was <2>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasLength(2);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).hasLength(4);

        try {
            Raw.shortArrayAssertion().hasLength(0);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).hasLength(0);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").hasLength(0);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasLength(4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").hasLength(4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString().isEqualTo("00010002");
        initialize(Raw.shortArrayAssertion(), new short[]{15, -3, 7}).toHexString().isEqualTo("000ffffd0007");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString().isEqualTo("006300050000ffeb");

        try {
            Raw.shortArrayAssertion().toHexString();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toHexString();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toHexString();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString()).isEqualTo("00000000");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString()).isEqualTo("00000000");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString().isEqualTo("00000000");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00010002>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString().isEqualTo("00000000");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00010002>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void toHexStringPartTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(0, 2).isEqualTo("00010002");
        initialize(Raw.shortArrayAssertion(), new short[]{15, -3, 7}).toHexString(0, 3).isEqualTo("000ffffd0007");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(0, 0).isEqualTo("");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(0, 1).isEqualTo("0063");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(0, 2).isEqualTo("00630005");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(0, 3).isEqualTo("006300050000");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(0, 4).isEqualTo("006300050000ffeb");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(1, 1).isEqualTo("");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(1, 2).isEqualTo("0005");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(1, 3).isEqualTo("00050000");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(1, 4).isEqualTo("00050000ffeb");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(2, 2).isEqualTo("");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(2, 3).isEqualTo("0000");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(2, 4).isEqualTo("0000ffeb");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(3, 3).isEqualTo("");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(3, 4).isEqualTo("ffeb");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(4, 4).isEqualTo("");

        try {
            Raw.shortArrayAssertion().toHexString(0, 0);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toHexString(0, 0);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toHexString(0, 0);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toHexString(-1, 0);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toHexString(-1, 0);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(-1, 0);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString(-1, 0);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(-1, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString(-1, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(0, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString(0, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(3, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString(3, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(1, 0);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString(1, 0);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            clearActual(initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(0, 0)).isEqualTo("00000000");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString(0, 0)).isEqualTo("00000000");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).toHexString(1, 3).isEqualTo("00010002");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00010002> but was:<00020003>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").toHexString(1, 3).isEqualTo("00010002");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00010002> but was:<00020003>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(Matchers.is(Matchers.equalTo("00010002")));
        initialize(Raw.shortArrayAssertion(), new short[]{15, -3, 7}).toHexString(Matchers.is(Matchers.equalTo("000ffffd0007")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(Matchers.is(Matchers.equalTo("006300050000ffeb")));

        try {
            Raw.shortArrayAssertion().toHexString(Matchers.equalTo(""));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toHexString(Matchers.equalTo(""));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toHexString(Matchers.equalTo(""));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toHexString(null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toHexString(null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString(null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(Matchers.equalTo("00000000"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"00000000\"\n     but: was \"00010002\"");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString(Matchers.equalTo("00000000"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"00000000\"\n     but: was \"00010002\"");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void toHexStringPartMatcherTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(0, 2, Matchers.is(Matchers.equalTo("00010002")));
        initialize(Raw.shortArrayAssertion(), new short[]{15, -3, 7}).toHexString(0, 3, Matchers.is(Matchers.equalTo("000ffffd0007")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(0, 1, Matchers.is(Matchers.equalTo("0063")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(0, 2, Matchers.is(Matchers.equalTo("00630005")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(0, 3, Matchers.is(Matchers.equalTo("006300050000")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(0, 4, Matchers.is(Matchers.equalTo("006300050000ffeb")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(1, 2, Matchers.is(Matchers.equalTo("0005")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(1, 3, Matchers.is(Matchers.equalTo("00050000")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(1, 4, Matchers.is(Matchers.equalTo("00050000ffeb")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(2, 3, Matchers.is(Matchers.equalTo("0000")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(2, 4, Matchers.is(Matchers.equalTo("0000ffeb")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(3, 3, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(3, 4, Matchers.is(Matchers.equalTo("ffeb")));
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).toHexString(4, 4, Matchers.is(Matchers.equalTo("")));

        try {
            Raw.shortArrayAssertion().toHexString(0, 0, Matchers.equalTo("00000000"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toHexString(0, 0, Matchers.equalTo("00000000"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toHexString(0, 0, Matchers.equalTo("00000000"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toHexString(-1, 0, Matchers.equalTo("00000000"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toHexString(-1, 0, Matchers.equalTo("00000000"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(-1, 0, Matchers.equalTo("00000000"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString(-1, 0, Matchers.equalTo("00000000"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(-1, 3, Matchers.equalTo("00000000"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString(-1, 3, Matchers.equalTo("00000000"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(0, 3, Matchers.equalTo("00000000"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString(0, 3, Matchers.equalTo("00000000"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(3, 3, Matchers.equalTo("00"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString(3, 3, Matchers.equalTo("00"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(1, 0, Matchers.equalTo("00"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString(1, 0, Matchers.equalTo("00"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(0, 3, null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString(0, 3, null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toHexString(0, 2, null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toHexString(0, 2, null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).toHexString(1, 3, Matchers.equalTo("00010002"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\nExpected: \"00010002\"\n     but: was \"00020003\"");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").toHexString(1, 3, Matchers.equalTo("00010002"));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\nExpected: \"00010002\"\n     but: was \"00020003\"");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasHexString("00010002");
        initialize(Raw.shortArrayAssertion(), new short[]{15, -3, 7}).hasHexString("000ffffd0007");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString("006300050000ffeb");

        try {
            Raw.shortArrayAssertion().hasHexString("");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).hasHexString("");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").hasHexString("");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).hasHexString(null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").hasHexString(null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasHexString(null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").hasHexString(null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasHexString("00000000");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00010002>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").hasHexString("00000000");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00010002>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void hasHexStringPartTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasHexString(0, 2, "00010002");
        initialize(Raw.shortArrayAssertion(), new short[]{15, -3, 7}).hasHexString(0, 3, "000ffffd0007");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString(0, 0, "");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString(0, 1, "0063");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString(0, 2, "00630005");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString(0, 3, "006300050000");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString(0, 4, "006300050000ffeb");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString(1, 1, "");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString(1, 2, "0005");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString(1, 3, "00050000");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString(1, 4, "00050000ffeb");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString(2, 2, "");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString(2, 3, "0000");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString(2, 4, "0000ffeb");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString(3, 3, "");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString(3, 4, "ffeb");
        initialize(Raw.shortArrayAssertion(), new short[]{99, 5, 0, -21}).hasHexString(4, 4, "");

        try {
            Raw.shortArrayAssertion().hasHexString(0, 0, "");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).hasHexString(0, 0, "");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").hasHexString(0, 0, "");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).hasHexString(-1, 0, "");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").hasHexString(-1, 0, "");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasHexString(-1, 0, "");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").hasHexString(-1, 0, "");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasHexString(-1, 3, "");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").hasHexString(-1, 3, "");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasHexString(0, 3, "");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").hasHexString(0, 3, "");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasHexString(3, 3, "");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").hasHexString(3, 3, "");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasHexString(1, 0, "");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").hasHexString(1, 0, "");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasHexString(0, 3, null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").hasHexString(0, 3, null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasHexString(0, 2, null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").hasHexString(0, 2, null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).hasHexString(1, 3, "00010002");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00010002> but was:<00020003>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").hasHexString(1, 3, "00010002");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00010002> but was:<00020003>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.shortArrayAssertion(), null).isNull();

        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).isNull();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").isNull();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        short[] value = new short[]{1, 2};
        initialize(Raw.shortArrayAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.shortArrayAssertion(), value).isSameAs(new short[]{1, 2});
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[1s, 2s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), value, "Message").isSameAs(new short[]{1, 2});
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<[1s, 2s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        short[] value = new short[]{1, 2};
        initialize(Raw.shortArrayAssertion(), value).isNotSameAs(new short[]{1, 2});

        try {
            initialize(Raw.shortArrayAssertion(), value).isNotSameAs(value);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<[1s, 2s]>");
        }
    }

}
