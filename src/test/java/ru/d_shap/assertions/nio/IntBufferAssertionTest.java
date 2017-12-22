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

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link IntBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntBufferAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntBufferAssertionTest() {
        super();
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[0]));

        try {
            initializeWithRawActual(Raw.intBufferAssertion(), new Object());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.intBufferAssertion(), new Object(), "Message");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).contains(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).contains(2);

        try {
            Raw.intBufferAssertion().contains(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).contains(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").contains(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).contains(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).contains(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).contains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").contains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContains(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContains(2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContains(2);

        try {
            Raw.intBufferAssertion().rewindAndContains(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContains(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContains(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContains(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).doesNotContain(3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doesNotContain(2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doesNotContain(5);

        try {
            Raw.intBufferAssertion().doesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).doesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").doesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doesNotContain(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).doesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").doesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndDoesNotContain(3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndDoesNotContain(5);

        try {
            Raw.intBufferAssertion().rewindAndDoesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndDoesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndDoesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndDoesNotContain(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndDoesNotContain(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndDoesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndDoesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAll(1, 2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAll(1, 3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAll(4, 2);

        try {
            Raw.intBufferAssertion().containsAll(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAll(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAll(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAll();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAll();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsAll(1, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsAll(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAll(Arrays.asList(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAll(Arrays.asList(1, 3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAll(Arrays.asList(4, 2));

        try {
            Raw.intBufferAssertion().containsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsAll(Arrays.asList(1, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsAll(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAll(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAll(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllArrayTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAll(1, 2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAll(1, 3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAll(4, 2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAll(1, 2);

        try {
            Raw.intBufferAssertion().rewindAndContainsAll(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAll(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAll(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAll();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAll();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAll(Arrays.asList(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAll(Arrays.asList(1, 3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAll(Arrays.asList(4, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAll(Arrays.asList(1, 2));

        try {
            Raw.intBufferAssertion().rewindAndContainsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAll(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAll(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder(1, 2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAllInOrder(1, 3, 4);

        try {
            Raw.intBufferAssertion().containsAllInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAllInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAllInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAllInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder(1, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder(Arrays.asList(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAllInOrder(Arrays.asList(1, 3, 4));

        try {
            Raw.intBufferAssertion().containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder(Arrays.asList(1, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderArrayTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAllInOrder(1, 2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(1, 3, 4);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAllInOrder(1, 2);

        try {
            Raw.intBufferAssertion().rewindAndContainsAllInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAllInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAllInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAllInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAllInOrder(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAllInOrder(Arrays.asList(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(Arrays.asList(1, 3, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAllInOrder(Arrays.asList(1, 2));

        try {
            Raw.intBufferAssertion().rewindAndContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAllInOrder(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactly(1, 2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactly(1, 2, 3, 4);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactly(1, 3, 2, 4);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[0])).containsExactly();

        try {
            Raw.intBufferAssertion().containsExactly(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsExactly(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactly(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactly(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactly(Arrays.asList(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1, 2, 3, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1, 3, 2, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[0])).containsExactly(new ArrayList<Integer>());

        try {
            Raw.intBufferAssertion().containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactly(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsExactly(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").containsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyArrayTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactly(1, 2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 2, 3, 4);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 3, 2, 4);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[0])).rewindAndContainsExactly();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactly(1, 2, 3, 4, 5);

        try {
            Raw.intBufferAssertion().rewindAndContainsExactly(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsExactly(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactly(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactly(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactly(Arrays.asList(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1, 2, 3, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1, 3, 2, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[0])).rewindAndContainsExactly(new ArrayList<Integer>());
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactly(Arrays.asList(1, 2, 3, 4, 5));

        try {
            Raw.intBufferAssertion().rewindAndContainsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactly(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(1, 2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[0])).containsExactlyInOrder();

        try {
            Raw.intBufferAssertion().containsExactlyInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsExactlyInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactlyInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(1, 2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactlyInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(Arrays.asList(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(1, 2, 3, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[0])).containsExactlyInOrder(new ArrayList<Integer>());

        try {
            Raw.intBufferAssertion().containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(1, 2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderArrayTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactlyInOrder(1, 2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[0])).rewindAndContainsExactlyInOrder();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);

        try {
            Raw.intBufferAssertion().rewindAndContainsExactlyInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsExactlyInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactlyInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1, 2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactlyInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactlyInOrder(Arrays.asList(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[0])).rewindAndContainsExactlyInOrder(new ArrayList<Integer>());
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));

        try {
            Raw.intBufferAssertion().rewindAndContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactlyInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAny(2, 3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAny(2, 4);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAny(4, 1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAny(5, 3);

        try {
            Raw.intBufferAssertion().containsAny(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAny(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAny(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAny();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAny();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsAny(1, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsAny(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAny(Arrays.asList(2, 3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAny(Arrays.asList(2, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAny(Arrays.asList(4, 1));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAny(Arrays.asList(5, 3));

        try {
            Raw.intBufferAssertion().containsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsAny(Arrays.asList(1, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsAny(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAny(Arrays.asList(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAny(Arrays.asList(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyArrayTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAny(2, 3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAny(2, 4);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAny(4, 1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAny(5, 3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAny(1, 3);

        try {
            Raw.intBufferAssertion().rewindAndContainsAny(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAny(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAny(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAny();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAny();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAny(Arrays.asList(2, 3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList(2, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList(4, 1));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList(5, 3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAny(Arrays.asList(1, 3));

        try {
            Raw.intBufferAssertion().rewindAndContainsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAny(Arrays.asList(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAny(Arrays.asList(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsNone(3, 7);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsNone(3, 4, 5);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsNone(1, 3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsNone(4, 5);

        try {
            Raw.intBufferAssertion().containsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsNone();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsNone();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsNone(Arrays.asList(3, 7));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsNone(Arrays.asList(3, 4, 5));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsNone(Arrays.asList(1, 3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsNone(Arrays.asList(4, 5));

        try {
            Raw.intBufferAssertion().containsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsNone(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsNone(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneArrayTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsNone(3, 7);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsNone(3, 4, 5);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsNone(4, 5);

        try {
            Raw.intBufferAssertion().rewindAndContainsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsNone();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsNone();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone(1, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsNone(Arrays.asList(3, 7));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsNone(Arrays.asList(3, 4, 5));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsNone(Arrays.asList(4, 5));

        try {
            Raw.intBufferAssertion().rewindAndContainsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone(Arrays.asList(1, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsNone(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsNone(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.intBufferAssertion(), null).isNull();

        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNull();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").isNull();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        IntBuffer value = createIntBuffer(new int[]{1, 2});
        initialize(Raw.intBufferAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.intBufferAssertion(), value).isSameAs(createIntBuffer(new int[]{1, 2}));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), value, "Message").isSameAs(createIntBuffer(new int[]{1, 2}));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        IntBuffer value = createIntBuffer(new int[]{1, 2});
        initialize(Raw.intBufferAssertion(), value).isNotSameAs(createIntBuffer(new int[]{1, 2}));

        try {
            initialize(Raw.intBufferAssertion(), value).isNotSameAs(value);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.intBufferAssertion(), null).asString(null));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.intBufferAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.intBufferAssertion(), null).asString(createIntBuffer(new int[]{1, 2, 3}))).isEqualTo("[1, 2, 3]");
        Assertions.assertThat(initialize(Raw.intBufferAssertion(), null).asString(createIntBuffer(new int[]{1, 2, 3, 4, 5}))).isEqualTo("[1, 2, 3, 4, 5]");
        Assertions.assertThat(initialize(Raw.intBufferAssertion(), null).asString(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 2))).isEqualTo("[3, 4, 5]");
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void positionTest() {
        IntBuffer buffer = createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).contains(4);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContains(2);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).doesNotContain(2);
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
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void listCapacityTest() {
        Assertions.assertThat(initialize(Raw.intBufferAssertion(), null).createList(createIntBuffer(new int[]{1, 2, 3, 4, 5}), false), "elementData", Raw.objectArrayAssertion()).hasLength(5);
        Assertions.assertThat(initialize(Raw.intBufferAssertion(), null).createList(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), false), "elementData", Raw.objectArrayAssertion()).hasLength(2);
        Assertions.assertThat(initialize(Raw.intBufferAssertion(), null).createList(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), false), "elementData", Raw.objectArrayAssertion()).hasLength(3);
        Assertions.assertThat(initialize(Raw.intBufferAssertion(), null).createList(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 3), false), "elementData", Raw.objectArrayAssertion()).hasLength(2);

        Assertions.assertThat(initialize(Raw.intBufferAssertion(), null).createList(createIntBuffer(new int[]{1, 2, 3, 4, 5}), true), "elementData", Raw.objectArrayAssertion()).hasLength(5);
        Assertions.assertThat(initialize(Raw.intBufferAssertion(), null).createList(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), true), "elementData", Raw.objectArrayAssertion()).hasLength(5);
        Assertions.assertThat(initialize(Raw.intBufferAssertion(), null).createList(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), true), "elementData", Raw.objectArrayAssertion()).hasLength(3);
        Assertions.assertThat(initialize(Raw.intBufferAssertion(), null).createList(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 3), true), "elementData", Raw.objectArrayAssertion()).hasLength(3);
    }

}
