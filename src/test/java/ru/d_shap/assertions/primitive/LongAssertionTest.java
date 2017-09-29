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

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

/**
 * Tests for {@link LongAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongAssertionTest {

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
        new LongAssertion(10L, new FailDescription()).isEqualTo(10L);
        new LongAssertion(75L, new FailDescription()).isEqualTo(75L);
        new LongAssertion(236L, new FailDescription()).isEqualTo(236L);
        new LongAssertion(257L, new FailDescription()).isEqualTo(257L);

        try {
            new LongAssertion(10L, new FailDescription()).isEqualTo(20L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20> but was:<10>.");
        }
        try {
            new LongAssertion(10L, new FailDescription("Message")).isEqualTo(20L);
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
        new LongAssertion(10L, new FailDescription()).isNotEqualTo(15L);
        new LongAssertion(75L, new FailDescription()).isNotEqualTo(76L);
        new LongAssertion(236L, new FailDescription()).isNotEqualTo(143L);
        new LongAssertion(257L, new FailDescription()).isNotEqualTo(2L);

        try {
            new LongAssertion(10L, new FailDescription()).isNotEqualTo(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10>.");
        }
        try {
            new LongAssertion(10L, new FailDescription("Message")).isNotEqualTo(10L);
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
        new LongAssertion(10L, new FailDescription()).isGreaterThan(5L);
        new LongAssertion(60L, new FailDescription()).isGreaterThan(30L);
        new LongAssertion(245L, new FailDescription()).isGreaterThan(244L);

        try {
            new LongAssertion(10L, new FailDescription()).isGreaterThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10> but was:<10>.");
        }
        try {
            new LongAssertion(10L, new FailDescription("Message")).isGreaterThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<10> but was:<10>.");
        }
        try {
            new LongAssertion(10L, new FailDescription()).isGreaterThan(11L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11> but was:<10>.");
        }
        try {
            new LongAssertion(10L, new FailDescription("Message")).isGreaterThan(11L);
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
        new LongAssertion(10L, new FailDescription()).isGreaterThanOrEqualTo(5L);
        new LongAssertion(60L, new FailDescription()).isGreaterThanOrEqualTo(60L);
        new LongAssertion(245L, new FailDescription()).isGreaterThanOrEqualTo(244L);

        try {
            new LongAssertion(10L, new FailDescription()).isGreaterThanOrEqualTo(11L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11> but was:<10>.");
        }
        try {
            new LongAssertion(10L, new FailDescription("Message")).isGreaterThanOrEqualTo(11L);
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
        new LongAssertion(5L, new FailDescription()).isLessThan(10L);
        new LongAssertion(30L, new FailDescription()).isLessThan(60L);
        new LongAssertion(244L, new FailDescription()).isLessThan(245L);

        try {
            new LongAssertion(10L, new FailDescription()).isLessThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<10>.");
        }
        try {
            new LongAssertion(10L, new FailDescription("Message")).isLessThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<10> but was:<10>.");
        }
        try {
            new LongAssertion(11L, new FailDescription()).isLessThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<11>.");
        }
        try {
            new LongAssertion(11L, new FailDescription("Message")).isLessThan(10L);
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
        new LongAssertion(5L, new FailDescription()).isLessThanOrEqualTo(10L);
        new LongAssertion(60L, new FailDescription()).isLessThanOrEqualTo(60L);
        new LongAssertion(244L, new FailDescription()).isLessThanOrEqualTo(245L);

        try {
            new LongAssertion(11L, new FailDescription()).isLessThanOrEqualTo(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<10> but was:<11>.");
        }
        try {
            new LongAssertion(11L, new FailDescription("Message")).isLessThanOrEqualTo(10L);
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
        new LongAssertion(5L, new FailDescription()).isInRange(4L, 6L);
        new LongAssertion(5L, new FailDescription()).isInRange(5L, 6L);
        new LongAssertion(5L, new FailDescription()).isInRange(1L, 10L);

        try {
            new LongAssertion(5L, new FailDescription()).isInRange(1L, 5L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<1:5> but was:<5>.");
        }
        try {
            new LongAssertion(5L, new FailDescription("Message")).isInRange(1L, 5L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<1:5> but was:<5>.");
        }
        try {
            new LongAssertion(5L, new FailDescription()).isInRange(6L, 10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<6:10> but was:<5>.");
        }
        try {
            new LongAssertion(5L, new FailDescription("Message")).isInRange(6L, 10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<6:10> but was:<5>.");
        }
        try {
            new LongAssertion(5L, new FailDescription()).isInRange(8L, 9L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<8:9> but was:<5>.");
        }
        try {
            new LongAssertion(5L, new FailDescription("Message")).isInRange(8L, 9L);
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
        new LongAssertion(5L, new FailDescription()).isNotInRange(1L, 5L);
        new LongAssertion(5L, new FailDescription()).isNotInRange(6L, 10L);
        new LongAssertion(5L, new FailDescription()).isNotInRange(8L, 9L);

        try {
            new LongAssertion(5L, new FailDescription()).isNotInRange(4L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<4:6> but was:<5>.");
        }
        try {
            new LongAssertion(5L, new FailDescription("Message")).isNotInRange(4L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<4:6> but was:<5>.");
        }
        try {
            new LongAssertion(5L, new FailDescription()).isNotInRange(5L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<5:6> but was:<5>.");
        }
        try {
            new LongAssertion(5L, new FailDescription("Message")).isNotInRange(5L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<5:6> but was:<5>.");
        }
        try {
            new LongAssertion(5L, new FailDescription()).isNotInRange(1L, 10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<1:10> but was:<5>.");
        }
        try {
            new LongAssertion(5L, new FailDescription("Message")).isNotInRange(1L, 10L);
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
        Assertions.assertThat(new LongAssertion(5L, new FailDescription()).asString(null, true)).isNull();
        Assertions.assertThat(new LongAssertion(5L, new FailDescription()).asString(5L, true)).isEqualTo("5");
        Assertions.assertThat(new LongAssertion(5L, new FailDescription()).asString(60L, true)).isEqualTo("60");
        Assertions.assertThat(new LongAssertion(5L, new FailDescription()).asString(244L, true)).isEqualTo("244");
        Assertions.assertThat(new LongAssertion(5L, new FailDescription()).asString("test", true)).isEqualTo("test");

        Assertions.assertThat(new LongAssertion(5L, new FailDescription()).asString(null, false)).isNull();
        Assertions.assertThat(new LongAssertion(5L, new FailDescription()).asString(5L, false)).isEqualTo("5");
        Assertions.assertThat(new LongAssertion(5L, new FailDescription()).asString(60L, false)).isEqualTo("60");
        Assertions.assertThat(new LongAssertion(5L, new FailDescription()).asString(244L, false)).isEqualTo("244");
        Assertions.assertThat(new LongAssertion(5L, new FailDescription()).asString("test", false)).isEqualTo("test");
    }

}
