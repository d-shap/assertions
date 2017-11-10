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

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

/**
 * Tests for {@link BufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class BufferAssertionTest {

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
        new BufferAssertionImpl(new ArrayList<Integer>(), new FailDescription()).isEmpty();
        new BufferAssertionImpl(Arrays.asList(1, 2), 2, new FailDescription()).isEmpty();
        new BufferAssertionImpl(Arrays.asList(1, 2), 2, 2, 4, new FailDescription()).isEmpty();

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(new ArrayList<Integer>(), 0, 4, 4, new FailDescription()).isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[0, 0, 0, 0]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 1, new FailDescription()).isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 1, new FailDescription("Message")).isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[2]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isRewindAndEmptyTest() {
        new BufferAssertionImpl(new ArrayList<Integer>(), new FailDescription()).isRewindAndEmpty();
        new BufferAssertionImpl(Arrays.asList(1, 2), 0, 0, new FailDescription()).isRewindAndEmpty();
        new BufferAssertionImpl(Arrays.asList(1, 2), 0, 0, 4, new FailDescription()).isRewindAndEmpty();

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(new ArrayList<Integer>(), 0, 4, 4, new FailDescription()).isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[0, 0, 0, 0]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 1, new FailDescription()).isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 1, new FailDescription("Message")).isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        new BufferAssertionImpl(new ArrayList<Integer>(), new FailDescription()).isNullOrEmpty();
        new BufferAssertionImpl(Arrays.asList(1, 2), 2, new FailDescription()).isNullOrEmpty();
        new BufferAssertionImpl(Arrays.asList(1, 2), 2, 2, 4, new FailDescription()).isNullOrEmpty();
        new BufferAssertionImpl((IntBuffer) null, new FailDescription()).isNullOrEmpty();

        try {
            new BufferAssertionImpl(new ArrayList<Integer>(), 0, 4, 4, new FailDescription()).isNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[0, 0, 0, 0]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).isNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 1, new FailDescription()).isNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 1, new FailDescription("Message")).isNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[2]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isRewindAndNullOrEmptyTest() {
        new BufferAssertionImpl(new ArrayList<Integer>(), new FailDescription()).isRewindAndNullOrEmpty();
        new BufferAssertionImpl(Arrays.asList(1, 2), 0, 0, new FailDescription()).isRewindAndNullOrEmpty();
        new BufferAssertionImpl(Arrays.asList(1, 2), 0, 0, 4, new FailDescription()).isRewindAndNullOrEmpty();
        new BufferAssertionImpl((IntBuffer) null, new FailDescription()).isRewindAndNullOrEmpty();

        try {
            new BufferAssertionImpl(new ArrayList<Integer>(), 0, 4, 4, new FailDescription()).isRewindAndNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[0, 0, 0, 0]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).isRewindAndNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 1, new FailDescription()).isRewindAndNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 1, new FailDescription("Message")).isRewindAndNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[1, 2]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).isNotEmpty();
        new BufferAssertionImpl(Arrays.asList(1, 2), 1, new FailDescription()).isNotEmpty();
        new BufferAssertionImpl(new ArrayList<Integer>(), 0, 4, 4, new FailDescription()).isNotEmpty();

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).isNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(new ArrayList<Integer>(), new FailDescription()).isNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 2, new FailDescription()).isNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 2, 2, 4, new FailDescription()).isNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 2, 2, 4, new FailDescription("Message")).isNotEmpty();
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
        new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).isRewindAndNotEmpty();
        new BufferAssertionImpl(Arrays.asList(1, 2), 1, new FailDescription()).isRewindAndNotEmpty();
        new BufferAssertionImpl(new ArrayList<Integer>(), 0, 4, 4, new FailDescription()).isRewindAndNotEmpty();
        new BufferAssertionImpl(Arrays.asList(1, 2), 2, new FailDescription()).isRewindAndNotEmpty();
        new BufferAssertionImpl(Arrays.asList(1, 2), 2, 2, 4, new FailDescription()).isRewindAndNotEmpty();

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).isRewindAndNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(new ArrayList<Integer>(), new FailDescription()).isRewindAndNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new BufferAssertionImpl(new ArrayList<Integer>(), new FailDescription("Message")).isRewindAndNotEmpty();
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
        new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription()).doContains(1);
        new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription()).doContains(2);

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContains(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 1, new FailDescription()).doContains(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<1> but was:<[2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 0, 1, new FailDescription()).doContains(2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[1]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription()).doContains(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription("Message")).doContains(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription()).doRewindAndContains(1);
        new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription()).doRewindAndContains(2);
        new BufferAssertionImpl(Arrays.asList(1, 2), 1, new FailDescription()).doRewindAndContains(1);

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContains(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 0, 1, new FailDescription()).doRewindAndContains(2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[1]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription()).doRewindAndContains(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription("Message")).doRewindAndContains(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doDoesNotContainTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription()).doDoesNotContain(3);
        new BufferAssertionImpl(Arrays.asList(1, 2), 1, new FailDescription()).doDoesNotContain(1);
        new BufferAssertionImpl(Arrays.asList(1, 2), 0, 1, new FailDescription()).doDoesNotContain(2);

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doDoesNotContain(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription()).doDoesNotContain(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription()).doDoesNotContain(2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription("Message")).doDoesNotContain(2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<2> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndDoesNotContainTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription()).doRewindAndDoesNotContain(3);
        new BufferAssertionImpl(Arrays.asList(1, 2), 0, 1, new FailDescription()).doRewindAndDoesNotContain(2);

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndDoesNotContain(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription()).doRewindAndDoesNotContain(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 1, new FailDescription()).doRewindAndDoesNotContain(1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription()).doRewindAndDoesNotContain(2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), 0, new FailDescription("Message")).doRewindAndDoesNotContain(2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<2> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsAllTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAll(1, 2);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAll(1, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAll(3, 1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAll(5, 1, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAll(3, 5, 4);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAll(3, 1, 4, 5, 2);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAll(Arrays.asList(3, 1, 4, 5, 2));

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsAll(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsAll(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsAll((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsAll((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsAll((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsAll((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsAll();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsAll(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAll(1, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAll(0, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[0, 1]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAll(1, 1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 1, 2]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doContainsAll(3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[3, 4]> but was:<[4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 0, 3, new FailDescription()).doContainsAll(3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAll(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription("Message")).doContainsAll(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAll(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription("Message")).doContainsAll(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsAllTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAll(1, 2);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAll(1, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAll(3, 1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAll(5, 1, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAll(3, 5, 4);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAll(3, 1, 4, 5, 2);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAll(Arrays.asList(3, 1, 4, 5, 2));
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doRewindAndContainsAll(3, 4);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doRewindAndContainsAll(Arrays.asList(3, 4));

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsAll(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsAll(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsAll((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsAll((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsAll((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsAll((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsAll();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsAll(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAll(1, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAll(0, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[0, 1]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAll(1, 1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 1, 2]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 0, 3, new FailDescription()).doRewindAndContainsAll(3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAll(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription("Message")).doRewindAndContainsAll(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAll(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription("Message")).doRewindAndContainsAll(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsAllInOrderTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAllInOrder(1, 2);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAllInOrder(1, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAllInOrder(1, 3, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAllInOrder(3, 4, 5);
        new BufferAssertionImpl(Arrays.asList(1, 1, 1, 2, 2), new FailDescription()).doContainsAllInOrder(1, 1, 1, 2, 2);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAllInOrder(1, 2, 3, 4, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAllInOrder(Arrays.asList(1, 2, 3, 4, 5));

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsAllInOrder(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsAllInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsAllInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsAllInOrder();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAllInOrder(1, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAllInOrder(3, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 1]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 1, 1), new FailDescription()).doContainsAllInOrder(1, 1, 1, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 1, 1, 1]> but was:<[1, 1, 1]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doContainsAllInOrder(3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 4]> but was:<[4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 0, 3, new FailDescription()).doContainsAllInOrder(3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAllInOrder(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription("Message")).doContainsAllInOrder(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAllInOrder(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription("Message")).doContainsAllInOrder(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsAllInOrderTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAllInOrder(1, 2);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAllInOrder(1, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAllInOrder(1, 3, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAllInOrder(3, 4, 5);
        new BufferAssertionImpl(Arrays.asList(1, 1, 1, 2, 2), new FailDescription()).doRewindAndContainsAllInOrder(1, 1, 1, 2, 2);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAllInOrder(1, 2, 3, 4, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAllInOrder(Arrays.asList(1, 2, 3, 4, 5));
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doRewindAndContainsAllInOrder(3, 4);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doRewindAndContainsAllInOrder(Arrays.asList(3, 4));

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsAllInOrder(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsAllInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsAllInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsAllInOrder();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAllInOrder(1, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAllInOrder(3, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 1]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 1, 1), new FailDescription()).doRewindAndContainsAllInOrder(1, 1, 1, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 1, 1, 1]> but was:<[1, 1, 1]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 0, 3, new FailDescription()).doRewindAndContainsAllInOrder(3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAllInOrder(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription("Message")).doRewindAndContainsAllInOrder(1, 2, 3, 4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAllInOrder(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription("Message")).doRewindAndContainsAllInOrder(Arrays.asList(1, 2, 3, 4, 5, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsExactlyTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactly(1, 2, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactly(2, 1, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactly(2, 3, 1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactly(3, 2, 1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsExactly(1, 2, 3, 4, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsExactly(2, 4, 1, 3, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsExactly(Arrays.asList(2, 4, 1, 3, 5));
        new BufferAssertionImpl(new ArrayList<Integer>(), new FailDescription()).doContainsExactly();
        new BufferAssertionImpl(new ArrayList<Integer>(), new FailDescription()).doContainsExactly(new ArrayList<Integer>());

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsExactly(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsExactly(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsExactly((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsExactly((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsExactly((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsExactly((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactly(1, 2, 3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactly(3, 2, 1, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[3, 2, 1, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactly(1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactly(2, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 1]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsExactly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsExactly(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 0, 3, new FailDescription()).doContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactly(2, 4, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription("Message")).doContainsExactly(2, 4, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactly(Arrays.asList(2, 4, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription("Message")).doContainsExactly(Arrays.asList(2, 4, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsExactlyTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactly(1, 2, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactly(2, 1, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactly(2, 3, 1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactly(3, 2, 1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsExactly(1, 2, 3, 4, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsExactly(2, 4, 1, 3, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsExactly(Arrays.asList(2, 4, 1, 3, 5));
        new BufferAssertionImpl(new ArrayList<Integer>(), new FailDescription()).doRewindAndContainsExactly();
        new BufferAssertionImpl(new ArrayList<Integer>(), new FailDescription()).doRewindAndContainsExactly(new ArrayList<Integer>());
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doRewindAndContainsExactly(1, 2, 3, 4, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doRewindAndContainsExactly(Arrays.asList(1, 2, 3, 4, 5));

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsExactly(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsExactly(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsExactly((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsExactly((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsExactly((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsExactly((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactly(1, 2, 3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactly(3, 2, 1, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[3, 2, 1, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactly(1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactly(2, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 1]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsExactly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsExactly(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 0, 3, new FailDescription()).doRewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactly(2, 4, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription("Message")).doRewindAndContainsExactly(2, 4, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactly(Arrays.asList(2, 4, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription("Message")).doRewindAndContainsExactly(Arrays.asList(2, 4, 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsExactlyInOrderTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactlyInOrder(1, 2, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsExactlyInOrder(1, 2, 3, 4, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
        new BufferAssertionImpl(new ArrayList<Integer>(), new FailDescription()).doContainsExactlyInOrder();
        new BufferAssertionImpl(new ArrayList<Integer>(), new FailDescription()).doContainsExactlyInOrder(new ArrayList<Integer>());

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsExactlyInOrder(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsExactlyInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsExactlyInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactlyInOrder(1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactlyInOrder(2, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactlyInOrder(1, 2, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsExactlyInOrder();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 0, 3, new FailDescription()).doContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactlyInOrder(3, 1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription("Message")).doContainsExactlyInOrder(3, 1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsExactlyInOrder(Arrays.asList(3, 1, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription("Message")).doContainsExactlyInOrder(Arrays.asList(3, 1, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsExactlyInOrderTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactlyInOrder(1, 2, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
        new BufferAssertionImpl(new ArrayList<Integer>(), new FailDescription()).doRewindAndContainsExactlyInOrder();
        new BufferAssertionImpl(new ArrayList<Integer>(), new FailDescription()).doRewindAndContainsExactlyInOrder(new ArrayList<Integer>());
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doRewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doRewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsExactlyInOrder(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsExactlyInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsExactlyInOrder((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactlyInOrder(1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactlyInOrder(2, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactlyInOrder(1, 2, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactlyInOrder(1, 2, 3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsExactlyInOrder();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 0, 3, new FailDescription()).doRewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactlyInOrder(3, 1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription("Message")).doRewindAndContainsExactlyInOrder(3, 1, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsExactlyInOrder(Arrays.asList(3, 1, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription("Message")).doRewindAndContainsExactlyInOrder(Arrays.asList(3, 1, 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsAnyTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsAny(1, 3, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsAny(6, 2, 4);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAny(7, 9, 1, 5, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAny(Arrays.asList(7, 9, 1, 5, 3));

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsAny(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsAny(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsAny((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsAny((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsAny((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsAny((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsAny();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsAny(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsAny(4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5, 6]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doContainsAny(3, 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 1]> but was:<[4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 0, 3, new FailDescription()).doContainsAny(4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAny(8, 7);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription("Message")).doContainsAny(8, 7);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doContainsAny(Arrays.asList(8, 7));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription("Message")).doContainsAny(Arrays.asList(8, 7));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsAnyTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsAny(1, 3, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsAny(6, 2, 4);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAny(7, 9, 1, 5, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAny(Arrays.asList(7, 9, 1, 5, 3));
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doRewindAndContainsAny(3, 1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doRewindAndContainsAny(Arrays.asList(3, 1));

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsAny(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsAny(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsAny((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsAny((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsAny((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsAny((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsAny();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsAny(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsAny(4, 5, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5, 6]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 0, 3, new FailDescription()).doRewindAndContainsAny(4, 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAny(8, 7);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription("Message")).doRewindAndContainsAny(8, 7);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription()).doRewindAndContainsAny(Arrays.asList(8, 7));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), new FailDescription("Message")).doRewindAndContainsAny(Arrays.asList(8, 7));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsNoneTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsNone(4, 5, 6);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsNone(8, 4);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsNone(Arrays.asList(8, 4));
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doContainsNone(1, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doContainsNone(Arrays.asList(1, 3));
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 0, 3, new FailDescription()).doContainsNone(4, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 0, 3, new FailDescription()).doContainsNone(Arrays.asList(4, 5));

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsNone(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsNone(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsNone((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doContainsNone((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsNone((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsNone((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsNone();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doContainsNone(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsNone(2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsNone(4, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[4, 2]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsNone(5, 4, 2, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription("Message")).doContainsNone(5, 4, 2, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doContainsNone(Arrays.asList(5, 4, 2, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription("Message")).doContainsNone(Arrays.asList(5, 4, 2, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsNoneTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsNone(4, 5, 6);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsNone(8, 4);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsNone(Arrays.asList(8, 4));
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 0, 3, new FailDescription()).doRewindAndContainsNone(4, 5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 0, 3, new FailDescription()).doRewindAndContainsNone(Arrays.asList(4, 5));

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsNone(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsNone(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsNone((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).doRewindAndContainsNone((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsNone((Integer[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsNone((Iterable<Integer>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsNone();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2), new FailDescription()).doRewindAndContainsNone(new ArrayList<Integer>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsNone(2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsNone(4, 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[4, 2]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3, 4, 5), 3, new FailDescription()).doRewindAndContainsNone(1, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsNone(5, 4, 2, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription("Message")).doRewindAndContainsNone(5, 4, 2, 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription()).doRewindAndContainsNone(Arrays.asList(5, 4, 2, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), new FailDescription("Message")).doRewindAndContainsNone(Arrays.asList(5, 4, 2, 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void toPositionTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).toPosition().isEqualTo(3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).toPosition().isGreaterThan(2);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).toPosition().isLessThan(6);

        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, new FailDescription()).toPosition().isEqualTo(1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, new FailDescription()).toPosition().isGreaterThan(0);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, new FailDescription()).toPosition().isLessThan(4);

        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 3, 5, new FailDescription()).toPosition().isEqualTo(3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 3, 5, new FailDescription()).toPosition().isGreaterThan(1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 3, 5, new FailDescription()).toPosition().isLessThan(5);

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).toPosition();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription("Message")).toPosition();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).toPosition().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer position. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription("Message")).toPosition().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer position. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void hasPositionTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).hasPosition(3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, new FailDescription()).hasPosition(1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 3, 5, new FailDescription()).hasPosition(3);

        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).hasPosition(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer position. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription("Message")).hasPosition(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer position. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void toLimitTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).toLimit().isEqualTo(3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).toLimit().isGreaterThan(2);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).toLimit().isLessThan(6);

        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, 1, new FailDescription()).toLimit().isEqualTo(1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, 1, new FailDescription()).toLimit().isGreaterThan(0);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, 1, new FailDescription()).toLimit().isLessThan(4);

        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 3, 5, new FailDescription()).toLimit().isEqualTo(3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 3, 5, new FailDescription()).toLimit().isGreaterThan(1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 3, 5, new FailDescription()).toLimit().isLessThan(5);

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).toLimit();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription("Message")).toLimit();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).toLimit().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer limit. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription("Message")).toLimit().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer limit. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void hasLimitTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).hasLimit(3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, 1, new FailDescription()).hasLimit(1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 3, 5, new FailDescription()).hasLimit(3);

        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).hasLimit(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer limit. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription("Message")).hasLimit(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer limit. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void toCapacityTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).toCapacity().isEqualTo(3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).toCapacity().isGreaterThan(2);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).toCapacity().isLessThan(6);

        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, 1, new FailDescription()).toCapacity().isEqualTo(3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, 1, new FailDescription()).toCapacity().isGreaterThan(2);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, 1, new FailDescription()).toCapacity().isLessThan(6);

        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 3, 5, new FailDescription()).toCapacity().isEqualTo(5);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 3, 5, new FailDescription()).toCapacity().isGreaterThan(1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 3, 5, new FailDescription()).toCapacity().isLessThan(7);

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).toCapacity();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription("Message")).toCapacity();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).toCapacity().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer capacity. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription("Message")).toCapacity().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer capacity. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void hasCapacityTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).hasCapacity(3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, 1, new FailDescription()).hasCapacity(3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 3, 5, new FailDescription()).hasCapacity(5);

        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).hasCapacity(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer capacity. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription("Message")).hasCapacity(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer capacity. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void hasPropertiesTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).hasProperties(3, 3, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, new FailDescription()).hasProperties(1, 3, 3);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 3, 5, new FailDescription()).hasProperties(3, 3, 5);

        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).hasProperties(4, 3, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer position. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription("Message")).hasProperties(4, 3, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer position. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).hasProperties(3, 4, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer limit. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription("Message")).hasProperties(3, 4, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer limit. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).hasProperties(3, 3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer capacity. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription("Message")).hasProperties(3, 3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer capacity. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void toRemainingTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).toRemaining().isEqualTo(0);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).toRemaining().isGreaterThan(-1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).toRemaining().isLessThan(3);

        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, 3, new FailDescription()).toRemaining().isEqualTo(2);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, 3, new FailDescription()).toRemaining().isGreaterThan(1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, 3, new FailDescription()).toRemaining().isLessThan(5);

        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 2, 5, new FailDescription()).toRemaining().isEqualTo(0);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 2, 5, new FailDescription()).toRemaining().isGreaterThan(-1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 2, 5, new FailDescription()).toRemaining().isLessThan(3);

        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 2, 4, 5, new FailDescription()).toRemaining().isEqualTo(2);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 2, 4, 5, new FailDescription()).toRemaining().isGreaterThan(1);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 2, 4, 5, new FailDescription()).toRemaining().isLessThan(5);

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).toRemaining();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription("Message")).toRemaining();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 0, 3, 3, new FailDescription()).toRemaining().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer remaining. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 0, 3, 3, new FailDescription("Message")).toRemaining().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer remaining. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void hasRemainingTest() {
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 3, new FailDescription()).hasRemaining(0);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 1, 3, new FailDescription()).hasRemaining(2);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 4, 2, 5, new FailDescription()).hasRemaining(0);
        new BufferAssertionImpl(Arrays.asList(1, 2, 3), 2, 4, 5, new FailDescription()).hasRemaining(2);

        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 0, 3, 3, new FailDescription()).hasRemaining(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check buffer remaining. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList(1, 2, 3), 0, 3, 3, new FailDescription("Message")).hasRemaining(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check buffer remaining. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isDirectTest() {
        new BufferAssertionImpl(ByteBuffer.allocateDirect(12).asIntBuffer(), new FailDescription()).isDirect();

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).isDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription("Message")).isDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new BufferAssertionImpl(ByteBuffer.allocate(12).asIntBuffer(), new FailDescription()).isDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be direct.");
        }
        try {
            new BufferAssertionImpl(ByteBuffer.allocate(12).asIntBuffer(), new FailDescription("Message")).isDirect();
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
        new BufferAssertionImpl(ByteBuffer.allocate(12).asIntBuffer(), new FailDescription()).isNotDirect();

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).isNotDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription("Message")).isNotDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new BufferAssertionImpl(ByteBuffer.allocateDirect(12).asIntBuffer(), new FailDescription()).isNotDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be direct.");
        }
        try {
            new BufferAssertionImpl(ByteBuffer.allocateDirect(12).asIntBuffer(), new FailDescription("Message")).isNotDirect();
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

        new BufferAssertionImpl(readOnlyBuffer, new FailDescription()).isReadOnly();

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).isReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription("Message")).isReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new BufferAssertionImpl(intBuffer, new FailDescription()).isReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be read only.");
        }
        try {
            new BufferAssertionImpl(intBuffer, new FailDescription("Message")).isReadOnly();
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

        new BufferAssertionImpl(intBuffer, new FailDescription()).isNotReadOnly();

        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription()).isNotReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((IntBuffer) null, new FailDescription("Message")).isNotReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new BufferAssertionImpl(readOnlyBuffer, new FailDescription()).isNotReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be read only.");
        }
        try {
            new BufferAssertionImpl(readOnlyBuffer, new FailDescription("Message")).isNotReadOnly();
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
    private static final class BufferAssertionImpl extends IntBufferAssertion {

        BufferAssertionImpl(final List<Integer> actual, final FailDescription failDescription) {
            this(actual, 0, failDescription);
        }

        BufferAssertionImpl(final List<Integer> actual, final int position, final FailDescription failDescription) {
            this(actual, position, getSize(actual), failDescription);
        }

        BufferAssertionImpl(final List<Integer> actual, final int position, final int limit, final FailDescription failDescription) {
            this(actual, position, limit, getSize(actual), failDescription);
        }

        BufferAssertionImpl(final List<Integer> actual, final int position, final int limit, final int capacity, final FailDescription failDescription) {
            this(createIntBuffer(actual, position, limit, capacity), failDescription);
        }

        BufferAssertionImpl(final IntBuffer byteBuffer, final FailDescription failDescription) {
            super(byteBuffer, failDescription);
        }

        private static IntBuffer createIntBuffer(final List<Integer> actual, final int position, final int limit, final int capacity) {
            if (actual == null) {
                return null;
            } else {
                ByteBuffer byteBuffer = ByteBuffer.allocate(capacity * 4);
                IntBuffer intBuffer = byteBuffer.asIntBuffer();
                for (Integer value : actual) {
                    intBuffer.put(value);
                }
                intBuffer.position(position);
                intBuffer.limit(limit);
                return intBuffer;
            }
        }

        private static int getSize(final List<Integer> actual) {
            if (actual == null) {
                return 0;
            } else {
                return actual.size();
            }
        }

    }

}
