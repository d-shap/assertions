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
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

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
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.longBufferAssertion(), new Object(), "Message");
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
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

        try {
            Raw.longBufferAssertion().contains(1L);
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).contains(1L);
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").contains(1L);
            Assertions.fail("Long buffer assertion test fail");
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

        try {
            Raw.longBufferAssertion().rewindAndContains(1L);
            Assertions.fail("Long buffer assertion test fail");
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

        try {
            Raw.longBufferAssertion().doesNotContain(1L);
            Assertions.fail("Long buffer assertion test fail");
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

        try {
            Raw.longBufferAssertion().rewindAndDoesNotContain(1L);
            Assertions.fail("Long buffer assertion test fail");
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

        try {
            Raw.longBufferAssertion().containsAll(1L);
            Assertions.fail("Long buffer assertion test fail");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAll();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAll();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
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
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAll(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAll(Arrays.asList(1L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAll(Arrays.asList(4L, 2L));

        try {
            Raw.longBufferAssertion().containsAll(new ArrayList<Long>());
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsAll(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsAll(new ArrayList<Long>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAll(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAll(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsAll(Arrays.asList(1L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1L, 2L]> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsAll(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAll(Arrays.asList(2L, 3L));
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

        try {
            Raw.longBufferAssertion().rewindAndContainsAll(1L);
            Assertions.fail("Long buffer assertion test fail");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAll();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAll();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
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
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAll(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAll(Arrays.asList(1L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAll(Arrays.asList(4L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsAll(Arrays.asList(1L, 2L));

        try {
            Raw.longBufferAssertion().rewindAndContainsAll(new ArrayList<Long>());
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsAll(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsAll(new ArrayList<Long>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAll(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAll(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsAll(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAll(Arrays.asList(2L, 3L));
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

        try {
            Raw.longBufferAssertion().containsAllInOrder(1L);
            Assertions.fail("Long buffer assertion test fail");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAllInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAllInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
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
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAllInOrder(Arrays.asList(1L, 3L, 4L));

        try {
            Raw.longBufferAssertion().containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsAllInOrder(new ArrayList<Long>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsAllInOrder(Arrays.asList(1L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1L, 2L]> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsAllInOrder(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAllInOrder(Arrays.asList(2L, 1L));
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

        try {
            Raw.longBufferAssertion().rewindAndContainsAllInOrder(1L);
            Assertions.fail("Long buffer assertion test fail");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAllInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAllInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
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
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAllInOrder(Arrays.asList(1L, 3L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsAllInOrder(Arrays.asList(1L, 2L));

        try {
            Raw.longBufferAssertion().rewindAndContainsAllInOrder(new ArrayList<Long>());
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(new ArrayList<Long>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsAllInOrder(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAllInOrder(Arrays.asList(2L, 1L));
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

        try {
            Raw.longBufferAssertion().containsExactly(1L);
            Assertions.fail("Long buffer assertion test fail");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1L, 2L]>");
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
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactly(Arrays.asList(1L, 2L, 3L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactly(Arrays.asList(1L, 3L, 2L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsExactly(new ArrayList<Long>());

        try {
            Raw.longBufferAssertion().containsExactly(new ArrayList<Long>());
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsExactly(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsExactly(new ArrayList<Long>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 1L, 3L, 2L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L}), "Message").containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
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

        try {
            Raw.longBufferAssertion().rewindAndContainsExactly(1L);
            Assertions.fail("Long buffer assertion test fail");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1L, 2L]>");
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
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactly(Arrays.asList(1L, 2L, 3L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactly(Arrays.asList(1L, 3L, 2L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsExactly(new ArrayList<Long>());
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));

        try {
            Raw.longBufferAssertion().rewindAndContainsExactly(new ArrayList<Long>());
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsExactly(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsExactly(new ArrayList<Long>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2L, 3L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1L, 1L, 3L, 2L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L}), "Message").rewindAndContainsExactly(Arrays.asList(1L, 1L, 3L, 2L));
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

        try {
            Raw.longBufferAssertion().containsExactlyInOrder(1L);
            Assertions.fail("Long buffer assertion test fail");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1L, 2L]>");
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
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsExactlyInOrder(new ArrayList<Long>());

        try {
            Raw.longBufferAssertion().containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<Long>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 3L, 1L, 4L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L}), "Message").containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
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

        try {
            Raw.longBufferAssertion().rewindAndContainsExactlyInOrder(1L);
            Assertions.fail("Long buffer assertion test fail");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1L, 2L]>");
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
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsExactlyInOrder(new ArrayList<Long>());
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));

        try {
            Raw.longBufferAssertion().rewindAndContainsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(new ArrayList<Long>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1L, 2L, 3L, 4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2L, 3L, 1L, 4L]> but was:<[1L, 2L, 3L, 4L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
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

        try {
            Raw.longBufferAssertion().containsAny(1L);
            Assertions.fail("Long buffer assertion test fail");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAny();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAny();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
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
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAny(Arrays.asList(2L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAny(Arrays.asList(2L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAny(Arrays.asList(4L, 1L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).containsAny(Arrays.asList(5L, 3L));

        try {
            Raw.longBufferAssertion().containsAny(new ArrayList<Long>());
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsAny(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsAny(new ArrayList<Long>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsAny(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsAny(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsAny(Arrays.asList(1L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1L, 3L]> but was:<[4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsAny(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3L, 4L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAny(Arrays.asList(3L, 4L));
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

        try {
            Raw.longBufferAssertion().rewindAndContainsAny(1L);
            Assertions.fail("Long buffer assertion test fail");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAny();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAny();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
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
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAny(Arrays.asList(2L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAny(Arrays.asList(2L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAny(Arrays.asList(4L, 1L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L})).rewindAndContainsAny(Arrays.asList(5L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsAny(Arrays.asList(1L, 3L));

        try {
            Raw.longBufferAssertion().rewindAndContainsAny(new ArrayList<Long>());
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsAny(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsAny(new ArrayList<Long>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsAny(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsAny(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsAny(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4L, 5L]> but was:<[1L, 2L, 3L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3L, 4L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAny(Arrays.asList(3L, 4L));
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

        try {
            Raw.longBufferAssertion().containsNone(1L);
            Assertions.fail("Long buffer assertion test fail");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsNone();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsNone();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
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
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsNone(Arrays.asList(3L, 7L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsNone(Arrays.asList(3L, 4L, 5L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsNone(Arrays.asList(1L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsNone(Arrays.asList(4L, 5L));

        try {
            Raw.longBufferAssertion().containsNone(new ArrayList<Long>());
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).containsNone(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").containsNone(new ArrayList<Long>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).containsNone(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").containsNone(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsNone(Arrays.asList(2L, 1L));
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

        try {
            Raw.longBufferAssertion().rewindAndContainsNone(1L);
            Assertions.fail("Long buffer assertion test fail");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsNone();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsNone();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
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
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsNone(Arrays.asList(3L, 7L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsNone(Arrays.asList(3L, 4L, 5L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsNone(Arrays.asList(4L, 5L));

        try {
            Raw.longBufferAssertion().rewindAndContainsNone(new ArrayList<Long>());
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).rewindAndContainsNone(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").rewindAndContainsNone(new ArrayList<Long>());
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).rewindAndContainsNone(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").rewindAndContainsNone(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsNone(Arrays.asList(1L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1L, 3L]> but was:<[1L, 2L, 3L, 4L, 5L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2L, 1L]> but was:<[1L, 2L]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toPositionTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition().isEqualTo(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition().isGreaterThan(2);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition().isLessThan(6);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).toPosition().isEqualTo(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).toPosition().isGreaterThan(0);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).toPosition().isLessThan(4);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toPosition().isEqualTo(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toPosition().isGreaterThan(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toPosition().isLessThan(5);

        try {
            Raw.longBufferAssertion().toPosition();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toPosition();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toPosition();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition()).isEqualTo(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toPosition()).isEqualTo(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition().isEqualTo(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toPosition().isEqualTo(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toPositionMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).toPosition(Matchers.equalTo(1));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).toPosition(Matchers.greaterThan(0));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).toPosition(Matchers.lessThan(2));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toPosition(Matchers.equalTo(3));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toPosition(Matchers.greaterThan(2));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toPosition(Matchers.lessThan(4));

        try {
            Raw.longBufferAssertion().toPosition(Matchers.equalTo(0));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toPosition(Matchers.equalTo(0));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toPosition(Matchers.equalTo(0));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toPosition(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toPosition(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toPosition(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").toPosition(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition(Matchers.equalTo(4));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toPosition(Matchers.equalTo(4));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasPositionTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasPosition(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).hasPosition(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).hasPosition(3);

        try {
            Raw.longBufferAssertion().hasPosition(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasPosition(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasPosition(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasPosition(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").hasPosition(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toLimitTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit().isEqualTo(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit().isGreaterThan(2);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit().isLessThan(6);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toLimit().isEqualTo(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toLimit().isGreaterThan(0);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toLimit().isLessThan(4);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toLimit().isEqualTo(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toLimit().isGreaterThan(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toLimit().isLessThan(5);

        try {
            Raw.longBufferAssertion().toLimit();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toLimit();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toLimit();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit()).isEqualTo(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toLimit()).isEqualTo(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit().isEqualTo(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toLimit().isEqualTo(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toLimitMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toLimit(Matchers.equalTo(1));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toLimit(Matchers.greaterThan(0));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toLimit(Matchers.lessThan(2));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toLimit(Matchers.equalTo(3));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toLimit(Matchers.greaterThan(2));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toLimit(Matchers.lessThan(4));

        try {
            Raw.longBufferAssertion().toLimit(Matchers.equalTo(0));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toLimit(Matchers.equalTo(0));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toLimit(Matchers.equalTo(0));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toLimit(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toLimit(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toLimit(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").toLimit(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit(Matchers.equalTo(4));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toLimit(Matchers.equalTo(4));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasLimitTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasLimit(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).hasLimit(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).hasLimit(3);

        try {
            Raw.longBufferAssertion().hasLimit(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasLimit(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasLimit(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasLimit(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").hasLimit(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toCapacityTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity().isEqualTo(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity().isGreaterThan(2);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity().isLessThan(6);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toCapacity().isEqualTo(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toCapacity().isGreaterThan(2);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toCapacity().isLessThan(6);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toCapacity().isEqualTo(5);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toCapacity().isGreaterThan(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toCapacity().isLessThan(7);

        try {
            Raw.longBufferAssertion().toCapacity();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toCapacity();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toCapacity();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity()).isEqualTo(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toCapacity()).isEqualTo(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity().isEqualTo(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toCapacity().isEqualTo(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toCapacityMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toCapacity(Matchers.equalTo(3));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toCapacity(Matchers.greaterThan(2));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toCapacity(Matchers.lessThan(4));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toCapacity(Matchers.equalTo(5));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toCapacity(Matchers.greaterThan(4));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toCapacity(Matchers.lessThan(6));

        try {
            Raw.longBufferAssertion().toCapacity(Matchers.equalTo(0));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toCapacity(Matchers.equalTo(0));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toCapacity(Matchers.equalTo(0));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toCapacity(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toCapacity(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toCapacity(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").toCapacity(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity(Matchers.equalTo(4));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toCapacity(Matchers.equalTo(4));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasCapacityTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasCapacity(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).hasCapacity(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).hasCapacity(5);

        try {
            Raw.longBufferAssertion().hasCapacity(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasCapacity(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasCapacity(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasCapacity(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").hasCapacity(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasPropertiesTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasProperties(3, 3, 3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).hasProperties(1, 3, 3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).hasProperties(3, 3, 5);

        try {
            Raw.longBufferAssertion().hasProperties(1, 1, 1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasProperties(1, 1, 1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasProperties(1, 1, 1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasProperties(4, 3, 3);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").hasProperties(4, 3, 3);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasProperties(3, 4, 3);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").hasProperties(3, 4, 3);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasProperties(3, 3, 4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").hasProperties(3, 3, 4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toRemainingTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toRemaining().isEqualTo(0);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toRemaining().isGreaterThan(-1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toRemaining().isLessThan(3);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 3)).toRemaining().isEqualTo(2);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 3)).toRemaining().isGreaterThan(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 3)).toRemaining().isLessThan(5);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 2, 5)).toRemaining().isEqualTo(0);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 2, 5)).toRemaining().isGreaterThan(-1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 2, 5)).toRemaining().isLessThan(3);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 2, 4, 5)).toRemaining().isEqualTo(2);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 2, 4, 5)).toRemaining().isGreaterThan(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 2, 4, 5)).toRemaining().isLessThan(5);

        try {
            Raw.longBufferAssertion().toRemaining();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRemaining();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRemaining();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3)).toRemaining()).isEqualTo(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3), "Message").toRemaining()).isEqualTo(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3)).toRemaining().isEqualTo(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3), "Message").toRemaining().isEqualTo(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toRemainingMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toRemaining(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toRemaining(Matchers.is(Matchers.greaterThan(-1)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toRemaining(Matchers.is(Matchers.lessThan(1)));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 3)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 3)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 3)).toRemaining(Matchers.lessThan(3));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 2, 5)).toRemaining(Matchers.equalTo(0));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 2, 5)).toRemaining(Matchers.greaterThan(-1));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 2, 5)).toRemaining(Matchers.lessThan(1));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 2, 4, 5)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 2, 4, 5)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 2, 4, 5)).toRemaining(Matchers.lessThan(3));

        try {
            Raw.longBufferAssertion().toRemaining(Matchers.equalTo(0));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRemaining(Matchers.equalTo(0));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRemaining(Matchers.equalTo(0));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRemaining(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRemaining(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toRemaining(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").toRemaining(null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3)).toRemaining(Matchers.equalTo(4));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3), "Message").toRemaining(Matchers.equalTo(4));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasRemainingTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasRemaining(0);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 3)).hasRemaining(2);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 2, 5)).hasRemaining(0);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 2, 4, 5)).hasRemaining(2);

        try {
            Raw.longBufferAssertion().hasRemaining(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasRemaining(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasRemaining(1);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3)).hasRemaining(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3), "Message").hasRemaining(4);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isDirectTest() {
        initialize(Raw.longBufferAssertion(), ByteBuffer.allocateDirect(12).asLongBuffer()).isDirect();

        try {
            Raw.longBufferAssertion().isDirect();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).isDirect();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").isDirect();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), ByteBuffer.allocate(12).asLongBuffer()).isDirect();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be direct.");
        }
        try {
            initialize(Raw.longBufferAssertion(), ByteBuffer.allocate(12).asLongBuffer(), "Message").isDirect();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be direct.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isNotDirectTest() {
        initialize(Raw.longBufferAssertion(), ByteBuffer.allocate(12).asLongBuffer()).isNotDirect();

        try {
            Raw.longBufferAssertion().isNotDirect();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).isNotDirect();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").isNotDirect();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), ByteBuffer.allocateDirect(12).asLongBuffer()).isNotDirect();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be direct.");
        }
        try {
            initialize(Raw.longBufferAssertion(), ByteBuffer.allocateDirect(12).asLongBuffer(), "Message").isNotDirect();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be direct.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isReadOnlyTest() {
        LongBuffer buffer = ByteBuffer.allocate(12).asLongBuffer();
        LongBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.longBufferAssertion(), readOnlyBuffer).isReadOnly();

        try {
            Raw.longBufferAssertion().isReadOnly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).isReadOnly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").isReadOnly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), buffer).isReadOnly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be read only.");
        }
        try {
            initialize(Raw.longBufferAssertion(), buffer, "Message").isReadOnly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be read only.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isNotReadOnlyTest() {
        LongBuffer buffer = ByteBuffer.allocate(12).asLongBuffer();
        LongBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.longBufferAssertion(), buffer).isNotReadOnly();

        try {
            Raw.longBufferAssertion().isNotReadOnly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).isNotReadOnly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").isNotReadOnly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), readOnlyBuffer).isNotReadOnly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be read only.");
        }
        try {
            initialize(Raw.longBufferAssertion(), readOnlyBuffer, "Message").isNotReadOnly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be read only.");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<[1L, 2L]> but was:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), value, "Message").isSameAs(createLongBuffer(new long[]{1L, 2L}));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<[1L, 2L]> but was:<[1L, 2L]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<[1L, 2L]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<[1L, 2L]>");
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
