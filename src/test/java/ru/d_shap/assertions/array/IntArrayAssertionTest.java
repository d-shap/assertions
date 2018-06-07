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
    public void actualValueValidatorTest() {
        initialize(Raw.intArrayAssertion(), new int[0]);

        try {
            initializeWithRawActual(Raw.intArrayAssertion(), new Object());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.intArrayAssertion(), new Object(), "Message");
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).contains(1);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).contains(2);

        try {
            Raw.intArrayAssertion().contains(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).contains(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").contains(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).contains(3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").contains(3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).doesNotContain(3);

        try {
            Raw.intArrayAssertion().doesNotContain(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).doesNotContain(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").doesNotContain(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).doesNotContain(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").doesNotContain(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll(1, 2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAll(1, 3);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAll(4, 2);

        try {
            Raw.intArrayAssertion().containsAll(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAll(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAll(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAll((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAll((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAll((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAll();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll(2, 3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAll(2, 3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll(Arrays.asList(1, 2));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAll(Arrays.asList(1, 3));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAll(Arrays.asList(4, 2));

        try {
            Raw.intArrayAssertion().containsAll(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAll(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAll(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAll((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAll((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAll((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAll(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAll(Arrays.asList(2, 3));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAll(Arrays.asList(2, 3));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(1, 2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAllInOrder(1, 3, 4);

        try {
            Raw.intArrayAssertion().containsAllInOrder(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAllInOrder(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAllInOrder(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAllInOrder((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAllInOrder((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAllInOrder((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAllInOrder();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(2, 3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(2, 1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAllInOrder(2, 1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(Arrays.asList(1, 2));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAllInOrder(Arrays.asList(1, 3, 4));

        try {
            Raw.intArrayAssertion().containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(Arrays.asList(2, 3));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly(1, 2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(1, 2, 3, 4);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(1, 3, 2, 4);
        initialize(Raw.intArrayAssertion(), new int[0]).containsExactly();

        try {
            Raw.intArrayAssertion().containsExactly(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactly(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactly(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactly((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactly((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsExactly((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly(2, 3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(1, 1, 3, 2);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}, "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly(Arrays.asList(1, 2));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(Arrays.asList(1, 2, 3, 4));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(Arrays.asList(1, 3, 2, 4));
        initialize(Raw.intArrayAssertion(), new int[0]).containsExactly(new ArrayList<Integer>());

        try {
            Raw.intArrayAssertion().containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly(Arrays.asList(2, 3));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}, "Message").containsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder(1, 2);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.intArrayAssertion(), new int[0]).containsExactlyInOrder();

        try {
            Raw.intArrayAssertion().containsExactlyInOrder(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactlyInOrder(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactlyInOrder(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactlyInOrder((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder(2, 1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder(Arrays.asList(1, 2));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList(1, 2, 3, 4));
        initialize(Raw.intArrayAssertion(), new int[0]).containsExactlyInOrder(new ArrayList<Integer>());

        try {
            Raw.intArrayAssertion().containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList(1, 2, 3));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny(2, 3);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(2, 4);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(4, 1);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(5, 3);

        try {
            Raw.intArrayAssertion().containsAny(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAny(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAny(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAny((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAny((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAny((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAny();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny(3, 4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAny(3, 4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny(Arrays.asList(2, 3));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(Arrays.asList(2, 4));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(Arrays.asList(4, 1));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2, 3, 4}).containsAny(Arrays.asList(5, 3));

        try {
            Raw.intArrayAssertion().containsAny(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAny(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAny(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsAny((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsAny((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAny((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAny(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsAny(Arrays.asList(3, 4));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsAny(Arrays.asList(3, 4));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(3, 7);
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(3, 4, 5);

        try {
            Raw.intArrayAssertion().containsNone(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsNone(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsNone(1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsNone((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsNone((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsNone((int[]) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsNone();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(2, 1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsNone(2, 1);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(Arrays.asList(3, 7));
        initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(Arrays.asList(3, 4, 5));

        try {
            Raw.intArrayAssertion().containsNone(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsNone(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsNone(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).containsNone((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").containsNone((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsNone((Iterable<Integer>) null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsNone(new ArrayList<Integer>());
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).containsNone(Arrays.asList(2, 1));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").containsNone(Arrays.asList(2, 1));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").isNull();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<[1, 2]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), value, "Message").isSameAs(new int[]{1, 2});
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<[1, 2]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        int[] value = new int[]{1, 2};
        initialize(Raw.intArrayAssertion(), value).isNotSameAs(new int[]{1, 2});

        try {
            initialize(Raw.intArrayAssertion(), value).isNotSameAs(value);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.intArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<[1, 2]>");
        }
    }

}
