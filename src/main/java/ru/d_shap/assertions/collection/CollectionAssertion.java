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
            throw createAssertionError(FailMessages.getCollectionIsEmpty(actualAsString()));
        }
    }

    /**
     * Check if the actual collection is NOT empty.
     */
    public final void isNotEmpty() {
        if (((Collection) getActual()).isEmpty()) {
            throw createAssertionError(FailMessages.getCollectionIsNotEmpty());
        }
    }

    /**
     * Check if the actual collection contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final Object expected) {
        if (!((Collection) getActual()).contains(expected)) {
            throw createAssertionError(FailMessages.getCollectionContains(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual collection does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final Object expected) {
        if (((Collection) getActual()).contains(expected)) {
            throw createAssertionError(FailMessages.getCollectionDoesNotContain(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual collection contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Object... expected) {
        List<?> actualListCopy = new ArrayList<>((Collection<?>) getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                actualListCopy = actualListCopy.subList(idx + 1, actualListCopy.size());
            } else {
                List<?> expectedList = Arrays.asList(expected);
                throw createAssertionError(FailMessages.getCollectionContainsAll(actualAsString(), asString(expectedList)));
            }
        }
    }

    /**
     * Check if the actual collection contains all of the expected values in any order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInAnyOrder(final Object... expected) {
        List<?> actualListCopy = new ArrayList<>((Collection<?>) getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                actualListCopy.remove(idx);
            } else {
                List<?> expectedList = Arrays.asList(expected);
                throw createAssertionError(FailMessages.getCollectionContainsAllInAnyOrder(actualAsString(), asString(expectedList)));
            }
        }
    }

    /**
     * Check if the actual collection contains the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Object... expected) {
        List<?> actualListCopy = new ArrayList<>((Collection<?>) getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx == 0) {
                actualListCopy.remove(idx);
            } else {
                List<?> expectedList = Arrays.asList(expected);
                throw createAssertionError(FailMessages.getCollectionContainsExactly(actualAsString(), asString(expectedList)));
            }
        }
        if (!actualListCopy.isEmpty()) {
            List<?> expectedList = Arrays.asList(expected);
            throw createAssertionError(FailMessages.getCollectionContainsExactly(actualAsString(), asString(expectedList)));
        }
    }

    /**
     * Check if the actual collection contains the expected values exactly in any order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInAnyOrder(final Object... expected) {
        List<?> actualListCopy = new ArrayList<>((Collection<?>) getActual());
        int elementCount = 0;
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                actualListCopy.remove(idx);
                elementCount++;
            }
        }
        if (!actualListCopy.isEmpty() || elementCount != expected.length) {
            List<?> expectedList = Arrays.asList(expected);
            throw createAssertionError(FailMessages.getCollectionContainsExactlyInAnyOrder(actualAsString(), asString(expectedList)));
        }
    }

    /**
     * Check if the actual collection contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Object... expected) {
        List<?> actualListCopy = new ArrayList<>((Collection<?>) getActual());
        boolean found = false;
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                found = true;
                break;
            }
        }
        if (!found) {
            List<?> expectedList = Arrays.asList(expected);
            throw createAssertionError(FailMessages.getCollectionContainsAny(actualAsString(), asString(expectedList)));
        }
    }

    /**
     * Check if the actual collection does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Object... expected) {
        List<?> actualListCopy = new ArrayList<>((Collection<?>) getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                List<?> expectedList = Arrays.asList(expected);
                throw createAssertionError(FailMessages.getCollectionContainsNone(actualAsString(), asString(expectedList)));
            }
        }
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
        if (value == null) {
            return null;
        } else {
            return String.valueOf(value);
        }
    }

}
