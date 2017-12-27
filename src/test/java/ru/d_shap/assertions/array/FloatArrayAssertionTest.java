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
 * Tests for {@link FloatArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatArrayAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FloatArrayAssertionTest() {
        super();
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.floatArrayAssertion(), new float[0]);

        try {
            initializeWithRawActual(Raw.floatArrayAssertion(), new Object());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.floatArrayAssertion(), new Object(), "Message");
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).contains(1.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).contains(2.0f);

        try {
            Raw.floatArrayAssertion().contains(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).contains(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").contains(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).contains(3.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").contains(3.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).doesNotContain(3.0f);

        try {
            Raw.floatArrayAssertion().doesNotContain(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).doesNotContain(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").doesNotContain(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).doesNotContain(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").doesNotContain(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAll(1.0f, 2.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAll(1.0f, 3.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAll(4.0f, 2.0f);

        try {
            Raw.floatArrayAssertion().containsAll(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAll(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAll(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAll((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAll((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAll((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAll((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAll();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAll();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAll(2.0f, 3.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAll(2.0f, 3.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAll(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAll(Arrays.asList(1.0f, 3.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAll(Arrays.asList(4.0f, 2.0f));

        try {
            Raw.floatArrayAssertion().containsAll(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAll(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAll(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAll((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAll((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAll((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAll((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAll(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAll(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder(1.0f, 2.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAllInOrder(1.0f, 3.0f, 4.0f);

        try {
            Raw.floatArrayAssertion().containsAllInOrder(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAllInOrder(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAllInOrder(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAllInOrder((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAllInOrder((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAllInOrder((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAllInOrder();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder(2.0f, 3.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAllInOrder(Arrays.asList(1.0f, 3.0f, 4.0f));

        try {
            Raw.floatArrayAssertion().containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactly(1.0f, 2.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(1.0f, 2.0f, 3.0f, 4.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(1.0f, 3.0f, 2.0f, 4.0f);
        initialize(Raw.floatArrayAssertion(), new float[0]).containsExactly();

        try {
            Raw.floatArrayAssertion().containsExactly(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactly(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactly(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactly((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactly((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactly((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsExactly((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactly(2.0f, 3.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactly();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}, "Message").containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactly(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(Arrays.asList(1.0f, 3.0f, 2.0f, 4.0f));
        initialize(Raw.floatArrayAssertion(), new float[0]).containsExactly(new ArrayList<Float>());

        try {
            Raw.floatArrayAssertion().containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactly(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}, "Message").containsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactlyInOrder(1.0f, 2.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        initialize(Raw.floatArrayAssertion(), new float[0]).containsExactlyInOrder();

        try {
            Raw.floatArrayAssertion().containsExactlyInOrder(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactlyInOrder(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactlyInOrder(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactlyInOrder();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}, "Message").containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatArrayAssertion(), new float[0]).containsExactlyInOrder(new ArrayList<Float>());

        try {
            Raw.floatArrayAssertion().containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactlyInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}, "Message").containsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAny(2.0f, 3.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAny(2.0f, 4.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAny(4.0f, 1.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAny(5.0f, 3.0f);

        try {
            Raw.floatArrayAssertion().containsAny(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAny(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAny(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAny((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAny((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAny((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAny((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAny();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAny();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAny(3.0f, 4.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAny(3.0f, 4.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAny(Arrays.asList(2.0f, 3.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAny(Arrays.asList(2.0f, 4.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAny(Arrays.asList(4.0f, 1.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f, 3.0f, 4.0f}).containsAny(Arrays.asList(5.0f, 3.0f));

        try {
            Raw.floatArrayAssertion().containsAny(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAny(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAny(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsAny((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsAny((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAny((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAny((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAny(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAny(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone(3.0f, 7.0f);
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone(3.0f, 4.0f, 5.0f);

        try {
            Raw.floatArrayAssertion().containsNone(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsNone(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsNone(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsNone((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsNone((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsNone((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsNone();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone(2.0f, 1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsNone(2.0f, 1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone(Arrays.asList(3.0f, 7.0f));
        initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone(Arrays.asList(3.0f, 4.0f, 5.0f));

        try {
            Raw.floatArrayAssertion().containsNone(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsNone(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsNone(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null).containsNone((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), null, "Message").containsNone((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsNone((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsNone(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).containsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").containsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.floatArrayAssertion(), null).isNull();

        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}).isNull();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), new float[]{1.0f, 2.0f}, "Message").isNull();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        float[] value = new float[]{1.0f, 2.0f};
        initialize(Raw.floatArrayAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.floatArrayAssertion(), value).isSameAs(new float[]{1.0f, 2.0f});
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<[1.0, 2.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), value, "Message").isSameAs(new float[]{1.0f, 2.0f});
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<[1.0, 2.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        float[] value = new float[]{1.0f, 2.0f};
        initialize(Raw.floatArrayAssertion(), value).isNotSameAs(new float[]{1.0f, 2.0f});

        try {
            initialize(Raw.floatArrayAssertion(), value).isNotSameAs(value);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.floatArrayAssertion(), null).asString(null));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.floatArrayAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.floatArrayAssertion(), null).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(initialize(Raw.floatArrayAssertion(), null).asString(new float[]{1.0f, 2.0f})).isEqualTo("[1.0, 2.0]");
    }

}
