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
package ru.d_shap.assertions.collection;

import java.util.List;
import java.util.RandomAccess;

import ru.d_shap.assertions.validator.ActualValueClassValidator;
import ru.d_shap.assertions.validator.ActualValueValidator;

/**
 * Assertions for the list.
 *
 * @param <T> the list element type.
 * @author Dmitry Shapovalov
 */
public class ListAssertion<T> extends CollectionAssertion<T> {

    private static final ActualValueValidator ACTUAL_VALUE_CLASS_VALIDATOR = new ActualValueClassValidator(List.class);

    /**
     * Create new object.
     */
    public ListAssertion() {
        super();
        addActualValueValidator(ACTUAL_VALUE_CLASS_VALIDATOR);
    }

    /**
     * Check if the actual value is the random access list.
     */
    public final void isRandomAccess() {
        toClass().isSubtypeOf(RandomAccess.class);
    }

    /**
     * Check if the actual value is NOT the random access list.
     */
    public final void isNotRandomAccess() {
        toClass().isNotSubtypeOf(RandomAccess.class);
    }

}
