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

import org.junit.Test;

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

/**
 * Tests for {@link IntBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntBufferAssertionTest {

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
    public void containsTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).contains(1);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).contains(2);

        try {
            new IntBufferAssertion(null, new FailDescription()).contains(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).contains(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[4, 5]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).contains(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).contains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).contains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContains(1);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContains(2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContains(2);

        try {
            new IntBufferAssertion(null, new FailDescription()).rewindAndContains(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContains(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).rewindAndContains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).doesNotContain(3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).doesNotContain(2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).doesNotContain(5);

        try {
            new IntBufferAssertion(null, new FailDescription()).doesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).doesNotContain(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).doesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).doesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndDoesNotContain(3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndDoesNotContain(5);

        try {
            new IntBufferAssertion(null, new FailDescription()).rewindAndDoesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndDoesNotContain(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndDoesNotContain(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndDoesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).rewindAndDoesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAll(1);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsAll(1, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsAll(4, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsAll(Arrays.asList(4, 2));

        try {
            new IntBufferAssertion(null, new FailDescription()).containsAll(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, new FailDescription()).containsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAll();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAll(1, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAll(Arrays.asList(1, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAll(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAll(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).containsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAll(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).containsAll(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAll(1);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(1, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(4, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(Arrays.asList(4, 2));
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAll(1, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAll(Arrays.asList(1, 2));

        try {
            new IntBufferAssertion(null, new FailDescription()).rewindAndContainsAll(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, new FailDescription()).rewindAndContainsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAll();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAll(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAll(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).rewindAndContainsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAll(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).rewindAndContainsAll(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAllInOrder(1);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsAllInOrder(1, 3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsAllInOrder(Arrays.asList(1, 3, 4));

        try {
            new IntBufferAssertion(null, new FailDescription()).containsAllInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAllInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAllInOrder(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAllInOrder(1, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAllInOrder(Arrays.asList(1, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAllInOrder(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAllInOrder(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).containsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).containsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder(1);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAllInOrder(1, 3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(1, 3, 4));
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAllInOrder(1, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(1, 2));

        try {
            new IntBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).rewindAndContainsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsExactly(1, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1, 2, 3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1, 3, 2, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsExactly(Arrays.asList(1, 3, 2, 4));
        new IntBufferAssertion(createIntBuffer(new int[0]), new FailDescription()).containsExactly();
        new IntBufferAssertion(createIntBuffer(new int[0]), new FailDescription()).containsExactly(new ArrayList<Integer>());

        try {
            new IntBufferAssertion(null, new FailDescription()).containsExactly(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, new FailDescription()).containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsExactly(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsExactly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactly(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactly(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsExactly(1, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1, 2, 3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1, 3, 2, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1, 3, 2, 4));
        new IntBufferAssertion(createIntBuffer(new int[0]), new FailDescription()).rewindAndContainsExactly();
        new IntBufferAssertion(createIntBuffer(new int[0]), new FailDescription()).rewindAndContainsExactly(new ArrayList<Integer>());
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactly(1, 2, 3, 4, 5);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1, 2, 3, 4, 5));

        try {
            new IntBufferAssertion(null, new FailDescription()).rewindAndContainsExactly(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, new FailDescription()).rewindAndContainsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsExactly(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsExactly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsExactlyInOrder(1, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(1, 2, 3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(Arrays.asList(1, 2, 3, 4));
        new IntBufferAssertion(createIntBuffer(new int[0]), new FailDescription()).containsExactlyInOrder();
        new IntBufferAssertion(createIntBuffer(new int[0]), new FailDescription()).containsExactlyInOrder(new ArrayList<Integer>());

        try {
            new IntBufferAssertion(null, new FailDescription()).containsExactlyInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsExactlyInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(1, 2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsExactlyInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder(1, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(1, 2, 3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4));
        new IntBufferAssertion(createIntBuffer(new int[0]), new FailDescription()).rewindAndContainsExactlyInOrder();
        new IntBufferAssertion(createIntBuffer(new int[0]), new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Integer>());
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));

        try {
            new IntBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(1, 2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAny(2, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsAny(2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsAny(4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsAny(5, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).containsAny(Arrays.asList(5, 3));

        try {
            new IntBufferAssertion(null, new FailDescription()).containsAny(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, new FailDescription()).containsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAny();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAny(1, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAny(Arrays.asList(1, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAny(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAny(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).containsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsAny(Arrays.asList(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).containsAny(Arrays.asList(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAny(2, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(5, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(Arrays.asList(5, 3));
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAny(1, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAny(Arrays.asList(1, 3));

        try {
            new IntBufferAssertion(null, new FailDescription()).rewindAndContainsAny(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, new FailDescription()).rewindAndContainsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAny();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAny(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAny(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).rewindAndContainsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsAny(Arrays.asList(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).rewindAndContainsAny(Arrays.asList(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsNone(3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsNone(3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsNone(Arrays.asList(3, 4));
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsNone(1, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsNone(Arrays.asList(1, 3));
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsNone(4, 5);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsNone(Arrays.asList(4, 5));

        try {
            new IntBufferAssertion(null, new FailDescription()).containsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, new FailDescription()).containsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsNone();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).containsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).containsNone(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).containsNone(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsNone(3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsNone(3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsNone(Arrays.asList(3, 4));
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsNone(4, 5);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsNone(Arrays.asList(4, 5));

        try {
            new IntBufferAssertion(null, new FailDescription()).rewindAndContainsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, new FailDescription()).rewindAndContainsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsNone();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsNone(1, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsNone(Arrays.asList(1, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).rewindAndContainsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).rewindAndContainsNone(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).rewindAndContainsNone(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new IntBufferAssertion(createIntBuffer(new int[0]), new FailDescription()).createCollectionAssertion(false).isEmpty();
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).createCollectionAssertion(false).isNotEmpty();

        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription()).createCollectionAssertion(false).isEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), new FailDescription("Message")).createCollectionAssertion(false).isEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>.");
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

    private static IntBuffer createIntBuffer(final int[] values) {
        return createIntBuffer(values, 0);
    }

    private static IntBuffer createIntBuffer(final int[] values, final int position) {
        return createIntBuffer(values, position, values.length);
    }

    private static IntBuffer createIntBuffer(final int[] values, final int position, final int limit) {
        return createIntBuffer(values, position, limit, values.length);
    }

    private static IntBuffer createIntBuffer(final int[] values, final int position, final int limit, final int capacity) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(capacity * 4);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        for (int value : values) {
            intBuffer.put(value);
        }
        intBuffer.position(position);
        intBuffer.limit(limit);
        return intBuffer;
    }

}
