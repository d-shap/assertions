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
    public Object convert(final Object value, final Object... arguments) {
        XMLGregorianCalendar castedValue = ConverterArgumentHelper.getValue(value, XMLGregorianCalendar.class);
        ConverterArgumentHelper.checkArgumentsLength(arguments, 1);
        TimeZone castedTimeZone = ConverterArgumentHelper.getArgument(arguments, 0, TimeZone.class);

        Calendar castedCalendar = castedValue.toGregorianCalendar();

        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.setTimeZone(castedCalendar.getTimeZone());
        tempCalendar.set(Calendar.YEAR, castedValue.getYear());
        tempCalendar.set(Calendar.MONTH, castedValue.getMonth() - 1);
        tempCalendar.set(Calendar.DAY_OF_MONTH, castedValue.getDay());
        tempCalendar.set(Calendar.HOUR_OF_DAY, castedValue.getHour());
        tempCalendar.set(Calendar.MINUTE, castedValue.getMinute());
        tempCalendar.set(Calendar.SECOND, castedValue.getSecond());
        tempCalendar.set(Calendar.MILLISECOND, castedValue.getMillisecond());

        Calendar result = Calendar.getInstance();
        if (castedTimeZone == null) {
            result.setTimeZone(tempCalendar.getTimeZone());
        } else {
            result.setTimeZone(castedTimeZone);
        }
        result.setTime(tempCalendar.getTime());
        return result;
    }

}
