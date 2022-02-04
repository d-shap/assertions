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
package ru.d_shap.assertions.asimp.java.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ConverterArgumentHelper;
import ru.d_shap.assertions.converter.ValueConverterProvider;

/**
 * Value converter from the input stream to the byte array.
 *
 * @author Dmitry Shapovalov
 */
public final class InputStreamToByteArrayValueConverter implements ValueConverterProvider {

    /**
     * Create new object.
     */
    public InputStreamToByteArrayValueConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return InputStream.class;
    }

    @Override
    public Class<?> getTargetClass() {
        return byte[].class;
    }

    @Override
    public Object convert(final Object value, final Object... arguments) {
        InputStream castedValue = ConverterArgumentHelper.getValue(value, InputStream.class);
        ConverterArgumentHelper.checkArgumentsLength(arguments, 1);
        int castedCount = ConverterArgumentHelper.getArgument(arguments, 0, Integer.class);

        try {
            int read;
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            for (int i = 0; castedCount == 0 || i < castedCount; i++) {
                read = castedValue.read();
                if (read < 0) {
                    break;
                }
                result.write(read);
            }
            return result.toByteArray();
        } catch (IOException ex) {
            throw new ConversionException(ex);
        }
    }

}
