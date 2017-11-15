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
    public void isEqualToTest() {
        initialize(Raw.longAssertion(), 10L).isEqualTo(10L);
        initialize(Raw.longAssertion(), 75L).isEqualTo(75L);
        initialize(Raw.longAssertion(), 236L).isEqualTo(236L);
        initialize(Raw.longAssertion(), 257L).isEqualTo(257L);

        try {
            initialize(Raw.longAssertion(), 10L).isEqualTo(20L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20> but was:<10>.");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isEqualTo(20L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<20> but was:<10>.");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.longAssertion(), 10L).isNotEqualTo(15L);
        initialize(Raw.longAssertion(), 75L).isNotEqualTo(76L);
        initialize(Raw.longAssertion(), 236L).isNotEqualTo(143L);
        initialize(Raw.longAssertion(), 257L).isNotEqualTo(2L);

        try {
            initialize(Raw.longAssertion(), 10L).isNotEqualTo(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10>.");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isNotEqualTo(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10>.");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        initialize(Raw.longAssertion(), 10L).isGreaterThan(5L);
        initialize(Raw.longAssertion(), 60L).isGreaterThan(30L);
        initialize(Raw.longAssertion(), 245L).isGreaterThan(244L);

        try {
            initialize(Raw.longAssertion(), 10L).isGreaterThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10> but was:<10>.");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isGreaterThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<10> but was:<10>.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isGreaterThan(11L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11> but was:<10>.");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isGreaterThan(11L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<11> but was:<10>.");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        initialize(Raw.longAssertion(), 10L).isGreaterThanOrEqualTo(5L);
        initialize(Raw.longAssertion(), 60L).isGreaterThanOrEqualTo(60L);
        initialize(Raw.longAssertion(), 245L).isGreaterThanOrEqualTo(244L);

        try {
            initialize(Raw.longAssertion(), 10L).isGreaterThanOrEqualTo(11L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11> but was:<10>.");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isGreaterThanOrEqualTo(11L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then or equal to the expected. Expected:<11> but was:<10>.");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        initialize(Raw.longAssertion(), 5L).isLessThan(10L);
        initialize(Raw.longAssertion(), 30L).isLessThan(60L);
        initialize(Raw.longAssertion(), 244L).isLessThan(245L);

        try {
            initialize(Raw.longAssertion(), 10L).isLessThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<10>.");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isLessThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<10> but was:<10>.");
        }
        try {
            initialize(Raw.longAssertion(), 11L).isLessThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<11>.");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").isLessThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<10> but was:<11>.");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        initialize(Raw.longAssertion(), 5L).isLessThanOrEqualTo(10L);
        initialize(Raw.longAssertion(), 60L).isLessThanOrEqualTo(60L);
        initialize(Raw.longAssertion(), 244L).isLessThanOrEqualTo(245L);

        try {
            initialize(Raw.longAssertion(), 11L).isLessThanOrEqualTo(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<10> but was:<11>.");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").isLessThanOrEqualTo(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then or equal to the expected. Expected:<10> but was:<11>.");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        initialize(Raw.longAssertion(), 5L).isInRange(4L, 6L);
        initialize(Raw.longAssertion(), 5L).isInRange(5L, 6L);
        initialize(Raw.longAssertion(), 5L).isInRange(1L, 10L);

        try {
            initialize(Raw.longAssertion(), 5L).isInRange(1L, 5L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<1:5> but was:<5>.");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isInRange(1L, 5L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<1:5> but was:<5>.");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isInRange(6L, 10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<6:10> but was:<5>.");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isInRange(6L, 10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<6:10> but was:<5>.");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isInRange(8L, 9L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<8:9> but was:<5>.");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isInRange(8L, 9L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<8:9> but was:<5>.");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        initialize(Raw.longAssertion(), 5L).isNotInRange(1L, 5L);
        initialize(Raw.longAssertion(), 5L).isNotInRange(6L, 10L);
        initialize(Raw.longAssertion(), 5L).isNotInRange(8L, 9L);

        try {
            initialize(Raw.longAssertion(), 5L).isNotInRange(4L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<4:6> but was:<5>.");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isNotInRange(4L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<4:6> but was:<5>.");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isNotInRange(5L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<5:6> but was:<5>.");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isNotInRange(5L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<5:6> but was:<5>.");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isNotInRange(1L, 10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<1:10> but was:<5>.");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isNotInRange(1L, 10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<1:10> but was:<5>.");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.longAssertion(), 5L).asString(null));
            Assertions.fail("LongAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.longAssertion(), 5L).asString(5L)).isEqualTo("5");
        Assertions.assertThat(initialize(Raw.longAssertion(), 5L).asString(60L)).isEqualTo("60");
        Assertions.assertThat(initialize(Raw.longAssertion(), 5L).asString(244L)).isEqualTo("244");
        Assertions.assertThat(initialize(Raw.longAssertion(), 5L).asString("test")).isEqualTo("test");
    }

}
