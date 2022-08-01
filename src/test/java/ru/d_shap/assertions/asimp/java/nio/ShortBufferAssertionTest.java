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

import org.hamcrest.Matchers;
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 2, 2, 4)).isNotNull().isEmpty().isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}, 0, 0, 4)).isNotNull().isRewindAndEmpty().isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).isNotNull().isNullOrEmpty().isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).isNotNull().isRewindAndNullOrEmpty().isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().isNotEmpty().isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().isRewindAndNotEmpty().isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().contains(2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContains(2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().doesNotContain(3).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndDoesNotContain(3).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAll((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAll(1, 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAll(DataHelper.createIterable((short) 1, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAll(DataHelper.createIterable((short) 4, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAll(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsAll(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAll(DataHelper.<Short>createIterable());
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
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAll(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAll(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAll(DataHelper.createIterable((short) 1, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1s, 2s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAll(DataHelper.createIterable((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll(DataHelper.createIterable((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAll(DataHelper.createIterable((short) 2, (short) 3));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAll((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAll(1, 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAll(DataHelper.createIterable((short) 1, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAll(DataHelper.createIterable((short) 4, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAll(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAll(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAll(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAll(DataHelper.<Short>createIterable());
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
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAll(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAll(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll(DataHelper.createIterable((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll(DataHelper.createIterable((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAll(DataHelper.createIterable((short) 2, (short) 3));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAllInOrder((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAllInOrder(1, 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAllInOrder(DataHelper.createIterable((short) 1, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAllInOrder(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAllInOrder(DataHelper.<Short>createIterable());
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
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(DataHelper.createIterable((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder(DataHelper.createIterable((short) 1, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1s, 2s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder(DataHelper.createIterable((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAllInOrder(DataHelper.createIterable((short) 2, (short) 1));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAllInOrder((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAllInOrder(1, 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(DataHelper.createIterable((short) 1, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAllInOrder(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAllInOrder(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(DataHelper.<Short>createIterable());
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
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAllInOrder(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(DataHelper.createIterable((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder(DataHelper.createIterable((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAllInOrder(DataHelper.createIterable((short) 2, (short) 1));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsExactly((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsExactly(1, 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(DataHelper.createIterable((short) 1, (short) 3, (short) 2, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactly(DataHelper.<Short>createIterable());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsExactly(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsExactly(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactly(DataHelper.<Short>createIterable());
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
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(DataHelper.createIterable((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(DataHelper.createIterable((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactly(DataHelper.createIterable((short) 1, (short) 1, (short) 3, (short) 2));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsExactly((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsExactly(1, 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 3, (short) 2, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactly(DataHelper.<Short>createIterable());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsExactly(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactly(DataHelper.<Short>createIterable());
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
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(DataHelper.createIterable((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2s, 3s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1s, 1s, 3s, 2s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(DataHelper.createIterable((short) 1, (short) 1, (short) 3, (short) 2));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsExactlyInOrder((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsExactlyInOrder(1, 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsExactlyInOrder(DataHelper.<Short>createIterable());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsExactlyInOrder(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<Short>createIterable());
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
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(DataHelper.createIterable((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(DataHelper.createIterable((short) 2, (short) 3, (short) 1, (short) 4));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsExactlyInOrder((short) 1, (short) 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsExactlyInOrder(1, 2).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsExactlyInOrder(DataHelper.<Short>createIterable());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsExactlyInOrder(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(DataHelper.<Short>createIterable());
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
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1s, 2s, 3s, 4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2s, 3s, 1s, 4s]> but was:<[1s, 2s, 3s, 4s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(DataHelper.createIterable((short) 2, (short) 3, (short) 1, (short) 4));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAny((short) 2, (short) 3).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAny(2, 3).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny(DataHelper.createIterable((short) 2, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny(DataHelper.createIterable((short) 2, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny(DataHelper.createIterable((short) 4, (short) 1));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny(DataHelper.createIterable((short) 5, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsAny(DataHelper.createIterable((short) 2, (short) 3)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsAny(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsAny(DataHelper.<Short>createIterable());
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
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsAny(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsAny(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAny(DataHelper.createIterable((short) 1, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1s, 3s]> but was:<[4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAny(DataHelper.createIterable((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny(DataHelper.createIterable((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAny(DataHelper.createIterable((short) 3, (short) 4));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAny((short) 2, (short) 3).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAny(2, 3).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny(DataHelper.createIterable((short) 2, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny(DataHelper.createIterable((short) 2, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny(DataHelper.createIterable((short) 4, (short) 1));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny(DataHelper.createIterable((short) 5, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAny(DataHelper.createIterable((short) 1, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsAny(DataHelper.createIterable((short) 2, (short) 3)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsAny(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsAny(DataHelper.<Short>createIterable());
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
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsAny(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsAny(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny(DataHelper.createIterable((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4s, 5s]> but was:<[1s, 2s, 3s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny(DataHelper.createIterable((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3s, 4s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAny(DataHelper.createIterable((short) 3, (short) 4));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsNone((short) 3, (short) 7).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsNone(3, 7).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(DataHelper.createIterable((short) 3, (short) 7));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(DataHelper.createIterable((short) 3, (short) 4, (short) 5));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsNone(DataHelper.createIterable((short) 1, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsNone(DataHelper.createIterable((short) 4, (short) 5));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().containsNone(DataHelper.createIterable((short) 3, (short) 7)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().containsNone(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").containsNone(DataHelper.<Short>createIterable());
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
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).containsNone(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").containsNone(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsNone(DataHelper.createIterable((short) 2, (short) 1));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsNone((short) 3, (short) 7).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsNone(3, 7).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(DataHelper.createIterable((short) 3, (short) 7));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(DataHelper.createIterable((short) 3, (short) 4, (short) 5));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsNone(DataHelper.createIterable((short) 4, (short) 5));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().rewindAndContainsNone(DataHelper.createIterable((short) 3, (short) 7)).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().rewindAndContainsNone(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").rewindAndContainsNone(DataHelper.<Short>createIterable());
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
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{})).rewindAndContainsNone(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{}), "Message").rewindAndContainsNone(DataHelper.<Short>createIterable());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone(DataHelper.createIterable((short) 1, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1s, 3s]> but was:<[1s, 2s, 3s, 4s, 5s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(DataHelper.createIterable((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2s, 1s]> but was:<[1s, 2s]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsNone(DataHelper.createIterable((short) 2, (short) 1));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString().isEqualTo("00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString().isEqualTo("000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toHexString().isEqualTo("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 2)).toHexString().isEqualTo("0000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString().isEqualTo("00050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toHexString().isEqualTo("00010002");

        try {
            Raw.shortBufferAssertion().toHexString();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toHexString();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toHexString();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toHexString()).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toHexString()).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toHexString().isEqualTo("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toHexString().isEqualTo("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).toHexString().isEqualTo("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), "Message").toHexString().isEqualTo("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toHexStringPartTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 0).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 1).isEqualTo("0001");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 2).isEqualTo("00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(1, 1).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(1, 2).isEqualTo("0002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(2, 2).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString(0, 3).isEqualTo("000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString(2, 2).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString(2, 3).isEqualTo("0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toHexString(0, 4).isEqualTo("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 0).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 1).isEqualTo("0005");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 2).isEqualTo("00050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 1).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 2).isEqualTo("0000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(2, 2).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toHexString(0, 2).isEqualTo("00010002");

        try {
            Raw.shortBufferAssertion().toHexString(0, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toHexString(0, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toHexString(0, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toHexString(-1, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toHexString(-1, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(-1, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(-1, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(-1, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(-1, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(0, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(3, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(3, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(1, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(1, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 0)).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(0, 0)).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toHexString(1, 2).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toHexString(1, 2).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4)).toHexString(1, 3).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00030004>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4), "Message").toHexString(1, 3).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00030004>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(Matchers.is(Matchers.equalTo("00010002")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString(Matchers.is(Matchers.equalTo("000ffffd0007")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toHexString(Matchers.is(Matchers.equalTo("006300050000ffeb")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 2)).toHexString(Matchers.is(Matchers.equalTo("0000ffeb")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(Matchers.is(Matchers.equalTo("00050000")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toHexString(Matchers.is(Matchers.equalTo("00010002"))).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().toHexString(Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toHexString(Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toHexString(Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toHexString(Matchers.equalTo("00030004"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"00040005\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toHexString(Matchers.equalTo("00030004"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"00040005\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).toHexString(Matchers.equalTo("00030004"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"000100020003\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), "Message").toHexString(Matchers.equalTo("00030004"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"000100020003\"");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toHexStringPartMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 1, Matchers.is(Matchers.equalTo("0001")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 2, Matchers.is(Matchers.equalTo("00010002")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(1, 2, Matchers.is(Matchers.equalTo("0002")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString(0, 3, Matchers.is(Matchers.equalTo("000ffffd0007")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString(2, 3, Matchers.is(Matchers.equalTo("0007")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toHexString(0, 4, Matchers.is(Matchers.equalTo("006300050000ffeb")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 1, Matchers.is(Matchers.equalTo("0005")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 2, Matchers.is(Matchers.equalTo("00050000")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 2, Matchers.is(Matchers.equalTo("0000")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toHexString(0, 2, Matchers.is(Matchers.equalTo("00010002"))).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 3, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(0, 3, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 0, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(0, 0, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toHexString(1, 2, Matchers.equalTo("00000000"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\nExpected: \"00000000\"\n     but: was \"0005\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toHexString(1, 2, Matchers.equalTo("00000000"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\nExpected: \"00000000\"\n     but: was \"0005\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4)).toHexString(1, 3, Matchers.equalTo("00000000"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\nExpected: \"00000000\"\n     but: was \"00030004\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4), "Message").toHexString(1, 3, Matchers.equalTo("00000000"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\nExpected: \"00000000\"\n     but: was \"00030004\"");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString().isEqualTo("00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString().isEqualTo("000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toRewindAndHexString().isEqualTo("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 2)).toRewindAndHexString().isEqualTo("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString().isEqualTo("006300050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toRewindAndHexString().isEqualTo("00010002");

        try {
            Raw.shortBufferAssertion().toRewindAndHexString();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndHexString();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndHexString();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString()).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString()).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString().isEqualTo("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00010002000300040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString().isEqualTo("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00010002000300040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).toRewindAndHexString().isEqualTo("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), "Message").toRewindAndHexString().isEqualTo("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringPartTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 0).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 1).isEqualTo("0001");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 2).isEqualTo("00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(1, 1).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(1, 2).isEqualTo("0002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString(0, 3).isEqualTo("000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString(2, 3).isEqualTo("0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toRewindAndHexString(0, 4).isEqualTo("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 0).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 1).isEqualTo("0063");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 2).isEqualTo("00630005");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 3).isEqualTo("006300050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 1).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 2).isEqualTo("0005");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 3).isEqualTo("00050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 3).isEqualTo("0000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(3, 3).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toRewindAndHexString(0, 2).isEqualTo("00010002");

        try {
            Raw.shortBufferAssertion().toRewindAndHexString(0, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndHexString(0, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndHexString(0, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndHexString(-1, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndHexString(-1, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(-1, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(-1, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(-1, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(-1, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(0, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(3, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(3, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(1, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(1, 0);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 0)).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(0, 0)).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString(1, 2).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0002>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString(1, 2).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0002>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4)).toRewindAndHexString(1, 3).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00020003>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4), "Message").toRewindAndHexString(1, 3).isEqualTo("00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00020003>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(Matchers.is(Matchers.equalTo("00010002")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString(Matchers.is(Matchers.equalTo("000ffffd0007")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toRewindAndHexString(Matchers.is(Matchers.equalTo("006300050000ffeb")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 2)).toRewindAndHexString(Matchers.is(Matchers.equalTo("006300050000ffeb")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(Matchers.is(Matchers.equalTo("006300050000")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toRewindAndHexString(Matchers.is(Matchers.equalTo("00010002"))).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString(Matchers.equalTo("00030004"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"00010002000300040005\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString(Matchers.equalTo("00030004"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"00010002000300040005\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).toRewindAndHexString(Matchers.equalTo("00030004"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"000100020003\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), "Message").toRewindAndHexString(Matchers.equalTo("00030004"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"000100020003\"");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringPartMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 1, Matchers.is(Matchers.equalTo("0001")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("00010002")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(1, 2, Matchers.is(Matchers.equalTo("0002")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString(0, 3, Matchers.is(Matchers.equalTo("000ffffd0007")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString(2, 3, Matchers.is(Matchers.equalTo("0007")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toRewindAndHexString(0, 4, Matchers.is(Matchers.equalTo("006300050000ffeb")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 1, Matchers.is(Matchers.equalTo("0063")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("00630005")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 3, Matchers.is(Matchers.equalTo("006300050000")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 2, Matchers.is(Matchers.equalTo("0005")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 3, Matchers.is(Matchers.equalTo("00050000")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 3, Matchers.is(Matchers.equalTo("0000")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(3, 3, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("00010002"))).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 3, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(0, 3, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 0, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(0, 0, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString(1, 2, Matchers.equalTo("00000000"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\nExpected: \"00000000\"\n     but: was \"0002\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString(1, 2, Matchers.equalTo("00000000"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\nExpected: \"00000000\"\n     but: was \"0002\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4)).toRewindAndHexString(1, 3, Matchers.equalTo("00000000"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\nExpected: \"00000000\"\n     but: was \"00020003\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4), "Message").toRewindAndHexString(1, 3, Matchers.equalTo("00000000"));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\nExpected: \"00000000\"\n     but: was \"00020003\"");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString("00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasHexString("000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).hasHexString("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 2)).hasHexString("0000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasHexString("00050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().hasHexString("00010002").isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasHexString("");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasHexString("");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasHexString("");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).hasHexString("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").hasHexString("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).hasHexString("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), "Message").hasHexString("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasHexStringPartTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(0, 0, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(0, 1, "0001");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(0, 2, "00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(1, 1, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(1, 2, "0002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(2, 2, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasHexString(0, 3, "000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasHexString(2, 2, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasHexString(2, 3, "0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).hasHexString(0, 4, "006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasHexString(0, 0, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasHexString(0, 1, "0005");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasHexString(0, 2, "00050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasHexString(1, 1, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasHexString(1, 2, "0000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasHexString(2, 2, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().hasHexString(0, 2, "00010002").isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasHexString(0, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasHexString(0, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasHexString(0, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasHexString(-1, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasHexString(-1, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(-1, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(-1, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(-1, 3, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(-1, 3, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(0, 3, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(0, 3, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(3, 3, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(3, 3, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(1, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(1, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(0, 3, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(0, 3, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(0, 0, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(0, 0, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).hasHexString(1, 2, "00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").hasHexString(1, 2, "00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4)).hasHexString(1, 3, "00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00030004>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4), "Message").hasHexString(1, 3, "00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00030004>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndHexStringTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString("00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasRewindAndHexString("000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).hasRewindAndHexString("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 2)).hasRewindAndHexString("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString("006300050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().hasRewindAndHexString("00010002").isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasRewindAndHexString("");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasRewindAndHexString("");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasRewindAndHexString("");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasRewindAndHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasRewindAndHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).hasRewindAndHexString("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00010002000300040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").hasRewindAndHexString("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00010002000300040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).hasRewindAndHexString("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), "Message").hasRewindAndHexString("00030004");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndHexStringPartTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(0, 0, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(0, 1, "0001");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(0, 2, "00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(1, 1, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(1, 2, "0002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(2, 2, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasRewindAndHexString(0, 3, "000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasRewindAndHexString(2, 2, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasRewindAndHexString(2, 3, "0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).hasRewindAndHexString(0, 4, "006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 0, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 1, "0063");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 2, "00630005");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 3, "006300050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(1, 1, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(1, 2, "0005");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(1, 3, "00050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(2, 2, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(2, 3, "0000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(3, 3, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().hasRewindAndHexString(0, 2, "00010002").isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasRewindAndHexString(0, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasRewindAndHexString(0, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasRewindAndHexString(0, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasRewindAndHexString(-1, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasRewindAndHexString(-1, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(-1, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(-1, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(-1, 3, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(-1, 3, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(0, 3, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(0, 3, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(3, 3, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(3, 3, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(1, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(1, 0, "");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(0, 3, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(0, 3, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(0, 0, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(0, 0, null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).hasRewindAndHexString(1, 2, "00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0002>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").hasRewindAndHexString(1, 2, "00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0002>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4)).hasRewindAndHexString(1, 3, "00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00020003>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4), "Message").hasRewindAndHexString(1, 3, "00000000");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00020003>");
        }
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

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).isNotNull().toPosition().isEqualTo(3);

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

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).isNotNull().toPosition(Matchers.is(Matchers.equalTo(3))).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).isNotNull().hasPosition(3).isInstanceOf(ShortBuffer.class);

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

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).isNotNull().toLimit().isEqualTo(3);

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

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).isNotNull().toLimit(Matchers.is(Matchers.equalTo(3))).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).isNotNull().hasLimit(3).isInstanceOf(ShortBuffer.class);

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

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).isNotNull().toCapacity().isEqualTo(3);

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

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).isNotNull().toCapacity(Matchers.is(Matchers.equalTo(3))).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).isNotNull().hasCapacity(3).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).isNotNull().hasProperties(3, 3, 3).isInstanceOf(ShortBuffer.class);

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

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).isNotNull().toRemaining().isEqualTo(0);

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

        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).isNotNull().toRemaining(Matchers.is(Matchers.equalTo(0))).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3}, 3)).isNotNull().hasRemaining(0).isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), ByteBuffer.allocateDirect(12).asShortBuffer()).isNotNull().isDirect().isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), ByteBuffer.allocate(12).asShortBuffer()).isNotNull().isNotDirect().isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), readOnlyBuffer).isNotNull().isReadOnly().isInstanceOf(ShortBuffer.class);

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
        initialize(Raw.shortBufferAssertion(), buffer).isNotNull().isNotReadOnly().isInstanceOf(ShortBuffer.class);

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
