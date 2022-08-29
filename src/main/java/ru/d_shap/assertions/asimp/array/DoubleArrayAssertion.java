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
package ru.d_shap.assertions.asimp.array;

import java.util.List;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.IterableAssertion;
import ru.d_shap.assertions.asimp.primitive.DoubleAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the double array.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleArrayAssertion extends ReferenceAssertion<DoubleArrayAssertion, double[]> {

    /**
     * Create new object.
     */
    public DoubleArrayAssertion() {
        super();
    }

    @Override
    protected Class<double[]> getActualValueClass() {
        return double[].class;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion isEmpty() {
        checkActualIsNotNull();
        if (getActual().length != 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_EMPTY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion isNullOrEmpty() {
        if (getActual() != null && getActual().length != 0) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NULL_OR_EMPTY).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion isNotEmpty() {
        checkActualIsNotNull();
        if (getActual().length == 0) {
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
    public DoubleArrayAssertion contains(final double expected) {
        createIterableAssertion().contains(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion doesNotContain(final double expected) {
        createIterableAssertion().doesNotContain(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion containsAll(final double... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAll(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion containsAll(final Iterable<Double> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAll(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion containsAllInOrder(final double... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAllInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion containsAllInOrder(final Iterable<Double> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAllInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion containsExactly(final double... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsExactly(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion containsExactly(final Iterable<Double> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsExactly(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion containsExactlyInOrder(final double... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsExactlyInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion containsExactlyInOrder(final Iterable<Double> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsExactlyInOrder(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion containsAny(final double... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAny(expectedList);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion containsAny(final Iterable<Double> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsAny(expectedList);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion containsNone(final double... expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsNone(expectedList);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion containsNone(final Iterable<Double> expected) {
        List<Object> expectedList = convertValue(expected, null, List.class);
        createIterableAssertion().containsNone(expectedList);
        return this;
    }

    private IterableAssertion<Object> createIterableAssertion() {
        List<Object> list = convertValue(getActual(), null, List.class);
        return initializeAssertion(Raw.iterableAssertion(), list);
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @return the assertion.
     */
    public IntAssertion toLength() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().length, Messages.Check.LENGTH);
    }

    /**
     * Make assertion about the actual value's length.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion toLength(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().length, matcher, Messages.Check.LENGTH);
        return this;
    }

    /**
     * Check if the actual value's length is equal to the expected length.
     *
     * @param expected the expected length.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion hasLength(final int expected) {
        toLength().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @return the assertion.
     */
    public DoubleAssertion toMin() {
        checkActualIsNotNull();
        Double minValue = getMinValue();
        return initializeAssertion(Raw.doubleAssertion(), minValue, Messages.Check.MIN_VALUE);
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion toMin(final Matcher<? super Double> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Double minValue = getMinValue();
        matcherAssertion(minValue, matcher, Messages.Check.MIN_VALUE);
        return this;
    }

    /**
     * Check if the actual value's minimum value is equal to the expected minimum value.
     *
     * @param expected the expected minimum value.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion hasMin(final double expected) {
        toMin().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's minimum value is equal to the expected minimum value.
     *
     * @param expected the expected minimum value.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion hasMin(final Double expected) {
        toMin().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's minimum value is equal to the expected minimum value.
     *
     * @param expected the expected minimum value.
     * @param delta    maximum delta between the actual value and the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion hasMin(final double expected, final double delta) {
        toMin().isEqualTo(expected, delta);
        return this;
    }

    /**
     * Check if the actual value's minimum value is equal to the expected minimum value.
     *
     * @param expected the expected minimum value.
     * @param delta    maximum delta between the actual value and the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion hasMin(final Double expected, final double delta) {
        toMin().isEqualTo(expected, delta);
        return this;
    }

    private Double getMinValue() {
        double[] actual = getActual();
        if (actual.length == 0) {
            return null;
        }
        double result = actual[0];
        for (double value : actual) {
            result = Math.min(result, value);
        }
        return result;
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @return the assertion.
     */
    public DoubleAssertion toMax() {
        checkActualIsNotNull();
        Double maxValue = getMaxValue();
        return initializeAssertion(Raw.doubleAssertion(), maxValue, Messages.Check.MAX_VALUE);
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion toMax(final Matcher<? super Double> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Double maxValue = getMaxValue();
        matcherAssertion(maxValue, matcher, Messages.Check.MAX_VALUE);
        return this;
    }

    /**
     * Check if the actual value's maximum value is equal to the expected maximum value.
     *
     * @param expected the expected maximum value.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion hasMax(final double expected) {
        toMax().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's maximum value is equal to the expected maximum value.
     *
     * @param expected the expected maximum value.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion hasMax(final Double expected) {
        toMax().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's maximum value is equal to the expected maximum value.
     *
     * @param expected the expected maximum value.
     * @param delta    maximum delta between the actual value and the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion hasMax(final double expected, final double delta) {
        toMax().isEqualTo(expected, delta);
        return this;
    }

    /**
     * Check if the actual value's maximum value is equal to the expected maximum value.
     *
     * @param expected the expected maximum value.
     * @param delta    maximum delta between the actual value and the expected value.
     *
     * @return current object for the chain call.
     */
    public DoubleArrayAssertion hasMax(final Double expected, final double delta) {
        toMax().isEqualTo(expected, delta);
        return this;
    }

    private Double getMaxValue() {
        double[] actual = getActual();
        if (actual.length == 0) {
            return null;
        }
        double result = actual[0];
        for (double value : actual) {
            result = Math.max(result, value);
        }
        return result;
    }

}
