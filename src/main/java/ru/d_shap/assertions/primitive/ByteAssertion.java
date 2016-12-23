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
 * Assertions for the byte primitive value.
 *
 * @author Dmitry Shapovalov
 */
public class ByteAssertion extends BaseAssertion {

    private final byte _actual;

    /**
     * Create new object.
     *
     * @param actual  the actual value.
     * @param message the error message.
     */
    public ByteAssertion(final byte actual, final String message) {
        super(message);
        _actual = actual;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final byte expected) {
        if (_actual != expected) {
            fail("Values should be the same. Expected: <" + expected + ">, but was: <" + _actual + ">");
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final byte expected) {
        if (_actual == expected) {
            fail("Values should be different. Actual: <" + _actual + ">");
        }
    }

    /**
     * Check if the actual value is greater than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThan(final byte expected) {
        if (_actual <= expected) {
            fail("Value should be greater then the expected. Expected: <" + expected + ">, but was: <" + _actual + ">");
        }
    }

    /**
     * Check if the actual value is greater than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isGreaterThanOrEqualTo(final byte expected) {
        if (_actual < expected) {
            fail("Value should be greater then or equal to the expected. Expected: <" + expected + ">, but was: <" + _actual + ">");
        }
    }

    /**
     * Check if the actual value is less than the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThan(final byte expected) {
        if (_actual >= expected) {
            fail("Value should be less then the expected. Expected: <" + expected + ">, but was: <" + _actual + ">");
        }
    }

    /**
     * Check if the actual value is less than or equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isLessThanOrEqualTo(final byte expected) {
        if (_actual > expected) {
            fail("Value should be less then or equal to the expected. Expected: <" + expected + ">, but was: <" + _actual + ">");
        }
    }

}
