///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
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
package ru.d_shap.assertions.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link CollectionAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class CollectionAssertionTest {

    /**
     * Test class constructor.
     */
    public CollectionAssertionTest() {
        super();
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new CollectionAssertion(new ArrayList<String>(), null).isEmpty();
        new CollectionAssertion(new HashSet<String>(), null).isEmpty();

        try {
            new CollectionAssertion(Arrays.asList("val1", "val2"), null).isEmpty();
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should be empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new CollectionAssertion(Arrays.asList("val1", "val2"), null).isNotEmpty();
        new CollectionAssertion(Arrays.asList("test1", "test2"), null).isNotEmpty();

        try {
            new CollectionAssertion(new ArrayList<String>(), null).isNotEmpty();
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should not be empty.");
        }
        try {
            new CollectionAssertion(new HashSet<String>(), null).isNotEmpty();
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should not be empty.");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void containsTest() {
        new CollectionAssertion(Arrays.asList("val1", "val2"), null).contains("val1");
        new CollectionAssertion(Arrays.asList("val1", "val2"), null).contains("val2");

        try {
            new CollectionAssertion(Arrays.asList("val1", "val2"), null).contains("val3");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2"), null).contains(1);
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain the expected value. Expected:<1> but was:<[val1, val2]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2"), null).contains(new StringBuilder("test1"));
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain the expected value. Expected:<test1> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new CollectionAssertion(Arrays.asList("val1", "val2"), null).doesNotContain("val3");
        new CollectionAssertion(Arrays.asList("val1", "val2"), null).doesNotContain(1);
        new CollectionAssertion(Arrays.asList("val1", "val2"), null).doesNotContain(new StringBuilder("test1"));

        try {
            new CollectionAssertion(Arrays.asList("val1", "val2"), null).doesNotContain("val1");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should not contain the expected value. Expected:<val1> but was:<[val1, val2]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2"), null).doesNotContain("val2");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val1", "val2");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val1", "val3");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val1", "val3", "val5");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val3", "val4", "val5");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val1", "val2", "val3", "val4", "val5");

        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val1", "val6");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val3", "val1");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain all of the expected values. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void containsAllInAnyOrderTest() {
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInAnyOrder("val1", "val2");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInAnyOrder("val1", "val3");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInAnyOrder("val3", "val1");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInAnyOrder("val5", "val1", "val3");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInAnyOrder("val3", "val5", "val4");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInAnyOrder("val3", "val1", "val4", "val5", "val2");

        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInAnyOrder("val1", "val6");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain all of the expected values in any order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInAnyOrder("val0", "val1");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain all of the expected values in any order. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInAnyOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain all of the expected values in any order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactly("val1", "val2", "val3");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsExactly("val1", "val2", "val3", "val4", "val5");

        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactly("val1", "val2");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactly("val2", "val3");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain the expected values exactly. Expected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactly("val1", "val2", "val4");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain the expected values exactly. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void containsExactlyInAnyOrderTest() {
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInAnyOrder("val1", "val2", "val3");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInAnyOrder("val2", "val1", "val3");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInAnyOrder("val2", "val3", "val1");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInAnyOrder("val3", "val2", "val1");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsExactlyInAnyOrder("val1", "val2", "val3", "val4", "val5");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsExactlyInAnyOrder("val2", "val4", "val1", "val3", "val5");

        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInAnyOrder("val1", "val2", "val3", "val4");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain the expected values exactly in any order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInAnyOrder("val3", "val2", "val1", "val4");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain the expected values exactly in any order. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInAnyOrder("val1", "val2");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain the expected values exactly in any order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInAnyOrder("val2", "val1");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain the expected values exactly in any order. Expected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInAnyOrder("val2", "val4", "val1");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain the expected values exactly in any order. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsAny("val1", "val3", "val5");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsAny("val6", "val2", "val4");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAny("val7", "val9", "val1", "val5", "val3");

        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsAny("val4", "val5", "val6");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAny("val8", "val7");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsNone("val4", "val5", "val6");
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsNone("val8", "val4");

        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsNone("val2");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should not contain any of the expected values. Expected:<[val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsNone("val4", "val2");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("Collection assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Collection should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).toSize().isEqualTo(3);
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).toSize().isGreaterThan(2);
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).toSize().isLessThan(6);

        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).toSize().isEqualTo(5);
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).toSize().isGreaterThan(1);
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).toSize().isLessThan(9);
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3"), null).hasSize(3);
        new CollectionAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).hasSize(5);
    }

    /**
     * {@link CollectionAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new CollectionAssertion(null, null).asString(null)).isNull();
        Assertions.assertThat(new CollectionAssertion(null, null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(new CollectionAssertion(null, null).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(new CollectionAssertion(null, null).asString(Arrays.asList("val1", "val2", "val3", "val4", "val5"))).isEqualTo("[val1, val2, val3, val4, val5]");
    }

}
