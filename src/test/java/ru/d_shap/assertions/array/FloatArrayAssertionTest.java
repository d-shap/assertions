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
package ru.d_shap.assertions.array;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

/**
 * Tests for {@link FloatArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public FloatArrayAssertionTest() {
        super();
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).contains(1.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).contains(2.0f);

        try {
            new FloatArrayAssertion(null, new FailDescription()).contains(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).contains(3.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription("Message")).contains(3.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).doesNotContain(3.0f);

        try {
            new FloatArrayAssertion(null, new FailDescription()).doesNotContain(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).doesNotContain(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription("Message")).doesNotContain(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAll(1.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsAll(1.0f, 3.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsAll(4.0f, 2.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsAll(Arrays.asList(4.0f, 2.0f));

        try {
            new FloatArrayAssertion(null, new FailDescription()).containsAll(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsAll(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsAll((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsAll((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAll((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAll((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAll();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAll(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAll(2.0f, 3.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription("Message")).containsAll(2.0f, 3.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription("Message")).containsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAllInOrder(1.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsAllInOrder(1.0f, 3.0f, 4.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsAllInOrder(Arrays.asList(1.0f, 3.0f, 4.0f));

        try {
            new FloatArrayAssertion(null, new FailDescription()).containsAllInOrder(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsAllInOrder((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAllInOrder((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAllInOrder();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAllInOrder(2.0f, 3.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription("Message")).containsAllInOrder(2.0f, 1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription("Message")).containsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsExactly(1.0f, 2.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsExactly(1.0f, 2.0f, 3.0f, 4.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsExactly(1.0f, 3.0f, 2.0f, 4.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsExactly(Arrays.asList(1.0f, 3.0f, 2.0f, 4.0f));
        new FloatArrayAssertion(new float[0], new FailDescription()).containsExactly();
        new FloatArrayAssertion(new float[0], new FailDescription()).containsExactly(new ArrayList<Float>());

        try {
            new FloatArrayAssertion(null, new FailDescription()).containsExactly(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsExactly((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsExactly((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsExactly((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsExactly(2.0f, 3.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsExactly();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsExactly(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription("Message")).containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription("Message")).containsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsExactlyInOrder(1.0f, 2.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));
        new FloatArrayAssertion(new float[0], new FailDescription()).containsExactlyInOrder();
        new FloatArrayAssertion(new float[0], new FailDescription()).containsExactlyInOrder(new ArrayList<Float>());

        try {
            new FloatArrayAssertion(null, new FailDescription()).containsExactlyInOrder(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsExactlyInOrder((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsExactlyInOrder();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription("Message")).containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription("Message")).containsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAny(2.0f, 3.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsAny(2.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsAny(4.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsAny(5.0f, 3.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, new FailDescription()).containsAny(Arrays.asList(5.0f, 3.0f));

        try {
            new FloatArrayAssertion(null, new FailDescription()).containsAny(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsAny(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsAny((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsAny((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAny((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAny((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAny();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAny(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAny(3.0f, 4.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription("Message")).containsAny(3.0f, 4.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription("Message")).containsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsNone(3.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsNone(3.0f, 4.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsNone(Arrays.asList(3.0f, 4.0f));

        try {
            new FloatArrayAssertion(null, new FailDescription()).containsNone(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsNone(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsNone((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, new FailDescription()).containsNone((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsNone((float[]) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsNone((Iterable<Float>) null);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsNone();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsNone(new ArrayList<Float>());
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsNone(1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsNone(2.0f, 1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription("Message")).containsNone(2.0f, 1.0f);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).containsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription("Message")).containsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new FloatArrayAssertion(null, new FailDescription()).isNull();

        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription()).isNull();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, new FailDescription("Message")).isNull();
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        float[] value = new float[]{1.0f, 2.0f};
        new FloatArrayAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new FloatArrayAssertion(value, new FailDescription()).isSameAs(new float[]{1.0f, 2.0f});
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[1.0, 2.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(value, new FailDescription("Message")).isSameAs(new float[]{1.0f, 2.0f});
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[1.0, 2.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        float[] value = new float[]{1.0f, 2.0f};
        new FloatArrayAssertion(value, new FailDescription()).isNotSameAs(new float[]{1.0f, 2.0f});
        new FloatArrayAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new FloatArrayAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1.0, 2.0]>.");
        }
        try {
            new FloatArrayAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("FloatArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new FloatArrayAssertion(null, new FailDescription()).asString(null)).isNull();
        Assertions.assertThat(new FloatArrayAssertion(null, new FailDescription()).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(new FloatArrayAssertion(null, new FailDescription()).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(new FloatArrayAssertion(null, new FailDescription()).asString(new float[]{1.0f, 2.0f})).isEqualTo("[1.0, 2.0]");
    }

}
