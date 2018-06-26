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
package ru.d_shap.assertions.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import ru.d_shap.assertions.BaseValueConverter;
import ru.d_shap.assertions.ConvertionException;

/**
 * Value converter from the input stream to the byte array.
 *
 * @author Dmitry Shapovalov
 */
public final class InputStreamToByteArrayValueConverter extends BaseValueConverter {

    /**
     * Create new object.
     */
    public InputStreamToByteArrayValueConverter() {
        super();
    }

    @Override
    protected Class<?> getValueClass() {
        return InputStream.class;
    }

    @Override
    protected Class<?> getTargetClass() {
        return byte[].class;
    }

    @Override
    protected boolean canConvert(final Object value, final Object... arguments) throws ConvertionException {
        return true;
    }

    @Override
    protected Object convert(final Object value, final Object... arguments) throws ConvertionException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (true) {
                int read = ((InputStream) value).read();
                if (read < 0) {
                    break;
                }
                baos.write(read);
            }
            return baos.toByteArray();
        } catch (IOException ex) {
            throw new ConvertionException(ex);
        }
    }

}
