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
 * Tests for {@link LongArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public LongArrayAssertionTest() {
        super();
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new LongArrayAssertion(null, null).isEmpty();
        new LongArrayAssertion(new long[]{}, null).isEmpty();

        try {
            new LongArrayAssertion(new long[]{1L}, null).isEmpty();
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1]>");
        }
        try {
            new LongArrayAssertion(new long[]{5L, 10L, 15L}, null).isEmpty();
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[5, 10, 15]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new LongArrayAssertion(new long[]{1L}, null).isNotEmpty();
        new LongArrayAssertion(new long[]{5L, 10L, 15L}, null).isNotEmpty();

        try {
            new LongArrayAssertion(null, null).isNotEmpty();
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new LongArrayAssertion(new long[]{}, null).isNotEmpty();
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        new LongArrayAssertion(new long[]{}, null).isEqualTo();
        new LongArrayAssertion(new long[]{1L}, null).isEqualTo(1L);
        new LongArrayAssertion(new long[]{5L, 10L, 15L}, null).isEqualTo(5L, 10L, 15L);

        try {
            new LongArrayAssertion(new long[]{5L, 10L, 15L}, null).isEqualTo(5L, 10L, 15L, 20L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5, 10, 15, 20]> but was:<[5, 10, 15]>");
        }
        try {
            new LongArrayAssertion(new long[]{5L, 10L, 15L, 20L}, null).isEqualTo(5L, 10L, 15L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5, 10, 15]> but was:<[5, 10, 15, 20]>");
        }
        try {
            new LongArrayAssertion(new long[]{5L, 10L, 15L}, null).isEqualTo(5L, 10L, 20L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5, 10, 20]> but was:<[5, 10, 15]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new LongArrayAssertion(new long[]{5L, 10L, 15L}, null).isNotEqualTo(5L, 10L, 15L, 20L);
        new LongArrayAssertion(new long[]{5L, 10L, 15L, 20L}, null).isNotEqualTo(5L, 10L, 15L);
        new LongArrayAssertion(new long[]{5L, 10L, 15L}, null).isNotEqualTo(5L, 10L, 20L);

        try {
            new LongArrayAssertion(new long[]{}, null).isNotEqualTo();
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[]>");
        }
        try {
            new LongArrayAssertion(new long[]{1L}, null).isNotEqualTo(1L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1]>");
        }
        try {
            new LongArrayAssertion(new long[]{5L, 10L, 15L}, null).isNotEqualTo(5L, 10L, 15L);
            Assertions.fail("Long array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[5, 10, 15]>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new LongArrayAssertion(new long[]{}, null).toLength().isEqualTo(0);
        new LongArrayAssertion(new long[]{1L}, null).toLength().isEqualTo(1);
        new LongArrayAssertion(new long[]{5L, 10L, 15L}, null).toLength().isEqualTo(3);
        new LongArrayAssertion(new long[]{5L, 10L, 15L, 20L}, null).toLength().isEqualTo(4);
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new LongArrayAssertion(new long[]{}, null).hasLength(0);
        new LongArrayAssertion(new long[]{1L}, null).hasLength(1);
        new LongArrayAssertion(new long[]{5L, 10L, 15L}, null).hasLength(3);
        new LongArrayAssertion(new long[]{5L, 10L, 15L, 20L}, null).hasLength(4);
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void toItemTest() {
        new LongArrayAssertion(new long[]{1L}, null).toItem(0).isEqualTo(1L);

        new LongArrayAssertion(new long[]{5L, 10L, 15L}, null).toItem(0).isEqualTo(5L);
        new LongArrayAssertion(new long[]{5L, 10L, 15L}, null).toItem(1).isEqualTo(10L);
        new LongArrayAssertion(new long[]{5L, 10L, 15L}, null).toItem(2).isEqualTo(15L);

        new LongArrayAssertion(new long[]{5L, 10L, 15L, 20L}, null).toItem(0).isEqualTo(5L);
        new LongArrayAssertion(new long[]{5L, 10L, 15L, 20L}, null).toItem(1).isEqualTo(10L);
        new LongArrayAssertion(new long[]{5L, 10L, 15L, 20L}, null).toItem(2).isEqualTo(15L);
        new LongArrayAssertion(new long[]{5L, 10L, 15L, 20L}, null).toItem(3).isEqualTo(20L);
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new LongArrayAssertion(null, null).asString(null)).isNull();
        Assertions.assertThat(new LongArrayAssertion(null, null).asString("test")).isEqualTo("test");
        Assertions.assertThat(new LongArrayAssertion(null, null).asString(new long[]{1L})).isEqualTo("[1]");
        Assertions.assertThat(new LongArrayAssertion(null, null).asString(new long[]{5L, 10L, 15L})).isEqualTo("[5, 10, 15]");
        Assertions.assertThat(new LongArrayAssertion(null, null).asString(new long[]{5L, 10L, 15L, 20L})).isEqualTo("[5, 10, 15, 20]");
    }

}
