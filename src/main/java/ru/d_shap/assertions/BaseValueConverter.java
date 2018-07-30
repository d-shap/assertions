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
package ru.d_shap.assertions;

/**
 * Base class for all value converters.
 *
 * @author Dmitry Shapovalov
 */
public abstract class BaseValueConverter {

    /**
     * Create new object.
     */
    protected BaseValueConverter() {
        super();
    }

    /**
     * Get the value class.
     *
     * @return the value class.
     */
    protected abstract Class<?> getValueClass();

    /**
     * Get the target class.
     *
     * @return the target class.
     */
    protected abstract Class<?> getTargetClass();

    /**
     * Check if the value can be converted to the target class.
     *
     * @param value     the value.
     * @param arguments the conversion arguments.
     * @return true if the value can be converted to the target class.
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    protected abstract boolean canConvert(Object value, Object... arguments) throws ConvertionException;

    /**
     * Get the value converted to the target class.
     *
     * @param value     the value.
     * @param arguments the conversion arguments.
     * @return the value converted to the target class.
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    protected abstract Object convert(Object value, Object... arguments) throws ConvertionException;

    /**
     * Check the value class.
     *
     * @param value the value.
     */
    protected final void checkValueClass(final Object value) {
        value.getClass();
        getValueClass().cast(value);
    }

    /**
     * Get the value converted to the target class.
     *
     * @param value       the value.
     * @param targetClass the target class.
     * @param arguments   the conversion arguments.
     * @param <V>         the generic type of the value converted to the target class.
     * @return the value converted to the target class.
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    protected final <V> V convertValue(final Object value, final Class<?> targetClass, final Object... arguments) throws ConvertionException {
        return ValueConverter.convert(value, targetClass, arguments);
    }

}
