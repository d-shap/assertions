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

import java.util.Iterator;
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
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).isNotNull().isEmpty().isInstanceOf(Iterator.class);

        try {
            Raw.<String>listIteratorAssertion().isEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).isEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").isEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).isEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should be empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2"), "Message").isEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should be empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2")).isEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should be empty.\n\tActual:<[val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2"), "Message").isEmpty();
            Assertions.fail(IteratorAssertion.class);
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
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).isNotNull().isNullOrEmpty().isInstanceOf(Iterator.class);

        try {
            Raw.<String>listIteratorAssertion().isNullOrEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).isNullOrEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2"), "Message").isNullOrEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2")).isNullOrEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should be null or empty.\n\tActual:<[val2]>");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(1, "val1", "val2"), "Message").isNullOrEmpty();
            Assertions.fail(IteratorAssertion.class);
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
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2")).isNotNull().isNotEmpty().isInstanceOf(Iterator.class);

        try {
            Raw.<String>listIteratorAssertion().isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0), "Message").isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createArrayList().listIterator()).isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createArrayList().listIterator(), "Message").isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createLinkedList().listIterator()).isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.listIteratorAssertion(), DataHelper.createLinkedList().listIterator(), "Message").isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3")).isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all next actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3"), "Message").isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all next actual value's elements.\n\tActual value should not be empty.");
        }
    }

}
