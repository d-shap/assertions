///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
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
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    public CollectionAssertion(final Collection<?> actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkActualIsNotNull();
        if (!((Collection) getActual()).isEmpty()) {
            throw createAssertionError(FailMessages.getIsEmpty(actualAsString()));
        }
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        if (getActual() != null && !((Collection) getActual()).isEmpty()) {
            throw createAssertionError(FailMessages.getIsNullOrEmpty(actualAsString()));
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkActualIsNotNull();
        if (((Collection) getActual()).isEmpty()) {
            throw createAssertionError(FailMessages.getIsNotEmpty());
        }
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final Object expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (!((Collection) getActual()).contains(expected)) {
            throw createAssertionError(FailMessages.getContains(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final Object expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        if (((Collection) getActual()).contains(expected)) {
            throw createAssertionError(FailMessages.getDoesNotContain(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Object... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmpty(expected.length == 0);
        List<?> actualListCopy = new ArrayList<>((Collection<?>) getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                actualListCopy.remove(idx);
            } else {
                List<?> expectedList = Arrays.asList(expected);
                throw createAssertionError(FailMessages.getContainsAll(actualAsString(), asString(expectedList)));
            }
        }
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Iterable<?> expected) {
        checkArgumentIsNotNull(expected);
        containsAll(iterableToArray(expected));
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Object... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmpty(expected.length == 0);
        List<?> actualListCopy = new ArrayList<>((Collection<?>) getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                actualListCopy = actualListCopy.subList(idx + 1, actualListCopy.size());
            } else {
                List<?> expectedList = Arrays.asList(expected);
                throw createAssertionError(FailMessages.getContainsAllInOrder(actualAsString(), asString(expectedList)));
            }
        }
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Iterable<?> expected) {
        checkArgumentIsNotNull(expected);
        containsAllInOrder(iterableToArray(expected));
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Object... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmpty(expected.length == 0);
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
            throw createAssertionError(FailMessages.getContainsExactly(actualAsString(), asString(expectedList)));
        }
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Iterable<?> expected) {
        checkArgumentIsNotNull(expected);
        containsExactly(iterableToArray(expected));
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Object... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmpty(expected.length == 0);
        List<?> actualListCopy = new ArrayList<>((Collection<?>) getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx == 0) {
                actualListCopy.remove(idx);
            } else {
                List<?> expectedList = Arrays.asList(expected);
                throw createAssertionError(FailMessages.getContainsExactlyInOrder(actualAsString(), asString(expectedList)));
            }
        }
        if (!actualListCopy.isEmpty()) {
            List<?> expectedList = Arrays.asList(expected);
            throw createAssertionError(FailMessages.getContainsExactlyInOrder(actualAsString(), asString(expectedList)));
        }
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Iterable<?> expected) {
        checkArgumentIsNotNull(expected);
        containsExactlyInOrder(iterableToArray(expected));
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Object... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmpty(expected.length == 0);
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
            throw createAssertionError(FailMessages.getContainsAny(actualAsString(), asString(expectedList)));
        }
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Iterable<?> expected) {
        checkArgumentIsNotNull(expected);
        containsAny(iterableToArray(expected));
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Object... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmpty(expected.length == 0);
        List<?> actualListCopy = new ArrayList<>((Collection<?>) getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                List<?> expectedList = Arrays.asList(expected);
                throw createAssertionError(FailMessages.getContainsNone(actualAsString(), asString(expectedList)));
            }
        }
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Iterable<?> expected) {
        checkArgumentIsNotNull(expected);
        containsNone(iterableToArray(expected));
    }

    private Object[] iterableToArray(final Iterable<?> expected) {
        List<Object> result = new ArrayList<>();
        for (Object value : expected) {
            result.add(value);
        }
        return result.toArray(new Object[result.size()]);
    }

    /**
     * Make assertion about the actual collection size.
     *
     * @return the assertion.
     */
    public final IntAssertion toSize() {
        checkActualIsNotNull();
        return new IntAssertion(((Collection) getActual()).size(), getMessage());
    }

    /**
     * Check if the actual value size is equal to the expected collection size.
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
