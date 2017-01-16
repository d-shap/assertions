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
 * Tests for {@link CharArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public CharArrayAssertionTest() {
        super();
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new CharArrayAssertion(null, null).isEmpty();
        new CharArrayAssertion(new char[]{}, null).isEmpty();

        try {
            new CharArrayAssertion(new char[]{'a'}, null).isEmpty();
            Assertions.fail("Char array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Array should be empty. Actual:<[a]>");
        }
        try {
            new CharArrayAssertion(new char[]{'a', 'Z', 'Й'}, null).isEmpty();
            Assertions.fail("Char array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Array should be empty. Actual:<[a, Z, Й]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new CharArrayAssertion(new char[]{'a'}, null).isNotEmpty();
        new CharArrayAssertion(new char[]{'a', 'Z', 'Й'}, null).isNotEmpty();

        try {
            new CharArrayAssertion(null, null).isNotEmpty();
            Assertions.fail("Char array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Array should not be empty.");
        }
        try {
            new CharArrayAssertion(new char[]{}, null).isNotEmpty();
            Assertions.fail("Char array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Array should not be empty.");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        new CharArrayAssertion(new char[]{}, null).isEqualTo(new char[]{});
        new CharArrayAssertion(new char[]{'a'}, null).isEqualTo(new char[]{'a'});
        new CharArrayAssertion(new char[]{'a', 'Z', 'Й'}, null).isEqualTo(new char[]{'a', 'Z', 'Й'});

        try {
            new CharArrayAssertion(new char[]{'a', 'Z', 'Й'}, null).isEqualTo(new char[]{'a', 'Z', 'Й', '1'});
            Assertions.fail("Char array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[a, Z, Й, 1]> but was:<[a, Z, Й]>");
        }
        try {
            new CharArrayAssertion(new char[]{'a', 'Z', 'Й', '1'}, null).isEqualTo(new char[]{'a', 'Z', 'Й'});
            Assertions.fail("Char array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[a, Z, Й]> but was:<[a, Z, Й, 1]>");
        }
        try {
            new CharArrayAssertion(new char[]{'a', 'Z', 'Й'}, null).isEqualTo(new char[]{'a', 'Z', '1'});
            Assertions.fail("Char array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[a, Z, 1]> but was:<[a, Z, Й]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new CharArrayAssertion(new char[]{'a', 'Z', 'Й'}, null).isNotEqualTo(new char[]{'a', 'Z', 'Й', '1'});
        new CharArrayAssertion(new char[]{'a', 'Z', 'Й', '1'}, null).isNotEqualTo(new char[]{'a', 'Z', 'Й'});
        new CharArrayAssertion(new char[]{'a', 'Z', 'Й'}, null).isNotEqualTo(new char[]{'a', 'Z', '1'});

        try {
            new CharArrayAssertion(new char[]{}, null).isNotEqualTo(new char[]{});
            Assertions.fail("Char array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[]>");
        }
        try {
            new CharArrayAssertion(new char[]{'a'}, null).isNotEqualTo(new char[]{'a'});
            Assertions.fail("Char array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[a]>");
        }
        try {
            new CharArrayAssertion(new char[]{'a', 'Z', 'Й'}, null).isNotEqualTo(new char[]{'a', 'Z', 'Й'});
            Assertions.fail("Char array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[a, Z, Й]>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new CharArrayAssertion(new char[]{}, null).toLength().isEqualTo(0);
        new CharArrayAssertion(new char[]{'a'}, null).toLength().isEqualTo(1);
        new CharArrayAssertion(new char[]{'a', 'Z', 'Й'}, null).toLength().isEqualTo(3);
        new CharArrayAssertion(new char[]{'a', 'Z', 'Й', '1'}, null).toLength().isEqualTo(4);
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new CharArrayAssertion(new char[]{}, null).hasLength(0);
        new CharArrayAssertion(new char[]{'a'}, null).hasLength(1);
        new CharArrayAssertion(new char[]{'a', 'Z', 'Й'}, null).hasLength(3);
        new CharArrayAssertion(new char[]{'a', 'Z', 'Й', '1'}, null).hasLength(4);
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void toItemTest() {
        new CharArrayAssertion(new char[]{'a'}, null).toItem(0).isEqualTo('a');

        new CharArrayAssertion(new char[]{'a', 'Z', 'Й'}, null).toItem(0).isEqualTo('a');
        new CharArrayAssertion(new char[]{'a', 'Z', 'Й'}, null).toItem(1).isEqualTo('Z');
        new CharArrayAssertion(new char[]{'a', 'Z', 'Й'}, null).toItem(2).isEqualTo('Й');

        new CharArrayAssertion(new char[]{'a', 'Z', 'Й', '1'}, null).toItem(0).isEqualTo('a');
        new CharArrayAssertion(new char[]{'a', 'Z', 'Й', '1'}, null).toItem(1).isEqualTo('Z');
        new CharArrayAssertion(new char[]{'a', 'Z', 'Й', '1'}, null).toItem(2).isEqualTo('Й');
        new CharArrayAssertion(new char[]{'a', 'Z', 'Й', '1'}, null).toItem(3).isEqualTo('1');
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new CharArrayAssertion(null, null).asString(null)).isNull();
        Assertions.assertThat(new CharArrayAssertion(null, null).asString(new char[]{'a'})).isEqualTo("[a]");
        Assertions.assertThat(new CharArrayAssertion(null, null).asString(new char[]{'a', 'Z', 'Й'})).isEqualTo("[a, Z, Й]");
        Assertions.assertThat(new CharArrayAssertion(null, null).asString(new char[]{'a', 'Z', 'Й', '1'})).isEqualTo("[a, Z, Й, 1]");
    }

}
