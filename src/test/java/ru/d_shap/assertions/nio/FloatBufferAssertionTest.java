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
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

/**
 * Tests for {@link FloatBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatBufferAssertionTest {

    /**
     * Test class constructor.
     */
    public FloatBufferAssertionTest() {
        super();
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).contains(1.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).contains(2.0f);

        try {
            new FloatBufferAssertion(null, new FailDescription()).contains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).contains(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2.0> but was:<[4.0, 5.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).contains(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4.0> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).contains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).contains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContains(1.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContains(2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).rewindAndContains(2.0f);

        try {
            new FloatBufferAssertion(null, new FailDescription()).rewindAndContains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).rewindAndContains(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4.0> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).rewindAndContains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).doesNotContain(3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).doesNotContain(2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).doesNotContain(5.0f);

        try {
            new FloatBufferAssertion(null, new FailDescription()).doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).doesNotContain(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2.0> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndDoesNotContain(3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).rewindAndDoesNotContain(5.0f);

        try {
            new FloatBufferAssertion(null, new FailDescription()).rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).rewindAndDoesNotContain(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2.0> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).rewindAndDoesNotContain(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2.0> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAll(1.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsAll(1.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsAll(4.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsAll(Arrays.asList(4.0f, 2.0f));

        try {
            new FloatBufferAssertion(null, new FailDescription()).containsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, new FailDescription()).containsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAll();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).containsAll(1.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).containsAll(Arrays.asList(1.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).containsAll(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).containsAll(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).containsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).containsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAll(1.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(1.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(4.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(Arrays.asList(4.0f, 2.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).rewindAndContainsAll(1.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).rewindAndContainsAll(Arrays.asList(1.0f, 2.0f));

        try {
            new FloatBufferAssertion(null, new FailDescription()).rewindAndContainsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, new FailDescription()).rewindAndContainsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAll();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).rewindAndContainsAll(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).rewindAndContainsAll(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).rewindAndContainsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).rewindAndContainsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAllInOrder(1.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsAllInOrder(1.0f, 3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsAllInOrder(Arrays.asList(1.0f, 3.0f, 4.0f));

        try {
            new FloatBufferAssertion(null, new FailDescription()).containsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAllInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAllInOrder(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).containsAllInOrder(1.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).containsAllInOrder(Arrays.asList(1.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).containsAllInOrder(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).containsAllInOrder(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).containsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).containsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAllInOrder(1.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAllInOrder(1.0f, 3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(1.0f, 3.0f, 4.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).rewindAndContainsAllInOrder(1.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(1.0f, 2.0f));

        try {
            new FloatBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAllInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAllInOrder(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).rewindAndContainsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).rewindAndContainsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsExactly(1.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1.0f, 2.0f, 3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1.0f, 3.0f, 2.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsExactly(Arrays.asList(1.0f, 3.0f, 2.0f, 4.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[0]), new FailDescription()).containsExactly();
        new FloatBufferAssertion(createFloatBuffer(new float[0]), new FailDescription()).containsExactly(new ArrayList<Float>());

        try {
            new FloatBufferAssertion(null, new FailDescription()).containsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, new FailDescription()).containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsExactly(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsExactly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).containsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).containsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsExactly(1.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1.0f, 3.0f, 2.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1.0f, 3.0f, 2.0f, 4.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[0]), new FailDescription()).rewindAndContainsExactly();
        new FloatBufferAssertion(createFloatBuffer(new float[0]), new FailDescription()).rewindAndContainsExactly(new ArrayList<Float>());
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));

        try {
            new FloatBufferAssertion(null, new FailDescription()).rewindAndContainsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, new FailDescription()).rewindAndContainsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsExactly(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsExactly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsExactlyInOrder(1.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[0]), new FailDescription()).containsExactlyInOrder();
        new FloatBufferAssertion(createFloatBuffer(new float[0]), new FailDescription()).containsExactlyInOrder(new ArrayList<Float>());

        try {
            new FloatBufferAssertion(null, new FailDescription()).containsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsExactlyInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsExactlyInOrder(1.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[0]), new FailDescription()).rewindAndContainsExactlyInOrder();
        new FloatBufferAssertion(createFloatBuffer(new float[0]), new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Float>());
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));

        try {
            new FloatBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsExactlyInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAny(2.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsAny(2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsAny(4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsAny(5.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).containsAny(Arrays.asList(5.0f, 3.0f));

        try {
            new FloatBufferAssertion(null, new FailDescription()).containsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, new FailDescription()).containsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAny();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).containsAny(1.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).containsAny(Arrays.asList(1.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).containsAny(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).containsAny(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).containsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).containsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAny(2.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(5.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(Arrays.asList(5.0f, 3.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).rewindAndContainsAny(1.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).rewindAndContainsAny(Arrays.asList(1.0f, 3.0f));

        try {
            new FloatBufferAssertion(null, new FailDescription()).rewindAndContainsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, new FailDescription()).rewindAndContainsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAny();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).rewindAndContainsAny(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).rewindAndContainsAny(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).rewindAndContainsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).rewindAndContainsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsNone(3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsNone(3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsNone(Arrays.asList(3.0f, 4.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).containsNone(1.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).containsNone(Arrays.asList(1.0f, 3.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).containsNone(4.0f, 5.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).containsNone(Arrays.asList(4.0f, 5.0f));

        try {
            new FloatBufferAssertion(null, new FailDescription()).containsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, new FailDescription()).containsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsNone();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).containsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).containsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).containsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsNone(3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsNone(3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsNone(Arrays.asList(3.0f, 4.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).rewindAndContainsNone(4.0f, 5.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), new FailDescription()).rewindAndContainsNone(Arrays.asList(4.0f, 5.0f));

        try {
            new FloatBufferAssertion(null, new FailDescription()).rewindAndContainsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, new FailDescription()).rewindAndContainsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsNone();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).rewindAndContainsNone(1.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), new FailDescription()).rewindAndContainsNone(Arrays.asList(1.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).rewindAndContainsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).rewindAndContainsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).rewindAndContainsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new FloatBufferAssertion(null, new FailDescription()).isNull();

        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription()).isNull();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), new FailDescription("Message")).isNull();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        FloatBuffer value = createFloatBuffer(new float[]{1.0f, 2.0f});
        new FloatBufferAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new FloatBufferAssertion(value, new FailDescription()).isSameAs(createFloatBuffer(new float[]{1.0f, 2.0f}));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[1.0, 2.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(value, new FailDescription("Message")).isSameAs(createFloatBuffer(new float[]{1.0f, 2.0f}));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[1.0, 2.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        FloatBuffer value = createFloatBuffer(new float[]{1.0f, 2.0f});
        new FloatBufferAssertion(value, new FailDescription()).isNotSameAs(createFloatBuffer(new float[]{1.0f, 2.0f}));
        new FloatBufferAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new FloatBufferAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1.0, 2.0]>.");
        }
        try {
            new FloatBufferAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new FloatBufferAssertion(null, new FailDescription()).asString(null)).isNull();
        Assertions.assertThat(new FloatBufferAssertion(null, new FailDescription()).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(new FloatBufferAssertion(null, new FailDescription()).asString(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}))).isEqualTo("[1.0, 2.0, 3.0]");
        Assertions.assertThat(new FloatBufferAssertion(null, new FailDescription()).asString(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}))).isEqualTo("[1.0, 2.0, 3.0, 4.0, 5.0]");
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void positionTest() {
        FloatBuffer buffer = createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).contains(4.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContains(2.0f);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).doesNotContain(2.0f);
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

    private static FloatBuffer createFloatBuffer(final float[] values) {
        return createFloatBuffer(values, 0);
    }

    private static FloatBuffer createFloatBuffer(final float[] values, final int position) {
        return createFloatBuffer(values, position, values.length);
    }

    private static FloatBuffer createFloatBuffer(final float[] values, final int position, final int limit) {
        return createFloatBuffer(values, position, limit, values.length);
    }

    private static FloatBuffer createFloatBuffer(final float[] values, final int position, final int limit, final int capacity) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(capacity * 4);
        FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
        for (float value : values) {
            floatBuffer.put(value);
        }
        floatBuffer.position(position);
        floatBuffer.limit(limit);
        return floatBuffer;
    }

}
