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
package ru.d_shap.assertions.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedSet;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link SortedSetAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class SortedSetAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public SortedSetAssertionTest() {
        super();
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.sortedSetAssertion(), createTreeSet());

        try {
            initializeWithRawActual(Raw.<String>sortedSetAssertion(), new Object());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.<String>sortedSetAssertion(), new Object(), "Message");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.sortedSetAssertion(), createTreeSet()).isEmpty();

        try {
            Raw.<String>sortedSetAssertion().isEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).isEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").isEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).isEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2"), "Message").isEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[val1, val2]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.sortedSetAssertion(), createTreeSet()).isNullOrEmpty();
        initialize(Raw.<String>sortedSetAssertion(), null).isNullOrEmpty();

        try {
            Raw.<String>sortedSetAssertion().isNullOrEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).isNullOrEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2"), "Message").isNullOrEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).isNotEmpty();
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("test1", "test2")).isNotEmpty();

        try {
            Raw.<String>sortedSetAssertion().isNotEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).isNotEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.sortedSetAssertion(), createTreeSet()).isNotEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.sortedSetAssertion(), createTreeSet(), "Message").isNotEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).contains("val1");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).contains("val2");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet(null, "val1", "val2")).contains(null);
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", null, "val2")).contains(null);
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", null)).contains(null);

        try {
            Raw.<String>sortedSetAssertion().contains("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).contains("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").contains("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).contains("val3");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2"), "Message").contains("val3");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2')).contains('3');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3(51)> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2'), "Message").contains('3');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3(51)> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).doesNotContain("val3");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", null)).doesNotContain("val3");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).doesNotContain(null);

        try {
            Raw.<String>sortedSetAssertion().doesNotContain("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).doesNotContain("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").doesNotContain("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).doesNotContain("val1");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).doesNotContain("val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2"), "Message").doesNotContain("val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", null, "val2")).doesNotContain(null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<null> but was:<[null, val1, val2]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", null, "val2"), "Message").doesNotContain(null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<null> but was:<[null, val1, val2]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2')).doesNotContain('2');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2(50)> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2'), "Message").doesNotContain('2');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<2(50)> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void toHeadSetElementTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val0").containsExactlyInOrder();
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val1").containsExactlyInOrder();
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val2").containsExactlyInOrder("val1");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val3").containsExactlyInOrder("val1", "val2");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val4").containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val5").containsExactlyInOrder("val1", "val2", "val3", "val4");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val6").containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet(null, "val1", "val2", "val3", "val4")).toHeadSet("val2").containsExactlyInOrder(null, "val1");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(null).containsExactlyInOrder();

        try {
            Raw.<String>sortedSetAssertion().toHeadSet("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toHeadSet("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toHeadSet("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedSetAssertion(), createTreeSet()).toHeadSet("val")).containsExactlyInOrder("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's head elements up to element: val.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedSetAssertion(), createTreeSet(), "Message").toHeadSet("val")).containsExactlyInOrder("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's head elements up to element: val.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.sortedSetAssertion(), createTreeSet()).toHeadSet("val3").containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's head elements up to element: val3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val5]> but was:<[]>");
        }
        try {
            initialize(Raw.sortedSetAssertion(), createTreeSet(), "Message").toHeadSet("val3").containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's head elements up to element: val3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val5]> but was:<[]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val3").containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's head elements up to element: val3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val5]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toHeadSet("val3").containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's head elements up to element: val3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val5]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3', '4', '5')).toHeadSet((Character) '3').containsExactlyInOrder('4', '5');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's head elements up to element: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3', '4', '5'), "Message").toHeadSet((Character) '3').containsExactlyInOrder('4', '5');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's head elements up to element: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void toHeadSetCountTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(1).containsExactlyInOrder("val1");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(2).containsExactlyInOrder("val1", "val2");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(3).containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(4).containsExactlyInOrder("val1", "val2", "val3", "val4");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(5).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(6).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");

        SortedSet<String> sortedSet = createTreeSet("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), sortedSet).toHeadSet(4).isNotSameAs(sortedSet);
        initialize(Raw.<String>sortedSetAssertion(), sortedSet).toHeadSet(5).isSameAs(sortedSet);
        initialize(Raw.<String>sortedSetAssertion(), sortedSet).toHeadSet(6).isSameAs(sortedSet);

        try {
            Raw.<String>sortedSetAssertion().toHeadSet(1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toHeadSet(1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toHeadSet(1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toHeadSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toHeadSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).toHeadSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").toHeadSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).toHeadSet(-1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").toHeadSet(-1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            clearActual(initialize(Raw.sortedSetAssertion(), createTreeSet()).toHeadSet(1)).containsExactlyInOrder("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedSetAssertion(), createTreeSet(), "Message").toHeadSet(1)).containsExactlyInOrder("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.sortedSetAssertion(), createTreeSet()).toHeadSet(3).containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val5]> but was:<[]>");
        }
        try {
            initialize(Raw.sortedSetAssertion(), createTreeSet(), "Message").toHeadSet(3).containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val5]> but was:<[]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(3).containsExactlyInOrder("val4", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toHeadSet(3).containsExactlyInOrder("val4", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(5).containsExactlyInOrder("val4", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toHeadSet(5).containsExactlyInOrder("val4", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(6).containsExactlyInOrder("val4", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 6.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toHeadSet(6).containsExactlyInOrder("val4", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 6.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3', '4', '5')).toHeadSet(6).containsExactlyInOrder('4', '6');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 6.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[4(52), 6(54)]> but was:<[1(49), 2(50), 3(51), 4(52), 5(53)]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3', '4', '5'), "Message").toHeadSet(6).containsExactlyInOrder('4', '6');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 6.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[4(52), 6(54)]> but was:<[1(49), 2(50), 3(51), 4(52), 5(53)]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void toHeadSetElementMatcherTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val0", Matchers.emptyIterableOf(String.class));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val1", Matchers.emptyIterableOf(String.class));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val2", Matchers.hasItems("val1"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val3", Matchers.hasItems("val1", "val2"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val4", Matchers.hasItems("val1", "val2", "val3"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val5", Matchers.hasItems("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val6", Matchers.hasItems("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet(null, "val1", "val2", "val3", "val4")).toHeadSet("val2", Matchers.hasItems(null, "val1"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(null, Matchers.emptyIterableOf(String.class));

        try {
            Raw.<String>sortedSetAssertion().toHeadSet("val", Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toHeadSet("val", Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toHeadSet("val", Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toHeadSet("val", null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toHeadSet("val", null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).toHeadSet("val", null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").toHeadSet("val", null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val3", Matchers.hasItems("val4", "val5"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's head elements up to element: val3.\nExpected: (a collection containing \"val4\" and a collection containing \"val5\")\n     but: a collection containing \"val4\" was \"val1\", was \"val2\"");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toHeadSet("val3", Matchers.hasItems("val4", "val5"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's head elements up to element: val3.\nExpected: (a collection containing \"val4\" and a collection containing \"val5\")\n     but: a collection containing \"val4\" was \"val1\", was \"val2\"");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void toHeadSetCountMatcherTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(1, Matchers.hasItems("val1"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(2, Matchers.hasItems("val1", "val2"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(3, Matchers.hasItems("val1", "val2", "val3"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(4, Matchers.hasItems("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(5, Matchers.hasItems("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(6, Matchers.hasItems("val1", "val2", "val3", "val4", "val5"));

        try {
            Raw.<String>sortedSetAssertion().toHeadSet(1, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toHeadSet(1, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toHeadSet(1, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toHeadSet(0, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toHeadSet(0, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).toHeadSet(0, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").toHeadSet(0, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).toHeadSet(-1, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").toHeadSet(-1, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).toHeadSet(0, null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").toHeadSet(0, null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).toHeadSet(1, null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").toHeadSet(1, null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(3, Matchers.hasItems("val4", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 3.\nExpected: (a collection containing \"val4\" and a collection containing \"val6\")\n     but: a collection containing \"val4\" was \"val1\", was \"val2\", was \"val3\"");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toHeadSet(3, Matchers.hasItems("val4", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 3.\nExpected: (a collection containing \"val4\" and a collection containing \"val6\")\n     but: a collection containing \"val4\" was \"val1\", was \"val2\", was \"val3\"");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(5, Matchers.hasItems("val4", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 5.\nExpected: (a collection containing \"val4\" and a collection containing \"val6\")\n     but: a collection containing \"val6\" was \"val1\", was \"val2\", was \"val3\", was \"val4\", was \"val5\"");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toHeadSet(5, Matchers.hasItems("val4", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 5.\nExpected: (a collection containing \"val4\" and a collection containing \"val6\")\n     but: a collection containing \"val6\" was \"val1\", was \"val2\", was \"val3\", was \"val4\", was \"val5\"");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(6, Matchers.hasItems("val4", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 6.\nExpected: (a collection containing \"val4\" and a collection containing \"val6\")\n     but: a collection containing \"val6\" was \"val1\", was \"val2\", was \"val3\", was \"val4\", was \"val5\"");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toHeadSet(6, Matchers.hasItems("val4", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 6.\nExpected: (a collection containing \"val4\" and a collection containing \"val6\")\n     but: a collection containing \"val6\" was \"val1\", was \"val2\", was \"val3\", was \"val4\", was \"val5\"");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void toTailSetElementTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val0").containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val1").containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val2").containsExactlyInOrder("val2", "val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val3").containsExactlyInOrder("val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val4").containsExactlyInOrder("val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val5").containsExactlyInOrder("val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val6").containsExactlyInOrder();
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet(null, "val1", "val2", "val3", "val4")).toTailSet("val2").containsExactlyInOrder("val2", "val3", "val4");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(null).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");

        try {
            Raw.<String>sortedSetAssertion().toTailSet("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toTailSet("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toTailSet("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedSetAssertion(), createTreeSet()).toTailSet("val")).containsExactlyInOrder("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tail elements from element: val.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedSetAssertion(), createTreeSet(), "Message").toTailSet("val")).containsExactlyInOrder("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tail elements from element: val.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.sortedSetAssertion(), createTreeSet()).toTailSet("val3").containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tail elements from element: val3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val5]> but was:<[]>");
        }
        try {
            initialize(Raw.sortedSetAssertion(), createTreeSet(), "Message").toTailSet("val3").containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tail elements from element: val3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val5]> but was:<[]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val3").containsExactlyInOrder("val1", "val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tail elements from element: val3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toTailSet("val3").containsExactlyInOrder("val1", "val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tail elements from element: val3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val3, val4, val5]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3', '4', '5')).toTailSet((Character) '3').containsExactlyInOrder('1', '2');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tail elements from element: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[3(51), 4(52), 5(53)]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3', '4', '5'), "Message").toTailSet((Character) '3').containsExactlyInOrder('1', '2');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tail elements from element: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[3(51), 4(52), 5(53)]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void toTailSetCountTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(1).containsExactlyInOrder("val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(2).containsExactlyInOrder("val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(3).containsExactlyInOrder("val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(4).containsExactlyInOrder("val2", "val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(5).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(6).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");

        SortedSet<String> sortedSet = createTreeSet("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), sortedSet).toTailSet(4).isNotSameAs(sortedSet);
        initialize(Raw.<String>sortedSetAssertion(), sortedSet).toTailSet(5).isSameAs(sortedSet);
        initialize(Raw.<String>sortedSetAssertion(), sortedSet).toTailSet(6).isSameAs(sortedSet);

        try {
            Raw.<String>sortedSetAssertion().toTailSet(1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toTailSet(1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toTailSet(1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toTailSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toTailSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).toTailSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").toTailSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).toTailSet(-1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").toTailSet(-1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            clearActual(initialize(Raw.sortedSetAssertion(), createTreeSet()).toTailSet(1)).containsExactlyInOrder("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedSetAssertion(), createTreeSet(), "Message").toTailSet(1)).containsExactlyInOrder("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.sortedSetAssertion(), createTreeSet()).toTailSet(3).containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val5]> but was:<[]>");
        }
        try {
            initialize(Raw.sortedSetAssertion(), createTreeSet(), "Message").toTailSet(3).containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val5]> but was:<[]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(3).containsExactlyInOrder("val4", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val6]> but was:<[val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toTailSet(3).containsExactlyInOrder("val4", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val6]> but was:<[val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(5).containsExactlyInOrder("val4", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toTailSet(5).containsExactlyInOrder("val4", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(6).containsExactlyInOrder("val4", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 6.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toTailSet(6).containsExactlyInOrder("val4", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 6.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val4, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3', '4', '5')).toTailSet(6).containsExactlyInOrder('4', '6');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 6.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[4(52), 6(54)]> but was:<[1(49), 2(50), 3(51), 4(52), 5(53)]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3', '4', '5'), "Message").toTailSet(6).containsExactlyInOrder('4', '6');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 6.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[4(52), 6(54)]> but was:<[1(49), 2(50), 3(51), 4(52), 5(53)]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void toTailSetElementMatcherTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val0", Matchers.hasItems("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val1", Matchers.hasItems("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val2", Matchers.hasItems("val2", "val3", "val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val3", Matchers.hasItems("val3", "val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val4", Matchers.hasItems("val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val5", Matchers.hasItems("val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val6", Matchers.emptyIterableOf(String.class));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet(null, "val1", "val2", "val3", "val4")).toTailSet("val2", Matchers.hasItems("val2", "val3", "val4"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(null, Matchers.hasItems("val1", "val2", "val3", "val4", "val5"));

        try {
            Raw.<String>sortedSetAssertion().toTailSet("val", Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toTailSet("val", Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toTailSet("val", Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toTailSet("val", null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toTailSet("val", null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).toTailSet("val", null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").toTailSet("val", null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val3", Matchers.hasItems("val1", "val2"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tail elements from element: val3.\nExpected: (a collection containing \"val1\" and a collection containing \"val2\")\n     but: a collection containing \"val1\" was \"val3\", was \"val4\", was \"val5\"");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toTailSet("val3", Matchers.hasItems("val1", "val2"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tail elements from element: val3.\nExpected: (a collection containing \"val1\" and a collection containing \"val2\")\n     but: a collection containing \"val1\" was \"val3\", was \"val4\", was \"val5\"");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void toTailSetCountMatcherTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(1, Matchers.hasItems("val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(2, Matchers.hasItems("val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(3, Matchers.hasItems("val3", "val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(4, Matchers.hasItems("val2", "val3", "val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(5, Matchers.hasItems("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(6, Matchers.hasItems("val1", "val2", "val3", "val4", "val5"));

        try {
            Raw.<String>sortedSetAssertion().toTailSet(1, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toTailSet(1, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toTailSet(1, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toTailSet(0, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toTailSet(0, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).toTailSet(0, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").toTailSet(0, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).toTailSet(-1, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").toTailSet(-1, Matchers.hasItems(""));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).toTailSet(0, null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").toTailSet(0, null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).toTailSet(1, null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").toTailSet(1, null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(3, Matchers.hasItems("val4", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 3.\nExpected: (a collection containing \"val4\" and a collection containing \"val6\")\n     but: a collection containing \"val6\" was \"val3\", was \"val4\", was \"val5\"");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toTailSet(3, Matchers.hasItems("val4", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 3.\nExpected: (a collection containing \"val4\" and a collection containing \"val6\")\n     but: a collection containing \"val6\" was \"val3\", was \"val4\", was \"val5\"");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(5, Matchers.hasItems("val4", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 5.\nExpected: (a collection containing \"val4\" and a collection containing \"val6\")\n     but: a collection containing \"val6\" was \"val1\", was \"val2\", was \"val3\", was \"val4\", was \"val5\"");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toTailSet(5, Matchers.hasItems("val4", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 5.\nExpected: (a collection containing \"val4\" and a collection containing \"val6\")\n     but: a collection containing \"val6\" was \"val1\", was \"val2\", was \"val3\", was \"val4\", was \"val5\"");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(6, Matchers.hasItems("val4", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 6.\nExpected: (a collection containing \"val4\" and a collection containing \"val6\")\n     but: a collection containing \"val6\" was \"val1\", was \"val2\", was \"val3\", was \"val4\", was \"val5\"");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toTailSet(6, Matchers.hasItems("val4", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 6.\nExpected: (a collection containing \"val4\" and a collection containing \"val6\")\n     but: a collection containing \"val6\" was \"val1\", was \"val2\", was \"val3\", was \"val4\", was \"val5\"");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val2");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val3");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val1");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll("val5", "val1", "val3");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val5", "val4");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val1", "val4", "val5", "val2");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", null)).containsAll("val3", "val1", "val4", null, "val2");

        try {
            Raw.<String>sortedSetAssertion().containsAll("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAll("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsAll("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAll((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsAll((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsAll((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsAll((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsAll();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsAll();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll("val0", "val1");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val1", "val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3', '4', '5')).containsAll('1', '2', '3', '4', '5', '6');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53), 6(54)]> but was:<[1(49), 2(50), 3(51), 4(52), 5(53)]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3', '4', '5'), "Message").containsAll('1', '2', '3', '4', '5', '6');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53), 6(54)]> but was:<[1(49), 2(50), 3(51), 4(52), 5(53)]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val1", "val2"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val1", "val3"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val3", "val1"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val5", "val1", "val3"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val3", "val5", "val4"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val3", "val1", "val4", "val5", "val2"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", null)).containsAll(Arrays.asList("val3", "val1", "val4", null, "val2"));

        try {
            Raw.<String>sortedSetAssertion().containsAll(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAll(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsAll(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAll((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsAll((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsAll((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsAll((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsAll(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsAll(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val1", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val0", "val1"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val1", "val1", "val2"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val3");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val3", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", null)).containsAllInOrder(null, "val1", "val2", "val3", "val4");

        try {
            Raw.<String>sortedSetAssertion().containsAllInOrder("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAllInOrder("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsAllInOrder("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAllInOrder((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsAllInOrder((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsAllInOrder((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsAllInOrder((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsAllInOrder();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsAllInOrder();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val3", "val1");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val1", "val1")).containsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val1, val1, val1]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3', '4', '5')).containsAllInOrder('1', '2', '3', '4', '5', '6');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53), 6(54)]> but was:<[1(49), 2(50), 3(51), 4(52), 5(53)]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3', '4', '5'), "Message").containsAllInOrder('1', '2', '3', '4', '5', '6');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53), 6(54)]> but was:<[1(49), 2(50), 3(51), 4(52), 5(53)]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val2"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val3"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val3", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val3", "val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", null)).containsAllInOrder(Arrays.asList(null, "val1", "val2", "val3", "val4"));

        try {
            Raw.<String>sortedSetAssertion().containsAllInOrder(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsAllInOrder(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsAllInOrder(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val3", "val1"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val1", "val1")).containsAllInOrder(Arrays.asList("val1", "val1", "val1", "val1"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val1, val1, val1]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly("val1", "val2", "val3");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly("val2", "val1", "val3");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly("val2", "val3", "val1");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly("val3", "val2", "val1");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsExactly("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsExactly("val2", "val4", "val1", "val3", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", null)).containsExactly("val2", "val4", "val1", "val3", null);
        initialize(Raw.sortedSetAssertion(), createTreeSet()).containsExactly();

        try {
            Raw.<String>sortedSetAssertion().containsExactly("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsExactly("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsExactly("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsExactly((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsExactly((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsExactly((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsExactly((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly("val3", "val2", "val1", "val4");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly("val1", "val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly("val2", "val1");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly("val2", "val4", "val1");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3')).containsExactly('2', '4', '1');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2(50), 4(52), 1(49)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3'), "Message").containsExactly('2', '4', '1');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[2(50), 4(52), 1(49)]> but was:<[1(49), 2(50), 3(51)]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(Arrays.asList("val1", "val2", "val3"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(Arrays.asList("val2", "val1", "val3"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(Arrays.asList("val2", "val3", "val1"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(Arrays.asList("val3", "val2", "val1"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsExactly(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsExactly(Arrays.asList("val2", "val4", "val1", "val3", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", null)).containsExactly(Arrays.asList("val2", "val4", "val1", "val3", null));
        initialize(Raw.sortedSetAssertion(), createTreeSet()).containsExactly(new ArrayList<>());

        try {
            Raw.<String>sortedSetAssertion().containsExactly(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsExactly(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsExactly(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsExactly((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsExactly((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsExactly((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsExactly((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(Arrays.asList("val1", "val2", "val3", "val4"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(Arrays.asList("val3", "val2", "val1", "val4"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(Arrays.asList("val1", "val2"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(Arrays.asList("val2", "val1"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", null)).containsExactlyInOrder(null, "val1", "val2", "val3", "val4");
        initialize(Raw.sortedSetAssertion(), createTreeSet()).containsExactlyInOrder();

        try {
            Raw.<String>sortedSetAssertion().containsExactlyInOrder("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsExactlyInOrder("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsExactlyInOrder("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsExactlyInOrder((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsExactlyInOrder((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder("val2", "val3");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3')).containsExactlyInOrder('3', '1', '2');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[3(51), 1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3'), "Message").containsExactlyInOrder('3', '1', '2');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[3(51), 1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", null)).containsExactlyInOrder(Arrays.asList(null, "val1", "val2", "val3", "val4"));
        initialize(Raw.sortedSetAssertion(), createTreeSet()).containsExactlyInOrder(new ArrayList<>());

        try {
            Raw.<String>sortedSetAssertion().containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val1", "val2"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val2", "val3"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val1", "val2", "val4"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsAny("val1", "val3", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsAny("val6", "val2", "val4");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAny("val7", "val9", "val1", "val5", "val3");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", null)).containsAny("val7", "val9", "val1", null, "val3");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", null)).containsAny("val7", "val9", null);

        try {
            Raw.<String>sortedSetAssertion().containsAny("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAny("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsAny("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAny((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsAny((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsAny((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsAny((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsAny();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsAny();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsAny("val4", "val5", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAny("val8", "val7");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").containsAny("val8", "val7");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3', '4', '5')).containsAny('8', '7');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[8(56), 7(55)]> but was:<[1(49), 2(50), 3(51), 4(52), 5(53)]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3', '4', '5'), "Message").containsAny('8', '7');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[8(56), 7(55)]> but was:<[1(49), 2(50), 3(51), 4(52), 5(53)]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsAny(Arrays.asList("val1", "val3", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsAny(Arrays.asList("val6", "val2", "val4"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAny(Arrays.asList("val7", "val9", "val1", "val5", "val3"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", null)).containsAny(Arrays.asList("val7", "val9", "val1", null, "val3"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", null)).containsAny(Arrays.asList("val7", "val9", null));

        try {
            Raw.<String>sortedSetAssertion().containsAny(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAny(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsAny(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAny((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsAny((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsAny((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsAny((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsAny(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsAny(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsAny(Arrays.asList("val4", "val5", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone("val4", "val5", "val6");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone("val8", "val4");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", null)).containsNone("val8", "val4");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone("val8", "val4", null);

        try {
            Raw.<String>sortedSetAssertion().containsNone("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsNone("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsNone("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsNone((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsNone((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsNone((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsNone((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsNone();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsNone();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone("val4", "val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3')).containsNone('5', '4', '2', '6');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[5(53), 4(52), 2(50), 6(54)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.<Character>sortedSetAssertion(), createTreeSet('1', '2', '3'), "Message").containsNone('5', '4', '2', '6');
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[5(53), 4(52), 2(50), 6(54)]> but was:<[1(49), 2(50), 3(51)]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone(Arrays.asList("val4", "val5", "val6"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone(Arrays.asList("val8", "val4"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", null)).containsNone(Arrays.asList("val8", "val4"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone(Arrays.asList("val8", "val4", null));

        try {
            Raw.<String>sortedSetAssertion().containsNone(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsNone(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsNone(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsNone((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").containsNone((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsNone((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsNone((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).containsNone(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").containsNone(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone(Arrays.asList("val4", "val2"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).toSize().isEqualTo(3);
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).toSize().isGreaterThan(2);
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).toSize().isLessThan(6);

        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toSize().isEqualTo(5);
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toSize().isGreaterThan(1);
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toSize().isLessThan(9);

        try {
            Raw.<String>sortedSetAssertion().toSize();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toSize();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toSize();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).toSize()).isEqualTo(1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").toSize()).isEqualTo(1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).toSize().isEqualTo(4);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").toSize().isEqualTo(4);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void toSizeMatcherTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).toSize(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).toSize(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).toSize(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toSize(Matchers.equalTo(5));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toSize(Matchers.greaterThan(4));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toSize(Matchers.lessThan(6));

        try {
            Raw.<String>sortedSetAssertion().toSize(Matchers.equalTo(0));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toSize(Matchers.equalTo(0));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toSize(Matchers.equalTo(0));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toSize(null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toSize(null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("")).toSize(null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(""), "Message").toSize(null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).toSize(Matchers.equalTo(4));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").toSize(Matchers.equalTo(4));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).hasSize(3);
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).hasSize(5);

        try {
            Raw.<String>sortedSetAssertion().hasSize(1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).hasSize(1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").hasSize(1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).hasSize(4);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").hasSize(4);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.<String>sortedSetAssertion(), null).isNull();

        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).isNull();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").isNull();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        SortedSet<String> value = createTreeSet("val1", "val2", "val3");
        initialize(Raw.<String>sortedSetAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.<String>sortedSetAssertion(), value).isSameAs(createTreeSet("val1", "val2", "val3"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<[val1, val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), value, "Message").isSameAs(createTreeSet("val1", "val2", "val3"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<[val1, val2, val3]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        SortedSet<String> value = createTreeSet("val1", "val2", "val3");
        initialize(Raw.<String>sortedSetAssertion(), value).isNotSameAs(createTreeSet("val1", "val2", "val3"));

        try {
            initialize(Raw.<String>sortedSetAssertion(), value).isNotSameAs(value);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<[val1, val2, val3]>");
        }
    }

}
