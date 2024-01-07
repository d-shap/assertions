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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link IntAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntAssertionTest() {
        super();
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.intAssertion(), 10);

        try {
            initializeWithRawActual(Raw.intAssertion(), new Object());
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Integer> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.intAssertion(), new Object(), "Message");
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Integer> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isEqualToPrimitiveTest() {
        initialize(Raw.intAssertion(), 10).isEqualTo(10);
        initialize(Raw.intAssertion(), 75).isEqualTo(75);
        initialize(Raw.intAssertion(), 236).isEqualTo(236);
        initialize(Raw.intAssertion(), 257).isEqualTo(257);
        initialize(Raw.intAssertion(), 10).isNotNull().isEqualTo(10).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isEqualTo(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).isEqualTo(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isEqualTo(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 10).isEqualTo(20);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<20> but was:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 10, "Message").isEqualTo(20);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<20> but was:<10>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isEqualToObjectTest() {
        initialize(Raw.intAssertion(), null).isEqualTo(null);
        initialize(Raw.intAssertion(), 10).isEqualTo(Integer.valueOf("10"));
        initialize(Raw.intAssertion(), 75).isEqualTo(Integer.valueOf("75"));
        initialize(Raw.intAssertion(), 236).isEqualTo(Integer.valueOf("236"));
        initialize(Raw.intAssertion(), 257).isEqualTo(Integer.valueOf("257"));
        initialize(Raw.intAssertion(), 10).isNotNull().isEqualTo(Integer.valueOf("10")).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isEqualTo(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).isEqualTo(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isEqualTo(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 1).isEqualTo(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.intAssertion(), 1, "Message").isEqualTo(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.intAssertion(), 10).isEqualTo(Integer.valueOf("20"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<20> but was:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 10, "Message").isEqualTo(Integer.valueOf("20"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<20> but was:<10>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isNotEqualToPrimitiveTest() {
        initialize(Raw.intAssertion(), null).isNotEqualTo(1);
        initialize(Raw.intAssertion(), 10).isNotEqualTo(15);
        initialize(Raw.intAssertion(), 75).isNotEqualTo(76);
        initialize(Raw.intAssertion(), 236).isNotEqualTo(143);
        initialize(Raw.intAssertion(), 257).isNotEqualTo(2);
        initialize(Raw.intAssertion(), 10).isNotNull().isNotEqualTo(15).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isNotEqualTo(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), 10).isNotEqualTo(10);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 10, "Message").isNotEqualTo(10);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isNotEqualToObjectTest() {
        initialize(Raw.intAssertion(), null).isNotEqualTo(Integer.valueOf("1"));
        initialize(Raw.intAssertion(), 1).isNotEqualTo(null);
        initialize(Raw.intAssertion(), 10).isNotEqualTo(Integer.valueOf("15"));
        initialize(Raw.intAssertion(), 75).isNotEqualTo(Integer.valueOf("76"));
        initialize(Raw.intAssertion(), 236).isNotEqualTo(Integer.valueOf("143"));
        initialize(Raw.intAssertion(), 257).isNotEqualTo(Integer.valueOf("2"));
        initialize(Raw.intAssertion(), 10).isNotNull().isNotEqualTo(Integer.valueOf("15")).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isNotEqualTo(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).isNotEqualTo(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 10).isNotEqualTo(Integer.valueOf("10"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 10, "Message").isNotEqualTo(Integer.valueOf("10"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isGreaterThanPrimitiveTest() {
        initialize(Raw.intAssertion(), 10).isGreaterThan(5);
        initialize(Raw.intAssertion(), 60).isGreaterThan(30);
        initialize(Raw.intAssertion(), 245).isGreaterThan(244);
        initialize(Raw.intAssertion(), 10).isNotNull().isGreaterThan(5).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isGreaterThan(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).isGreaterThan(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isGreaterThan(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 10).isGreaterThan(10);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<10> but was:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 10, "Message").isGreaterThan(10);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<10> but was:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 10).isGreaterThan(11);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<11> but was:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 10, "Message").isGreaterThan(11);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<11> but was:<10>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isGreaterThanObjectTest() {
        initialize(Raw.intAssertion(), 10).isGreaterThan(Integer.valueOf("5"));
        initialize(Raw.intAssertion(), 60).isGreaterThan(Integer.valueOf("30"));
        initialize(Raw.intAssertion(), 245).isGreaterThan(Integer.valueOf("244"));
        initialize(Raw.intAssertion(), 10).isNotNull().isGreaterThan(Integer.valueOf("5")).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isGreaterThan(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).isGreaterThan(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isGreaterThan(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null).isGreaterThan(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isGreaterThan(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 1).isGreaterThan(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intAssertion(), 1, "Message").isGreaterThan(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intAssertion(), 10).isGreaterThan(Integer.valueOf("10"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<10> but was:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 10, "Message").isGreaterThan(Integer.valueOf("10"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<10> but was:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 10).isGreaterThan(Integer.valueOf("11"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<11> but was:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 10, "Message").isGreaterThan(Integer.valueOf("11"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<11> but was:<10>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToPrimitiveTest() {
        initialize(Raw.intAssertion(), 10).isGreaterThanOrEqualTo(5);
        initialize(Raw.intAssertion(), 60).isGreaterThanOrEqualTo(60);
        initialize(Raw.intAssertion(), 245).isGreaterThanOrEqualTo(244);
        initialize(Raw.intAssertion(), 10).isNotNull().isGreaterThanOrEqualTo(5).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isGreaterThanOrEqualTo(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).isGreaterThanOrEqualTo(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isGreaterThanOrEqualTo(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 10).isGreaterThanOrEqualTo(11);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<11> but was:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 10, "Message").isGreaterThanOrEqualTo(11);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<11> but was:<10>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToObjectTest() {
        initialize(Raw.intAssertion(), 10).isGreaterThanOrEqualTo(Integer.valueOf("5"));
        initialize(Raw.intAssertion(), 60).isGreaterThanOrEqualTo(Integer.valueOf("60"));
        initialize(Raw.intAssertion(), 245).isGreaterThanOrEqualTo(Integer.valueOf("244"));
        initialize(Raw.intAssertion(), 10).isNotNull().isGreaterThanOrEqualTo(Integer.valueOf("5")).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isGreaterThanOrEqualTo(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).isGreaterThanOrEqualTo(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isGreaterThanOrEqualTo(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null).isGreaterThanOrEqualTo(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 1).isGreaterThanOrEqualTo(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intAssertion(), 1, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intAssertion(), 10).isGreaterThanOrEqualTo(Integer.valueOf("11"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<11> but was:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 10, "Message").isGreaterThanOrEqualTo(Integer.valueOf("11"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<11> but was:<10>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isLessThanPrimitiveTest() {
        initialize(Raw.intAssertion(), 5).isLessThan(10);
        initialize(Raw.intAssertion(), 30).isLessThan(60);
        initialize(Raw.intAssertion(), 244).isLessThan(245);
        initialize(Raw.intAssertion(), 5).isNotNull().isLessThan(10).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isLessThan(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).isLessThan(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isLessThan(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 10).isLessThan(10);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10> but was:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 10, "Message").isLessThan(10);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10> but was:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 11).isLessThan(10);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10> but was:<11>");
        }
        try {
            initialize(Raw.intAssertion(), 11, "Message").isLessThan(10);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10> but was:<11>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isLessThanObjectTest() {
        initialize(Raw.intAssertion(), 5).isLessThan(Integer.valueOf("10"));
        initialize(Raw.intAssertion(), 30).isLessThan(Integer.valueOf("60"));
        initialize(Raw.intAssertion(), 244).isLessThan(Integer.valueOf("245"));
        initialize(Raw.intAssertion(), 5).isNotNull().isLessThan(Integer.valueOf("10")).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isLessThan(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).isLessThan(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isLessThan(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null).isLessThan(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isLessThan(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 1).isLessThan(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intAssertion(), 1, "Message").isLessThan(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intAssertion(), 10).isLessThan(Integer.valueOf("10"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10> but was:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 10, "Message").isLessThan(Integer.valueOf("10"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10> but was:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 11).isLessThan(Integer.valueOf("10"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10> but was:<11>");
        }
        try {
            initialize(Raw.intAssertion(), 11, "Message").isLessThan(Integer.valueOf("10"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10> but was:<11>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToPrimitiveTest() {
        initialize(Raw.intAssertion(), 5).isLessThanOrEqualTo(10);
        initialize(Raw.intAssertion(), 60).isLessThanOrEqualTo(60);
        initialize(Raw.intAssertion(), 244).isLessThanOrEqualTo(245);
        initialize(Raw.intAssertion(), 5).isNotNull().isLessThanOrEqualTo(10).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isLessThanOrEqualTo(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).isLessThanOrEqualTo(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isLessThanOrEqualTo(1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 11).isLessThanOrEqualTo(10);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<10> but was:<11>");
        }
        try {
            initialize(Raw.intAssertion(), 11, "Message").isLessThanOrEqualTo(10);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<10> but was:<11>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToObjectTest() {
        initialize(Raw.intAssertion(), 5).isLessThanOrEqualTo(Integer.valueOf("10"));
        initialize(Raw.intAssertion(), 60).isLessThanOrEqualTo(Integer.valueOf("60"));
        initialize(Raw.intAssertion(), 244).isLessThanOrEqualTo(Integer.valueOf("245"));
        initialize(Raw.intAssertion(), 5).isNotNull().isLessThanOrEqualTo(Integer.valueOf("10")).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isLessThanOrEqualTo(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).isLessThanOrEqualTo(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isLessThanOrEqualTo(Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null).isLessThanOrEqualTo(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isLessThanOrEqualTo(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 1).isLessThanOrEqualTo(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intAssertion(), 1, "Message").isLessThanOrEqualTo(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intAssertion(), 11).isLessThanOrEqualTo(Integer.valueOf("10"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<10> but was:<11>");
        }
        try {
            initialize(Raw.intAssertion(), 11, "Message").isLessThanOrEqualTo(Integer.valueOf("10"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<10> but was:<11>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isInRangePrimitiveTest() {
        initialize(Raw.intAssertion(), 5).isInRange(4, 6);
        initialize(Raw.intAssertion(), 5).isInRange(5, 6);
        initialize(Raw.intAssertion(), 5).isInRange(1, 10);
        initialize(Raw.intAssertion(), 5).isNotNull().isInRange(4, 6).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isInRange(1, 1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).isInRange(1, 1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isInRange(1, 1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 5).isInRange(1, 5);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<1:5> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5, "Message").isInRange(1, 5);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<1:5> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5).isInRange(6, 10);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<6:10> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5, "Message").isInRange(6, 10);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<6:10> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5).isInRange(8, 9);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<8:9> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5, "Message").isInRange(8, 9);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<8:9> but was:<5>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isInRangeObjectTest() {
        initialize(Raw.intAssertion(), 5).isInRange(Integer.valueOf("4"), Integer.valueOf("6"));
        initialize(Raw.intAssertion(), 5).isInRange(Integer.valueOf("5"), Integer.valueOf("6"));
        initialize(Raw.intAssertion(), 5).isInRange(Integer.valueOf("1"), Integer.valueOf("10"));
        initialize(Raw.intAssertion(), 5).isNotNull().isInRange(Integer.valueOf("4"), Integer.valueOf("6")).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isInRange(Integer.valueOf("1"), Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).isInRange(Integer.valueOf("1"), Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isInRange(Integer.valueOf("1"), Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null).isInRange(null, Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isInRange(null, Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 1).isInRange(null, Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.intAssertion(), 1, "Message").isInRange(null, Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.intAssertion(), 1).isInRange(null, null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.intAssertion(), 1, "Message").isInRange(null, null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.intAssertion(), 1).isInRange(Integer.valueOf("1"), null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.intAssertion(), 1, "Message").isInRange(Integer.valueOf("1"), null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.intAssertion(), 5).isInRange(Integer.valueOf("1"), Integer.valueOf("5"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<1:5> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5, "Message").isInRange(Integer.valueOf("1"), Integer.valueOf("5"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<1:5> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5).isInRange(Integer.valueOf("6"), Integer.valueOf("10"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<6:10> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5, "Message").isInRange(Integer.valueOf("6"), Integer.valueOf("10"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<6:10> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5).isInRange(Integer.valueOf("8"), Integer.valueOf("9"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<8:9> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5, "Message").isInRange(Integer.valueOf("8"), Integer.valueOf("9"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<8:9> but was:<5>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isNotInRangePrimitiveTest() {
        initialize(Raw.intAssertion(), 5).isNotInRange(1, 5);
        initialize(Raw.intAssertion(), 5).isNotInRange(6, 10);
        initialize(Raw.intAssertion(), 5).isNotInRange(8, 9);
        initialize(Raw.intAssertion(), 5).isNotNull().isNotInRange(1, 5).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isNotInRange(1, 1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).isNotInRange(1, 1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isNotInRange(1, 1);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 5).isNotInRange(4, 6);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<4:6> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5, "Message").isNotInRange(4, 6);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<4:6> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5).isNotInRange(5, 6);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<5:6> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5, "Message").isNotInRange(5, 6);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<5:6> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5).isNotInRange(1, 10);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<1:10> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5, "Message").isNotInRange(1, 10);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<1:10> but was:<5>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isNotInRangeObjectTest() {
        initialize(Raw.intAssertion(), 5).isNotInRange(Integer.valueOf("1"), Integer.valueOf("5"));
        initialize(Raw.intAssertion(), 5).isNotInRange(Integer.valueOf("6"), Integer.valueOf("10"));
        initialize(Raw.intAssertion(), 5).isNotInRange(Integer.valueOf("8"), Integer.valueOf("9"));
        initialize(Raw.intAssertion(), 5).isNotNull().isNotInRange(Integer.valueOf("1"), Integer.valueOf("5")).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().isNotInRange(Integer.valueOf("1"), Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).isNotInRange(Integer.valueOf("1"), Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isNotInRange(Integer.valueOf("1"), Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null).isNotInRange(null, Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").isNotInRange(null, Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 1).isNotInRange(null, Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.intAssertion(), 1, "Message").isNotInRange(null, Integer.valueOf("1"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.intAssertion(), 1).isNotInRange(null, null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.intAssertion(), 1, "Message").isNotInRange(null, null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.intAssertion(), 1).isNotInRange(Integer.valueOf("1"), null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.intAssertion(), 1, "Message").isNotInRange(Integer.valueOf("1"), null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.intAssertion(), 5).isNotInRange(Integer.valueOf("4"), Integer.valueOf("6"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<4:6> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5, "Message").isNotInRange(Integer.valueOf("4"), Integer.valueOf("6"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<4:6> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5).isNotInRange(Integer.valueOf("5"), Integer.valueOf("6"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<5:6> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5, "Message").isNotInRange(Integer.valueOf("5"), Integer.valueOf("6"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<5:6> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5).isNotInRange(Integer.valueOf("1"), Integer.valueOf("10"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<1:10> but was:<5>");
        }
        try {
            initialize(Raw.intAssertion(), 5, "Message").isNotInRange(Integer.valueOf("1"), Integer.valueOf("10"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<1:10> but was:<5>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.intAssertion(), null).isNull();

        try {
            initialize(Raw.intAssertion(), 10).isNull();
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<10>");
        }
        try {
            initialize(Raw.intAssertion(), 10, "Message").isNull();
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<10>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Integer value = 10000;
        initialize(Raw.intAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.intAssertion(), value).isSameAs(10000);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<10000> but was:<10000>");
        }
        try {
            initialize(Raw.intAssertion(), value, "Message").isSameAs(10000);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<10000> but was:<10000>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Integer value = 10000;
        initialize(Raw.intAssertion(), value).isNotSameAs(10000);

        try {
            initialize(Raw.intAssertion(), value).isNotSameAs(value);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<10000>");
        }
        try {
            initialize(Raw.intAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<10000>");
        }
    }

}
