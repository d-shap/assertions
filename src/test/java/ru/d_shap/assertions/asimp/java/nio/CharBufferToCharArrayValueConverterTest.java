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
     * @throws Exception exception in test.
     */
    @Test
    public void convertTest() throws Exception {
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), false), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), true), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}), false), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}), true), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}), false), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}), true), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}), false), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}), true), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1), false), Raw.charArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1), true), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 1), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1), false), Raw.charArrayAssertion()).containsExactlyInOrder('2');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('2');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1), true), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 1), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1), false), Raw.charArrayAssertion()).containsExactlyInOrder('2', '3', '4');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('2', '3', '4');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1), true), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 1), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', '3', '4');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1), false), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1), true), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 1), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1), false), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1), true), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 1), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1), false), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1), true), Raw.charArrayAssertion()).containsExactlyInOrder('1');
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2', '3', '4'}, 0, 1), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1');

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5), false), Raw.charArrayAssertion()).containsExactlyInOrder('1', 0, 0, 0, 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', 0, 0, 0, 0);

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5), true), Raw.charArrayAssertion()).containsExactlyInOrder('1', 0, 0, 0, 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1'}, 0, 5, 5), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', 0, 0, 0, 0);

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5), false)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5), false), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', 0, 0, 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5), false)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', 0, 0, 0);

        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5), true)).isInstanceOf(char[].class);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5), true), Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', 0, 0, 0);
        Assertions.assertThat(new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{'1', '2'}, 0, 5, 5), true)).as(Raw.charArrayAssertion()).containsExactlyInOrder('1', '2', 0, 0, 0);

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
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws Exception {
        new CharBufferToCharArrayValueConverter().convert(null);
    }

    /**
     * {@link CharBufferToCharArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws Exception {
        new CharBufferToCharArrayValueConverter().convert(new Object());
    }

    /**
     * {@link CharBufferToCharArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() throws Exception {
        new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}));
    }

    /**
     * {@link CharBufferToCharArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws Exception {
        new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), new Object(), new Object());
    }

    /**
     * {@link CharBufferToCharArrayValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws Exception {
        new CharBufferToCharArrayValueConverter().convert(createCharBuffer(new char[]{}), new Object());
    }

}
