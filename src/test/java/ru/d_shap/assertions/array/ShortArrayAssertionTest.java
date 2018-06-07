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
        initialize(Raw.shortArrayAssertion(), new short[0]);

        try {
            initializeWithRawActual(Raw.shortArrayAssertion(), new Object());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.shortArrayAssertion(), new Object(), "Message");
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
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
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").contains(3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3> but was:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").doesNotContain(1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1> but was:<[1, 2]>");
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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAll((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAll();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll((short) 2, (short) 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAll((short) 2, (short) 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAll((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAll(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll(2, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAll(2, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAll((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAll(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAllInOrder((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAllInOrder();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder((short) 2, (short) 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAllInOrder((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAllInOrder(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder(2, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder(2, 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAllInOrder(2, 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
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
        initialize(Raw.shortArrayAssertion(), new short[0]).containsExactly();

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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsExactly((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly((short) 2, (short) 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
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
        initialize(Raw.shortArrayAssertion(), new short[0]).containsExactly(new int[0]);

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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsExactly((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly(2, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly(1, 1, 3, 2);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
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
        initialize(Raw.shortArrayAssertion(), new short[0]).containsExactly(new ArrayList<Short>());

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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsExactly((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayShortTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder((short) 1, (short) 2);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
        initialize(Raw.shortArrayAssertion(), new short[0]).containsExactlyInOrder();

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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsExactlyInOrder((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder((short) 2, (short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder((short) 1, (short) 2, (short) 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayIntTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder(1, 2);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.shortArrayAssertion(), new short[0]).containsExactlyInOrder(new int[0]);

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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder(2, 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2));
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortArrayAssertion(), new short[0]).containsExactlyInOrder(new ArrayList<Short>());

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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAny((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAny();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny((short) 3, (short) 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAny((short) 3, (short) 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAny((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAny(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny(3, 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAny(3, 4);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAny((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAny(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsNone((short[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsNone();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone((short) 2, (short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsNone((short) 2, (short) 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayIntTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone(3, 7);
        initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone(3, 4, 5);

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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsNone((int[]) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsNone(new int[0]);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone(2, 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsNone(2, 1);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
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
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsNone((Iterable<Short>) null);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsNone(new ArrayList<Short>());
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).containsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").containsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").isNull();
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<[1, 2]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), value, "Message").isSameAs(new short[]{1, 2});
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<[1, 2]> but was:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ShortArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<[1, 2]>");
        }
    }

}
