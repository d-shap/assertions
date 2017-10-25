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

import ru.d_shap.assertions.FailDescription;
import ru.d_shap.assertions.ValueConverter;

/**
 * Assertions for the float buffer.
 *
 * @author Dmitry Shapovalov
 */
public class FloatBufferAssertion extends BufferAssertion<Float> {

    /**
     * Create new object.
     *
     * @param actual          the actual value.
     * @param failDescription the fail description.
     */
    public FloatBufferAssertion(final FloatBuffer actual, final FailDescription failDescription) {
        super(actual, failDescription);
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
     * Check if the actual value contains the expected value.
     *
     * @param expected the expected value.
     */
    public final void rewindAndContains(final float expected) {
        doRewindAndContains(expected);
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
     * Check if the actual value does NOT contain the expected value.
     *
     * @param expected the expected value.
     */
    public final void rewindAndDoesNotContain(final float expected) {
        doRewindAndDoesNotContain(expected);
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAll(final float... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        doContainsAll(ValueConverter.toFloatObjectArray(expected));
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
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAll(final float... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        doRewindAndContainsAll(ValueConverter.toFloatObjectArray(expected));
    }

    /**
     * Check if the actual value contains all of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAll(final Iterable<Float> expected) {
        doRewindAndContainsAll(expected);
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsAllInOrder(final float... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        doContainsAllInOrder(ValueConverter.toFloatObjectArray(expected));
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
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAllInOrder(final float... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        doRewindAndContainsAllInOrder(ValueConverter.toFloatObjectArray(expected));
    }

    /**
     * Check if the actual value contains all of the expected values in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAllInOrder(final Iterable<Float> expected) {
        doRewindAndContainsAllInOrder(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void containsExactly(final float... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        doContainsExactly(ValueConverter.toFloatObjectArray(expected));
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
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactly(final float... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        doRewindAndContainsExactly(ValueConverter.toFloatObjectArray(expected));
    }

    /**
     * Check if the actual value contains all of the expected values exactly.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactly(final Iterable<Float> expected) {
        doRewindAndContainsExactly(expected);
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void containsExactlyInOrder(final float... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        doContainsExactlyInOrder(ValueConverter.toFloatObjectArray(expected));
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
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactlyInOrder(final float... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        doRewindAndContainsExactlyInOrder(ValueConverter.toFloatObjectArray(expected));
    }

    /**
     * Check if the actual value contains all of the expected values exactly in the specified order.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsExactlyInOrder(final Iterable<Float> expected) {
        doRewindAndContainsExactlyInOrder(expected);
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsAny(final float... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        doContainsAny(ValueConverter.toFloatObjectArray(expected));
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
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAny(final float... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        doRewindAndContainsAny(ValueConverter.toFloatObjectArray(expected));
    }

    /**
     * Check if the actual value contains any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsAny(final Iterable<Float> expected) {
        doRewindAndContainsAny(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final float... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        doContainsNone(ValueConverter.toFloatObjectArray(expected));
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void containsNone(final Iterable<Float> expected) {
        doContainsNone(expected);
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsNone(final float... expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected);
        doRewindAndContainsNone(ValueConverter.toFloatObjectArray(expected));
    }

    /**
     * Check if the actual value does NOT contain any of the expected values.
     *
     * @param expected the expected values.
     */
    public final void rewindAndContainsNone(final Iterable<Float> expected) {
        doRewindAndContainsNone(expected);
    }

    @Override
    final List<Float> createList(final Object value, final boolean rewind) {
        FloatBuffer buffer = (FloatBuffer) getActual();
        int position = buffer.position();
        if (rewind) {
            buffer.rewind();
        }
        List<Float> result = new LinkedList<>();
        while (buffer.hasRemaining()) {
            float bufferValue = buffer.get();
            result.add(bufferValue);
        }
        buffer.position(position);
        return result;
    }

    @Override
    protected final String asString(final Object value, final boolean actual) {
        if (value == null) {
            return null;
        } else if (value instanceof FloatBuffer) {
            return createList(value, false).toString();
        } else {
            return value.toString();
        }
    }

}
