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
package ru.d_shap.assertions.asimp.predicate;

import ru.d_shap.assertions.AssertionInvoker;
import ru.d_shap.assertions.BaseAssertion;
import ru.d_shap.assertions.Messages;

/**
 * Predicate for the AND operation.
 *
 * @author Dmitry Shapovalov
 */
public final class AndPredicate extends BaseAssertion<AssertionInvoker[]> implements AssertionInvoker {

    /**
     * Create new object.
     */
    public AndPredicate() {
        super();
    }

    @Override
    protected Class<AssertionInvoker[]> getActualValueClass() {
        return AssertionInvoker[].class;
    }

    @Override
    public void invoke() {
        checkActualIsNotNull();
        AssertionInvoker[] assertionInvokers = getActual();
        for (int i = 0; i < assertionInvokers.length; i++) {
            AssertionInvoker assertionInvoker = assertionInvokers[i];
            checkArgumentPropertyIsNotNull(assertionInvoker, "assertionInvoker", "[" + i + "]");
        }
        for (AssertionInvoker assertionInvoker : assertionInvokers) {
            try {
                assertionInvoker.invoke();
            } catch (AssertionError ex) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Predicate.AND_IS_FALSE).addSuppressedThrowable(ex).build();
            }
        }
    }

}
