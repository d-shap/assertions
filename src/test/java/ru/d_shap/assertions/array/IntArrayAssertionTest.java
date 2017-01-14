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
 * Tests for {@link IntArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public IntArrayAssertionTest() {
        super();
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new IntArrayAssertion(null, null).isEmpty();
        new IntArrayAssertion(new int[]{}, null).isEmpty();

        try {
            new IntArrayAssertion(new int[]{1}, null).isEmpty();
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the empty array. Actual:<[1]>");
        }
        try {
            new IntArrayAssertion(new int[]{5, 10, 15}, null).isEmpty();
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the empty array. Actual:<[5, 10, 15]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new IntArrayAssertion(new int[]{1}, null).isNotEmpty();
        new IntArrayAssertion(new int[]{5, 10, 15}, null).isNotEmpty();

        try {
            new IntArrayAssertion(null, null).isNotEmpty();
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the empty array.");
        }
        try {
            new IntArrayAssertion(new int[]{}, null).isNotEmpty();
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the empty array.");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        new IntArrayAssertion(new int[]{}, null).isEqualTo(new int[]{});
        new IntArrayAssertion(new int[]{1}, null).isEqualTo(new int[]{1});
        new IntArrayAssertion(new int[]{5, 10, 15}, null).isEqualTo(new int[]{5, 10, 15});

        try {
            new IntArrayAssertion(new int[]{5, 10, 15}, null).isEqualTo(new int[]{5, 10, 15, 20});
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5, 10, 15, 20]> but was:<[5, 10, 15]>");
        }
        try {
            new IntArrayAssertion(new int[]{5, 10, 15, 20}, null).isEqualTo(new int[]{5, 10, 15});
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5, 10, 15]> but was:<[5, 10, 15, 20]>");
        }
        try {
            new IntArrayAssertion(new int[]{5, 10, 15}, null).isEqualTo(new int[]{5, 10, 20});
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5, 10, 20]> but was:<[5, 10, 15]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new IntArrayAssertion(new int[]{5, 10, 15}, null).isNotEqualTo(new int[]{5, 10, 15, 20});
        new IntArrayAssertion(new int[]{5, 10, 15, 20}, null).isNotEqualTo(new int[]{5, 10, 15});
        new IntArrayAssertion(new int[]{5, 10, 15}, null).isNotEqualTo(new int[]{5, 10, 20});

        try {
            new IntArrayAssertion(new int[]{}, null).isNotEqualTo(new int[]{});
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[]>");
        }
        try {
            new IntArrayAssertion(new int[]{1}, null).isNotEqualTo(new int[]{1});
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1]>");
        }
        try {
            new IntArrayAssertion(new int[]{5, 10, 15}, null).isNotEqualTo(new int[]{5, 10, 15});
            Assertions.fail("Int array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[5, 10, 15]>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new IntArrayAssertion(new int[]{}, null).toLength().isEqualTo(0);
        new IntArrayAssertion(new int[]{1}, null).toLength().isEqualTo(1);
        new IntArrayAssertion(new int[]{5, 10, 15}, null).toLength().isEqualTo(3);
        new IntArrayAssertion(new int[]{5, 10, 15, 20}, null).toLength().isEqualTo(4);
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new IntArrayAssertion(new int[]{}, null).hasLength(0);
        new IntArrayAssertion(new int[]{1}, null).hasLength(1);
        new IntArrayAssertion(new int[]{5, 10, 15}, null).hasLength(3);
        new IntArrayAssertion(new int[]{5, 10, 15, 20}, null).hasLength(4);
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void toItemTest() {
        new IntArrayAssertion(new int[]{1}, null).toItem(0).isEqualTo(1);

        new IntArrayAssertion(new int[]{5, 10, 15}, null).toItem(0).isEqualTo(5);
        new IntArrayAssertion(new int[]{5, 10, 15}, null).toItem(1).isEqualTo(10);
        new IntArrayAssertion(new int[]{5, 10, 15}, null).toItem(2).isEqualTo(15);

        new IntArrayAssertion(new int[]{5, 10, 15, 20}, null).toItem(0).isEqualTo(5);
        new IntArrayAssertion(new int[]{5, 10, 15, 20}, null).toItem(1).isEqualTo(10);
        new IntArrayAssertion(new int[]{5, 10, 15, 20}, null).toItem(2).isEqualTo(15);
        new IntArrayAssertion(new int[]{5, 10, 15, 20}, null).toItem(3).isEqualTo(20);
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new IntArrayAssertion(null, null).asString(null)).isNull();
        Assertions.assertThat(new IntArrayAssertion(null, null).asString(new int[]{1})).isEqualTo("[1]");
        Assertions.assertThat(new IntArrayAssertion(null, null).asString(new int[]{5, 10, 15})).isEqualTo("[5, 10, 15]");
        Assertions.assertThat(new IntArrayAssertion(null, null).asString(new int[]{5, 10, 15, 20})).isEqualTo("[5, 10, 15, 20]");
    }

}
