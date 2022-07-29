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
package ru.d_shap.assertions.asimp.java.lang;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link IterableAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IterableAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IterableAssertionTest() {
        super();
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable());

        try {
            initializeWithRawActual(Raw.<String>iterableAssertion(), new Object());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Iterable> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.<String>iterableAssertion(), new Object(), "Message");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Iterable> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).isEmpty();
        initialize(Raw.iterableAssertion(), DataHelper.createHashSet()).isEmpty();
        initialize(Raw.iterableAssertion(), DataHelper.createTreeSet()).isEmpty();
        initialize(Raw.iterableAssertion(), DataHelper.createTreeSet()).isNotNull().isEmpty().isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2")).isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2"), "Message").isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[val1, val2]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).isNullOrEmpty();
        initialize(Raw.iterableAssertion(), DataHelper.createHashSet()).isNullOrEmpty();
        initialize(Raw.iterableAssertion(), DataHelper.createTreeSet()).isNullOrEmpty();
        initialize(Raw.<String>iterableAssertion(), null).isNullOrEmpty();
        initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).isNotNull().isNullOrEmpty().isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().isNullOrEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2")).isNullOrEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2"), "Message").isNullOrEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2")).isNotEmpty();
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("test1", "test2")).isNotEmpty();
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("test1", "test2")).isNotNull().isNotEmpty().isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.iterableAssertion(), DataHelper.createHashSet()).isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.iterableAssertion(), DataHelper.createHashSet(), "Message").isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.iterableAssertion(), DataHelper.createTreeSet()).isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.iterableAssertion(), DataHelper.createTreeSet(), "Message").isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2")).contains("val1");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2")).contains("val2");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable(null, "val1", "val2")).contains(null);
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", null, "val2")).contains(null);
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", null, "val2")).contains(null);
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2")).isNotNull().contains("val1").isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().contains("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).contains("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").contains("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), DataHelper.createIterable((Object) "val1", '1')).contains("val3");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2")).contains("val3");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2"), "Message").contains("val3");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2")).doesNotContain("val3");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", null)).doesNotContain("val3");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2")).doesNotContain(null);
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2")).isNotNull().doesNotContain("val3").isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().doesNotContain("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).doesNotContain("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").doesNotContain("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), DataHelper.createIterable((Object) "val1", '1')).doesNotContain("val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2")).doesNotContain("val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2")).doesNotContain("val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2"), "Message").doesNotContain("val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<val2> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val2");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val3");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val1");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll("val5", "val1", "val3");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val5", "val4");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val1", "val4", "val5", "val2");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", null)).containsAll("val3", "val1", "val4", null, "val2");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).isNotNull().containsAll("val1", "val2").isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().containsAll("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAll("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAll("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAll((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAll((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsAll((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsAll((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsAll();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsAll();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll("val0", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iterableAssertion(), DataHelper.createIterable((Object) "val1", "val2", "val3", "val4", '1')).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val2"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val3"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val3", "val1"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val5", "val1", "val3"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val3", "val5", "val4"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val3", "val1", "val4", "val5", "val2"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", null)).containsAll(DataHelper.createIterable("val3", "val1", "val4", null, "val2"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).isNotNull().containsAll(DataHelper.createIterable("val1", "val2")).isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().containsAll(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAll(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAll(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAll((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAll((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsAll((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsAll((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsAll(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsAll(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val0", "val1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val1", "val2"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"), "Message").containsAll(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val3");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val3", "val5");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val3", "val4", "val5");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val1", "val1", "val2", "val2")).containsAllInOrder("val1", "val1", "val1", "val2", "val2");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", null)).containsAllInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).isNotNull().containsAllInOrder("val1", "val2").isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().containsAllInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAllInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAllInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAllInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAllInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsAllInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsAllInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsAllInOrder();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsAllInOrder();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val3", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val1", "val1")).containsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(Raw.iterableAssertion(), DataHelper.createIterable((Object) "val1", "val2", "val3", "val4", '1')).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val2"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val3"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val3", "val5"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val3", "val4", "val5"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val1", "val1", "val2", "val2")).containsAllInOrder(DataHelper.createIterable("val1", "val1", "val1", "val2", "val2"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", null)).containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", null));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).isNotNull().containsAllInOrder(DataHelper.createIterable("val1", "val2")).isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val3", "val1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val1", "val1")).containsAllInOrder(DataHelper.createIterable("val1", "val1", "val1", "val1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly("val1", "val2", "val3");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly("val2", "val1", "val3");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly("val2", "val3", "val1");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly("val3", "val2", "val1");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsExactly("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsExactly("val2", "val4", "val1", "val3", "val5");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", null)).containsExactly("val2", "val4", "val1", "val3", null);
        initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsExactly();
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).isNotNull().containsExactly("val1", "val2", "val3").isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().containsExactly("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactly("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactly("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactly((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactly((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsExactly((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsExactly((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly("val3", "val2", "val1", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly("val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly("val2", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iterableAssertion(), DataHelper.createIterable((Object) "val1", "val2", '1')).containsExactly("val2", "val4", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly("val2", "val4", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3"), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val1", "val2", "val3"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val1", "val3"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val3", "val1"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val3", "val2", "val1"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsExactly(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsExactly(DataHelper.createIterable("val2", "val4", "val1", "val3", "val5"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", null)).containsExactly(DataHelper.createIterable("val2", "val4", "val1", "val3", null));
        initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsExactly(DataHelper.<String>createIterable());
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).isNotNull().containsExactly(DataHelper.createIterable("val1", "val2", "val3")).isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().containsExactly(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactly(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactly(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactly((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactly((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsExactly((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsExactly((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val1", "val2", "val3", "val4"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val3", "val2", "val1", "val4"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val1", "val2"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val4", "val1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3"), "Message").containsExactly(DataHelper.createIterable("val2", "val4", "val1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", null)).containsExactlyInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsExactlyInOrder();
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).isNotNull().containsExactlyInOrder("val1", "val2", "val3").isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().containsExactlyInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactlyInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactlyInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactlyInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsExactlyInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactlyInOrder("val2", "val3");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactlyInOrder();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iterableAssertion(), DataHelper.createIterable((Object) "val1", "val2", '1')).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3"), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", null)).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", null));
        initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsExactlyInOrder(DataHelper.<String>createIterable());
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).isNotNull().containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3")).isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val2", "val3"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val4"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val3", "val1", "val2"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3"), "Message").containsExactlyInOrder(DataHelper.createIterable("val3", "val1", "val2"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsAny("val1", "val3", "val5");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsAny("val6", "val2", "val4");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAny("val7", "val9", "val1", "val5", "val3");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", null)).containsAny("val7", "val9", null);
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).isNotNull().containsAny("val1", "val3", "val5").isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().containsAny("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAny("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAny("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAny((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAny((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsAny((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsAny((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsAny();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsAny();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsAny("val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iterableAssertion(), DataHelper.createIterable((Object) "val1", "val2", "val3", "val4", '1')).containsAny("val8", "val7");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAny("val8", "val7");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"), "Message").containsAny("val8", "val7");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsAny(DataHelper.createIterable("val1", "val3", "val5"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsAny(DataHelper.createIterable("val6", "val2", "val4"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAny(DataHelper.createIterable("val7", "val9", "val1", "val5", "val3"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", null)).containsAny(DataHelper.createIterable("val7", "val9", null));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).isNotNull().containsAny(DataHelper.createIterable("val1", "val3", "val5")).isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().containsAny(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAny(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAny(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAny((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAny((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsAny((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsAny((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsAny(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsAny(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsAny(DataHelper.createIterable("val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).containsAny(DataHelper.createIterable("val8", "val7"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"), "Message").containsAny(DataHelper.createIterable("val8", "val7"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsNone("val4", "val5", "val6");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsNone("val8", "val4");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", null)).containsNone("val8", "val4");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsNone("val8", null);
        initialize(Raw.iterableAssertion(), DataHelper.createIterable((Object) "val1", "val2", '1')).containsNone("val8", "val4");
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).isNotNull().containsNone("val4", "val5", "val6").isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().containsNone("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsNone("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsNone("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsNone((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsNone((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsNone((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsNone((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsNone();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsNone();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsNone("val4", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iterableAssertion(), DataHelper.createIterable((Object) "val1", "val2", '1')).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3"), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsNone(DataHelper.createIterable("val4", "val5", "val6"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsNone(DataHelper.createIterable("val8", "val4"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", null)).containsNone(DataHelper.createIterable("val8", "val4"));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsNone(DataHelper.createIterable("val8", null));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).isNotNull().containsNone(DataHelper.createIterable("val4", "val5", "val6")).isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().containsNone(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsNone(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsNone(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsNone((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsNone((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsNone((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsNone((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).containsNone(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").containsNone(DataHelper.<String>createIterable());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsNone(DataHelper.createIterable("val4", "val2"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).containsNone(DataHelper.createIterable("val5", "val4", "val2", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3"), "Message").containsNone(DataHelper.createIterable("val5", "val4", "val2", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).toSize().isEqualTo(3);
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).toSize().isGreaterThan(2);
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).toSize().isLessThan(6);

        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).toSize().isEqualTo(5);
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).toSize().isGreaterThan(1);
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).toSize().isLessThan(9);

        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).isNotNull().toSize().isEqualTo(5);

        try {
            Raw.<String>iterableAssertion().toSize();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).toSize();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").toSize();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).toSize()).isEqualTo(1);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3"), "Message").toSize()).isEqualTo(1);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).toSize().isEqualTo(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3"), "Message").toSize().isEqualTo(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void toSizeMatcherTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).toSize(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).toSize(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).toSize(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).toSize(Matchers.equalTo(5));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).toSize(Matchers.greaterThan(4));
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).toSize(Matchers.lessThan(6));

        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).isNotNull().toSize(Matchers.equalTo(5)).isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().toSize(Matchers.equalTo(0));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).toSize(Matchers.equalTo(0));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").toSize(Matchers.equalTo(0));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).toSize(null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").toSize(null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable()).toSize(null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.<String>createIterable(), "Message").toSize(null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).toSize(Matchers.equalTo(4));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3"), "Message").toSize(Matchers.equalTo(4));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).hasSize(3);
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).hasSize(5);
        initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")).isNotNull().hasSize(5).isInstanceOf(Iterable.class);

        try {
            Raw.<String>iterableAssertion().hasSize(3);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).hasSize(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").hasSize(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).hasSize(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3"), "Message").hasSize(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.<String>iterableAssertion(), null).isNull();

        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3")).isNull();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), DataHelper.createIterable("val1", "val2", "val3"), "Message").isNull();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Iterable<String> value = DataHelper.createIterable("val1", "val2", "val3");
        initialize(Raw.<String>iterableAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.<String>iterableAssertion(), value).isSameAs(DataHelper.createIterable("val1", "val2", "val3"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[val1, val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), value, "Message").isSameAs(DataHelper.createIterable("val1", "val2", "val3"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<[val1, val2, val3]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Iterable<String> value = DataHelper.createIterable("val1", "val2", "val3");
        initialize(Raw.<String>iterableAssertion(), value).isNotSameAs(DataHelper.createIterable("val1", "val2", "val3"));

        try {
            initialize(Raw.<String>iterableAssertion(), value).isNotSameAs(value);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<[val1, val2, val3]>");
        }
    }

}
