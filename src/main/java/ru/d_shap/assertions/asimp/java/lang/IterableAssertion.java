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

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the iterable.
 *
 * @param <E> the generic type of the element.
 *
 * @author Dmitry Shapovalov
 */
public final class IterableAssertion<E> extends ReferenceAssertion<IterableAssertion<E>, Iterable<E>> {

    /**
     * Create new object.
     */
    public IterableAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Class<Iterable<E>> getActualValueClass() {
        return (Class<Iterable<E>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return Iterable.class;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public IterableAssertion<E> isEmpty() {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), null, List.class);
        if (!list.isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_EMPTY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public IterableAssertion<E> isNullOrEmpty() {
        List<E> list = convertValue(getActual(), null, List.class);
        if (list != null && !list.isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NULL_OR_EMPTY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public IterableAssertion<E> isNotEmpty() {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), null, List.class);
        if (list.isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_EMPTY).build();
        }
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IterableAssertion<E> contains(final E expected) {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), null, List.class);
        if (!list.contains(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.CONTAINS).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IterableAssertion<E> doesNotContain(final E expected) {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), null, List.class);
        if (list.contains(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_CONTAIN).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final IterableAssertion<E> containsAll(final E... expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, null, List.class);
        containsAll(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IterableAssertion<E> containsAll(final Iterable<E> expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, null, List.class);
        containsAll(expectedList);
        return this;
    }

    private void containsAll(final List<?> expected) {
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.isEmpty(), "expected", true);
        List<?> list = convertValue(getActual(), null, List.class);
        List<?> listCopy = new ArrayList<>(list);
        for (Object expectedItem : expected) {
            int idx = listCopy.indexOf(expectedItem);
            if (idx >= 0) {
                listCopy.remove(idx);
            } else {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.CONTAINS_ALL).addActual().addExpected(expected).build();
            }
        }
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final IterableAssertion<E> containsAllInOrder(final E... expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, null, List.class);
        containsAllInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IterableAssertion<E> containsAllInOrder(final Iterable<E> expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, null, List.class);
        containsAllInOrder(expectedList);
        return this;
    }

    private void containsAllInOrder(final List<?> expected) {
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.isEmpty(), "expected", true);
        List<?> list = convertValue(getActual(), null, List.class);
        List<?> listCopy = new ArrayList<>(list);
        for (Object expectedItem : expected) {
            int idx = listCopy.indexOf(expectedItem);
            if (idx >= 0) {
                listCopy = listCopy.subList(idx + 1, listCopy.size());
            } else {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.CONTAINS_ALL_IN_ORDER).addActual().addExpected(expected).build();
            }
        }
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final IterableAssertion<E> containsExactly(final E... expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, null, List.class);
        containsExactly(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IterableAssertion<E> containsExactly(final Iterable<E> expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, null, List.class);
        containsExactly(expectedList);
        return this;
    }

    private void containsExactly(final List<?> expected) {
        checkArgumentIsNotNull(expected, "expected");
        List<?> list = convertValue(getActual(), null, List.class);
        List<?> listCopy = new ArrayList<>(list);
        int elementCount = 0;
        for (Object expectedItem : expected) {
            int idx = listCopy.indexOf(expectedItem);
            if (idx >= 0) {
                listCopy.remove(idx);
                elementCount++;
            }
        }
        if (!listCopy.isEmpty() || elementCount != expected.size()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.CONTAINS_EXACTLY).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final IterableAssertion<E> containsExactlyInOrder(final E... expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, null, List.class);
        containsExactlyInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IterableAssertion<E> containsExactlyInOrder(final Iterable<E> expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, null, List.class);
        containsExactlyInOrder(expectedList);
        return this;
    }

    private void containsExactlyInOrder(final List<?> expected) {
        checkArgumentIsNotNull(expected, "expected");
        List<?> list = convertValue(getActual(), null, List.class);
        List<?> listCopy = new ArrayList<>(list);
        for (Object expectedItem : expected) {
            int idx = listCopy.indexOf(expectedItem);
            if (idx == 0) {
                listCopy.remove(idx);
            } else {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.CONTAINS_EXACTLY_IN_ORDER).addActual().addExpected(expected).build();
            }
        }
        if (!listCopy.isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.CONTAINS_EXACTLY_IN_ORDER).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final IterableAssertion<E> containsAny(final E... expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, null, List.class);
        containsAny(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IterableAssertion<E> containsAny(final Iterable<E> expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, null, List.class);
        containsAny(expectedList);
        return this;
    }

    private void containsAny(final List<?> expected) {
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.isEmpty(), "expected", false);
        List<?> list = convertValue(getActual(), null, List.class);
        boolean found = false;
        for (Object expectedItem : expected) {
            int idx = list.indexOf(expectedItem);
            if (idx >= 0) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.CONTAINS_ANY).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    @SafeVarargs
    public final IterableAssertion<E> containsNone(final E... expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, null, List.class);
        containsNone(expectedList);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public IterableAssertion<E> containsNone(final Iterable<E> expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, null, List.class);
        containsNone(expectedList);
        return this;
    }

    private void containsNone(final List<?> expected) {
        checkArgumentIsNotNull(expected, "expected");
        checkArgumentIsNotEmpty(expected.isEmpty(), "expected", true);
        List<?> list = convertValue(getActual(), null, List.class);
        for (Object expectedItem : expected) {
            int idx = list.indexOf(expectedItem);
            if (idx >= 0) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.CONTAINS_NONE).addActual().addExpected(expected).build();
            }
        }
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @return the assertion.
     */
    public IntAssertion toSize() {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), null, List.class);
        return initializeAssertion(Raw.intAssertion(), list.size(), Messages.Check.SIZE);
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IterableAssertion<E> toSize(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        List<E> list = convertValue(getActual(), null, List.class);
        matcherAssertion(list.size(), matcher, Messages.Check.SIZE);
        return this;
    }

    /**
     * Check if the actual value's size is equal to the expected size.
     *
     * @param expected the expected size.
     *
     * @return current object for the chain call.
     */
    public IterableAssertion<E> hasSize(final int expected) {
        toSize().isEqualTo(expected);
        return this;
    }

}
