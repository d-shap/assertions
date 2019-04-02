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
package ru.d_shap.assertions.converter;

/**
 * Service provider interface for the value to the value with the target class converter.
 *
 * @author Dmitry Shapovalov
 */
public interface ValueConverterProvider {

    /**
     * Get the value class.
     *
     * @return the value class.
     */
    Class<?> getValueClass();

    /**
     * Get the target class.
     *
     * @return the target class.
     */
    Class<?> getTargetClass();

    /**
     * Get the value converted to the target class (or the same value if conversion cannot be performed).
     *
     * @param value     the value.
     * @param arguments the conversion arguments.
     *
     * @return the value converted to the target class (or the same value if conversion cannot be performed).
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    Object convert(Object value, Object... arguments) throws ConversionException;

}
