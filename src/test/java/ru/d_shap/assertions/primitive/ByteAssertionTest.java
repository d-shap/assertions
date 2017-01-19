///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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
        new ByteAssertion((byte) 10, null).isEqualTo((byte) 10);
        new ByteAssertion((byte) 75, null).isEqualTo((byte) 75);
        new ByteAssertion((byte) 236, null).isEqualTo((byte) 236);
        new ByteAssertion((byte) 257, null).isEqualTo((byte) 1);

        try {
            new ByteAssertion((byte) 10, null).isEqualTo((byte) 20);
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20> but was:<10>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new ByteAssertion((byte) 10, null).isNotEqualTo((byte) 15);
        new ByteAssertion((byte) 75, null).isNotEqualTo((byte) 76);
        new ByteAssertion((byte) 236, null).isNotEqualTo((byte) 143);
        new ByteAssertion((byte) 257, null).isNotEqualTo((byte) 2);

        try {
            new ByteAssertion((byte) 10, null).isNotEqualTo((byte) 10);
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new ByteAssertion((byte) 10, null).isGreaterThan((byte) 5);
        new ByteAssertion((byte) 60, null).isGreaterThan((byte) 30);
        new ByteAssertion((byte) 245, null).isGreaterThan((byte) 244);

        try {
            new ByteAssertion((byte) 10, null).isGreaterThan((byte) 10);
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10> but was:<10>");
        }
        try {
            new ByteAssertion((byte) 10, null).isGreaterThan((byte) 11);
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11> but was:<10>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new ByteAssertion((byte) 10, null).isGreaterThanOrEqualTo((byte) 5);
        new ByteAssertion((byte) 60, null).isGreaterThanOrEqualTo((byte) 60);
        new ByteAssertion((byte) 245, null).isGreaterThanOrEqualTo((byte) 244);

        try {
            new ByteAssertion((byte) 10, null).isGreaterThanOrEqualTo((byte) 11);
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11> but was:<10>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new ByteAssertion((byte) 5, null).isLessThan((byte) 10);
        new ByteAssertion((byte) 30, null).isLessThan((byte) 60);
        new ByteAssertion((byte) 244, null).isLessThan((byte) 245);

        try {
            new ByteAssertion((byte) 10, null).isLessThan((byte) 10);
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<10>");
        }
        try {
            new ByteAssertion((byte) 11, null).isLessThan((byte) 10);
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<11>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new ByteAssertion((byte) 5, null).isLessThanOrEqualTo((byte) 10);
        new ByteAssertion((byte) 60, null).isLessThanOrEqualTo((byte) 60);
        new ByteAssertion((byte) 244, null).isLessThanOrEqualTo((byte) 245);

        try {
            new ByteAssertion((byte) 11, null).isLessThanOrEqualTo((byte) 10);
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<10> but was:<11>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ByteAssertion((byte) 5, null).asString(null)).isNull();
        Assertions.assertThat(new ByteAssertion((byte) 5, null).asString("test")).isEqualTo("test");
        Assertions.assertThat(new ByteAssertion((byte) 5, null).asString((byte) 5)).isEqualTo("5");
        Assertions.assertThat(new ByteAssertion((byte) 5, null).asString((byte) 60)).isEqualTo("60");
        Assertions.assertThat(new ByteAssertion((byte) 5, null).asString((byte) 244)).isEqualTo("-12");
    }

}
