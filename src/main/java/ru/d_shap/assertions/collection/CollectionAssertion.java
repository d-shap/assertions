///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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
package ru.d_shap.assertions.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import ru.d_shap.assertions.FailMessages;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the collection.
 *
 * @author Dmitry Shapovalov
 */
public class CollectionAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual collection.
     * @param message the assertion message.
     */
    public CollectionAssertion(final Collection<?> actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual collection is empty.
     */
    public final void isEmpty() {
        if (!((Collection) getActual()).isEmpty()) {
            throw createAssertionError(FailMessages.getCollectionEmpty(actualAsString()));
        }
    }

    /**
     * Check if the actual collection is NOT empty.
     */
    public final void isNotEmpty() {
        if (((Collection) getActual()).isEmpty()) {
            throw createAssertionError(FailMessages.getCollectionNotEmpty());
        }
    }

    /**
     * Check if the actual collection has the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasValue(final Object expected) {
        if (!((Collection) getActual()).contains(expected)) {
            throw createAssertionError(FailMessages.getCollectionHasValue(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual collection has NOT the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasNotValue(final Object expected) {
        if (((Collection) getActual()).contains(expected)) {
            throw createAssertionError(FailMessages.getCollectionHasNotValue(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual collection has all the expected values.
     *
     * @param expected the expected values.
     */
    public final void hasAllValues(final Object... expected) {

    }

    /**
     * Check if the actual collection has all the expected values in any order.
     *
     * @param expected the expected values.
     */
    public final void hasAllValuesInAnyOrder(final Object... expected) {
        List<?> actualListCopy = new ArrayList<>((Collection<?>) getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                actualListCopy.remove(idx);
            } else {
                List<?> expectedList = Arrays.asList(expected);
                throw createAssertionError(FailMessages.getCollectionHasAllValuesInAnyOrder(actualAsString(), asString(expectedList)));
            }
        }
    }

    /**
     * Check if the actual collection has the exact expected values.
     *
     * @param expected the expected values.
     */
    public final void hasExactValues(final Object... expected) {

    }

    /**
     * Check if the actual collection has the exact expected values in any order.
     *
     * @param expected the expected values.
     */
    public final void hasExactValuesInAnyOrder(final Object... expected) {

    }

    /**
     * Check if the actual collection has any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void hasAnyValue(final Object... expected) {

    }

    /**
     * Make assertion about the actual collection size.
     *
     * @return assertion.
     */
    public final IntAssertion toSize() {
        return new IntAssertion(((Collection) getActual()).size(), getMessage());
    }

    /**
     * Check if the actual collection size is equal to the expected collection size.
     *
     * @param expected the expected collection size.
     */
    public final void hasSize(final int expected) {
        toSize().isEqualTo(expected);
    }

    @Override
    protected final String asString(final Object value) {
        return String.valueOf(value);
    }

}
