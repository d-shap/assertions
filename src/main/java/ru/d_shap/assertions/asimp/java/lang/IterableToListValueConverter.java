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
package ru.d_shap.assertions.asimp.java.lang;

import java.util.ArrayList;
import java.util.List;

import ru.d_shap.assertions.converter.ConverterArgumentHelper;
import ru.d_shap.assertions.converter.ValueConverterProvider;

/**
 * Value converter from the iterable to the list.
 *
 * @author Dmitry Shapovalov
 */
public final class IterableToListValueConverter implements ValueConverterProvider {

    /**
     * Create new object.
     */
    public IterableToListValueConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return Iterable.class;
    }

    @Override
    public Class<?> getTargetClass() {
        return List.class;
    }

    @Override
    public Object convert(final Object value, final Object... arguments) {
        Iterable<?> castedValue = ConverterArgumentHelper.getValue(value, Iterable.class);
        ConverterArgumentHelper.checkArgumentsLength(arguments, 0);

        if (castedValue instanceof List) {
            return castedValue;
        } else {
            List<Object> result = new ArrayList<>();
            for (Object element : castedValue) {
                result.add(element);
            }
            return result;
        }
    }

}
