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
 * Package contains classes to convert objects to the objects with some other class.
 * </p>
 * <p>
 * Classes to convert the value to the value with the target class are used to reuse existing assertions.
 * For example, arrays, collections, buffers have the same assertions like containsAll, containsExactly etc.
 * The actual value of this assertions is converted to the value with the target class of the other assertion
 * and the other assertion is used.
 * </p>
 * <p>
 * Classes to convert the value to the string representation are used for the fail message generation.
 * </p>
 * <p>
 * All convertes use SPI to locate the converter providers.
 * </p>
 */
package ru.d_shap.assertions.converter;
