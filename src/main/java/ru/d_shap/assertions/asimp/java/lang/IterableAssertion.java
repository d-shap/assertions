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
public class IterableAssertion<E> extends ReferenceAssertion<Iterable<E>> {

    /**
     * Create new object.
     */
    public IterableAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected final Class<Iterable<E>> getActualValueClass() {
        return (Class<Iterable<E>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return Iterable.class;
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), List.class);
        if (!list.isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_EMPTY).addActual().build();
        }
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        List<E> list = convertValue(getActual(), List.class);
        if (list != null && !list.isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NULL_OR_EMPTY).addActual().build();
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), List.class);
        if (list.isEmpty()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_EMPTY).build();
        }
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final E expected) {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), List.class);
        if (!list.contains(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.CONTAINS).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final E expected) {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), List.class);
        if (list.contains(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_CONTAIN).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    @SafeVarargs
    public final void containsAll(final E... expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsAll(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Iterable<E> expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsAll(expectedList);
    }

    private void containsAll(final List<?> expected) {
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.isEmpty());
        List<?> list = convertValue(getActual(), List.class);
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
     */
    @SafeVarargs
    public final void containsAllInOrder(final E... expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsAllInOrder(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Iterable<E> expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsAllInOrder(expectedList);
    }

    private void containsAllInOrder(final List<?> expected) {
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.isEmpty());
        List<?> list = convertValue(getActual(), List.class);
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
     */
    @SafeVarargs
    public final void containsExactly(final E... expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsExactly(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Iterable<E> expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsExactly(expectedList);
    }

    private void containsExactly(final List<?> expected) {
        checkArgumentIsNotNull(expected);
        List<?> list = convertValue(getActual(), List.class);
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
     */
    @SafeVarargs
    public final void containsExactlyInOrder(final E... expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsExactlyInOrder(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Iterable<E> expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsExactlyInOrder(expectedList);
    }

    private void containsExactlyInOrder(final List<?> expected) {
        checkArgumentIsNotNull(expected);
        List<?> list = convertValue(getActual(), List.class);
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
     */
    @SafeVarargs
    public final void containsAny(final E... expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsAny(expectedList);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Iterable<E> expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsAny(expectedList);
    }

    private void containsAny(final List<?> expected) {
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyFalse(expected.isEmpty());
        List<?> list = convertValue(getActual(), List.class);
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
     */
    @SafeVarargs
    public final void containsNone(final E... expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsNone(expectedList);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Iterable<E> expected) {
        checkActualIsNotNull();
        List<?> expectedList = convertValue(expected, List.class);
        containsNone(expectedList);
    }

    private void containsNone(final List<?> expected) {
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.isEmpty());
        List<?> list = convertValue(getActual(), List.class);
        for (Object expectedItem : expected) {
            int idx = list.indexOf(expectedItem);
            if (idx >= 0) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.CONTAINS_NONE).addActual().addExpected(expected).build();
            }
        }
    }

    /**
     * Make assertion about the actual value size.
     *
     * @return the assertion.
     */
    public final IntAssertion toSize() {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), List.class);
        return initializeAssertion(Raw.intAssertion(), list.size(), Messages.Check.SIZE);
    }

    /**
     * Make assertion about the actual value's size.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toSize(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        List<E> list = convertValue(getActual(), List.class);
        matcherAssertion(list.size(), matcher, Messages.Check.SIZE);
    }

    /**
     * Check if the actual value's size is equal to the expected size.
     *
     * @param expected the expected size.
     */
    public final void hasSize(final int expected) {
        toSize().isEqualTo(expected);
    }

}
