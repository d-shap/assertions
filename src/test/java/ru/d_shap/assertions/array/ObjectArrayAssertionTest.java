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

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ObjectArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ObjectArrayAssertionTest extends AssertionTest {

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
    public void actualValueValidatorTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[0]);

        try {
            initialize(Raw.<String>objectArrayAssertion(), new Object());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new Object(), "Message");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).contains("val1");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).contains("val2");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{null, "val1", "val2"}).contains(null);
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", null, "val2"}).contains(null);
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", null}).contains(null);

        try {
            initialize(Raw.<String>objectArrayAssertion(), null).contains("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).contains("val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").contains("val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).doesNotContain("val3");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", null}).doesNotContain("val3");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).doesNotContain(null);

        try {
            initialize(Raw.<String>objectArrayAssertion(), null).doesNotContain("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).doesNotContain("val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").doesNotContain("val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAll("val1");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAll("val1", "val3");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAll("val4", "val2");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAll(Arrays.asList("val4", "val2"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsAll(null, "val2");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsAll(Arrays.asList(null, "val2"));

        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAll("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAll(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAll((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAll((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAll((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAll((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAll();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAll(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAll("val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsAll("val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAll(Arrays.asList("val2", "val3"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsAll(Arrays.asList("val2", "val3"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val2, val3]> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAllInOrder("val1");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAllInOrder("val1", "val3", "val4");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAllInOrder(Arrays.asList("val1", "val3", "val4"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsAllInOrder("val1", "val3", null);
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsAllInOrder(Arrays.asList("val1", "val3", null));

        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAllInOrder("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAllInOrder((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAllInOrder((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAllInOrder();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAllInOrder("val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAllInOrder("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsAllInOrder("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAllInOrder(Arrays.asList("val2", "val1"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsAllInOrder(Arrays.asList("val2", "val1"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactly("val1", "val2");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactly("val1", "val2", "val3", "val4");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactly("val1", "val3", "val2", "val4");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactly(Arrays.asList("val1", "val3", "val2", "val4"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsExactly("val1", "val3", "val2", null);
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsExactly(Arrays.asList("val1", "val3", "val2", null));
        initialize(Raw.<String>objectArrayAssertion(), new String[0]).containsExactly();
        initialize(Raw.<String>objectArrayAssertion(), new String[0]).containsExactly(new ArrayList<String>());

        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactly("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactly(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactly((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactly((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactly((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactly((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactly("val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactly("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactly();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactly(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactly("val1", "val1", "val3", "val2");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}, "Message").containsExactly("val1", "val1", "val3", "val2");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactly(Arrays.asList("val1", "val1", "val3", "val2"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}, "Message").containsExactly(Arrays.asList("val1", "val1", "val3", "val2"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactlyInOrder("val1", "val2");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactlyInOrder("val1", "val2", "val3", "val4");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsExactlyInOrder("val1", "val2", "val3", null);
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", null));
        initialize(Raw.<String>objectArrayAssertion(), new String[0]).containsExactlyInOrder();
        initialize(Raw.<String>objectArrayAssertion(), new String[0]).containsExactlyInOrder(new ArrayList<String>());

        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactlyInOrder("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactlyInOrder((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactlyInOrder((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactlyInOrder("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactlyInOrder("val1", "val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactlyInOrder();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactlyInOrder("val2", "val3", "val1", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}, "Message").containsExactlyInOrder("val2", "val3", "val1", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactlyInOrder(Arrays.asList("val2", "val3", "val1", "val4"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}, "Message").containsExactlyInOrder(Arrays.asList("val2", "val3", "val1", "val4"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAny("val2", "val3");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAny("val2");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAny("val4");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAny("val5", "val3");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAny(Arrays.asList("val5", "val3"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsAny("val5", null);
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsAny(Arrays.asList("val5", null));

        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAny("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAny(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAny((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAny((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAny((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAny((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAny();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAny(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAny("val3", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val3, val4]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsAny("val3", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val3, val4]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAny(Arrays.asList("val3", "val4"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val3, val4]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsAny(Arrays.asList("val3", "val4"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val3, val4]> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone("val3");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone("val3", "val4");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone(Arrays.asList("val3", "val4"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", null}).containsNone("val3", "val4");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", null}).containsNone(Arrays.asList("val3", "val4"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone("val3", null);
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone(Arrays.asList("val3", null));

        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsNone("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsNone(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsNone((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsNone((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone("val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsNone("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone(Arrays.asList("val2", "val1"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsNone(Arrays.asList("val2", "val1"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val2, val1]> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.<String>objectArrayAssertion(), null).isNull();

        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).isNull();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").isNull();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        String[] value = new String[]{"val1", "val2"};
        initialize(Raw.<String>objectArrayAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.<String>objectArrayAssertion(), value).isSameAs(new String[]{"val1", "val2"});
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[val1, val2]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), value, "Message").isSameAs(new String[]{"val1", "val2"});
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[val1, val2]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), value).isSameAs("test");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        String[] value = new String[]{"val1", "val2"};
        initialize(Raw.<String>objectArrayAssertion(), value).isNotSameAs(new String[]{"val1", "val2"});
        initialize(Raw.<String>objectArrayAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.<String>objectArrayAssertion(), value).isNotSameAs(value);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.<String>objectArrayAssertion(), null).asString(null));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.<String>objectArrayAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.<String>objectArrayAssertion(), null).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(initialize(Raw.<String>objectArrayAssertion(), null).asString(new String[]{"val1", "val2"})).isEqualTo("[val1, val2]");
    }

}
