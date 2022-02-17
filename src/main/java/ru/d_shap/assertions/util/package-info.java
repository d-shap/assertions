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
 * Package contains utility classes.
 * </p>
 * <p>
 * Often, many objects should be created during testing. But some objects cannot be created
 * with one constructor or method call. First, the constructor or factory method should be called,
 * then multiple setters should be called. And only then the object can be used.
 * </p>
 * <p>
 * Classes in this package provides simple methods to create objects, that can be used in tests.
 * </p>
 * <p>
 * Also classes in this package provide useful utilities for testing, for example, access the inner
 * state of the object with reflection, or check if the object is serializable.
 * </p>
 */
package ru.d_shap.assertions.util;
