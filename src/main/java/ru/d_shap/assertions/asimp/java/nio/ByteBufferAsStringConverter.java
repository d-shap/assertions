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

import java.nio.ByteBuffer;

import ru.d_shap.assertions.converter.AsStringConverter;
import ru.d_shap.assertions.converter.AsStringConverterProvider;
import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ConverterArgumentHelper;

/**
 * Value to string converter for the byte buffer.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteBufferAsStringConverter implements AsStringConverterProvider {

    /**
     * Create new object.
     */
    public ByteBufferAsStringConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return ByteBuffer.class;
    }

    @Override
    public String asString(final Object value) throws ConversionException {
        ByteBuffer castedValue = ConverterArgumentHelper.getValue(value, ByteBuffer.class);

        return AsStringConverter.asString(castedValue, byte[].class);
    }

}
