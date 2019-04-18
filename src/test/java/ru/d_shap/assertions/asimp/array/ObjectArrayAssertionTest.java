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
package ru.d_shap.assertions.asimp.array;

import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.Matchers;
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
        initialize(Raw.<String>objectArrayAssertion(), new String[]{});

        try {
            initializeWithRawActual(Raw.<String>objectArrayAssertion(), new Object());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.<String>objectArrayAssertion(), new Object(), "Message");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.objectArrayAssertion(), new String[]{}).isEmpty();

        try {
            Raw.objectArrayAssertion().isEmpty();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), null).isEmpty();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), null, "Message").isEmpty();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}).isEmpty();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").isEmpty();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.objectArrayAssertion(), null).isNullOrEmpty();
        initialize(Raw.objectArrayAssertion(), new String[]{}).isNullOrEmpty();

        try {
            Raw.objectArrayAssertion().isNullOrEmpty();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}).isNullOrEmpty();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").isNullOrEmpty();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}).isNotEmpty();

        try {
            Raw.objectArrayAssertion().isNotEmpty();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), null).isNotEmpty();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new String[]{}).isNotEmpty();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new String[]{}, "Message").isNotEmpty();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
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
            Raw.<String>objectArrayAssertion().contains("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).contains("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").contains("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).contains("val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").contains("val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}).contains("val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}, "Message").contains("val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, 1(49)]>");
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
            Raw.<String>objectArrayAssertion().doesNotContain("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).doesNotContain("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").doesNotContain("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).doesNotContain("val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").doesNotContain("val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", null, "val2"}).doesNotContain(null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<null> but was:<[val1, null, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", null, "val2"}, "Message").doesNotContain(null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<null> but was:<[val1, null, val2]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}).doesNotContain("val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}, "Message").doesNotContain("val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, 1(49)]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAll("val1", "val2");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAll("val1", "val3");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAll("val4", "val2");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsAll(null, "val2");

        try {
            Raw.<String>objectArrayAssertion().containsAll("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAll("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsAll("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAll((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsAll((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsAll((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsAll((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsAll();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsAll();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAll("val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsAll("val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}).containsAll("val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val2, val3]> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}, "Message").containsAll("val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[val2, val3]> but was:<[val1, 1(49)]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAll(Arrays.asList("val1", "val2"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAll(Arrays.asList("val1", "val3"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAll(Arrays.asList("val4", "val2"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsAll(Arrays.asList(null, "val2"));

        try {
            Raw.<String>objectArrayAssertion().containsAll(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAll(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsAll(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAll((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsAll((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsAll((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsAll((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsAll(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsAll(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAll(Arrays.asList("val2", "val3"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsAll(Arrays.asList("val2", "val3"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[val2, val3]> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAllInOrder("val1", "val2");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAllInOrder("val1", "val3", "val4");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsAllInOrder("val1", "val3", null);

        try {
            Raw.<String>objectArrayAssertion().containsAllInOrder("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAllInOrder("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsAllInOrder("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAllInOrder((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsAllInOrder((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsAllInOrder((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsAllInOrder((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsAllInOrder();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsAllInOrder();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAllInOrder("val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAllInOrder("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsAllInOrder("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}).containsAllInOrder("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val2, val1]> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}, "Message").containsAllInOrder("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val2, val1]> but was:<[val1, 1(49)]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAllInOrder(Arrays.asList("val1", "val2"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAllInOrder(Arrays.asList("val1", "val3", "val4"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsAllInOrder(Arrays.asList("val1", "val3", null));

        try {
            Raw.<String>objectArrayAssertion().containsAllInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsAllInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsAllInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAllInOrder(Arrays.asList("val2", "val3"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAllInOrder(Arrays.asList("val2", "val1"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsAllInOrder(Arrays.asList("val2", "val1"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val2, val1]> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactly("val1", "val2");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactly("val1", "val2", "val3", "val4");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactly("val1", "val3", "val2", "val4");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsExactly("val1", "val3", "val2", null);
        initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsExactly();

        try {
            Raw.<String>objectArrayAssertion().containsExactly("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactly("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsExactly("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactly((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsExactly((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsExactly((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsExactly((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactly("val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactly("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactly();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactly("val1", "val1", "val3", "val2");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}, "Message").containsExactly("val1", "val1", "val3", "val2");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}).containsExactly("val1", "val1", "val3", "val2");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val1, val3, val2]> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}, "Message").containsExactly("val1", "val1", "val3", "val2");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val1, val1, val3, val2]> but was:<[val1, 1(49)]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactly(Arrays.asList("val1", "val2"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactly(Arrays.asList("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactly(Arrays.asList("val1", "val3", "val2", "val4"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsExactly(Arrays.asList("val1", "val3", "val2", null));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsExactly(new ArrayList<String>());

        try {
            Raw.<String>objectArrayAssertion().containsExactly(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactly(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsExactly(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactly((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsExactly((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsExactly((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsExactly((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactly(Arrays.asList("val2", "val3"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactly(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactly(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactly(Arrays.asList("val1", "val1", "val3", "val2"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}, "Message").containsExactly(Arrays.asList("val1", "val1", "val3", "val2"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val1, val1, val3, val2]> but was:<[val1, val2, val3, val4]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactlyInOrder("val1", "val2");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactlyInOrder("val1", "val2", "val3", "val4");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsExactlyInOrder("val1", "val2", "val3", null);
        initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsExactlyInOrder();

        try {
            Raw.<String>objectArrayAssertion().containsExactlyInOrder("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactlyInOrder("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsExactlyInOrder("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactlyInOrder((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsExactlyInOrder((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactlyInOrder("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactlyInOrder("val1", "val2", "val3");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactlyInOrder();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactlyInOrder("val2", "val3", "val1", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}, "Message").containsExactlyInOrder("val2", "val3", "val1", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}).containsExactlyInOrder("val2", "val3", "val1", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3, val1, val4]> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}, "Message").containsExactlyInOrder("val2", "val3", "val1", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3, val1, val4]> but was:<[val1, 1(49)]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactlyInOrder(Arrays.asList("val1", "val2"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", null));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsExactlyInOrder(new ArrayList<String>());

        try {
            Raw.<String>objectArrayAssertion().containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactlyInOrder(Arrays.asList("val2", "val1"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsExactlyInOrder(Arrays.asList("val2", "val3", "val1", "val4"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}, "Message").containsExactlyInOrder(Arrays.asList("val2", "val3", "val1", "val4"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3, val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAny("val2", "val3");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAny("val2", "val4");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAny("val4", "val1");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAny("val5", "val3");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsAny("val5", null);

        try {
            Raw.<String>objectArrayAssertion().containsAny("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAny("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsAny("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAny((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsAny((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsAny((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsAny((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsAny();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsAny();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAny("val3", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val3, val4]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsAny("val3", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[val3, val4]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}).containsAny("val3", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val3, val4]> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}, "Message").containsAny("val3", "val4");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[val3, val4]> but was:<[val1, 1(49)]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAny(Arrays.asList("val2", "val3"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAny(Arrays.asList("val2", "val4"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAny(Arrays.asList("val4", "val1"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).containsAny(Arrays.asList("val5", "val3"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2", "val3", null}).containsAny(Arrays.asList("val5", null));

        try {
            Raw.<String>objectArrayAssertion().containsAny(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAny(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsAny(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsAny((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsAny((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsAny((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsAny((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsAny(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsAny(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsAny(Arrays.asList("val3", "val4"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[val3, val4]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsAny(Arrays.asList("val3", "val4"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[val3, val4]> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone("val3", "val7");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone("val3", "val4", "val5");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", null}).containsNone("val3", "val4");
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone("val3", null);
        initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}).containsNone("val3", "val7");

        try {
            Raw.<String>objectArrayAssertion().containsNone("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsNone("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsNone("val");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsNone((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsNone((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsNone((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsNone((String[]) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsNone();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsNone();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsNone("val2", "val1");
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}).containsNone("val2", '1');
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val2, 1(49)]> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new Object[]{"val1", '1'}, "Message").containsNone("val2", '1');
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val2, 1(49)]> but was:<[val1, 1(49)]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone(Arrays.asList("val3", "val7"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone(Arrays.asList("val3", "val4", "val5"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", null}).containsNone(Arrays.asList("val3", "val4"));
        initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone(Arrays.asList("val3", null));

        try {
            Raw.<String>objectArrayAssertion().containsNone(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsNone(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsNone(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null).containsNone((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), null, "Message").containsNone((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsNone((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsNone((Iterable<String>) null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}).containsNone(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{}, "Message").containsNone(new ArrayList<String>());
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}).containsNone(Arrays.asList("val2", "val1"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[val2, val1]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").containsNone(Arrays.asList("val2", "val1"));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val2, val1]> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}).toLength().isEqualTo(2);
        initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}).toLength().isGreaterThan(1);
        initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}).toLength().isLessThan(3);

        initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).toLength().isEqualTo(4);
        initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).toLength().isGreaterThan(3);
        initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).toLength().isLessThan(5);

        try {
            Raw.objectArrayAssertion().toLength();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), null).toLength();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), null, "Message").toLength();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}).toLength()).isEqualTo(0);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").toLength()).isEqualTo(0);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}).toLength().isEqualTo(4);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").toLength().isEqualTo(4);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void toLengthMatcherTest() {
        initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}).toLength(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}).toLength(Matchers.is(Matchers.greaterThan(1)));
        initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}).toLength(Matchers.is(Matchers.lessThan(3)));

        initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).toLength(Matchers.equalTo(4));
        initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).toLength(Matchers.greaterThan(3));
        initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).toLength(Matchers.lessThan(5));

        try {
            Raw.objectArrayAssertion().toLength(Matchers.equalTo(0));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), null).toLength(Matchers.equalTo(0));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), null, "Message").toLength(Matchers.equalTo(0));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), null).toLength(null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), null, "Message").toLength(null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new String[]{}).toLength(null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new String[]{}, "Message").toLength(null);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}).toLength(Matchers.equalTo(4));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").toLength(Matchers.equalTo(4));
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\nExpected: <4>\n     but: was <2>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}).hasLength(2);
        initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2", "val3", "val4"}).hasLength(4);

        try {
            Raw.objectArrayAssertion().hasLength(0);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), null).hasLength(0);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), null, "Message").hasLength(0);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}).hasLength(4);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").hasLength(4);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), new String[]{"val1", "val2"}, "Message").isNull();
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[val1, val2]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<[val1, val2]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), value, "Message").isSameAs(new String[]{"val1", "val2"});
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<[val1, val2]> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        String[] value = new String[]{"val1", "val2"};
        initialize(Raw.<String>objectArrayAssertion(), value).isNotSameAs(new String[]{"val1", "val2"});

        try {
            initialize(Raw.<String>objectArrayAssertion(), value).isNotSameAs(value);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>objectArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ObjectArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<[val1, val2]>");
        }
    }

}
