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
package ru.d_shap.assertions.array;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ShortArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public ShortArrayAssertionTest() {
        super();
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new ShortArrayAssertion(null, null).isEmpty();
        new ShortArrayAssertion(new short[]{}, null).isEmpty();

        try {
            new ShortArrayAssertion(new short[]{1}, null).isEmpty();
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the empty array. Actual:<[1]>");
        }
        try {
            new ShortArrayAssertion(new short[]{5, 10, 15}, null).isEmpty();
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the empty array. Actual:<[5, 10, 15]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new ShortArrayAssertion(new short[]{1}, null).isNotEmpty();
        new ShortArrayAssertion(new short[]{5, 10, 15}, null).isNotEmpty();

        try {
            new ShortArrayAssertion(null, null).isNotEmpty();
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the empty array.");
        }
        try {
            new ShortArrayAssertion(new short[]{}, null).isNotEmpty();
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the empty array.");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        new ShortArrayAssertion(new short[]{}, null).isEqualTo(new short[]{});
        new ShortArrayAssertion(new short[]{1}, null).isEqualTo(new short[]{1});
        new ShortArrayAssertion(new short[]{5, 10, 15}, null).isEqualTo(new short[]{5, 10, 15});

        try {
            new ShortArrayAssertion(new short[]{5, 10, 15}, null).isEqualTo(new short[]{5, 10, 15, 20});
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5, 10, 15, 20]> but was:<[5, 10, 15]>");
        }
        try {
            new ShortArrayAssertion(new short[]{5, 10, 15, 20}, null).isEqualTo(new short[]{5, 10, 15});
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5, 10, 15]> but was:<[5, 10, 15, 20]>");
        }
        try {
            new ShortArrayAssertion(new short[]{5, 10, 15}, null).isEqualTo(new short[]{5, 10, 20});
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5, 10, 20]> but was:<[5, 10, 15]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new ShortArrayAssertion(new short[]{5, 10, 15}, null).isNotEqualTo(new short[]{5, 10, 15, 20});
        new ShortArrayAssertion(new short[]{5, 10, 15, 20}, null).isNotEqualTo(new short[]{5, 10, 15});
        new ShortArrayAssertion(new short[]{5, 10, 15}, null).isNotEqualTo(new short[]{5, 10, 20});

        try {
            new ShortArrayAssertion(new short[]{}, null).isNotEqualTo(new short[]{});
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[]>");
        }
        try {
            new ShortArrayAssertion(new short[]{1}, null).isNotEqualTo(new short[]{1});
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1]>");
        }
        try {
            new ShortArrayAssertion(new short[]{5, 10, 15}, null).isNotEqualTo(new short[]{5, 10, 15});
            Assertions.fail("Short array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[5, 10, 15]>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new ShortArrayAssertion(new short[]{}, null).toLength().isEqualTo(0);
        new ShortArrayAssertion(new short[]{1}, null).toLength().isEqualTo(1);
        new ShortArrayAssertion(new short[]{5, 10, 15}, null).toLength().isEqualTo(3);
        new ShortArrayAssertion(new short[]{5, 10, 15, 20}, null).toLength().isEqualTo(4);
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new ShortArrayAssertion(new short[]{}, null).hasLength(0);
        new ShortArrayAssertion(new short[]{1}, null).hasLength(1);
        new ShortArrayAssertion(new short[]{5, 10, 15}, null).hasLength(3);
        new ShortArrayAssertion(new short[]{5, 10, 15, 20}, null).hasLength(4);
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void toItemTest() {
        new ShortArrayAssertion(new short[]{1}, null).toItem(0).isEqualTo((short) 1);

        new ShortArrayAssertion(new short[]{5, 10, 15}, null).toItem(0).isEqualTo((short) 5);
        new ShortArrayAssertion(new short[]{5, 10, 15}, null).toItem(1).isEqualTo((short) 10);
        new ShortArrayAssertion(new short[]{5, 10, 15}, null).toItem(2).isEqualTo((short) 15);

        new ShortArrayAssertion(new short[]{5, 10, 15, 20}, null).toItem(0).isEqualTo((short) 5);
        new ShortArrayAssertion(new short[]{5, 10, 15, 20}, null).toItem(1).isEqualTo((short) 10);
        new ShortArrayAssertion(new short[]{5, 10, 15, 20}, null).toItem(2).isEqualTo((short) 15);
        new ShortArrayAssertion(new short[]{5, 10, 15, 20}, null).toItem(3).isEqualTo((short) 20);
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ShortArrayAssertion(null, null).asString(null)).isNull();
        Assertions.assertThat(new ShortArrayAssertion(null, null).asString(new short[]{1})).isEqualTo("[1]");
        Assertions.assertThat(new ShortArrayAssertion(null, null).asString(new short[]{5, 10, 15})).isEqualTo("[5, 10, 15]");
        Assertions.assertThat(new ShortArrayAssertion(null, null).asString(new short[]{5, 10, 15, 20})).isEqualTo("[5, 10, 15, 20]");
    }

}
