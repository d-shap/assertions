///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions library provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions library.
//
// Assertions library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.converter;

import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ConverterKey}.
 *
 * @author Dmitry Shapovalov
 */
public final class ConverterKeyTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ConverterKeyTest() {
        super();
    }

    /**
     * {@link ConverterKey} class test.
     */
    @Test
    public void equalsTest() {
        ConverterKey objectKey = new ConverterKey(Object.class);
        ConverterKey objectKeyRef = objectKey;
        ConverterKey objectKey2 = new ConverterKey(Object.class, Object.class);
        ConverterKey objectKeyRef2 = objectKey2;
        ConverterKey nullKey = null;

        Assertions.assertThat(objectKey.equals(nullKey)).isFalse();
        Assertions.assertThat(objectKey2.equals(nullKey)).isFalse();

        Assertions.assertThat(objectKey.equals(objectKeyRef)).isTrue();
        Assertions.assertThat(objectKey.equals(objectKey2)).isTrue();
        Assertions.assertThat(objectKey2.equals(objectKeyRef2)).isTrue();
        Assertions.assertThat(objectKey2.equals(objectKey)).isTrue();

        Object obj1 = new ConverterKey(Object.class);
        Object obj2 = Object.class;
        Assertions.assertThat(obj1.equals(obj2)).isFalse();

        Assertions.assertThat(new ConverterKey(String.class, List.class).equals(new ConverterKey(String.class, List.class))).isTrue();
        Assertions.assertThat(new ConverterKey(String.class, List.class).equals(new ConverterKey(List.class, String.class))).isFalse();
        Assertions.assertThat(new ConverterKey(String.class, List.class).equals(new ConverterKey(String.class))).isFalse();
        Assertions.assertThat(new ConverterKey(String.class, List.class).equals(new ConverterKey(List.class))).isFalse();

        Assertions.assertThat(new ConverterKey(Object.class).equals(new ConverterKey(null))).isFalse();
        Assertions.assertThat(new ConverterKey(Object.class).equals(new ConverterKey(Object.class, null))).isFalse();
        Assertions.assertThat(new ConverterKey(Object.class).equals(new ConverterKey(null, Object.class))).isFalse();
    }

    /**
     * {@link ConverterKey} class test.
     */
    @Test(expected = NullPointerException.class)
    public void equalsNull1FailTest() {
        new ConverterKey(null).equals(new ConverterKey(Object.class));
    }

    /**
     * {@link ConverterKey} class test.
     */
    @Test(expected = NullPointerException.class)
    public void equalsNull2FailTest() {
        new ConverterKey(Object.class, null).equals(new ConverterKey(Object.class));
    }

    /**
     * {@link ConverterKey} class test.
     */
    @Test(expected = NullPointerException.class)
    public void equalsNull3FailTest() {
        new ConverterKey(null, Object.class).equals(new ConverterKey(Object.class));
    }

    /**
     * {@link ConverterKey} class test.
     */
    @Test
    public void hashCodeTest() {
        Assertions.assertThat(new ConverterKey(Object.class).hashCode()).isEqualTo(2127754022);
        Assertions.assertThat(new ConverterKey(Object.class, Object.class).hashCode()).isEqualTo(2127754022);

        Assertions.assertThat(new ConverterKey(String.class).hashCode()).isEqualTo(-1904448310);
        Assertions.assertThat(new ConverterKey(List.class).hashCode()).isEqualTo(131642556);
        Assertions.assertThat(new ConverterKey(String.class, List.class).hashCode()).isEqualTo(1261080771);
        Assertions.assertThat(new ConverterKey(List.class, String.class).hashCode()).isEqualTo(1261080771);
    }

    /**
     * {@link ConverterKey} class test.
     */
    @Test(expected = NullPointerException.class)
    public void hashCodeNull1FailTest() {
        new ConverterKey(null).hashCode();
    }

    /**
     * {@link ConverterKey} class test.
     */
    @Test(expected = NullPointerException.class)
    public void hashCodeNull2FailTest() {
        new ConverterKey(Object.class, null).hashCode();
    }

    /**
     * {@link ConverterKey} class test.
     */
    @Test(expected = NullPointerException.class)
    public void hashCodeNull3FailTest() {
        new ConverterKey(null, Object.class).hashCode();
    }

}
