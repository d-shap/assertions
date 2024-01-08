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

import ru.d_shap.assertions.Messages;
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

}
