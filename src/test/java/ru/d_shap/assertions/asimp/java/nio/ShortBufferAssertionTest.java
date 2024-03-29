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

import java.nio.ShortBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

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
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.nio.ShortBuffer> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.shortBufferAssertion(), new Object(), "Message");
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 2, 2, 4)).isNotNull().isEmpty().isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().isEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).isEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").isEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}, 0, 4, 4)).isEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[0s, 0s, 0s, 0s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).isEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").isEmpty();
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 0, 0, 4)).isNotNull().isRewindAndEmpty().isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().isRewindAndEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).isRewindAndEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").isRewindAndEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}, 0, 4, 4)).isRewindAndEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[0s, 0s, 0s, 0s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isRewindAndEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).isRewindAndEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").isRewindAndEmpty();
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).isNotNull().isNullOrEmpty().isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().isNullOrEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}, 0, 4, 4)).isNullOrEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[0s, 0s, 0s, 0s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNullOrEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).isNullOrEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").isNullOrEmpty();
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).isNotNull().isRewindAndNullOrEmpty().isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().isRewindAndNullOrEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}, 0, 4, 4)).isRewindAndNullOrEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[0s, 0s, 0s, 0s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isRewindAndNullOrEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1)).isRewindAndNullOrEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 1), "Message").isRewindAndNullOrEmpty();
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().isNotEmpty().isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().isNotEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).isNotEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").isNotEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).isNotEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 2)).isNotEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 2, 2, 4)).isNotEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 2, 2, 4), "Message").isNotEmpty();
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().isRewindAndNotEmpty().isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().isRewindAndNotEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).isRewindAndNotEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").isRewindAndNotEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).isRewindAndNotEmpty();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").isRewindAndNotEmpty();
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().contains(2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().contains(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).contains(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").contains(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).contains(2);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<2s> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).contains(4);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4s> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).contains(3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3s> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").contains(3);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContains(2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContains(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContains(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContains(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContains(4);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4s> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContains(3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3s> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContains(3);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().doesNotContain(3).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().doesNotContain(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).doesNotContain(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").doesNotContain(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).doesNotContain(2);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2s> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).doesNotContain(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1s> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").doesNotContain(1);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndDoesNotContain(3).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndDoesNotContain(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndDoesNotContain(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndDoesNotContain(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndDoesNotContain(2);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2s> but was:<[1s, 2s, 3s, 4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndDoesNotContain(2);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2s> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndDoesNotContain(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1s> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndDoesNotContain(1);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAll((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsAll((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAll((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAll((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAll((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAll((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAll();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAll();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAll((short) 1, (short) 2);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1s, 2s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAll((short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll((short) 2, (short) 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAll((short) 2, (short) 3);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAll(1, 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsAll(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAll(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAll((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAll((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAll((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAll(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAll(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAll(1, 2);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1s, 2s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAll(4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll(2, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAll(2, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAll(DataHelper.createIterable((short) 1, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAll(DataHelper.createIterable((short) 4, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAll(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsAll(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAll(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAll((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAll((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAll((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAll(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAll(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAll(DataHelper.createIterable((short) 1, (short) 2));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1s, 2s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAll(DataHelper.createIterable((short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll(DataHelper.createIterable((short) 2, (short) 3));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAll(DataHelper.createIterable((short) 2, (short) 3));
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAll((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAll((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAll((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAll((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAll((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAll((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAll();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAll();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll((short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll((short) 2, (short) 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAll((short) 2, (short) 3);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAll(1, 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAll(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAll(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAll((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAll((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAll((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAll(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAll(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll(4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll(2, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAll(2, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAll(DataHelper.createIterable((short) 1, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAll(DataHelper.createIterable((short) 4, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAll(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAll(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAll(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAll(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAll((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAll((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAll((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAll(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAll(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll(DataHelper.createIterable((short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll(DataHelper.createIterable((short) 2, (short) 3));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAll(DataHelper.createIterable((short) 2, (short) 3));
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAllInOrder((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsAllInOrder((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAllInOrder((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAllInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAllInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAllInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAllInOrder();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAllInOrder();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder((short) 2, (short) 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder((short) 1, (short) 2);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1s, 2s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder((short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder((short) 2, (short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAllInOrder((short) 2, (short) 1);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAllInOrder(1, 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsAllInOrder(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAllInOrder(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAllInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAllInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAllInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAllInOrder(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAllInOrder(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(2, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder(1, 2);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1s, 2s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder(4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(2, 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAllInOrder(2, 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAllInOrder(DataHelper.createIterable((short) 1, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAllInOrder(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAllInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAllInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAllInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(DataHelper.createIterable((short) 2, (short) 3));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder(DataHelper.createIterable((short) 1, (short) 2));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1s, 2s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder(DataHelper.createIterable((short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAllInOrder(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAllInOrder((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAllInOrder((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAllInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAllInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAllInOrder();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAllInOrder();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder((short) 2, (short) 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder((short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder((short) 2, (short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAllInOrder((short) 2, (short) 1);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAllInOrder(1, 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAllInOrder(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAllInOrder(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAllInOrder(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(2, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder(4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(2, 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAllInOrder(2, 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(DataHelper.createIterable((short) 1, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAllInOrder(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAllInOrder(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAllInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAllInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(DataHelper.createIterable((short) 2, (short) 3));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder(DataHelper.createIterable((short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAllInOrder(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsExactly((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsExactly((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactly((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactly((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactly((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsExactly((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly((short) 2, (short) 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsExactly(1, 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsExactly(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactly(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactly((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactly((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsExactly((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(2, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(1, 1, 3, 2);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(DataHelper.createIterable((short) 1, (short) 3, (short) 2, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactly(DataHelper.<Short>createIterable());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsExactly(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsExactly(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactly(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactly((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactly((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsExactly((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(DataHelper.createIterable((short) 2, (short) 3));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(DataHelper.createIterable((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactly(DataHelper.createIterable((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsExactly((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsExactly((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactly((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactly((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactly((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsExactly((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly((short) 2, (short) 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsExactly(1, 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsExactly(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactly(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactly((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactly((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsExactly((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(2, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 3, (short) 2, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactly(DataHelper.<Short>createIterable());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsExactly(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactly(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactly((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactly((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsExactly((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(DataHelper.createIterable((short) 2, (short) 3));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsExactlyInOrder((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsExactlyInOrder((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactlyInOrder((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactlyInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactlyInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsExactlyInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder((short) 2, (short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder((short) 1, (short) 2, (short) 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsExactlyInOrder(1, 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsExactlyInOrder(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactlyInOrder(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactlyInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(2, 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(1, 2, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactlyInOrder(DataHelper.<Short>createIterable());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsExactlyInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(DataHelper.createIterable((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(DataHelper.createIterable((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsExactlyInOrder((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsExactlyInOrder((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactlyInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsExactlyInOrder((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder((short) 2, (short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsExactlyInOrder(1, 2).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsExactlyInOrder(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(2, 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1, 2, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactlyInOrder(DataHelper.<Short>createIterable());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsExactlyInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAny((short) 2, (short) 3).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsAny((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAny((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAny((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAny((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAny((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAny();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAny();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAny((short) 1, (short) 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1s, 3s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAny((short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny((short) 3, (short) 4);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAny((short) 3, (short) 4);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAny(2, 3).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsAny(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAny(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAny((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAny((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAny((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAny(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAny(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAny(1, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1s, 3s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAny(4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny(3, 4);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAny(3, 4);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny(DataHelper.createIterable((short) 2, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny(DataHelper.createIterable((short) 2, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny(DataHelper.createIterable((short) 4, (short) 1));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny(DataHelper.createIterable((short) 5, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAny(DataHelper.createIterable((short) 2, (short) 3)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsAny(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAny(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAny((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAny((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAny((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAny(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAny(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAny(DataHelper.createIterable((short) 1, (short) 3));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1s, 3s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAny(DataHelper.createIterable((short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny(DataHelper.createIterable((short) 3, (short) 4));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAny(DataHelper.createIterable((short) 3, (short) 4));
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAny((short) 2, (short) 3).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAny((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAny((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAny((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAny((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAny((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAny();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAny();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny((short) 4, (short) 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny((short) 3, (short) 4);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAny((short) 3, (short) 4);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAny(2, 3).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAny(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAny(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAny((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAny((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAny((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAny(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAny(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny(4, 5);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny(3, 4);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAny(3, 4);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny(DataHelper.createIterable((short) 2, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny(DataHelper.createIterable((short) 2, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny(DataHelper.createIterable((short) 4, (short) 1));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny(DataHelper.createIterable((short) 5, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAny(DataHelper.createIterable((short) 1, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAny(DataHelper.createIterable((short) 2, (short) 3)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAny(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAny(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAny((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAny((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAny((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAny(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAny(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny(DataHelper.createIterable((short) 4, (short) 5));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny(DataHelper.createIterable((short) 3, (short) 4));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAny(DataHelper.createIterable((short) 3, (short) 4));
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsNone((short) 3, (short) 7).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsNone((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsNone((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsNone((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsNone((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsNone((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsNone();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsNone();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone((short) 2, (short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsNone((short) 2, (short) 1);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsNone(3, 7).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsNone(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsNone(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsNone((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsNone((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsNone((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsNone(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsNone(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(2, 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsNone(2, 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(DataHelper.createIterable((short) 3, (short) 7));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(DataHelper.createIterable((short) 3, (short) 4, (short) 5));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsNone(DataHelper.createIterable((short) 1, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsNone(DataHelper.createIterable((short) 4, (short) 5));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsNone(DataHelper.createIterable((short) 3, (short) 7)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsNone(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsNone(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsNone((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsNone((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsNone((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsNone(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsNone(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsNone(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsNone((short) 3, (short) 7).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsNone((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsNone((short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsNone((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsNone((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsNone((short[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsNone();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsNone();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone((short) 1, (short) 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1s, 3s]> but was:<[1s, 2s, 3s, 4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone((short) 2, (short) 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsNone((short) 2, (short) 1);
            Assertions.fail(ShortBufferAssertion.class);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsNone(3, 7).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsNone(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsNone(1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsNone((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsNone((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsNone((int[]) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsNone(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsNone(new int[]{});
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone(1, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1s, 3s]> but was:<[1s, 2s, 3s, 4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(2, 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsNone(2, 1);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneIterableTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(DataHelper.createIterable((short) 3, (short) 7));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(DataHelper.createIterable((short) 3, (short) 4, (short) 5));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsNone(DataHelper.createIterable((short) 4, (short) 5));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsNone(DataHelper.createIterable((short) 3, (short) 7)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsNone(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsNone(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsNone((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsNone((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsNone((Iterable<Short>) null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsNone(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsNone(DataHelper.<Short>createIterable());
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone(DataHelper.createIterable((short) 1, (short) 3));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1s, 3s]> but was:<[1s, 2s, 3s, 4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsNone(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
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
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").isNull();
            Assertions.fail(ShortBufferAssertion.class);
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
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[1s, 2s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), value, "Message").isSameAs(createShortBuffer(new short[]{1, 2}));
            Assertions.fail(ShortBufferAssertion.class);
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
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(ShortBufferAssertion.class);
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
