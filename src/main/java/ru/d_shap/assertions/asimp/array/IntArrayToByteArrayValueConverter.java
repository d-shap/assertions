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
package ru.d_shap.assertions.asimp.array;

import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ConverterArgumentHelper;
import ru.d_shap.assertions.converter.ValueConverterProvider;

/**
 * Value converter from the int array to the byte array.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayToByteArrayValueConverter implements ValueConverterProvider {

    /**
     * Create new object.
     */
    public IntArrayToByteArrayValueConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return int[].class;
    }

    @Override
    public Class<?> getTargetClass() {
        return byte[].class;
    }

    @Override
    public Object convert(final Object value, final Object... arguments) throws ConversionException {
        ConverterArgumentHelper.checkValueClass(value, getValueClass());
        ConverterArgumentHelper.checkArgumentsLength(arguments, 0);

        if (canConvertToTargetClass(value)) {
            byte[] result = new byte[((int[]) value).length];
            for (int i = 0; i < ((int[]) value).length; i++) {
                result[i] = (byte) ((int[]) value)[i];
            }
            return result;
        } else {
            return value;
        }
    }

    private boolean canConvertToTargetClass(final Object value) throws ConversionException {
        for (int i = 0; i < ((int[]) value).length; i++) {
            int intValue = ((int[]) value)[i];
            byte byteValue = (byte) intValue;
            if (intValue != byteValue) {
                return false;
            }
        }
        return true;
    }

}
