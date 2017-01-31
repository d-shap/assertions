///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
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
package ru.d_shap.assertions.array;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link DoubleArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public DoubleArrayAssertionTest() {
        super();
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new DoubleArrayAssertion(null, null).isEmpty();
        new DoubleArrayAssertion(new double[]{}, null).isEmpty();

        try {
            new DoubleArrayAssertion(new double[]{1.0}, null).isEmpty();
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0}, null).isEmpty();
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[5.0, 10.0, 15.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new DoubleArrayAssertion(new double[]{1.0}, null).isNotEmpty();
        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0}, null).isNotEmpty();

        try {
            new DoubleArrayAssertion(null, null).isNotEmpty();
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new DoubleArrayAssertion(new double[]{}, null).isNotEmpty();
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        new DoubleArrayAssertion(new double[]{}, null).isEqualTo();
        new DoubleArrayAssertion(new double[]{1.0}, null).isEqualTo(1.0);
        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0}, null).isEqualTo(5.0, 10.0, 15.0);

        try {
            new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0}, null).isEqualTo(5.0, 10.0, 15.0, 20.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5.0, 10.0, 15.0, 20.0]> but was:<[5.0, 10.0, 15.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0, 20.0}, null).isEqualTo(5.0, 10.0, 15.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5.0, 10.0, 15.0]> but was:<[5.0, 10.0, 15.0, 20.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0}, null).isEqualTo(5.0, 10.0, 20.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5.0, 10.0, 20.0]> but was:<[5.0, 10.0, 15.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0}, null).isNotEqualTo(5.0, 10.0, 15.0, 20.0);
        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0, 20.0}, null).isNotEqualTo(5.0, 10.0, 15.0);
        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0}, null).isNotEqualTo(5.0, 10.0, 20.0);

        try {
            new DoubleArrayAssertion(new double[]{}, null).isNotEqualTo();
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0}, null).isNotEqualTo(1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0}, null).isNotEqualTo(5.0, 10.0, 15.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[5.0, 10.0, 15.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new DoubleArrayAssertion(new double[]{}, null).toLength().isEqualTo(0);
        new DoubleArrayAssertion(new double[]{1.0}, null).toLength().isEqualTo(1);
        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0}, null).toLength().isEqualTo(3);
        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0, 20.0}, null).toLength().isEqualTo(4);
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new DoubleArrayAssertion(new double[]{}, null).hasLength(0);
        new DoubleArrayAssertion(new double[]{1.0}, null).hasLength(1);
        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0}, null).hasLength(3);
        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0, 20.0}, null).hasLength(4);
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void toItemTest() {
        new DoubleArrayAssertion(new double[]{1.0}, null).toItem(0).isEqualTo(1.0, 0.01);

        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0}, null).toItem(0).isEqualTo(5.0, 0.01);
        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0}, null).toItem(1).isEqualTo(10.0, 0.01);
        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0}, null).toItem(2).isEqualTo(15.0, 0.01);

        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0, 20.0}, null).toItem(0).isEqualTo(5.0, 0.01);
        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0, 20.0}, null).toItem(1).isEqualTo(10.0, 0.01);
        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0, 20.0}, null).toItem(2).isEqualTo(15.0, 0.01);
        new DoubleArrayAssertion(new double[]{5.0, 10.0, 15.0, 20.0}, null).toItem(3).isEqualTo(20.0, 0.01);
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new DoubleArrayAssertion(null, null).asString(null)).isNull();
        Assertions.assertThat(new DoubleArrayAssertion(null, null).asString("test")).isEqualTo("test");
        Assertions.assertThat(new DoubleArrayAssertion(null, null).asString(new double[]{1.0})).isEqualTo("[1.0]");
        Assertions.assertThat(new DoubleArrayAssertion(null, null).asString(new double[]{5.0, 10.0, 15.0})).isEqualTo("[5.0, 10.0, 15.0]");
        Assertions.assertThat(new DoubleArrayAssertion(null, null).asString(new double[]{5.0, 10.0, 15.0, 20.0})).isEqualTo("[5.0, 10.0, 15.0, 20.0]");
    }

}
