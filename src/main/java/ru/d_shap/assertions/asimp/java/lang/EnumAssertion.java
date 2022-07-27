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
package ru.d_shap.assertions.asimp.java.lang;

import java.lang.reflect.Method;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;
import ru.d_shap.assertions.util.ReflectionHelper;

/**
 * Assertions for the enum.
 *
 * @author Dmitry Shapovalov
 */
public final class EnumAssertion extends ReferenceAssertion<EnumAssertion, Class<?>> {

    private static final String VALUES_METHOD_NAME = "values";

    private static final String VALUE_OF_METHOD_NAME = "valueOf";

    /**
     * Create new object.
     */
    public EnumAssertion() {
        super();
        addActualValueValidator(new EnumActualValueValidator());
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Class<Class<?>> getActualValueClass() {
        return (Class<Class<?>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return Class.class;
    }

    /**
     * Make assertion about the actual enum value count.
     * Side-effect: invokes the methods "values" and "valueOf" for the code coverage.
     *
     * @return the assertion.
     */
    public IntAssertion toValueCount() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getValueCount(), Messages.Check.VALUE_COUNT);
    }

    /**
     * Make assertion about the actual enum value count.
     * Side-effect: invokes the methods "values" and "valueOf" for the code coverage.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public EnumAssertion toValueCount(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getValueCount(), matcher, Messages.Check.VALUE_COUNT);
        return this;
    }

    private int getValueCount() {
        Method valuesMethod = ReflectionHelper.getMethod(getActual(), VALUES_METHOD_NAME);
        Object[] values = (Object[]) ReflectionHelper.callMethod(valuesMethod, (Object) null);

        Method valueOfMethod = ReflectionHelper.getMethod(getActual(), VALUE_OF_METHOD_NAME, String.class);
        for (Object value : values) {
            String valueName = value.toString();
            ReflectionHelper.callMethod(valueOfMethod, getActual(), valueName);
        }

        return values.length;
    }

    /**
     * Check if the actual enum value count is equal to the expected value count.
     *
     * @param expected the expected value count.
     *
     * @return current object for the chain call.
     */
    public EnumAssertion hasValueCount(final int expected) {
        toValueCount().isEqualTo(expected);
        return this;
    }

}
