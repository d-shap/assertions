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
package ru.d_shap.assertions.array;

import ru.d_shap.assertions.BaseValueConverter;
import ru.d_shap.assertions.ConvertionException;

/**
 * Value converter from the int array to the char array.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayToCharArrayValueConverter extends BaseValueConverter {

    /**
     * Create new object.
     */
    public IntArrayToCharArrayValueConverter() {
        super();
    }

    @Override
    protected Class<?> getValueClass() {
        return int[].class;
    }

    @Override
    protected Class<?> getTargetClass() {
        return char[].class;
    }

    @Override
    protected boolean canConvert(final Object value, final Object... arguments) throws ConvertionException {
        checkValueClass(value);
        checkArgumentValueCount(0, arguments);
        for (int i = 0; i < ((int[]) value).length; i++) {
            int intValue = ((int[]) value)[i];
            char charValue = (char) intValue;
            if (intValue != charValue) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected Object convert(final Object value, final Object... arguments) throws ConvertionException {
        checkValueClass(value);
        checkArgumentValueCount(0, arguments);
        char[] result = new char[((int[]) value).length];
        for (int i = 0; i < ((int[]) value).length; i++) {
            result[i] = (char) ((int[]) value)[i];
        }
        return result;
    }

}
