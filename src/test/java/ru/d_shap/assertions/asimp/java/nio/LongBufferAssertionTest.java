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

import java.nio.LongBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link LongBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongBufferAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongBufferAssertionTest() {
        super();
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}));

        try {
            initializeWithRawActual(Raw.longBufferAssertion(), new Object());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.nio.LongBuffer> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.longBufferAssertion(), new Object(), "Message");
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.nio.LongBuffer> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).isEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 2)).isEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 2, 2, 4)).isEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 2, 2, 4)).isNotNull().isEmpty().isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().isEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).isEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").isEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}, 0, 4, 4)).isEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[0L, 0L, 0L, 0L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1)).isEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1), "Message").isEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isRewindAndEmptyTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).isRewindAndEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 0, 0)).isRewindAndEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 0, 0, 4)).isRewindAndEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 0, 0, 4)).isNotNull().isRewindAndEmpty().isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().isRewindAndEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).isRewindAndEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").isRewindAndEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}, 0, 4, 4)).isRewindAndEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[0L, 0L, 0L, 0L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isRewindAndEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1)).isRewindAndEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1), "Message").isRewindAndEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).isNullOrEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 2)).isNullOrEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 2, 2, 4)).isNullOrEmpty();
        initialize(Raw.longBufferAssertion(), null).isNullOrEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).isNotNull().isNullOrEmpty().isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().isNullOrEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}, 0, 4, 4)).isNullOrEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[0L, 0L, 0L, 0L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNullOrEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1)).isNullOrEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1), "Message").isNullOrEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isRewindAndNullOrEmptyTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).isRewindAndNullOrEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 0, 0)).isRewindAndNullOrEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 0, 0, 4)).isRewindAndNullOrEmpty();
        initialize(Raw.longBufferAssertion(), null).isRewindAndNullOrEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).isNotNull().isRewindAndNullOrEmpty().isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().isRewindAndNullOrEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}, 0, 4, 4)).isRewindAndNullOrEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[0L, 0L, 0L, 0L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isRewindAndNullOrEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1)).isRewindAndNullOrEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1), "Message").isRewindAndNullOrEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1)).isNotEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}, 0, 4, 4)).isNotEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().isNotEmpty().isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().isNotEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).isNotEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).isNotEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 2)).isNotEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 2, 2, 4)).isNotEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 2, 2, 4), "Message").isNotEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isRewindAndNotEmptyTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isRewindAndNotEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1)).isRewindAndNotEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}, 0, 4, 4)).isRewindAndNotEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 2)).isRewindAndNotEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 2, 2, 4)).isRewindAndNotEmpty();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().isRewindAndNotEmpty().isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().isRewindAndNotEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).isRewindAndNotEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").isRewindAndNotEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).isRewindAndNotEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").isRewindAndNotEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).contains(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).contains(2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().contains(2L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().contains(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).contains(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").contains(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).contains(2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<2L> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).contains(4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4L> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).contains(3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3L> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").contains(3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3L> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContains(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContains(2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContains(2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().rewindAndContains(2L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().rewindAndContains(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContains(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContains(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContains(4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4L> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContains(3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3L> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContains(3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3L> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).doesNotContain(3L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).doesNotContain(2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).doesNotContain(5L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().doesNotContain(3L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().doesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).doesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").doesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).doesNotContain(2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2L> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).doesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1L> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").doesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1L> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndDoesNotContain(3L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndDoesNotContain(5L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().rewindAndDoesNotContain(3L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().rewindAndDoesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndDoesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndDoesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndDoesNotContain(2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2L> but was:<[1L, 2L, 3L, 4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndDoesNotContain(2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2L> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndDoesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1L> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndDoesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1L> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAll(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAll(1L, 3L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAll(4L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().containsAll(1L, 2L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().containsAll(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsAll(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsAll(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAll();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAll();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsAll(1L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1L, 2L]> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsAll(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAll(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAll(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAll(DataHelper.createIterable(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAll(DataHelper.createIterable(1L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAll(DataHelper.createIterable(4L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().containsAll(DataHelper.createIterable(1L, 2L)).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().containsAll(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsAll(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsAll(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAll(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAll(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsAll(DataHelper.createIterable(1L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1L, 2L]> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsAll(DataHelper.createIterable(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAll(DataHelper.createIterable(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAll(DataHelper.createIterable(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAll(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAll(1L, 3L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAll(4L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsAll(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().rewindAndContainsAll(1L, 2L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().rewindAndContainsAll(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsAll(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsAll(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAll();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAll();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsAll(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAll(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAll(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAll(DataHelper.createIterable(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAll(DataHelper.createIterable(1L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAll(DataHelper.createIterable(4L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsAll(DataHelper.createIterable(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().rewindAndContainsAll(DataHelper.createIterable(1L, 2L)).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().rewindAndContainsAll(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsAll(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsAll(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAll(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAll(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsAll(DataHelper.createIterable(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAll(DataHelper.createIterable(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAll(DataHelper.createIterable(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAllInOrder(1L, 3L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().containsAllInOrder(1L, 2L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().containsAllInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsAllInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsAllInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAllInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAllInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsAllInOrder(1L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1L, 2L]> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsAllInOrder(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAllInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(DataHelper.createIterable(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAllInOrder(DataHelper.createIterable(1L, 3L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().containsAllInOrder(DataHelper.createIterable(1L, 2L)).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().containsAllInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsAllInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsAllInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAllInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAllInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(DataHelper.createIterable(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsAllInOrder(DataHelper.createIterable(1L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1L, 2L]> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsAllInOrder(DataHelper.createIterable(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(DataHelper.createIterable(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAllInOrder(DataHelper.createIterable(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAllInOrder(1L, 3L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsAllInOrder(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().rewindAndContainsAllInOrder(1L, 2L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().rewindAndContainsAllInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsAllInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAllInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAllInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsAllInOrder(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAllInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(DataHelper.createIterable(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAllInOrder(DataHelper.createIterable(1L, 3L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsAllInOrder(DataHelper.createIterable(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().rewindAndContainsAllInOrder(DataHelper.createIterable(1L, 2L)).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().rewindAndContainsAllInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsAllInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAllInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAllInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(DataHelper.createIterable(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsAllInOrder(DataHelper.createIterable(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(DataHelper.createIterable(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAllInOrder(DataHelper.createIterable(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactly(1L, 2L, 3L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactly(1L, 3L, 2L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsExactly();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().containsExactly(1L, 2L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().containsExactly(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsExactly(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsExactly(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 1L, 3L, 2L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L}), "Message").containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1L, 1L, 3L, 2L]> but was:<[1L, 2L, 3L, 4L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly(DataHelper.createIterable(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactly(DataHelper.createIterable(1L, 2L, 3L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactly(DataHelper.createIterable(1L, 3L, 2L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsExactly(DataHelper.<Long>createIterable());
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().containsExactly(DataHelper.createIterable(1L, 2L)).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().containsExactly(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsExactly(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsExactly(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly(DataHelper.createIterable(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactly(DataHelper.createIterable(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsExactly(DataHelper.createIterable(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsExactly(DataHelper.createIterable(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactly(DataHelper.createIterable(1L, 1L, 3L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 1L, 3L, 2L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L}), "Message").containsExactly(DataHelper.createIterable(1L, 1L, 3L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1L, 1L, 3L, 2L]> but was:<[1L, 2L, 3L, 4L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactly(1L, 2L, 3L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactly(1L, 3L, 2L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsExactly();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsExactly(1L, 2L, 3L, 4L, 5L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().rewindAndContainsExactly(1L, 2L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().rewindAndContainsExactly(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsExactly(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsExactly(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 1L, 3L, 2L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L}), "Message").rewindAndContainsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1L, 1L, 3L, 2L]> but was:<[1L, 2L, 3L, 4L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly(DataHelper.createIterable(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactly(DataHelper.createIterable(1L, 2L, 3L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactly(DataHelper.createIterable(1L, 3L, 2L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsExactly(DataHelper.<Long>createIterable());
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsExactly(DataHelper.createIterable(1L, 2L, 3L, 4L, 5L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().rewindAndContainsExactly(DataHelper.createIterable(1L, 2L)).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().rewindAndContainsExactly(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsExactly(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsExactly(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly(DataHelper.createIterable(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactly(DataHelper.createIterable(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsExactly(DataHelper.createIterable(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactly(DataHelper.createIterable(1L, 1L, 3L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 1L, 3L, 2L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L}), "Message").rewindAndContainsExactly(DataHelper.createIterable(1L, 1L, 3L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1L, 1L, 3L, 2L]> but was:<[1L, 2L, 3L, 4L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactlyInOrder(1L, 2L, 3L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsExactlyInOrder();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().containsExactlyInOrder(1L, 2L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().containsExactlyInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsExactlyInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsExactlyInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactlyInOrder(1L, 2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 3L, 1L, 4L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L}), "Message").containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 3L, 1L, 4L]> but was:<[1L, 2L, 3L, 4L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(DataHelper.createIterable(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactlyInOrder(DataHelper.createIterable(1L, 2L, 3L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsExactlyInOrder(DataHelper.<Long>createIterable());
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().containsExactlyInOrder(DataHelper.createIterable(1L, 2L)).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().containsExactlyInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsExactlyInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(DataHelper.createIterable(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactlyInOrder(DataHelper.createIterable(1L, 2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactlyInOrder(DataHelper.createIterable(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsExactlyInOrder(DataHelper.createIterable(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsExactlyInOrder(DataHelper.createIterable(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactlyInOrder(DataHelper.createIterable(2L, 3L, 1L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 3L, 1L, 4L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L}), "Message").containsExactlyInOrder(DataHelper.createIterable(2L, 3L, 1L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 3L, 1L, 4L]> but was:<[1L, 2L, 3L, 4L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsExactlyInOrder();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().rewindAndContainsExactlyInOrder(1L, 2L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().rewindAndContainsExactlyInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsExactlyInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactlyInOrder(1L, 2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 3L, 1L, 4L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L}), "Message").rewindAndContainsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 3L, 1L, 4L]> but was:<[1L, 2L, 3L, 4L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1L, 2L, 3L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsExactlyInOrder(DataHelper.<Long>createIterable());
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1L, 2L, 3L, 4L, 5L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().rewindAndContainsExactlyInOrder(DataHelper.createIterable(1L, 2L)).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().rewindAndContainsExactlyInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsExactlyInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1L, 2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsExactlyInOrder(DataHelper.createIterable(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactlyInOrder(DataHelper.createIterable(2L, 3L, 1L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 3L, 1L, 4L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L}), "Message").rewindAndContainsExactlyInOrder(DataHelper.createIterable(2L, 3L, 1L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 3L, 1L, 4L]> but was:<[1L, 2L, 3L, 4L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAny(2L, 3L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAny(2L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAny(4L, 1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAny(5L, 3L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().containsAny(2L, 3L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().containsAny(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsAny(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsAny(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAny();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAny();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsAny(1L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1L, 3L]> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsAny(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAny(3L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3L, 4L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAny(3L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3L, 4L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAny(DataHelper.createIterable(2L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAny(DataHelper.createIterable(2L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAny(DataHelper.createIterable(4L, 1L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAny(DataHelper.createIterable(5L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().containsAny(DataHelper.createIterable(2L, 3L)).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().containsAny(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsAny(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsAny(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAny(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAny(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsAny(DataHelper.createIterable(1L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1L, 3L]> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsAny(DataHelper.createIterable(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAny(DataHelper.createIterable(3L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3L, 4L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAny(DataHelper.createIterable(3L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3L, 4L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAny(2L, 3L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAny(2L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAny(4L, 1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAny(5L, 3L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsAny(1L, 3L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().rewindAndContainsAny(2L, 3L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().rewindAndContainsAny(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsAny(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsAny(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAny();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAny();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsAny(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAny(3L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3L, 4L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAny(3L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3L, 4L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAny(DataHelper.createIterable(2L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAny(DataHelper.createIterable(2L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAny(DataHelper.createIterable(4L, 1L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAny(DataHelper.createIterable(5L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsAny(DataHelper.createIterable(1L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().rewindAndContainsAny(DataHelper.createIterable(2L, 3L)).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().rewindAndContainsAny(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsAny(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsAny(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAny(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAny(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsAny(DataHelper.createIterable(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAny(DataHelper.createIterable(3L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3L, 4L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAny(DataHelper.createIterable(3L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3L, 4L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsNone(3L, 7L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsNone(3L, 4L, 5L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsNone(1L, 3L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsNone(4L, 5L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().containsNone(3L, 7L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().containsNone(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsNone(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsNone(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsNone();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsNone();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsNone(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsNone(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsNone(DataHelper.createIterable(3L, 7L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsNone(DataHelper.createIterable(3L, 4L, 5L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsNone(DataHelper.createIterable(1L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsNone(DataHelper.createIterable(4L, 5L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().containsNone(DataHelper.createIterable(3L, 7L)).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().containsNone(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsNone(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsNone(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsNone(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsNone(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsNone(DataHelper.createIterable(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsNone(DataHelper.createIterable(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsNone(3L, 7L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsNone(3L, 4L, 5L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsNone(4L, 5L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().rewindAndContainsNone(3L, 7L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().rewindAndContainsNone(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsNone(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsNone(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsNone();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsNone();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsNone(1L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1L, 3L]> but was:<[1L, 2L, 3L, 4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsNone(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsNone(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsNone(DataHelper.createIterable(3L, 7L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsNone(DataHelper.createIterable(3L, 4L, 5L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsNone(DataHelper.createIterable(4L, 5L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().rewindAndContainsNone(DataHelper.createIterable(3L, 7L)).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().rewindAndContainsNone(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsNone(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsNone(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsNone(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsNone(DataHelper.<Long>createIterable());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsNone(DataHelper.createIterable(1L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1L, 3L]> but was:<[1L, 2L, 3L, 4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsNone(DataHelper.createIterable(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsNone(DataHelper.createIterable(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.longBufferAssertion(), null).isNull();

        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNull();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").isNull();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        LongBuffer value = createLongBuffer(new long[]{1L, 2L});
        initialize(Raw.longBufferAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.longBufferAssertion(), value).isSameAs(createLongBuffer(new long[]{1L, 2L}));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[1L, 2L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), value, "Message").isSameAs(createLongBuffer(new long[]{1L, 2L}));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<[1L, 2L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        LongBuffer value = createLongBuffer(new long[]{1L, 2L});
        initialize(Raw.longBufferAssertion(), value).isNotSameAs(createLongBuffer(new long[]{1L, 2L}));

        try {
            initialize(Raw.longBufferAssertion(), value).isNotSameAs(value);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void positionTest() {
        LongBuffer buffer = createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).contains(4L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContains(2L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).doesNotContain(2L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndDoesNotContain(0L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAll(4L, 5L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAll(2L, 5L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAllInOrder(4L, 5L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAllInOrder(2L, 5L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsExactly(4L, 5L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsExactly(1L, 2L, 3L, 4L, 5L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsExactlyInOrder(4L, 5L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAny(1L, 5L, 7L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAny(1L, 7L, 9L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsNone(1L, 9L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsNone(7L, 9L);
        Assertions.assertThat(buffer).hasPosition(3);
    }

}
