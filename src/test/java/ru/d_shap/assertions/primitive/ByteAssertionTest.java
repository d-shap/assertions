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
 * Tests for {@link ByteAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteAssertionTest {

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
    public void isEqualToTest() {
        new ByteAssertion((byte) 10, new FailDescription()).isEqualTo(10);
        new ByteAssertion((byte) 75, new FailDescription()).isEqualTo(75);
        new ByteAssertion((byte) 236, new FailDescription()).isEqualTo((byte) 236);
        new ByteAssertion((byte) 257, new FailDescription()).isEqualTo(1);

        try {
            new ByteAssertion((byte) 10, new FailDescription()).isEqualTo(20);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20> but was:<10>.");
        }
        try {
            new ByteAssertion((byte) 10, new FailDescription().addMessage("Message")).isEqualTo(20);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<20> but was:<10>.");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new ByteAssertion((byte) 10, new FailDescription()).isNotEqualTo(15);
        new ByteAssertion((byte) 75, new FailDescription()).isNotEqualTo(76);
        new ByteAssertion((byte) 236, new FailDescription()).isNotEqualTo(143);
        new ByteAssertion((byte) 257, new FailDescription()).isNotEqualTo(2);

        try {
            new ByteAssertion((byte) 10, new FailDescription()).isNotEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10>.");
        }
        try {
            new ByteAssertion((byte) 10, new FailDescription().addMessage("Message")).isNotEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<10>.");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new ByteAssertion((byte) 10, new FailDescription()).isGreaterThan(5);
        new ByteAssertion((byte) 60, new FailDescription()).isGreaterThan(30);
        new ByteAssertion((byte) 245, new FailDescription()).isGreaterThan((byte) 244);

        try {
            new ByteAssertion((byte) 10, new FailDescription()).isGreaterThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10> but was:<10>.");
        }
        try {
            new ByteAssertion((byte) 10, new FailDescription().addMessage("Message")).isGreaterThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<10> but was:<10>.");
        }
        try {
            new ByteAssertion((byte) 10, new FailDescription()).isGreaterThan(11);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11> but was:<10>.");
        }
        try {
            new ByteAssertion((byte) 10, new FailDescription().addMessage("Message")).isGreaterThan(11);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<11> but was:<10>.");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new ByteAssertion((byte) 10, new FailDescription()).isGreaterThanOrEqualTo(5);
        new ByteAssertion((byte) 60, new FailDescription()).isGreaterThanOrEqualTo(60);
        new ByteAssertion((byte) 245, new FailDescription()).isGreaterThanOrEqualTo((byte) 244);

        try {
            new ByteAssertion((byte) 10, new FailDescription()).isGreaterThanOrEqualTo(11);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11> but was:<10>.");
        }
        try {
            new ByteAssertion((byte) 10, new FailDescription().addMessage("Message")).isGreaterThanOrEqualTo(11);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then or equal to the expected. Expected:<11> but was:<10>.");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new ByteAssertion((byte) 5, new FailDescription()).isLessThan(10);
        new ByteAssertion((byte) 30, new FailDescription()).isLessThan(60);
        new ByteAssertion((byte) 244, new FailDescription()).isLessThan(245);

        try {
            new ByteAssertion((byte) 10, new FailDescription()).isLessThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<10>.");
        }
        try {
            new ByteAssertion((byte) 10, new FailDescription().addMessage("Message")).isLessThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<10> but was:<10>.");
        }
        try {
            new ByteAssertion((byte) 11, new FailDescription()).isLessThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<11>.");
        }
        try {
            new ByteAssertion((byte) 11, new FailDescription().addMessage("Message")).isLessThan(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<10> but was:<11>.");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new ByteAssertion((byte) 5, new FailDescription()).isLessThanOrEqualTo(10);
        new ByteAssertion((byte) 60, new FailDescription()).isLessThanOrEqualTo(60);
        new ByteAssertion((byte) 244, new FailDescription()).isLessThanOrEqualTo(245);

        try {
            new ByteAssertion((byte) 11, new FailDescription()).isLessThanOrEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<10> but was:<11>.");
        }
        try {
            new ByteAssertion((byte) 11, new FailDescription().addMessage("Message")).isLessThanOrEqualTo(10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then or equal to the expected. Expected:<10> but was:<11>.");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        new ByteAssertion((byte) 5, new FailDescription()).isInRange(4, 6);
        new ByteAssertion((byte) 5, new FailDescription()).isInRange(5, 6);
        new ByteAssertion((byte) 5, new FailDescription()).isInRange(1, 10);

        try {
            new ByteAssertion((byte) 5, new FailDescription()).isInRange(1, 5);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<1:5> but was:<5>.");
        }
        try {
            new ByteAssertion((byte) 5, new FailDescription().addMessage("Message")).isInRange(1, 5);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<1:5> but was:<5>.");
        }
        try {
            new ByteAssertion((byte) 5, new FailDescription()).isInRange(6, 10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<6:10> but was:<5>.");
        }
        try {
            new ByteAssertion((byte) 5, new FailDescription().addMessage("Message")).isInRange(6, 10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<6:10> but was:<5>.");
        }
        try {
            new ByteAssertion((byte) 5, new FailDescription()).isInRange(8, 9);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<8:9> but was:<5>.");
        }
        try {
            new ByteAssertion((byte) 5, new FailDescription().addMessage("Message")).isInRange(8, 9);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<8:9> but was:<5>.");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        new ByteAssertion((byte) 5, new FailDescription()).isNotInRange(1, 5);
        new ByteAssertion((byte) 5, new FailDescription()).isNotInRange(6, 10);
        new ByteAssertion((byte) 5, new FailDescription()).isNotInRange(8, 9);

        try {
            new ByteAssertion((byte) 5, new FailDescription()).isNotInRange(4, 6);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<4:6> but was:<5>.");
        }
        try {
            new ByteAssertion((byte) 5, new FailDescription().addMessage("Message")).isNotInRange(4, 6);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<4:6> but was:<5>.");
        }
        try {
            new ByteAssertion((byte) 5, new FailDescription()).isNotInRange(5, 6);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<5:6> but was:<5>.");
        }
        try {
            new ByteAssertion((byte) 5, new FailDescription().addMessage("Message")).isNotInRange(5, 6);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<5:6> but was:<5>.");
        }
        try {
            new ByteAssertion((byte) 5, new FailDescription()).isNotInRange(1, 10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<1:10> but was:<5>.");
        }
        try {
            new ByteAssertion((byte) 5, new FailDescription().addMessage("Message")).isNotInRange(1, 10);
            Assertions.fail("ByteAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<1:10> but was:<5>.");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ByteAssertion((byte) 5, new FailDescription()).asString(null, true)).isNull();
        Assertions.assertThat(new ByteAssertion((byte) 5, new FailDescription()).asString((byte) 5, true)).isEqualTo("5");
        Assertions.assertThat(new ByteAssertion((byte) 5, new FailDescription()).asString((byte) 60, true)).isEqualTo("60");
        Assertions.assertThat(new ByteAssertion((byte) 5, new FailDescription()).asString((byte) 244, true)).isEqualTo("-12");
        Assertions.assertThat(new ByteAssertion((byte) 5, new FailDescription()).asString("test", true)).isEqualTo("test");

        Assertions.assertThat(new ByteAssertion((byte) 5, new FailDescription()).asString(null, false)).isNull();
        Assertions.assertThat(new ByteAssertion((byte) 5, new FailDescription()).asString((byte) 5, false)).isEqualTo("5");
        Assertions.assertThat(new ByteAssertion((byte) 5, new FailDescription()).asString((byte) 60, false)).isEqualTo("60");
        Assertions.assertThat(new ByteAssertion((byte) 5, new FailDescription()).asString((byte) 244, false)).isEqualTo("-12");
        Assertions.assertThat(new ByteAssertion((byte) 5, new FailDescription()).asString("test", false)).isEqualTo("test");
    }

}
