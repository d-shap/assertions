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
package ru.d_shap.assertions.asimp.primitive;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.HexString;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;

/**
 * Assertions for the int.
 *
 * @author Dmitry Shapovalov
 */
public final class IntAssertion extends ReferenceAssertion<IntAssertion, Integer> {

    /**
     * Create new object.
     */
    public IntAssertion() {
        super();
    }

    @Override
    protected Class<Integer> getActualValueClass() {
        return Integer.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isEqualTo(final int expected) {
        checkActualIsNotNull();
        if (getActual() != expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isEqualTo(final Integer expected) {
        if (expected == null) {
            isNull();
        } else {
            isEqualTo(expected.intValue());
        }
        return this;
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isNotEqualTo(final int expected) {
        if (getActual() != null && getActual() == expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isNotEqualTo(final Integer expected) {
        if (expected == null) {
            isNotNull();
        } else {
            isNotEqualTo(expected.intValue());
        }
        return this;
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isGreaterThan(final int expected) {
        checkActualIsNotNull();
        if (getActual() <= expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isGreaterThan(final Integer expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        isGreaterThan(expected.intValue());
        return this;
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isGreaterThanOrEqualTo(final int expected) {
        checkActualIsNotNull();
        if (getActual() < expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_GREATER_OR_EQUAL).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isGreaterThanOrEqualTo(final Integer expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        isGreaterThanOrEqualTo(expected.intValue());
        return this;
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isLessThan(final int expected) {
        checkActualIsNotNull();
        if (getActual() >= expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isLessThan(final Integer expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        isLessThan(expected.intValue());
        return this;
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isLessThanOrEqualTo(final int expected) {
        checkActualIsNotNull();
        if (getActual() > expected) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_LESS_OR_EQUAL).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isLessThanOrEqualTo(final Integer expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        isLessThanOrEqualTo(expected.intValue());
        return this;
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isInRange(final int expectedFrom, final int expectedTo) {
        checkActualIsNotNull();
        if (getActual() < expectedFrom || getActual() >= expectedTo) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
        return this;
    }

    /**
     * Check if the actual value is in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isInRange(final Integer expectedFrom, final Integer expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        isInRange(expectedFrom.intValue(), expectedTo.intValue());
        return this;
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isNotInRange(final int expectedFrom, final int expectedTo) {
        checkActualIsNotNull();
        if (getActual() >= expectedFrom && getActual() < expectedTo) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_NOT_IN_RANGE).addActual().addExpected(expectedFrom, expectedTo).build();
        }
        return this;
    }

    /**
     * Check if the actual value is NOT in the expected range.
     *
     * @param expectedFrom the expected lower (inclusive) bound of the range.
     * @param expectedTo   the expected upper (exclusive) bound of the range.
     *
     * @return current object for the chain call.
     */
    public IntAssertion isNotInRange(final Integer expectedFrom, final Integer expectedTo) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedFrom, "expectedFrom");
        checkArgumentIsNotNull(expectedTo, "expectedTo");
        isNotInRange(expectedFrom.intValue(), expectedTo.intValue());
        return this;
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toHexString() {
        checkActualIsNotNull();
        HexString hexString = convertValue(getActual(), null, HexString.class);
        return initializeAssertion(Raw.charSequenceAssertion(), hexString.toString(), Messages.Check.HEX_REPRESENTATION);
    }

    /**
     * Make assertion about the actual value's hex representation.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public IntAssertion toHexString(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        HexString hexString = convertValue(getActual(), null, HexString.class);
        matcherAssertion(hexString.toString(), matcher, Messages.Check.HEX_REPRESENTATION);
        return this;
    }

    /**
     * Check if the actual value's hex representation is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public IntAssertion hasHexString(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toHexString().isEqualTo(expected);
        return this;
    }

}
