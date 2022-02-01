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
package ru.d_shap.assertions.asimp.javax.xml.datatype;

import java.util.Calendar;
import java.util.TimeZone;

import javax.xml.datatype.XMLGregorianCalendar;

import ru.d_shap.assertions.converter.ConversionException;
import ru.d_shap.assertions.converter.ConverterArgumentHelper;
import ru.d_shap.assertions.converter.ValueConverterProvider;

/**
 * Value converter from the XML gregorian calendar to the calendar.
 *
 * @author Dmitry Shapovalov
 */
public final class XMLGregorianCalendarToCalendarValueConverter implements ValueConverterProvider {

    /**
     * Create new object.
     */
    public XMLGregorianCalendarToCalendarValueConverter() {
        super();
    }

    @Override
    public Class<?> getValueClass() {
        return XMLGregorianCalendar.class;
    }

    @Override
    public Class<?> getTargetClass() {
        return Calendar.class;
    }

    @Override
    public Object convert(final Object value, final Object... arguments) throws ConversionException {
        XMLGregorianCalendar castedValue = ConverterArgumentHelper.getValue(value, XMLGregorianCalendar.class);
        ConverterArgumentHelper.checkArgumentsLength(arguments, 1);
        TimeZone castedTimeZone = ConverterArgumentHelper.getArgument(arguments, 0, TimeZone.class);

        Calendar result = Calendar.getInstance();
        if (castedTimeZone == null) {
            Calendar calendar = castedValue.toGregorianCalendar();
            result.setTimeZone(calendar.getTimeZone());
        } else {
            result.setTimeZone(castedTimeZone);
        }
        result.set(Calendar.YEAR, castedValue.getYear());
        result.set(Calendar.MONTH, castedValue.getMonth() - 1);
        result.set(Calendar.DAY_OF_MONTH, castedValue.getDay());
        result.set(Calendar.HOUR_OF_DAY, castedValue.getHour());
        result.set(Calendar.MINUTE, castedValue.getMinute());
        result.set(Calendar.SECOND, castedValue.getSecond());
        result.set(Calendar.MILLISECOND, castedValue.getMillisecond());
        return result;
    }

}