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
 * Tests for {@link ObjectArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ObjectArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public ObjectArrayAssertionTest() {
        super();
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new ObjectArrayAssertion(null, null).isEmpty();
        new ObjectArrayAssertion(new Object[]{}, null).isEmpty();

        try {
            new ObjectArrayAssertion(new Object[]{"val1"}, null).isEmpty();
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[val1]>");
        }
        try {
            new ObjectArrayAssertion(new Object[]{"val5", "val10", "val15"}, null).isEmpty();
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[val5, val10, val15]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new ObjectArrayAssertion(new Object[]{"val1"}, null).isNotEmpty();
        new ObjectArrayAssertion(new Object[]{"val5", "val10", "val15"}, null).isNotEmpty();

        try {
            new ObjectArrayAssertion(null, null).isNotEmpty();
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new ObjectArrayAssertion(new Object[]{}, null).isNotEmpty();
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        new ObjectArrayAssertion(new Object[]{}, null).isEqualTo();
        new ObjectArrayAssertion(new Object[]{"val1"}, null).isEqualTo("val1");
        new ObjectArrayAssertion(new Object[]{"val5", "val10", "val15"}, null).isEqualTo("val5", "val10", "val15");

        try {
            new ObjectArrayAssertion(new Object[]{"val5", "val10", "val15"}, null).isEqualTo("val5", "val10", "val15", "val20");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[val5, val10, val15, val20]> but was:<[val5, val10, val15]>");
        }
        try {
            new ObjectArrayAssertion(new Object[]{"val5", "val10", "val15", "val20"}, null).isEqualTo("val5", "val10", "val15");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[val5, val10, val15]> but was:<[val5, val10, val15, val20]>");
        }
        try {
            new ObjectArrayAssertion(new Object[]{"val5", "val10", "val15"}, null).isEqualTo("val5", "val10", "val20");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[val5, val10, val20]> but was:<[val5, val10, val15]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new ObjectArrayAssertion(new Object[]{"val5", "val10", "val15"}, null).isNotEqualTo("val5", "val10", "val15", "val20");
        new ObjectArrayAssertion(new Object[]{"val5", "val10", "val15", "val20"}, null).isNotEqualTo("val5", "val10", "val15");
        new ObjectArrayAssertion(new Object[]{"val5", "val10", "val15"}, null).isNotEqualTo("val5", "val10", "val20");

        try {
            new ObjectArrayAssertion(new Object[]{}, null).isNotEqualTo();
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[]>");
        }
        try {
            new ObjectArrayAssertion(new Object[]{"val1"}, null).isNotEqualTo("val1");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[val1]>");
        }
        try {
            new ObjectArrayAssertion(new Object[]{"val5", "val10", "val15"}, null).isNotEqualTo("val5", "val10", "val15");
            Assertions.fail("Object array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[val5, val10, val15]>");
        }
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new ObjectArrayAssertion(new Object[]{}, null).toLength().isEqualTo(0);
        new ObjectArrayAssertion(new Object[]{"val1"}, null).toLength().isEqualTo(1);
        new ObjectArrayAssertion(new Object[]{"val5", "val10", "val15"}, null).toLength().isEqualTo(3);
        new ObjectArrayAssertion(new Object[]{"val5", "val10", "val15", "val20"}, null).toLength().isEqualTo(4);
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new ObjectArrayAssertion(new Object[]{}, null).hasLength(0);
        new ObjectArrayAssertion(new Object[]{"val1"}, null).hasLength(1);
        new ObjectArrayAssertion(new Object[]{"val5", "val10", "val15"}, null).hasLength(3);
        new ObjectArrayAssertion(new Object[]{"val5", "val10", "val15", "val20"}, null).hasLength(4);
    }

    /**
     * {@link ObjectArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ObjectArrayAssertion(null, null).asString(null)).isNull();
        Assertions.assertThat(new ObjectArrayAssertion(null, null).asString("test")).isEqualTo("test");
        Assertions.assertThat(new ObjectArrayAssertion(null, null).asString(new Object[]{"val1"})).isEqualTo("[val1]");
        Assertions.assertThat(new ObjectArrayAssertion(null, null).asString(new Object[]{"val5", "val10", "val15"})).isEqualTo("[val5, val10, val15]");
        Assertions.assertThat(new ObjectArrayAssertion(null, null).asString(new Object[]{"val5", "val10", "val15", "val20"})).isEqualTo("[val5, val10, val15, val20]");
    }

}
