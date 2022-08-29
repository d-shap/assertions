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
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.FloatBuffer;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.array.FloatArrayAssertion;
import ru.d_shap.assertions.asimp.primitive.FloatAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the float buffer.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatBufferAssertion extends ReferenceAssertion<FloatBufferAssertion, FloatBuffer> {

    /**
     * Create new object.
     */
    public FloatBufferAssertion() {
        super();
    }

    @Override
    protected Class<FloatBuffer> getActualValueClass() {
        return FloatBuffer.class;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion isEmpty() {
        createFloatArrayAssertion(false).isEmpty();
        return this;
    }

    /**
     * Check if the actual value is empty.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion isRewindAndEmpty() {
        createFloatArrayAssertion(true).isEmpty();
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion isNullOrEmpty() {
        createFloatArrayAssertion(false).isNullOrEmpty();
        return this;
    }

    /**
     * Check if the actual value is null or empty.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion isRewindAndNullOrEmpty() {
        createFloatArrayAssertion(true).isNullOrEmpty();
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion isNotEmpty() {
        createFloatArrayAssertion(false).isNotEmpty();
        return this;
    }

    /**
     * Check if the actual value is NOT empty.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion isRewindAndNotEmpty() {
        createFloatArrayAssertion(true).isNotEmpty();
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion contains(final float expected) {
        createFloatArrayAssertion(false).contains(expected);
        return this;
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion rewindAndContains(final float expected) {
        createFloatArrayAssertion(true).contains(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion doesNotContain(final float expected) {
        createFloatArrayAssertion(false).doesNotContain(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion rewindAndDoesNotContain(final float expected) {
        createFloatArrayAssertion(true).doesNotContain(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion containsAll(final float... expected) {
        createFloatArrayAssertion(false).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion containsAll(final Iterable<Float> expected) {
        createFloatArrayAssertion(false).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion rewindAndContainsAll(final float... expected) {
        createFloatArrayAssertion(true).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion rewindAndContainsAll(final Iterable<Float> expected) {
        createFloatArrayAssertion(true).containsAll(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion containsAllInOrder(final float... expected) {
        createFloatArrayAssertion(false).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion containsAllInOrder(final Iterable<Float> expected) {
        createFloatArrayAssertion(false).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion rewindAndContainsAllInOrder(final float... expected) {
        createFloatArrayAssertion(true).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion rewindAndContainsAllInOrder(final Iterable<Float> expected) {
        createFloatArrayAssertion(true).containsAllInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion containsExactly(final float... expected) {
        createFloatArrayAssertion(false).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion containsExactly(final Iterable<Float> expected) {
        createFloatArrayAssertion(false).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion rewindAndContainsExactly(final float... expected) {
        createFloatArrayAssertion(true).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion rewindAndContainsExactly(final Iterable<Float> expected) {
        createFloatArrayAssertion(true).containsExactly(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion containsExactlyInOrder(final float... expected) {
        createFloatArrayAssertion(false).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion containsExactlyInOrder(final Iterable<Float> expected) {
        createFloatArrayAssertion(false).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion rewindAndContainsExactlyInOrder(final float... expected) {
        createFloatArrayAssertion(true).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion rewindAndContainsExactlyInOrder(final Iterable<Float> expected) {
        createFloatArrayAssertion(true).containsExactlyInOrder(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion containsAny(final float... expected) {
        createFloatArrayAssertion(false).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion containsAny(final Iterable<Float> expected) {
        createFloatArrayAssertion(false).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion rewindAndContainsAny(final float... expected) {
        createFloatArrayAssertion(true).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion rewindAndContainsAny(final Iterable<Float> expected) {
        createFloatArrayAssertion(true).containsAny(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion containsNone(final float... expected) {
        createFloatArrayAssertion(false).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion containsNone(final Iterable<Float> expected) {
        createFloatArrayAssertion(false).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion rewindAndContainsNone(final float... expected) {
        createFloatArrayAssertion(true).containsNone(expected);
        return this;
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion rewindAndContainsNone(final Iterable<Float> expected) {
        createFloatArrayAssertion(true).containsNone(expected);
        return this;
    }

    private FloatArrayAssertion createFloatArrayAssertion(final boolean rewind) {
        float[] floats = convertValue(getActual(), null, float[].class, rewind);
        return initializeAssertion(Raw.floatArrayAssertion(), floats);
    }

    /**
     * Make assertion about the actual value's position.
     *
     * @return the assertion.
     */
    public IntAssertion toPosition() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().position(), Messages.Check.POSITION);
    }

    /**
     * Make assertion about the actual value's position.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion toPosition(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().position(), matcher, Messages.Check.POSITION);
        return this;
    }

    /**
     * Check if the actual value's position is equal to the expected position.
     *
     * @param expected the expected position.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion hasPosition(final int expected) {
        toPosition().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's limit.
     *
     * @return the assertion.
     */
    public IntAssertion toLimit() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().limit(), Messages.Check.LIMIT);
    }

    /**
     * Make assertion about the actual value's limit.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion toLimit(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().limit(), matcher, Messages.Check.LIMIT);
        return this;
    }

    /**
     * Check if the actual value's limit is equal to the expected limit.
     *
     * @param expected the expected limit.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion hasLimit(final int expected) {
        toLimit().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's capacity.
     *
     * @return the assertion.
     */
    public IntAssertion toCapacity() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().capacity(), Messages.Check.CAPACITY);
    }

    /**
     * Make assertion about the actual value's capacity.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion toCapacity(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().capacity(), matcher, Messages.Check.CAPACITY);
        return this;
    }

    /**
     * Check if the actual value's capacity is equal to the expected capacity.
     *
     * @param expected the expected capacity.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion hasCapacity(final int expected) {
        toCapacity().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedPosition the expected position.
     * @param expectedLimit    the expected limit.
     * @param expectedCapacity the expected capacity.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion hasProperties(final int expectedPosition, final int expectedLimit, final int expectedCapacity) {
        hasPosition(expectedPosition);
        hasLimit(expectedLimit);
        hasCapacity(expectedCapacity);
        return this;
    }

    /**
     * Make assertion about the actual value's remaining.
     *
     * @return the assertion.
     */
    public IntAssertion toRemaining() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().remaining(), Messages.Check.REMAINING);
    }

    /**
     * Make assertion about the actual value's remaining.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion toRemaining(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().remaining(), matcher, Messages.Check.REMAINING);
        return this;
    }

    /**
     * Check if the actual value's remaining is equal to the expected remaining.
     *
     * @param expected the expected remaining.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion hasRemaining(final int expected) {
        toRemaining().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value is direct.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion isDirect() {
        checkActualIsNotNull();
        if (!getActual().isDirect()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIRECT).build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT direct.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion isNotDirect() {
        checkActualIsNotNull();
        if (getActual().isDirect()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_DIRECT).build();
        }
        return this;
    }

    /**
     * Check if the actual value is read only.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion isReadOnly() {
        checkActualIsNotNull();
        if (!getActual().isReadOnly()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_READ_ONLY).build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT read only.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion isNotReadOnly() {
        checkActualIsNotNull();
        if (getActual().isReadOnly()) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_READ_ONLY).build();
        }
        return this;
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @return the assertion.
     */
    public FloatAssertion toMin() {
        checkActualIsNotNull();
        Float minValue = getMinValue(false);
        return initializeAssertion(Raw.floatAssertion(), minValue, Messages.Check.MIN_VALUE);
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion toMin(final Matcher<? super Float> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Float minValue = getMinValue(false);
        matcherAssertion(minValue, matcher, Messages.Check.MIN_VALUE);
        return this;
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @return the assertion.
     */
    public FloatAssertion toRewindAndMin() {
        checkActualIsNotNull();
        Float minValue = getMinValue(true);
        return initializeAssertion(Raw.floatAssertion(), minValue, Messages.Check.MIN_VALUE);
    }

    /**
     * Make assertion about the actual value's minimum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion toRewindAndMin(final Matcher<? super Float> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Float minValue = getMinValue(true);
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
    public FloatBufferAssertion hasMin(final float expected) {
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
    public FloatBufferAssertion hasMin(final Float expected) {
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
    public FloatBufferAssertion hasMin(final float expected, final float delta) {
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
    public FloatBufferAssertion hasMin(final Float expected, final float delta) {
        toMin().isEqualTo(expected, delta);
        return this;
    }

    /**
     * Check if the actual value's minimum value is equal to the expected minimum value.
     *
     * @param expected the expected minimum value.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion hasRewindAndMin(final float expected) {
        toRewindAndMin().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's minimum value is equal to the expected minimum value.
     *
     * @param expected the expected minimum value.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion hasRewindAndMin(final Float expected) {
        toRewindAndMin().isEqualTo(expected);
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
    public FloatBufferAssertion hasRewindAndMin(final float expected, final float delta) {
        toRewindAndMin().isEqualTo(expected, delta);
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
    public FloatBufferAssertion hasRewindAndMin(final Float expected, final float delta) {
        toRewindAndMin().isEqualTo(expected, delta);
        return this;
    }

    private Float getMinValue(final boolean rewind) {
        float[] actual = convertValue(getActual(), null, float[].class, rewind);
        if (actual.length == 0) {
            return null;
        }
        float result = actual[0];
        for (float value : actual) {
            result = Math.min(result, value);
        }
        return result;
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @return the assertion.
     */
    public FloatAssertion toMax() {
        checkActualIsNotNull();
        Float maxValue = getMaxValue(false);
        return initializeAssertion(Raw.floatAssertion(), maxValue, Messages.Check.MAX_VALUE);
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion toMax(final Matcher<? super Float> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Float maxValue = getMaxValue(false);
        matcherAssertion(maxValue, matcher, Messages.Check.MAX_VALUE);
        return this;
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @return the assertion.
     */
    public FloatAssertion toRewindAndMax() {
        checkActualIsNotNull();
        Float maxValue = getMaxValue(true);
        return initializeAssertion(Raw.floatAssertion(), maxValue, Messages.Check.MAX_VALUE);
    }

    /**
     * Make assertion about the actual value's maximum value.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion toRewindAndMax(final Matcher<? super Float> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        Float maxValue = getMaxValue(true);
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
    public FloatBufferAssertion hasMax(final float expected) {
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
    public FloatBufferAssertion hasMax(final Float expected) {
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
    public FloatBufferAssertion hasMax(final float expected, final float delta) {
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
    public FloatBufferAssertion hasMax(final Float expected, final float delta) {
        toMax().isEqualTo(expected, delta);
        return this;
    }

    /**
     * Check if the actual value's maximum value is equal to the expected maximum value.
     *
     * @param expected the expected maximum value.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion hasRewindAndMax(final float expected) {
        toRewindAndMax().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's maximum value is equal to the expected maximum value.
     *
     * @param expected the expected maximum value.
     *
     * @return current object for the chain call.
     */
    public FloatBufferAssertion hasRewindAndMax(final Float expected) {
        toRewindAndMax().isEqualTo(expected);
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
    public FloatBufferAssertion hasRewindAndMax(final float expected, final float delta) {
        toRewindAndMax().isEqualTo(expected, delta);
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
    public FloatBufferAssertion hasRewindAndMax(final Float expected, final float delta) {
        toRewindAndMax().isEqualTo(expected, delta);
        return this;
    }

    private Float getMaxValue(final boolean rewind) {
        float[] actual = convertValue(getActual(), null, float[].class, rewind);
        if (actual.length == 0) {
            return null;
        }
        float result = actual[0];
        for (float value : actual) {
            result = Math.max(result, value);
        }
        return result;
    }

}
