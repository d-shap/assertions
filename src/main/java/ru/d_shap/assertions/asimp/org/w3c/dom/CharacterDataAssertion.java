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
package ru.d_shap.assertions.asimp.org.w3c.dom;

import org.hamcrest.Matcher;
import org.w3c.dom.CharacterData;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;

/**
 * Assertions for the character data.
 *
 * @author Dmitry Shapovalov
 */
public final class CharacterDataAssertion extends ReferenceAssertion<CharacterDataAssertion, CharacterData> {

    /**
     * Create new object.
     */
    public CharacterDataAssertion() {
        super();
    }

    @Override
    protected Class<CharacterData> getActualValueClass() {
        return CharacterData.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharacterDataAssertion isEqualTo(final CharacterData expected) {
        createNodeAssertion().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharacterDataAssertion isNotEqualTo(final CharacterData expected) {
        createNodeAssertion().isNotEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's data.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toData() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getData(), Messages.Check.DATA);
    }

    /**
     * Make assertion about the actual value's data.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public CharacterDataAssertion toData(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getData(), matcher, Messages.Check.DATA);
        return this;
    }

    /**
     * Check if the actual value's data is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public CharacterDataAssertion hasData(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toData().isEqualTo(expected);
        return this;
    }

    private NodeAssertion createNodeAssertion() {
        return initializeAssertion(Raw.nodeAssertion(), getActual());
    }

}
