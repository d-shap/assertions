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
package ru.d_shap.assertions.primitive;

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
            initialize(Raw.byteAssertion(), new Object());
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.byteAssertion(), new Object(), "Message");
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.byteAssertion(), (byte) 10).isEqualTo(10);
        initialize(Raw.byteAssertion(), (byte) 75).isEqualTo(75);
        initialize(Raw.byteAssertion(), (byte) 236).isEqualTo((byte) 236);
        initialize(Raw.byteAssertion(), (byte) 257).isEqualTo(1);

        try {
            Raw.byteAssertion().isEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isEqualTo(20);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20> but was:<10>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isEqualTo(20);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<20> but was:<10>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.byteAssertion(), (byte) 10).isNotEqualTo(15);
        initialize(Raw.byteAssertion(), (byte) 75).isNotEqualTo(76);
        initialize(Raw.byteAssertion(), (byte) 236).isNotEqualTo(143);
        initialize(Raw.byteAssertion(), (byte) 257).isNotEqualTo(2);

        try {
            Raw.byteAssertion().isNotEqualTo(15);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isNotEqualTo(15);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isNotEqualTo(15);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isNotEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isNotEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        initialize(Raw.byteAssertion(), (byte) 10).isGreaterThan(5);
        initialize(Raw.byteAssertion(), (byte) 60).isGreaterThan(30);
        initialize(Raw.byteAssertion(), (byte) 245).isGreaterThan((byte) 244);

        try {
            Raw.byteAssertion().isGreaterThan(5);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isGreaterThan(5);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isGreaterThan(5);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isGreaterThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10> but was:<10>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isGreaterThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<10> but was:<10>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isGreaterThan(11);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11> but was:<10>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isGreaterThan(11);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<11> but was:<10>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        initialize(Raw.byteAssertion(), (byte) 10).isGreaterThanOrEqualTo(5);
        initialize(Raw.byteAssertion(), (byte) 60).isGreaterThanOrEqualTo(60);
        initialize(Raw.byteAssertion(), (byte) 245).isGreaterThanOrEqualTo((byte) 244);

        try {
            Raw.byteAssertion().isGreaterThanOrEqualTo(5);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isGreaterThanOrEqualTo(5);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isGreaterThanOrEqualTo(5);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isGreaterThanOrEqualTo(11);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11> but was:<10>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isGreaterThanOrEqualTo(11);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then or equal to the expected. Expected:<11> but was:<10>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        initialize(Raw.byteAssertion(), (byte) 5).isLessThan(10);
        initialize(Raw.byteAssertion(), (byte) 30).isLessThan(60);
        initialize(Raw.byteAssertion(), (byte) 244).isLessThan(245);

        try {
            Raw.byteAssertion().isLessThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isLessThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isLessThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10).isLessThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<10>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isLessThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<10> but was:<10>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11).isLessThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<11>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11, "Message").isLessThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<10> but was:<11>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        initialize(Raw.byteAssertion(), (byte) 5).isLessThanOrEqualTo(10);
        initialize(Raw.byteAssertion(), (byte) 60).isLessThanOrEqualTo(60);
        initialize(Raw.byteAssertion(), (byte) 244).isLessThanOrEqualTo(245);

        try {
            Raw.byteAssertion().isLessThanOrEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isLessThanOrEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isLessThanOrEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11).isLessThanOrEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<10> but was:<11>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11, "Message").isLessThanOrEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then or equal to the expected. Expected:<10> but was:<11>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        initialize(Raw.byteAssertion(), (byte) 5).isInRange(4, 6);
        initialize(Raw.byteAssertion(), (byte) 5).isInRange(5, 6);
        initialize(Raw.byteAssertion(), (byte) 5).isInRange(1, 10);

        try {
            Raw.byteAssertion().isInRange(4, 6);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isInRange(4, 6);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isInRange(4, 6);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isInRange(1, 5);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<1:5> but was:<5>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isInRange(1, 5);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<1:5> but was:<5>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isInRange(6, 10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<6:10> but was:<5>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isInRange(6, 10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<6:10> but was:<5>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isInRange(8, 9);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<8:9> but was:<5>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isInRange(8, 9);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<8:9> but was:<5>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(1, 5);
        initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(6, 10);
        initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(8, 9);

        try {
            Raw.byteAssertion().isNotInRange(1, 5);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).isNotInRange(1, 5);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").isNotInRange(1, 5);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(4, 6);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<4:6> but was:<5>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isNotInRange(4, 6);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<4:6> but was:<5>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(5, 6);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<5:6> but was:<5>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isNotInRange(5, 6);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<5:6> but was:<5>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5).isNotInRange(1, 10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<1:10> but was:<5>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 5, "Message").isNotInRange(1, 10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<1:10> but was:<5>");
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
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<10>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 10, "Message").isNull();
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<10>");
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
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<101> but was:<100>");
        }
        try {
            initialize(Raw.byteAssertion(), value, "Message").isSameAs((byte) 101);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<101> but was:<100>");
        }
        try {
            initialize(Raw.byteAssertion(), value).isSameAs("test");
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<100>");
        }
        try {
            initialize(Raw.byteAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<100>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Byte value = 100;
        initialize(Raw.byteAssertion(), value).isNotSameAs((byte) 101);
        initialize(Raw.byteAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.byteAssertion(), value).isNotSameAs(value);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<100>");
        }
        try {
            initialize(Raw.byteAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<100>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.byteAssertion(), (byte) 5).asString(null));
            Assertions.fail("ByteAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.byteAssertion(), (byte) 5).asString((byte) 5)).isEqualTo("5");
        Assertions.assertThat(initialize(Raw.byteAssertion(), (byte) 5).asString((byte) 60)).isEqualTo("60");
        Assertions.assertThat(initialize(Raw.byteAssertion(), (byte) 5).asString((byte) 244)).isEqualTo("-12");
        Assertions.assertThat(initialize(Raw.byteAssertion(), (byte) 5).asString("test")).isEqualTo("test");
    }

}
