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

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link BufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class BufferAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public BufferAssertionTest() {
        super();
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[0])).isEmpty();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 2)).isEmpty();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 2, 2, 4)).isEmpty();

        try {
            new BufferAssertionImpl().isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[0], 0, 4, 4)).isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[0, 0, 0, 0]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 1)).isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 1), "Message").isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isRewindAndEmptyTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[0])).isRewindAndEmpty();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0, 0)).isRewindAndEmpty();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0, 0, 4)).isRewindAndEmpty();

        try {
            new BufferAssertionImpl().isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[0], 0, 4, 4)).isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[0, 0, 0, 0]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 1)).isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 1), "Message").isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[0])).isNullOrEmpty();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 2)).isNullOrEmpty();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 2, 2, 4)).isNullOrEmpty();
        initialize(new BufferAssertionImpl(), null).isNullOrEmpty();

        try {
            new BufferAssertionImpl().isNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[0], 0, 4, 4)).isNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[0, 0, 0, 0]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).isNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 1)).isNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 1), "Message").isNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isRewindAndNullOrEmptyTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[0])).isRewindAndNullOrEmpty();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0, 0)).isRewindAndNullOrEmpty();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0, 0, 4)).isRewindAndNullOrEmpty();
        initialize(new BufferAssertionImpl(), null).isRewindAndNullOrEmpty();

        try {
            new BufferAssertionImpl().isRewindAndNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[0], 0, 4, 4)).isRewindAndNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[0, 0, 0, 0]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).isRewindAndNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 1)).isRewindAndNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 1), "Message").isRewindAndNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).isNotEmpty();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 1)).isNotEmpty();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[0], 0, 4, 4)).isNotEmpty();

        try {
            new BufferAssertionImpl().isNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).isNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[0])).isNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 2)).isNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 2, 2, 4)).isNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 2, 2, 4), "Message").isNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isRewindAndNotEmptyTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).isRewindAndNotEmpty();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 1)).isRewindAndNotEmpty();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[0], 0, 4, 4)).isRewindAndNotEmpty();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 2)).isRewindAndNotEmpty();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 2, 2, 4)).isRewindAndNotEmpty();

        try {
            new BufferAssertionImpl().isRewindAndNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).isRewindAndNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[0])).isRewindAndNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[0]), "Message").isRewindAndNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0)).doContains(1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0)).doContains(2);

        try {
            new BufferAssertionImpl().doContains(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContains(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 1)).doContains(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<1> but was:<[2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0, 1)).doContains(2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[1]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0)).doContains(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0), "Message").doContains(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0)).doRewindAndContains(1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0)).doRewindAndContains(2);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 1)).doRewindAndContains(1);

        try {
            new BufferAssertionImpl().doRewindAndContains(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContains(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0, 1)).doRewindAndContains(2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[1]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0)).doRewindAndContains(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0), "Message").doRewindAndContains(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doDoesNotContainTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0)).doDoesNotContain(3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 1)).doDoesNotContain(1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0, 1)).doDoesNotContain(2);

        try {
            new BufferAssertionImpl().doDoesNotContain(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doDoesNotContain(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0)).doDoesNotContain(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0)).doDoesNotContain(2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0), "Message").doDoesNotContain(2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<2> but was:<[1, 2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndDoesNotContainTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0)).doRewindAndDoesNotContain(3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0, 1)).doRewindAndDoesNotContain(2);

        try {
            new BufferAssertionImpl().doRewindAndDoesNotContain(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndDoesNotContain(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0)).doRewindAndDoesNotContain(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 1)).doRewindAndDoesNotContain(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0)).doRewindAndDoesNotContain(2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2}, 0), "Message").doRewindAndDoesNotContain(2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<2> but was:<[1, 2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsAllArrayTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(1, 2);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(1, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(3, 1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(5, 1, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(3, 5, 4);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(3, 1, 4, 5, 2);

        try {
            new BufferAssertionImpl().doContainsAll(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsAll(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsAll((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsAll((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsAll();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(1, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(0, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[0, 1]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(1, 1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 1, 2]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doContainsAll(3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[3, 4]> but was:<[4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doContainsAll(3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}), "Message").doContainsAll(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsAllIterableTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(Arrays.asList(1, 2));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(Arrays.asList(1, 3));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(Arrays.asList(3, 1));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(Arrays.asList(5, 1, 3));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(Arrays.asList(3, 5, 4));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(Arrays.asList(3, 1, 4, 5, 2));

        try {
            new BufferAssertionImpl().doContainsAll(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsAll(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsAll((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsAll((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsAll(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(Arrays.asList(1, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(Arrays.asList(0, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[0, 1]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(Arrays.asList(1, 1, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 1, 2]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doContainsAll(Arrays.asList(3, 4));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[3, 4]> but was:<[4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doContainsAll(Arrays.asList(3, 4));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAll(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}), "Message").doContainsAll(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsAllArrayTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(1, 2);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(1, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(3, 1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(5, 1, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(3, 5, 4);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(3, 1, 4, 5, 2);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doRewindAndContainsAll(3, 4);

        try {
            new BufferAssertionImpl().doRewindAndContainsAll(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsAll(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsAll((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsAll((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsAll();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(1, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(0, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[0, 1]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(1, 1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 1, 2]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doRewindAndContainsAll(3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}), "Message").doRewindAndContainsAll(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsAllIterableTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(Arrays.asList(1, 2));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(Arrays.asList(1, 3));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(Arrays.asList(3, 1));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(Arrays.asList(5, 1, 3));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(Arrays.asList(3, 5, 4));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(Arrays.asList(3, 1, 4, 5, 2));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doRewindAndContainsAll(Arrays.asList(3, 4));

        try {
            new BufferAssertionImpl().doRewindAndContainsAll(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsAll(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsAll((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsAll((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsAll(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(Arrays.asList(1, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(Arrays.asList(0, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[0, 1]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(Arrays.asList(1, 1, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 1, 2]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doRewindAndContainsAll(Arrays.asList(3, 4));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAll(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}), "Message").doRewindAndContainsAll(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsAllInOrderArrayTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(1, 2);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(1, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(1, 3, 5);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(3, 4, 5);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 1, 1, 2, 2})).doContainsAllInOrder(1, 1, 1, 2, 2);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(1, 2, 3, 4, 5);

        try {
            new BufferAssertionImpl().doContainsAllInOrder(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsAllInOrder(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsAllInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsAllInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsAllInOrder();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(1, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(3, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 1]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 1, 1})).doContainsAllInOrder(1, 1, 1, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 1, 1, 1]> but was:<[1, 1, 1]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doContainsAllInOrder(3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 4]> but was:<[4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doContainsAllInOrder(3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}), "Message").doContainsAllInOrder(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsAllInOrderIterableTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(Arrays.asList(1, 2));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(Arrays.asList(1, 3));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(Arrays.asList(1, 3, 5));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(Arrays.asList(3, 4, 5));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 1, 1, 2, 2})).doContainsAllInOrder(Arrays.asList(1, 1, 1, 2, 2));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(Arrays.asList(1, 2, 3, 4, 5));

        try {
            new BufferAssertionImpl().doContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(Arrays.asList(1, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(Arrays.asList(3, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 1]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 1, 1})).doContainsAllInOrder(Arrays.asList(1, 1, 1, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 1, 1, 1]> but was:<[1, 1, 1]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doContainsAllInOrder(Arrays.asList(3, 4));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 4]> but was:<[4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doContainsAllInOrder(Arrays.asList(3, 4));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAllInOrder(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}), "Message").doContainsAllInOrder(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsAllInOrderArrayTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(1, 2);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(1, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(1, 3, 5);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(3, 4, 5);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 1, 1, 2, 2})).doRewindAndContainsAllInOrder(1, 1, 1, 2, 2);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(1, 2, 3, 4, 5);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doRewindAndContainsAllInOrder(3, 4);

        try {
            new BufferAssertionImpl().doRewindAndContainsAllInOrder(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsAllInOrder(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsAllInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsAllInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsAllInOrder();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(1, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(3, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 1]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 1, 1})).doRewindAndContainsAllInOrder(1, 1, 1, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 1, 1, 1]> but was:<[1, 1, 1]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doRewindAndContainsAllInOrder(3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}), "Message").doRewindAndContainsAllInOrder(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsAllInOrderIterableTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(Arrays.asList(1, 2));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(Arrays.asList(1, 3));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(Arrays.asList(1, 3, 5));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(Arrays.asList(3, 4, 5));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 1, 1, 2, 2})).doRewindAndContainsAllInOrder(Arrays.asList(1, 1, 1, 2, 2));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(Arrays.asList(1, 2, 3, 4, 5));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doRewindAndContainsAllInOrder(Arrays.asList(3, 4));

        try {
            new BufferAssertionImpl().doRewindAndContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(Arrays.asList(1, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(Arrays.asList(3, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 1]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 1, 1})).doRewindAndContainsAllInOrder(Arrays.asList(1, 1, 1, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 1, 1, 1]> but was:<[1, 1, 1]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doRewindAndContainsAllInOrder(Arrays.asList(3, 4));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAllInOrder(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}), "Message").doRewindAndContainsAllInOrder(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsExactlyArrayTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(1, 2, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(2, 1, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(2, 3, 1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(3, 2, 1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsExactly(1, 2, 3, 4, 5);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsExactly(2, 4, 1, 3, 5);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[0])).doContainsExactly();

        try {
            new BufferAssertionImpl().doContainsExactly(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsExactly(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsExactly((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsExactly((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(1, 2, 3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(3, 2, 1, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[3, 2, 1, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(2, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 1]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsExactly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(2, 4, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}), "Message").doContainsExactly(2, 4, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsExactlyIterableTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(Arrays.asList(1, 2, 3));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(Arrays.asList(2, 1, 3));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(Arrays.asList(2, 3, 1));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(Arrays.asList(3, 2, 1));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsExactly(Arrays.asList(1, 2, 3, 4, 5));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsExactly(Arrays.asList(2, 4, 1, 3, 5));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[0])).doContainsExactly(new ArrayList<Integer>());

        try {
            new BufferAssertionImpl().doContainsExactly(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsExactly(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsExactly((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsExactly((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(Arrays.asList(1, 2, 3, 4));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(Arrays.asList(3, 2, 1, 4));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[3, 2, 1, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(Arrays.asList(1, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(Arrays.asList(2, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 1]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsExactly(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doContainsExactly(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doContainsExactly(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactly(Arrays.asList(2, 4, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}), "Message").doContainsExactly(Arrays.asList(2, 4, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsExactlyArrayTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(1, 2, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(2, 1, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(2, 3, 1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(3, 2, 1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsExactly(1, 2, 3, 4, 5);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsExactly(2, 4, 1, 3, 5);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[0])).doRewindAndContainsExactly();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doRewindAndContainsExactly(1, 2, 3, 4, 5);

        try {
            new BufferAssertionImpl().doRewindAndContainsExactly(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsExactly(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsExactly((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsExactly((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(1, 2, 3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(3, 2, 1, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[3, 2, 1, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(2, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 1]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsExactly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doRewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(2, 4, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}), "Message").doRewindAndContainsExactly(2, 4, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsExactlyIterableTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(Arrays.asList(1, 2, 3));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(Arrays.asList(2, 1, 3));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(Arrays.asList(2, 3, 1));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(Arrays.asList(3, 2, 1));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsExactly(Arrays.asList(1, 2, 3, 4, 5));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsExactly(Arrays.asList(2, 4, 1, 3, 5));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[0])).doRewindAndContainsExactly(new ArrayList<Integer>());
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doRewindAndContainsExactly(Arrays.asList(1, 2, 3, 4, 5));

        try {
            new BufferAssertionImpl().doRewindAndContainsExactly(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsExactly(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsExactly((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsExactly((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(Arrays.asList(1, 2, 3, 4));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(Arrays.asList(3, 2, 1, 4));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[3, 2, 1, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(Arrays.asList(1, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(Arrays.asList(2, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 1]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsExactly(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doRewindAndContainsExactly(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactly(Arrays.asList(2, 4, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}), "Message").doRewindAndContainsExactly(Arrays.asList(2, 4, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsExactlyInOrderArrayTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactlyInOrder(1, 2, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsExactlyInOrder(1, 2, 3, 4, 5);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[0])).doContainsExactlyInOrder();

        try {
            new BufferAssertionImpl().doContainsExactlyInOrder(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsExactlyInOrder(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsExactlyInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsExactlyInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactlyInOrder(1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactlyInOrder(2, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactlyInOrder(1, 2, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsExactlyInOrder();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactlyInOrder(3, 1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}), "Message").doContainsExactlyInOrder(3, 1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsExactlyInOrderIterableTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactlyInOrder(Arrays.asList(1, 2, 3));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[0])).doContainsExactlyInOrder(new ArrayList<Integer>());

        try {
            new BufferAssertionImpl().doContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactlyInOrder(Arrays.asList(1, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactlyInOrder(Arrays.asList(2, 3));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactlyInOrder(Arrays.asList(1, 2, 4));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsExactlyInOrder(Arrays.asList(3, 1, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}), "Message").doContainsExactlyInOrder(Arrays.asList(3, 1, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsExactlyInOrderArrayTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactlyInOrder(1, 2, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[0])).doRewindAndContainsExactlyInOrder();
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doRewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);

        try {
            new BufferAssertionImpl().doRewindAndContainsExactlyInOrder(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsExactlyInOrder(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsExactlyInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsExactlyInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactlyInOrder(1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactlyInOrder(2, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactlyInOrder(1, 2, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsExactlyInOrder();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doRewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactlyInOrder(3, 1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}), "Message").doRewindAndContainsExactlyInOrder(3, 1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsExactlyInOrderIterableTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[0])).doRewindAndContainsExactlyInOrder(new ArrayList<Integer>());
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doRewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));

        try {
            new BufferAssertionImpl().doRewindAndContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactlyInOrder(Arrays.asList(1, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactlyInOrder(Arrays.asList(2, 3));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 4));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doRewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsExactlyInOrder(Arrays.asList(3, 1, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}), "Message").doRewindAndContainsExactlyInOrder(Arrays.asList(3, 1, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsAnyArrayTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsAny(1, 3, 5);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsAny(6, 2, 4);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAny(7, 9, 1, 5, 3);

        try {
            new BufferAssertionImpl().doContainsAny(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsAny(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsAny((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsAny((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsAny();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsAny(4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5, 6]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doContainsAny(3, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 1]> but was:<[4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doContainsAny(4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAny(8, 7);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}), "Message").doContainsAny(8, 7);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsAnyIterableTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsAny(Arrays.asList(1, 3, 5));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsAny(Arrays.asList(6, 2, 4));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAny(Arrays.asList(7, 9, 1, 5, 3));

        try {
            new BufferAssertionImpl().doContainsAny(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsAny(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsAny((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsAny((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsAny(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsAny(Arrays.asList(4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5, 6]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doContainsAny(Arrays.asList(3, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 1]> but was:<[4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doContainsAny(Arrays.asList(4, 5));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doContainsAny(Arrays.asList(8, 7));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}), "Message").doContainsAny(Arrays.asList(8, 7));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsAnyArrayTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsAny(1, 3, 5);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsAny(6, 2, 4);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAny(7, 9, 1, 5, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doRewindAndContainsAny(3, 1);

        try {
            new BufferAssertionImpl().doRewindAndContainsAny(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsAny(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsAny((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsAny((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsAny();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsAny(4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5, 6]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doRewindAndContainsAny(4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAny(8, 7);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}), "Message").doRewindAndContainsAny(8, 7);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsAnyIterableTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsAny(Arrays.asList(1, 3, 5));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsAny(Arrays.asList(6, 2, 4));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAny(Arrays.asList(7, 9, 1, 5, 3));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doRewindAndContainsAny(Arrays.asList(3, 1));

        try {
            new BufferAssertionImpl().doRewindAndContainsAny(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsAny(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsAny((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsAny((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsAny(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsAny(Arrays.asList(4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5, 6]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doRewindAndContainsAny(Arrays.asList(4, 5));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5})).doRewindAndContainsAny(Arrays.asList(8, 7));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}), "Message").doRewindAndContainsAny(Arrays.asList(8, 7));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsNoneArrayTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsNone(4, 5, 6);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsNone(8, 4);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doContainsNone(1, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doContainsNone(4, 5);

        try {
            new BufferAssertionImpl().doContainsNone(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsNone(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsNone((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsNone((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsNone();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsNone(4, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[4, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsNone(5, 4, 2, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}), "Message").doContainsNone(5, 4, 2, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsNoneIterableTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsNone(Arrays.asList(4, 5, 6));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsNone(Arrays.asList(8, 4));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doContainsNone(Arrays.asList(1, 3));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doContainsNone(Arrays.asList(4, 5));

        try {
            new BufferAssertionImpl().doContainsNone(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsNone(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doContainsNone((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsNone((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doContainsNone(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsNone(Arrays.asList(4, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[4, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doContainsNone(Arrays.asList(5, 4, 2, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}), "Message").doContainsNone(Arrays.asList(5, 4, 2, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsNoneArrayTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsNone(4, 5, 6);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsNone(8, 4);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doRewindAndContainsNone(4, 5);

        try {
            new BufferAssertionImpl().doRewindAndContainsNone(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsNone(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsNone((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsNone((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsNone();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsNone(4, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[4, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doRewindAndContainsNone(1, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsNone(5, 4, 2, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}), "Message").doRewindAndContainsNone(5, 4, 2, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsNoneIterableTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsNone(Arrays.asList(4, 5, 6));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsNone(Arrays.asList(8, 4));
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).doRewindAndContainsNone(Arrays.asList(4, 5));

        try {
            new BufferAssertionImpl().doRewindAndContainsNone(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsNone(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).doRewindAndContainsNone((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsNone((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2})).doRewindAndContainsNone(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsNone(Arrays.asList(4, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[4, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).doRewindAndContainsNone(Arrays.asList(1, 3));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3})).doRewindAndContainsNone(Arrays.asList(5, 4, 2, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}), "Message").doRewindAndContainsNone(Arrays.asList(5, 4, 2, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void toPositionTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).toPosition().isEqualTo(3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).toPosition().isGreaterThan(2);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).toPosition().isLessThan(6);

        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1)).toPosition().isEqualTo(1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1)).toPosition().isGreaterThan(0);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1)).toPosition().isLessThan(4);

        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toPosition().isEqualTo(3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toPosition().isGreaterThan(1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toPosition().isLessThan(5);

        try {
            new BufferAssertionImpl().toPosition();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).toPosition();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null, "Message").toPosition();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).toPosition().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer position. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").toPosition().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer position. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void hasPositionTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasPosition(3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1)).hasPosition(1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).hasPosition(3);

        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasPosition(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer position. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").hasPosition(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer position. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void toLimitTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).toLimit().isEqualTo(3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).toLimit().isGreaterThan(2);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).toLimit().isLessThan(6);

        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toLimit().isEqualTo(1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toLimit().isGreaterThan(0);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toLimit().isLessThan(4);

        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toLimit().isEqualTo(3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toLimit().isGreaterThan(1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toLimit().isLessThan(5);

        try {
            new BufferAssertionImpl().toLimit();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).toLimit();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null, "Message").toLimit();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).toLimit().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer limit. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").toLimit().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer limit. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void hasLimitTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasLimit(3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).hasLimit(1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).hasLimit(3);

        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasLimit(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer limit. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").hasLimit(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer limit. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void toCapacityTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).toCapacity().isEqualTo(3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).toCapacity().isGreaterThan(2);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).toCapacity().isLessThan(6);

        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toCapacity().isEqualTo(3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toCapacity().isGreaterThan(2);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).toCapacity().isLessThan(6);

        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toCapacity().isEqualTo(5);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toCapacity().isGreaterThan(1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).toCapacity().isLessThan(7);

        try {
            new BufferAssertionImpl().toCapacity();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).toCapacity();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null, "Message").toCapacity();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).toCapacity().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer capacity. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").toCapacity().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer capacity. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void hasCapacityTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasCapacity(3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1, 1)).hasCapacity(3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).hasCapacity(5);

        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasCapacity(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer capacity. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").hasCapacity(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer capacity. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void hasPropertiesTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasProperties(3, 3, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1)).hasProperties(1, 3, 3);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 3, 5)).hasProperties(3, 3, 5);

        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasProperties(4, 3, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer position. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").hasProperties(4, 3, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer position. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasProperties(3, 4, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer limit. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").hasProperties(3, 4, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer limit. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasProperties(3, 3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer capacity. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3), "Message").hasProperties(3, 3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer capacity. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void toRemainingTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).toRemaining().isEqualTo(0);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).toRemaining().isGreaterThan(-1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).toRemaining().isLessThan(3);

        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1, 3)).toRemaining().isEqualTo(2);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1, 3)).toRemaining().isGreaterThan(1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1, 3)).toRemaining().isLessThan(5);

        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 2, 5)).toRemaining().isEqualTo(0);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 2, 5)).toRemaining().isGreaterThan(-1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 2, 5)).toRemaining().isLessThan(3);

        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 2, 4, 5)).toRemaining().isEqualTo(2);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 2, 4, 5)).toRemaining().isGreaterThan(1);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 2, 4, 5)).toRemaining().isLessThan(5);

        try {
            new BufferAssertionImpl().toRemaining();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).toRemaining();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null, "Message").toRemaining();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 0, 3, 3)).toRemaining().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer remaining. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 0, 3, 3), "Message").toRemaining().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer remaining. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void hasRemainingTest() {
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 3)).hasRemaining(0);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 1, 3)).hasRemaining(2);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 4, 2, 5)).hasRemaining(0);
        initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 2, 4, 5)).hasRemaining(2);

        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 0, 3, 3)).hasRemaining(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer remaining. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(new BufferAssertionImpl(), createIntBuffer(new int[]{1, 2, 3}, 0, 3, 3), "Message").hasRemaining(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer remaining. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isDirectTest() {
        initialize(new BufferAssertionImpl(), ByteBuffer.allocateDirect(12).asIntBuffer()).isDirect();

        try {
            new BufferAssertionImpl().isDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).isDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null, "Message").isDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), ByteBuffer.allocate(12).asIntBuffer()).isDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be direct.");
        }
        try {
            initialize(new BufferAssertionImpl(), ByteBuffer.allocate(12).asIntBuffer(), "Message").isDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be direct.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isNotDirectTest() {
        initialize(new BufferAssertionImpl(), ByteBuffer.allocate(12).asIntBuffer()).isNotDirect();

        try {
            new BufferAssertionImpl().isNotDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).isNotDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null, "Message").isNotDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), ByteBuffer.allocateDirect(12).asIntBuffer()).isNotDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be direct.");
        }
        try {
            initialize(new BufferAssertionImpl(), ByteBuffer.allocateDirect(12).asIntBuffer(), "Message").isNotDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be direct.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isReadOnlyTest() {
        IntBuffer intBuffer = ByteBuffer.allocate(12).asIntBuffer();
        IntBuffer readOnlyBuffer = intBuffer.asReadOnlyBuffer();

        initialize(new BufferAssertionImpl(), readOnlyBuffer).isReadOnly();

        try {
            new BufferAssertionImpl().isReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).isReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null, "Message").isReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), intBuffer).isReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be read only.");
        }
        try {
            initialize(new BufferAssertionImpl(), intBuffer, "Message").isReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be read only.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isNotReadOnlyTest() {
        IntBuffer intBuffer = ByteBuffer.allocate(12).asIntBuffer();
        IntBuffer readOnlyBuffer = intBuffer.asReadOnlyBuffer();

        initialize(new BufferAssertionImpl(), intBuffer).isNotReadOnly();

        try {
            new BufferAssertionImpl().isNotReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new BufferAssertionImpl(), null).isNotReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), null, "Message").isNotReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(new BufferAssertionImpl(), readOnlyBuffer).isNotReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be read only.");
        }
        try {
            initialize(new BufferAssertionImpl(), readOnlyBuffer, "Message").isNotReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be read only.");
        }
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BufferAssertionImpl extends BufferAssertion<IntBuffer, Integer> {

        BufferAssertionImpl() {
            super();
        }

        @Override
        protected Class<IntBuffer> getActualValueClass() {
            return IntBuffer.class;
        }

        @Override
        List<Integer> createList(final Object value, final boolean rewind) {
            IntBuffer buffer = (IntBuffer) value;
            int position = buffer.position();
            if (rewind) {
                buffer.rewind();
            }
            List<Integer> result = new ArrayList<>(buffer.remaining());
            while (buffer.hasRemaining()) {
                int bufferValue = buffer.get();
                result.add(bufferValue);
            }
            buffer.position(position);
            return result;
        }

        @Override
        protected String asString(final Object value) {
            return value.toString();
        }

    }

}
