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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

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
        initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator());

        try {
            initializeWithRawActual(Raw.<String>iteratorAssertion(), new Object());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Iterator> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.<String>iteratorAssertion(), new Object(), "Message");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Iterator> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isCompletedTest() {
        initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).isCompleted();
        Iterator<String> iterator = Arrays.asList("val1", "val2", "val3").iterator();
        Assertions.assertThat(iterator.next()).isEqualTo("val1");
        Assertions.assertThat(iterator.next()).isEqualTo("val2");
        Assertions.assertThat(iterator.next()).isEqualTo("val3");
        initialize(Raw.<String>iteratorAssertion(), iterator).isCompleted();

        try {
            Raw.<String>iteratorAssertion().isCompleted();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isCompleted();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isCompleted();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isCompleted();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be completed.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator(), "Message").isCompleted();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be completed.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNotCompletedTest() {
        Iterator<String> iterator = Arrays.asList("val1", "val2", "val3").iterator();
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

        try {
            Raw.<String>iteratorAssertion().isNotCompleted();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isNotCompleted();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isNotCompleted();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).isNotCompleted();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be completed.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").isNotCompleted();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be completed.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void toListTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList().containsExactlyInOrder("val1", "val2", "val3", "val4");

        try {
            Raw.<String>iteratorAssertion().toList();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toList();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toList();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList()).containsExactlyInOrder("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator(), "Message").toList()).containsExactlyInOrder("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList().containsExactlyInOrder("val1", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator(), "Message").toList().containsExactlyInOrder("val1", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void toListSizeTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(5).containsExactlyInOrder("val1", "val2", "val3", "val4");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(4).containsExactlyInOrder("val1", "val2", "val3", "val4");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(3).containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(2).containsExactlyInOrder("val1", "val2");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(1).containsExactlyInOrder("val1");

        try {
            Raw.<String>iteratorAssertion().toList(1);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toList(1);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toList(1);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toList(0);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toList(0);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).toList(0);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").toList(0);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).toList(-1);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").toList(-1);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            clearActual(initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(1)).containsExactlyInOrder("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator(), "Message").toList(1)).containsExactlyInOrder("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(5).containsExactlyInOrder("val1", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator(), "Message").toList(5).containsExactlyInOrder("val1", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val4]> but was:<[val1, val2, val3, val4]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void toListMatcherTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(Matchers.hasItems("val1", "val2", "val3", "val4"));

        try {
            Raw.<String>iteratorAssertion().toList(Matchers.hasItems(""));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toList(Matchers.hasItems(""));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toList(Matchers.hasItems(""));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toList(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toList(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).toList(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").toList(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(Matchers.hasItems("val1", "val5"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" was \"val1\", was \"val2\", was \"val3\", was \"val4\"");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator(), "Message").toList(Matchers.hasItems("val1", "val5"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" was \"val1\", was \"val2\", was \"val3\", was \"val4\"");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void toListSizeMatcherTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(5, Matchers.hasItems("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(4, Matchers.hasItems("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(3, Matchers.hasItems("val1", "val2", "val3"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(2, Matchers.hasItems("val1", "val2"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(1, Matchers.hasItems("val1"));

        try {
            Raw.<String>iteratorAssertion().toList(1, Matchers.hasItems(""));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toList(1, Matchers.hasItems(""));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toList(1, Matchers.hasItems(""));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toList(0, Matchers.hasItems(""));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toList(0, Matchers.hasItems(""));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).toList(0, Matchers.hasItems(""));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").toList(0, Matchers.hasItems(""));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).toList(-1, Matchers.hasItems(""));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").toList(-1, Matchers.hasItems(""));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).toList(0, null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").toList(0, null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).toList(1, null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").toList(1, null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(5, Matchers.hasItems("val1", "val5"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" was \"val1\", was \"val2\", was \"val3\", was \"val4\"");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator(), "Message").toList(5, Matchers.hasItems("val1", "val5"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\nExpected: (a collection containing \"val1\" and a collection containing \"val5\")\n     but: a collection containing \"val5\" was \"val1\", was \"val2\", was \"val3\", was \"val4\"");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).isEmpty();
        initialize(Raw.iteratorAssertion(), createHashSet().iterator()).isEmpty();
        initialize(Raw.iteratorAssertion(), createTreeSet().iterator()).isEmpty();

        try {
            Raw.<String>iteratorAssertion().isEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).isEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should be empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2").iterator(), "Message").isEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should be empty.\n\tActual:<[val1, val2]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).isNullOrEmpty();
        initialize(Raw.iteratorAssertion(), createHashSet().iterator()).isNullOrEmpty();
        initialize(Raw.iteratorAssertion(), createTreeSet().iterator()).isNullOrEmpty();
        initialize(Raw.<String>iteratorAssertion(), null).isNullOrEmpty();

        try {
            Raw.<String>iteratorAssertion().isNullOrEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).isNullOrEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2").iterator(), "Message").isNullOrEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should be null or empty.\n\tActual:<[val1, val2]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).isNotEmpty();
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("test1", "test2").iterator()).isNotEmpty();

        try {
            Raw.<String>iteratorAssertion().isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.iteratorAssertion(), createHashSet().iterator()).isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.iteratorAssertion(), createHashSet().iterator(), "Message").isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.iteratorAssertion(), createTreeSet().iterator()).isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.iteratorAssertion(), createTreeSet().iterator(), "Message").isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNextElementEqualToTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isNextElementEqualTo("val1");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val2", "val3").iterator()).isNextElementEqualTo("val2");
        initialize(Raw.<String>iteratorAssertion(), Arrays.<String>asList(null, null).iterator()).isNextElementEqualTo(null);

        try {
            Raw.<String>iteratorAssertion().isNextElementEqualTo("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isNextElementEqualTo("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isNextElementEqualTo("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isNextElementEqualTo("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").isNextElementEqualTo("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList(null, "val2", "val3").iterator()).isNextElementEqualTo("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[<NULL>]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList(null, "val2", "val3").iterator(), "Message").isNextElementEqualTo("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val]> but was:<[<NULL>]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isNextElementEqualTo(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[<NULL>]> but was:<[val1]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").isNextElementEqualTo(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[<NULL>]> but was:<[val1]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNextElementsEqualToArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo("val1", "val2");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo("val1", "val2", "val3");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo("val1", "val2", "val3", "val4");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", null, "val4").iterator()).isNextElementsEqualTo("val1", "val2", null, "val4");

        try {
            Raw.<String>iteratorAssertion().isNextElementsEqualTo("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isNextElementsEqualTo("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isNextElementsEqualTo("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isNextElementsEqualTo((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isNextElementsEqualTo((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).isNextElementsEqualTo((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").isNextElementsEqualTo((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).isNextElementsEqualTo();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").isNextElementsEqualTo();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo("val2", "val3");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator(), "Message").isNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", "val3", '1').iterator()).isNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", "val3", '1').iterator(), "Message").isNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNextElementsEqualToIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo(Arrays.asList("val1", "val2"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo(Arrays.asList("val1", "val2", "val3"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo(Arrays.asList("val1", "val2", "val3", "val4"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", null, "val4").iterator()).isNextElementsEqualTo(Arrays.asList("val1", "val2", null, "val4"));

        try {
            Raw.<String>iteratorAssertion().isNextElementsEqualTo(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isNextElementsEqualTo(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isNextElementsEqualTo(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isNextElementsEqualTo((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isNextElementsEqualTo((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).isNextElementsEqualTo((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").isNextElementsEqualTo((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).isNextElementsEqualTo(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").isNextElementsEqualTo(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo(Arrays.asList("val2", "val3"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator(), "Message").isNextElementsEqualTo(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's elements: 5.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isAllElementsEqualToArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isAllElementsEqualTo("val1", "val2", "val3");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).isAllElementsEqualTo("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).isAllElementsEqualTo("val1", "val2", "val3", "val4", null);
        initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).isAllElementsEqualTo();

        try {
            Raw.<String>iteratorAssertion().isAllElementsEqualTo("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isAllElementsEqualTo("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isAllElementsEqualTo("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isAllElementsEqualTo((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isAllElementsEqualTo((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).isAllElementsEqualTo((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").isAllElementsEqualTo((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isAllElementsEqualTo("val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isAllElementsEqualTo("val2", "val3");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isAllElementsEqualTo("val1", "val2", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isAllElementsEqualTo("val1", "val2", "val3", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isAllElementsEqualTo();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isAllElementsEqualTo("val3", "val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").isAllElementsEqualTo("val3", "val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", '1').iterator()).isAllElementsEqualTo("val3", "val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", '1').iterator(), "Message").isAllElementsEqualTo("val3", "val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isAllElementsEqualToIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isAllElementsEqualTo(Arrays.asList("val1", "val2", "val3"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).isAllElementsEqualTo(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).isAllElementsEqualTo(Arrays.asList("val1", "val2", "val3", "val4", null));
        initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).isAllElementsEqualTo(new ArrayList<String>());

        try {
            Raw.<String>iteratorAssertion().isAllElementsEqualTo(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isAllElementsEqualTo(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isAllElementsEqualTo(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).isAllElementsEqualTo((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").isAllElementsEqualTo((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).isAllElementsEqualTo((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").isAllElementsEqualTo((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isAllElementsEqualTo(Arrays.asList("val1", "val2"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isAllElementsEqualTo(Arrays.asList("val2", "val3"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isAllElementsEqualTo(Arrays.asList("val1", "val2", "val4"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isAllElementsEqualTo(Arrays.asList("val1", "val2", "val3", "val4"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isAllElementsEqualTo(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isAllElementsEqualTo(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").isAllElementsEqualTo(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).contains("val1");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).contains("val2");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList(null, "val1", "val2").iterator()).contains(null);
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", null, "val2").iterator()).contains(null);
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", null).iterator()).contains(null);

        try {
            Raw.<String>iteratorAssertion().contains("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).contains("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").contains("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).contains("val3");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2").iterator(), "Message").contains("val3");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", '1').iterator()).contains("val3");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", '1').iterator(), "Message").contains("val3");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain the expected value.\n\tExpected:<val3> but was:<[val1, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).doesNotContain("val3");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", null).iterator()).doesNotContain("val3");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).doesNotContain(null);

        try {
            Raw.<String>iteratorAssertion().doesNotContain("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).doesNotContain("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").doesNotContain("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).doesNotContain("val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).doesNotContain("val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2").iterator(), "Message").doesNotContain("val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", null, "val2").iterator()).doesNotContain(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<<NULL>> but was:<[val1, <NULL>, val2]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", null, "val2").iterator(), "Message").doesNotContain(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<<NULL>> but was:<[val1, <NULL>, val2]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", '1').iterator()).doesNotContain("val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", '1').iterator(), "Message").doesNotContain("val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not contain the expected value.\n\tExpected:<val1> but was:<[val1, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val1", "val2");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val1", "val3");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val3", "val1");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val5", "val1", "val3");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val3", "val5", "val4");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val3", "val1", "val4", "val5", "val2");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAll("val3", "val1", "val4", null, "val2");

        try {
            Raw.<String>iteratorAssertion().containsAll("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAll("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAll("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAll((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAll((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsAll((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsAll((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsAll();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsAll();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val1", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val0", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val1", "val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", "val3", "val4", '1').iterator()).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", "val3", "val4", '1').iterator(), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll(Arrays.asList("val1", "val2"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll(Arrays.asList("val1", "val3"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll(Arrays.asList("val3", "val1"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll(Arrays.asList("val5", "val1", "val3"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll(Arrays.asList("val3", "val5", "val4"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll(Arrays.asList("val3", "val1", "val4", "val5", "val2"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAll(Arrays.asList("val3", "val1", "val4", null, "val2"));

        try {
            Raw.<String>iteratorAssertion().containsAll(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAll(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAll(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAll((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAll((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsAll((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsAll((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsAll(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsAll(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll(Arrays.asList("val1", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll(Arrays.asList("val0", "val1"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll(Arrays.asList("val1", "val1", "val2"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val1", "val2");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val1", "val3");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val1", "val3", "val5");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val3", "val4", "val5");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val1", "val1", "val2", "val2").iterator()).containsAllInOrder("val1", "val1", "val1", "val2", "val2");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAllInOrder("val1", "val2", "val3", "val4", null);

        try {
            Raw.<String>iteratorAssertion().containsAllInOrder("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAllInOrder("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAllInOrder("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAllInOrder((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAllInOrder((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsAllInOrder((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsAllInOrder((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsAllInOrder();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsAllInOrder();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val1", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val3", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val1", "val1").iterator()).containsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", "val3", "val4", '1').iterator()).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", "val3", "val4", '1').iterator(), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder(Arrays.asList("val1", "val2"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder(Arrays.asList("val1", "val3"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder(Arrays.asList("val1", "val3", "val5"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder(Arrays.asList("val3", "val4", "val5"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val1", "val1", "val2", "val2").iterator()).containsAllInOrder(Arrays.asList("val1", "val1", "val1", "val2", "val2"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", null));

        try {
            Raw.<String>iteratorAssertion().containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder(Arrays.asList("val1", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder(Arrays.asList("val3", "val1"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val1", "val1").iterator()).containsAllInOrder(Arrays.asList("val1", "val1", "val1", "val1"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val1", "val2", "val3");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val2", "val1", "val3");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val2", "val3", "val1");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val3", "val2", "val1");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsExactly("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsExactly("val2", "val4", "val1", "val3", "val5");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsExactly("val2", "val4", "val1", "val3", null);
        initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsExactly();

        try {
            Raw.<String>iteratorAssertion().containsExactly("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactly("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactly("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactly((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactly((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsExactly((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsExactly((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val3", "val2", "val1", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val2", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val2", "val4", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", '1').iterator()).containsExactly("val2", "val4", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", '1').iterator(), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly(Arrays.asList("val1", "val2", "val3"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly(Arrays.asList("val2", "val1", "val3"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly(Arrays.asList("val2", "val3", "val1"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly(Arrays.asList("val3", "val2", "val1"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsExactly(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsExactly(Arrays.asList("val2", "val4", "val1", "val3", "val5"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsExactly(Arrays.asList("val2", "val4", "val1", "val3", null));
        initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsExactly(new ArrayList<String>());

        try {
            Raw.<String>iteratorAssertion().containsExactly(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactly(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactly(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactly((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactly((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsExactly((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsExactly((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly(Arrays.asList("val1", "val2", "val3", "val4"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly(Arrays.asList("val3", "val2", "val1", "val4"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly(Arrays.asList("val1", "val2"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly(Arrays.asList("val2", "val1"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsExactlyInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsExactlyInOrder();

        try {
            Raw.<String>iteratorAssertion().containsExactlyInOrder("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactlyInOrder("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactlyInOrder("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactlyInOrder((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsExactlyInOrder((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder("val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder("val2", "val3");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", '1').iterator()).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", '1').iterator(), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", null));
        initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsExactlyInOrder(new ArrayList<String>());

        try {
            Raw.<String>iteratorAssertion().containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder(Arrays.asList("val1", "val2"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder(Arrays.asList("val2", "val3"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder(Arrays.asList("val1", "val2", "val4"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsAny("val1", "val3", "val5");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsAny("val6", "val2", "val4");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAny("val7", "val9", "val1", "val5", "val3");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAny("val7", "val9", "val1", null, "val3");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAny("val7", "val9", null);

        try {
            Raw.<String>iteratorAssertion().containsAny("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAny("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAny("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAny((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAny((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsAny((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsAny((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsAny();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsAny();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsAny("val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAny("val8", "val7");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAny("val8", "val7");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", "val3", "val4", '1').iterator()).containsAny("val8", "val7");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", "val3", "val4", '1').iterator(), "Message").containsAny("val8", "val7");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsAny(Arrays.asList("val1", "val3", "val5"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsAny(Arrays.asList("val6", "val2", "val4"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAny(Arrays.asList("val7", "val9", "val1", "val5", "val3"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAny(Arrays.asList("val7", "val9", "val1", null, "val3"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAny(Arrays.asList("val7", "val9", null));

        try {
            Raw.<String>iteratorAssertion().containsAny(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAny(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAny(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsAny((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsAny((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsAny((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsAny((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsAny(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsAny(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsAny(Arrays.asList("val4", "val5", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should contain any of the expected values.\n\tExpected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone("val4", "val5", "val6");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone("val8", "val4");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", null).iterator()).containsNone("val8", "val4");
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone("val8", "val4", null);
        initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", '1').iterator()).containsNone("val8", "val4");

        try {
            Raw.<String>iteratorAssertion().containsNone("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsNone("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsNone("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsNone((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsNone((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsNone((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsNone((String[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsNone();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsNone();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone("val4", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", '1').iterator()).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, 1(49)]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList((Object) "val1", "val2", '1').iterator(), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, 1(49)]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone(Arrays.asList("val4", "val5", "val6"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone(Arrays.asList("val8", "val4"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", null).iterator()).containsNone(Arrays.asList("val8", "val4"));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone(Arrays.asList("val8", "val4", null));

        try {
            Raw.<String>iteratorAssertion().containsNone(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsNone(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsNone(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).containsNone((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").containsNone((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsNone((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsNone((Iterable<String>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).containsNone(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").containsNone(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone(Arrays.asList("val4", "val2"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tActual value should not contain any of the expected values.\n\tExpected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).toSize().isEqualTo(3);
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).toSize().isGreaterThan(2);
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).toSize().isLessThan(6);

        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).toSize().isEqualTo(5);
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).toSize().isGreaterThan(1);
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).toSize().isLessThan(9);

        try {
            Raw.<String>iteratorAssertion().toSize();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toSize();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toSize();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).toSize()).isEqualTo(1);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tCheck actual value's size.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").toSize()).isEqualTo(1);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tCheck actual value's size.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).toSize().isEqualTo(4);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").toSize().isEqualTo(4);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void toSizeMatcherTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).toSize(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).toSize(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).toSize(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).toSize(Matchers.equalTo(5));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).toSize(Matchers.greaterThan(4));
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).toSize(Matchers.lessThan(6));

        try {
            Raw.<String>iteratorAssertion().toSize(Matchers.equalTo(0));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toSize(Matchers.equalTo(0));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toSize(Matchers.equalTo(0));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).toSize(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").toSize(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator()).toSize(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Collections.<String>emptyIterator(), "Message").toSize(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).toSize(Matchers.equalTo(4));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tCheck actual value's size.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").toSize(Matchers.equalTo(4));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's elements.\n\tCheck actual value's size.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).hasSize(3);
        initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).hasSize(5);

        try {
            Raw.<String>iteratorAssertion().hasSize(1);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null).hasSize(1);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), null, "Message").hasSize(1);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).hasSize(4);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's elements.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").hasSize(4);
            Assertions.fail("IteratorAssertion test fail");
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
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isNull();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual value should be null.\n\tActual:<java.util.AbstractList.*>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").isNull();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual value should be null.\n\tActual:<java.util.AbstractList.*>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Iterator<String> value = Arrays.asList("val1", "val2", "val3").iterator();
        initialize(Raw.<String>iteratorAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.<String>iteratorAssertion(), value).isSameAs(Arrays.asList("val1", "val2", "val3").iterator());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should be the same.\n\tExpected:<java.util.AbstractList.*> but was:<java.util.AbstractList.*>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), value, "Message").isSameAs(Arrays.asList("val1", "val2", "val3").iterator());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should be the same.\n\tExpected:<java.util.AbstractList.*> but was:<java.util.AbstractList.*>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Iterator<String> value = Arrays.asList("val1", "val2", "val3").iterator();
        initialize(Raw.<String>iteratorAssertion(), value).isNotSameAs(Arrays.asList("val1", "val2", "val3").iterator());

        try {
            initialize(Raw.<String>iteratorAssertion(), value).isNotSameAs(value);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should be different.\n\tActual:<java.util.AbstractList.*>");
        }
        try {
            initialize(Raw.<String>iteratorAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should be different.\n\tActual:<java.util.AbstractList.*>");
        }
    }

}
