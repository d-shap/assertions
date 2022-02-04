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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ru.d_shap.assertions.converter.ConverterArgumentHelper;
import ru.d_shap.assertions.converter.ValueConverter;
import ru.d_shap.assertions.converter.ValueConverterProvider;

/**
 * Value converter from the char sequence to the element.
 *
 * @author Dmitry Shapovalov
 */
public final class CharSequenceToElementValueConverter implements ValueConverterProvider {

    /**
     * Create new object.
     */
    public CharSequenceToElementValueConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return CharSequence.class;
    }

    @Override
    public Class<?> getTargetClass() {
        return Element.class;
    }

    @Override
    public Object convert(final Object value, final Object... arguments) {
        CharSequence castedValue = ConverterArgumentHelper.getValue(value, CharSequence.class);
        ConverterArgumentHelper.checkArgumentsLength(arguments, 0);

        Document document = ValueConverter.convert(castedValue, Document.class);
        return document.getDocumentElement();
    }

}
