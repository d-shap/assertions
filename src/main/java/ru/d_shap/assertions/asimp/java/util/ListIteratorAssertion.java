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

import java.util.List;
import java.util.ListIterator;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;

/**
 * Assertions for the list iterator.
 *
 * @param <E> the generic type of the element.
 *
 * @author Dmitry Shapovalov
 */
public final class ListIteratorAssertion<E> extends ReferenceAssertion<ListIteratorAssertion<E>, ListIterator<E>> {

    /**
     * Create new object.
     */
    public ListIteratorAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Class<ListIterator<E>> getActualValueClass() {
        return (Class<ListIterator<E>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return ListIterator.class;
    }

    /**
     * Check if the actual value has next value.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> hasNextValue() {
        checkActualIsNotNull();
        if (!getActual().hasNext()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.HAS_NEXT_VALUE).build();
        }
        return this;
    }

    /**
     * Check if the actual value does not have next value.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> doesNotHaveNextValue() {
        checkActualIsNotNull();
        if (getActual().hasNext()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_HAVE_NEXT_VALUE).build();
        }
        return this;
    }

    /**
     * Check if the actual value has previous value.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> hasPreviousValue() {
        checkActualIsNotNull();
        if (!getActual().hasPrevious()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.HAS_PREVIOUS_VALUE).build();
        }
        return this;
    }

    /**
     * Check if the actual value does not have previous value.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> doesNotHavePreviousValue() {
        checkActualIsNotNull();
        if (getActual().hasPrevious()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_HAVE_PREVIOUS_VALUE).build();
        }
        return this;
    }

    /**
     * Make assertion about all next list iterator elements from the current position.
     *
     * @return the assertion.
     */
    public ListAssertion<E> toNextList() {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), null, List.class, 0, true);
        return initializeAssertion(Raw.<E>listAssertion(), list, Messages.Check.ELEMENTS_ALL_NEXT);
    }

    /**
     * Make assertion about all next list iterator elements from the current position.
     *
     * @param count the number of elements to get from the list iterator.
     *
     * @return the assertion.
     */
    public ListAssertion<E> toNextList(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        List<E> list = convertValue(getActual(), null, List.class, count, true);
        return initializeAssertion(Raw.<E>listAssertion(), list, Messages.Check.ELEMENTS_COUNT_NEXT, count);
    }

    /**
     * Make assertion about all next list iterator elements from the current position.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> toNextList(final Matcher<? super Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        List<E> list = convertValue(getActual(), null, List.class, 0, true);
        matcherAssertion(list, matcher, Messages.Check.ELEMENTS_ALL_NEXT);
        return this;
    }

    /**
     * Make assertion about all next list iterator elements from the current position.
     *
     * @param count   the number of elements to get from the list iterator.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> toNextList(final int count, final Matcher<? super Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        List<E> list = convertValue(getActual(), null, List.class, count, true);
        matcherAssertion(list, matcher, Messages.Check.ELEMENTS_COUNT_NEXT, count);
        return this;
    }

    /**
     * Make assertion about all previous list iterator elements from the current position.
     *
     * @return the assertion.
     */
    public ListAssertion<E> toPreviousList() {
        checkActualIsNotNull();
        List<E> list = convertValue(getActual(), null, List.class, 0, false);
        return initializeAssertion(Raw.<E>listAssertion(), list, Messages.Check.ELEMENTS_ALL_PREVIOUS);
    }

    /**
     * Make assertion about all previous list iterator elements from the current position.
     *
     * @param count the number of elements to get from the list iterator.
     *
     * @return the assertion.
     */
    public ListAssertion<E> toPreviousList(final int count) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        List<E> list = convertValue(getActual(), null, List.class, count, false);
        return initializeAssertion(Raw.<E>listAssertion(), list, Messages.Check.ELEMENTS_COUNT_PREVIOUS, count);
    }

    /**
     * Make assertion about all previous list iterator elements from the current position.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> toPreviousList(final Matcher<? super Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        List<E> list = convertValue(getActual(), null, List.class, 0, false);
        matcherAssertion(list, matcher, Messages.Check.ELEMENTS_ALL_PREVIOUS);
        return this;
    }

    /**
     * Make assertion about all previous list iterator elements from the current position.
     *
     * @param count   the number of elements to get from the list iterator.
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public ListIteratorAssertion<E> toPreviousList(final int count, final Matcher<? super Iterable<E>> matcher) {
        checkActualIsNotNull();
        checkArgumentIsValid(count > 0, "count", Messages.Fail.Argument.IS_GREATER_THAN_ZERO);
        checkArgumentIsNotNull(matcher, "matcher");
        List<E> list = convertValue(getActual(), null, List.class, count, false);
        matcherAssertion(list, matcher, Messages.Check.ELEMENTS_COUNT_PREVIOUS, count);
        return this;
    }

}
