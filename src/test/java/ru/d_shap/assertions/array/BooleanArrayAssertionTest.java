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
 * Tests for {@link BooleanArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class BooleanArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public BooleanArrayAssertionTest() {
        super();
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new BooleanArrayAssertion(null, null).isEmpty();
        new BooleanArrayAssertion(new boolean[]{}, null).isEmpty();

        try {
            new BooleanArrayAssertion(new boolean[]{true}, null).isEmpty();
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, false, true}, null).isEmpty();
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[true, false, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new BooleanArrayAssertion(new boolean[]{true}, null).isNotEmpty();
        new BooleanArrayAssertion(new boolean[]{true, false, true}, null).isNotEmpty();

        try {
            new BooleanArrayAssertion(null, null).isNotEmpty();
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{}, null).isNotEmpty();
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        new BooleanArrayAssertion(new boolean[]{}, null).isEqualTo();
        new BooleanArrayAssertion(new boolean[]{true}, null).isEqualTo(true);
        new BooleanArrayAssertion(new boolean[]{true, false, true}, null).isEqualTo(true, false, true);

        try {
            new BooleanArrayAssertion(new boolean[]{true, false, true}, null).isEqualTo(true, false, true, true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[true, false, true, true]> but was:<[true, false, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, false, true, true}, null).isEqualTo(true, false, true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[true, false, true]> but was:<[true, false, true, true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, false, true}, null).isEqualTo(true, false, false);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[true, false, false]> but was:<[true, false, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new BooleanArrayAssertion(new boolean[]{true, false, true}, null).isNotEqualTo(true, false, true, true);
        new BooleanArrayAssertion(new boolean[]{true, false, true, true}, null).isNotEqualTo(true, false, true);
        new BooleanArrayAssertion(new boolean[]{true, false, true}, null).isNotEqualTo(true, false, false);

        try {
            new BooleanArrayAssertion(new boolean[]{}, null).isNotEqualTo();
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true}, null).isNotEqualTo(true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[true]>");
        }
        try {
            new BooleanArrayAssertion(new boolean[]{true, false, true}, null).isNotEqualTo(true, false, true);
            Assertions.fail("Boolean array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[true, false, true]>");
        }
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new BooleanArrayAssertion(new boolean[]{}, null).toLength().isEqualTo(0);
        new BooleanArrayAssertion(new boolean[]{true}, null).toLength().isEqualTo(1);
        new BooleanArrayAssertion(new boolean[]{true, false, true}, null).toLength().isEqualTo(3);
        new BooleanArrayAssertion(new boolean[]{true, false, true, true}, null).toLength().isEqualTo(4);
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new BooleanArrayAssertion(new boolean[]{}, null).hasLength(0);
        new BooleanArrayAssertion(new boolean[]{true}, null).hasLength(1);
        new BooleanArrayAssertion(new boolean[]{true, false, true}, null).hasLength(3);
        new BooleanArrayAssertion(new boolean[]{true, false, true, true}, null).hasLength(4);
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void toItemTest() {
        new BooleanArrayAssertion(new boolean[]{true}, null).toItem(0).isTrue();

        new BooleanArrayAssertion(new boolean[]{true, false, true}, null).toItem(0).isTrue();
        new BooleanArrayAssertion(new boolean[]{true, false, true}, null).toItem(1).isFalse();
        new BooleanArrayAssertion(new boolean[]{true, false, true}, null).toItem(2).isTrue();

        new BooleanArrayAssertion(new boolean[]{true, false, true, true}, null).toItem(0).isTrue();
        new BooleanArrayAssertion(new boolean[]{true, false, true, true}, null).toItem(1).isFalse();
        new BooleanArrayAssertion(new boolean[]{true, false, true, true}, null).toItem(2).isTrue();
        new BooleanArrayAssertion(new boolean[]{true, false, true, true}, null).toItem(3).isTrue();
    }

    /**
     * {@link BooleanArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new BooleanArrayAssertion(null, null).asString(null)).isNull();
        Assertions.assertThat(new BooleanArrayAssertion(null, null).asString("test")).isEqualTo("test");
        Assertions.assertThat(new BooleanArrayAssertion(null, null).asString(new boolean[]{true})).isEqualTo("[true]");
        Assertions.assertThat(new BooleanArrayAssertion(null, null).asString(new boolean[]{true, false, true})).isEqualTo("[true, false, true]");
        Assertions.assertThat(new BooleanArrayAssertion(null, null).asString(new boolean[]{true, false, true, true})).isEqualTo("[true, false, true, true]");
    }

}
