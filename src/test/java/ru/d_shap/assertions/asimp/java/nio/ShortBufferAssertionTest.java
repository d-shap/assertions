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
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ShortBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortBufferAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ShortBufferAssertionTest() {
        super();
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}));

        try {
            initializeWithRawActual(Raw.shortBufferAssertion(), new Object());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.nio.ShortBuffer> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.shortBufferAssertion(), new Object(), "Message");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.nio.ShortBuffer> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).isEmpty();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 2)).isEmpty();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 2, 2, 4)).isEmpty();

        try {
            Raw.shortBufferAssertion().isEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).isEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").isEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}, 0, 4, 4)).isEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[0s, 0s, 0s, 0s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).isEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").isEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isRewindAndEmptyTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).isRewindAndEmpty();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 0, 0)).isRewindAndEmpty();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 0, 0, 4)).isRewindAndEmpty();

        try {
            Raw.shortBufferAssertion().isRewindAndEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).isRewindAndEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").isRewindAndEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}, 0, 4, 4)).isRewindAndEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[0s, 0s, 0s, 0s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isRewindAndEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).isRewindAndEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").isRewindAndEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).isNullOrEmpty();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 2)).isNullOrEmpty();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 2, 2, 4)).isNullOrEmpty();
        initialize(Raw.shortBufferAssertion(), null).isNullOrEmpty();

        try {
            Raw.shortBufferAssertion().isNullOrEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}, 0, 4, 4)).isNullOrEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[0s, 0s, 0s, 0s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNullOrEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).isNullOrEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").isNullOrEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isRewindAndNullOrEmptyTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).isRewindAndNullOrEmpty();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 0, 0)).isRewindAndNullOrEmpty();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 0, 0, 4)).isRewindAndNullOrEmpty();
        initialize(Raw.shortBufferAssertion(), null).isRewindAndNullOrEmpty();

        try {
            Raw.shortBufferAssertion().isRewindAndNullOrEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}, 0, 4, 4)).isRewindAndNullOrEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[0s, 0s, 0s, 0s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isRewindAndNullOrEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).isRewindAndNullOrEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").isRewindAndNullOrEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotEmpty();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).isNotEmpty();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}, 0, 4, 4)).isNotEmpty();

        try {
            Raw.shortBufferAssertion().isNotEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).isNotEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).isNotEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 2)).isNotEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 2, 2, 4)).isNotEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 2, 2, 4), "Message").isNotEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isRewindAndNotEmptyTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isRewindAndNotEmpty();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).isRewindAndNotEmpty();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}, 0, 4, 4)).isRewindAndNotEmpty();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 2)).isRewindAndNotEmpty();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 2, 2, 4)).isRewindAndNotEmpty();

        try {
            Raw.shortBufferAssertion().isRewindAndNotEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).isRewindAndNotEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").isRewindAndNotEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).isRewindAndNotEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").isRewindAndNotEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).contains(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).contains(2);

        try {
            Raw.shortBufferAssertion().contains(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).contains(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").contains(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).contains(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<2s> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).contains(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4s> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).contains(3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3s> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").contains(3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3s> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContains(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContains(2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContains(2);

        try {
            Raw.shortBufferAssertion().rewindAndContains(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContains(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContains(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContains(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4s> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContains(3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3s> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContains(3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3s> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).doesNotContain(3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).doesNotContain(2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).doesNotContain(5);

        try {
            Raw.shortBufferAssertion().doesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).doesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").doesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).doesNotContain(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2s> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).doesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1s> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").doesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1s> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndDoesNotContain(3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndDoesNotContain(5);

        try {
            Raw.shortBufferAssertion().rewindAndDoesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndDoesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndDoesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndDoesNotContain(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2s> but was:<[1s, 2s, 3s, 4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndDoesNotContain(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2s> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndDoesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1s> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndDoesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1s> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAllArrayShortTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll((short) 1, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAll((short) 1, (short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAll((short) 4, (short) 2);

        try {
            Raw.shortBufferAssertion().containsAll((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAll((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAll();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAll();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAll((short) 1, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1s, 2s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAll((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAllArrayIntTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll(1, 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAll(1, 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAll(4, 2);

        try {
            Raw.shortBufferAssertion().containsAll(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAll(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAll(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAll(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAll(1, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1s, 2s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAll(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll(Arrays.asList((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAll(Arrays.asList((short) 1, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAll(Arrays.asList((short) 4, (short) 2));

        try {
            Raw.shortBufferAssertion().containsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAll(Arrays.asList((short) 1, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1s, 2s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAll(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllArrayShortTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll((short) 1, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAll((short) 1, (short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAll((short) 4, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAll((short) 1, (short) 2);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAll((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAll((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAll();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAll();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllArrayIntTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll(1, 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAll(1, 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAll(4, 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAll(1, 2);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAll(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAll(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAll(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAll(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll(Arrays.asList((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAll(Arrays.asList((short) 1, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAll(Arrays.asList((short) 4, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAll(Arrays.asList((short) 1, (short) 2));

        try {
            Raw.shortBufferAssertion().rewindAndContainsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayShortTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder((short) 1, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAllInOrder((short) 1, (short) 3, (short) 4);

        try {
            Raw.shortBufferAssertion().containsAllInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAllInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAllInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAllInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder((short) 1, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1s, 2s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayIntTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(1, 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAllInOrder(1, 3, 4);

        try {
            Raw.shortBufferAssertion().containsAllInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAllInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAllInOrder(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAllInOrder(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder(1, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1s, 2s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(Arrays.asList((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAllInOrder(Arrays.asList((short) 1, (short) 3, (short) 4));

        try {
            Raw.shortBufferAssertion().containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder(Arrays.asList((short) 1, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1s, 2s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderArrayShortTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder((short) 1, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAllInOrder((short) 1, (short) 3, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAllInOrder((short) 1, (short) 2);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAllInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAllInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAllInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderArrayIntTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(1, 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(1, 3, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAllInOrder(1, 2);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAllInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAllInOrder(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAllInOrder(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(Arrays.asList((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(Arrays.asList((short) 1, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAllInOrder(Arrays.asList((short) 1, (short) 2));

        try {
            Raw.shortBufferAssertion().rewindAndContainsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsExactlyArrayShortTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly((short) 1, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly((short) 1, (short) 2, (short) 3, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly((short) 1, (short) 3, (short) 2, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactly();

        try {
            Raw.shortBufferAssertion().containsExactly((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactly((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsExactlyArrayIntTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(1, 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(1, 2, 3, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(1, 3, 2, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactly(new int[]{});

        try {
            Raw.shortBufferAssertion().containsExactly(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactly(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(Arrays.asList((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(Arrays.asList((short) 1, (short) 3, (short) 2, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactly(new ArrayList<Short>());

        try {
            Raw.shortBufferAssertion().containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyArrayShortTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly((short) 1, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly((short) 1, (short) 3, (short) 2, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactly();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);

        try {
            Raw.shortBufferAssertion().rewindAndContainsExactly((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactly((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyArrayIntTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(1, 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 2, 3, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 3, 2, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactly(new int[]{});
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactly(1, 2, 3, 4, 5);

        try {
            Raw.shortBufferAssertion().rewindAndContainsExactly(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactly(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 3, (short) 2, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactly(new ArrayList<Short>());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));

        try {
            Raw.shortBufferAssertion().rewindAndContainsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayShortTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder((short) 1, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactlyInOrder();

        try {
            Raw.shortBufferAssertion().containsExactlyInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactlyInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder((short) 1, (short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayIntTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(1, 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactlyInOrder(new int[]{});

        try {
            Raw.shortBufferAssertion().containsExactlyInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactlyInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(1, 2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactlyInOrder(new ArrayList<Short>());

        try {
            Raw.shortBufferAssertion().containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderArrayShortTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder((short) 1, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactlyInOrder();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);

        try {
            Raw.shortBufferAssertion().rewindAndContainsExactlyInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderArrayIntTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(1, 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactlyInOrder(new int[]{});
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);

        try {
            Raw.shortBufferAssertion().rewindAndContainsExactlyInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1, 2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(Arrays.asList((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactlyInOrder(new ArrayList<Short>());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));

        try {
            Raw.shortBufferAssertion().rewindAndContainsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAnyArrayShortTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny((short) 2, (short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny((short) 2, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny((short) 4, (short) 1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny((short) 5, (short) 3);

        try {
            Raw.shortBufferAssertion().containsAny((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAny((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAny();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAny();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAny((short) 1, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1s, 3s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAny((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAnyArrayIntTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny(2, 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny(2, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny(4, 1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny(5, 3);

        try {
            Raw.shortBufferAssertion().containsAny(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAny(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAny(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAny(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAny(1, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1s, 3s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAny(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny(Arrays.asList((short) 2, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny(Arrays.asList((short) 2, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny(Arrays.asList((short) 4, (short) 1));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny(Arrays.asList((short) 5, (short) 3));

        try {
            Raw.shortBufferAssertion().containsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAny(Arrays.asList((short) 1, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1s, 3s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAny(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyArrayShortTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny((short) 2, (short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny((short) 2, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny((short) 4, (short) 1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny((short) 5, (short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAny((short) 1, (short) 3);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAny((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAny((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAny();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAny();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyArrayIntTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny(2, 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny(2, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny(4, 1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny(5, 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAny(1, 3);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAny(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAny(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAny(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAny(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny(Arrays.asList((short) 2, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList((short) 2, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList((short) 4, (short) 1));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList((short) 5, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAny(Arrays.asList((short) 1, (short) 3));

        try {
            Raw.shortBufferAssertion().rewindAndContainsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsNoneArrayShortTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone((short) 3, (short) 7);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone((short) 3, (short) 4, (short) 5);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsNone((short) 1, (short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsNone((short) 4, (short) 5);

        try {
            Raw.shortBufferAssertion().containsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsNone();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsNone();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsNoneArrayIntTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(3, 7);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(3, 4, 5);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsNone(1, 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsNone(4, 5);

        try {
            Raw.shortBufferAssertion().containsNone(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsNone(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsNone(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsNone(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(Arrays.asList((short) 3, (short) 7));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(Arrays.asList((short) 3, (short) 4, (short) 5));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsNone(Arrays.asList((short) 1, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsNone(Arrays.asList((short) 4, (short) 5));

        try {
            Raw.shortBufferAssertion().containsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneArrayShortTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone((short) 3, (short) 7);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone((short) 3, (short) 4, (short) 5);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsNone((short) 4, (short) 5);

        try {
            Raw.shortBufferAssertion().rewindAndContainsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsNone();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsNone();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone((short) 1, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1s, 3s]> but was:<[1s, 2s, 3s, 4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneArrayIntTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(3, 7);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(3, 4, 5);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsNone(4, 5);

        try {
            Raw.shortBufferAssertion().rewindAndContainsNone(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsNone(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsNone(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsNone(new int[]{});
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone(1, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1s, 3s]> but was:<[1s, 2s, 3s, 4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(Arrays.asList((short) 3, (short) 7));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(Arrays.asList((short) 3, (short) 4, (short) 5));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsNone(Arrays.asList((short) 4, (short) 5));

        try {
            Raw.shortBufferAssertion().rewindAndContainsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone(Arrays.asList((short) 1, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1s, 3s]> but was:<[1s, 2s, 3s, 4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        // TODO
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toHexStringPartTest() {
        // TODO
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        // TODO
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toHexStringPartMatcherTest() {
        // TODO
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringTest() {
        // TODO
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringPartTest() {
        // TODO
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringMatcherTest() {
        // TODO
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringPartMatcherTest() {
        // TODO
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        // TODO
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasHexStringPartTest() {
        // TODO
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndHexStringTest() {
        // TODO
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndHexStringPartTest() {
        // TODO
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toPositionTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toPosition().isEqualTo(3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toPosition().isGreaterThan(2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toPosition().isLessThan(6);

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1)).toPosition().isEqualTo(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1)).toPosition().isGreaterThan(0);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1)).toPosition().isLessThan(4);

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toPosition().isEqualTo(3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toPosition().isGreaterThan(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toPosition().isLessThan(5);

        try {
            Raw.shortBufferAssertion().toPosition();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toPosition();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toPosition();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toPosition()).isEqualTo(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3), "Message").toPosition()).isEqualTo(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toPosition().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3), "Message").toPosition().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toPositionMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toPosition(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toPosition(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toPosition(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1)).toPosition(Matchers.equalTo(1));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1)).toPosition(Matchers.greaterThan(0));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1)).toPosition(Matchers.lessThan(2));

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toPosition(Matchers.equalTo(3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toPosition(Matchers.greaterThan(2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toPosition(Matchers.lessThan(4));

        try {
            Raw.shortBufferAssertion().toPosition(Matchers.equalTo(0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toPosition(Matchers.equalTo(0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toPosition(Matchers.equalTo(0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toPosition(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toPosition(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).toPosition(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").toPosition(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toPosition(Matchers.equalTo(4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3), "Message").toPosition(Matchers.equalTo(4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasPositionTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).hasPosition(3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1)).hasPosition(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).hasPosition(3);

        try {
            Raw.shortBufferAssertion().hasPosition(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasPosition(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasPosition(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).hasPosition(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3), "Message").hasPosition(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toLimitTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toLimit().isEqualTo(3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toLimit().isGreaterThan(2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toLimit().isLessThan(6);

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 1)).toLimit().isEqualTo(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 1)).toLimit().isGreaterThan(0);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 1)).toLimit().isLessThan(4);

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toLimit().isEqualTo(3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toLimit().isGreaterThan(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toLimit().isLessThan(5);

        try {
            Raw.shortBufferAssertion().toLimit();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toLimit();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toLimit();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toLimit()).isEqualTo(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3), "Message").toLimit()).isEqualTo(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toLimit().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3), "Message").toLimit().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toLimitMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toLimit(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toLimit(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toLimit(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 1)).toLimit(Matchers.equalTo(1));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 1)).toLimit(Matchers.greaterThan(0));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 1)).toLimit(Matchers.lessThan(2));

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toLimit(Matchers.equalTo(3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toLimit(Matchers.greaterThan(2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toLimit(Matchers.lessThan(4));

        try {
            Raw.shortBufferAssertion().toLimit(Matchers.equalTo(0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toLimit(Matchers.equalTo(0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toLimit(Matchers.equalTo(0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toLimit(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toLimit(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).toLimit(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").toLimit(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toLimit(Matchers.equalTo(4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3), "Message").toLimit(Matchers.equalTo(4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasLimitTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).hasLimit(3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 1)).hasLimit(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).hasLimit(3);

        try {
            Raw.shortBufferAssertion().hasLimit(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasLimit(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasLimit(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).hasLimit(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3), "Message").hasLimit(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toCapacityTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toCapacity().isEqualTo(3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toCapacity().isGreaterThan(2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toCapacity().isLessThan(6);

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 1)).toCapacity().isEqualTo(3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 1)).toCapacity().isGreaterThan(2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 1)).toCapacity().isLessThan(6);

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toCapacity().isEqualTo(5);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toCapacity().isGreaterThan(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toCapacity().isLessThan(7);

        try {
            Raw.shortBufferAssertion().toCapacity();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toCapacity();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toCapacity();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toCapacity()).isEqualTo(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3), "Message").toCapacity()).isEqualTo(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toCapacity().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3), "Message").toCapacity().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toCapacityMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toCapacity(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toCapacity(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toCapacity(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 1)).toCapacity(Matchers.equalTo(3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 1)).toCapacity(Matchers.greaterThan(2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 1)).toCapacity(Matchers.lessThan(4));

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toCapacity(Matchers.equalTo(5));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toCapacity(Matchers.greaterThan(4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).toCapacity(Matchers.lessThan(6));

        try {
            Raw.shortBufferAssertion().toCapacity(Matchers.equalTo(0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toCapacity(Matchers.equalTo(0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toCapacity(Matchers.equalTo(0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toCapacity(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toCapacity(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).toCapacity(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").toCapacity(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toCapacity(Matchers.equalTo(4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3), "Message").toCapacity(Matchers.equalTo(4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasCapacityTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).hasCapacity(3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 1)).hasCapacity(3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).hasCapacity(5);

        try {
            Raw.shortBufferAssertion().hasCapacity(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasCapacity(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasCapacity(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).hasCapacity(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3), "Message").hasCapacity(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasPropertiesTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).hasProperties(3, 3, 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1)).hasProperties(1, 3, 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 3, 5)).hasProperties(3, 3, 5);

        try {
            Raw.shortBufferAssertion().hasProperties(1, 1, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasProperties(1, 1, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasProperties(1, 1, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).hasProperties(4, 3, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3), "Message").hasProperties(4, 3, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).hasProperties(3, 4, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3), "Message").hasProperties(3, 4, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).hasProperties(3, 3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3), "Message").hasProperties(3, 3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRemainingTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toRemaining().isEqualTo(0);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toRemaining().isGreaterThan(-1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toRemaining().isLessThan(3);

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 3)).toRemaining().isEqualTo(2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 3)).toRemaining().isGreaterThan(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 3)).toRemaining().isLessThan(5);

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 2, 5)).toRemaining().isEqualTo(0);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 2, 5)).toRemaining().isGreaterThan(-1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 2, 5)).toRemaining().isLessThan(3);

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 2, 4, 5)).toRemaining().isEqualTo(2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 2, 4, 5)).toRemaining().isGreaterThan(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 2, 4, 5)).toRemaining().isLessThan(5);

        try {
            Raw.shortBufferAssertion().toRemaining();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRemaining();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRemaining();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 0, 3, 3)).toRemaining()).isEqualTo(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 0, 3, 3), "Message").toRemaining()).isEqualTo(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 0, 3, 3)).toRemaining().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 0, 3, 3), "Message").toRemaining().isEqualTo(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRemainingMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toRemaining(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toRemaining(Matchers.is(Matchers.greaterThan(-1)));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).toRemaining(Matchers.is(Matchers.lessThan(1)));

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 3)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 3)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 3)).toRemaining(Matchers.lessThan(3));

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 2, 5)).toRemaining(Matchers.equalTo(0));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 2, 5)).toRemaining(Matchers.greaterThan(-1));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 2, 5)).toRemaining(Matchers.lessThan(1));

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 2, 4, 5)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 2, 4, 5)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 2, 4, 5)).toRemaining(Matchers.lessThan(3));

        try {
            Raw.shortBufferAssertion().toRemaining(Matchers.equalTo(0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRemaining(Matchers.equalTo(0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRemaining(Matchers.equalTo(0));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRemaining(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRemaining(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).toRemaining(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").toRemaining(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 0, 3, 3)).toRemaining(Matchers.equalTo(4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 0, 3, 3), "Message").toRemaining(Matchers.equalTo(4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasRemainingTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).hasRemaining(0);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 1, 3)).hasRemaining(2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 4, 2, 5)).hasRemaining(0);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 2, 4, 5)).hasRemaining(2);

        try {
            Raw.shortBufferAssertion().hasRemaining(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasRemaining(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasRemaining(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 0, 3, 3)).hasRemaining(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 0, 3, 3), "Message").hasRemaining(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isDirectTest() {
        initialize(Raw.shortBufferAssertion(), ByteBuffer.allocateDirect(12).asShortBuffer()).isDirect();

        try {
            Raw.shortBufferAssertion().isDirect();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).isDirect();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").isDirect();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), ByteBuffer.allocate(12).asShortBuffer()).isDirect();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be direct.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), ByteBuffer.allocate(12).asShortBuffer(), "Message").isDirect();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be direct.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isNotDirectTest() {
        initialize(Raw.shortBufferAssertion(), ByteBuffer.allocate(12).asShortBuffer()).isNotDirect();

        try {
            Raw.shortBufferAssertion().isNotDirect();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).isNotDirect();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").isNotDirect();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), ByteBuffer.allocateDirect(12).asShortBuffer()).isNotDirect();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be direct.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), ByteBuffer.allocateDirect(12).asShortBuffer(), "Message").isNotDirect();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be direct.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isReadOnlyTest() {
        ShortBuffer buffer = ByteBuffer.allocate(12).asShortBuffer();
        ShortBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.shortBufferAssertion(), readOnlyBuffer).isReadOnly();

        try {
            Raw.shortBufferAssertion().isReadOnly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).isReadOnly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").isReadOnly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), buffer).isReadOnly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be read only.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), buffer, "Message").isReadOnly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be read only.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isNotReadOnlyTest() {
        ShortBuffer buffer = ByteBuffer.allocate(12).asShortBuffer();
        ShortBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.shortBufferAssertion(), buffer).isNotReadOnly();

        try {
            Raw.shortBufferAssertion().isNotReadOnly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).isNotReadOnly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").isNotReadOnly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), readOnlyBuffer).isNotReadOnly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be read only.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), readOnlyBuffer, "Message").isNotReadOnly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be read only.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.shortBufferAssertion(), null).isNull();

        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNull();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").isNull();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        ShortBuffer value = createShortBuffer(new short[]{1, 2});
        initialize(Raw.shortBufferAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.shortBufferAssertion(), value).isSameAs(createShortBuffer(new short[]{1, 2}));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[1s, 2s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), value, "Message").isSameAs(createShortBuffer(new short[]{1, 2}));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<[1s, 2s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        ShortBuffer value = createShortBuffer(new short[]{1, 2});
        initialize(Raw.shortBufferAssertion(), value).isNotSameAs(createShortBuffer(new short[]{1, 2}));

        try {
            initialize(Raw.shortBufferAssertion(), value).isNotSameAs(value);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void positionTest() {
        ShortBuffer buffer = createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3);
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
