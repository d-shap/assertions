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
 * Tests for {@link FloatArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public FloatArrayAssertionTest() {
        super();
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new FloatArrayAssertion(null, null).isEmpty();
        new FloatArrayAssertion(new float[]{}, null).isEmpty();

        try {
            new FloatArrayAssertion(new float[]{1.0f}, null).isEmpty();
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Array should be empty. Actual:<[1.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f}, null).isEmpty();
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Array should be empty. Actual:<[5.0, 10.0, 15.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new FloatArrayAssertion(new float[]{1.0f}, null).isNotEmpty();
        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f}, null).isNotEmpty();

        try {
            new FloatArrayAssertion(null, null).isNotEmpty();
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Array should not be empty.");
        }
        try {
            new FloatArrayAssertion(new float[]{}, null).isNotEmpty();
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Array should not be empty.");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        new FloatArrayAssertion(new float[]{}, null).isEqualTo(new float[]{});
        new FloatArrayAssertion(new float[]{1.0f}, null).isEqualTo(new float[]{1.0f});
        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f}, null).isEqualTo(new float[]{5.0f, 10.0f, 15.0f});

        try {
            new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f}, null).isEqualTo(new float[]{5.0f, 10.0f, 15.0f, 20.0f});
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5.0, 10.0, 15.0, 20.0]> but was:<[5.0, 10.0, 15.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, null).isEqualTo(new float[]{5.0f, 10.0f, 15.0f});
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5.0, 10.0, 15.0]> but was:<[5.0, 10.0, 15.0, 20.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f}, null).isEqualTo(new float[]{5.0f, 10.0f, 20.0f});
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5.0, 10.0, 20.0]> but was:<[5.0, 10.0, 15.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f}, null).isNotEqualTo(new float[]{5.0f, 10.0f, 15.0f, 20.0f});
        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, null).isNotEqualTo(new float[]{5.0f, 10.0f, 15.0f});
        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f}, null).isNotEqualTo(new float[]{5.0f, 10.0f, 20.0f});

        try {
            new FloatArrayAssertion(new float[]{}, null).isNotEqualTo(new float[]{});
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[]>");
        }
        try {
            new FloatArrayAssertion(new float[]{1.0f}, null).isNotEqualTo(new float[]{1.0f});
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1.0]>");
        }
        try {
            new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f}, null).isNotEqualTo(new float[]{5.0f, 10.0f, 15.0f});
            Assertions.fail("Float array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[5.0, 10.0, 15.0]>");
        }
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new FloatArrayAssertion(new float[]{}, null).toLength().isEqualTo(0);
        new FloatArrayAssertion(new float[]{1.0f}, null).toLength().isEqualTo(1);
        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f}, null).toLength().isEqualTo(3);
        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, null).toLength().isEqualTo(4);
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new FloatArrayAssertion(new float[]{}, null).hasLength(0);
        new FloatArrayAssertion(new float[]{1.0f}, null).hasLength(1);
        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f}, null).hasLength(3);
        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, null).hasLength(4);
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void toItemTest() {
        new FloatArrayAssertion(new float[]{1.0f}, null).toItem(0).isEqualTo(1.0f, 0.01f);

        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f}, null).toItem(0).isEqualTo(5.0f, 0.01f);
        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f}, null).toItem(1).isEqualTo(10.0f, 0.01f);
        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f}, null).toItem(2).isEqualTo(15.0f, 0.01f);

        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, null).toItem(0).isEqualTo(5.0f, 0.01f);
        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, null).toItem(1).isEqualTo(10.0f, 0.01f);
        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, null).toItem(2).isEqualTo(15.0f, 0.01f);
        new FloatArrayAssertion(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, null).toItem(3).isEqualTo(20.0f, 0.01f);
    }

    /**
     * {@link FloatArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new FloatArrayAssertion(null, null).asString(null)).isNull();
        Assertions.assertThat(new FloatArrayAssertion(null, null).asString(new float[]{1.0f})).isEqualTo("[1.0]");
        Assertions.assertThat(new FloatArrayAssertion(null, null).asString(new float[]{5.0f, 10.0f, 15.0f})).isEqualTo("[5.0, 10.0, 15.0]");
        Assertions.assertThat(new FloatArrayAssertion(null, null).asString(new float[]{5.0f, 10.0f, 15.0f, 20.0f})).isEqualTo("[5.0, 10.0, 15.0, 20.0]");
    }

}
