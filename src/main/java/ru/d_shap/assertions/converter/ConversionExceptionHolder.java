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
package ru.d_shap.assertions.converter;

/**
 * Holder class for the conversion exception.
 *
 * @author Dmitry Shapovalov
 */
public final class ConversionExceptionHolder {

    private ConversionException _conversionException;

    /**
     * Create new object.
     */
    public ConversionExceptionHolder() {
        super();
    }

    /**
     * Check if the conversion exception is set.
     *
     * @return true, if the conversion exception is set.
     */
    public boolean hasConversionException() {
        return _conversionException != null;
    }

    /**
     * Get the conversion exception.
     *
     * @return the conversion exception.
     */
    public ConversionException getConversionException() {
        return _conversionException;
    }

    /**
     * Set the conversion exception.
     *
     * @param conversionException the conversion exception.
     */
    public void setConversionException(final ConversionException conversionException) {
        _conversionException = conversionException;
    }

}
