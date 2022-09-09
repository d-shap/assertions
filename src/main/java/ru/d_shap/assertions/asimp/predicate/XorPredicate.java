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

import java.util.ArrayList;
import java.util.List;

import ru.d_shap.assertions.AssertionInvoker;
import ru.d_shap.assertions.BaseAssertion;
import ru.d_shap.assertions.Messages;

/**
 * Predicate for the XOR operation.
 *
 * @author Dmitry Shapovalov
 */
public final class XorPredicate extends BaseAssertion<AssertionInvoker[]> implements AssertionInvoker {

    /**
     * Create new object.
     */
    public XorPredicate() {
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
        List<AssertionError> assertionErrors = new ArrayList<>();
        if (assertionInvokers.length == 0) {
            return;
        }
        boolean result;
        try {
            assertionInvokers[0].invoke();
            result = true;
        } catch (AssertionError ex) {
            assertionErrors.add(ex);
            result = false;
        }
        for (int i = 1; i < assertionInvokers.length; i++) {
            try {
                assertionInvokers[i].invoke();
                result = !result;
            } catch (AssertionError ex) {
                assertionErrors.add(ex);
            }
        }
        if (!result) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Predicate.XOR_IS_FALSE).addSuppressedThrowable(assertionErrors).build();
        }
    }

}
