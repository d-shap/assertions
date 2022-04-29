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
package ru.d_shap.assertions.mock;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link MockInputStream}.
 *
 * @author Dmitry Shapovalov
 */
public final class MockInputStreamTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public MockInputStreamTest() {
        super();
    }

    /**
     * {@link MockInputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void availableTest() throws IOException {
        Assertions.assertThat(DataHelper.createInputStreamBuilder().buildInputStream().available()).isEqualTo(0);
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setContent(new byte[]{}).buildInputStream().available()).isEqualTo(0);
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).buildInputStream().available()).isEqualTo(1);
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2}).buildInputStream().available()).isEqualTo(2);
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3}).buildInputStream().available()).isEqualTo(3);
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3}).setReadException("ex").buildInputStream().available()).isEqualTo(3);
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3}).setSkipException("ex").buildInputStream().available()).isEqualTo(3);
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3}).setCloseException("ex").buildInputStream().available()).isEqualTo(3);

        InputStream inputStream1 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream();
        Assertions.assertThat(inputStream1.available()).isEqualTo(5);
        inputStream1.read();
        Assertions.assertThat(inputStream1.available()).isEqualTo(4);
        inputStream1.read();
        Assertions.assertThat(inputStream1.available()).isEqualTo(3);
        inputStream1.read();
        Assertions.assertThat(inputStream1.available()).isEqualTo(2);
        inputStream1.read();
        Assertions.assertThat(inputStream1.available()).isEqualTo(1);
        inputStream1.read();
        Assertions.assertThat(inputStream1.available()).isEqualTo(0);
        inputStream1.read();
        Assertions.assertThat(inputStream1.available()).isEqualTo(0);

        try {
            DataHelper.createInputStreamBuilder().setAvailableException(new IOException("fail")).buildInputStream().available();
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createInputStreamBuilder().setAvailableException("fail").buildInputStream().available();
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        InputStream inputStream2 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setAvailableException("fail").buildInputStream();
        Assertions.assertThat(inputStream2.available()).isEqualTo(5);
        inputStream2.read();
        inputStream2.read();
        inputStream2.read();
        Assertions.assertThat(inputStream2.available()).isEqualTo(2);
        inputStream2.read();
        inputStream2.read();
        try {
            inputStream2.available();
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
    }

    /**
     * {@link MockInputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void readByteTest() throws IOException {
        // TODO
    }

    /**
     * {@link MockInputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void readByteArrayTest() throws IOException {
        // TODO
    }

    /**
     * {@link MockInputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void skipTest() throws IOException {
        // TODO
    }

    /**
     * {@link MockInputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void closeTest() throws IOException {
        // TODO
    }

    /**
     * {@link MockInputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void isClosedTest() throws IOException {
        // TODO
    }

}
