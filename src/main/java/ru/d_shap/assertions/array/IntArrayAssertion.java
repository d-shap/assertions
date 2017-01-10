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
import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the int array.
 *
 * @author Dmitry Shapovalov
 */
public class IntArrayAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual int array.
     * @param message the assertion message.
     */
    public IntArrayAssertion(final int[] actual, final String message) {
        super(actual, message);
    }

    /**
     * Check if the actual array is empty.
     */
    public final void isEmpty() {
        if (getActual() != null && ((int[]) getActual()).length > 0) {
            throw createAssertionError(FailMessages.getArrayEmpty(arrayToString((int[]) getActual())));
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
        if (getActual() == null || ((int[]) getActual()).length == 0) {
            throw createAssertionError(FailMessages.getArrayNotEmpty());
        }
    }

    /**
     * Check if the actual array is equal to the expected array.
     *
     * @param expected the expected array.
     */
    public final void isEqualTo(final int[] expected) {
        if (!Arrays.equals((int[]) getActual(), expected)) {
            throw createAssertionError(FailMessages.getSame(arrayToString((int[]) getActual()), arrayToString(expected)));
        }
    }

    /**
     * Check if the actual array is NOT equal to the expected array.
     *
     * @param expected the expected array.
     */
    public final void isNotEqualTo(final int[] expected) {
        if (Arrays.equals((int[]) getActual(), expected)) {
            throw createAssertionError(FailMessages.getDifferent(arrayToString((int[]) getActual())));
        }
    }

    /**
     * Make assertion about the actual array length.
     *
     * @return assertion.
     */
    public final IntAssertion toLength() {
        return new IntAssertion(((int[]) getActual()).length, getMessage());
    }

    /**
     * Make assertion about the actual array item.
     *
     * @param index item index.
     * @return assertion.
     */
    public final IntAssertion toItem(final int index) {
        return new IntAssertion(((int[]) getActual())[index], getMessage());
    }

    private String arrayToString(final int[] elements) {
        if (elements == null) {
            return null;
        } else {
            List<Integer> list = new ArrayList<>(elements.length);
            for (int element : elements) {
                list.add(element);
            }
            return list.toString();
        }
    }

}
