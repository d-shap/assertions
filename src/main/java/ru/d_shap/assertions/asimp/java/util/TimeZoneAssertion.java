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
public class TimeZoneAssertion extends ReferenceAssertion<TimeZone> {

    /**
     * Create new object.
     */
    public TimeZoneAssertion() {
        super();
    }

    @Override
    protected final Class<TimeZone> getActualValueClass() {
        return TimeZone.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final TimeZone expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (!getActual().equals(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final TimeZone expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().equals(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
        }
    }

    /**
     * Check if the actual value has the same rules as the expected value.
     *
     * @param expected the expected value.
     */
    public final void hasSameRules(final TimeZone expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (!getActual().hasSameRules(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.HAS_SAME_RULES).addActual().addExpected(expected).build();
        }
    }

    /**
     * Check if the actual value does NOT have the same rules as the expected value.
     *
     * @param expected the expected value.
     */
    public final void doesNotHaveSameRules(final TimeZone expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        if (getActual().hasSameRules(expected)) {
            throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.DOES_NOT_HAVE_SAME_RULES).addActual().build();
        }
    }

    /**
     * Make assertion about the actual value's ID.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toId() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getID(), Messages.Check.ID);
    }

    /**
     * Make assertion about the actual value's ID.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toId(final Matcher<String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getID(), matcher, Messages.Check.ID);
    }

    /**
     * Check if the actual value's ID is equal to the expected ID.
     *
     * @param expected the expected value.
     */
    public final void hasId(final String expected) {
        toId().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's display name.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toDisplayName() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getDisplayName(Locale.US), Messages.Check.DISPLAY_NAME);
    }

    /**
     * Make assertion about the actual value's display name.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toDisplayName(final Matcher<String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getDisplayName(Locale.US), matcher, Messages.Check.DISPLAY_NAME);
    }

    /**
     * Check if the actual value's display name is equal to the expected display name.
     *
     * @param expected the expected value.
     */
    public final void hasDisplayName(final String expected) {
        toDisplayName().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's raw offset.
     *
     * @return the assertion.
     */
    public final IntAssertion toRawOffset() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().getRawOffset(), Messages.Check.RAW_OFFSET);
    }

    /**
     * Make assertion about the actual value's raw offset.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toRawOffset(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getRawOffset(), matcher, Messages.Check.RAW_OFFSET);
    }

    /**
     * Check if the actual value's raw offset is equal to the expected raw offset.
     *
     * @param expected the expected value.
     */
    public final void hasRawOffset(final int expected) {
        toRawOffset().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's use daylight time.
     *
     * @return the assertion.
     */
    public final BooleanAssertion toUseDaylightTime() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.booleanAssertion(), getActual().useDaylightTime(), Messages.Check.USE_DAYLIGHT_TIME);
    }

    /**
     * Make assertion about the actual value's use daylight time.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toUseDaylightTime(final Matcher<Boolean> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().useDaylightTime(), matcher, Messages.Check.USE_DAYLIGHT_TIME);
    }

    /**
     * Check if the actual value's use daylight time is true.
     */
    public final void useDaylightTime() {
        toUseDaylightTime().isTrue();
    }

    /**
     * Check if the actual value's use daylight time is false.
     */
    public final void doesNotUseDaylightTime() {
        toUseDaylightTime().isFalse();
    }

    /**
     * Make assertion about the actual value's DST savings.
     *
     * @return the assertion.
     */
    public final IntAssertion toDstSavings() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.intAssertion(), getActual().getDSTSavings(), Messages.Check.DST_SAVINGS);
    }

    /**
     * Make assertion about the actual value's DST savings.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toDstSavings(final Matcher<Integer> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getDSTSavings(), matcher, Messages.Check.DST_SAVINGS);
    }

    /**
     * Check if the actual value's DST savings is equal to the expected DST savings.
     *
     * @param expected the expected value.
     */
    public final void hasDstSavings(final int expected) {
        toDstSavings().isEqualTo(expected);
    }

}
