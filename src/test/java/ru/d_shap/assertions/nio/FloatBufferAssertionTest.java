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
package ru.d_shap.assertions.nio;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link FloatBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatBufferAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FloatBufferAssertionTest() {
        super();
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[0]));

        try {
            initializeWithRawActual(Raw.floatBufferAssertion(), new Object());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.floatBufferAssertion(), new Object(), "Message");
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).contains(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).contains(2.0f);

        try {
            Raw.floatBufferAssertion().contains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).contains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").contains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).contains(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<2.0> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).contains(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).contains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").contains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContains(1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContains(2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContains(2.0f);

        try {
            Raw.floatBufferAssertion().rewindAndContains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContains(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).doesNotContain(3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).doesNotContain(2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).doesNotContain(5.0f);

        try {
            Raw.floatBufferAssertion().doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).doesNotContain(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndDoesNotContain(3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndDoesNotContain(5.0f);

        try {
            Raw.floatBufferAssertion().rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndDoesNotContain(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2.0> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndDoesNotContain(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAll(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsAll(1.0f, 3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsAll(4.0f, 2.0f);

        try {
            Raw.floatBufferAssertion().containsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAll();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAll();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsAll(1.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsAll(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAll(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsAll(Arrays.asList(1.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsAll(Arrays.asList(4.0f, 2.0f));

        try {
            Raw.floatBufferAssertion().containsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsAll(Arrays.asList(1.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsAll(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAll(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsAll(1.0f, 3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsAll(4.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsAll(1.0f, 2.0f);

        try {
            Raw.floatBufferAssertion().rewindAndContainsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAll();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAll();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsAll(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAll(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsAll(Arrays.asList(1.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsAll(Arrays.asList(4.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsAll(Arrays.asList(1.0f, 2.0f));

        try {
            Raw.floatBufferAssertion().rewindAndContainsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsAll(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsAllInOrder(1.0f, 3.0f, 4.0f);

        try {
            Raw.floatBufferAssertion().containsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAllInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsAllInOrder(1.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsAllInOrder(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsAllInOrder(Arrays.asList(1.0f, 3.0f, 4.0f));

        try {
            Raw.floatBufferAssertion().containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsAllInOrder(Arrays.asList(1.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsAllInOrder(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(1.0f, 3.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsAllInOrder(1.0f, 2.0f);

        try {
            Raw.floatBufferAssertion().rewindAndContainsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAllInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsAllInOrder(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(Arrays.asList(1.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsAllInOrder(Arrays.asList(1.0f, 2.0f));

        try {
            Raw.floatBufferAssertion().rewindAndContainsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsAllInOrder(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactly(1.0f, 2.0f, 3.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactly(1.0f, 3.0f, 2.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[0])).containsExactly();

        try {
            Raw.floatBufferAssertion().containsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1.0f, 3.0f, 2.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[0])).containsExactly(new ArrayList<Float>());

        try {
            Raw.floatBufferAssertion().containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").containsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactly(1.0f, 3.0f, 2.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[0])).rewindAndContainsExactly();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);

        try {
            Raw.floatBufferAssertion().rewindAndContainsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1.0f, 3.0f, 2.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[0])).rewindAndContainsExactly(new ArrayList<Float>());
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));

        try {
            Raw.floatBufferAssertion().rewindAndContainsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[0])).containsExactlyInOrder();

        try {
            Raw.floatBufferAssertion().containsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[0])).containsExactlyInOrder(new ArrayList<Float>());

        try {
            Raw.floatBufferAssertion().containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder(1.0f, 2.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[0])).rewindAndContainsExactlyInOrder();
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);

        try {
            Raw.floatBufferAssertion().rewindAndContainsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[0])).rewindAndContainsExactlyInOrder(new ArrayList<Float>());
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));

        try {
            Raw.floatBufferAssertion().rewindAndContainsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAny(2.0f, 3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsAny(2.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsAny(4.0f, 1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsAny(5.0f, 3.0f);

        try {
            Raw.floatBufferAssertion().containsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAny();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAny();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsAny(1.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1.0, 3.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsAny(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAny(Arrays.asList(2.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsAny(Arrays.asList(2.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsAny(Arrays.asList(4.0f, 1.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).containsAny(Arrays.asList(5.0f, 3.0f));

        try {
            Raw.floatBufferAssertion().containsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsAny(Arrays.asList(1.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1.0, 3.0]> but was:<[4.0, 5.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsAny(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAny(2.0f, 3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsAny(2.0f, 4.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsAny(4.0f, 1.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsAny(5.0f, 3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsAny(1.0f, 3.0f);

        try {
            Raw.floatBufferAssertion().rewindAndContainsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAny();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAny();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsAny(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAny(Arrays.asList(2.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList(2.0f, 4.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList(4.0f, 1.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList(5.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsAny(Arrays.asList(1.0f, 3.0f));

        try {
            Raw.floatBufferAssertion().rewindAndContainsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsAny(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(3.0f, 7.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(3.0f, 4.0f, 5.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsNone(1.0f, 3.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsNone(4.0f, 5.0f);

        try {
            Raw.floatBufferAssertion().containsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsNone();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(Arrays.asList(3.0f, 7.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(Arrays.asList(3.0f, 4.0f, 5.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).containsNone(Arrays.asList(1.0f, 3.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).containsNone(Arrays.asList(4.0f, 5.0f));

        try {
            Raw.floatBufferAssertion().containsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).containsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").containsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).containsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneArrayTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(3.0f, 7.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(3.0f, 4.0f, 5.0f);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsNone(4.0f, 5.0f);

        try {
            Raw.floatBufferAssertion().rewindAndContainsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsNone();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsNone(1.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneIterableTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(Arrays.asList(3.0f, 7.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(Arrays.asList(3.0f, 4.0f, 5.0f));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3)).rewindAndContainsNone(Arrays.asList(4.0f, 5.0f));

        try {
            Raw.floatBufferAssertion().rewindAndContainsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).rewindAndContainsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").rewindAndContainsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3)).rewindAndContainsNone(Arrays.asList(1.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).rewindAndContainsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.floatBufferAssertion(), null).isNull();

        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f})).isNull();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").isNull();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        FloatBuffer value = createFloatBuffer(new float[]{1.0f, 2.0f});
        initialize(Raw.floatBufferAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.floatBufferAssertion(), value).isSameAs(createFloatBuffer(new float[]{1.0f, 2.0f}));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<[1.0, 2.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), value, "Message").isSameAs(createFloatBuffer(new float[]{1.0f, 2.0f}));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<[1.0, 2.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        FloatBuffer value = createFloatBuffer(new float[]{1.0f, 2.0f});
        initialize(Raw.floatBufferAssertion(), value).isNotSameAs(createFloatBuffer(new float[]{1.0f, 2.0f}));

        try {
            initialize(Raw.floatBufferAssertion(), value).isNotSameAs(value);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.floatBufferAssertion(), null).asString(null));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.floatBufferAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.floatBufferAssertion(), null).asString(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}))).isEqualTo("[1.0, 2.0, 3.0]");
        Assertions.assertThat(initialize(Raw.floatBufferAssertion(), null).asString(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}))).isEqualTo("[1.0, 2.0, 3.0, 4.0, 5.0]");
        Assertions.assertThat(initialize(Raw.floatBufferAssertion(), null).asString(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 2))).isEqualTo("[3.0, 4.0, 5.0]");
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void positionTest() {
        FloatBuffer buffer = createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).contains(4.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContains(2.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).doesNotContain(2.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndDoesNotContain(0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAll(4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAll(2, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAllInOrder(4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAllInOrder(2, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsExactly(4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsExactly(1, 2, 3, 4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsExactlyInOrder(4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAny(1, 5, 7);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAny(1, 7, 9);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsNone(1, 9);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsNone(7, 9);
        Assertions.assertThat(buffer).hasPosition(3);
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void listCapacityTest() {
        Assertions.assertThat(initialize(Raw.floatBufferAssertion(), null).createList(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}), false), "elementData", Raw.objectArrayAssertion()).hasLength(5);
        Assertions.assertThat(initialize(Raw.floatBufferAssertion(), null).createList(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), false), "elementData", Raw.objectArrayAssertion()).hasLength(2);
        Assertions.assertThat(initialize(Raw.floatBufferAssertion(), null).createList(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), false), "elementData", Raw.objectArrayAssertion()).hasLength(3);
        Assertions.assertThat(initialize(Raw.floatBufferAssertion(), null).createList(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 1, 3), false), "elementData", Raw.objectArrayAssertion()).hasLength(2);

        Assertions.assertThat(initialize(Raw.floatBufferAssertion(), null).createList(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}), true), "elementData", Raw.objectArrayAssertion()).hasLength(5);
        Assertions.assertThat(initialize(Raw.floatBufferAssertion(), null).createList(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), true), "elementData", Raw.objectArrayAssertion()).hasLength(5);
        Assertions.assertThat(initialize(Raw.floatBufferAssertion(), null).createList(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), true), "elementData", Raw.objectArrayAssertion()).hasLength(3);
        Assertions.assertThat(initialize(Raw.floatBufferAssertion(), null).createList(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 1, 3), true), "elementData", Raw.objectArrayAssertion()).hasLength(3);
    }

}
