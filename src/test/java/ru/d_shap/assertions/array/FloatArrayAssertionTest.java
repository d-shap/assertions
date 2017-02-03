///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).contains(1.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).contains(2.0f);

        try {
            new FloatArrayAssertion(null, null).contains(1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).contains(3.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, "Message").contains(3.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).doesNotContain(3.0f);

        try {
            new FloatArrayAssertion(null, null).doesNotContain(1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).doesNotContain(1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, "Message").doesNotContain(1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAll(1.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsAll(1.0f, 3.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsAll(4.0f, 2.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsAll(Arrays.asList(4.0f, 2.0f));

        try {
            new FloatArrayAssertion(null, null).containsAll(1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, null).containsAll(new ArrayList<Float>());
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAll((float[]) null);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAll();
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAll((Iterable<Float>) null);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAll(new ArrayList<Float>());
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAll(2.0f, 3.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, "Message").containsAll(2.0f, 3.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, "Message").containsAll(Arrays.asList(2.0f, 3.0f));
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAllInOrder(1.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsAllInOrder(1.0f, 3.0f, 4.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsAllInOrder(Arrays.asList(1.0f, 3.0f, 4.0f));

        try {
            new FloatArrayAssertion(null, null).containsAllInOrder(1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, null).containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAllInOrder((float[]) null);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAllInOrder();
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAllInOrder((Iterable<Float>) null);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAllInOrder(new ArrayList<Float>());
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAllInOrder(2.0f, 3.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAllInOrder(2.0f, 1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, "Message").containsAllInOrder(2.0f, 1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, "Message").containsAllInOrder(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsExactly(1.0f, 2.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsExactly(1.0f, 2.0f, 3.0f, 4.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsExactly(1.0f, 3.0f, 2.0f, 4.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsExactly(Arrays.asList(1.0f, 3.0f, 2.0f, 4.0f));

        try {
            new FloatArrayAssertion(null, null).containsExactly(1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, null).containsExactly(new ArrayList<Float>());
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsExactly((float[]) null);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsExactly();
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsExactly((Iterable<Float>) null);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsExactly(new ArrayList<Float>());
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsExactly(2.0f, 3.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsExactly(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, "Message").containsExactly(1.0f, 1.0f, 3.0f, 2.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, "Message").containsExactly(Arrays.asList(1.0f, 1.0f, 3.0f, 2.0f));
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsExactlyInOrder(1.0f, 2.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsExactlyInOrder(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f));

        try {
            new FloatArrayAssertion(null, null).containsExactlyInOrder(1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, null).containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsExactlyInOrder((float[]) null);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsExactlyInOrder();
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsExactlyInOrder((Iterable<Float>) null);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsExactlyInOrder(new ArrayList<Float>());
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsExactlyInOrder(2.0f, 1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsExactlyInOrder(1.0f, 2.0f, 3.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsExactlyInOrder(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, "Message").containsExactlyInOrder(2.0f, 3.0f, 1.0f, 4.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, "Message").containsExactlyInOrder(Arrays.asList(2.0f, 3.0f, 1.0f, 4.0f));
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAny(2.0f, 3.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsAny(2.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsAny(4.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsAny(5.0f, 3.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f, 3.0f, 4.0f}, null).containsAny(Arrays.asList(5.0f, 3.0f));

        try {
            new FloatArrayAssertion(null, null).containsAny(1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, null).containsAny(new ArrayList<Float>());
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAny((float[]) null);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAny();
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAny((Iterable<Float>) null);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAny(new ArrayList<Float>());
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAny(3.0f, 4.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, "Message").containsAny(3.0f, 4.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, "Message").containsAny(Arrays.asList(3.0f, 4.0f));
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsNone(3.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsNone(3.0f, 4.0f);
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsNone(Arrays.asList(3.0f, 4.0f));

        try {
            new FloatArrayAssertion(null, null).containsNone(1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(null, null).containsNone(new ArrayList<Float>());
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsNone((float[]) null);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsNone();
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsNone((Iterable<Float>) null);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsNone(new ArrayList<Float>());
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsNone(1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsNone(2.0f, 1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, "Message").containsNone(2.0f, 1.0f);
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).containsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, "Message").containsNone(Arrays.asList(2.0f, 1.0f));
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new FloatArrayAssertion(new float[0], null).createCollectionAssertion().isEmpty();
        new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).createCollectionAssertion().isNotEmpty();

        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, null).createCollectionAssertion().isEmpty();
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1.0, 2.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f, 2.0f}, "Message").createCollectionAssertion().isEmpty();
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1.0, 2.0]>");
        }
    }

}
