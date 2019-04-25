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
import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ByteBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteBufferAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteBufferAssertionTest() {
        super();
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}));

        try {
            initializeWithRawActual(Raw.byteBufferAssertion(), new Object());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.nio.ByteBuffer> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.byteBufferAssertion(), new Object(), "Message");
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.nio.ByteBuffer> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).isEmpty();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 2)).isEmpty();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 2, 2, 4)).isEmpty();

        try {
            Raw.byteBufferAssertion().isEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).isEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").isEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}, 0, 4, 4)).isEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[0b, 0b, 0b, 0b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).isEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1), "Message").isEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void isRewindAndEmptyTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).isRewindAndEmpty();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 0, 0)).isRewindAndEmpty();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 0, 0, 4)).isRewindAndEmpty();

        try {
            Raw.byteBufferAssertion().isRewindAndEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).isRewindAndEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").isRewindAndEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}, 0, 4, 4)).isRewindAndEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[0b, 0b, 0b, 0b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isRewindAndEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).isRewindAndEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1), "Message").isRewindAndEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).isNullOrEmpty();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 2)).isNullOrEmpty();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 2, 2, 4)).isNullOrEmpty();
        initialize(Raw.byteBufferAssertion(), null).isNullOrEmpty();

        try {
            Raw.byteBufferAssertion().isNullOrEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}, 0, 4, 4)).isNullOrEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[0b, 0b, 0b, 0b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isNullOrEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).isNullOrEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1), "Message").isNullOrEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void isRewindAndNullOrEmptyTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).isRewindAndNullOrEmpty();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 0, 0)).isRewindAndNullOrEmpty();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 0, 0, 4)).isRewindAndNullOrEmpty();
        initialize(Raw.byteBufferAssertion(), null).isRewindAndNullOrEmpty();

        try {
            Raw.byteBufferAssertion().isRewindAndNullOrEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}, 0, 4, 4)).isRewindAndNullOrEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[0b, 0b, 0b, 0b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isRewindAndNullOrEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).isRewindAndNullOrEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1), "Message").isRewindAndNullOrEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isNotEmpty();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).isNotEmpty();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}, 0, 4, 4)).isNotEmpty();

        try {
            Raw.byteBufferAssertion().isNotEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).isNotEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).isNotEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 2)).isNotEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 2, 2, 4)).isNotEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 2, 2, 4), "Message").isNotEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void isRewindAndNotEmptyTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isRewindAndNotEmpty();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).isRewindAndNotEmpty();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}, 0, 4, 4)).isRewindAndNotEmpty();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 2)).isRewindAndNotEmpty();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 2, 2, 4)).isRewindAndNotEmpty();

        try {
            Raw.byteBufferAssertion().isRewindAndNotEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).isRewindAndNotEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").isRewindAndNotEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).isRewindAndNotEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").isRewindAndNotEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).contains(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).contains(2);

        try {
            Raw.byteBufferAssertion().contains(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).contains(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").contains(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).contains(2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<2b> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).contains(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4b> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).contains(3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3b> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").contains(3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3b> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContains(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContains(2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContains(2);

        try {
            Raw.byteBufferAssertion().rewindAndContains(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContains(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContains(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContains(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4b> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContains(3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3b> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContains(3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3b> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).doesNotContain(3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).doesNotContain(2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).doesNotContain(5);

        try {
            Raw.byteBufferAssertion().doesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).doesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").doesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).doesNotContain(2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2b> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).doesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1b> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").doesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1b> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndDoesNotContain(3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndDoesNotContain(5);

        try {
            Raw.byteBufferAssertion().rewindAndDoesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndDoesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndDoesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndDoesNotContain(2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2b> but was:<[1b, 2b, 3b, 4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndDoesNotContain(2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2b> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndDoesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1b> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").rewindAndDoesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1b> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsAllArrayByteTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAll((byte) 1, (byte) 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAll((byte) 1, (byte) 3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAll((byte) 4, (byte) 2);

        try {
            Raw.byteBufferAssertion().containsAll((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAll((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAll((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAll((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAll((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAll((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAll((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAll();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAll();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsAll((byte) 1, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1b, 2b]> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsAll((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").containsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsAllArrayIntTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAll(1, 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAll(1, 3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAll(4, 2);

        try {
            Raw.byteBufferAssertion().containsAll(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAll(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAll(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAll((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAll((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAll((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAll((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAll(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAll(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsAll(1, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1b, 2b]> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsAll(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAll(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").containsAll(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAll(Arrays.asList((byte) 1, (byte) 2));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAll(Arrays.asList((byte) 1, (byte) 3));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAll(Arrays.asList((byte) 4, (byte) 2));

        try {
            Raw.byteBufferAssertion().containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAll((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAll((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAll((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAll((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsAll(Arrays.asList((byte) 1, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1b, 2b]> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsAll(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").containsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllArrayByteTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAll((byte) 1, (byte) 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAll((byte) 1, (byte) 3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAll((byte) 4, (byte) 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAll((byte) 1, (byte) 2);

        try {
            Raw.byteBufferAssertion().rewindAndContainsAll((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAll((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAll((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAll((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAll((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAll((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAll((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAll();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAll();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllArrayIntTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAll(1, 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAll(1, 3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAll(4, 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAll(1, 2);

        try {
            Raw.byteBufferAssertion().rewindAndContainsAll(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAll(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAll(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAll((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAll((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAll((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAll((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAll(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAll(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAll(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAll(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllIterableTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAll(Arrays.asList((byte) 1, (byte) 2));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAll(Arrays.asList((byte) 1, (byte) 3));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAll(Arrays.asList((byte) 4, (byte) 2));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAll(Arrays.asList((byte) 1, (byte) 2));

        try {
            Raw.byteBufferAssertion().rewindAndContainsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAll((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAll((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAll((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAll((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayByteTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAllInOrder((byte) 1, (byte) 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAllInOrder((byte) 1, (byte) 3, (byte) 4);

        try {
            Raw.byteBufferAssertion().containsAllInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAllInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAllInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAllInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAllInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAllInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAllInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAllInOrder();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAllInOrder();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAllInOrder((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder((byte) 1, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1b, 2b]> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").containsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayIntTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAllInOrder(1, 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAllInOrder(1, 3, 4);

        try {
            Raw.byteBufferAssertion().containsAllInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAllInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAllInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAllInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAllInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAllInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAllInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAllInOrder(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAllInOrder(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAllInOrder(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder(1, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1b, 2b]> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAllInOrder(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").containsAllInOrder(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAllInOrder(Arrays.asList((byte) 1, (byte) 2));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAllInOrder(Arrays.asList((byte) 1, (byte) 3, (byte) 4));

        try {
            Raw.byteBufferAssertion().containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAllInOrder(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder(Arrays.asList((byte) 1, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1b, 2b]> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").containsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderArrayByteTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAllInOrder((byte) 1, (byte) 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAllInOrder((byte) 1, (byte) 3, (byte) 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAllInOrder((byte) 1, (byte) 2);

        try {
            Raw.byteBufferAssertion().rewindAndContainsAllInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAllInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAllInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAllInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAllInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAllInOrder();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAllInOrder();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAllInOrder((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderArrayIntTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAllInOrder(1, 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(1, 3, 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAllInOrder(1, 2);

        try {
            Raw.byteBufferAssertion().rewindAndContainsAllInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAllInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAllInOrder(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAllInOrder(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAllInOrder(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderIterableTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAllInOrder(Arrays.asList((byte) 1, (byte) 2));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(Arrays.asList((byte) 1, (byte) 3, (byte) 4));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAllInOrder(Arrays.asList((byte) 1, (byte) 2));

        try {
            Raw.byteBufferAssertion().rewindAndContainsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAllInOrder(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsExactlyArrayByteTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactly((byte) 1, (byte) 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactly((byte) 1, (byte) 3, (byte) 2, (byte) 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsExactly();

        try {
            Raw.byteBufferAssertion().containsExactly((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsExactly((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsExactly((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsExactly((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsExactly((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsExactly((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsExactly((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactly((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").containsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsExactlyArrayIntTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactly(1, 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactly(1, 2, 3, 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactly(1, 3, 2, 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsExactly(new int[]{});

        try {
            Raw.byteBufferAssertion().containsExactly(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsExactly(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsExactly(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsExactly((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsExactly((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsExactly((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsExactly((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactly(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactly(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactly(1, 1, 3, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactly(Arrays.asList((byte) 1, (byte) 2));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactly(Arrays.asList((byte) 1, (byte) 3, (byte) 2, (byte) 4));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsExactly(new ArrayList<Byte>());

        try {
            Raw.byteBufferAssertion().containsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactly(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").containsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyArrayByteTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactly((byte) 1, (byte) 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactly((byte) 1, (byte) 3, (byte) 2, (byte) 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsExactly();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);

        try {
            Raw.byteBufferAssertion().rewindAndContainsExactly((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsExactly((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsExactly((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsExactly((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsExactly((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsExactly((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsExactly((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactly((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyArrayIntTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactly(1, 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 2, 3, 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 3, 2, 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsExactly(new int[]{});
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactly(1, 2, 3, 4, 5);

        try {
            Raw.byteBufferAssertion().rewindAndContainsExactly(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsExactly(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsExactly(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsExactly((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsExactly((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsExactly((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsExactly((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactly(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactly(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyIterableTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 2));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 3, (byte) 2, (byte) 4));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsExactly(new ArrayList<Byte>());
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));

        try {
            Raw.byteBufferAssertion().rewindAndContainsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactly(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayByteTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder((byte) 1, (byte) 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsExactlyInOrder();

        try {
            Raw.byteBufferAssertion().containsExactlyInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsExactlyInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsExactlyInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").containsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayIntTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(1, 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsExactlyInOrder(new int[]{});

        try {
            Raw.byteBufferAssertion().containsExactlyInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsExactlyInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsExactlyInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsExactlyInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsExactlyInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactlyInOrder(1, 2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsExactlyInOrder(new ArrayList<Byte>());

        try {
            Raw.byteBufferAssertion().containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderArrayByteTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsExactlyInOrder();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);

        try {
            Raw.byteBufferAssertion().rewindAndContainsExactlyInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsExactlyInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactlyInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactlyInOrder();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderArrayIntTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactlyInOrder(1, 2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsExactlyInOrder(new int[]{});
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);

        try {
            Raw.byteBufferAssertion().rewindAndContainsExactlyInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsExactlyInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactlyInOrder(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1, 2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactlyInOrder(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderIterableTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsExactlyInOrder(new ArrayList<Byte>());
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));

        try {
            Raw.byteBufferAssertion().rewindAndContainsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsAnyArrayByteTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAny((byte) 2, (byte) 3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAny((byte) 2, (byte) 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAny((byte) 4, (byte) 1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAny((byte) 5, (byte) 3);

        try {
            Raw.byteBufferAssertion().containsAny((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAny((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAny((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAny((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAny((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAny((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAny((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAny();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAny();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsAny((byte) 1, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1b, 3b]> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsAny((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").containsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsAnyArrayIntTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAny(2, 3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAny(2, 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAny(4, 1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAny(5, 3);

        try {
            Raw.byteBufferAssertion().containsAny(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAny(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAny(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAny((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAny((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAny((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAny((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAny(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAny(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsAny(1, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1b, 3b]> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsAny(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAny(3, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").containsAny(3, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAny(Arrays.asList((byte) 2, (byte) 3));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAny(Arrays.asList((byte) 2, (byte) 4));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAny(Arrays.asList((byte) 4, (byte) 1));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).containsAny(Arrays.asList((byte) 5, (byte) 3));

        try {
            Raw.byteBufferAssertion().containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsAny((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsAny((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAny((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAny((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsAny(Arrays.asList((byte) 1, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1b, 3b]> but was:<[4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsAny(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").containsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyArrayByteTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAny((byte) 2, (byte) 3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAny((byte) 2, (byte) 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAny((byte) 4, (byte) 1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAny((byte) 5, (byte) 3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAny((byte) 1, (byte) 3);

        try {
            Raw.byteBufferAssertion().rewindAndContainsAny((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAny((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAny((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAny((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAny((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAny((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAny((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAny();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAny();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyArrayIntTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAny(2, 3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAny(2, 4);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAny(4, 1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAny(5, 3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAny(1, 3);

        try {
            Raw.byteBufferAssertion().rewindAndContainsAny(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAny(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAny(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAny((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAny((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAny((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAny((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAny(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAny(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAny(3, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAny(3, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyIterableTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAny(Arrays.asList((byte) 2, (byte) 3));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList((byte) 2, (byte) 4));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList((byte) 4, (byte) 1));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList((byte) 5, (byte) 3));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAny(Arrays.asList((byte) 1, (byte) 3));

        try {
            Raw.byteBufferAssertion().rewindAndContainsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsAny((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsAny((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAny((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAny((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4b, 5b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsNoneArrayByteTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsNone((byte) 3, (byte) 7);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsNone((byte) 3, (byte) 4, (byte) 5);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsNone((byte) 1, (byte) 3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsNone((byte) 4, (byte) 5);

        try {
            Raw.byteBufferAssertion().containsNone((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsNone((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsNone((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsNone((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsNone((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsNone((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsNone((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsNone();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsNone();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").containsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsNoneArrayIntTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsNone(3, 7);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsNone(3, 4, 5);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsNone(1, 3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsNone(4, 5);

        try {
            Raw.byteBufferAssertion().containsNone(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsNone(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsNone(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsNone((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsNone((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsNone((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsNone((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsNone(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsNone(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsNone(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").containsNone(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsNone(Arrays.asList((byte) 3, (byte) 7));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsNone(Arrays.asList((byte) 3, (byte) 4, (byte) 5));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).containsNone(Arrays.asList((byte) 1, (byte) 3));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).containsNone(Arrays.asList((byte) 4, (byte) 5));

        try {
            Raw.byteBufferAssertion().containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).containsNone((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").containsNone((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsNone((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsNone((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).containsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").containsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneArrayByteTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsNone((byte) 3, (byte) 7);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsNone((byte) 3, (byte) 4, (byte) 5);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsNone((byte) 4, (byte) 5);

        try {
            Raw.byteBufferAssertion().rewindAndContainsNone((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsNone((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsNone((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsNone((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsNone((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsNone((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsNone((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsNone();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsNone();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone((byte) 1, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1b, 3b]> but was:<[1b, 2b, 3b, 4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneArrayIntTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsNone(3, 7);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsNone(3, 4, 5);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsNone(4, 5);

        try {
            Raw.byteBufferAssertion().rewindAndContainsNone(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsNone(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsNone(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsNone((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsNone((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsNone((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsNone((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsNone(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsNone(new int[]{});
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone(1, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1b, 3b]> but was:<[1b, 2b, 3b, 4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsNone(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsNone(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneIterableTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsNone(Arrays.asList((byte) 3, (byte) 7));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsNone(Arrays.asList((byte) 3, (byte) 4, (byte) 5));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsNone(Arrays.asList((byte) 4, (byte) 5));

        try {
            Raw.byteBufferAssertion().rewindAndContainsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).rewindAndContainsNone((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").rewindAndContainsNone((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsNone((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsNone((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).rewindAndContainsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").rewindAndContainsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone(Arrays.asList((byte) 1, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1b, 3b]> but was:<[1b, 2b, 3b, 4b, 5b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).rewindAndContainsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toPositionTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toPosition().isEqualTo(3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toPosition().isGreaterThan(2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toPosition().isLessThan(6);

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1)).toPosition().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1)).toPosition().isGreaterThan(0);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1)).toPosition().isLessThan(4);

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toPosition().isEqualTo(3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toPosition().isGreaterThan(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toPosition().isLessThan(5);

        try {
            Raw.byteBufferAssertion().toPosition();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toPosition();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toPosition();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toPosition()).isEqualTo(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3), "Message").toPosition()).isEqualTo(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toPosition().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3), "Message").toPosition().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toPositionMatcherTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toPosition(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toPosition(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toPosition(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1)).toPosition(Matchers.equalTo(1));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1)).toPosition(Matchers.greaterThan(0));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1)).toPosition(Matchers.lessThan(2));

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toPosition(Matchers.equalTo(3));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toPosition(Matchers.greaterThan(2));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toPosition(Matchers.lessThan(4));

        try {
            Raw.byteBufferAssertion().toPosition(Matchers.equalTo(0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toPosition(Matchers.equalTo(0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toPosition(Matchers.equalTo(0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toPosition(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toPosition(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toPosition(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").toPosition(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toPosition(Matchers.equalTo(4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3), "Message").toPosition(Matchers.equalTo(4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasPositionTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).hasPosition(3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1)).hasPosition(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).hasPosition(3);

        try {
            Raw.byteBufferAssertion().hasPosition(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasPosition(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasPosition(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).hasPosition(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3), "Message").hasPosition(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toLimitTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toLimit().isEqualTo(3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toLimit().isGreaterThan(2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toLimit().isLessThan(6);

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 1)).toLimit().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 1)).toLimit().isGreaterThan(0);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 1)).toLimit().isLessThan(4);

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toLimit().isEqualTo(3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toLimit().isGreaterThan(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toLimit().isLessThan(5);

        try {
            Raw.byteBufferAssertion().toLimit();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toLimit();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toLimit();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toLimit()).isEqualTo(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3), "Message").toLimit()).isEqualTo(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toLimit().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3), "Message").toLimit().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toLimitMatcherTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toLimit(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toLimit(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toLimit(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 1)).toLimit(Matchers.equalTo(1));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 1)).toLimit(Matchers.greaterThan(0));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 1)).toLimit(Matchers.lessThan(2));

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toLimit(Matchers.equalTo(3));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toLimit(Matchers.greaterThan(2));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toLimit(Matchers.lessThan(4));

        try {
            Raw.byteBufferAssertion().toLimit(Matchers.equalTo(0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toLimit(Matchers.equalTo(0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toLimit(Matchers.equalTo(0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toLimit(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toLimit(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toLimit(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").toLimit(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toLimit(Matchers.equalTo(4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3), "Message").toLimit(Matchers.equalTo(4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasLimitTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).hasLimit(3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 1)).hasLimit(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).hasLimit(3);

        try {
            Raw.byteBufferAssertion().hasLimit(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasLimit(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasLimit(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).hasLimit(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3), "Message").hasLimit(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toCapacityTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toCapacity().isEqualTo(3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toCapacity().isGreaterThan(2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toCapacity().isLessThan(6);

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 1)).toCapacity().isEqualTo(3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 1)).toCapacity().isGreaterThan(2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 1)).toCapacity().isLessThan(6);

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toCapacity().isEqualTo(5);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toCapacity().isGreaterThan(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toCapacity().isLessThan(7);

        try {
            Raw.byteBufferAssertion().toCapacity();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toCapacity();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toCapacity();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toCapacity()).isEqualTo(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3), "Message").toCapacity()).isEqualTo(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toCapacity().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3), "Message").toCapacity().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toCapacityMatcherTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toCapacity(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toCapacity(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toCapacity(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 1)).toCapacity(Matchers.equalTo(3));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 1)).toCapacity(Matchers.greaterThan(2));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 1)).toCapacity(Matchers.lessThan(4));

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toCapacity(Matchers.equalTo(5));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toCapacity(Matchers.greaterThan(4));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).toCapacity(Matchers.lessThan(6));

        try {
            Raw.byteBufferAssertion().toCapacity(Matchers.equalTo(0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toCapacity(Matchers.equalTo(0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toCapacity(Matchers.equalTo(0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toCapacity(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toCapacity(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toCapacity(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").toCapacity(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toCapacity(Matchers.equalTo(4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3), "Message").toCapacity(Matchers.equalTo(4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasCapacityTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).hasCapacity(3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 1)).hasCapacity(3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).hasCapacity(5);

        try {
            Raw.byteBufferAssertion().hasCapacity(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasCapacity(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasCapacity(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).hasCapacity(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3), "Message").hasCapacity(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasPropertiesTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).hasProperties(3, 3, 3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1)).hasProperties(1, 3, 3);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 3, 5)).hasProperties(3, 3, 5);

        try {
            Raw.byteBufferAssertion().hasProperties(1, 1, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasProperties(1, 1, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasProperties(1, 1, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).hasProperties(4, 3, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3), "Message").hasProperties(4, 3, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).hasProperties(3, 4, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3), "Message").hasProperties(3, 4, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).hasProperties(3, 3, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3), "Message").hasProperties(3, 3, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toRemainingTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toRemaining().isEqualTo(0);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toRemaining().isGreaterThan(-1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toRemaining().isLessThan(3);

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 3)).toRemaining().isEqualTo(2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 3)).toRemaining().isGreaterThan(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 3)).toRemaining().isLessThan(5);

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 2, 5)).toRemaining().isEqualTo(0);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 2, 5)).toRemaining().isGreaterThan(-1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 2, 5)).toRemaining().isLessThan(3);

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 2, 4, 5)).toRemaining().isEqualTo(2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 2, 4, 5)).toRemaining().isGreaterThan(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 2, 4, 5)).toRemaining().isLessThan(5);

        try {
            Raw.byteBufferAssertion().toRemaining();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRemaining();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRemaining();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 0, 3, 3)).toRemaining()).isEqualTo(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 0, 3, 3), "Message").toRemaining()).isEqualTo(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 0, 3, 3)).toRemaining().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 0, 3, 3), "Message").toRemaining().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toRemainingMatcherTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toRemaining(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toRemaining(Matchers.is(Matchers.greaterThan(-1)));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).toRemaining(Matchers.is(Matchers.lessThan(1)));

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 3)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 3)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 3)).toRemaining(Matchers.lessThan(3));

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 2, 5)).toRemaining(Matchers.equalTo(0));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 2, 5)).toRemaining(Matchers.greaterThan(-1));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 2, 5)).toRemaining(Matchers.lessThan(1));

        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 2, 4, 5)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 2, 4, 5)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 2, 4, 5)).toRemaining(Matchers.lessThan(3));

        try {
            Raw.byteBufferAssertion().toRemaining(Matchers.equalTo(0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRemaining(Matchers.equalTo(0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRemaining(Matchers.equalTo(0));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRemaining(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRemaining(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toRemaining(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{}), "Message").toRemaining(null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 0, 3, 3)).toRemaining(Matchers.equalTo(4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 0, 3, 3), "Message").toRemaining(Matchers.equalTo(4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasRemainingTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 3)).hasRemaining(0);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 1, 3)).hasRemaining(2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 4, 2, 5)).hasRemaining(0);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 2, 4, 5)).hasRemaining(2);

        try {
            Raw.byteBufferAssertion().hasRemaining(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasRemaining(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasRemaining(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 0, 3, 3)).hasRemaining(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3}, 0, 3, 3), "Message").hasRemaining(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void isDirectTest() {
        initialize(Raw.byteBufferAssertion(), ByteBuffer.allocateDirect(12)).isDirect();

        try {
            Raw.byteBufferAssertion().isDirect();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).isDirect();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").isDirect();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), ByteBuffer.allocate(12)).isDirect();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be direct.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), ByteBuffer.allocate(12), "Message").isDirect();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be direct.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void isNotDirectTest() {
        initialize(Raw.byteBufferAssertion(), ByteBuffer.allocate(12)).isNotDirect();

        try {
            Raw.byteBufferAssertion().isNotDirect();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).isNotDirect();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").isNotDirect();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), ByteBuffer.allocateDirect(12)).isNotDirect();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be direct.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), ByteBuffer.allocateDirect(12), "Message").isNotDirect();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be direct.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void isReadOnlyTest() {
        ByteBuffer buffer = ByteBuffer.allocate(12);
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.byteBufferAssertion(), readOnlyBuffer).isReadOnly();

        try {
            Raw.byteBufferAssertion().isReadOnly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).isReadOnly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").isReadOnly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), buffer).isReadOnly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be read only.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), buffer, "Message").isReadOnly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be read only.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void isNotReadOnlyTest() {
        ByteBuffer buffer = ByteBuffer.allocate(12);
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.byteBufferAssertion(), buffer).isNotReadOnly();

        try {
            Raw.byteBufferAssertion().isNotReadOnly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).isNotReadOnly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").isNotReadOnly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), readOnlyBuffer).isNotReadOnly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be read only.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), readOnlyBuffer, "Message").isNotReadOnly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be read only.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.byteBufferAssertion(), null).isNull();

        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isNull();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").isNull();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        ByteBuffer value = createByteBuffer(new byte[]{1, 2});
        initialize(Raw.byteBufferAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.byteBufferAssertion(), value).isSameAs(createByteBuffer(new byte[]{1, 2}));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<[1b, 2b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), value, "Message").isSameAs(createByteBuffer(new byte[]{1, 2}));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<[1b, 2b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        ByteBuffer value = createByteBuffer(new byte[]{1, 2});
        initialize(Raw.byteBufferAssertion(), value).isNotSameAs(createByteBuffer(new byte[]{1, 2}));

        try {
            initialize(Raw.byteBufferAssertion(), value).isNotSameAs(value);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void positionTest() {
        ByteBuffer buffer = createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3);
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
