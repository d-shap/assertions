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
package ru.d_shap.assertions.asimp.java.util;

import java.util.Locale;
import java.util.TimeZone;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;
import ru.d_shap.assertions.asimp.primitive.BooleanAssertion;
import ru.d_shap.assertions.asimp.primitive.IntAssertion;

/**
 * Assertions for the time zone.
 *
 * @author Dmitry Shapovalov
 */
public final class TimeZoneAssertion extends ReferenceAssertion<TimeZone> {

    /**
     * Create new object.
     */
    public TimeZoneAssertion() {
        super();
    }

    @Override
    protected Class<TimeZone> getActualValueClass() {
        return TimeZone.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public TimeZoneAssertion isEqualTo(final TimeZone expected) {
        if (expected == null) {
            isNull();
        } else {
            checkActualIsNotNull();
            if (!getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
            }
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
    public TimeZoneAssertion isNotEqualTo(final TimeZone expected) {
        if (expected == null) {
            isNotNull();
        } else {
            if (getActual() != null && getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
            }
        }
        return this;
    }

    /**
     * Check if the actual value has the same rules as the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public TimeZoneAssertion hasSameRules(final TimeZone expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (!getActual().hasSameRules(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.HAS_SAME_RULES).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Check if the actual value does NOT have the same rules as the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public TimeZoneAssertion doesNotHaveSameRules(final TimeZone expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().hasSameRules(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_HAVE_SAME_RULES).addActual().addExpected(expected).build();
        }
        return this;
    }

    /**
     * Make assertion about the actual value's ID.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toId() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getID(), Messages.Check.ID);
    }

    /**
     * Make assertion about the actual value's ID.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public TimeZoneAssertion toId(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getID(), matcher, Messages.Check.ID);
        return this;
    }

    /**
     * Check if the actual value's ID is equal to the expected ID.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public TimeZoneAssertion hasId(final String expected) {
        toId().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's display name.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toDisplayName() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getDisplayName(Locale.US), Messages.Check.DISPLAY_NAME);
    }

    /**
     * Make assertion about the actual value's display name.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public TimeZoneAssertion toDisplayName(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getDisplayName(Locale.US), matcher, Messages.Check.DISPLAY_NAME);
        return this;
    }

    /**
     * Check if the actual value's display name is equal to the expected display name.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public TimeZoneAssertion hasDisplayName(final String expected) {
        toDisplayName().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's raw offset.
     *
     * @return the assertion.
     */
    public IntAssertion toRawOffset() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().getRawOffset(), Messages.Check.RAW_OFFSET);
    }

    /**
     * Make assertion about the actual value's raw offset.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public TimeZoneAssertion toRawOffset(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getRawOffset(), matcher, Messages.Check.RAW_OFFSET);
        return this;
    }

    /**
     * Check if the actual value's raw offset is equal to the expected raw offset.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public TimeZoneAssertion hasRawOffset(final int expected) {
        toRawOffset().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's use daylight time.
     *
     * @return the assertion.
     */
    public BooleanAssertion toUseDaylightTime() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.booleanAssertion(), getActual().useDaylightTime(), Messages.Check.USE_DAYLIGHT_TIME);
    }

    /**
     * Make assertion about the actual value's use daylight time.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public TimeZoneAssertion toUseDaylightTime(final Matcher<? super Boolean> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().useDaylightTime(), matcher, Messages.Check.USE_DAYLIGHT_TIME);
        return this;
    }

    /**
     * Check if the actual value's use daylight time is true.
     *
     * @return current object for the chain call.
     */
    public TimeZoneAssertion useDaylightTime() {
        toUseDaylightTime().isTrue();
        return this;
    }

    /**
     * Check if the actual value's use daylight time is false.
     *
     * @return current object for the chain call.
     */
    public TimeZoneAssertion doesNotUseDaylightTime() {
        toUseDaylightTime().isFalse();
        return this;
    }

    /**
     * Make assertion about the actual value's DST savings.
     *
     * @return the assertion.
     */
    public IntAssertion toDstSavings() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().getDSTSavings(), Messages.Check.DST_SAVINGS);
    }

    /**
     * Make assertion about the actual value's DST savings.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public TimeZoneAssertion toDstSavings(final Matcher<? super Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getDSTSavings(), matcher, Messages.Check.DST_SAVINGS);
        return this;
    }

    /**
     * Check if the actual value's DST savings is equal to the expected DST savings.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public TimeZoneAssertion hasDstSavings(final int expected) {
        toDstSavings().isEqualTo(expected);
        return this;
    }

}
