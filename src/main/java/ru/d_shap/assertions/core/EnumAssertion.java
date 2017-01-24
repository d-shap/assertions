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
package ru.d_shap.assertions.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ru.d_shap.assertions.primitive.IntAssertion;

/**
 * Assertions for the enum.
 *
 * @author Dmitry Shapovalov
 */
public class EnumAssertion extends ClassAssertion {

    private static final String VALUES_METHOD_NAME = "values";

    private static final String VALUE_OF_METHOD_NAME = "valueOf";

    private final String _valuesMethodName;

    private final String _valueOfMethodName;

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the assertion message.
     */
    public EnumAssertion(final Class<?> actual, final String message) {
        this(actual, message, VALUES_METHOD_NAME, VALUE_OF_METHOD_NAME);
    }

    EnumAssertion(final Class<?> actual, final String message, final String valuesMethodName, final String valueOfMethodName) {
        super(actual, message);
        _valuesMethodName = valuesMethodName;
        _valueOfMethodName = valueOfMethodName;
    }

    /**
     * Make assertion about the actual enum value count.
     *
     * @return the assertion.
     */
    public final IntAssertion toValueCount() {
        return new IntAssertion(getValueCount(), getMessage());
    }

    private int getValueCount() {
        try {
            Class<?> actualClass = (Class<?>) getActual();

            Method valuesMethod = actualClass.getDeclaredMethod(_valuesMethodName);
            Object[] values = (Object[]) valuesMethod.invoke(actualClass);

            Method valueOfMethod = actualClass.getDeclaredMethod(_valueOfMethodName, String.class);
            for (Object value : values) {
                String valueName = value.toString();
                valueOfMethod.invoke(actualClass, valueName);
            }

            return values.length;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            throw createAssertionError(ex);
        }
    }

    /**
     * Check if the actual enum value count is equal to the expected value count.
     *
     * @param expected the expected value count.
     */
    public final void hasValueCount(final int expected) {
        toValueCount().isEqualTo(expected);
    }

}
