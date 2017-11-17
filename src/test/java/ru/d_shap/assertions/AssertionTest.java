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
package ru.d_shap.assertions;

/**
 * Base class for all tests.
 *
 * @author Dmitry Shapovalov
 */
public class AssertionTest {

    /**
     * Test class constructor.
     */
    protected AssertionTest() {
        super();
    }

    /**
     * Initialize the specified assertion with the actual value.
     *
     * @param assertion the specified assertion.
     * @param actual    the actual value.
     * @param <T>       generic assertion type.
     * @return the initialized assertion.
     */
    public final <T extends BaseAssertion> T initialize(final T assertion, final Object actual) {
        assertion.initialize(actual);
        return assertion;
    }

    /**
     * Initialize the specified assertion with the actual value and the message.
     *
     * @param assertion the specified assertion.
     * @param actual    the actual value.
     * @param message   the message.
     * @param <T>       generic assertion type.
     * @return the initialized assertion.
     */
    public final <T extends BaseAssertion> T initialize(final T assertion, final Object actual, final String message) {
        assertion.initialize(actual, message);
        return assertion;
    }

    /**
     * Create initialized base assertion with the actual value.
     *
     * @param actual the actual value.
     * @return the initialized assertion.
     */
    public BaseAssertion createBaseAssertion(final Object actual) {
        return initialize(new BaseAssertionImpl(), actual);
    }

    /**
     * Create initialized base assertion with the actual value and the message.
     *
     * @param actual  the actual value.
     * @param message the message.
     * @return the initialized assertion.
     */
    public BaseAssertion createBaseAssertion(final Object actual, final String message) {
        return initialize(new BaseAssertionImpl(), actual, message);
    }

    /**
     * Create initialized reference assertion with the actual value.
     *
     * @param actual the actual value.
     * @return the initialized assertion.
     */
    public ReferenceAssertion createReferenceAssertion(final Object actual) {
        return initialize(new ReferenceAssertionImpl(), actual);
    }

    /**
     * Create initialized reference assertion with the actual value and the message.
     *
     * @param actual  the actual value.
     * @param message the message.
     * @return the initialized assertion.
     */
    public ReferenceAssertion createReferenceAssertion(final Object actual, final String message) {
        return initialize(new ReferenceAssertionImpl(), actual, message);
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    public static final class BaseAssertionImpl extends BaseAssertion {

        BaseAssertionImpl() {
            super();
        }

        @Override
        protected String asString(final Object value) {
            return value.toString();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    public static final class ReferenceAssertionImpl extends ReferenceAssertion {

        ReferenceAssertionImpl() {
            super();
        }

        @Override
        protected String asString(final Object value) {
            return value.toString();
        }

    }

}
