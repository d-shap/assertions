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
package ru.d_shap.assertions.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import ru.d_shap.assertions.FailDescription;
import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.ValueConverter;
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
     * @param actual          the actual value.
     * @param failDescription the fail description.
     */
    public CollectionAssertion(final Collection<?> actual, final FailDescription failDescription) {
        super(actual, failDescription);
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkActualIsNotNull();
        if (!((Collection) getActual()).isEmpty()) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_EMPTY);
        }
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        if (getActual() != null && !((Collection) getActual()).isEmpty()) {
            throw createAssertionErrorWithActual(Messages.Fail.IS_NULL_OR_EMPTY);
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkActualIsNotNull();
        if (((Collection) getActual()).isEmpty()) {
            throw createAssertionError(Messages.Fail.IS_NOT_EMPTY);
        }
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final Object expected) {
        checkActualIsNotNull();
        if (!((Collection) getActual()).contains(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.CONTAINS, expected);
        }
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final Object expected) {
        checkActualIsNotNull();
        if (((Collection) getActual()).contains(expected)) {
            throw createAssertionErrorWithActual(Messages.Fail.DOES_NOT_CONTAIN, expected);
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
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        List<?> actualListCopy = new ArrayList<>((Collection<?>) getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                actualListCopy.remove(idx);
            } else {
                List<?> expectedList = Arrays.asList(expected);
                throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_ALL, expectedList);
            }
        }
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Iterable<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        containsAll(ValueConverter.toObjectArray(expected));
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Object... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        List<?> actualListCopy = new ArrayList<>((Collection<?>) getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                actualListCopy = actualListCopy.subList(idx + 1, actualListCopy.size());
            } else {
                List<?> expectedList = Arrays.asList(expected);
                throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_ALL_IN_ORDER, expectedList);
            }
        }
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Iterable<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        containsAllInOrder(ValueConverter.toObjectArray(expected));
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Object... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
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
            throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_EXACTLY, expectedList);
        }
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Iterable<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        containsExactly(ValueConverter.toObjectArray(expected));
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Object... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        List<?> actualListCopy = new ArrayList<>((Collection<?>) getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx == 0) {
                actualListCopy.remove(idx);
            } else {
                List<?> expectedList = Arrays.asList(expected);
                throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_EXACTLY_IN_ORDER, expectedList);
            }
        }
        if (!actualListCopy.isEmpty()) {
            List<?> expectedList = Arrays.asList(expected);
            throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_EXACTLY_IN_ORDER, expectedList);
        }
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Iterable<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        containsExactlyInOrder(ValueConverter.toObjectArray(expected));
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Object... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyFalse(expected.length == 0);
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
            throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_ANY, expectedList);
        }
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Iterable<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        containsAny(ValueConverter.toObjectArray(expected));
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Object... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        checkArgumentIsNotEmptyTrue(expected.length == 0);
        List<?> actualListCopy = new ArrayList<>((Collection<?>) getActual());
        for (Object expectedItem : expected) {
            int idx = actualListCopy.indexOf(expectedItem);
            if (idx >= 0) {
                List<?> expectedList = Arrays.asList(expected);
                throw createAssertionErrorWithActual(Messages.Fail.CONTAINS_NONE, expectedList);
            }
        }
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Iterable<?> expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        containsNone(ValueConverter.toObjectArray(expected));
    }

    /**
     * Make assertion about the actual value size.
     *
     * @return the assertion.
     */
    public final IntAssertion toSize() {
        checkActualIsNotNull();
        return new IntAssertion(((Collection) getActual()).size(), getFailDescription(Messages.Check.ACTUAL_VALUE_SIZE));
    }

    /**
     * Check if the actual value size is equal to the expected size.
     *
     * @param expected the expected size.
     */
    public final void hasSize(final int expected) {
        toSize().isEqualTo(expected);
    }

    @Override
    protected final String asString(final Object value) {
        return value.toString();
    }

}
