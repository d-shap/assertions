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
package ru.d_shap.assertions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.d_shap.assertions.FailMessages;
import ru.d_shap.assertions.ReferenceAssertion;
import ru.d_shap.assertions.primitive.BooleanAssertion;
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the boolean array.
 *
 * @author Dmitry Shapovalov
 */
public class BooleanArrayAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual boolean array.
     * @param message the assertion message.
     */
    public BooleanArrayAssertion(final boolean[] actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual array is empty.
     */
    public final void isEmpty() {
        if (getActual() != null && ((boolean[]) getActual()).length > 0) {
            throw createAssertionError(FailMessages.getArrayEmpty(arrayToString((boolean[]) getActual())));
        }
    }

    /**
     * Check if the actual array is null or empty.
     */
    public final void isNullOrEmpty() {
        isNull();
        isEmpty();
    }

    /**
     * Check if the actual array is NOT empty.
     */
    public final void isNotEmpty() {
        if (getActual() == null || ((boolean[]) getActual()).length == 0) {
            throw createAssertionError(FailMessages.getArrayNotEmpty());
        }
    }

    /**
     * Check if the actual array is equal to the expected array.
     *
     * @param expected the expected array.
     */
    public final void isEqualTo(final boolean[] expected) {
        if (!Arrays.equals((boolean[]) getActual(), expected)) {
            throw createAssertionError(FailMessages.getSame(arrayToString((boolean[]) getActual()), arrayToString(expected)));
        }
    }

    /**
     * Check if the actual array is NOT equal to the expected array.
     *
     * @param expected the expected array.
     */
    public final void isNotEqualTo(final boolean[] expected) {
        if (Arrays.equals((boolean[]) getActual(), expected)) {
            throw createAssertionError(FailMessages.getDifferent(arrayToString((boolean[]) getActual())));
        }
    }

    /**
     * Make assertion about the actual array length.
     *
     * @return the assertion.
     */
    public final IntAssertion toLength() {
        return new IntAssertion(((boolean[]) getActual()).length, getMessage());
    }

    /**
     * Check if the actual array length is equal to the expected array length.
     *
     * @param expected the expected array length.
     */
    public final void hasLength(final int expected) {
        toLength().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual array item.
     *
     * @param index item index.
     * @return the assertion.
     */
    public final BooleanAssertion toItem(final int index) {
        return new BooleanAssertion(((boolean[]) getActual())[index], getMessage());
    }

    private String arrayToString(final boolean[] elements) {
        if (elements == null) {
            return null;
        } else {
            List<Boolean> list = new ArrayList<>(elements.length);
            for (boolean element : elements) {
                list.add(element);
            }
            return list.toString();
        }
    }

}
