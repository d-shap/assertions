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

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link IteratorAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IteratorAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IteratorAssertionTest() {
        super();
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator());

        try {
            initializeWithRawActual(Raw.<String>iteratorAssertion(), new Object());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Iterator> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.<String>iteratorAssertion(), new Object(), "Message");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Iterator> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void hasNextElementTest() {
        Iterator<String> iterator = DataHelper.createIterator("val1", "val2", "val3");
        initialize(Raw.<String>iteratorAssertion(), iterator).hasNextElement();
        initialize(Raw.<String>iteratorAssertion(), iterator).hasNextElement();
        initialize(Raw.<String>iteratorAssertion(), iterator).hasNextElement();
        Assertions.assertThat(iterator.next()).isEqualTo("val1");
        initialize(Raw.<String>iteratorAssertion(), iterator).hasNextElement();
        initialize(Raw.<String>iteratorAssertion(), iterator).hasNextElement();
        Assertions.assertThat(iterator.next()).isEqualTo("val2");
        initialize(Raw.<String>iteratorAssertion(), iterator).hasNextElement();
        initialize(Raw.<String>iteratorAssertion(), iterator).hasNextElement();
        Assertions.assertThat(iterator.next()).isEqualTo("val3");
        initialize(Raw.<String>iteratorAssertion(), iterator).isCompleted();
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().hasNextElement().isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().hasNextElement();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).hasNextElement();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").hasNextElement();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).hasNextElement();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have next element.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").hasNextElement();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have next element.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void doesNotHaveNextElementTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).doesNotHaveNextElement();
        Iterator<String> iterator = DataHelper.createIterator("val1", "val2", "val3");
        Assertions.assertThat(iterator.next()).isEqualTo("val1");
        Assertions.assertThat(iterator.next()).isEqualTo("val2");
        Assertions.assertThat(iterator.next()).isEqualTo("val3");
        initialize(Raw.<String>iteratorAssertion(), iterator).doesNotHaveNextElement();
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).isNotNull().doesNotHaveNextElement().isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().doesNotHaveNextElement();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).doesNotHaveNextElement();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").doesNotHaveNextElement();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).doesNotHaveNextElement();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have next element.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4"), "Message").doesNotHaveNextElement();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have next element.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isCompletedTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).isCompleted();
        Iterator<String> iterator = DataHelper.createIterator("val1", "val2", "val3");
        Assertions.assertThat(iterator.next()).isEqualTo("val1");
        Assertions.assertThat(iterator.next()).isEqualTo("val2");
        Assertions.assertThat(iterator.next()).isEqualTo("val3");
        initialize(Raw.<String>iteratorAssertion(), iterator).isCompleted();
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).isNotNull().isCompleted().isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().isCompleted();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isCompleted();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isCompleted();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).isCompleted();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be completed.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4"), "Message").isCompleted();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be completed.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNotCompletedTest() {
        Iterator<String> iterator = DataHelper.createIterator("val1", "val2", "val3");
        initialize(Raw.<String>iteratorAssertion(), iterator).isNotCompleted();
        initialize(Raw.<String>iteratorAssertion(), iterator).isNotCompleted();
        initialize(Raw.<String>iteratorAssertion(), iterator).isNotCompleted();
        Assertions.assertThat(iterator.next()).isEqualTo("val1");
        initialize(Raw.<String>iteratorAssertion(), iterator).isNotCompleted();
        initialize(Raw.<String>iteratorAssertion(), iterator).isNotCompleted();
        Assertions.assertThat(iterator.next()).isEqualTo("val2");
        initialize(Raw.<String>iteratorAssertion(), iterator).isNotCompleted();
        initialize(Raw.<String>iteratorAssertion(), iterator).isNotCompleted();
        Assertions.assertThat(iterator.next()).isEqualTo("val3");
        initialize(Raw.<String>iteratorAssertion(), iterator).isCompleted();
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().isNotCompleted().isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().isNotCompleted();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isNotCompleted();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isNotCompleted();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).isNotCompleted();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be completed.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").isNotCompleted();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be completed.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void toListTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList().containsExactlyInOrder("val1", "val2", "val3", "val4");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).isNotNull().toList().containsExactlyInOrder("val1", "val2", "val3", "val4");

        try {
            Raw.<String>iteratorAssertion().toList();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toList();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toList();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList()).containsExactlyInOrder("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4"), "Message").toList()).containsExactlyInOrder("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList().containsExactlyInOrder("val1", "val4");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4"), "Message").toList().containsExactlyInOrder("val1", "val4");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void toListCountTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList(5).containsExactlyInOrder("val1", "val2", "val3", "val4");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList(4).containsExactlyInOrder("val1", "val2", "val3", "val4");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList(3).containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList(2).containsExactlyInOrder("val1", "val2");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList(1).containsExactlyInOrder("val1");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).isNotNull().toList(5).containsExactlyInOrder("val1", "val2", "val3", "val4");

        try {
            Raw.<String>iteratorAssertion().toList(1);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toList(1);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toList(1);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toList(0);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toList(0);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).toList(0);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").toList(0);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).toList(-1);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").toList(-1);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            clearActual(initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList(1)).containsExactlyInOrder("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4"), "Message").toList(1)).containsExactlyInOrder("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList(5).containsExactlyInOrder("val1", "val4");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4"), "Message").toList(5).containsExactlyInOrder("val1", "val4");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void toListMatcherTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList(Matchers.hasItems("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).isNotNull().toList(Matchers.hasItems("val1", "val2", "val3", "val4")).isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().toList(Matchers.hasItems(""));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toList(Matchers.hasItems(""));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toList(Matchers.hasItems(""));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toList(null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toList(null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).toList(null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").toList(null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList(Matchers.hasItems("val1", "val5"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val1\", was \"val2\", was \"val3\", was \"val4\"]");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4"), "Message").toList(Matchers.hasItems("val1", "val5"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val1\", was \"val2\", was \"val3\", was \"val4\"]");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void toListCountMatcherTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList(5, Matchers.hasItems("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList(4, Matchers.hasItems("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList(3, Matchers.hasItems("val1", "val2", "val3"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList(2, Matchers.hasItems("val1", "val2"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList(1, Matchers.hasItems("val1"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).isNotNull().toList(5, Matchers.hasItems("val1", "val2", "val3", "val4")).isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().toList(1, Matchers.hasItems(""));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toList(1, Matchers.hasItems(""));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toList(1, Matchers.hasItems(""));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toList(0, Matchers.hasItems(""));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toList(0, Matchers.hasItems(""));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).toList(0, Matchers.hasItems(""));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").toList(0, Matchers.hasItems(""));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).toList(-1, Matchers.hasItems(""));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").toList(-1, Matchers.hasItems(""));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).toList(0, null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").toList(0, null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).toList(1, null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").toList(1, null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).toList(5, Matchers.hasItems("val1", "val5"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val1\", was \"val2\", was \"val3\", was \"val4\"]");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4"), "Message").toList(5, Matchers.hasItems("val1", "val5"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" mismatches were: [was \"val1\", was \"val2\", was \"val3\", was \"val4\"]");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).isEmpty();
        initialize(Raw.iteratorAssertion(), DataHelper.createHashSet().iterator()).isEmpty();
        initialize(Raw.iteratorAssertion(), DataHelper.createTreeSet().iterator()).isEmpty();
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).isNotNull().isEmpty().isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().isEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2")).isEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should be empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2"), "Message").isEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should be empty.\n\tActual:<[val1, val2]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).isNullOrEmpty();
        initialize(Raw.iteratorAssertion(), DataHelper.createHashSet().iterator()).isNullOrEmpty();
        initialize(Raw.iteratorAssertion(), DataHelper.createTreeSet().iterator()).isNullOrEmpty();
        initialize(Raw.<String>iteratorAssertion(), null).isNullOrEmpty();
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).isNotNull().isNullOrEmpty().isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().isNullOrEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2")).isNullOrEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2"), "Message").isNullOrEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2")).isNotEmpty();
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("test1", "test2")).isNotEmpty();
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2")).isNotNull().isNotEmpty().isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createHashSet().iterator()).isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createHashSet().iterator(), "Message").isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createTreeSet().iterator()).isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createTreeSet().iterator(), "Message").isNotEmpty();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNextElementEqualToTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNextElementEqualTo("val1");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val2", "val3")).isNextElementEqualTo("val2");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(null, null)).isNextElementEqualTo(null);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().isNextElementEqualTo("val1").isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().isNextElementEqualTo("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isNextElementEqualTo("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isNextElementEqualTo("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNextElementEqualTo("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3"), "Message").isNextElementEqualTo("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator(null, "val2", "val3")).isNextElementEqualTo("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[<NULL>]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator(null, "val2", "val3"), "Message").isNextElementEqualTo("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[<NULL>]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNextElementEqualTo(null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[<NULL>]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3"), "Message").isNextElementEqualTo(null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[<NULL>]> but was:<[val1]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void areNextElementsEqualToArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).areNextElementsEqualTo("val1", "val2");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).areNextElementsEqualTo("val1", "val2", "val3");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).areNextElementsEqualTo("val1", "val2", "val3", "val4");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", null, "val4")).areNextElementsEqualTo("val1", "val2", null, "val4");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).isNotNull().areNextElementsEqualTo("val1", "val2").isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().areNextElementsEqualTo("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).areNextElementsEqualTo("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").areNextElementsEqualTo("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).areNextElementsEqualTo((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").areNextElementsEqualTo((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).areNextElementsEqualTo((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").areNextElementsEqualTo((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).areNextElementsEqualTo();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").areNextElementsEqualTo();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).areNextElementsEqualTo("val2", "val3");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).areNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4"), "Message").areNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", "val3", '1')).areNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", "val3", '1'), "Message").areNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void areNextElementsEqualToIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).areNextElementsEqualTo(DataHelper.createIterable("val1", "val2"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).areNextElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).areNextElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", null, "val4")).areNextElementsEqualTo(DataHelper.createIterable("val1", "val2", null, "val4"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).isNotNull().areNextElementsEqualTo(DataHelper.createIterable("val1", "val2")).isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().areNextElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).areNextElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").areNextElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).areNextElementsEqualTo((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").areNextElementsEqualTo((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).areNextElementsEqualTo((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").areNextElementsEqualTo((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).areNextElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").areNextElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).areNextElementsEqualTo(DataHelper.createIterable("val2", "val3"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4")).areNextElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4"), "Message").areNextElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void areAllElementsEqualToArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).areAllElementsEqualTo("val1", "val2", "val3");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).areAllElementsEqualTo("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", null)).areAllElementsEqualTo("val1", "val2", "val3", "val4", null);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).areAllElementsEqualTo();
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().areAllElementsEqualTo("val1", "val2", "val3").isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().areAllElementsEqualTo("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).areAllElementsEqualTo("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").areAllElementsEqualTo("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).areAllElementsEqualTo((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").areAllElementsEqualTo((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).areAllElementsEqualTo((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").areAllElementsEqualTo((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).areAllElementsEqualTo("val1", "val2");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).areAllElementsEqualTo("val2", "val3");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).areAllElementsEqualTo("val1", "val2", "val4");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).areAllElementsEqualTo("val1", "val2", "val3", "val4");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).areAllElementsEqualTo();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).areAllElementsEqualTo("val3", "val1", "val2");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3"), "Message").areAllElementsEqualTo("val3", "val1", "val2");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", '1')).areAllElementsEqualTo("val3", "val1", "val2");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", '1'), "Message").areAllElementsEqualTo("val3", "val1", "val2");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void areAllElementsEqualToIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).areAllElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", null)).areAllElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4", null));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).areAllElementsEqualTo(DataHelper.<String>createIterable());
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().areAllElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3")).isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().areAllElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).areAllElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").areAllElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).areAllElementsEqualTo((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").areAllElementsEqualTo((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).areAllElementsEqualTo((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").areAllElementsEqualTo((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val1", "val2"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val2", "val3"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val1", "val2", "val4"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val1", "val2", "val3", "val4"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).areAllElementsEqualTo(DataHelper.createIterable("val3", "val1", "val2"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3"), "Message").areAllElementsEqualTo(DataHelper.createIterable("val3", "val1", "val2"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2")).contains("val1");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2")).contains("val2");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator(null, "val1", "val2")).contains(null);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", null, "val2")).contains(null);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", null)).contains(null);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2")).isNotNull().contains("val1").isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().contains("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).contains("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").contains("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2")).contains("val3");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2"), "Message").contains("val3");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", '1')).contains("val3");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", '1'), "Message").contains("val3");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2")).doesNotContain("val3");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", null)).doesNotContain("val3");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2")).doesNotContain(null);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2")).isNotNull().doesNotContain("val3").isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().doesNotContain("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).doesNotContain("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").doesNotContain("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2")).doesNotContain("val1");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2")).doesNotContain("val2");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2"), "Message").doesNotContain("val2");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", null, "val2")).doesNotContain(null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<<NULL>> but was:<[val1, <NULL>, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", null, "val2"), "Message").doesNotContain(null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<<NULL>> but was:<[val1, <NULL>, val2]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", '1')).doesNotContain("val1");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", '1'), "Message").doesNotContain("val1");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val2");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val3");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val1");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll("val5", "val1", "val3");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val5", "val4");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val1", "val4", "val5", "val2");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", null)).containsAll("val3", "val1", "val4", null, "val2");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).isNotNull().containsAll("val1", "val2").isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().containsAll("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAll("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAll("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAll((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAll((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsAll((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsAll((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsAll();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsAll();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val6");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll("val0", "val1");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val1", "val2");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", "val3", "val4", '1')).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", "val3", "val4", '1'), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val2"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val3"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val3", "val1"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val5", "val1", "val3"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val3", "val5", "val4"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val3", "val1", "val4", "val5", "val2"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", null)).containsAll(DataHelper.createIterable("val3", "val1", "val4", null, "val2"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).isNotNull().containsAll(DataHelper.createIterable("val1", "val2")).isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().containsAll(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAll(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAll(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAll((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAll((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsAll((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsAll((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsAll(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsAll(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val6"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val0", "val1"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val1", "val2"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAll(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5"), "Message").containsAll(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val3");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val3", "val5");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val3", "val4", "val5");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val1", "val1", "val2", "val2")).containsAllInOrder("val1", "val1", "val1", "val2", "val2");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", null)).containsAllInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).isNotNull().containsAllInOrder("val1", "val2").isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().containsAllInOrder("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAllInOrder("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAllInOrder("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAllInOrder((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAllInOrder((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsAllInOrder((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsAllInOrder((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsAllInOrder();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsAllInOrder();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val6");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val3", "val1");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val1", "val1")).containsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", "val3", "val4", '1')).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", "val3", "val4", '1'), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val2"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val3"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val3", "val5"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val3", "val4", "val5"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val1", "val1", "val2", "val2")).containsAllInOrder(DataHelper.createIterable("val1", "val1", "val1", "val2", "val2"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", null)).containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", null));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).isNotNull().containsAllInOrder(DataHelper.createIterable("val1", "val2")).isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAllInOrder((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsAllInOrder((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsAllInOrder(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val6"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val3", "val1"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val1", "val1")).containsAllInOrder(DataHelper.createIterable("val1", "val1", "val1", "val1"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly("val1", "val2", "val3");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly("val2", "val1", "val3");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly("val2", "val3", "val1");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly("val3", "val2", "val1");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsExactly("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsExactly("val2", "val4", "val1", "val3", "val5");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", null)).containsExactly("val2", "val4", "val1", "val3", null);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsExactly();
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().containsExactly("val1", "val2", "val3").isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().containsExactly("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactly("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactly("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactly((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactly((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsExactly((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsExactly((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly("val3", "val2", "val1", "val4");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly("val1", "val2");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly("val2", "val1");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly("val2", "val4", "val1");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3"), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", '1')).containsExactly("val2", "val4", "val1");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", '1'), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val1", "val2", "val3"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val1", "val3"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val3", "val1"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val3", "val2", "val1"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsExactly(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsExactly(DataHelper.createIterable("val2", "val4", "val1", "val3", "val5"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", null)).containsExactly(DataHelper.createIterable("val2", "val4", "val1", "val3", null));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsExactly(DataHelper.<String>createIterable());
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().containsExactly(DataHelper.createIterable("val1", "val2", "val3")).isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().containsExactly(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactly(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactly(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactly((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactly((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsExactly((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsExactly((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val1", "val2", "val3", "val4"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val3", "val2", "val1", "val4"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val1", "val2"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val1"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactly(DataHelper.createIterable("val2", "val4", "val1"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3"), "Message").containsExactly(DataHelper.createIterable("val2", "val4", "val1"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", null)).containsExactlyInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsExactlyInOrder();
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().containsExactlyInOrder("val1", "val2", "val3").isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().containsExactlyInOrder("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactlyInOrder("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactlyInOrder("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactlyInOrder((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsExactlyInOrder((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactlyInOrder("val2", "val3");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactlyInOrder();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3"), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", '1')).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", '1'), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", null)).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4", null));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsExactlyInOrder(DataHelper.<String>createIterable());
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3")).isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val2", "val3"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val4"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val1", "val2", "val3", "val4"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsExactlyInOrder(DataHelper.createIterable("val3", "val1", "val2"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3"), "Message").containsExactlyInOrder(DataHelper.createIterable("val3", "val1", "val2"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsAny("val1", "val3", "val5");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsAny("val6", "val2", "val4");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAny("val7", "val9", "val1", "val5", "val3");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", null)).containsAny("val7", "val9", "val1", null, "val3");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", null)).containsAny("val7", "val9", null);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().containsAny("val1", "val3", "val5").isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().containsAny("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAny("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAny("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAny((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAny((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsAny((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsAny((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsAny();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsAny();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsAny("val4", "val5", "val6");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAny("val8", "val7");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5"), "Message").containsAny("val8", "val7");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", "val3", "val4", '1')).containsAny("val8", "val7");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", "val3", "val4", '1'), "Message").containsAny("val8", "val7");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsAny(DataHelper.createIterable("val1", "val3", "val5"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsAny(DataHelper.createIterable("val6", "val2", "val4"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAny(DataHelper.createIterable("val7", "val9", "val1", "val5", "val3"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", null)).containsAny(DataHelper.createIterable("val7", "val9", "val1", null, "val3"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", null)).containsAny(DataHelper.createIterable("val7", "val9", null));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().containsAny(DataHelper.createIterable("val1", "val3", "val5")).isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().containsAny(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAny(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAny(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAny((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAny((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsAny((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsAny((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsAny(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsAny(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsAny(DataHelper.createIterable("val4", "val5", "val6"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).containsAny(DataHelper.createIterable("val8", "val7"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5"), "Message").containsAny(DataHelper.createIterable("val8", "val7"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsNone("val4", "val5", "val6");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsNone("val8", "val4");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", null)).containsNone("val8", "val4");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsNone("val8", "val4", null);
        initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", '1')).containsNone("val8", "val4");
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().containsNone("val4", "val5", "val6").isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().containsNone("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsNone("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsNone("val");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsNone((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsNone((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsNone((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsNone((String[]) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsNone();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsNone();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsNone("val4", "val2");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3"), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", '1')).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), DataHelper.createIterator((Object) "val1", "val2", '1'), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsNone(DataHelper.createIterable("val4", "val5", "val6"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsNone(DataHelper.createIterable("val8", "val4"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", null)).containsNone(DataHelper.createIterable("val8", "val4"));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsNone(DataHelper.createIterable("val8", "val4", null));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().containsNone(DataHelper.createIterable("val4", "val5", "val6")).isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().containsNone(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsNone(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsNone(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsNone((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsNone((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsNone((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsNone((Iterable<String>) null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).containsNone(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").containsNone(DataHelper.<String>createIterable());
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsNone(DataHelper.createIterable("val4", "val2"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).containsNone(DataHelper.createIterable("val5", "val4", "val2", "val6"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3"), "Message").containsNone(DataHelper.createIterable("val5", "val4", "val2", "val6"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).toSize().isEqualTo(3);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).toSize().isGreaterThan(2);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).toSize().isLessThan(6);

        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).toSize().isEqualTo(5);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).toSize().isGreaterThan(1);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).toSize().isLessThan(9);

        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().toSize().isEqualTo(3);

        try {
            Raw.<String>iteratorAssertion().toSize();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toSize();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toSize();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).toSize()).isEqualTo(1);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tCheck actual value's size.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3"), "Message").toSize()).isEqualTo(1);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tCheck actual value's size.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).toSize().isEqualTo(4);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3"), "Message").toSize().isEqualTo(4);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void toSizeMatcherTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).toSize(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).toSize(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).toSize(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).toSize(Matchers.equalTo(5));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).toSize(Matchers.greaterThan(4));
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).toSize(Matchers.lessThan(6));

        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().toSize(Matchers.is(Matchers.equalTo(3))).isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().toSize(Matchers.equalTo(0));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toSize(Matchers.equalTo(0));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toSize(Matchers.equalTo(0));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toSize(null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toSize(null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator()).toSize(null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.<String>createIterator(), "Message").toSize(null);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).toSize(Matchers.equalTo(4));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tCheck actual value's size.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3"), "Message").toSize(Matchers.equalTo(4));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tCheck actual value's size.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).hasSize(3);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3", "val4", "val5")).hasSize(5);
        initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNotNull().hasSize(3).isInstanceOf(Iterator.class);

        try {
            Raw.<String>iteratorAssertion().hasSize(1);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).hasSize(1);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").hasSize(1);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).hasSize(4);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3"), "Message").hasSize(4);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.<String>iteratorAssertion(), null).isNull();

        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3")).isNull();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual value should be null.\n\tActual:<ru.d_shap.assertions.util.DataHelper.*>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), DataHelper.createIterator("val1", "val2", "val3"), "Message").isNull();
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual value should be null.\n\tActual:<ru.d_shap.assertions.util.DataHelper.*>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Iterator<String> value = DataHelper.createIterator("val1", "val2", "val3");
        initialize(Raw.<String>iteratorAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.<String>iteratorAssertion(), value).isSameAs(DataHelper.createIterator("val1", "val2", "val3"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should point to the same object.\n\tExpected:<ru.d_shap.assertions.util.DataHelper.*> but was:<ru.d_shap.assertions.util.DataHelper.*>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), value, "Message").isSameAs(DataHelper.createIterator("val1", "val2", "val3"));
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<ru.d_shap.assertions.util.DataHelper.*> but was:<ru.d_shap.assertions.util.DataHelper.*>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Iterator<String> value = DataHelper.createIterator("val1", "val2", "val3");
        initialize(Raw.<String>iteratorAssertion(), value).isNotSameAs(DataHelper.createIterator("val1", "val2", "val3"));

        try {
            initialize(Raw.<String>iteratorAssertion(), value).isNotSameAs(value);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should point to the different objects.\n\tActual:<ru.d_shap.assertions.util.DataHelper.*>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(IteratorAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<ru.d_shap.assertions.util.DataHelper.*>");
        }
    }

}
