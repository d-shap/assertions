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
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).contains(1.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).contains(2.0f);

        try {
            new FloatBufferAssertion(null, null).contains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).contains(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2.0> but was:<[4.0, 5.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).contains(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).contains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").contains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContains(1.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContains(2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).rewindAndContains(2.0f);

        try {
            new FloatBufferAssertion(null, null).rewindAndContains(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).rewindAndContains(4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContains(3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).doesNotContain(3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).doesNotContain(2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).doesNotContain(5.0f);

        try {
            new FloatBufferAssertion(null, null).doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).doesNotContain(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").doesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndDoesNotContain(3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).rewindAndDoesNotContain(5.0f);

        try {
            new FloatBufferAssertion(null, null).rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).rewindAndDoesNotContain(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2.0> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).rewindAndDoesNotContain(2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndDoesNotContain(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAll(1.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsAll(1.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsAll(4.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsAll(Arrays.asList(4.0f, 2.0f));

        try {
            new FloatBufferAssertion(null, null).containsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, null).containsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAll();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).containsAll(1.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).containsAll(Arrays.asList(1.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).containsAll(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).containsAll(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAll(1.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsAll(1.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsAll(4.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsAll(Arrays.asList(4.0f, 2.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).rewindAndContainsAll(1.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).rewindAndContainsAll(Arrays.asList(1.0f, 2.0f));

        try {
            new FloatBufferAssertion(null, null).rewindAndContainsAll(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, null).rewindAndContainsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAll((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAll((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAll();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAll(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).rewindAndContainsAll(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).rewindAndContainsAll(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAll(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAllInOrder(1.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsAllInOrder(1.0f, 3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsAllInOrder(Arrays.asList(1.0f, 3.0f, 4.0f));

        try {
            new FloatBufferAssertion(null, null).containsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, null).containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAllInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAllInOrder(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).containsAllInOrder(1.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).containsAllInOrder(Arrays.asList(1.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).containsAllInOrder(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).containsAllInOrder(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAllInOrder(1.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsAllInOrder(1.0f, 3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsAllInOrder(Arrays.asList(1.0f, 3.0f, 4.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).rewindAndContainsAllInOrder(1.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).rewindAndContainsAllInOrder(Arrays.asList(1.0f, 2.0f));

        try {
            new FloatBufferAssertion(null, null).rewindAndContainsAllInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, null).rewindAndContainsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAllInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAllInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAllInOrder(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).rewindAndContainsAllInOrder(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).rewindAndContainsAllInOrder(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsExactly(1.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsExactly(1.0f, 2.0f, 3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsExactly(1.0f, 3.0f, 2.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsExactly(Arrays.asList(1.0f, 3.0f, 2.0f, 4.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[0]), null).containsExactly();
        new FloatBufferAssertion(createFloatBuffer(new float[0]), null).containsExactly(new ArrayList<Float>());

        try {
            new FloatBufferAssertion(null, null).containsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, null).containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsExactly(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsExactly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).containsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).containsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").containsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsExactly(1.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1.0f, 3.0f, 2.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsExactly(Arrays.asList(1.0f, 3.0f, 2.0f, 4.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[0]), null).rewindAndContainsExactly();
        new FloatBufferAssertion(createFloatBuffer(new float[0]), null).rewindAndContainsExactly(new ArrayList<Float>());
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).rewindAndContainsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));

        try {
            new FloatBufferAssertion(null, null).rewindAndContainsExactly(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, null).rewindAndContainsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsExactly((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsExactly((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsExactly(2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsExactly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsExactly(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).rewindAndContainsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).rewindAndContainsExactly(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsExactlyInOrder(1.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[0]), null).containsExactlyInOrder();
        new FloatBufferAssertion(createFloatBuffer(new float[0]), null).containsExactlyInOrder(new ArrayList<Float>());

        try {
            new FloatBufferAssertion(null, null).containsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, null).containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsExactlyInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsExactlyInOrder(1.0f, 2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[0]), null).rewindAndContainsExactlyInOrder();
        new FloatBufferAssertion(createFloatBuffer(new float[0]), null).rewindAndContainsExactlyInOrder(new ArrayList<Float>());
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));

        try {
            new FloatBufferAssertion(null, null).rewindAndContainsExactlyInOrder(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, null).rewindAndContainsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsExactlyInOrder((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsExactlyInOrder();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).rewindAndContainsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).rewindAndContainsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAny(2.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsAny(2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsAny(4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsAny(5.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).containsAny(Arrays.asList(5.0f, 3.0f));

        try {
            new FloatBufferAssertion(null, null).containsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, null).containsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAny();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).containsAny(1.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).containsAny(Arrays.asList(1.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).containsAny(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).containsAny(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAny(2.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsAny(2.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsAny(4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsAny(5.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1, 2, 3, 4}), null).rewindAndContainsAny(Arrays.asList(5.0f, 3.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).rewindAndContainsAny(1.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).rewindAndContainsAny(Arrays.asList(1.0f, 3.0f));

        try {
            new FloatBufferAssertion(null, null).rewindAndContainsAny(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, null).rewindAndContainsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAny((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAny((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAny();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAny(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).rewindAndContainsAny(4.0f, 5.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).rewindAndContainsAny(Arrays.asList(4.0f, 5.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAny(3.0f, 4.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsNone(3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsNone(3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsNone(Arrays.asList(3.0f, 4.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).containsNone(1.0f, 3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).containsNone(Arrays.asList(1.0f, 3.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).containsNone(4.0f, 5.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).containsNone(Arrays.asList(4.0f, 5.0f));

        try {
            new FloatBufferAssertion(null, null).containsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, null).containsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsNone();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).containsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").containsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsNone(3.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsNone(3.0f, 4.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsNone(Arrays.asList(3.0f, 4.0f));
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).rewindAndContainsNone(4.0f, 5.0f);
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 0, 3), null).rewindAndContainsNone(Arrays.asList(4.0f, 5.0f));

        try {
            new FloatBufferAssertion(null, null).rewindAndContainsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(null, null).rewindAndContainsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsNone((float[]) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsNone((Iterable<Float>) null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsNone();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsNone(new ArrayList<Float>());
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsNone(1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).rewindAndContainsNone(1.0f, 3.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 3), null).rewindAndContainsNone(Arrays.asList(1.0f, 3.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsNone(2.0f, 1.0f);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).rewindAndContainsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").rewindAndContainsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new FloatBufferAssertion(createFloatBuffer(new float[0]), null).createCollectionAssertion(false).isEmpty();
        new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).createCollectionAssertion(false).isNotEmpty();

        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), null).createCollectionAssertion(false).isEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1.0, 2.0]>");
        }
        try {
            new FloatBufferAssertion(createFloatBuffer(new float[]{1.0f, 2.0f}), "Message").createCollectionAssertion(false).isEmpty();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1.0, 2.0]>");
        }
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
