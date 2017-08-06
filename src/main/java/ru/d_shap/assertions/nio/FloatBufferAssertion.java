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
package ru.d_shap.assertions.nio;

import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.List;

import ru.d_shap.assertions.collection.CollectionAssertion;
import ru.d_shap.assertions.collection.ListAssertion;

/**
 * Assertions for the float buffer.
 *
 * @author Dmitry Shapovalov
 */
public class FloatBufferAssertion extends BufferAssertion<Float> {

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    public FloatBufferAssertion(final FloatBuffer actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void contains(final float expected) {
        doContains(expected);
    }

    /**
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotContain(final float expected) {
        doDoesNotContain(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final float... expected) {
        checkArgumentIsNotNull(expected);
        doContainsAll(createArgumentArray(expected));
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final Iterable<Float> expected) {
        doContainsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final float... expected) {
        checkArgumentIsNotNull(expected);
        doContainsAllInOrder(createArgumentArray(expected));
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final Iterable<Float> expected) {
        doContainsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final float... expected) {
        checkArgumentIsNotNull(expected);
        doContainsExactly(createArgumentArray(expected));
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final Iterable<Float> expected) {
        doContainsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final float... expected) {
        checkArgumentIsNotNull(expected);
        doContainsExactlyInOrder(createArgumentArray(expected));
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final Iterable<Float> expected) {
        doContainsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final float... expected) {
        checkArgumentIsNotNull(expected);
        doContainsAny(createArgumentArray(expected));
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final Iterable<Float> expected) {
        doContainsAny(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final float... expected) {
        checkArgumentIsNotNull(expected);
        doContainsNone(createArgumentArray(expected));
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Iterable<Float> expected) {
        doContainsNone(expected);
    }

    @Override
    final CollectionAssertion createCollectionAssertion() {
        FloatBuffer buffer = (FloatBuffer) getActual();
        int position = buffer.position();
        List<Float> result = new LinkedList<>();
        while (buffer.hasRemaining()) {
            float value = buffer.get();
            result.add(value);
        }
        buffer.position(position);
        return new ListAssertion(result, getMessage());
    }

    private Float[] createArgumentArray(final float... array) {
        Float[] result = new Float[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

}
