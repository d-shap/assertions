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
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).contains("val1");
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).contains("val2");

        try {
            new ObjectArrayAssertion(null, null).contains("val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).contains("val3");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, "Message").contains("val3");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).doesNotContain("val3");

        try {
            new ObjectArrayAssertion(null, null).doesNotContain("val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).doesNotContain("val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, "Message").doesNotContain("val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAll("val1");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsAll("val1", "val3");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsAll("val4", "val2");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsAll(Arrays.asList("val4", "val2"));

        try {
            new ObjectArrayAssertion(null, null).containsAll("val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, null).containsAll(new ArrayList<String>());
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAll((Object[]) null);
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAll();
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAll((Iterable<String>) null);
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAll(new ArrayList<String>());
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAll("val2", "val3");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, "Message").containsAll("val2", "val3");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAll(Arrays.asList("val2", "val3"));
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, "Message").containsAll(Arrays.asList("val2", "val3"));
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val2, val3]> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAllInOrder("val1");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsAllInOrder("val1", "val3", "val4");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsAllInOrder(Arrays.asList("val1", "val3", "val4"));

        try {
            new ObjectArrayAssertion(null, null).containsAllInOrder("val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, null).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAllInOrder((Object[]) null);
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAllInOrder();
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAllInOrder("val2", "val3");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAllInOrder("val2", "val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, "Message").containsAllInOrder("val2", "val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAllInOrder(Arrays.asList("val2", "val1"));
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, "Message").containsAllInOrder(Arrays.asList("val2", "val1"));
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsExactly("val1", "val2");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsExactly("val1", "val2", "val3", "val4");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsExactly("val1", "val3", "val2", "val4");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsExactly(Arrays.asList("val1", "val3", "val2", "val4"));
        new ObjectArrayAssertion(new String[0], null).containsExactly();
        new ObjectArrayAssertion(new String[0], null).containsExactly(new ArrayList<String>());

        try {
            new ObjectArrayAssertion(null, null).containsExactly("val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, null).containsExactly(new ArrayList<String>());
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsExactly((Object[]) null);
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsExactly((Iterable<String>) null);
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsExactly("val2", "val3");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsExactly("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsExactly();
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsExactly(new ArrayList<String>());
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsExactly("val1", "val1", "val3", "val2");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, "Message").containsExactly("val1", "val1", "val3", "val2");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsExactly(Arrays.asList("val1", "val1", "val3", "val2"));
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, "Message").containsExactly(Arrays.asList("val1", "val1", "val3", "val2"));
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsExactlyInOrder("val1", "val2");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsExactlyInOrder("val1", "val2", "val3", "val4");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4"));
        new ObjectArrayAssertion(new String[0], null).containsExactlyInOrder();
        new ObjectArrayAssertion(new String[0], null).containsExactlyInOrder(new ArrayList<String>());

        try {
            new ObjectArrayAssertion(null, null).containsExactlyInOrder("val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, null).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsExactlyInOrder((Object[]) null);
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsExactlyInOrder("val2", "val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsExactlyInOrder("val1", "val2", "val3");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsExactlyInOrder();
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsExactlyInOrder("val2", "val3", "val1", "val4");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, "Message").containsExactlyInOrder("val2", "val3", "val1", "val4");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsExactlyInOrder(Arrays.asList("val2", "val3", "val1", "val4"));
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, "Message").containsExactlyInOrder(Arrays.asList("val2", "val3", "val1", "val4"));
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAny("val2", "val3");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsAny("val2");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsAny("val4");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsAny("val5", "val3");
        new ObjectArrayAssertion(new String[]{"val1", "val2", "val3", "val4"}, null).containsAny(Arrays.asList("val5", "val3"));

        try {
            new ObjectArrayAssertion(null, null).containsAny("val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, null).containsAny(new ArrayList<String>());
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAny((Object[]) null);
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAny();
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAny((Iterable<String>) null);
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAny(new ArrayList<String>());
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAny("val3", "val4");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val3, val4]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, "Message").containsAny("val3", "val4");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val3, val4]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsAny(Arrays.asList("val3", "val4"));
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val3, val4]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, "Message").containsAny(Arrays.asList("val3", "val4"));
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val3, val4]> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsNone("val3");
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsNone("val3", "val4");
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsNone(Arrays.asList("val3", "val4"));

        try {
            new ObjectArrayAssertion(null, null).containsNone("val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(null, null).containsNone(new ArrayList<String>());
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsNone((Object[]) null);
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsNone();
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsNone((Iterable<String>) null);
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsNone(new ArrayList<String>());
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsNone("val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val1]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsNone("val2", "val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, "Message").containsNone("val2", "val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).containsNone(Arrays.asList("val2", "val1"));
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, "Message").containsNone(Arrays.asList("val2", "val1"));
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new ObjectArrayAssertion(new String[0], null).createCollectionAssertion().isEmpty();
        new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).createCollectionAssertion().isNotEmpty();

        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, null).createCollectionAssertion().isEmpty();
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[val1, val2]>");
        }
        try {
            new ObjectArrayAssertion(new String[]{"val1", "val2"}, "Message").createCollectionAssertion().isEmpty();
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[val1, val2]>");
        }
    }

}
