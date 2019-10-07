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
/**
 * <p>
 * Package contains classes to describe the failure and to generate the assertion error with the fail
 * description.
 * </p>
 * <p>
 * The fail description consists of the fail description entries, describing the check.
 * The last fail description entry can contain actual and expected value with an optional delta value.
 * </p>
 * <p>
 * If the fail description contains the actual value, then this value is converted to the string
 * representation.
 * </p>
 * <p>
 * If the fail description contains the expected value, then the expected value is first converted
 * to the value with the actual value's class, then the converted value is converted to the string
 * representation. Conversion to the actual value's class can be skipped if the raw expected values
 * are used.
 * </p>
 * <p>
 * If the fail description contains the delta value, then the delta value is first converted to
 * the value with the actual value's class, then the converted value is converted to the string
 * representation. Conversion to the actual value's class can be replaced with the conversion to
 * the expected value's class, if raw expected values are used.
 * </p>
 */
package ru.d_shap.assertions.fail;
