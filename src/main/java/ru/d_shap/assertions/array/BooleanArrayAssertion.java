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
package ru.d_shap.assertions.array;

import java.util.List;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the boolean array.
 *
 * @author Dmitry Shapovalov
 */
public class BooleanArrayAssertion extends ReferenceAssertion<boolean[]> {

    /**
     * Create new object.
     */
    public BooleanArrayAssertion() {
        super();
    }

    @Override
    protected final Class<boolean[]> getActualValueClass() {
        return boolean[].class;
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual().length != 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_EMPTY).addActual().build();
        }
    }

    /**
     * Check if the actual value is null or empty.
     */
    public final void isNullOrEmpty() {
        checkInitialized();
        if (getActual() != null && getActual().length != 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_NULL_OR_EMPTY).addActual().build();
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        checkInitialized();
        checkActualIsNotNull();
        if (getActual().length == 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.ActualFail.IS_NOT_EMPTY).build();
        }
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final boolean expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().contains(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final boolean expected) {
        checkInitialized();
        checkActualIsNotNull();
        createListAssertion().doesNotContain(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final boolean... expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<Object> expectedList = convertValue(expected, List.class);
        createListAssertion().containsAll(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Iterable<Boolean> expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<Object> expectedList = convertValue(expected, List.class);
        createListAssertion().containsAll(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final boolean... expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<Object> expectedList = convertValue(expected, List.class);
        createListAssertion().containsAllInOrder(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Iterable<Boolean> expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<Object> expectedList = convertValue(expected, List.class);
        createListAssertion().containsAllInOrder(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final boolean... expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<Object> expectedList = convertValue(expected, List.class);
        createListAssertion().containsExactly(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Iterable<Boolean> expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<Object> expectedList = convertValue(expected, List.class);
        createListAssertion().containsExactly(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final boolean... expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<Object> expectedList = convertValue(expected, List.class);
        createListAssertion().containsExactlyInOrder(expectedList);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Iterable<Boolean> expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<Object> expectedList = convertValue(expected, List.class);
        createListAssertion().containsExactlyInOrder(expectedList);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final boolean... expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<Object> expectedList = convertValue(expected, List.class);
        createListAssertion().containsAny(expectedList);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Iterable<Boolean> expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<Object> expectedList = convertValue(expected, List.class);
        createListAssertion().containsAny(expectedList);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final boolean... expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<Object> expectedList = convertValue(expected, List.class);
        createListAssertion().containsNone(expectedList);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Iterable<Boolean> expected) {
        checkInitialized();
        checkActualIsNotNull();
        List<Object> expectedList = convertValue(expected, List.class);
        createListAssertion().containsNone(expectedList);
    }

    private ListAssertion<Object> createListAssertion() {
        List<Object> list = convertValue(getActual(), List.class);
        return initializeAssertion(Raw.listAssertion(), list);
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @return the assertion.
     */
    public final IntAssertion toLength() {
        checkInitialized();
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().length, Messages.Check.ACTUAL_VALUE_LENGTH);
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toLength(final Matcher<Integer> matcher) {
        checkInitialized();
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getActual().length, matcher, Messages.Check.ACTUAL_VALUE_LENGTH);
    }

    /**
     * Check if the actual value length is equal to the expected length.
     *
     * @param expected the expected length.
     */
    public final void hasLength(final int expected) {
        toLength().isEqualTo(expected);
    }

}
