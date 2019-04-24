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

import java.nio.DoubleBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link DoubleBufferAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleBufferAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DoubleBufferAsStringConverterTest() {
        super();
    }

    /**
     * {@link DoubleBufferAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new DoubleBufferAsStringConverter().getValueClass()).isEqualTo(DoubleBuffer.class);
    }

    /**
     * {@link DoubleBufferAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void asStringTest() throws Exception {
        Assertions.assertThat(new DoubleBufferAsStringConverter().asString(createDoubleBuffer(new double[]{}))).isEqualTo("<EMPTY>");

        Assertions.assertThat(new DoubleBufferAsStringConverter().asString(createDoubleBuffer(new double[]{1.0}))).isEqualTo("[1.0]");
        Assertions.assertThat(new DoubleBufferAsStringConverter().asString(createDoubleBuffer(new double[]{1.0, 2.0}))).isEqualTo("[1.0, 2.0]");
        Assertions.assertThat(new DoubleBufferAsStringConverter().asString(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}))).isEqualTo("[1.0, 2.0, 3.0, 4.0]");

        Assertions.assertThat(new DoubleBufferAsStringConverter().asString(createDoubleBuffer(new double[]{1.0}, 1))).isEqualTo("<EMPTY>");
        Assertions.assertThat(new DoubleBufferAsStringConverter().asString(createDoubleBuffer(new double[]{1.0, 2.0}, 1))).isEqualTo("[2.0]");
        Assertions.assertThat(new DoubleBufferAsStringConverter().asString(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 1))).isEqualTo("[2.0, 3.0, 4.0]");

        Assertions.assertThat(new DoubleBufferAsStringConverter().asString(createDoubleBuffer(new double[]{1.0}, 0, 1))).isEqualTo("[1.0]");
        Assertions.assertThat(new DoubleBufferAsStringConverter().asString(createDoubleBuffer(new double[]{1.0, 2.0}, 0, 1))).isEqualTo("[1.0]");
        Assertions.assertThat(new DoubleBufferAsStringConverter().asString(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 0, 1))).isEqualTo("[1.0]");

        Assertions.assertThat(new DoubleBufferAsStringConverter().asString(createDoubleBuffer(new double[]{1.0}, 0, 5, 5))).isEqualTo("[1.0, 0.0, 0.0, 0.0, 0.0]");
        Assertions.assertThat(new DoubleBufferAsStringConverter().asString(createDoubleBuffer(new double[]{1.0, 2.0}, 0, 5, 5))).isEqualTo("[1.0, 2.0, 0.0, 0.0, 0.0]");
        Assertions.assertThat(new DoubleBufferAsStringConverter().asString(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0}, 0, 5, 5))).isEqualTo("[1.0, 2.0, 3.0, 4.0, 0.0]");
    }

    /**
     * {@link DoubleBufferAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws Exception {
        new DoubleBufferAsStringConverter().asString(null);
    }

    /**
     * {@link DoubleBufferAsStringConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws Exception {
        new DoubleBufferAsStringConverter().asString(new Object());
    }

}
