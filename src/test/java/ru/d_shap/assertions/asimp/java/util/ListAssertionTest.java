///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions library provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions library.
//
// Assertions library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.asimp.java.util;

import java.util.LinkedList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link ListAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ListAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ListAssertionTest() {
        super();
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList());

        try {
            initializeWithRawActual(Raw.<String>listAssertion(), new Object());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.List> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.<String>listAssertion(), new Object(), "Message");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.List> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).isEmpty();
        initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).isNotNull().isEmpty().isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().isEmpty();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).isEmpty();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").isEmpty();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).isEmpty();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2"), "Message").isEmpty();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[val1, val2]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).isNullOrEmpty();
        initialize(Raw.<String>listAssertion(), null).isNullOrEmpty();
        initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).isNotNull().isNullOrEmpty().isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().isNullOrEmpty();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).isNullOrEmpty();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2"), "Message").isNullOrEmpty();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).isNotEmpty();
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("test1", "test2")).isNotEmpty();
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).isNotNull().isNotEmpty().isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().isNotEmpty();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).isNotEmpty();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").isNotEmpty();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).isNotEmpty();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").isNotEmpty();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void isRandomAccessTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).isRandomAccess();
        initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).isNotNull().isRandomAccess().isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().isRandomAccess();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).isRandomAccess();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").isRandomAccess();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), new LinkedList<String>()).isRandomAccess();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.util.RandomAccess> but was:<java.util.LinkedList>");
        }
        try {
            initialize(Raw.<String>listAssertion(), new LinkedList<String>(), "Message").isRandomAccess();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.util.RandomAccess> but was:<java.util.LinkedList>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void isNotRandomAccessTest() {
        initialize(Raw.<String>listAssertion(), new LinkedList<String>()).isNotRandomAccess();
        initialize(Raw.<String>listAssertion(), new LinkedList<String>()).isNotNull().isNotRandomAccess().isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().isNotRandomAccess();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).isNotRandomAccess();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").isNotRandomAccess();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).isNotRandomAccess();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual value should not be the subtype of the expected value.\n\tExpected:<java.util.RandomAccess> but was:<java.util.ArrayList>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").isNotRandomAccess();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's class.\n\tActual value should not be the subtype of the expected value.\n\tExpected:<java.util.RandomAccess> but was:<java.util.ArrayList>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.<String>listAssertion(), null).isEqualTo(null);
        initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).isEqualTo(DataHelper.<String>createArrayList());
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("value")).isEqualTo(DataHelper.createArrayList("value"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).isEqualTo(DataHelper.createArrayList("val1", "val2"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList(null, "val1", "val2")).isEqualTo(DataHelper.createArrayList(null, "val1", "val2"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", null, "val2")).isEqualTo(DataHelper.createArrayList("val1", null, "val2"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", null)).isEqualTo(DataHelper.createArrayList("val1", "val2", null));
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f)).isEqualTo(DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f));
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0)).isEqualTo(DataHelper.createArrayList(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("value")).isNotNull().isEqualTo(DataHelper.createArrayList("value")).isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().isEqualTo(DataHelper.<String>createArrayList());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).isEqualTo(DataHelper.<String>createArrayList());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").isEqualTo(DataHelper.<String>createArrayList());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).isEqualTo(null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").isEqualTo(null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("value")).isEqualTo(null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[value]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("value"), "Message").isEqualTo(null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[value]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("value")).isEqualTo(DataHelper.<String>createArrayList());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<EMPTY>> but was:<[value]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("value"), "Message").isEqualTo(DataHelper.<String>createArrayList());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<EMPTY>> but was:<[value]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).isEqualTo(DataHelper.createArrayList("value"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<[value]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").isEqualTo(DataHelper.createArrayList("value"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<[value]> but was:<<EMPTY>>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.<String>listAssertion(), null).isNotEqualTo(DataHelper.<String>createArrayList());
        initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).isNotEqualTo(null);
        initialize(Raw.<String>listAssertion(), null).isNotEqualTo(DataHelper.createArrayList("value"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("value")).isNotEqualTo(null);
        initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).isNotEqualTo(DataHelper.createArrayList("value"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("value")).isNotEqualTo(DataHelper.<String>createArrayList());
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1")).isNotEqualTo(DataHelper.createArrayList("val2"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).isNotEqualTo(DataHelper.createArrayList(null, "val1", "val2"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).isNotEqualTo(DataHelper.createArrayList("val1", null, "val2"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).isNotEqualTo(DataHelper.createArrayList("val1", "val2", null));
        initialize(Raw.<Integer>listAssertion(), DataHelper.createArrayList(5, 10)).isNotEqualTo(DataHelper.createArrayList(15, 20));
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY)).isNotEqualTo(DataHelper.createArrayList(Float.NEGATIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY));
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY)).isNotEqualTo(DataHelper.createArrayList(Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1")).isNotNull().isNotEqualTo(DataHelper.createArrayList("val2")).isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().isNotEqualTo(DataHelper.<String>createArrayList());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).isNotEqualTo(null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).isNotEqualTo(DataHelper.<String>createArrayList());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").isNotEqualTo(DataHelper.<String>createArrayList());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).isNotEqualTo(DataHelper.createArrayList("val1", "val2"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2"), "Message").isNotEqualTo(DataHelper.createArrayList("val1", "val2"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<[val1, val2]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).contains("val1");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).contains("val2");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList(null, "val1", "val2")).contains(null);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", null, "val2")).contains(null);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", null)).contains(null);
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f)).contains(Float.POSITIVE_INFINITY);
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0)).contains(Double.POSITIVE_INFINITY);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).isNotNull().contains("val1").isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().contains("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).contains("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").contains("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).contains("val3");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2"), "Message").contains("val3");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", '1')).contains("val3");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", '1'), "Message").contains("val3");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(1.0f, Float.POSITIVE_INFINITY)).contains(Float.NEGATIVE_INFINITY);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<-Infinity> but was:<[1.0f, Infinity]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(1.0f, Float.POSITIVE_INFINITY), "Message").contains(Float.NEGATIVE_INFINITY);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<-Infinity> but was:<[1.0f, Infinity]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).doesNotContain("val3");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", null)).doesNotContain("val3");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).doesNotContain(null);
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY)).doesNotContain(3.0f);
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.POSITIVE_INFINITY)).doesNotContain(3.0);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).isNotNull().doesNotContain("val3").isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().doesNotContain("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).doesNotContain("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").doesNotContain("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).doesNotContain("val1");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2"), "Message").doesNotContain("val1");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2")).doesNotContain("val2");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2"), "Message").doesNotContain("val2");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", null, "val2")).doesNotContain(null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<<NULL>> but was:<[val1, <NULL>, val2]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", null, "val2"), "Message").doesNotContain(null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<<NULL>> but was:<[val1, <NULL>, val2]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", '1')).doesNotContain("val1");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", '1'), "Message").doesNotContain("val1");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY)).doesNotContain(Float.POSITIVE_INFINITY);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<Infinity> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY), "Message").doesNotContain(Float.POSITIVE_INFINITY);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<Infinity> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val2");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val3");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val1");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll("val5", "val1", "val3");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val5", "val4");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val1", "val4", "val5", "val2");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", null)).containsAll("val3", "val1", "val4", null, "val2");
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f)).containsAll(Float.NEGATIVE_INFINITY, Float.NaN);
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0)).containsAll(Double.NEGATIVE_INFINITY, Double.NaN);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).isNotNull().containsAll("val1", "val2").isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().containsAll("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsAll("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsAll("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsAll((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsAll((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsAll((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsAll((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsAll();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsAll();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val6");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll("val0", "val1");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val1", "val2");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", "val2", "val3", "val4", '1')).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", "val2", "val3", "val4", '1'), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY)).containsAll(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY), "Message").containsAll(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val2"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val3"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val3", "val1"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val5", "val1", "val3"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val3", "val5", "val4"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val3", "val1", "val4", "val5", "val2"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", null)).containsAll(DataHelper.createIterable("val3", "val1", "val4", null, "val2"));
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f)).containsAll(DataHelper.createIterable(Float.NEGATIVE_INFINITY, Float.NaN));
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0)).containsAll(DataHelper.createIterable(Double.NEGATIVE_INFINITY, Double.NaN));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).isNotNull().containsAll(DataHelper.createIterable("val1", "val2")).isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().containsAll(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsAll(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsAll(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsAll((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsAll((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsAll((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsAll((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsAll(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsAll(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val6"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val0", "val1"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val1", "val2"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY)).containsAll(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY), "Message").containsAll(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[Infinity, -Infinity]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val3");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val3", "val5");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val3", "val4", "val5");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val1", "val1", "val2", "val2")).containsAllInOrder("val1", "val1", "val1", "val2", "val2");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", null)).containsAllInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f)).containsAllInOrder(Float.NaN, Float.NEGATIVE_INFINITY, 3.0f);
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0)).containsAllInOrder(Double.NaN, Double.NEGATIVE_INFINITY, 3.0);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).isNotNull().containsAllInOrder("val1", "val2").isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().containsAllInOrder("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsAllInOrder("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsAllInOrder("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsAllInOrder((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsAllInOrder((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsAllInOrder((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsAllInOrder((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsAllInOrder();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsAllInOrder();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val6");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val3", "val1");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val1", "val1")).containsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", "val2", "val3", "val4", '1')).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", "val2", "val3", "val4", '1'), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY)).containsAllInOrder(Float.POSITIVE_INFINITY, Float.NaN);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY), "Message").containsAllInOrder(Float.POSITIVE_INFINITY, Float.NaN);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val2"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val3"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val3", "val5"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val3", "val4", "val5"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val1", "val1", "val2", "val2")).containsAllInOrder(DataHelper.createIterable("val1", "val1", "val1", "val2", "val2"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", null)).containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", null));
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f)).containsAllInOrder(DataHelper.createIterable(Float.NaN, Float.NEGATIVE_INFINITY, 3.0f));
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0)).containsAllInOrder(DataHelper.createIterable(Double.NaN, Double.NEGATIVE_INFINITY, 3.0));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).isNotNull().containsAllInOrder(DataHelper.createIterable("val1", "val2")).isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsAllInOrder((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsAllInOrder((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val6"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val3", "val1"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val1", "val1")).containsAllInOrder(DataHelper.createIterable("val1", "val1", "val1", "val1"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY)).containsAllInOrder(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NaN));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY), "Message").containsAllInOrder(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NaN));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[Infinity, NaN]> but was:<[NaN, Infinity]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly("val1", "val2", "val3");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly("val2", "val1", "val3");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly("val2", "val3", "val1");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly("val3", "val2", "val1");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsExactly("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsExactly("val2", "val4", "val1", "val3", "val5");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", null)).containsExactly("val2", "val4", "val1", "val3", null);
        initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsExactly();
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f)).containsExactly(Float.NEGATIVE_INFINITY, Float.NaN, 3.0f, Float.POSITIVE_INFINITY);
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0)).containsExactly(Double.NEGATIVE_INFINITY, Double.NaN, 3.0, Double.POSITIVE_INFINITY);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).isNotNull().containsExactly("val1", "val2", "val3").isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().containsExactly("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsExactly("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsExactly("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsExactly((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsExactly((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsExactly((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsExactly((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly("val3", "val2", "val1", "val4");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly("val1", "val2");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly("val2", "val1");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly("val2", "val4", "val1");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3"), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", "val2", '1')).containsExactly("val2", "val4", "val1");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", "val2", '1'), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY)).containsExactly(Float.NaN, 3.0f);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY), "Message").containsExactly(Float.NaN, 3.0f);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val1", "val2", "val3"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val1", "val3"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val3", "val1"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val3", "val2", "val1"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsExactly(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsExactly(DataHelper.createIterable("val2", "val4", "val1", "val3", "val5"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", null)).containsExactly(DataHelper.createIterable("val2", "val4", "val1", "val3", null));
        initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsExactly(DataHelper.<String>createIterable());
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f)).containsExactly(DataHelper.createIterable(Float.NEGATIVE_INFINITY, Float.NaN, 3.0f, Float.POSITIVE_INFINITY));
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0)).containsExactly(DataHelper.createIterable(Double.NEGATIVE_INFINITY, Double.NaN, 3.0, Double.POSITIVE_INFINITY));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).isNotNull().containsExactly(DataHelper.createIterable("val1", "val2", "val3")).isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().containsExactly(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsExactly(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsExactly(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsExactly((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsExactly((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsExactly((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsExactly((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val1", "val2", "val3", "val4"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val3", "val2", "val1", "val4"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val1", "val2"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val1"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val4", "val1"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3"), "Message").containsExactly(DataHelper.createIterable("val2", "val4", "val1"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY)).containsExactly(DataHelper.createIterable(Float.NaN, 3.0f));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY), "Message").containsExactly(DataHelper.createIterable(Float.NaN, 3.0f));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", null)).containsExactlyInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsExactlyInOrder();
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f)).containsExactlyInOrder(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f);
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0)).containsExactlyInOrder(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).isNotNull().containsExactlyInOrder("val1", "val2", "val3").isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().containsExactlyInOrder("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsExactlyInOrder("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsExactlyInOrder("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsExactlyInOrder((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsExactlyInOrder((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactlyInOrder("val2", "val3");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactlyInOrder();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3"), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", "val2", '1')).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", "val2", '1'), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY)).containsExactlyInOrder(Float.POSITIVE_INFINITY, Float.NaN, 3.0f);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY), "Message").containsExactlyInOrder(Float.POSITIVE_INFINITY, Float.NaN, 3.0f);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", null)).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", null));
        initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsExactlyInOrder(DataHelper.<String>createIterable());
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f)).containsExactlyInOrder(DataHelper.createIterable(Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 3.0f));
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0)).containsExactlyInOrder(DataHelper.createIterable(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 3.0));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).isNotNull().containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3")).isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val2", "val3"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val4"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val3", "val1", "val2"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3"), "Message").containsExactlyInOrder(DataHelper.createIterable("val3", "val1", "val2"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY)).containsExactlyInOrder(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NaN, 3.0f));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY), "Message").containsExactlyInOrder(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NaN, 3.0f));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[Infinity, NaN, 3.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsAny("val1", "val3", "val5");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsAny("val6", "val2", "val4");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAny("val7", "val9", "val1", "val5", "val3");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", null)).containsAny("val7", "val9", "val1", null, "val3");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", null)).containsAny("val7", "val9", null);
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.NEGATIVE_INFINITY, 3.0f)).containsAny(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY);
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.NEGATIVE_INFINITY, 3.0)).containsAny(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).isNotNull().containsAny("val1", "val3", "val5").isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().containsAny("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsAny("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsAny("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsAny((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsAny((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsAny((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsAny((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsAny();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsAny();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsAny("val4", "val5", "val6");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAny("val8", "val7");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5"), "Message").containsAny("val8", "val7");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", "val2", "val3", "val4", '1')).containsAny("val8", "val7");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", "val2", "val3", "val4", '1'), "Message").containsAny("val8", "val7");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY)).containsAny(Float.NEGATIVE_INFINITY, 4.0f);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY), "Message").containsAny(Float.NEGATIVE_INFINITY, 4.0f);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsAny(DataHelper.createIterable("val1", "val3", "val5"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsAny(DataHelper.createIterable("val6", "val2", "val4"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAny(DataHelper.createIterable("val7", "val9", "val1", "val5", "val3"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", null)).containsAny(DataHelper.createIterable("val7", "val9", "val1", null, "val3"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", null)).containsAny(DataHelper.createIterable("val7", "val9", null));
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.NEGATIVE_INFINITY, 3.0f)).containsAny(DataHelper.createIterable(Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY));
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.NEGATIVE_INFINITY, 3.0)).containsAny(DataHelper.createIterable(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).isNotNull().containsAny(DataHelper.createIterable("val1", "val3", "val5")).isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().containsAny(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsAny(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsAny(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsAny((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsAny((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsAny((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsAny((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsAny(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsAny(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsAny(DataHelper.createIterable("val4", "val5", "val6"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).containsAny(DataHelper.createIterable("val8", "val7"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5"), "Message").containsAny(DataHelper.createIterable("val8", "val7"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY)).containsAny(DataHelper.createIterable(Float.NEGATIVE_INFINITY, 4.0f));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY), "Message").containsAny(DataHelper.createIterable(Float.NEGATIVE_INFINITY, 4.0f));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[-Infinity, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsNone("val4", "val5", "val6");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsNone("val8", "val4");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", null)).containsNone("val8", "val4");
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsNone("val8", "val4", null);
        initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", "val2", '1')).containsNone("val8", "val4");
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.NEGATIVE_INFINITY, 3.0f)).containsNone(Float.POSITIVE_INFINITY, 4.0f);
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.NEGATIVE_INFINITY, 3.0)).containsNone(Double.POSITIVE_INFINITY, 4.0);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).isNotNull().containsNone("val4", "val5", "val6").isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().containsNone("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsNone("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsNone("val");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsNone((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsNone((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsNone((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsNone((String[]) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsNone();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsNone();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsNone("val4", "val2");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3"), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", "val2", '1')).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.listAssertion(), DataHelper.createArrayList((Object) "val1", "val2", '1'), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY)).containsNone(Float.NaN, 4.0f);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY), "Message").containsNone(Float.NaN, 4.0f);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsNone(DataHelper.createIterable("val4", "val5", "val6"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsNone(DataHelper.createIterable("val8", "val4"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", null)).containsNone(DataHelper.createIterable("val8", "val4"));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsNone(DataHelper.createIterable("val8", "val4", null));
        initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, Float.NEGATIVE_INFINITY, 3.0f)).containsNone(DataHelper.createIterable(Float.POSITIVE_INFINITY, 4.0f));
        initialize(Raw.<Double>listAssertion(), DataHelper.createArrayList(Double.NaN, Double.NEGATIVE_INFINITY, 3.0)).containsNone(DataHelper.createIterable(Double.POSITIVE_INFINITY, 4.0));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).isNotNull().containsNone(DataHelper.createIterable("val4", "val5", "val6")).isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().containsNone(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsNone(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsNone(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).containsNone((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").containsNone((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsNone((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsNone((Iterable<String>) null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).containsNone(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").containsNone(DataHelper.<String>createIterable());
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsNone(DataHelper.createIterable("val4", "val2"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).containsNone(DataHelper.createIterable("val5", "val4", "val2", "val6"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3"), "Message").containsNone(DataHelper.createIterable("val5", "val4", "val2", "val6"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY)).containsNone(DataHelper.createIterable(Float.NaN, 4.0f));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
        try {
            initialize(Raw.<Float>listAssertion(), DataHelper.createArrayList(Float.NaN, 3.0f, Float.POSITIVE_INFINITY), "Message").containsNone(DataHelper.createIterable(Float.NaN, 4.0f));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[NaN, 4.0f]> but was:<[NaN, 3.0f, Infinity]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).toSize().isEqualTo(3);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).toSize().isGreaterThan(2);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).toSize().isLessThan(6);

        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).toSize().isEqualTo(5);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).toSize().isGreaterThan(1);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).toSize().isLessThan(9);

        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).isNotNull().toSize().isEqualTo(3);

        try {
            Raw.<String>listAssertion().toSize();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).toSize();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").toSize();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).toSize()).isEqualTo(1);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3"), "Message").toSize()).isEqualTo(1);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).toSize().isEqualTo(4);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3"), "Message").toSize().isEqualTo(4);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void toSizeMatcherTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).toSize(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).toSize(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).toSize(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).toSize(Matchers.equalTo(5));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).toSize(Matchers.greaterThan(4));
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).toSize(Matchers.lessThan(6));

        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).isNotNull().toSize(Matchers.is(Matchers.equalTo(3))).isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().toSize(Matchers.equalTo(0));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).toSize(Matchers.equalTo(0));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").toSize(Matchers.equalTo(0));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).toSize(null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").toSize(null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList()).toSize(null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.<String>createArrayList(), "Message").toSize(null);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).toSize(Matchers.equalTo(4));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3"), "Message").toSize(Matchers.equalTo(4));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).hasSize(3);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5")).hasSize(5);
        initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).isNotNull().hasSize(3).isInstanceOf(List.class);

        try {
            Raw.<String>listAssertion().hasSize(1);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null).hasSize(1);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), null, "Message").hasSize(1);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).hasSize(4);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3"), "Message").hasSize(4);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.<String>listAssertion(), null).isNull();

        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3")).isNull();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), DataHelper.createArrayList("val1", "val2", "val3"), "Message").isNull();
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        List<String> value = DataHelper.createArrayList("val1", "val2", "val3");
        initialize(Raw.<String>listAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.<String>listAssertion(), value).isSameAs(DataHelper.createArrayList("val1", "val2", "val3"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[val1, val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), value, "Message").isSameAs(DataHelper.createArrayList("val1", "val2", "val3"));
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<[val1, val2, val3]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link ListAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        List<String> value = DataHelper.createArrayList("val1", "val2", "val3");
        initialize(Raw.<String>listAssertion(), value).isNotSameAs(DataHelper.createArrayList("val1", "val2", "val3"));

        try {
            initialize(Raw.<String>listAssertion(), value).isNotSameAs(value);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(ListAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<[val1, val2, val3]>");
        }
    }

}
