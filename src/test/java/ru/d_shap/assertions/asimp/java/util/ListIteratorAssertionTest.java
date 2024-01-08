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
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3")).isNotNull().hasNextValue().isInstanceOf(Iterator.class);

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
        initialize(Raw.<String>listIteratorAssertion(), DataHelper.<String>createListIterator(0)).isNotNull().doesNotHaveNextValue().isInstanceOf(Iterator.class);

        try {
            Raw.<String>listIteratorAssertion().doesNotHaveNextValue();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null).doesNotHaveNextValue();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), null, "Message").doesNotHaveNextValue();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4")).doesNotHaveNextValue();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have next value.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(0, "val1", "val2", "val3", "val4"), "Message").doesNotHaveNextValue();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have next value.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4")).doesNotHaveNextValue();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have next value.");
        }
        try {
            initialize(Raw.<String>listIteratorAssertion(), DataHelper.createListIterator(3, "val1", "val2", "val3", "val4"), "Message").doesNotHaveNextValue();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have next value.");
        }
    }

}
