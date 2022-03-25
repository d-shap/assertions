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
package ru.d_shap.assertions.asimp.primitive;

import ru.d_shap.assertions.converter.ConverterArgumentHelper;
import ru.d_shap.assertions.converter.ValueConverter;
import ru.d_shap.assertions.converter.ValueConverterProvider;

/**
 * Value converter from the long to the string.
 *
 * @author Dmitry Shapovalov
 */
public final class LongToStringValueConverter implements ValueConverterProvider {

    /**
     * Create new object.
     */
    public LongToStringValueConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return Long.class;
    }

    @Override
    public Class<?> getTargetClass() {
        return String.class;
    }

    @Override
    public Object convert(final Object value, final Object... arguments) {
        long castedValue = ConverterArgumentHelper.getValue(value, Long.class);
        ConverterArgumentHelper.checkArgumentsLength(arguments, 1);
        Boolean toHex = ConverterArgumentHelper.getArgument(arguments, 0, Boolean.class);

        if (toHex == null || !toHex) {
            return Long.toString(castedValue);
        } else {
            byte part1 = (byte) (castedValue >> 56 & 0xFF);
            String str1 = ValueConverter.convert(part1, String.class);
            byte part2 = (byte) (castedValue >> 48 & 0xFF);
            String str2 = ValueConverter.convert(part2, String.class);
            byte part3 = (byte) (castedValue >> 40 & 0xFF);
            String str3 = ValueConverter.convert(part3, String.class);
            byte part4 = (byte) (castedValue >> 32 & 0xFF);
            String str4 = ValueConverter.convert(part4, String.class);
            byte part5 = (byte) (castedValue >> 24 & 0xFF);
            String str5 = ValueConverter.convert(part5, String.class);
            byte part6 = (byte) (castedValue >> 16 & 0xFF);
            String str6 = ValueConverter.convert(part6, String.class);
            byte part7 = (byte) (castedValue >> 8 & 0xFF);
            String str7 = ValueConverter.convert(part7, String.class);
            byte part8 = (byte) (castedValue & 0xFF);
            String str8 = ValueConverter.convert(part8, String.class);
            return str1 + str2 + str3 + str4 + str5 + str6 + str7 + str8;
        }
    }

}
