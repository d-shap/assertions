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
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.DoubleBuffer;

import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ConverterArgumentHelper;
import ru.d_shap.assertions.converter.ValueConverterProvider;

/**
 * Value converter from the double buffer to the double array.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleBufferToDoubleArrayValueConverter implements ValueConverterProvider {

    /**
     * Create new object.
     */
    public DoubleBufferToDoubleArrayValueConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return DoubleBuffer.class;
    }

    @Override
    public Class<?> getTargetClass() {
        return double[].class;
    }

    @Override
    public Object convert(final Object value, final Object... arguments) throws ConversionException {
        DoubleBuffer castedValue = ConverterArgumentHelper.getValue(value, DoubleBuffer.class);
        ConverterArgumentHelper.checkArgumentsLength(arguments, 1);
        boolean castedRewind = ConverterArgumentHelper.getArgument(arguments, 0, Boolean.class);

        int position = castedValue.position();
        if (castedRewind) {
            castedValue.rewind();
        }
        double[] result = new double[castedValue.remaining()];
        for (int i = 0; i < result.length; i++) {
            result[i] = castedValue.get();
        }
        castedValue.position(position);
        return result;
    }

}
