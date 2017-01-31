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
package ru.d_shap.assertions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.d_shap.assertions.FailMessages;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;
import ru.d_shap.assertions.primitive.LongAssertion;

/**
 * Assertions for the long array.
 *
 * @author Dmitry Shapovalov
 */
public class LongArrayAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    public LongArrayAssertion(final long[] actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual value is empty.
     */
    public final void isEmpty() {
        if (getActual() != null && ((long[]) getActual()).length > 0) {
            throw createAssertionError(FailMessages.getIsEmpty(actualAsString()));
        }
    }

    /**
     * Check if the actual value is NOT empty.
     */
    public final void isNotEmpty() {
        if (getActual() == null || ((long[]) getActual()).length == 0) {
            throw createAssertionError(FailMessages.getIsNotEmpty());
        }
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final long... expected) {
        checkArgumentIsNotNull(expected);
        if (!Arrays.equals((long[]) getActual(), expected)) {
            throw createAssertionError(FailMessages.getIsSame(actualAsString(), asString(expected)));
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final long... expected) {
        checkArgumentIsNotNull(expected);
        if (Arrays.equals((long[]) getActual(), expected)) {
            throw createAssertionError(FailMessages.getIsDifferent(actualAsString()));
        }
    }

    /**
     * Make assertion about the actual value length.
     *
     * @return the assertion.
     */
    public final IntAssertion toLength() {
        return new IntAssertion(((long[]) getActual()).length, getMessage());
    }

    /**
     * Check if the actual value length is equal to the expected length.
     *
     * @param expected the expected length.
     */
    public final void hasLength(final int expected) {
        toLength().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value item.
     *
     * @param index item index.
     * @return the assertion.
     */
    public final LongAssertion toItem(final int index) {
        return new LongAssertion(((long[]) getActual())[index], getMessage());
    }

    @Override
    protected final String asString(final Object value) {
        if (value == null) {
            return null;
        } else {
            if (value instanceof long[]) {
                List<Long> list = new ArrayList<>(((long[]) value).length);
                for (long item : (long[]) value) {
                    list.add(item);
                }
                return list.toString();
            } else {
                return String.valueOf(value);
            }
        }
    }

}
