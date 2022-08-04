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

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link LongAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongAssertionTest() {
        super();
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.longAssertion(), 10L);

        try {
            initializeWithRawActual(Raw.longAssertion(), new Object());
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Long> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.longAssertion(), new Object(), "Message");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Long> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isEqualToPrimitiveTest() {
        initialize(Raw.longAssertion(), 10L).isEqualTo(10L);
        initialize(Raw.longAssertion(), 75L).isEqualTo(75L);
        initialize(Raw.longAssertion(), 236L).isEqualTo(236L);
        initialize(Raw.longAssertion(), 257L).isEqualTo(257L);
        initialize(Raw.longAssertion(), 10L).isNotNull().isEqualTo(10L).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isEqualTo(20L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<20L> but was:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isEqualTo(20L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<20L> but was:<10L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isEqualToObjectTest() {
        initialize(Raw.longAssertion(), null).isEqualTo(null);
        initialize(Raw.longAssertion(), 10L).isEqualTo(Long.valueOf("10"));
        initialize(Raw.longAssertion(), 75L).isEqualTo(Long.valueOf("75"));
        initialize(Raw.longAssertion(), 236L).isEqualTo(Long.valueOf("236"));
        initialize(Raw.longAssertion(), 257L).isEqualTo(Long.valueOf("257"));
        initialize(Raw.longAssertion(), 10L).isNotNull().isEqualTo(Long.valueOf("10")).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isEqualTo(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isEqualTo(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isEqualTo(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 1L).isEqualTo(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<1L>");
        }
        try {
            initialize(Raw.longAssertion(), 1L, "Message").isEqualTo(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<1L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isEqualTo(Long.valueOf("20"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<20L> but was:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isEqualTo(Long.valueOf("20"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<20L> but was:<10L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isNotEqualToPrimitiveTest() {
        initialize(Raw.longAssertion(), null).isNotEqualTo(1);
        initialize(Raw.longAssertion(), 10L).isNotEqualTo(15L);
        initialize(Raw.longAssertion(), 75L).isNotEqualTo(76L);
        initialize(Raw.longAssertion(), 236L).isNotEqualTo(143L);
        initialize(Raw.longAssertion(), 257L).isNotEqualTo(2L);
        initialize(Raw.longAssertion(), 10L).isNotNull().isNotEqualTo(15L).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isNotEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isNotEqualTo(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isNotEqualTo(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isNotEqualToObjectTest() {
        initialize(Raw.longAssertion(), null).isNotEqualTo(Long.valueOf("1"));
        initialize(Raw.longAssertion(), 1L).isNotEqualTo(null);
        initialize(Raw.longAssertion(), 10L).isNotEqualTo(Long.valueOf("15"));
        initialize(Raw.longAssertion(), 75L).isNotEqualTo(Long.valueOf("76"));
        initialize(Raw.longAssertion(), 236L).isNotEqualTo(Long.valueOf("143"));
        initialize(Raw.longAssertion(), 257L).isNotEqualTo(Long.valueOf("2"));
        initialize(Raw.longAssertion(), 10L).isNotNull().isNotEqualTo(Long.valueOf("15")).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isNotEqualTo(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isNotEqualTo(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isNotEqualTo(Long.valueOf("10"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isNotEqualTo(Long.valueOf("10"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isGreaterThanPrimitiveTest() {
        initialize(Raw.longAssertion(), 10L).isGreaterThan(5L);
        initialize(Raw.longAssertion(), 60L).isGreaterThan(30L);
        initialize(Raw.longAssertion(), 245L).isGreaterThan(244L);
        initialize(Raw.longAssertion(), 10L).isNotNull().isGreaterThan(5L).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isGreaterThan(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isGreaterThan(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isGreaterThan(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isGreaterThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<10L> but was:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isGreaterThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<10L> but was:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isGreaterThan(11L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<11L> but was:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isGreaterThan(11L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<11L> but was:<10L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isGreaterThanObjectTest() {
        initialize(Raw.longAssertion(), 10L).isGreaterThan(Long.valueOf("5"));
        initialize(Raw.longAssertion(), 60L).isGreaterThan(Long.valueOf("30"));
        initialize(Raw.longAssertion(), 245L).isGreaterThan(Long.valueOf("244"));
        initialize(Raw.longAssertion(), 10L).isNotNull().isGreaterThan(Long.valueOf("5")).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isGreaterThan(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isGreaterThan(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isGreaterThan(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null).isGreaterThan(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isGreaterThan(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 1L).isGreaterThan(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longAssertion(), 1L, "Message").isGreaterThan(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isGreaterThan(Long.valueOf("10"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<10L> but was:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isGreaterThan(Long.valueOf("10"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<10L> but was:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isGreaterThan(Long.valueOf("11"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<11L> but was:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isGreaterThan(Long.valueOf("11"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<11L> but was:<10L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToPrimitiveTest() {
        initialize(Raw.longAssertion(), 10L).isGreaterThanOrEqualTo(5L);
        initialize(Raw.longAssertion(), 60L).isGreaterThanOrEqualTo(60L);
        initialize(Raw.longAssertion(), 245L).isGreaterThanOrEqualTo(244L);
        initialize(Raw.longAssertion(), 10L).isNotNull().isGreaterThanOrEqualTo(5L).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isGreaterThanOrEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isGreaterThanOrEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isGreaterThanOrEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isGreaterThanOrEqualTo(11L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<11L> but was:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isGreaterThanOrEqualTo(11L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<11L> but was:<10L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToObjectTest() {
        initialize(Raw.longAssertion(), 10L).isGreaterThanOrEqualTo(Long.valueOf("5"));
        initialize(Raw.longAssertion(), 60L).isGreaterThanOrEqualTo(Long.valueOf("60"));
        initialize(Raw.longAssertion(), 245L).isGreaterThanOrEqualTo(Long.valueOf("244"));
        initialize(Raw.longAssertion(), 10L).isNotNull().isGreaterThanOrEqualTo(Long.valueOf("5")).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isGreaterThanOrEqualTo(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isGreaterThanOrEqualTo(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isGreaterThanOrEqualTo(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null).isGreaterThanOrEqualTo(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 1L).isGreaterThanOrEqualTo(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longAssertion(), 1L, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isGreaterThanOrEqualTo(Long.valueOf("11"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<11L> but was:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isGreaterThanOrEqualTo(Long.valueOf("11"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<11L> but was:<10L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isLessThanPrimitiveTest() {
        initialize(Raw.longAssertion(), 5L).isLessThan(10L);
        initialize(Raw.longAssertion(), 30L).isLessThan(60L);
        initialize(Raw.longAssertion(), 244L).isLessThan(245L);
        initialize(Raw.longAssertion(), 5L).isNotNull().isLessThan(10L).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isLessThan(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isLessThan(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isLessThan(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isLessThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10L> but was:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isLessThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10L> but was:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 11L).isLessThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10L> but was:<11L>");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").isLessThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10L> but was:<11L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isLessThanObjectTest() {
        initialize(Raw.longAssertion(), 5L).isLessThan(Long.valueOf("10"));
        initialize(Raw.longAssertion(), 30L).isLessThan(Long.valueOf("60"));
        initialize(Raw.longAssertion(), 244L).isLessThan(Long.valueOf("245"));
        initialize(Raw.longAssertion(), 5L).isNotNull().isLessThan(Long.valueOf("10")).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isLessThan(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isLessThan(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isLessThan(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null).isLessThan(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isLessThan(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 1L).isLessThan(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longAssertion(), 1L, "Message").isLessThan(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isLessThan(Long.valueOf("10"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10L> but was:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isLessThan(Long.valueOf("10"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10L> but was:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 11L).isLessThan(Long.valueOf("10"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10L> but was:<11L>");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").isLessThan(Long.valueOf("10"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10L> but was:<11L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToPrimitiveTest() {
        initialize(Raw.longAssertion(), 5L).isLessThanOrEqualTo(10L);
        initialize(Raw.longAssertion(), 60L).isLessThanOrEqualTo(60L);
        initialize(Raw.longAssertion(), 244L).isLessThanOrEqualTo(245L);
        initialize(Raw.longAssertion(), 5L).isNotNull().isLessThanOrEqualTo(10L).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isLessThanOrEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isLessThanOrEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isLessThanOrEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 11L).isLessThanOrEqualTo(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<10L> but was:<11L>");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").isLessThanOrEqualTo(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<10L> but was:<11L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToObjectTest() {
        initialize(Raw.longAssertion(), 5L).isLessThanOrEqualTo(Long.valueOf("10"));
        initialize(Raw.longAssertion(), 60L).isLessThanOrEqualTo(Long.valueOf("60"));
        initialize(Raw.longAssertion(), 244L).isLessThanOrEqualTo(Long.valueOf("245"));
        initialize(Raw.longAssertion(), 5L).isNotNull().isLessThanOrEqualTo(Long.valueOf("10")).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isLessThanOrEqualTo(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isLessThanOrEqualTo(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isLessThanOrEqualTo(Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null).isLessThanOrEqualTo(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 1L).isLessThanOrEqualTo(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longAssertion(), 1L, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longAssertion(), 11L).isLessThanOrEqualTo(Long.valueOf("10"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<10L> but was:<11L>");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").isLessThanOrEqualTo(Long.valueOf("10"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<10L> but was:<11L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isInRangePrimitiveTest() {
        initialize(Raw.longAssertion(), 5L).isInRange(4L, 6L);
        initialize(Raw.longAssertion(), 5L).isInRange(5L, 6L);
        initialize(Raw.longAssertion(), 5L).isInRange(1L, 10L);
        initialize(Raw.longAssertion(), 5L).isNotNull().isInRange(4L, 6L).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isInRange(1L, 1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isInRange(1L, 1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isInRange(1L, 1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isInRange(1L, 5L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<1L:5L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isInRange(1L, 5L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<1L:5L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isInRange(6L, 10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<6L:10L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isInRange(6L, 10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<6L:10L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isInRange(8L, 9L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<8L:9L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isInRange(8L, 9L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<8L:9L> but was:<5L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isInRangeObjectTest() {
        initialize(Raw.longAssertion(), 5L).isInRange(Long.valueOf("4"), Long.valueOf("6"));
        initialize(Raw.longAssertion(), 5L).isInRange(Long.valueOf("5"), Long.valueOf("6"));
        initialize(Raw.longAssertion(), 5L).isInRange(Long.valueOf("1"), Long.valueOf("10"));
        initialize(Raw.longAssertion(), 5L).isNotNull().isInRange(Long.valueOf("4"), Long.valueOf("6")).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isInRange(Long.valueOf("1"), Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isInRange(Long.valueOf("1"), Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isInRange(Long.valueOf("1"), Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null).isInRange(null, Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isInRange(null, Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 1L).isInRange(null, Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.longAssertion(), 1L, "Message").isInRange(null, Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.longAssertion(), 1L).isInRange(null, null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.longAssertion(), 1L, "Message").isInRange(null, null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.longAssertion(), 1L).isInRange(Long.valueOf("1"), null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.longAssertion(), 1L, "Message").isInRange(Long.valueOf("1"), null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isInRange(Long.valueOf("1"), Long.valueOf("5"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<1L:5L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isInRange(Long.valueOf("1"), Long.valueOf("5"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<1L:5L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isInRange(Long.valueOf("6"), Long.valueOf("10"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<6L:10L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isInRange(Long.valueOf("6"), Long.valueOf("10"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<6L:10L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isInRange(Long.valueOf("8"), Long.valueOf("9"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<8L:9L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isInRange(Long.valueOf("8"), Long.valueOf("9"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<8L:9L> but was:<5L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isNotInRangePrimitiveTest() {
        initialize(Raw.longAssertion(), 5L).isNotInRange(1L, 5L);
        initialize(Raw.longAssertion(), 5L).isNotInRange(6L, 10L);
        initialize(Raw.longAssertion(), 5L).isNotInRange(8L, 9L);
        initialize(Raw.longAssertion(), 5L).isNotNull().isNotInRange(1L, 5L).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isNotInRange(1L, 1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isNotInRange(1L, 1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isNotInRange(1L, 1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isNotInRange(4L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<4L:6L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isNotInRange(4L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<4L:6L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isNotInRange(5L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<5L:6L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isNotInRange(5L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<5L:6L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isNotInRange(1L, 10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<1L:10L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isNotInRange(1L, 10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<1L:10L> but was:<5L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isNotInRangeObjectTest() {
        initialize(Raw.longAssertion(), 5L).isNotInRange(Long.valueOf("1"), Long.valueOf("5"));
        initialize(Raw.longAssertion(), 5L).isNotInRange(Long.valueOf("6"), Long.valueOf("10"));
        initialize(Raw.longAssertion(), 5L).isNotInRange(Long.valueOf("8"), Long.valueOf("9"));
        initialize(Raw.longAssertion(), 5L).isNotNull().isNotInRange(Long.valueOf("1"), Long.valueOf("5")).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().isNotInRange(Long.valueOf("1"), Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isNotInRange(Long.valueOf("1"), Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isNotInRange(Long.valueOf("1"), Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null).isNotInRange(null, Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isNotInRange(null, Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 1L).isNotInRange(null, Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.longAssertion(), 1L, "Message").isNotInRange(null, Long.valueOf("1"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.longAssertion(), 1L).isNotInRange(null, null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.longAssertion(), 1L, "Message").isNotInRange(null, null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.longAssertion(), 1L).isNotInRange(Long.valueOf("1"), null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.longAssertion(), 1L, "Message").isNotInRange(Long.valueOf("1"), null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isNotInRange(Long.valueOf("4"), Long.valueOf("6"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<4L:6L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isNotInRange(Long.valueOf("4"), Long.valueOf("6"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<4L:6L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isNotInRange(Long.valueOf("5"), Long.valueOf("6"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<5L:6L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isNotInRange(Long.valueOf("5"), Long.valueOf("6"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<5L:6L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isNotInRange(Long.valueOf("1"), Long.valueOf("10"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<1L:10L> but was:<5L>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isNotInRange(Long.valueOf("1"), Long.valueOf("10"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<1L:10L> but was:<5L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        initialize(Raw.longAssertion(), 0L).toHexString().isEqualTo("0000000000000000");
        initialize(Raw.longAssertion(), 1L).toHexString().isEqualTo("0000000000000001");
        initialize(Raw.longAssertion(), 31L).toHexString().isEqualTo("000000000000001f");
        initialize(Raw.longAssertion(), 50L).toHexString().isEqualTo("0000000000000032");
        initialize(Raw.longAssertion(), 100L).toHexString().isEqualTo("0000000000000064");
        initialize(Raw.longAssertion(), 479L).toHexString().isEqualTo("00000000000001df");
        initialize(Raw.longAssertion(), 7311L).toHexString().isEqualTo("0000000000001c8f");
        initialize(Raw.longAssertion(), 102351L).toHexString().isEqualTo("0000000000018fcf");
        initialize(Raw.longAssertion(), 1300879L).toHexString().isEqualTo("000000000013d98f");
        initialize(Raw.longAssertion(), 26461823L).toHexString().isEqualTo("000000000193c67f");
        initialize(Raw.longAssertion(), 5663606399L).toHexString().isEqualTo("000000015193c67f");
        initialize(Raw.longAssertion(), 1998528431743L).toHexString().isEqualTo("000001d15193c67f");
        initialize(Raw.longAssertion(), 459395365586559L).toHexString().isEqualTo("0001a1d15193c67f");
        initialize(Raw.longAssertion(), 78149847602153087L).toHexString().isEqualTo("0115a4df5193c67f");
        initialize(Raw.longAssertion(), Long.MAX_VALUE).toHexString().isEqualTo("7fffffffffffffff");
        initialize(Raw.longAssertion(), -1L).toHexString().isEqualTo("ffffffffffffffff");
        initialize(Raw.longAssertion(), Long.MIN_VALUE).toHexString().isEqualTo("8000000000000000");
        initialize(Raw.longAssertion(), 31L).isNotNull().toHexString().isEqualTo("000000000000001f");

        try {
            Raw.longAssertion().toHexString();
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).toHexString();
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").toHexString();
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longAssertion(), 11L).toHexString()).isEqualTo("0000000000000011");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longAssertion(), 11L, "Message").toHexString()).isEqualTo("0000000000000011");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 11L).toHexString().isEqualTo("0000000000000011");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000011> but was:<000000000000000b>");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").toHexString().isEqualTo("0000000000000011");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000011> but was:<000000000000000b>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.longAssertion(), 0L).toHexString(Matchers.is(Matchers.equalTo("0000000000000000")));
        initialize(Raw.longAssertion(), 1L).toHexString(Matchers.is(Matchers.equalTo("0000000000000001")));
        initialize(Raw.longAssertion(), 31L).toHexString(Matchers.is(Matchers.equalTo("000000000000001f")));
        initialize(Raw.longAssertion(), 50L).toHexString(Matchers.is(Matchers.equalTo("0000000000000032")));
        initialize(Raw.longAssertion(), 100L).toHexString(Matchers.is(Matchers.equalTo("0000000000000064")));
        initialize(Raw.longAssertion(), 479L).toHexString(Matchers.is(Matchers.equalTo("00000000000001df")));
        initialize(Raw.longAssertion(), 7311L).toHexString(Matchers.is(Matchers.equalTo("0000000000001c8f")));
        initialize(Raw.longAssertion(), 102351L).toHexString(Matchers.is(Matchers.equalTo("0000000000018fcf")));
        initialize(Raw.longAssertion(), 1300879L).toHexString(Matchers.is(Matchers.equalTo("000000000013d98f")));
        initialize(Raw.longAssertion(), 26461823L).toHexString(Matchers.is(Matchers.equalTo("000000000193c67f")));
        initialize(Raw.longAssertion(), 5663606399L).toHexString(Matchers.is(Matchers.equalTo("000000015193c67f")));
        initialize(Raw.longAssertion(), 1998528431743L).toHexString(Matchers.is(Matchers.equalTo("000001d15193c67f")));
        initialize(Raw.longAssertion(), 459395365586559L).toHexString(Matchers.is(Matchers.equalTo("0001a1d15193c67f")));
        initialize(Raw.longAssertion(), 78149847602153087L).toHexString(Matchers.is(Matchers.equalTo("0115a4df5193c67f")));
        initialize(Raw.longAssertion(), Long.MAX_VALUE).toHexString(Matchers.is(Matchers.equalTo("7fffffffffffffff")));
        initialize(Raw.longAssertion(), -1L).toHexString(Matchers.is(Matchers.equalTo("ffffffffffffffff")));
        initialize(Raw.longAssertion(), Long.MIN_VALUE).toHexString(Matchers.is(Matchers.equalTo("8000000000000000")));
        initialize(Raw.longAssertion(), 31L).isNotNull().toHexString(Matchers.is(Matchers.equalTo("000000000000001f"))).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().toHexString(Matchers.equalTo("0"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).toHexString(Matchers.equalTo("0"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").toHexString(Matchers.equalTo("0"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null).toHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").toHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 1L).toHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longAssertion(), 1L, "Message").toHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longAssertion(), 11L).toHexString(Matchers.equalTo("0000000000000011"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0000000000000011\"\n     but: was \"000000000000000b\"");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").toHexString(Matchers.equalTo("0000000000000011"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0000000000000011\"\n     but: was \"000000000000000b\"");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.longAssertion(), 0L).hasHexString("0000000000000000");
        initialize(Raw.longAssertion(), 1L).hasHexString("0000000000000001");
        initialize(Raw.longAssertion(), 31L).hasHexString("000000000000001f");
        initialize(Raw.longAssertion(), 50L).hasHexString("0000000000000032");
        initialize(Raw.longAssertion(), 100L).hasHexString("0000000000000064");
        initialize(Raw.longAssertion(), 479L).hasHexString("00000000000001df");
        initialize(Raw.longAssertion(), 7311L).hasHexString("0000000000001c8f");
        initialize(Raw.longAssertion(), 102351L).hasHexString("0000000000018fcf");
        initialize(Raw.longAssertion(), 1300879L).hasHexString("000000000013d98f");
        initialize(Raw.longAssertion(), 26461823L).hasHexString("000000000193c67f");
        initialize(Raw.longAssertion(), 5663606399L).hasHexString("000000015193c67f");
        initialize(Raw.longAssertion(), 1998528431743L).hasHexString("000001d15193c67f");
        initialize(Raw.longAssertion(), 459395365586559L).hasHexString("0001a1d15193c67f");
        initialize(Raw.longAssertion(), 78149847602153087L).hasHexString("0115a4df5193c67f");
        initialize(Raw.longAssertion(), Long.MAX_VALUE).hasHexString("7fffffffffffffff");
        initialize(Raw.longAssertion(), -1L).hasHexString("ffffffffffffffff");
        initialize(Raw.longAssertion(), Long.MIN_VALUE).hasHexString("8000000000000000");
        initialize(Raw.longAssertion(), 31L).isNotNull().hasHexString("000000000000001f").isInstanceOf(Long.class);

        try {
            Raw.longAssertion().hasHexString("0");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).hasHexString("0");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").hasHexString("0");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null).hasHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").hasHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 11L).hasHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").hasHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longAssertion(), 11L).hasHexString("0000000000000011");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000011> but was:<000000000000000b>");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").hasHexString("0000000000000011");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000011> but was:<000000000000000b>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.longAssertion(), null).isNull();

        try {
            initialize(Raw.longAssertion(), 10L).isNull();
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<10L>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isNull();
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<10L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Long value = 10000L;
        initialize(Raw.longAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.longAssertion(), value).isSameAs(10000L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<10000L> but was:<10000L>");
        }
        try {
            initialize(Raw.longAssertion(), value, "Message").isSameAs(10000L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<10000L> but was:<10000L>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Long value = 10000L;
        initialize(Raw.longAssertion(), value).isNotSameAs(10000L);

        try {
            initialize(Raw.longAssertion(), value).isNotSameAs(value);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<10000L>");
        }
        try {
            initialize(Raw.longAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<10000L>");
        }
    }

}
