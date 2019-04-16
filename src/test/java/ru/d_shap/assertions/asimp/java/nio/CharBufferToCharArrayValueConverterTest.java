///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions framework.
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
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.CharBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.converter.ConversionException;

/**
 * Tests for {@link CharBufferToCharArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharBufferToCharArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CharBufferToCharArrayValueConverterTest() {
        super();
    }

    /**
     * {@link CharBufferToCharArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().getValueClass()).isEqualTo(CharBuffer.class);
    }

    /**
     * {@link CharBufferToCharArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().getTargetClass()).isEqualTo(char[].class);
    }

    /**
     * {@link CharBufferToCharArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}))).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{})), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}))).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), false), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), true), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}))).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'})), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}))).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}), false), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}), true), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}))).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'})), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}))).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}), false), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}), true), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}))).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'})), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}))).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}), false), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}), true), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1))).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1)), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1))).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1), false), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1), true), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1))).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1)), Raw.charArrayAssertion()).containsExactlyInOrder('2');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1))).as(Raw.charArrayAssertion()).containsExactlyInOrder('2');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder('2');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder('2');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1), false), Raw.charArrayAssertion()).containsExactlyInOrder('2');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('2');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1), true), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1))).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1)), Raw.charArrayAssertion()).containsExactlyInOrder('2', '3', '4');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1))).as(Raw.charArrayAssertion()).containsExactlyInOrder('2', '3', '4');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder('2', '3', '4');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder('2', '3', '4');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1), false), Raw.charArrayAssertion()).containsExactlyInOrder('2', '3', '4');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('2', '3', '4');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1), true), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1))).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1)), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1))).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1), false), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1), true), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1))).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1)), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1))).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1), false), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1), true), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1))).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1)), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1))).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1), false), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1), true), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5))).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5)), Raw.charArrayAssertion()).containsExactlyInOrder('1', 0, 0, 0, 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5))).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', 0, 0, 0, 0);

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder('1', 0, 0, 0, 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', 0, 0, 0, 0);

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5), false), Raw.charArrayAssertion()).containsExactlyInOrder('1', 0, 0, 0, 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', 0, 0, 0, 0);

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5), true), Raw.charArrayAssertion()).containsExactlyInOrder('1', 0, 0, 0, 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', 0, 0, 0, 0);

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5))).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5)), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', 0, 0, 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5))).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', 0, 0, 0);

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', 0, 0, 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', 0, 0, 0);

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5), false), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', 0, 0, 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', 0, 0, 0);

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5), true), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', 0, 0, 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', 0, 0, 0);

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 5, 5))).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 5, 5)), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4', 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 5, 5))).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4', 0);

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 5, 5), (Object) null)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 5, 5), (Object) null), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4', 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 5, 5), (Object) null)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4', 0);

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 5, 5), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 5, 5), false), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4', 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 5, 5), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4', 0);

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 5, 5), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 5, 5), true), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4', 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 5, 5), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4', 0);
    }

    /**
     * {@link CharBufferToCharArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new CharBufferToCharArrayValueConverter().convert(null);
    }

    /**
     * {@link CharBufferToCharArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new CharBufferToCharArrayValueConverter().convert(new Object());
    }

    /**
     * {@link CharBufferToCharArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws ConversionException {
        new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), new Object(), new Object());
    }

    /**
     * {@link CharBufferToCharArrayValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws ConversionException {
        new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), new Object());
    }

}
