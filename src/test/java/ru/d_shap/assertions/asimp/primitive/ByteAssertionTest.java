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
 * Tests for {@link ByteAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteAssertionTest() {
        super();
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.byteAssertion(), (byte) 10);

        try {
            initializeWithRawActual(Raw.byteAssertion(), new Object());
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Byte> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.byteAssertion(), new Object(), "Message");
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Byte> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isEqualToPrimitiveTest() {
        initialize(Raw.byteAssertion(), (byte) 10).isEqualTo(10);
        initialize(Raw.byteAssertion(), (byte) 75).isEqualTo(75);
        initialize(Raw.byteAssertion(), (byte) 236).isEqualTo((byte) 236);
        initialize(Raw.byteAssertion(), (byte) 257).isEqualTo(1);
        initialize(Raw.byteAssertion(), (byte) 10).isNotNull().isEqualTo(10).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isEqualTo(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isEqualTo(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isEqualTo(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isEqualTo(20);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<20b> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isEqualTo(20);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<20b> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isEqualTo(130);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<130> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isEqualTo(130);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<130> but was:<10b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isEqualToObjectTest() {
        initialize(Raw.byteAssertion(), null).isEqualTo(null);
        initialize(Raw.byteAssertion(), (byte) 10).isEqualTo(Byte.valueOf("10"));
        initialize(Raw.byteAssertion(), (byte) 75).isEqualTo(Byte.valueOf("75"));
        initialize(Raw.byteAssertion(), (byte) 10).isNotNull().isEqualTo(Byte.valueOf("10")).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isEqualTo(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isEqualTo(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isEqualTo(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1).isEqualTo(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<1b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1, "Message").isEqualTo(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<1b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isEqualTo(Byte.valueOf("20"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<20b> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isEqualTo(Byte.valueOf("20"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<20b> but was:<10b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isNotEqualToPrimitiveTest() {
        initialize(Raw.byteAssertion(), null).isNotEqualTo(1);
        initialize(Raw.byteAssertion(), (byte) 10).isNotEqualTo(15);
        initialize(Raw.byteAssertion(), (byte) 75).isNotEqualTo(76);
        initialize(Raw.byteAssertion(), (byte) 236).isNotEqualTo(143);
        initialize(Raw.byteAssertion(), (byte) 257).isNotEqualTo(2);
        initialize(Raw.byteAssertion(), (byte) 10).isNotNull().isNotEqualTo(15).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isNotEqualTo(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isNotEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isNotEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isNotEqualToObjectTest() {
        initialize(Raw.byteAssertion(), null).isNotEqualTo(Byte.valueOf("1"));
        initialize(Raw.byteAssertion(), (byte) 1).isNotEqualTo(null);
        initialize(Raw.byteAssertion(), (byte) 10).isNotEqualTo(Byte.valueOf("15"));
        initialize(Raw.byteAssertion(), (byte) 75).isNotEqualTo(Byte.valueOf("76"));
        initialize(Raw.byteAssertion(), (byte) 10).isNotNull().isNotEqualTo(Byte.valueOf("15")).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isNotEqualTo(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isNotEqualTo(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isNotEqualTo(Byte.valueOf("10"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isNotEqualTo(Byte.valueOf("10"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isGreaterThanPrimitiveTest() {
        initialize(Raw.byteAssertion(), (byte) 10).isGreaterThan(5);
        initialize(Raw.byteAssertion(), (byte) 60).isGreaterThan(30);
        initialize(Raw.byteAssertion(), (byte) 245).isGreaterThan((byte) 244);
        initialize(Raw.byteAssertion(), (byte) 10).isNotNull().isGreaterThan(5).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isGreaterThan(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isGreaterThan(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isGreaterThan(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isGreaterThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<10b> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isGreaterThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<10b> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isGreaterThan(11);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<11b> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isGreaterThan(11);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<11b> but was:<10b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isGreaterThanObjectTest() {
        initialize(Raw.byteAssertion(), (byte) 10).isGreaterThan(Byte.valueOf("5"));
        initialize(Raw.byteAssertion(), (byte) 60).isGreaterThan(Byte.valueOf("30"));
        initialize(Raw.byteAssertion(), (byte) 10).isNotNull().isGreaterThan(Byte.valueOf("5")).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isGreaterThan(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isGreaterThan(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isGreaterThan(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isGreaterThan(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isGreaterThan(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1).isGreaterThan(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1, "Message").isGreaterThan(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isGreaterThan(Byte.valueOf("10"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<10b> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isGreaterThan(Byte.valueOf("10"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<10b> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isGreaterThan(Byte.valueOf("11"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<11b> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isGreaterThan(Byte.valueOf("11"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<11b> but was:<10b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToPrimitiveTest() {
        initialize(Raw.byteAssertion(), (byte) 10).isGreaterThanOrEqualTo(5);
        initialize(Raw.byteAssertion(), (byte) 60).isGreaterThanOrEqualTo(60);
        initialize(Raw.byteAssertion(), (byte) 245).isGreaterThanOrEqualTo((byte) 244);
        initialize(Raw.byteAssertion(), (byte) 10).isNotNull().isGreaterThanOrEqualTo(5).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isGreaterThanOrEqualTo(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isGreaterThanOrEqualTo(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isGreaterThanOrEqualTo(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isGreaterThanOrEqualTo(11);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<11b> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isGreaterThanOrEqualTo(11);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<11b> but was:<10b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToObjectTest() {
        initialize(Raw.byteAssertion(), (byte) 10).isGreaterThanOrEqualTo(Byte.valueOf("5"));
        initialize(Raw.byteAssertion(), (byte) 60).isGreaterThanOrEqualTo(Byte.valueOf("60"));
        initialize(Raw.byteAssertion(), (byte) 10).isNotNull().isGreaterThanOrEqualTo(Byte.valueOf("5")).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isGreaterThanOrEqualTo(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isGreaterThanOrEqualTo(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isGreaterThanOrEqualTo(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isGreaterThanOrEqualTo(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1).isGreaterThanOrEqualTo(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isGreaterThanOrEqualTo(Byte.valueOf("11"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<11b> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isGreaterThanOrEqualTo(Byte.valueOf("11"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<11b> but was:<10b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isLessThanPrimitiveTest() {
        initialize(Raw.byteAssertion(), (byte) 5).isLessThan(10);
        initialize(Raw.byteAssertion(), (byte) 30).isLessThan(60);
        initialize(Raw.byteAssertion(), (byte) 244).isLessThan(245);
        initialize(Raw.byteAssertion(), (byte) 5).isNotNull().isLessThan(10).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isLessThan(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isLessThan(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isLessThan(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isLessThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10b> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isLessThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10b> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11).isLessThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10b> but was:<11b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11, "Message").isLessThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10b> but was:<11b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isLessThanObjectTest() {
        initialize(Raw.byteAssertion(), (byte) 5).isLessThan(Byte.valueOf("10"));
        initialize(Raw.byteAssertion(), (byte) 30).isLessThan(Byte.valueOf("60"));
        initialize(Raw.byteAssertion(), (byte) 5).isNotNull().isLessThan(Byte.valueOf("10")).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isLessThan(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isLessThan(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isLessThan(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isLessThan(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isLessThan(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1).isLessThan(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1, "Message").isLessThan(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isLessThan(Byte.valueOf("10"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10b> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isLessThan(Byte.valueOf("10"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10b> but was:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11).isLessThan(Byte.valueOf("10"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10b> but was:<11b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11, "Message").isLessThan(Byte.valueOf("10"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10b> but was:<11b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToPrimitiveTest() {
        initialize(Raw.byteAssertion(), (byte) 5).isLessThanOrEqualTo(10);
        initialize(Raw.byteAssertion(), (byte) 60).isLessThanOrEqualTo(60);
        initialize(Raw.byteAssertion(), (byte) 244).isLessThanOrEqualTo(245);
        initialize(Raw.byteAssertion(), (byte) 5).isNotNull().isLessThanOrEqualTo(10).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isLessThanOrEqualTo(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isLessThanOrEqualTo(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isLessThanOrEqualTo(1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11).isLessThanOrEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<10b> but was:<11b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11, "Message").isLessThanOrEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<10b> but was:<11b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToObjectTest() {
        initialize(Raw.byteAssertion(), (byte) 5).isLessThanOrEqualTo(Byte.valueOf("10"));
        initialize(Raw.byteAssertion(), (byte) 60).isLessThanOrEqualTo(Byte.valueOf("60"));
        initialize(Raw.byteAssertion(), (byte) 5).isNotNull().isLessThanOrEqualTo(Byte.valueOf("10")).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isLessThanOrEqualTo(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isLessThanOrEqualTo(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isLessThanOrEqualTo(Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isLessThanOrEqualTo(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1).isLessThanOrEqualTo(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11).isLessThanOrEqualTo(Byte.valueOf("10"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<10b> but was:<11b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11, "Message").isLessThanOrEqualTo(Byte.valueOf("10"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<10b> but was:<11b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isInRangePrimitiveTest() {
        initialize(Raw.byteAssertion(), (byte) 5).isInRange(4, 6);
        initialize(Raw.byteAssertion(), (byte) 5).isInRange(5, 6);
        initialize(Raw.byteAssertion(), (byte) 5).isInRange(1, 10);
        initialize(Raw.byteAssertion(), (byte) 5).isNotNull().isInRange(4, 6).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isInRange(1, 1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isInRange(1, 1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isInRange(1, 1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isInRange(1, 5);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<1b:5b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isInRange(1, 5);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<1b:5b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isInRange(6, 10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<6b:10b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isInRange(6, 10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<6b:10b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isInRange(8, 9);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<8b:9b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isInRange(8, 9);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<8b:9b> but was:<5b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isInRangeObjectTest() {
        initialize(Raw.byteAssertion(), (byte) 5).isInRange(Byte.valueOf("4"), Byte.valueOf("6"));
        initialize(Raw.byteAssertion(), (byte) 5).isInRange(Byte.valueOf("5"), Byte.valueOf("6"));
        initialize(Raw.byteAssertion(), (byte) 5).isInRange(Byte.valueOf("1"), Byte.valueOf("10"));
        initialize(Raw.byteAssertion(), (byte) 5).isNotNull().isInRange(Byte.valueOf("4"), Byte.valueOf("6")).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isInRange(Byte.valueOf("1"), Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isInRange(Byte.valueOf("1"), Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isInRange(Byte.valueOf("1"), Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isInRange(null, Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isInRange(null, Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1).isInRange(null, Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1, "Message").isInRange(null, Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1).isInRange(null, null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1, "Message").isInRange(null, null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1).isInRange(Byte.valueOf("1"), null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1, "Message").isInRange(Byte.valueOf("1"), null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isInRange(Byte.valueOf("1"), Byte.valueOf("5"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<1b:5b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isInRange(Byte.valueOf("1"), Byte.valueOf("5"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<1b:5b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isInRange(Byte.valueOf("6"), Byte.valueOf("10"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<6b:10b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isInRange(Byte.valueOf("6"), Byte.valueOf("10"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<6b:10b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isInRange(Byte.valueOf("8"), Byte.valueOf("9"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<8b:9b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isInRange(Byte.valueOf("8"), Byte.valueOf("9"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<8b:9b> but was:<5b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isNotInRangePrimitiveTest() {
        initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(1, 5);
        initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(6, 10);
        initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(8, 9);
        initialize(Raw.byteAssertion(), (byte) 5).isNotNull().isNotInRange(1, 5).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isNotInRange(1, 1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isNotInRange(1, 1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isNotInRange(1, 1);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(4, 6);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<4b:6b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isNotInRange(4, 6);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<4b:6b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(5, 6);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<5b:6b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isNotInRange(5, 6);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<5b:6b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(1, 10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<1b:10b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isNotInRange(1, 10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<1b:10b> but was:<5b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isNotInRangeObjectTest() {
        initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(Byte.valueOf("1"), Byte.valueOf("5"));
        initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(Byte.valueOf("6"), Byte.valueOf("10"));
        initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(Byte.valueOf("8"), Byte.valueOf("9"));
        initialize(Raw.byteAssertion(), (byte) 5).isNotNull().isNotInRange(Byte.valueOf("1"), Byte.valueOf("5")).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().isNotInRange(Byte.valueOf("1"), Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isNotInRange(Byte.valueOf("1"), Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isNotInRange(Byte.valueOf("1"), Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isNotInRange(null, Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isNotInRange(null, Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1).isNotInRange(null, Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1, "Message").isNotInRange(null, Byte.valueOf("1"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1).isNotInRange(null, null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1, "Message").isNotInRange(null, null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1).isNotInRange(Byte.valueOf("1"), null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1, "Message").isNotInRange(Byte.valueOf("1"), null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(Byte.valueOf("4"), Byte.valueOf("6"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<4b:6b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isNotInRange(Byte.valueOf("4"), Byte.valueOf("6"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<4b:6b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(Byte.valueOf("5"), Byte.valueOf("6"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<5b:6b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isNotInRange(Byte.valueOf("5"), Byte.valueOf("6"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<5b:6b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(Byte.valueOf("1"), Byte.valueOf("10"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<1b:10b> but was:<5b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isNotInRange(Byte.valueOf("1"), Byte.valueOf("10"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<1b:10b> but was:<5b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        initialize(Raw.byteAssertion(), (byte) 0).toHexString().isEqualTo("00");
        initialize(Raw.byteAssertion(), (byte) 1).toHexString().isEqualTo("01");
        initialize(Raw.byteAssertion(), (byte) 31).toHexString().isEqualTo("1f");
        initialize(Raw.byteAssertion(), (byte) 50).toHexString().isEqualTo("32");
        initialize(Raw.byteAssertion(), (byte) 100).toHexString().isEqualTo("64");
        initialize(Raw.byteAssertion(), (byte) 101).toHexString().isEqualTo("65");
        initialize(Raw.byteAssertion(), (byte) -1).toHexString().isEqualTo("ff");
        initialize(Raw.byteAssertion(), (byte) -127).toHexString().isEqualTo("81");
        initialize(Raw.byteAssertion(), (byte) 31).isNotNull().toHexString().isEqualTo("1f");

        try {
            Raw.byteAssertion().toHexString();
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).toHexString();
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").toHexString();
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteAssertion(), (byte) 11).toHexString()).isEqualTo("11");
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteAssertion(), (byte) 11, "Message").toHexString()).isEqualTo("11");
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11).toHexString().isEqualTo("11");
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<0b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11, "Message").toHexString().isEqualTo("11");
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<0b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.byteAssertion(), (byte) 0).toHexString(Matchers.is(Matchers.equalTo("00")));
        initialize(Raw.byteAssertion(), (byte) 1).toHexString(Matchers.is(Matchers.equalTo("01")));
        initialize(Raw.byteAssertion(), (byte) 31).toHexString(Matchers.is(Matchers.equalTo("1f")));
        initialize(Raw.byteAssertion(), (byte) 50).toHexString(Matchers.is(Matchers.equalTo("32")));
        initialize(Raw.byteAssertion(), (byte) 100).toHexString(Matchers.is(Matchers.equalTo("64")));
        initialize(Raw.byteAssertion(), (byte) 101).toHexString(Matchers.is(Matchers.equalTo("65")));
        initialize(Raw.byteAssertion(), (byte) -1).toHexString(Matchers.is(Matchers.equalTo("ff")));
        initialize(Raw.byteAssertion(), (byte) -127).toHexString(Matchers.is(Matchers.equalTo("81")));
        initialize(Raw.byteAssertion(), (byte) 31).isNotNull().toHexString(Matchers.is(Matchers.equalTo("1f"))).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().toHexString(Matchers.equalTo("0"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).toHexString(Matchers.equalTo("0"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").toHexString(Matchers.equalTo("0"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null).toHexString(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").toHexString(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1).toHexString(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1, "Message").toHexString(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11).toHexString(Matchers.equalTo("11"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"11\"\n     but: was \"0b\"");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11, "Message").toHexString(Matchers.equalTo("11"));
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"11\"\n     but: was \"0b\"");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.byteAssertion(), (byte) 0).hasHexString("00");
        initialize(Raw.byteAssertion(), (byte) 1).hasHexString("01");
        initialize(Raw.byteAssertion(), (byte) 31).hasHexString("1f");
        initialize(Raw.byteAssertion(), (byte) 50).hasHexString("32");
        initialize(Raw.byteAssertion(), (byte) 100).hasHexString("64");
        initialize(Raw.byteAssertion(), (byte) 101).hasHexString("65");
        initialize(Raw.byteAssertion(), (byte) -1).hasHexString("ff");
        initialize(Raw.byteAssertion(), (byte) -127).hasHexString("81");
        initialize(Raw.byteAssertion(), (byte) 31).isNotNull().hasHexString("1f").isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().hasHexString("0");
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).hasHexString("0");
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").hasHexString("0");
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null).hasHexString(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").hasHexString(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11).hasHexString(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11, "Message").hasHexString(null);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11).hasHexString("11");
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<0b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11, "Message").hasHexString("11");
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<0b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.byteAssertion(), null).isNull();

        try {
            initialize(Raw.byteAssertion(), (byte) 10).isNull();
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<10b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isNull();
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<10b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Byte value = 100;
        initialize(Raw.byteAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.byteAssertion(), value).isSameAs((byte) 101);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<101b> but was:<100b>");
        }
        try {
            initialize(Raw.byteAssertion(), value, "Message").isSameAs((byte) 101);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<101b> but was:<100b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Byte value = 100;
        initialize(Raw.byteAssertion(), value).isNotSameAs((byte) 101);

        try {
            initialize(Raw.byteAssertion(), value).isNotSameAs(value);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<100b>");
        }
        try {
            initialize(Raw.byteAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<100b>");
        }
    }

}
