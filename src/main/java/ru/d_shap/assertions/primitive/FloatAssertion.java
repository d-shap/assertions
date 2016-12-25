///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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
package ru.d_shap.assertions.primitive;

import ru.d_shap.assertions.BaseAssertion;

/**
 * Assertions for the float primitive value.
 *
 * @author Dmitry Shapovalov
 */
public class FloatAssertion extends BaseAssertion {

    private final float _actual;

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the error message.
     */
    public FloatAssertion(final float actual, final String message) {
        super(message);
        _actual = actual;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     */
    public final void isEqualTo(final float expected, final float delta) {
        if (Float.compare(expected, delta) != 0 && Math.abs(expected - delta) > delta) {
            throw new AssertionError();
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     * @param delta    maximum delta between the actual value and the expected value.
     */
    public final void isNotEqualTo(final float expected, final float delta) {
        if (Float.compare(expected, delta) == 0 || Math.abs(expected - delta) <= delta) {
            throw new AssertionError();
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final float expected) {
        if (_actual <= expected) {
            fail("Value should be greater then the expected. Expected: <" + expected + ">, but was: <" + _actual + ">");
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final float expected) {
        if (_actual < expected) {
            fail("Value should be greater then or equal to the expected. Expected: <" + expected + ">, but was: <" + _actual + ">");
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final float expected) {
        if (_actual >= expected) {
            fail("Value should be less then the expected. Expected: <" + expected + ">, but was: <" + _actual + ">");
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final float expected) {
        if (_actual > expected) {
            fail("Value should be less then or equal to the expected. Expected: <" + expected + ">, but was: <" + _actual + ">");
        }
    }

}
