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
 * Tests for {@link ByteArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public ByteArrayAssertionTest() {
        super();
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new ByteArrayAssertion(null, null).isEmpty();
        new ByteArrayAssertion(new byte[]{}, null).isEmpty();

        try {
            new ByteArrayAssertion(new byte[]{1}, null).isEmpty();
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Array should be empty. Actual:<[1]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{5, 10, 15}, null).isEmpty();
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Array should be empty. Actual:<[5, 10, 15]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new ByteArrayAssertion(new byte[]{1}, null).isNotEmpty();
        new ByteArrayAssertion(new byte[]{5, 10, 15}, null).isNotEmpty();

        try {
            new ByteArrayAssertion(null, null).isNotEmpty();
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Array should not be empty.");
        }
        try {
            new ByteArrayAssertion(new byte[]{}, null).isNotEmpty();
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Array should not be empty.");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        new ByteArrayAssertion(new byte[]{}, null).isEqualTo(new byte[]{});
        new ByteArrayAssertion(new byte[]{1}, null).isEqualTo(new byte[]{1});
        new ByteArrayAssertion(new byte[]{5, 10, 15}, null).isEqualTo(new byte[]{5, 10, 15});

        try {
            new ByteArrayAssertion(new byte[]{5, 10, 15}, null).isEqualTo(new byte[]{5, 10, 15, 20});
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5, 10, 15, 20]> but was:<[5, 10, 15]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{5, 10, 15, 20}, null).isEqualTo(new byte[]{5, 10, 15});
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5, 10, 15]> but was:<[5, 10, 15, 20]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{5, 10, 15}, null).isEqualTo(new byte[]{5, 10, 20});
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[5, 10, 20]> but was:<[5, 10, 15]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new ByteArrayAssertion(new byte[]{5, 10, 15}, null).isNotEqualTo(new byte[]{5, 10, 15, 20});
        new ByteArrayAssertion(new byte[]{5, 10, 15, 20}, null).isNotEqualTo(new byte[]{5, 10, 15});
        new ByteArrayAssertion(new byte[]{5, 10, 15}, null).isNotEqualTo(new byte[]{5, 10, 20});

        try {
            new ByteArrayAssertion(new byte[]{}, null).isNotEqualTo(new byte[]{});
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{1}, null).isNotEqualTo(new byte[]{1});
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1]>");
        }
        try {
            new ByteArrayAssertion(new byte[]{5, 10, 15}, null).isNotEqualTo(new byte[]{5, 10, 15});
            Assertions.fail("Byte array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[5, 10, 15]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new ByteArrayAssertion(new byte[]{}, null).toLength().isEqualTo(0);
        new ByteArrayAssertion(new byte[]{1}, null).toLength().isEqualTo(1);
        new ByteArrayAssertion(new byte[]{5, 10, 15}, null).toLength().isEqualTo(3);
        new ByteArrayAssertion(new byte[]{5, 10, 15, 20}, null).toLength().isEqualTo(4);
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new ByteArrayAssertion(new byte[]{}, null).hasLength(0);
        new ByteArrayAssertion(new byte[]{1}, null).hasLength(1);
        new ByteArrayAssertion(new byte[]{5, 10, 15}, null).hasLength(3);
        new ByteArrayAssertion(new byte[]{5, 10, 15, 20}, null).hasLength(4);
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void toItemTest() {
        new ByteArrayAssertion(new byte[]{1}, null).toItem(0).isEqualTo((byte) 1);

        new ByteArrayAssertion(new byte[]{5, 10, 15}, null).toItem(0).isEqualTo((byte) 5);
        new ByteArrayAssertion(new byte[]{5, 10, 15}, null).toItem(1).isEqualTo((byte) 10);
        new ByteArrayAssertion(new byte[]{5, 10, 15}, null).toItem(2).isEqualTo((byte) 15);

        new ByteArrayAssertion(new byte[]{5, 10, 15, 20}, null).toItem(0).isEqualTo((byte) 5);
        new ByteArrayAssertion(new byte[]{5, 10, 15, 20}, null).toItem(1).isEqualTo((byte) 10);
        new ByteArrayAssertion(new byte[]{5, 10, 15, 20}, null).toItem(2).isEqualTo((byte) 15);
        new ByteArrayAssertion(new byte[]{5, 10, 15, 20}, null).toItem(3).isEqualTo((byte) 20);
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ByteArrayAssertion(null, null).asString(null)).isNull();
        Assertions.assertThat(new ByteArrayAssertion(null, null).asString(new byte[]{1})).isEqualTo("[1]");
        Assertions.assertThat(new ByteArrayAssertion(null, null).asString(new byte[]{5, 10, 15})).isEqualTo("[5, 10, 15]");
        Assertions.assertThat(new ByteArrayAssertion(null, null).asString(new byte[]{5, 10, 15, 20})).isEqualTo("[5, 10, 15, 20]");
    }

}
