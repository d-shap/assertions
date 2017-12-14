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
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet());

        try {
            initializeWithRawActual(Raw.<String>sortedSetAssertion(), new Object());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.<String>sortedSetAssertion(), new Object(), "Message");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet()).isEmpty();

        try {
            Raw.<String>sortedSetAssertion().isEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").isEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).isEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2"), "Message").isEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet()).isNullOrEmpty();
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
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2"), "Message").isNullOrEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[val1, val2]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet()).isNotEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(), "Message").isNotEmpty();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).contains("val1");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).contains("val2");

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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").contains("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).contains("val3");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2"), "Message").contains("val3");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).doesNotContain("val3");

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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").doesNotContain("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).doesNotContain("val1");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).doesNotContain("val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2"), "Message").doesNotContain("val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toHeadSet("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toHeadSet(null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toHeadSet(null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet()).toHeadSet(null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(), "Message").toHeadSet(null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet("val3").containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check head elements up to element: val3. Value should contain all of the expected values exactly in the specified order. Expected:<[val4, val5]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toHeadSet("val3").containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check head elements up to element: val3. Value should contain all of the expected values exactly in the specified order. Expected:<[val4, val5]> but was:<[val1, val2]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toHeadSet(1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toHeadSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toHeadSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet()).toHeadSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(), "Message").toHeadSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet()).toHeadSet(-1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(), "Message").toHeadSet(-1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toHeadSet(3).containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check head n elements: 3. Value should contain all of the expected values exactly in the specified order. Expected:<[val4, val5]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toHeadSet(3).containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check head n elements: 3. Value should contain all of the expected values exactly in the specified order. Expected:<[val4, val5]> but was:<[val1, val2, val3]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toTailSet("val");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toTailSet(null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toTailSet(null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet()).toTailSet(null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(), "Message").toTailSet(null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet("val3").containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check tail elements from element: val3. Value should contain all of the expected values exactly in the specified order. Expected:<[val4, val5]> but was:<[val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toTailSet("val3").containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check tail elements from element: val3. Value should contain all of the expected values exactly in the specified order. Expected:<[val4, val5]> but was:<[val3, val4, val5]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toTailSet(1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).toTailSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toTailSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet()).toTailSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(), "Message").toTailSet(0);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet()).toTailSet(-1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet(), "Message").toTailSet(-1);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should be valid.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).toTailSet(3).containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check tail n elements: 3. Value should contain all of the expected values exactly in the specified order. Expected:<[val4, val5]> but was:<[val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").toTailSet(3).containsExactlyInOrder("val4", "val5");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check tail n elements: 3. Value should contain all of the expected values exactly in the specified order. Expected:<[val4, val5]> but was:<[val3, val4, val5]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAll((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsAll((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsAll();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll("val0", "val1");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val1", "val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAll((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsAll((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsAll(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val1", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val0", "val1"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val1", "val1", "val2"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAllInOrder((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsAllInOrder((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsAllInOrder();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val3", "val1");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val1", "val1")).containsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val1, val1, val1]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val3", "val1"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val1", "val1")).containsAllInOrder(Arrays.asList("val1", "val1", "val1", "val1"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val1, val1, val1]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
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
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet()).containsExactly();

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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsExactly((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsExactly((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly("val3", "val2", "val1", "val4");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly("val1", "val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly("val2", "val1");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly("val2", "val4", "val1");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
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
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet()).containsExactly(new ArrayList<String>());

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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsExactly((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsExactly((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(Arrays.asList("val1", "val2", "val3", "val4"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(Arrays.asList("val3", "val2", "val1", "val4"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(Arrays.asList("val1", "val2"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(Arrays.asList("val2", "val1"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet()).containsExactlyInOrder();

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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsExactlyInOrder((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsExactlyInOrder((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder("val2", "val3");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet()).containsExactlyInOrder(new ArrayList<String>());

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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val1", "val2"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val2", "val3"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val1", "val2", "val4"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAny((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsAny((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsAny();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsAny("val4", "val5", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAny("val8", "val7");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").containsAny("val8", "val7");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsAny((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsAny((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsAny(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsAny(Arrays.asList("val4", "val5", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5")).containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3", "val4", "val5"), "Message").containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone("val4", "val5", "val6");
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone("val8", "val4");

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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsNone((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsNone((String[]) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsNone();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone("val4", "val2");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone(Arrays.asList("val4", "val5", "val6"));
        initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone(Arrays.asList("val8", "val4"));

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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null).containsNone((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsNone((Iterable<String>) null);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2")).containsNone(new ArrayList<String>());
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone(Arrays.asList("val4", "val2"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), null, "Message").toSize();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).toSize().isEqualTo(4);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").toSize().isEqualTo(4);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's size. Values should be the same. Expected:<4> but was:<3>");
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
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3")).hasSize(4);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").hasSize(4);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's size. Values should be the same. Expected:<4> but was:<3>");
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
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), createTreeSet("val1", "val2", "val3"), "Message").isNull();
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[val1, val2, val3]>");
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
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[val1, val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), value, "Message").isSameAs(createTreeSet("val1", "val2", "val3"));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[val1, val2, val3]> but was:<[val1, val2, val3]>");
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
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>sortedSetAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("SortedSetAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link SortedSetAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.<String>sortedSetAssertion(), null).asString(null));
            Assertions.fail("SortedSetAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.<String>sortedSetAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.<String>sortedSetAssertion(), null).asString(createTreeSet("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(initialize(Raw.<String>sortedSetAssertion(), null).asString(createTreeSet("val1", "val2", "val3", "val4", "val5"))).isEqualTo("[val1, val2, val3, val4, val5]");
    }

}
