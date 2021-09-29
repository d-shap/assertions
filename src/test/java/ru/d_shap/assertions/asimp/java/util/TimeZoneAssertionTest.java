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

import java.util.TimeZone;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link TimeZoneAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public class TimeZoneAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public TimeZoneAssertionTest() {
        super();
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"));

        try {
            initializeWithRawActual(Raw.timeZoneAssertion(), new Object());
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.TimeZone> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.timeZoneAssertion(), new Object(), "Message");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.TimeZone> but was:<java.lang.Object>");
        }
    }

}
