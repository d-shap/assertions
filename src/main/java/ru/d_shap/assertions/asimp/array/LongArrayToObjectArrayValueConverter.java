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
package ru.d_shap.assertions.asimp.array;

import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ConverterArgumentHelper;
import ru.d_shap.assertions.converter.ValueConverterProvider;

/**
 * Value converter from the long array to the object array.
 *
 * @author Dmitry Shapovalov
 */
public final class LongArrayToObjectArrayValueConverter implements ValueConverterProvider {

    /**
     * Create new object.
     */
    public LongArrayToObjectArrayValueConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return long[].class;
    }

    @Override
    public Class<?> getTargetClass() {
        return Long[].class;
    }

    @Override
    public Object convert(final Object value, final Object... arguments) throws ConversionException {
        long[] castedValue = ConverterArgumentHelper.getValue(value, long[].class);
        ConverterArgumentHelper.checkArgumentsLength(arguments, 0);

        Long[] result = new Long[castedValue.length];
        for (int i = 0; i < castedValue.length; i++) {
            result[i] = castedValue[i];
        }
        return result;
    }

}
