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
 * Tests for {@link BooleanArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class BooleanArrayAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public BooleanArrayAssertionTest() {
        super();
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[0]);

        try {
            initializeWithRawActual(Raw.booleanArrayAssertion(), new Object());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.booleanArrayAssertion(), new Object(), "Message");
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should match the assertion.");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}).contains(true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}).contains(false);

        try {
            Raw.booleanArrayAssertion().contains(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).contains(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").contains(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).contains(false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value. Expected:<false> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").contains(false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain the expected value. Expected:<false> but was:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).doesNotContain(false);

        try {
            Raw.booleanArrayAssertion().doesNotContain(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).doesNotContain(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").doesNotContain(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).doesNotContain(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value. Expected:<true> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").doesNotContain(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not contain the expected value. Expected:<true> but was:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAll(true, true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAll(true, false);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAll(false, true);

        try {
            Raw.booleanArrayAssertion().containsAll(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAll(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAll(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAll((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAll((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAll((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAll((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAll();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAll();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAll(false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAll(false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAll(Arrays.asList(true, true));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAll(Arrays.asList(true, false));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAll(Arrays.asList(false, true));

        try {
            Raw.booleanArrayAssertion().containsAll(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAll(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAll(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAll((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAll((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAll((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAll((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAll(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAll(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAll(Arrays.asList(false, false));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAll(Arrays.asList(false, false));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAllInOrder(true, true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAllInOrder(true, false);

        try {
            Raw.booleanArrayAssertion().containsAllInOrder(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAllInOrder(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAllInOrder(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAllInOrder((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAllInOrder((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAllInOrder((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAllInOrder((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAllInOrder();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAllInOrder();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAllInOrder(false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}).containsAllInOrder(false, true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[false, true]> but was:<[true, false]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}, "Message").containsAllInOrder(false, true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values in the specified order. Expected:<[false, true]> but was:<[true, false]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAllInOrder(Arrays.asList(true, true));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAllInOrder(Arrays.asList(true, false));

        try {
            Raw.booleanArrayAssertion().containsAllInOrder(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAllInOrder(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAllInOrder(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAllInOrder((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAllInOrder((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAllInOrder((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAllInOrder((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAllInOrder(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAllInOrder(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAllInOrder(Arrays.asList(false, false));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}).containsAllInOrder(Arrays.asList(false, true));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[false, true]> but was:<[true, false]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, false}, "Message").containsAllInOrder(Arrays.asList(false, true));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values in the specified order. Expected:<[false, true]> but was:<[true, false]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactly(true, true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(true, false, true, false);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(false, false, true, true);
        initialize(Raw.booleanArrayAssertion(), new boolean[0]).containsExactly();

        try {
            Raw.booleanArrayAssertion().containsExactly(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactly(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactly(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactly((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactly((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactly((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsExactly((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactly(false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(true, true, false, false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[true, true, false, false, false]> but was:<[true, true, false, false]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactly();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(true, true, true, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[true, true, true, false]> but was:<[true, true, false, false]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}, "Message").containsExactly(true, true, true, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values exactly. Expected:<[true, true, true, false]> but was:<[true, true, false, false]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactly(Arrays.asList(true, true));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(Arrays.asList(true, false, true, false));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(Arrays.asList(false, false, true, true));
        initialize(Raw.booleanArrayAssertion(), new boolean[0]).containsExactly(new ArrayList<Boolean>());

        try {
            Raw.booleanArrayAssertion().containsExactly(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactly(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactly(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactly((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactly((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactly((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsExactly((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactly(Arrays.asList(false, false));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(Arrays.asList(true, true, false, false, false));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[true, true, false, false, false]> but was:<[true, true, false, false]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactly(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactly(Arrays.asList(true, true, true, false));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[true, true, true, false]> but was:<[true, true, false, false]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}, "Message").containsExactly(Arrays.asList(true, true, true, false));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values exactly. Expected:<[true, true, true, false]> but was:<[true, true, false, false]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactlyInOrder(true, true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(true, true, false, false);
        initialize(Raw.booleanArrayAssertion(), new boolean[0]).containsExactlyInOrder();

        try {
            Raw.booleanArrayAssertion().containsExactlyInOrder(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactlyInOrder(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactlyInOrder(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactlyInOrder((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactlyInOrder((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactlyInOrder((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsExactlyInOrder((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactlyInOrder(false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(true, true, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[true, true, false]> but was:<[true, true, false, false]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(true, true, false, false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[true, true, false, false, false]> but was:<[true, true, false, false]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactlyInOrder();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(true, false, true, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[true, false, true, false]> but was:<[true, true, false, false]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}, "Message").containsExactlyInOrder(true, false, true, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values exactly in the specified order. Expected:<[true, false, true, false]> but was:<[true, true, false, false]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactlyInOrder(Arrays.asList(true, true));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(Arrays.asList(true, true, false, false));
        initialize(Raw.booleanArrayAssertion(), new boolean[0]).containsExactlyInOrder(new ArrayList<Boolean>());

        try {
            Raw.booleanArrayAssertion().containsExactlyInOrder(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactlyInOrder(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsExactlyInOrder((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsExactlyInOrder((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactlyInOrder((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsExactlyInOrder((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactlyInOrder(Arrays.asList(false, false));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(Arrays.asList(true, true, false));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[true, true, false]> but was:<[true, true, false, false]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(Arrays.asList(true, true, false, false, false));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[true, true, false, false, false]> but was:<[true, true, false, false]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsExactlyInOrder(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsExactlyInOrder(Arrays.asList(true, false, true, false));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[true, false, true, false]> but was:<[true, true, false, false]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}, "Message").containsExactlyInOrder(Arrays.asList(true, false, true, false));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values exactly in the specified order. Expected:<[true, false, true, false]> but was:<[true, true, false, false]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAny(true, true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAny(true, true);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAny(false, false);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAny(true, false);

        try {
            Raw.booleanArrayAssertion().containsAny(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAny(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAny(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAny((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAny((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAny((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAny((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAny();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAny();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAny(false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAny(false, false);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain any of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAny(Arrays.asList(true, true));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAny(Arrays.asList(true, true));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAny(Arrays.asList(false, false));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true, false, false}).containsAny(Arrays.asList(true, false));

        try {
            Raw.booleanArrayAssertion().containsAny(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAny(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAny(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsAny((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsAny((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAny((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAny((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAny(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAny(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsAny(Arrays.asList(false, false));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsAny(Arrays.asList(false, false));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain any of the expected values. Expected:<[false, false]> but was:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(false, false);
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(false, false, false);

        try {
            Raw.booleanArrayAssertion().containsNone(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsNone(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsNone(true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsNone((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsNone((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsNone((boolean[]) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsNone();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(true, true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values. Expected:<[true, true]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(false, true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values. Expected:<[false, true]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsNone(false, true);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not contain any of the expected values. Expected:<[false, true]> but was:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(Arrays.asList(false, false));
        initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(Arrays.asList(false, false, false));

        try {
            Raw.booleanArrayAssertion().containsNone(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsNone(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsNone(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null).containsNone((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), null, "Message").containsNone((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsNone((Iterable<Boolean>) null);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsNone(new ArrayList<Boolean>());
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(Arrays.asList(true, true));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values. Expected:<[true, true]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).containsNone(Arrays.asList(false, true));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values. Expected:<[false, true]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").containsNone(Arrays.asList(false, true));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not contain any of the expected values. Expected:<[false, true]> but was:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.booleanArrayAssertion(), null).isNull();

        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}).isNull();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null. Actual:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), new boolean[]{true, true}, "Message").isNull();
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should be null. Actual:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        boolean[] value = new boolean[]{true, true};
        initialize(Raw.booleanArrayAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.booleanArrayAssertion(), value).isSameAs(new boolean[]{true, true});
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same. Expected:<[true, true]> but was:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), value, "Message").isSameAs(new boolean[]{true, true});
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual and expected values should be the same. Expected:<[true, true]> but was:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        boolean[] value = new boolean[]{true, true};
        initialize(Raw.booleanArrayAssertion(), value).isNotSameAs(new boolean[]{true, true});

        try {
            initialize(Raw.booleanArrayAssertion(), value).isNotSameAs(value);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different. Actual:<[true, true]>");
        }
        try {
            initialize(Raw.booleanArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual and expected values should be different. Actual:<[true, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.booleanArrayAssertion(), null).asString(null));
            Assertions.fail("BooleanArrayAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.booleanArrayAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.booleanArrayAssertion(), null).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(initialize(Raw.booleanArrayAssertion(), null).asString(new boolean[]{true, true})).isEqualTo("[true, true]");
    }

}
