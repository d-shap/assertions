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
 * Tests for {@link ShortAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ShortAssertionTest() {
        super();
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.shortAssertion(), (short) 10);

        try {
            initializeWithRawActual(Raw.shortAssertion(), new Object());
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Short> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.shortAssertion(), new Object(), "Message");
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Short> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isEqualToPrimitiveTest() {
        initialize(Raw.shortAssertion(), (short) 10).isEqualTo(10);
        initialize(Raw.shortAssertion(), (short) 75).isEqualTo(75);
        initialize(Raw.shortAssertion(), (short) 236).isEqualTo(236);
        initialize(Raw.shortAssertion(), (short) 257).isEqualTo(257);

        try {
            Raw.shortAssertion().isEqualTo(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isEqualTo(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isEqualTo(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isEqualTo(20);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<20s> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isEqualTo(20);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<20s> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isEqualTo(1000000);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<1000000> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isEqualTo(1000000);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<1000000> but was:<10s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isEqualToObjectTest() {
        initialize(Raw.shortAssertion(), null).isEqualTo(null);
        initialize(Raw.shortAssertion(), (short) 10).isEqualTo(Short.valueOf("10"));
        initialize(Raw.shortAssertion(), (short) 75).isEqualTo(Short.valueOf("75"));
        initialize(Raw.shortAssertion(), (short) 236).isEqualTo(Short.valueOf("236"));
        initialize(Raw.shortAssertion(), (short) 257).isEqualTo(Short.valueOf("257"));

        try {
            Raw.shortAssertion().isEqualTo(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isEqualTo(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isEqualTo(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1).isEqualTo(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<1s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1, "Message").isEqualTo(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<1s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isEqualTo(Short.valueOf("20"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<20s> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isEqualTo(Short.valueOf("20"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<20s> but was:<10s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isNotEqualToPrimitiveTest() {
        initialize(Raw.shortAssertion(), null).isNotEqualTo(1);
        initialize(Raw.shortAssertion(), (short) 10).isNotEqualTo(15);
        initialize(Raw.shortAssertion(), (short) 75).isNotEqualTo(76);
        initialize(Raw.shortAssertion(), (short) 236).isNotEqualTo(143);
        initialize(Raw.shortAssertion(), (short) 257).isNotEqualTo(2);

        try {
            Raw.shortAssertion().isNotEqualTo(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isNotEqualTo(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isNotEqualTo(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isNotEqualToObjectTest() {
        initialize(Raw.shortAssertion(), null).isNotEqualTo(Short.valueOf("1"));
        initialize(Raw.shortAssertion(), (short) 1).isNotEqualTo(null);
        initialize(Raw.shortAssertion(), (short) 10).isNotEqualTo(Short.valueOf("15"));
        initialize(Raw.shortAssertion(), (short) 75).isNotEqualTo(Short.valueOf("76"));
        initialize(Raw.shortAssertion(), (short) 236).isNotEqualTo(Short.valueOf("143"));
        initialize(Raw.shortAssertion(), (short) 257).isNotEqualTo(Short.valueOf("2"));

        try {
            Raw.shortAssertion().isNotEqualTo(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isNotEqualTo(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isNotEqualTo(Short.valueOf("10"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isNotEqualTo(Short.valueOf("10"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isGreaterThanPrimitiveTest() {
        initialize(Raw.shortAssertion(), (short) 10).isGreaterThan(5);
        initialize(Raw.shortAssertion(), (short) 60).isGreaterThan(30);
        initialize(Raw.shortAssertion(), (short) 245).isGreaterThan(244);

        try {
            Raw.shortAssertion().isGreaterThan(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isGreaterThan(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isGreaterThan(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isGreaterThan(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<10s> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isGreaterThan(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<10s> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isGreaterThan(11);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<11s> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isGreaterThan(11);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<11s> but was:<10s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isGreaterThanObjectTest() {
        initialize(Raw.shortAssertion(), (short) 10).isGreaterThan(Short.valueOf("5"));
        initialize(Raw.shortAssertion(), (short) 60).isGreaterThan(Short.valueOf("30"));
        initialize(Raw.shortAssertion(), (short) 245).isGreaterThan(Short.valueOf("244"));

        try {
            Raw.shortAssertion().isGreaterThan(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isGreaterThan(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isGreaterThan(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isGreaterThan(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isGreaterThan(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1).isGreaterThan(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1, "Message").isGreaterThan(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isGreaterThan(Short.valueOf("10"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<10s> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isGreaterThan(Short.valueOf("10"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<10s> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isGreaterThan(Short.valueOf("11"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<11s> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isGreaterThan(Short.valueOf("11"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<11s> but was:<10s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToPrimitiveTest() {
        initialize(Raw.shortAssertion(), (short) 10).isGreaterThanOrEqualTo(5);
        initialize(Raw.shortAssertion(), (short) 60).isGreaterThanOrEqualTo(60);
        initialize(Raw.shortAssertion(), (short) 245).isGreaterThanOrEqualTo(244);

        try {
            Raw.shortAssertion().isGreaterThanOrEqualTo(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isGreaterThanOrEqualTo(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isGreaterThanOrEqualTo(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isGreaterThanOrEqualTo(11);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<11s> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isGreaterThanOrEqualTo(11);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<11s> but was:<10s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToObjectTest() {
        initialize(Raw.shortAssertion(), (short) 10).isGreaterThanOrEqualTo(Short.valueOf("5"));
        initialize(Raw.shortAssertion(), (short) 60).isGreaterThanOrEqualTo(Short.valueOf("60"));
        initialize(Raw.shortAssertion(), (short) 245).isGreaterThanOrEqualTo(Short.valueOf("244"));

        try {
            Raw.shortAssertion().isGreaterThanOrEqualTo(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isGreaterThanOrEqualTo(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isGreaterThanOrEqualTo(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isGreaterThanOrEqualTo(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1).isGreaterThanOrEqualTo(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isGreaterThanOrEqualTo(Short.valueOf("11"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<11s> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isGreaterThanOrEqualTo(Short.valueOf("11"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<11s> but was:<10s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isLessThanPrimitiveTest() {
        initialize(Raw.shortAssertion(), (short) 5).isLessThan(10);
        initialize(Raw.shortAssertion(), (short) 30).isLessThan(60);
        initialize(Raw.shortAssertion(), (short) 244).isLessThan(245);

        try {
            Raw.shortAssertion().isLessThan(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isLessThan(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isLessThan(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isLessThan(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10s> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isLessThan(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10s> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11).isLessThan(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10s> but was:<11s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11, "Message").isLessThan(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10s> but was:<11s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isLessThanObjectTest() {
        initialize(Raw.shortAssertion(), (short) 5).isLessThan(Short.valueOf("10"));
        initialize(Raw.shortAssertion(), (short) 30).isLessThan(Short.valueOf("60"));
        initialize(Raw.shortAssertion(), (short) 244).isLessThan(Short.valueOf("245"));

        try {
            Raw.shortAssertion().isLessThan(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isLessThan(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isLessThan(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isLessThan(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isLessThan(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1).isLessThan(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1, "Message").isLessThan(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isLessThan(Short.valueOf("10"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10s> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isLessThan(Short.valueOf("10"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10s> but was:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11).isLessThan(Short.valueOf("10"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10s> but was:<11s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11, "Message").isLessThan(Short.valueOf("10"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10s> but was:<11s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToPrimitiveTest() {
        initialize(Raw.shortAssertion(), (short) 5).isLessThanOrEqualTo(10);
        initialize(Raw.shortAssertion(), (short) 60).isLessThanOrEqualTo(60);
        initialize(Raw.shortAssertion(), (short) 244).isLessThanOrEqualTo(245);

        try {
            Raw.shortAssertion().isLessThanOrEqualTo(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isLessThanOrEqualTo(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isLessThanOrEqualTo(1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11).isLessThanOrEqualTo(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<10s> but was:<11s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11, "Message").isLessThanOrEqualTo(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<10s> but was:<11s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToObjectTest() {
        initialize(Raw.shortAssertion(), (short) 5).isLessThanOrEqualTo(Short.valueOf("10"));
        initialize(Raw.shortAssertion(), (short) 60).isLessThanOrEqualTo(Short.valueOf("60"));
        initialize(Raw.shortAssertion(), (short) 244).isLessThanOrEqualTo(Short.valueOf("245"));

        try {
            Raw.shortAssertion().isLessThanOrEqualTo(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isLessThanOrEqualTo(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isLessThanOrEqualTo(Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isLessThanOrEqualTo(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1).isLessThanOrEqualTo(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11).isLessThanOrEqualTo(Short.valueOf("10"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<10s> but was:<11s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11, "Message").isLessThanOrEqualTo(Short.valueOf("10"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<10s> but was:<11s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isInRangePrimitiveTest() {
        initialize(Raw.shortAssertion(), (short) 5).isInRange(4, 6);
        initialize(Raw.shortAssertion(), (short) 5).isInRange(5, 6);
        initialize(Raw.shortAssertion(), (short) 5).isInRange(1, 10);

        try {
            Raw.shortAssertion().isInRange(1, 1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isInRange(1, 1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isInRange(1, 1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isInRange(1, 5);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<1s:5s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isInRange(1, 5);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<1s:5s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isInRange(6, 10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<6s:10s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isInRange(6, 10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<6s:10s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isInRange(8, 9);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<8s:9s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isInRange(8, 9);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<8s:9s> but was:<5s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isInRangeObjectTest() {
        initialize(Raw.shortAssertion(), (short) 5).isInRange(Short.valueOf("4"), Short.valueOf("6"));
        initialize(Raw.shortAssertion(), (short) 5).isInRange(Short.valueOf("5"), Short.valueOf("6"));
        initialize(Raw.shortAssertion(), (short) 5).isInRange(Short.valueOf("1"), Short.valueOf("10"));

        try {
            Raw.shortAssertion().isInRange(Short.valueOf("1"), Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isInRange(Short.valueOf("1"), Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isInRange(Short.valueOf("1"), Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isInRange(null, Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isInRange(null, Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1).isInRange(null, Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1, "Message").isInRange(null, Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1).isInRange(null, null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1, "Message").isInRange(null, null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1).isInRange(Short.valueOf("1"), null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1, "Message").isInRange(Short.valueOf("1"), null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isInRange(Short.valueOf("1"), Short.valueOf("5"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<1s:5s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isInRange(Short.valueOf("1"), Short.valueOf("5"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<1s:5s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isInRange(Short.valueOf("6"), Short.valueOf("10"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<6s:10s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isInRange(Short.valueOf("6"), Short.valueOf("10"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<6s:10s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isInRange(Short.valueOf("8"), Short.valueOf("9"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<8s:9s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isInRange(Short.valueOf("8"), Short.valueOf("9"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<8s:9s> but was:<5s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isNotInRangePrimitiveTest() {
        initialize(Raw.shortAssertion(), (short) 5).isNotInRange(1, 5);
        initialize(Raw.shortAssertion(), (short) 5).isNotInRange(6, 10);
        initialize(Raw.shortAssertion(), (short) 5).isNotInRange(8, 9);

        try {
            Raw.shortAssertion().isNotInRange(1, 1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isNotInRange(1, 1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isNotInRange(1, 1);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isNotInRange(4, 6);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<4s:6s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isNotInRange(4, 6);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<4s:6s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isNotInRange(5, 6);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<5s:6s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isNotInRange(5, 6);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<5s:6s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isNotInRange(1, 10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<1s:10s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isNotInRange(1, 10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<1s:10s> but was:<5s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isNotInRangeObjectTest() {
        initialize(Raw.shortAssertion(), (short) 5).isNotInRange(Short.valueOf("1"), Short.valueOf("5"));
        initialize(Raw.shortAssertion(), (short) 5).isNotInRange(Short.valueOf("6"), Short.valueOf("10"));
        initialize(Raw.shortAssertion(), (short) 5).isNotInRange(Short.valueOf("8"), Short.valueOf("9"));

        try {
            Raw.shortAssertion().isNotInRange(Short.valueOf("1"), Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isNotInRange(Short.valueOf("1"), Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isNotInRange(Short.valueOf("1"), Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isNotInRange(null, Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isNotInRange(null, Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1).isNotInRange(null, Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1, "Message").isNotInRange(null, Short.valueOf("1"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1).isNotInRange(null, null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1, "Message").isNotInRange(null, null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1).isNotInRange(Short.valueOf("1"), null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1, "Message").isNotInRange(Short.valueOf("1"), null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isNotInRange(Short.valueOf("4"), Short.valueOf("6"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<4s:6s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isNotInRange(Short.valueOf("4"), Short.valueOf("6"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<4s:6s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isNotInRange(Short.valueOf("5"), Short.valueOf("6"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<5s:6s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isNotInRange(Short.valueOf("5"), Short.valueOf("6"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<5s:6s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isNotInRange(Short.valueOf("1"), Short.valueOf("10"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<1s:10s> but was:<5s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isNotInRange(Short.valueOf("1"), Short.valueOf("10"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<1s:10s> but was:<5s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.shortAssertion(), null).isNull();

        try {
            initialize(Raw.shortAssertion(), (short) 10).isNull();
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<10s>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isNull();
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<10s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Short value = (short) 10000;
        initialize(Raw.shortAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.shortAssertion(), value).isSameAs((short) 10000);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<10000s> but was:<10000s>");
        }
        try {
            initialize(Raw.shortAssertion(), value, "Message").isSameAs((short) 10000);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<10000s> but was:<10000s>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Short value = (short) 10000;
        initialize(Raw.shortAssertion(), value).isNotSameAs((short) 10000);

        try {
            initialize(Raw.shortAssertion(), value).isNotSameAs(value);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<10000s>");
        }
        try {
            initialize(Raw.shortAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<10000s>");
        }
    }

}
