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
package ru.d_shap.assertions.asimp.java.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ConverterArgumentHelper;
import ru.d_shap.assertions.converter.ValueConverterProvider;

/**
 * Value converter from the iterator to the list.
 *
 * @author Dmitry Shapovalov
 */
public final class IteratorToListValueConverter implements ValueConverterProvider {

    /**
     * Create new object.
     */
    public IteratorToListValueConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return Iterator.class;
    }

    @Override
    public Class<?> getTargetClass() {
        return List.class;
    }

    @Override
    public Object convert(final Object value, final Object... arguments) throws ConversionException {
        Iterator<?> castedValue = ConverterArgumentHelper.getValue(value, Iterator.class);
        ConverterArgumentHelper.checkArgumentsLength(arguments, 1);
        int castedCount = ConverterArgumentHelper.getArgument(arguments, 0, Integer.class);

        List<Object> result = new ArrayList<>();
        for (int i = 0; (castedCount == 0 || i < castedCount) && castedValue.hasNext(); i++) {
            Object element = castedValue.next();
            result.add(element);
        }
        return result;
    }

}
