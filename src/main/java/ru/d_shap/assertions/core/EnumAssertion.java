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
package ru.d_shap.assertions.core;

import java.lang.reflect.Method;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
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
     */
    public EnumAssertion() {
        this(VALUES_METHOD_NAME, VALUE_OF_METHOD_NAME);
    }

    EnumAssertion(final String valuesMethodName, final String valueOfMethodName) {
        super();
        addActualValueValidator(new EnumActualValueValidator());
        _valuesMethodName = valuesMethodName;
        _valueOfMethodName = valueOfMethodName;
    }

    /**
     * Make assertion about the actual enum value count.
     * Side-effect: invokes the methods "values" and "valueOf" for the code coverage.
     *
     * @return the assertion.
     */
    public final IntAssertion toValueCount() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getValueCount(), Messages.Check.VALUE_COUNT);
    }

    /**
     * Make assertion about the actual enum value count.
     * Side-effect: invokes the methods "values" and "valueOf" for the code coverage.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toValueCount(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher);
        matcherAssertion(getValueCount(), matcher, Messages.Check.VALUE_COUNT);
    }

    private int getValueCount() {
        try {
            Method valuesMethod = getActual().getDeclaredMethod(_valuesMethodName);
            Object[] values = (Object[]) valuesMethod.invoke(null);

            Method valueOfMethod = getActual().getDeclaredMethod(_valueOfMethodName, String.class);
            for (Object value : values) {
                String valueName = value.toString();
                valueOfMethod.invoke(null, valueName);
            }

            return values.length;
        } catch (ReflectiveOperationException ex) {
            throw getAssertionErrorBuilder().addThrowable(ex).build();
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
