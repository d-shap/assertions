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
            initialize(Raw.shortAssertion(), new Object());
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.shortAssertion(), new Object(), "Message");
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.shortAssertion(), (short) 10).isEqualTo(10);
        initialize(Raw.shortAssertion(), (short) 75).isEqualTo(75);
        initialize(Raw.shortAssertion(), (short) 236).isEqualTo(236);
        initialize(Raw.shortAssertion(), (short) 257).isEqualTo(257);

        try {
            Raw.shortAssertion().isEqualTo(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isEqualTo(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isEqualTo(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isEqualTo(20);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20> but was:<10>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isEqualTo(20);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<20> but was:<10>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.shortAssertion(), (short) 10).isNotEqualTo(15);
        initialize(Raw.shortAssertion(), (short) 75).isNotEqualTo(76);
        initialize(Raw.shortAssertion(), (short) 236).isNotEqualTo(143);
        initialize(Raw.shortAssertion(), (short) 257).isNotEqualTo(2);

        try {
            Raw.shortAssertion().isNotEqualTo(15);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isNotEqualTo(15);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isNotEqualTo(15);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isNotEqualTo(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isNotEqualTo(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        initialize(Raw.shortAssertion(), (short) 10).isGreaterThan(5);
        initialize(Raw.shortAssertion(), (short) 60).isGreaterThan(30);
        initialize(Raw.shortAssertion(), (short) 245).isGreaterThan(244);

        try {
            Raw.shortAssertion().isGreaterThan(5);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isGreaterThan(5);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isGreaterThan(5);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isGreaterThan(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10> but was:<10>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isGreaterThan(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<10> but was:<10>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isGreaterThan(11);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11> but was:<10>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isGreaterThan(11);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<11> but was:<10>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        initialize(Raw.shortAssertion(), (short) 10).isGreaterThanOrEqualTo(5);
        initialize(Raw.shortAssertion(), (short) 60).isGreaterThanOrEqualTo(60);
        initialize(Raw.shortAssertion(), (short) 245).isGreaterThanOrEqualTo(244);

        try {
            Raw.shortAssertion().isGreaterThanOrEqualTo(5);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isGreaterThanOrEqualTo(5);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isGreaterThanOrEqualTo(5);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isGreaterThanOrEqualTo(11);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11> but was:<10>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isGreaterThanOrEqualTo(11);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then or equal to the expected. Expected:<11> but was:<10>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        initialize(Raw.shortAssertion(), (short) 5).isLessThan(10);
        initialize(Raw.shortAssertion(), (short) 30).isLessThan(60);
        initialize(Raw.shortAssertion(), (short) 244).isLessThan(245);

        try {
            Raw.shortAssertion().isLessThan(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isLessThan(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isLessThan(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10).isLessThan(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<10>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isLessThan(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<10> but was:<10>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11).isLessThan(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<11>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11, "Message").isLessThan(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<10> but was:<11>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        initialize(Raw.shortAssertion(), (short) 5).isLessThanOrEqualTo(10);
        initialize(Raw.shortAssertion(), (short) 60).isLessThanOrEqualTo(60);
        initialize(Raw.shortAssertion(), (short) 244).isLessThanOrEqualTo(245);

        try {
            Raw.shortAssertion().isLessThanOrEqualTo(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isLessThanOrEqualTo(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isLessThanOrEqualTo(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11).isLessThanOrEqualTo(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<10> but was:<11>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11, "Message").isLessThanOrEqualTo(10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then or equal to the expected. Expected:<10> but was:<11>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        initialize(Raw.shortAssertion(), (short) 5).isInRange(4, 6);
        initialize(Raw.shortAssertion(), (short) 5).isInRange(5, 6);
        initialize(Raw.shortAssertion(), (short) 5).isInRange(1, 10);

        try {
            Raw.shortAssertion().isInRange(4, 6);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isInRange(4, 6);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isInRange(4, 6);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isInRange(1, 5);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<1:5> but was:<5>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isInRange(1, 5);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<1:5> but was:<5>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isInRange(6, 10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<6:10> but was:<5>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isInRange(6, 10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<6:10> but was:<5>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isInRange(8, 9);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<8:9> but was:<5>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isInRange(8, 9);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<8:9> but was:<5>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        initialize(Raw.shortAssertion(), (short) 5).isNotInRange(1, 5);
        initialize(Raw.shortAssertion(), (short) 5).isNotInRange(6, 10);
        initialize(Raw.shortAssertion(), (short) 5).isNotInRange(8, 9);

        try {
            Raw.shortAssertion().isNotInRange(1, 5);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).isNotInRange(1, 5);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").isNotInRange(1, 5);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isNotInRange(4, 6);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<4:6> but was:<5>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isNotInRange(4, 6);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<4:6> but was:<5>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isNotInRange(5, 6);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<5:6> but was:<5>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isNotInRange(5, 6);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<5:6> but was:<5>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5).isNotInRange(1, 10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<1:10> but was:<5>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 5, "Message").isNotInRange(1, 10);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<1:10> but was:<5>");
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
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<10>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 10, "Message").isNull();
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<10>");
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
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<10000> but was:<10000>");
        }
        try {
            initialize(Raw.shortAssertion(), value, "Message").isSameAs((short) 10000);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<10000> but was:<10000>");
        }
        try {
            initialize(Raw.shortAssertion(), value).isSameAs("test");
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<10000>");
        }
        try {
            initialize(Raw.shortAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<10000>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Short value = (short) 10000;
        initialize(Raw.shortAssertion(), value).isNotSameAs((short) 10000);
        initialize(Raw.shortAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.shortAssertion(), value).isNotSameAs(value);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10000>");
        }
        try {
            initialize(Raw.shortAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10000>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.shortAssertion(), (short) 5).asString(null));
            Assertions.fail("ShortAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.shortAssertion(), (short) 5).asString((short) 5)).isEqualTo("5");
        Assertions.assertThat(initialize(Raw.shortAssertion(), (short) 5).asString((short) 60)).isEqualTo("60");
        Assertions.assertThat(initialize(Raw.shortAssertion(), (short) 5).asString((short) 244)).isEqualTo("244");
        Assertions.assertThat(initialize(Raw.shortAssertion(), (short) 5).asString("test")).isEqualTo("test");
    }

}
