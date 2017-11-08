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
 * Tests for {@link ObjectArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ObjectArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public ObjectArrayAssertionTest() {
        super();
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).contains("val1");
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).contains("val2");
        new ObjectArrayAssertion(new String[]{null, "val1", "val2"}, new FailDescription()).contains(null);
        new ObjectArrayAssertion(new String[]{"val1", null, "val2"}, new FailDescription()).contains(null);
        new ObjectArrayAssertion(new String[]{"val1", "val2", null}, new FailDescription()).contains(null);

        try {
            new ObjectArrayAssertion(null, new FailDescription()).contains("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).contains("val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription("Message")).contains("val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>.");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).doesNotContain("val3");
        new ObjectArrayAssertion(new String[]{"val1", null}, new FailDescription()).doesNotContain("val3");
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).doesNotContain(null);

        try {
            new ObjectArrayAssertion(null, new FailDescription()).doesNotContain("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).doesNotContain("val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription("Message")).doesNotContain("val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>.");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAll("val1");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsAll("val1", "val3");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsAll("val4", "val2");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsAll(Arrays.asList("val4", "val2"));
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", null}, new FailDescription()).containsAll(null, "val2");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", null}, new FailDescription()).containsAll(Arrays.asList(null, "val2"));

        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsAll("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsAll(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsAll((Object[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsAll((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAll((Object[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAll((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAll();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAll(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAll("val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val2, val3]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription("Message")).containsAll("val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val2, val3]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAll(Arrays.asList("val2", "val3"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val2, val3]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription("Message")).containsAll(Arrays.asList("val2", "val3"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val2, val3]> but was:<[val1, val2]>.");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAllInOrder("val1");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsAllInOrder("val1", "val3", "val4");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsAllInOrder(Arrays.asList("val1", "val3", "val4"));
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", null}, new FailDescription()).containsAllInOrder("val1", "val3", null);
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", null}, new FailDescription()).containsAllInOrder(Arrays.asList("val1", "val3", null));

        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsAllInOrder("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsAllInOrder((Object[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAllInOrder((Object[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAllInOrder();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAllInOrder("val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val2, val3]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAllInOrder("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val2, val1]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription("Message")).containsAllInOrder("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val2, val1]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAllInOrder(Arrays.asList("val2", "val1"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val2, val1]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription("Message")).containsAllInOrder(Arrays.asList("val2", "val1"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val2, val1]> but was:<[val1, val2]>.");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsExactly("val1", "val2");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsExactly("val1", "val2", "val3", "val4");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsExactly("val1", "val3", "val2", "val4");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsExactly(Arrays.asList("val1", "val3", "val2", "val4"));
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", null}, new FailDescription()).containsExactly("val1", "val3", "val2", null);
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", null}, new FailDescription()).containsExactly(Arrays.asList("val1", "val3", "val2", null));
        new ObjectArrayAssertion(new String[0], new FailDescription()).containsExactly();
        new ObjectArrayAssertion(new String[0], new FailDescription()).containsExactly(new ArrayList<String>());

        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsExactly("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsExactly(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsExactly((Object[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsExactly((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsExactly((Object[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsExactly((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsExactly("val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val3]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsExactly("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsExactly();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsExactly(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsExactly("val1", "val1", "val3", "val2");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription("Message")).containsExactly("val1", "val1", "val3", "val2");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsExactly(Arrays.asList("val1", "val1", "val3", "val2"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription("Message")).containsExactly(Arrays.asList("val1", "val1", "val3", "val2"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>.");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsExactlyInOrder("val1", "val2");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsExactlyInOrder("val1", "val2", "val3", "val4");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4"));
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", null}, new FailDescription()).containsExactlyInOrder("val1", "val2", "val3", null);
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", null}, new FailDescription()).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", null));
        new ObjectArrayAssertion(new String[0], new FailDescription()).containsExactlyInOrder();
        new ObjectArrayAssertion(new String[0], new FailDescription()).containsExactlyInOrder(new ArrayList<String>());

        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsExactlyInOrder("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsExactlyInOrder((Object[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsExactlyInOrder((Object[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsExactlyInOrder("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val1]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsExactlyInOrder("val1", "val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3]> but was:<[val1, val2, val3, val4]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsExactlyInOrder();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsExactlyInOrder("val2", "val3", "val1", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription("Message")).containsExactlyInOrder("val2", "val3", "val1", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsExactlyInOrder(Arrays.asList("val2", "val3", "val1", "val4"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription("Message")).containsExactlyInOrder(Arrays.asList("val2", "val3", "val1", "val4"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>.");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAny("val2", "val3");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsAny("val2");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsAny("val4");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsAny("val5", "val3");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, new FailDescription()).containsAny(Arrays.asList("val5", "val3"));
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", null}, new FailDescription()).containsAny("val5", null);
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", null}, new FailDescription()).containsAny(Arrays.asList("val5", null));

        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsAny("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsAny(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsAny((Object[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsAny((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAny((Object[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAny((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAny();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAny(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAny("val3", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val3, val4]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription("Message")).containsAny("val3", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val3, val4]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsAny(Arrays.asList("val3", "val4"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val3, val4]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription("Message")).containsAny(Arrays.asList("val3", "val4"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val3, val4]> but was:<[val1, val2]>.");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsNone("val3");
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsNone("val3", "val4");
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsNone(Arrays.asList("val3", "val4"));
        new ObjectArrayAssertion(new String[]{"val1", null}, new FailDescription()).containsNone("val3", "val4");
        new ObjectArrayAssertion(new String[]{"val1", null}, new FailDescription()).containsNone(Arrays.asList("val3", "val4"));
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsNone("val3", null);
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsNone(Arrays.asList("val3", null));

        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsNone("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsNone(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsNone((Object[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, new FailDescription()).containsNone((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsNone((Object[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsNone((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsNone();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsNone(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsNone("val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val1]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsNone("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val2, val1]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription("Message")).containsNone("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val2, val1]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).containsNone(Arrays.asList("val2", "val1"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val2, val1]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription("Message")).containsNone(Arrays.asList("val2", "val1"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val2, val1]> but was:<[val1, val2]>.");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new ObjectArrayAssertion(null, new FailDescription()).isNull();

        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription()).isNull();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, new FailDescription("Message")).isNull();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[val1, val2]>.");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        String[] value = new String[]{"val1", "val2"};
        new ObjectArrayAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new ObjectArrayAssertion(value, new FailDescription()).isSameAs(new String[]{"val1", "val2"});
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[val1, val2]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(value, new FailDescription("Message")).isSameAs(new String[]{"val1", "val2"});
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[val1, val2]> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[val1, val2]>.");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        String[] value = new String[]{"val1", "val2"};
        new ObjectArrayAssertion(value, new FailDescription()).isNotSameAs(new String[]{"val1", "val2"});
        new ObjectArrayAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new ObjectArrayAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[val1, val2]>.");
        }
        try {
            new ObjectArrayAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[val1, val2]>.");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ObjectArrayAssertion(null, new FailDescription()).asString(null)).isNull();
        Assertions.assertThat(new ObjectArrayAssertion(null, new FailDescription()).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(new ObjectArrayAssertion(null, new FailDescription()).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(new ObjectArrayAssertion(null, new FailDescription()).asString(new String[]{"val1", "val2"})).isEqualTo("[val1, val2]");
    }

}
