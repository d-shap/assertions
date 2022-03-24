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

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ConverterArgumentHelper;
import ru.d_shap.assertions.converter.ValueConverterProvider;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Value converter from the char sequence to the document.
 *
 * @author Dmitry Shapovalov
 */
public final class CharSequenceToDocumentValueConverter implements ValueConverterProvider {

    /**
     * Create new object.
     */
    public CharSequenceToDocumentValueConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return CharSequence.class;
    }

    @Override
    public Class<?> getTargetClass() {
        return Document.class;
    }

    @Override
    public Object convert(final Object value, final Object... arguments) {
        CharSequence castedValue = ConverterArgumentHelper.getValue(value, CharSequence.class);
        ConverterArgumentHelper.checkArgumentsLength(arguments, 0);

        try {
            DocumentBuilder documentBuilder = DataHelper.createDocumentBuilder();
            StringReader reader = new StringReader(castedValue.toString());
            InputSource inputSource = new InputSource(reader);
            return documentBuilder.parse(inputSource);
        } catch (SAXException | IOException ex) {
            throw new ConversionException(ex);
        }
    }

}
