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

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Arrays;

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
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[0]));

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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should match the assertion.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).contains(2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value. Expected:<2> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).contains(4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).contains(3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").contains(3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain the expected value. Expected:<3> but was:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContains(4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContains(3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContains(3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain the expected value. Expected:<3> but was:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).doesNotContain(2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).doesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").doesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndDoesNotContain(2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value. Expected:<2> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndDoesNotContain(2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndDoesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndDoesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAll(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsAll(1L, 3L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsAll(4L, 2L);

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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAll();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAll();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsAll(1L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsAll(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAll(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAll(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAll(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsAll(Arrays.asList(1L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsAll(Arrays.asList(4L, 2L));

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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAll(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAll(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsAll(Arrays.asList(1L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsAll(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAll(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsAll(1L, 3L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsAll(4L, 2L);
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAll();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAll();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsAll(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAll(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAll(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAll(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsAll(Arrays.asList(1L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsAll(Arrays.asList(4L, 2L));
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAll(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAll(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsAll(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsAllInOrder(1L, 3L, 4L);

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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAllInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsAllInOrder(1L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsAllInOrder(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAllInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsAllInOrder(Arrays.asList(1L, 3L, 4L));

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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsAllInOrder(Arrays.asList(1L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsAllInOrder(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(1L, 3L, 4L);
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAllInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsAllInOrder(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAllInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(Arrays.asList(1L, 3L, 4L));
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsAllInOrder(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactly(1L, 2L, 3L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactly(1L, 3L, 2L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[0])).containsExactly();

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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4}), "Message").containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1L, 2L, 3L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1L, 3L, 2L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[0])).containsExactly(new ArrayList<Long>());

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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactly(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4}), "Message").containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactly(1L, 2L, 3L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactly(1L, 3L, 2L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[0])).rewindAndContainsExactly();
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1L, 2L, 3L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1L, 3L, 2L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[0])).rewindAndContainsExactly(new ArrayList<Long>());
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactly(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactlyInOrder(1L, 2L, 3L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[0])).containsExactlyInOrder();

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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactlyInOrder(1L, 2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[0])).containsExactlyInOrder(new ArrayList<Long>());

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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder(1L, 2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[0])).rewindAndContainsExactlyInOrder();
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1L, 2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[0])).rewindAndContainsExactlyInOrder(new ArrayList<Long>());
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAny(2L, 3L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsAny(2L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsAny(4L, 1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsAny(5L, 3L);

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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAny();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAny();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsAny(1L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsAny(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAny(3L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAny(3L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAny(Arrays.asList(2L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsAny(Arrays.asList(2L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsAny(Arrays.asList(4L, 1L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).containsAny(Arrays.asList(5L, 3L));

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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAny(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAny(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).containsAny(Arrays.asList(1L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).containsAny(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyArrayTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAny(2L, 3L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsAny(2L, 4L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsAny(4L, 1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsAny(5L, 3L);
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAny();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAny();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsAny(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAny(3L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAny(3L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyIterableTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAny(Arrays.asList(2L, 3L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList(2L, 4L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList(4L, 1L));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList(5L, 3L));
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAny(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAny(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).rewindAndContainsAny(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsNone();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsNone();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsNone(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsNone(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsNone(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsNone(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).containsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").containsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsNone();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsNone();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsNone(1L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsNone(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsNone(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsNone(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsNone(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).rewindAndContainsNone(Arrays.asList(1L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).rewindAndContainsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should be null. Actual:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").isNull();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should be null. Actual:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same. Expected:<[1, 2]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), value, "Message").isSameAs(createLongBuffer(new long[]{1L, 2L}));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual and expected values should be the same. Expected:<[1, 2]> but was:<[1, 2]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different. Actual:<[1, 2]>");
        }
        try {
            initialize(Raw.longBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual and expected values should be different. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.longBufferAssertion(), null).asString(null));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.longBufferAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.longBufferAssertion(), null).asString(createLongBuffer(new long[]{1L, 2L, 3L}))).isEqualTo("[1, 2, 3]");
        Assertions.assertThat(initialize(Raw.longBufferAssertion(), null).asString(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}))).isEqualTo("[1, 2, 3, 4, 5]");
        Assertions.assertThat(initialize(Raw.longBufferAssertion(), null).asString(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 2))).isEqualTo("[3, 4, 5]");
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
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void listCapacityTest() {
        Assertions.assertThat(initialize(Raw.longBufferAssertion(), null).createList(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}), false), "elementData", Raw.objectArrayAssertion()).hasLength(5);
        Assertions.assertThat(initialize(Raw.longBufferAssertion(), null).createList(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), false), "elementData", Raw.objectArrayAssertion()).hasLength(2);
        Assertions.assertThat(initialize(Raw.longBufferAssertion(), null).createList(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), false), "elementData", Raw.objectArrayAssertion()).hasLength(3);
        Assertions.assertThat(initialize(Raw.longBufferAssertion(), null).createList(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 1, 3), false), "elementData", Raw.objectArrayAssertion()).hasLength(2);

        Assertions.assertThat(initialize(Raw.longBufferAssertion(), null).createList(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}), true), "elementData", Raw.objectArrayAssertion()).hasLength(5);
        Assertions.assertThat(initialize(Raw.longBufferAssertion(), null).createList(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), true), "elementData", Raw.objectArrayAssertion()).hasLength(5);
        Assertions.assertThat(initialize(Raw.longBufferAssertion(), null).createList(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), true), "elementData", Raw.objectArrayAssertion()).hasLength(3);
        Assertions.assertThat(initialize(Raw.longBufferAssertion(), null).createList(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 1, 3), true), "elementData", Raw.objectArrayAssertion()).hasLength(3);
    }

}
