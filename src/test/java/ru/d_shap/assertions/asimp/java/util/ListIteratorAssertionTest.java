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

import java.util.ListIterator;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link ListIteratorAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ListIteratorAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ListIteratorAssertionTest() {
        super();
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0));

        try {
            initializeWithRawActual(Raw.<String>listIteratorAssertion(), new Object());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.ListIterator> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.<String>listIteratorAssertion(), new Object(), "Message");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.ListIterator> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void hasNextValueTest() {
        ListIterator<String> listIterator1 = DataHelper.createListIterator(0, "val1", "val2", "val3");
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).hasNextValue();
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).hasNextValue();
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).hasNextValue();
        Assertions.assertThat(listIterator1.next()).isEqualTo("val1");
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).hasNextValue();
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).hasNextValue();
        Assertions.assertThat(listIterator1.next()).isEqualTo("val2");
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).hasNextValue();
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).hasNextValue();
        Assertions.assertThat(listIterator1.next()).isEqualTo("val3");
        ListIterator<String> listIterator2 = DataHelper.createListIterator(2, "val1", "val2", "val3");
        initialize(Raw.<String>listIteratorAssertion(), listIterator2).hasNextValue();
        initialize(Raw.<String>listIteratorAssertion(), listIterator2).hasNextValue();
        initialize(Raw.<String>listIteratorAssertion(), listIterator2).hasNextValue();
        Assertions.assertThat(listIterator2.next()).isEqualTo("val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNotNull().hasNextValue().isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().hasNextValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).hasNextValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").hasNextValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).hasNextValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have next value.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").hasNextValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have next value.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "value")).hasNextValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have next value.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "value"), "Message").hasNextValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have next value.");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void doesNotHaveNextValueTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).doesNotHaveNextValue();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "value")).doesNotHaveNextValue();
        ListIterator<String> listIterator1 = DataHelper.createListIterator(0, "val1", "val2", "val3");
        Assertions.assertThat(listIterator1.next()).isEqualTo("val1");
        Assertions.assertThat(listIterator1.next()).isEqualTo("val2");
        Assertions.assertThat(listIterator1.next()).isEqualTo("val3");
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).doesNotHaveNextValue();
        ListIterator<String> listIterator2 = DataHelper.createListIterator(2, "val1", "val2", "val3");
        Assertions.assertThat(listIterator2.next()).isEqualTo("val3");
        initialize(Raw.<String>listIteratorAssertion(), listIterator2).doesNotHaveNextValue();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).isNotNull().doesNotHaveNextValue().isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().doesNotHaveNextValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).doesNotHaveNextValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").doesNotHaveNextValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).doesNotHaveNextValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have next value.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4"), "Message").doesNotHaveNextValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have next value.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).doesNotHaveNextValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have next value.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4"), "Message").doesNotHaveNextValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have next value.");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void hasPreviousValueTest() {
        ListIterator<String> listIterator1 = DataHelper.createListIterator(3, "val1", "val2", "val3");
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).hasPreviousValue();
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).hasPreviousValue();
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).hasPreviousValue();
        Assertions.assertThat(listIterator1.previous()).isEqualTo("val3");
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).hasPreviousValue();
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).hasPreviousValue();
        Assertions.assertThat(listIterator1.previous()).isEqualTo("val2");
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).hasPreviousValue();
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).hasPreviousValue();
        Assertions.assertThat(listIterator1.previous()).isEqualTo("val1");
        ListIterator<String> listIterator2 = DataHelper.createListIterator(1, "val1", "val2", "val3");
        initialize(Raw.<String>listIteratorAssertion(), listIterator2).hasPreviousValue();
        initialize(Raw.<String>listIteratorAssertion(), listIterator2).hasPreviousValue();
        initialize(Raw.<String>listIteratorAssertion(), listIterator2).hasPreviousValue();
        Assertions.assertThat(listIterator2.previous()).isEqualTo("val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3")).isNotNull().hasPreviousValue().isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().hasPreviousValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).hasPreviousValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").hasPreviousValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).hasPreviousValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have previous value.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").hasPreviousValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have previous value.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "value")).hasPreviousValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have previous value.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "value"), "Message").hasPreviousValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have previous value.");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void doesNotHavePreviousValueTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).doesNotHavePreviousValue();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "value")).doesNotHavePreviousValue();
        ListIterator<String> listIterator1 = DataHelper.createListIterator(3, "val1", "val2", "val3");
        Assertions.assertThat(listIterator1.previous()).isEqualTo("val3");
        Assertions.assertThat(listIterator1.previous()).isEqualTo("val2");
        Assertions.assertThat(listIterator1.previous()).isEqualTo("val1");
        initialize(Raw.<String>listIteratorAssertion(), listIterator1).doesNotHavePreviousValue();
        ListIterator<String> listIterator2 = DataHelper.createListIterator(1, "val1", "val2", "val3");
        Assertions.assertThat(listIterator2.previous()).isEqualTo("val1");
        initialize(Raw.<String>listIteratorAssertion(), listIterator2).doesNotHavePreviousValue();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).isNotNull().doesNotHavePreviousValue().isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().doesNotHavePreviousValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).doesNotHavePreviousValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").doesNotHavePreviousValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).doesNotHavePreviousValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have previous value.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4"), "Message").doesNotHavePreviousValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have previous value.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).doesNotHavePreviousValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have previous value.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4"), "Message").doesNotHavePreviousValue();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have previous value.");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void toNextListTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList().containsExactlyInOrder("val1", "val2", "val3", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toNextList().containsExactlyInOrder("val2", "val3", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).toNextList().containsExactlyInOrder("val3", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toNextList().containsExactlyInOrder("val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toNextList().containsExactlyInOrder();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).isNotNull().toNextList().containsExactlyInOrder("val1", "val2", "val3", "val4");

        try {
            Raw.<String>listIteratorAssertion().toNextList();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toNextList();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toNextList();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList()).containsExactlyInOrder("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4"), "Message").toNextList()).containsExactlyInOrder("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList().containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4"), "Message").toNextList().containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toNextList().containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val4]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4"), "Message").toNextList().containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val4]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void toNextListCountTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList(5).containsExactlyInOrder("val1", "val2", "val3", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList(4).containsExactlyInOrder("val1", "val2", "val3", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toNextList(4).containsExactlyInOrder("val2", "val3", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).toNextList(4).containsExactlyInOrder("val3", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toNextList(4).containsExactlyInOrder("val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toNextList(4).containsExactlyInOrder();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList(3).containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList(2).containsExactlyInOrder("val1", "val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toNextList(2).containsExactlyInOrder("val2", "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).toNextList(2).containsExactlyInOrder("val3", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toNextList(2).containsExactlyInOrder("val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList(1).containsExactlyInOrder("val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).isNotNull().toNextList(5).containsExactlyInOrder("val1", "val2", "val3", "val4");

        try {
            Raw.<String>listIteratorAssertion().toNextList(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toNextList(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toNextList(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toNextList(0);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toNextList(0);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toNextList(0);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toNextList(0);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toNextList(-1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toNextList(-1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            clearActual(initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList(1)).containsExactlyInOrder("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4"), "Message").toNextList(1)).containsExactlyInOrder("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList(5).containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4"), "Message").toNextList(5).containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toNextList(5).containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val4]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4"), "Message").toNextList(5).containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val4]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void toNextListMatcherTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList(Matchers.hasItems("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toNextList(Matchers.hasItems("val2", "val3", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).toNextList(Matchers.hasItems("val3", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toNextList(Matchers.hasItems("val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toNextList(Matchers.<String>hasItems());
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).isNotNull().toNextList(Matchers.hasItems("val1", "val2", "val3", "val4")).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().toNextList(Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toNextList(Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toNextList(Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toNextList(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toNextList(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toNextList(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toNextList(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList(Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val1\", was \"val2\", was \"val3\", was \"val4\"]");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4"), "Message").toNextList(Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val1\", was \"val2\", was \"val3\", was \"val4\"]");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toNextList(Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val1\" mismatches were: [was \"val4\"]");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4"), "Message").toNextList(Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val1\" mismatches were: [was \"val4\"]");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void toNextListCountMatcherTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList(5, Matchers.hasItems("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList(4, Matchers.hasItems("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toNextList(4, Matchers.hasItems("val2", "val3", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).toNextList(4, Matchers.hasItems("val3", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toNextList(4, Matchers.hasItems("val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toNextList(4, Matchers.<String>hasItems());
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList(3, Matchers.hasItems("val1", "val2", "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList(2, Matchers.hasItems("val1", "val2"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toNextList(2, Matchers.hasItems("val2", "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).toNextList(2, Matchers.hasItems("val3", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toNextList(2, Matchers.hasItems("val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList(1, Matchers.hasItems("val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).isNotNull().toNextList(5, Matchers.hasItems("val1", "val2", "val3", "val4")).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().toNextList(1, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toNextList(1, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toNextList(1, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toNextList(0, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toNextList(0, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toNextList(0, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toNextList(0, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toNextList(-1, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toNextList(-1, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toNextList(0, null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toNextList(0, null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toNextList(1, null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toNextList(1, null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toNextList(5, Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val1\", was \"val2\", was \"val3\", was \"val4\"]");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4"), "Message").toNextList(5, Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val1\", was \"val2\", was \"val3\", was \"val4\"]");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toNextList(5, Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val1\" mismatches were: [was \"val4\"]");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4"), "Message").toNextList(5, Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val1\" mismatches were: [was \"val4\"]");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void toPreviousListTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList().containsExactlyInOrder("val4", "val3", "val2", "val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toPreviousList().containsExactlyInOrder("val3", "val2", "val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).toPreviousList().containsExactlyInOrder("val2", "val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toPreviousList().containsExactlyInOrder("val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toPreviousList().containsExactlyInOrder();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).isNotNull().toPreviousList().containsExactlyInOrder("val4", "val3", "val2", "val1");

        try {
            Raw.<String>listIteratorAssertion().toPreviousList();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toPreviousList();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toPreviousList();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList()).containsExactlyInOrder("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all previous actual value's elements.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4"), "Message").toPreviousList()).containsExactlyInOrder("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all previous actual value's elements.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList().containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all previous actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val4, val3, val2, val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4"), "Message").toPreviousList().containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all previous actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val4, val3, val2, val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toPreviousList().containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all previous actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4"), "Message").toPreviousList().containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all previous actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void toPreviousListCountTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList(5).containsExactlyInOrder("val4", "val3", "val2", "val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList(4).containsExactlyInOrder("val4", "val3", "val2", "val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toPreviousList(4).containsExactlyInOrder("val3", "val2", "val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).toPreviousList(4).containsExactlyInOrder("val2", "val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toPreviousList(4).containsExactlyInOrder("val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toPreviousList(4).containsExactlyInOrder();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList(3).containsExactlyInOrder("val4", "val3", "val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList(2).containsExactlyInOrder("val4", "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toPreviousList(2).containsExactlyInOrder("val3", "val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).toPreviousList(2).containsExactlyInOrder("val2", "val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toPreviousList(2).containsExactlyInOrder("val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList(1).containsExactlyInOrder("val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).isNotNull().toPreviousList(5).containsExactlyInOrder("val4", "val3", "val2", "val1");

        try {
            Raw.<String>listIteratorAssertion().toPreviousList(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toPreviousList(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toPreviousList(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toPreviousList(0);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toPreviousList(0);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toPreviousList(0);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toPreviousList(0);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toPreviousList(-1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toPreviousList(-1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            clearActual(initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toPreviousList(1)).containsExactlyInOrder("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4"), "Message").toPreviousList(1)).containsExactlyInOrder("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck previous N actual value's elements: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList(5).containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val4, val3, val2, val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4"), "Message").toPreviousList(5).containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck previous N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val4, val3, val2, val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toPreviousList(5).containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4"), "Message").toPreviousList(5).containsExactlyInOrder("val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck previous N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void toPreviousListMatcherTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList(Matchers.hasItems("val4", "val3", "val2", "val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toPreviousList(Matchers.hasItems("val3", "val2", "val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).toPreviousList(Matchers.hasItems("val2", "val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toPreviousList(Matchers.hasItems("val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toPreviousList(Matchers.<String>hasItems());
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).isNotNull().toPreviousList(Matchers.hasItems("val4", "val3", "val2", "val1")).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().toPreviousList(Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toPreviousList(Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toPreviousList(Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toPreviousList(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toPreviousList(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toPreviousList(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toPreviousList(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList(Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all previous actual value's elements.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val4\", was \"val3\", was \"val2\", was \"val1\"]");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4"), "Message").toPreviousList(Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all previous actual value's elements.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val4\", was \"val3\", was \"val2\", was \"val1\"]");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toPreviousList(Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all previous actual value's elements.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val1\"]");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4"), "Message").toPreviousList(Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all previous actual value's elements.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val1\"]");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void toPreviousListCountMatcherTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList(5, Matchers.hasItems("val4", "val3", "val2", "val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList(4, Matchers.hasItems("val4", "val3", "val2", "val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toPreviousList(4, Matchers.hasItems("val3", "val2", "val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).toPreviousList(4, Matchers.hasItems("val2", "val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toPreviousList(4, Matchers.hasItems("val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).toPreviousList(4, Matchers.<String>hasItems());
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList(3, Matchers.hasItems("val4", "val3", "val2"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList(2, Matchers.hasItems("val4", "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).toPreviousList(2, Matchers.hasItems("val3", "val2"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).toPreviousList(2, Matchers.hasItems("val2", "val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toPreviousList(2, Matchers.hasItems("val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList(1, Matchers.hasItems("val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).isNotNull().toPreviousList(5, Matchers.hasItems("val4", "val3", "val2", "val1")).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().toPreviousList(1, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toPreviousList(1, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toPreviousList(1, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toPreviousList(0, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toPreviousList(0, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toPreviousList(0, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toPreviousList(0, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toPreviousList(-1, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toPreviousList(-1, Matchers.hasItems(""));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toPreviousList(0, null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toPreviousList(0, null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toPreviousList(1, null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toPreviousList(1, null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).toPreviousList(5, Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 5.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val4\", was \"val3\", was \"val2\", was \"val1\"]");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4"), "Message").toPreviousList(5, Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck previous N actual value's elements: 5.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val4\", was \"val3\", was \"val2\", was \"val1\"]");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).toPreviousList(5, Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 5.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val1\"]");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4"), "Message").toPreviousList(5, Matchers.hasItems("val1", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck previous N actual value's elements: 5.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val1\"]");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).isEmpty();
        initialize(Raw.listIteratorAssertion(), DataHelper.createArrayList().listIterator()).isEmpty();
        initialize(Raw.listIteratorAssertion(), DataHelper.createLinkedList().listIterator()).isEmpty();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "value")).isEmpty();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2")).isEmpty();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).isNotNull().isEmpty().isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().isEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).isEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").isEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).isEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should be empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2"), "Message").isEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should be empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2")).isEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should be empty.\n\tActual:<[val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2"), "Message").isEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should be empty.\n\tActual:<[val2]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).isNullOrEmpty();
        initialize(Raw.listIteratorAssertion(), DataHelper.createArrayList().listIterator()).isNullOrEmpty();
        initialize(Raw.listIteratorAssertion(), DataHelper.createLinkedList().listIterator()).isNullOrEmpty();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "value")).isNullOrEmpty();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2")).isNullOrEmpty();
        initialize(Raw.<String>listIteratorAssertion(), null).isNullOrEmpty();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).isNotNull().isNullOrEmpty().isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().isNullOrEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).isNullOrEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2"), "Message").isNullOrEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2")).isNullOrEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should be null or empty.\n\tActual:<[val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2"), "Message").isNullOrEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should be null or empty.\n\tActual:<[val2]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).isNotEmpty();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2")).isNotEmpty();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "test1", "test2")).isNotEmpty();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).isNotNull().isNotEmpty().isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().isNotEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).isNotEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").isNotEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).isNotEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").isNotEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createArrayList().listIterator()).isNotEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createArrayList().listIterator(), "Message").isNotEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createLinkedList().listIterator()).isNotEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createLinkedList().listIterator(), "Message").isNotEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3")).isNotEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3"), "Message").isNotEmpty();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void toNextIndexTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toNextIndex().isEqualTo(1);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toNextIndex().isGreaterThan(0);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toNextIndex().isLessThan(2);

        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).toNextIndex().isEqualTo(3);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).toNextIndex().isGreaterThan(2);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).toNextIndex().isLessThan(4);

        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).isNotNull().toNextIndex().isEqualTo(1);

        try {
            Raw.<String>listIteratorAssertion().toNextIndex();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toNextIndex();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toNextIndex();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toNextIndex()).isEqualTo(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's next index.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3"), "Message").toNextIndex()).isEqualTo(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's next index.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toNextIndex().isEqualTo(4);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's next index.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3"), "Message").toNextIndex().isEqualTo(4);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's next index.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void toNextIndexMatcherTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toNextIndex(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toNextIndex(Matchers.is(Matchers.greaterThan(0)));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toNextIndex(Matchers.is(Matchers.lessThan(2)));

        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).toNextIndex(Matchers.equalTo(3));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).toNextIndex(Matchers.greaterThan(2));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).toNextIndex(Matchers.lessThan(4));

        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).isNotNull().toNextIndex(Matchers.is(Matchers.equalTo(1))).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().toNextIndex(Matchers.equalTo(0));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toNextIndex(Matchers.equalTo(0));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toNextIndex(Matchers.equalTo(0));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toNextIndex(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toNextIndex(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toNextIndex(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toNextIndex(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toNextIndex(Matchers.equalTo(4));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's next index.\nExpected: <4>\n     but: was <1>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3"), "Message").toNextIndex(Matchers.equalTo(4));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's next index.\nExpected: <4>\n     but: was <1>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void hasNextIndexTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).hasNextIndex(1);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).hasNextIndex(3);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).isNotNull().hasNextIndex(1).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().hasNextIndex(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).hasNextIndex(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").hasNextIndex(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).hasNextIndex(4);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's next index.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3"), "Message").hasNextIndex(4);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's next index.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void toPreviousIndexTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toPreviousIndex().isEqualTo(0);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toPreviousIndex().isGreaterThan(-1);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toPreviousIndex().isLessThan(1);

        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).toPreviousIndex().isEqualTo(2);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).toPreviousIndex().isGreaterThan(1);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).toPreviousIndex().isLessThan(3);

        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).isNotNull().toPreviousIndex().isEqualTo(0);

        try {
            Raw.<String>listIteratorAssertion().toPreviousIndex();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toPreviousIndex();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toPreviousIndex();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toPreviousIndex()).isEqualTo(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's previous index.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3"), "Message").toPreviousIndex()).isEqualTo(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's previous index.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toPreviousIndex().isEqualTo(4);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's previous index.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<0>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3"), "Message").toPreviousIndex().isEqualTo(4);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's previous index.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<0>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void toPreviousIndexMatcherTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toPreviousIndex(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toPreviousIndex(Matchers.is(Matchers.greaterThan(-1)));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toPreviousIndex(Matchers.is(Matchers.lessThan(1)));

        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).toPreviousIndex(Matchers.equalTo(2));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).toPreviousIndex(Matchers.greaterThan(1));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).toPreviousIndex(Matchers.lessThan(3));

        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).isNotNull().toPreviousIndex(Matchers.is(Matchers.equalTo(0))).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().toPreviousIndex(Matchers.equalTo(0));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toPreviousIndex(Matchers.equalTo(0));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toPreviousIndex(Matchers.equalTo(0));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).toPreviousIndex(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").toPreviousIndex(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).toPreviousIndex(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").toPreviousIndex(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).toPreviousIndex(Matchers.equalTo(4));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's previous index.\nExpected: <4>\n     but: was <0>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3"), "Message").toPreviousIndex(Matchers.equalTo(4));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's previous index.\nExpected: <4>\n     but: was <0>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void hasPreviousIndexTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).hasPreviousIndex(0);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).hasPreviousIndex(2);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).isNotNull().hasPreviousIndex(0).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().hasPreviousIndex(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).hasPreviousIndex(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").hasPreviousIndex(1);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).hasPreviousIndex(4);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's previous index.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<0>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3"), "Message").hasPreviousIndex(4);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's previous index.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<0>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void isNextElementEqualToTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNextElementEqualTo("val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).isNextElementEqualTo("val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3")).isNextElementEqualTo("val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val2", "val3")).isNextElementEqualTo("val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val2", "val3")).isNextElementEqualTo("val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0, null, null)).isNextElementEqualTo(null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(1, null, null)).isNextElementEqualTo(null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNotNull().isNextElementEqualTo("val1").isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().isNextElementEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).isNextElementEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").isNextElementEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNextElementEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3"), "Message").isNextElementEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, null, "val2", "val3")).isNextElementEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[<NULL>]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, null, "val2", "val3"), "Message").isNextElementEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[<NULL>]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNextElementEqualTo(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[<NULL>]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3"), "Message").isNextElementEqualTo(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[<NULL>]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3")).isNextElementEqualTo("val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1]> but was:<[val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3"), "Message").isNextElementEqualTo("val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1]> but was:<[val3]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void areNextElementsEqualToArrayTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).areNextElementsEqualTo("val1", "val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).areNextElementsEqualTo("val2", "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).areNextElementsEqualTo("val3", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).areNextElementsEqualTo("val1", "val2", "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).areNextElementsEqualTo("val2", "val3", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).areNextElementsEqualTo("val1", "val2", "val3", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", null, "val4")).areNextElementsEqualTo("val1", "val2", null, "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).isNotNull().areNextElementsEqualTo("val1", "val2").isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().areNextElementsEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).areNextElementsEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").areNextElementsEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).areNextElementsEqualTo((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").areNextElementsEqualTo((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).areNextElementsEqualTo((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").areNextElementsEqualTo((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).areNextElementsEqualTo();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").areNextElementsEqualTo();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).areNextElementsEqualTo("val2", "val3");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).areNextElementsEqualTo("val2", "val3");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val3, val4]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).areNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4"), "Message").areNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).areNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val3, val4]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4"), "Message").areNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val3, val4]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", "val3", '1')).areNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, 1(49)]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", "val3", '1'), "Message").areNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, 1(49)]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void areNextElementsEqualToIterableTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).areNextElementsEqualTo(DataHelper.createIterable("val1", "val2"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).areNextElementsEqualTo(DataHelper.createIterable("val2", "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).areNextElementsEqualTo(DataHelper.createIterable("val3", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).areNextElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4")).areNextElementsEqualTo(DataHelper.createIterable("val2", "val3", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).areNextElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", null, "val4")).areNextElementsEqualTo(DataHelper.createIterable("val1", "val2", null, "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).isNotNull().areNextElementsEqualTo(DataHelper.createIterable("val1", "val2")).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().areNextElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).areNextElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").areNextElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).areNextElementsEqualTo((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").areNextElementsEqualTo((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).areNextElementsEqualTo((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").areNextElementsEqualTo((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).areNextElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").areNextElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).areNextElementsEqualTo(DataHelper.createIterable("val2", "val3"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).areNextElementsEqualTo(DataHelper.createIterable("val2", "val3"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val3, val4]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).areNextElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4"), "Message").areNextElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).areNextElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val3, val4]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4"), "Message").areNextElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val3, val4]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void isPreviousElementEqualToTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3")).isPreviousElementEqualTo("val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3")).isPreviousElementEqualTo("val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).isPreviousElementEqualTo("val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val2", "val3")).isPreviousElementEqualTo("val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val2", "val3")).isPreviousElementEqualTo("val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(2, null, null)).isPreviousElementEqualTo(null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(1, null, null)).isPreviousElementEqualTo(null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3")).isNotNull().isPreviousElementEqualTo("val3").isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().isPreviousElementEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).isPreviousElementEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").isPreviousElementEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3")).isPreviousElementEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3"), "Message").isPreviousElementEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck previous N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, null, "val2", "val3")).isPreviousElementEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[<NULL>]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, null, "val2", "val3"), "Message").isPreviousElementEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck previous N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[<NULL>]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3")).isPreviousElementEqualTo(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[<NULL>]> but was:<[val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3"), "Message").isPreviousElementEqualTo(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck previous N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[<NULL>]> but was:<[val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3")).isPreviousElementEqualTo("val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1]> but was:<[val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3"), "Message").isPreviousElementEqualTo("val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck previous N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1]> but was:<[val2]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void arePreviousElementsEqualToArrayTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo("val4", "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo("val3", "val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo("val2", "val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo("val4", "val3", "val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo("val3", "val2", "val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo("val4", "val3", "val2", "val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", null, "val4")).arePreviousElementsEqualTo("val4", null, "val2", "val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).isNotNull().arePreviousElementsEqualTo("val4", "val3").isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().arePreviousElementsEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).arePreviousElementsEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").arePreviousElementsEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).arePreviousElementsEqualTo((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").arePreviousElementsEqualTo((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).arePreviousElementsEqualTo((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").arePreviousElementsEqualTo((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).arePreviousElementsEqualTo();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").arePreviousElementsEqualTo();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo("val2", "val3");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val4, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo("val2", "val3");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val2, val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val4, val3, val2, val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4"), "Message").arePreviousElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck previous N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val4, val3, val2, val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val2, val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4"), "Message").arePreviousElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck previous N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val2, val1]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(4, (Object) "val1", "val2", "val3", '1')).arePreviousElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[1(49), val3, val2, val1]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(4, (Object) "val1", "val2", "val3", '1'), "Message").arePreviousElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck previous N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[1(49), val3, val2, val1]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void arePreviousElementsEqualToIterableTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo(DataHelper.createIterable("val4", "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo(DataHelper.createIterable("val3", "val2"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo(DataHelper.createIterable("val2", "val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo(DataHelper.createIterable("val4", "val3", "val2"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo(DataHelper.createIterable("val3", "val2", "val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo(DataHelper.createIterable("val4", "val3", "val2", "val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", null, "val4")).arePreviousElementsEqualTo(DataHelper.createIterable("val4", null, "val2", "val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).isNotNull().arePreviousElementsEqualTo(DataHelper.createIterable("val4", "val3")).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().arePreviousElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).arePreviousElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").arePreviousElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).arePreviousElementsEqualTo((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").arePreviousElementsEqualTo((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).arePreviousElementsEqualTo((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").arePreviousElementsEqualTo((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).arePreviousElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").arePreviousElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo(DataHelper.createIterable("val2", "val3"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val4, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo(DataHelper.createIterable("val2", "val3"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val2, val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val4, val3, val2, val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4"), "Message").arePreviousElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck previous N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val4, val3, val2, val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4")).arePreviousElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check previous N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val2, val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4"), "Message").arePreviousElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck previous N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val2, val1]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void areAllElementsEqualToArrayTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).areAllElementsEqualTo("val1", "val2", "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).areAllElementsEqualTo("val2", "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3")).areAllElementsEqualTo("val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3")).areAllElementsEqualTo();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).areAllElementsEqualTo("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4", "val5")).areAllElementsEqualTo("val2", "val3", "val4", "val5");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4", "val5")).areAllElementsEqualTo("val3", "val4", "val5");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).areAllElementsEqualTo("val4", "val5");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4", "val5")).areAllElementsEqualTo("val5");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(5, "val1", "val2", "val3", "val4", "val5")).areAllElementsEqualTo();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", null)).areAllElementsEqualTo("val1", "val2", "val3", "val4", null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4", null)).areAllElementsEqualTo("val2", "val3", "val4", null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4", null)).areAllElementsEqualTo("val3", "val4", null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", null)).areAllElementsEqualTo("val4", null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4", null)).areAllElementsEqualTo((String) null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(5, "val1", "val2", "val3", "val4", null)).areAllElementsEqualTo();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).areAllElementsEqualTo();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNotNull().areAllElementsEqualTo("val1", "val2", "val3").isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().areAllElementsEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).areAllElementsEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").areAllElementsEqualTo("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).areAllElementsEqualTo((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").areAllElementsEqualTo((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).areAllElementsEqualTo((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").areAllElementsEqualTo((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).areAllElementsEqualTo("val1", "val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).areAllElementsEqualTo("val1", "val2", "val3");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3]> but was:<[val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).areAllElementsEqualTo("val2", "val3");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).areAllElementsEqualTo("val1", "val2", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).areAllElementsEqualTo("val1", "val2", "val3", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).areAllElementsEqualTo();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).areAllElementsEqualTo("val3", "val1", "val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3"), "Message").areAllElementsEqualTo("val3", "val1", "val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3")).areAllElementsEqualTo("val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2]> but was:<[val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3"), "Message").areAllElementsEqualTo("val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2]> but was:<[val3]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", '1')).areAllElementsEqualTo("val3", "val1", "val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", '1'), "Message").areAllElementsEqualTo("val3", "val1", "val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, 1(49)]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void areAllElementsEqualToIterableTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val2", "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.<String>createIterable());
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).areAllElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4", "val5")).areAllElementsEqualTo(DataHelper.createIterable("val2", "val3", "val4", "val5"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4", "val5")).areAllElementsEqualTo(DataHelper.createIterable("val3", "val4", "val5"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5")).areAllElementsEqualTo(DataHelper.createIterable("val4", "val5"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4", "val5")).areAllElementsEqualTo(DataHelper.createIterable("val5"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(5, "val1", "val2", "val3", "val4", "val5")).areAllElementsEqualTo(DataHelper.<String>createIterable());
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", null)).areAllElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4", null));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4", null)).areAllElementsEqualTo(DataHelper.createIterable("val2", "val3", "val4", null));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4", null)).areAllElementsEqualTo(DataHelper.createIterable("val3", "val4", null));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", null)).areAllElementsEqualTo(DataHelper.createIterable("val4", null));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(4, "val1", "val2", "val3", "val4", null)).areAllElementsEqualTo(DataHelper.createIterable((String) null));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(5, "val1", "val2", "val3", "val4", null)).areAllElementsEqualTo(DataHelper.<String>createIterable());
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).areAllElementsEqualTo(DataHelper.<String>createIterable());
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNotNull().areAllElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3")).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().areAllElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).areAllElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").areAllElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).areAllElementsEqualTo((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").areAllElementsEqualTo((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).areAllElementsEqualTo((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").areAllElementsEqualTo((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val1", "val2"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3]> but was:<[val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val2", "val3"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val1", "val2", "val4"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val3", "val1", "val2"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3"), "Message").areAllElementsEqualTo(DataHelper.createIterable("val3", "val1", "val2"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val2"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2]> but was:<[val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3"), "Message").areAllElementsEqualTo(DataHelper.createIterable("val2"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2]> but was:<[val3]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).contains("val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).contains("val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2")).contains("val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, null, "val1", "val2")).contains(null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", null, "val2")).contains(null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", null, "val2")).contains(null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", null)).contains(null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", null)).contains(null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", null)).contains(null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).isNotNull().contains("val1").isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().contains("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).contains("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").contains("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).contains("val3");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2"), "Message").contains("val3");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2")).contains("val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain the expected value.\n\tExpected:<val1> but was:<[val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2"), "Message").contains("val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain the expected value.\n\tExpected:<val1> but was:<[val2]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", '1')).contains("val3");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", '1'), "Message").contains("val3");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, 1(49)]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).doesNotContain("val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2")).doesNotContain("val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2")).doesNotContain("val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", null)).doesNotContain("val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", null)).doesNotContain("val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", null)).doesNotContain("val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", null)).doesNotContain(null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).doesNotContain(null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2")).doesNotContain(null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2")).doesNotContain(null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).isNotNull().doesNotContain("val3").isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().doesNotContain("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).doesNotContain("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").doesNotContain("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).doesNotContain("val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).doesNotContain("val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2"), "Message").doesNotContain("val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2")).doesNotContain("val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val2> but was:<[val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2"), "Message").doesNotContain("val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val2> but was:<[val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", null, "val2")).doesNotContain(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<<NULL>> but was:<[val1, <NULL>, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", null, "val2"), "Message").doesNotContain(null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<<NULL>> but was:<[val1, <NULL>, val2]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", '1')).doesNotContain("val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", '1'), "Message").doesNotContain("val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, 1(49)]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll("val5", "val1", "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val5", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val5", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val5", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val1", "val4", "val5", "val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", null)).containsAll("val3", "val1", "val4", null, "val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).isNotNull().containsAll("val1", "val2").isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().containsAll("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsAll("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsAll("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsAll((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsAll((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsAll((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsAll((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsAll();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsAll();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val6");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll("val0", "val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val1", "val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4", "val5")).containsAll("val2", "val3", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val2, val3, val4]> but was:<[val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val2", "val3", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val2, val3, val4]> but was:<[val3, val4, val5]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", "val3", "val4", '1')).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", "val3", "val4", '1'), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val2"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val3", "val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val5", "val1", "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val3", "val5", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val3", "val5", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val3", "val5", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val3", "val1", "val4", "val5", "val2"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", null)).containsAll(DataHelper.createIterable("val3", "val1", "val4", null, "val2"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).isNotNull().containsAll(DataHelper.createIterable("val1", "val2")).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().containsAll(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsAll(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsAll(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsAll((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsAll((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsAll((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsAll((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsAll(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsAll(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val6"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val0", "val1"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val1", "val2"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), "Message").containsAll(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val2", "val3", "val4"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val2, val3, val4]> but was:<[val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(2, "val1", "val2", "val3", "val4", "val5"), "Message").containsAll(DataHelper.createIterable("val2", "val3", "val4"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val2, val3, val4]> but was:<[val3, val4, val5]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val3", "val5");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val3", "val4", "val5");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val1", "val1", "val2", "val2")).containsAllInOrder("val1", "val1", "val1", "val2", "val2");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", null)).containsAllInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).isNotNull().containsAllInOrder("val1", "val2").isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().containsAllInOrder("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsAllInOrder("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsAllInOrder("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsAllInOrder((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsAllInOrder((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsAllInOrder((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsAllInOrder((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsAllInOrder();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsAllInOrder();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val6");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val3", "val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val1", "val1")).containsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", "val3", "val4", '1')).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", "val3", "val4", '1'), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val2"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val3", "val5"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val3", "val4", "val5"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val1", "val1", "val2", "val2")).containsAllInOrder(DataHelper.createIterable("val1", "val1", "val1", "val2", "val2"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", null)).containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", null));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).isNotNull().containsAllInOrder(DataHelper.createIterable("val1", "val2")).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsAllInOrder((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsAllInOrder((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val6"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val3", "val1"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val1", "val1")).containsAllInOrder(DataHelper.createIterable("val1", "val1", "val1", "val1"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly("val1", "val2", "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly("val2", "val1", "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly("val2", "val3", "val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly("val3", "val2", "val1");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsExactly("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsExactly("val2", "val4", "val1", "val3", "val5");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", null)).containsExactly("val2", "val4", "val1", "val3", null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsExactly();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNotNull().containsExactly("val1", "val2", "val3").isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().containsExactly("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsExactly("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsExactly("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsExactly((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsExactly((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsExactly((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsExactly((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly("val3", "val2", "val1", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly("val1", "val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly("val2", "val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly("val2", "val4", "val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3"), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", '1')).containsExactly("val2", "val4", "val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", '1'), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, 1(49)]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val1", "val2", "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val1", "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val3", "val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val3", "val2", "val1"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsExactly(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsExactly(DataHelper.createIterable("val2", "val4", "val1", "val3", "val5"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", null)).containsExactly(DataHelper.createIterable("val2", "val4", "val1", "val3", null));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsExactly(DataHelper.<String>createIterable());
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNotNull().containsExactly(DataHelper.createIterable("val1", "val2", "val3")).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().containsExactly(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsExactly(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsExactly(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsExactly((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsExactly((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsExactly((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsExactly((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val1", "val2", "val3", "val4"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val3", "val2", "val1", "val4"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val1", "val2"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val1"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val4", "val1"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3"), "Message").containsExactly(DataHelper.createIterable("val2", "val4", "val1"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", null)).containsExactlyInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsExactlyInOrder();
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNotNull().containsExactlyInOrder("val1", "val2", "val3").isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().containsExactlyInOrder("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsExactlyInOrder("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsExactlyInOrder("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsExactlyInOrder((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsExactlyInOrder((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactlyInOrder("val1", "val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactlyInOrder("val2", "val3");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactlyInOrder();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3"), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", '1')).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", '1'), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, 1(49)]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", null)).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", null));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsExactlyInOrder(DataHelper.<String>createIterable());
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNotNull().containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3")).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val2", "val3"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val4"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val3", "val1", "val2"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3"), "Message").containsExactlyInOrder(DataHelper.createIterable("val3", "val1", "val2"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsAny("val1", "val3", "val5");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsAny("val6", "val2", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAny("val7", "val9", "val1", "val5", "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", null)).containsAny("val7", "val9", "val1", null, "val3");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", null)).containsAny("val7", "val9", null);
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNotNull().containsAny("val1", "val3", "val5").isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().containsAny("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsAny("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsAny("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsAny((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsAny((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsAny((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsAny((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsAny();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsAny();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsAny("val4", "val5", "val6");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAny("val8", "val7");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), "Message").containsAny("val8", "val7");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", "val3", "val4", '1')).containsAny("val8", "val7");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", "val3", "val4", '1'), "Message").containsAny("val8", "val7");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsAny(DataHelper.createIterable("val1", "val3", "val5"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsAny(DataHelper.createIterable("val6", "val2", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAny(DataHelper.createIterable("val7", "val9", "val1", "val5", "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", null)).containsAny(DataHelper.createIterable("val7", "val9", "val1", null, "val3"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", null)).containsAny(DataHelper.createIterable("val7", "val9", null));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNotNull().containsAny(DataHelper.createIterable("val1", "val3", "val5")).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().containsAny(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsAny(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsAny(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsAny((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsAny((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsAny((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsAny((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsAny(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsAny(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsAny(DataHelper.createIterable("val4", "val5", "val6"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5")).containsAny(DataHelper.createIterable("val8", "val7"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), "Message").containsAny(DataHelper.createIterable("val8", "val7"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsNone("val4", "val5", "val6");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsNone("val8", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", null)).containsNone("val8", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsNone("val8", "val4", null);
        initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", '1')).containsNone("val8", "val4");
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNotNull().containsNone("val4", "val5", "val6").isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().containsNone("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsNone("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsNone("val");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsNone((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsNone((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsNone((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsNone((String[]) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsNone();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsNone();
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsNone("val4", "val2");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3"), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", '1')).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createListIterator(0, (Object) "val1", "val2", '1'), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, 1(49)]>");
        }
    }

    /**
     * {@link ListIteratorAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsNone(DataHelper.createIterable("val4", "val5", "val6"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsNone(DataHelper.createIterable("val8", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", null)).containsNone(DataHelper.createIterable("val8", "val4"));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsNone(DataHelper.createIterable("val8", "val4", null));
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNotNull().containsNone(DataHelper.createIterable("val4", "val5", "val6")).isInstanceOf(ListIterator.class);

        try {
            Raw.<String>listIteratorAssertion().containsNone(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsNone(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsNone(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).containsNone((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").containsNone((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsNone((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsNone((Iterable<String>) null);
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).containsNone(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").containsNone(DataHelper.<String>createIterable());
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsNone(DataHelper.createIterable("val4", "val2"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).containsNone(DataHelper.createIterable("val5", "val4", "val2", "val6"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3"), "Message").containsNone(DataHelper.createIterable("val5", "val4", "val2", "val6"));
            Assertions.fail(ListIteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

}
