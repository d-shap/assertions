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
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

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
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}));

        try {
            initializeWithRawActual(Raw.intBufferAssertion(), new Object());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.nio.IntBuffer> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.intBufferAssertion(), new Object(), "Message");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.nio.IntBuffer> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).isEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 2)).isEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 2, 2, 4)).isEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 2, 2, 4)).isNotNull().isEmpty().isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().isEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).isEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").isEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}, 0, 4, 4)).isEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[0, 0, 0, 0]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1)).isEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1), "Message").isEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void isRewindAndEmptyTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).isRewindAndEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 0, 0)).isRewindAndEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 0, 0, 4)).isRewindAndEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 0, 0, 4)).isNotNull().isRewindAndEmpty().isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().isRewindAndEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).isRewindAndEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").isRewindAndEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}, 0, 4, 4)).isRewindAndEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[0, 0, 0, 0]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isRewindAndEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1)).isRewindAndEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1), "Message").isRewindAndEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).isNullOrEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 2)).isNullOrEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 2, 2, 4)).isNullOrEmpty();
        initialize(Raw.intBufferAssertion(), null).isNullOrEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).isNotNull().isNullOrEmpty().isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().isNullOrEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}, 0, 4, 4)).isNullOrEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[0, 0, 0, 0]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNullOrEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1)).isNullOrEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1), "Message").isNullOrEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void isRewindAndNullOrEmptyTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).isRewindAndNullOrEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 0, 0)).isRewindAndNullOrEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 0, 0, 4)).isRewindAndNullOrEmpty();
        initialize(Raw.intBufferAssertion(), null).isRewindAndNullOrEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).isNotNull().isRewindAndNullOrEmpty().isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().isRewindAndNullOrEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}, 0, 4, 4)).isRewindAndNullOrEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[0, 0, 0, 0]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isRewindAndNullOrEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1)).isRewindAndNullOrEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1), "Message").isRewindAndNullOrEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1)).isNotEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}, 0, 4, 4)).isNotEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().isNotEmpty().isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().isNotEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).isNotEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).isNotEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 2)).isNotEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 2, 2, 4)).isNotEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 2, 2, 4), "Message").isNotEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void isRewindAndNotEmptyTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isRewindAndNotEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 1)).isRewindAndNotEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}, 0, 4, 4)).isRewindAndNotEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 2)).isRewindAndNotEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}, 2, 2, 4)).isRewindAndNotEmpty();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().isRewindAndNotEmpty().isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().isRewindAndNotEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).isRewindAndNotEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").isRewindAndNotEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).isRewindAndNotEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").isRewindAndNotEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).contains(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).contains(2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().contains(2).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").contains(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).contains(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<2> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).contains(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).contains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").contains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3> but was:<[1, 2]>");
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
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().rewindAndContains(2).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContains(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContains(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3> but was:<[1, 2]>");
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
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().doesNotContain(3).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").doesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doesNotContain(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).doesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").doesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndDoesNotContain(3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndDoesNotContain(5);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().rewindAndDoesNotContain(3).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndDoesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndDoesNotContain(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndDoesNotContain(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndDoesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndDoesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1> but was:<[1, 2]>");
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
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().containsAll(1, 2).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAll(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsAll();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsAll();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsAll(1, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsAll(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAll(DataHelper.createIterable(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAll(DataHelper.createIterable(1, 3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAll(DataHelper.createIterable(4, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().containsAll(DataHelper.createIterable(1, 2)).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().containsAll(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAll(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAll(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsAll(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsAll(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsAll(DataHelper.createIterable(1, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsAll(DataHelper.createIterable(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAll(DataHelper.createIterable(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAll(DataHelper.createIterable(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
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
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().rewindAndContainsAll(1, 2).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAll(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsAll();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsAll();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAll(DataHelper.createIterable(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAll(DataHelper.createIterable(1, 3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAll(DataHelper.createIterable(4, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAll(DataHelper.createIterable(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().rewindAndContainsAll(DataHelper.createIterable(1, 2)).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().rewindAndContainsAll(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAll(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAll(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsAll(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsAll(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll(DataHelper.createIterable(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAll(DataHelper.createIterable(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAll(DataHelper.createIterable(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder(1, 2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAllInOrder(1, 3, 4);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().containsAllInOrder(1, 2).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAllInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsAllInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsAllInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder(1, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder(DataHelper.createIterable(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAllInOrder(DataHelper.createIterable(1, 3, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().containsAllInOrder(DataHelper.createIterable(1, 2)).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().containsAllInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAllInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAllInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsAllInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsAllInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder(DataHelper.createIterable(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder(DataHelper.createIterable(1, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder(DataHelper.createIterable(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAllInOrder(DataHelper.createIterable(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAllInOrder(DataHelper.createIterable(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
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
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().rewindAndContainsAllInOrder(1, 2).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsAllInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsAllInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAllInOrder(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAllInOrder(DataHelper.createIterable(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(DataHelper.createIterable(1, 3, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAllInOrder(DataHelper.createIterable(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().rewindAndContainsAllInOrder(DataHelper.createIterable(1, 2)).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().rewindAndContainsAllInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAllInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsAllInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsAllInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAllInOrder(DataHelper.createIterable(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder(DataHelper.createIterable(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAllInOrder(DataHelper.createIterable(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAllInOrder(DataHelper.createIterable(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
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
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsExactly();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().containsExactly(1, 2).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactly(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactly(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactly(DataHelper.createIterable(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactly(DataHelper.createIterable(1, 2, 3, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactly(DataHelper.createIterable(1, 3, 2, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsExactly(DataHelper.<Integer>createIterable());
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().containsExactly(DataHelper.createIterable(1, 2)).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().containsExactly(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsExactly(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactly(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactly(DataHelper.createIterable(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactly(DataHelper.createIterable(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactly(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsExactly(DataHelper.createIterable(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly(DataHelper.createIterable(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactly(DataHelper.createIterable(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").containsExactly(DataHelper.createIterable(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
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
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsExactly();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactly(1, 2, 3, 4, 5);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().rewindAndContainsExactly(1, 2).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactly(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactly(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactly(DataHelper.createIterable(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactly(DataHelper.createIterable(1, 2, 3, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactly(DataHelper.createIterable(1, 3, 2, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsExactly(DataHelper.<Integer>createIterable());
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactly(DataHelper.createIterable(1, 2, 3, 4, 5));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().rewindAndContainsExactly(DataHelper.createIterable(1, 2)).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().rewindAndContainsExactly(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsExactly(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactly(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactly(DataHelper.createIterable(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactly(DataHelper.createIterable(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactly(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly(DataHelper.createIterable(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactly(DataHelper.createIterable(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(DataHelper.createIterable(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(1, 2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsExactlyInOrder();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().containsExactlyInOrder(1, 2).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactlyInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(1, 2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactlyInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(DataHelper.createIterable(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(DataHelper.createIterable(1, 2, 3, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsExactlyInOrder(DataHelper.<Integer>createIterable());
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().containsExactlyInOrder(DataHelper.createIterable(1, 2)).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().containsExactlyInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsExactlyInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(DataHelper.createIterable(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(DataHelper.createIterable(1, 2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(DataHelper.createIterable(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsExactlyInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder(DataHelper.createIterable(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder(DataHelper.createIterable(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsExactlyInOrder(DataHelper.createIterable(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(DataHelper.createIterable(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderArrayTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactlyInOrder(1, 2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsExactlyInOrder();
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().rewindAndContainsExactlyInOrder(1, 2).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactlyInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1, 2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactlyInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1, 2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1, 2, 3, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsExactlyInOrder(DataHelper.<Integer>createIterable());
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1, 2, 3, 4, 5));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().rewindAndContainsExactlyInOrder(DataHelper.createIterable(1, 2)).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().rewindAndContainsExactlyInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsExactlyInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1, 2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsExactlyInOrder(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(DataHelper.createIterable(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
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
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().containsAny(2, 3).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAny(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsAny();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsAny();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsAny(1, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsAny(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAny(DataHelper.createIterable(2, 3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAny(DataHelper.createIterable(2, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAny(DataHelper.createIterable(4, 1));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).containsAny(DataHelper.createIterable(5, 3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().containsAny(DataHelper.createIterable(2, 3)).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().containsAny(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAny(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAny(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsAny(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsAny(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsAny(DataHelper.createIterable(1, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsAny(DataHelper.createIterable(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsAny(DataHelper.createIterable(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsAny(DataHelper.createIterable(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
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
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().rewindAndContainsAny(2, 3).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAny(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsAny();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsAny();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAny(DataHelper.createIterable(2, 3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAny(DataHelper.createIterable(2, 4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAny(DataHelper.createIterable(4, 1));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4})).rewindAndContainsAny(DataHelper.createIterable(5, 3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAny(DataHelper.createIterable(1, 3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().rewindAndContainsAny(DataHelper.createIterable(2, 3)).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().rewindAndContainsAny(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAny(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAny(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsAny(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsAny(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny(DataHelper.createIterable(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsAny(DataHelper.createIterable(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAny(DataHelper.createIterable(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
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
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().containsNone(3, 7).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsNone();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsNone();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsNone(DataHelper.createIterable(3, 7));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsNone(DataHelper.createIterable(3, 4, 5));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).containsNone(DataHelper.createIterable(1, 3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).containsNone(DataHelper.createIterable(4, 5));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().containsNone(DataHelper.createIterable(3, 7)).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().containsNone(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsNone(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsNone(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).containsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").containsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).containsNone(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").containsNone(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).containsNone(DataHelper.createIterable(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").containsNone(DataHelper.createIterable(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
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
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().rewindAndContainsNone(3, 7).isInstanceOf(IntBuffer.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsNone();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsNone();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone(1, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneIterableTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsNone(DataHelper.createIterable(3, 7));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsNone(DataHelper.createIterable(3, 4, 5));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsNone(DataHelper.createIterable(4, 5));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().rewindAndContainsNone(DataHelper.createIterable(3, 7)).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().rewindAndContainsNone(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsNone(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsNone(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).rewindAndContainsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").rewindAndContainsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).rewindAndContainsNone(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").rewindAndContainsNone(DataHelper.<Integer>createIterable());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone(DataHelper.createIterable(1, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).rewindAndContainsNone(DataHelper.createIterable(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsNone(DataHelper.createIterable(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString().isEqualTo("0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString().isEqualTo("0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toHexString().isEqualTo("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 2)).toHexString().isEqualTo("00000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString().isEqualTo("0000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toHexString().isEqualTo("0000000100000002");

        try {
            Raw.intBufferAssertion().toHexString();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toHexString();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toHexString();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toHexString()).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toHexString()).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toHexString().isEqualTo("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toHexString().isEqualTo("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).toHexString().isEqualTo("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), "Message").toHexString().isEqualTo("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toHexStringPartTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 0).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 1).isEqualTo("00000001");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 2).isEqualTo("0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(1, 1).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(1, 2).isEqualTo("00000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(2, 2).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString(0, 3).isEqualTo("0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString(2, 2).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString(2, 3).isEqualTo("00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toHexString(0, 4).isEqualTo("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 0).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 1).isEqualTo("00000005");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 2).isEqualTo("0000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 1).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 2).isEqualTo("00000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(2, 2).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toHexString(0, 2).isEqualTo("0000000100000002");

        try {
            Raw.intBufferAssertion().toHexString(0, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toHexString(0, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toHexString(0, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toHexString(-1, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toHexString(-1, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(-1, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(-1, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(-1, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(-1, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(0, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(3, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(3, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(1, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(1, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 0)).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(0, 0)).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toHexString(1, 2).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toHexString(1, 2).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4)).toHexString(1, 3).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000300000004>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4), "Message").toHexString(1, 3).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000300000004>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(Matchers.is(Matchers.equalTo("0000000100000002")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString(Matchers.is(Matchers.equalTo("0000000ffffffffd00000007")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toHexString(Matchers.is(Matchers.equalTo("000000630000000500000000ffffffeb")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 2)).toHexString(Matchers.is(Matchers.equalTo("00000000ffffffeb")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(Matchers.is(Matchers.equalTo("0000000500000000")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toHexString(Matchers.is(Matchers.equalTo("0000000100000002"))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toHexString(Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toHexString(Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toHexString(Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"0000000400000005\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"0000000400000005\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).toHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"000000010000000200000003\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), "Message").toHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"000000010000000200000003\"");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toHexStringPartMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 1, Matchers.is(Matchers.equalTo("00000001")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 2, Matchers.is(Matchers.equalTo("0000000100000002")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(1, 2, Matchers.is(Matchers.equalTo("00000002")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString(0, 3, Matchers.is(Matchers.equalTo("0000000ffffffffd00000007")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString(2, 3, Matchers.is(Matchers.equalTo("00000007")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toHexString(0, 4, Matchers.is(Matchers.equalTo("000000630000000500000000ffffffeb")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 1, Matchers.is(Matchers.equalTo("00000005")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 2, Matchers.is(Matchers.equalTo("0000000500000000")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 2, Matchers.is(Matchers.equalTo("00000000")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toHexString(0, 2, Matchers.is(Matchers.equalTo("0000000100000002"))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 3, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(0, 3, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 0, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(0, 0, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toHexString(1, 2, Matchers.equalTo("0000000000000000"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\nExpected: \"0000000000000000\"\n     but: was \"00000005\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toHexString(1, 2, Matchers.equalTo("0000000000000000"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\nExpected: \"0000000000000000\"\n     but: was \"00000005\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4)).toHexString(1, 3, Matchers.equalTo("0000000000000000"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\nExpected: \"0000000000000000\"\n     but: was \"0000000300000004\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4), "Message").toHexString(1, 3, Matchers.equalTo("0000000000000000"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\nExpected: \"0000000000000000\"\n     but: was \"0000000300000004\"");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString().isEqualTo("0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString().isEqualTo("0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toRewindAndHexString().isEqualTo("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 2)).toRewindAndHexString().isEqualTo("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString().isEqualTo("000000630000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toRewindAndHexString().isEqualTo("0000000100000002");

        try {
            Raw.intBufferAssertion().toRewindAndHexString();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndHexString();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndHexString();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString()).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString()).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString().isEqualTo("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000100000002000000030000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString().isEqualTo("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000100000002000000030000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).toRewindAndHexString().isEqualTo("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), "Message").toRewindAndHexString().isEqualTo("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringPartTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 0).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 1).isEqualTo("00000001");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 2).isEqualTo("0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(1, 1).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(1, 2).isEqualTo("00000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString(0, 3).isEqualTo("0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString(2, 3).isEqualTo("00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toRewindAndHexString(0, 4).isEqualTo("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 0).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 1).isEqualTo("00000063");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 2).isEqualTo("0000006300000005");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 3).isEqualTo("000000630000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 1).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 2).isEqualTo("00000005");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 3).isEqualTo("0000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 3).isEqualTo("00000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(3, 3).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toRewindAndHexString(0, 2).isEqualTo("0000000100000002");

        try {
            Raw.intBufferAssertion().toRewindAndHexString(0, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndHexString(0, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndHexString(0, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndHexString(-1, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndHexString(-1, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(-1, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(-1, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(-1, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(-1, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(0, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(3, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(3, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(1, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(1, 0);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 0)).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(0, 0)).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString(1, 2).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000002>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString(1, 2).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000002>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4)).toRewindAndHexString(1, 3).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000200000003>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4), "Message").toRewindAndHexString(1, 3).isEqualTo("0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000200000003>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(Matchers.is(Matchers.equalTo("0000000100000002")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString(Matchers.is(Matchers.equalTo("0000000ffffffffd00000007")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toRewindAndHexString(Matchers.is(Matchers.equalTo("000000630000000500000000ffffffeb")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 2)).toRewindAndHexString(Matchers.is(Matchers.equalTo("000000630000000500000000ffffffeb")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(Matchers.is(Matchers.equalTo("000000630000000500000000")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toRewindAndHexString(Matchers.is(Matchers.equalTo("0000000100000002"))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"0000000100000002000000030000000400000005\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"0000000100000002000000030000000400000005\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).toRewindAndHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"000000010000000200000003\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), "Message").toRewindAndHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"000000010000000200000003\"");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringPartMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 1, Matchers.is(Matchers.equalTo("00000001")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("0000000100000002")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(1, 2, Matchers.is(Matchers.equalTo("00000002")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString(0, 3, Matchers.is(Matchers.equalTo("0000000ffffffffd00000007")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString(2, 3, Matchers.is(Matchers.equalTo("00000007")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toRewindAndHexString(0, 4, Matchers.is(Matchers.equalTo("000000630000000500000000ffffffeb")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 1, Matchers.is(Matchers.equalTo("00000063")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("0000006300000005")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 3, Matchers.is(Matchers.equalTo("000000630000000500000000")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 2, Matchers.is(Matchers.equalTo("00000005")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 3, Matchers.is(Matchers.equalTo("0000000500000000")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 3, Matchers.is(Matchers.equalTo("00000000")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(3, 3, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("0000000100000002"))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 3, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(0, 3, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 0, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(0, 0, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString(1, 2, Matchers.equalTo("0000000000000000"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\nExpected: \"0000000000000000\"\n     but: was \"00000002\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString(1, 2, Matchers.equalTo("0000000000000000"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\nExpected: \"0000000000000000\"\n     but: was \"00000002\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4)).toRewindAndHexString(1, 3, Matchers.equalTo("0000000000000000"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\nExpected: \"0000000000000000\"\n     but: was \"0000000200000003\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4), "Message").toRewindAndHexString(1, 3, Matchers.equalTo("0000000000000000"));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\nExpected: \"0000000000000000\"\n     but: was \"0000000200000003\"");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString("0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasHexString("0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).hasHexString("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 2)).hasHexString("00000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasHexString("0000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().hasHexString("0000000100000002").isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasHexString("");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasHexString("");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasHexString("");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).hasHexString("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").hasHexString("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).hasHexString("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), "Message").hasHexString("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasHexStringPartTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(0, 0, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(0, 1, "00000001");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(0, 2, "0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(1, 1, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(1, 2, "00000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(2, 2, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasHexString(0, 3, "0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasHexString(2, 2, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasHexString(2, 3, "00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).hasHexString(0, 4, "000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasHexString(0, 0, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasHexString(0, 1, "00000005");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasHexString(0, 2, "0000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasHexString(1, 1, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasHexString(1, 2, "00000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasHexString(2, 2, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().hasHexString(0, 2, "0000000100000002").isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasHexString(0, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasHexString(0, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasHexString(0, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasHexString(-1, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasHexString(-1, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(-1, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(-1, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(-1, 3, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(-1, 3, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(0, 3, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(0, 3, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(3, 3, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(3, 3, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(1, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(1, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(0, 3, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(0, 3, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(0, 0, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(0, 0, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).hasHexString(1, 2, "0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").hasHexString(1, 2, "0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4)).hasHexString(1, 3, "0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000300000004>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4), "Message").hasHexString(1, 3, "0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000300000004>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndHexStringTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString("0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasRewindAndHexString("0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).hasRewindAndHexString("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 2)).hasRewindAndHexString("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString("000000630000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().hasRewindAndHexString("0000000100000002").isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasRewindAndHexString("");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasRewindAndHexString("");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasRewindAndHexString("");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasRewindAndHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasRewindAndHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).hasRewindAndHexString("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000100000002000000030000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").hasRewindAndHexString("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000100000002000000030000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).hasRewindAndHexString("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), "Message").hasRewindAndHexString("0000000300000004");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndHexStringPartTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(0, 0, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(0, 1, "00000001");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(0, 2, "0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(1, 1, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(1, 2, "00000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(2, 2, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasRewindAndHexString(0, 3, "0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasRewindAndHexString(2, 2, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasRewindAndHexString(2, 3, "00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).hasRewindAndHexString(0, 4, "000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 0, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 1, "00000063");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 2, "0000006300000005");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 3, "000000630000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(1, 1, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(1, 2, "00000005");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(1, 3, "0000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(2, 2, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(2, 3, "00000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(3, 3, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().hasRewindAndHexString(0, 2, "0000000100000002").isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasRewindAndHexString(0, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasRewindAndHexString(0, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasRewindAndHexString(0, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasRewindAndHexString(-1, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasRewindAndHexString(-1, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(-1, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(-1, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(-1, 3, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(-1, 3, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(0, 3, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(0, 3, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(3, 3, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(3, 3, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(1, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(1, 0, "");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(0, 3, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(0, 3, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(0, 0, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(0, 0, null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).hasRewindAndHexString(1, 2, "0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000002>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").hasRewindAndHexString(1, 2, "0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000002>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4)).hasRewindAndHexString(1, 3, "0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000200000003>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4), "Message").hasRewindAndHexString(1, 3, "0000000000000000");
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000200000003>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toPositionTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toPosition().isEqualTo(3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toPosition().isGreaterThan(2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toPosition().isLessThan(6);

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1)).toPosition().isEqualTo(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1)).toPosition().isGreaterThan(0);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1)).toPosition().isLessThan(4);

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toPosition().isEqualTo(3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toPosition().isGreaterThan(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toPosition().isLessThan(5);

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).isNotNull().toPosition().isEqualTo(3);

        try {
            Raw.intBufferAssertion().toPosition();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toPosition();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toPosition();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toPosition()).isEqualTo(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").toPosition()).isEqualTo(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toPosition().isEqualTo(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").toPosition().isEqualTo(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toPositionMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toPosition(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toPosition(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toPosition(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1)).toPosition(Matchers.equalTo(1));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1)).toPosition(Matchers.greaterThan(0));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1)).toPosition(Matchers.lessThan(2));

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toPosition(Matchers.equalTo(3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toPosition(Matchers.greaterThan(2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toPosition(Matchers.lessThan(4));

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).isNotNull().toPosition(Matchers.is(Matchers.equalTo(3))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toPosition(Matchers.equalTo(0));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toPosition(Matchers.equalTo(0));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toPosition(Matchers.equalTo(0));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toPosition(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toPosition(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).toPosition(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").toPosition(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toPosition(Matchers.equalTo(4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").toPosition(Matchers.equalTo(4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasPositionTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasPosition(3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1)).hasPosition(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).hasPosition(3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).isNotNull().hasPosition(3).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasPosition(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasPosition(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasPosition(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasPosition(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").hasPosition(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toLimitTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toLimit().isEqualTo(3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toLimit().isGreaterThan(2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toLimit().isLessThan(6);

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toLimit().isEqualTo(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toLimit().isGreaterThan(0);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toLimit().isLessThan(4);

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toLimit().isEqualTo(3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toLimit().isGreaterThan(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toLimit().isLessThan(5);

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).isNotNull().toLimit().isEqualTo(3);

        try {
            Raw.intBufferAssertion().toLimit();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toLimit();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toLimit();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toLimit()).isEqualTo(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").toLimit()).isEqualTo(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toLimit().isEqualTo(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").toLimit().isEqualTo(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toLimitMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toLimit(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toLimit(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toLimit(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toLimit(Matchers.equalTo(1));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toLimit(Matchers.greaterThan(0));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toLimit(Matchers.lessThan(2));

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toLimit(Matchers.equalTo(3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toLimit(Matchers.greaterThan(2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toLimit(Matchers.lessThan(4));

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).isNotNull().toLimit(Matchers.is(Matchers.equalTo(3))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toLimit(Matchers.equalTo(0));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toLimit(Matchers.equalTo(0));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toLimit(Matchers.equalTo(0));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toLimit(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toLimit(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).toLimit(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").toLimit(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toLimit(Matchers.equalTo(4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").toLimit(Matchers.equalTo(4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasLimitTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasLimit(3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).hasLimit(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).hasLimit(3);

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).isNotNull().hasLimit(3).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasLimit(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasLimit(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasLimit(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasLimit(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").hasLimit(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toCapacityTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toCapacity().isEqualTo(3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toCapacity().isGreaterThan(2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toCapacity().isLessThan(6);

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toCapacity().isEqualTo(3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toCapacity().isGreaterThan(2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toCapacity().isLessThan(6);

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toCapacity().isEqualTo(5);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toCapacity().isGreaterThan(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toCapacity().isLessThan(7);

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).isNotNull().toCapacity().isEqualTo(3);

        try {
            Raw.intBufferAssertion().toCapacity();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toCapacity();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toCapacity();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toCapacity()).isEqualTo(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").toCapacity()).isEqualTo(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toCapacity().isEqualTo(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").toCapacity().isEqualTo(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toCapacityMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toCapacity(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toCapacity(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toCapacity(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toCapacity(Matchers.equalTo(3));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toCapacity(Matchers.greaterThan(2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toCapacity(Matchers.lessThan(4));

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toCapacity(Matchers.equalTo(5));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toCapacity(Matchers.greaterThan(4));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toCapacity(Matchers.lessThan(6));

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).isNotNull().toCapacity(Matchers.is(Matchers.equalTo(3))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toCapacity(Matchers.equalTo(0));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toCapacity(Matchers.equalTo(0));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toCapacity(Matchers.equalTo(0));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toCapacity(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toCapacity(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).toCapacity(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").toCapacity(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toCapacity(Matchers.equalTo(4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").toCapacity(Matchers.equalTo(4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasCapacityTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasCapacity(3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).hasCapacity(3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).hasCapacity(5);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).isNotNull().hasCapacity(3).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasCapacity(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasCapacity(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasCapacity(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasCapacity(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").hasCapacity(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasPropertiesTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasProperties(3, 3, 3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1)).hasProperties(1, 3, 3);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).hasProperties(3, 3, 5);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).isNotNull().hasProperties(3, 3, 3).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasProperties(1, 1, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasProperties(1, 1, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasProperties(1, 1, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasProperties(4, 3, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").hasProperties(4, 3, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasProperties(3, 4, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").hasProperties(3, 4, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasProperties(3, 3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").hasProperties(3, 3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toRemainingTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toRemaining().isEqualTo(0);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toRemaining().isGreaterThan(-1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toRemaining().isLessThan(3);

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 3)).toRemaining().isEqualTo(2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 3)).toRemaining().isGreaterThan(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 3)).toRemaining().isLessThan(5);

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 2, 5)).toRemaining().isEqualTo(0);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 2, 5)).toRemaining().isGreaterThan(-1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 2, 5)).toRemaining().isLessThan(3);

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 2, 4, 5)).toRemaining().isEqualTo(2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 2, 4, 5)).toRemaining().isGreaterThan(1);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 2, 4, 5)).toRemaining().isLessThan(5);

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).isNotNull().toRemaining().isEqualTo(0);

        try {
            Raw.intBufferAssertion().toRemaining();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRemaining();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRemaining();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 0, 3, 3)).toRemaining()).isEqualTo(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 0, 3, 3), "Message").toRemaining()).isEqualTo(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 0, 3, 3)).toRemaining().isEqualTo(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 0, 3, 3), "Message").toRemaining().isEqualTo(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toRemainingMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toRemaining(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toRemaining(Matchers.is(Matchers.greaterThan(-1)));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).toRemaining(Matchers.is(Matchers.lessThan(1)));

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 3)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 3)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 3)).toRemaining(Matchers.lessThan(3));

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 2, 5)).toRemaining(Matchers.equalTo(0));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 2, 5)).toRemaining(Matchers.greaterThan(-1));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 2, 5)).toRemaining(Matchers.lessThan(1));

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 2, 4, 5)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 2, 4, 5)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 2, 4, 5)).toRemaining(Matchers.lessThan(3));

        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).isNotNull().toRemaining(Matchers.is(Matchers.equalTo(0))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toRemaining(Matchers.equalTo(0));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRemaining(Matchers.equalTo(0));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRemaining(Matchers.equalTo(0));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRemaining(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRemaining(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{})).toRemaining(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{}), "Message").toRemaining(null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 0, 3, 3)).toRemaining(Matchers.equalTo(4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 0, 3, 3), "Message").toRemaining(Matchers.equalTo(4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasRemainingTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasRemaining(0);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 1, 3)).hasRemaining(2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 4, 2, 5)).hasRemaining(0);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 2, 4, 5)).hasRemaining(2);
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 3)).isNotNull().hasRemaining(0).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasRemaining(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasRemaining(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasRemaining(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 0, 3, 3)).hasRemaining(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3}, 0, 3, 3), "Message").hasRemaining(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void isDirectTest() {
        initialize(Raw.intBufferAssertion(), ByteBuffer.allocateDirect(12).asIntBuffer()).isDirect();
        initialize(Raw.intBufferAssertion(), ByteBuffer.allocateDirect(12).asIntBuffer()).isNotNull().isDirect().isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().isDirect();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).isDirect();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").isDirect();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), ByteBuffer.allocate(12).asIntBuffer()).isDirect();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be direct.");
        }
        try {
            initialize(Raw.intBufferAssertion(), ByteBuffer.allocate(12).asIntBuffer(), "Message").isDirect();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be direct.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void isNotDirectTest() {
        initialize(Raw.intBufferAssertion(), ByteBuffer.allocate(12).asIntBuffer()).isNotDirect();
        initialize(Raw.intBufferAssertion(), ByteBuffer.allocate(12).asIntBuffer()).isNotNull().isNotDirect().isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().isNotDirect();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).isNotDirect();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").isNotDirect();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), ByteBuffer.allocateDirect(12).asIntBuffer()).isNotDirect();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be direct.");
        }
        try {
            initialize(Raw.intBufferAssertion(), ByteBuffer.allocateDirect(12).asIntBuffer(), "Message").isNotDirect();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be direct.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void isReadOnlyTest() {
        IntBuffer buffer = ByteBuffer.allocate(12).asIntBuffer();
        IntBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.intBufferAssertion(), readOnlyBuffer).isReadOnly();
        initialize(Raw.intBufferAssertion(), readOnlyBuffer).isNotNull().isReadOnly().isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().isReadOnly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).isReadOnly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").isReadOnly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), buffer).isReadOnly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be read only.");
        }
        try {
            initialize(Raw.intBufferAssertion(), buffer, "Message").isReadOnly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be read only.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void isNotReadOnlyTest() {
        IntBuffer buffer = ByteBuffer.allocate(12).asIntBuffer();
        IntBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.intBufferAssertion(), buffer).isNotReadOnly();
        initialize(Raw.intBufferAssertion(), buffer).isNotNull().isNotReadOnly().isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().isNotReadOnly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).isNotReadOnly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").isNotReadOnly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), readOnlyBuffer).isNotReadOnly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be read only.");
        }
        try {
            initialize(Raw.intBufferAssertion(), readOnlyBuffer, "Message").isNotReadOnly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be read only.");
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
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").isNull();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[1, 2]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), value, "Message").isSameAs(createIntBuffer(new int[]{1, 2}));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<[1, 2]> but was:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.intBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<[1, 2]>");
        }
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

}
