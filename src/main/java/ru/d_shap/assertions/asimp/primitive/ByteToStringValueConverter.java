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
import ru.d_shap.assertions.converter.ValueConverterProvider;

/**
 * Value converter from the byte to the string.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteToStringValueConverter implements ValueConverterProvider {

    private static final String[] VALUES;

    static {
        VALUES = new String[16];
        VALUES[0] = "0";
        VALUES[1] = "1";
        VALUES[2] = "2";
        VALUES[3] = "3";
        VALUES[4] = "4";
        VALUES[5] = "5";
        VALUES[6] = "6";
        VALUES[7] = "7";
        VALUES[8] = "8";
        VALUES[9] = "9";
        VALUES[10] = "a";
        VALUES[11] = "b";
        VALUES[12] = "c";
        VALUES[13] = "d";
        VALUES[14] = "e";
        VALUES[15] = "f";
    }

    /**
     * Create new object.
     */
    public ByteToStringValueConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return Byte.class;
    }

    @Override
    public Class<?> getTargetClass() {
        return String.class;
    }

    @Override
    public Object convert(final Object value, final Object... arguments) {
        byte castedValue = ConverterArgumentHelper.getValue(value, Byte.class);
        ConverterArgumentHelper.checkArgumentsLength(arguments, 0);

        byte part1 = (byte) (castedValue >> 4 & 0xF);
        String str1 = VALUES[part1];
        byte part2 = (byte) (castedValue & 0xF);
        String str2 = VALUES[part2];
        return str1 + str2;
    }

}
