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

        try {
            InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setAvailableException("fail").buildInputStream();
            Assertions.assertThat(inputStream.available()).isEqualTo(5);
            inputStream.read();
            inputStream.read();
            inputStream.read();
            Assertions.assertThat(inputStream.available()).isEqualTo(2);
            inputStream.read();
            inputStream.read();
            inputStream.available();
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
        InputStream inputStream1 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream();
        Assertions.assertThat(inputStream1.read()).isEqualTo(1);
        Assertions.assertThat(inputStream1.read()).isEqualTo(2);
        Assertions.assertThat(inputStream1.read()).isEqualTo(3);
        Assertions.assertThat(inputStream1.read()).isEqualTo(4);
        Assertions.assertThat(inputStream1.read()).isEqualTo(5);
        Assertions.assertThat(inputStream1.read()).isEqualTo(-1);
        Assertions.assertThat(inputStream1.read()).isEqualTo(-1);

        InputStream inputStream2 = DataHelper.createInputStreamBuilder().setContent(new byte[]{}).buildInputStream();
        Assertions.assertThat(inputStream2.read()).isEqualTo(-1);

        InputStream inputStream3 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setAvailableException("ex").buildInputStream();
        Assertions.assertThat(inputStream3.read()).isEqualTo(1);
        Assertions.assertThat(inputStream3.read()).isEqualTo(-1);

        InputStream inputStream4 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setSkipException("ex").buildInputStream();
        Assertions.assertThat(inputStream4.read()).isEqualTo(1);
        Assertions.assertThat(inputStream4.read()).isEqualTo(-1);

        InputStream inputStream5 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setCloseException("ex").buildInputStream();
        Assertions.assertThat(inputStream5.read()).isEqualTo(1);
        Assertions.assertThat(inputStream5.read()).isEqualTo(-1);

        try {
            DataHelper.createInputStreamBuilder().setReadException(new IOException("fail")).buildInputStream().read();
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createInputStreamBuilder().setReadException("fail").buildInputStream().read();
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        try {
            InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setReadException("fail").buildInputStream();
            inputStream.read();
            inputStream.read();
            inputStream.read();
            Assertions.assertThat(inputStream.read()).isEqualTo(4);
            inputStream.read();
            inputStream.read();
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
    public void readByteArrayTest() throws IOException {
        InputStream inputStream1 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream();
        byte[] buff1 = new byte[3];
        Assertions.assertThat(inputStream1.read(buff1, 0, 3)).isEqualTo(3);
        Assertions.assertThat(buff1).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(inputStream1.read(buff1, 0, 3)).isEqualTo(2);
        Assertions.assertThat(buff1).containsExactlyInOrder(4, 5, 3);

        InputStream inputStream2 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream();
        byte[] buff2 = new byte[3];
        Assertions.assertThat(inputStream2.read(buff2, 0, 2)).isEqualTo(2);
        Assertions.assertThat(buff2).containsExactlyInOrder(1, 2, 0);
        Assertions.assertThat(inputStream2.read(buff2, 0, 2)).isEqualTo(2);
        Assertions.assertThat(buff2).containsExactlyInOrder(3, 4, 0);
        Assertions.assertThat(inputStream2.read(buff2, 0, 2)).isEqualTo(1);
        Assertions.assertThat(buff2).containsExactlyInOrder(5, 4, 0);

        InputStream inputStream3 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream();
        byte[] buff3 = new byte[3];
        Assertions.assertThat(inputStream3.read(buff3, 1, 2)).isEqualTo(2);
        Assertions.assertThat(buff3).containsExactlyInOrder(0, 1, 2);
        Assertions.assertThat(inputStream3.read(buff3, 1, 2)).isEqualTo(2);
        Assertions.assertThat(buff3).containsExactlyInOrder(0, 3, 4);
        Assertions.assertThat(inputStream3.read(buff3, 1, 2)).isEqualTo(1);
        Assertions.assertThat(buff3).containsExactlyInOrder(0, 5, 4);

        InputStream inputStream4 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream();
        byte[] buff4 = new byte[5];
        Assertions.assertThat(inputStream4.read(buff4, 0, 5)).isEqualTo(5);
        Assertions.assertThat(buff4).containsExactlyInOrder(1, 2, 3, 4, 5);
        Assertions.assertThat(inputStream4.read(buff4, 0, 5)).isEqualTo(0);
        Assertions.assertThat(buff4).containsExactlyInOrder(1, 2, 3, 4, 5);

        InputStream inputStream5 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream();
        byte[] buff5 = new byte[10];
        Assertions.assertThat(inputStream5.read(buff5, 0, 10)).isEqualTo(5);
        Assertions.assertThat(buff5).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);
        Assertions.assertThat(inputStream5.read(buff5, 0, 10)).isEqualTo(0);
        Assertions.assertThat(buff5).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);

        InputStream inputStream6 = DataHelper.createInputStreamBuilder().setContent(new byte[]{}).buildInputStream();
        byte[] buff6 = new byte[10];
        Assertions.assertThat(inputStream6.read(buff6, 0, 10)).isEqualTo(0);
        Assertions.assertThat(buff6).containsExactlyInOrder(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Assertions.assertThat(inputStream6.read(buff6, 0, 10)).isEqualTo(0);
        Assertions.assertThat(buff6).containsExactlyInOrder(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        InputStream inputStream7 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setAvailableException("ex").buildInputStream();
        byte[] buff7 = new byte[10];
        Assertions.assertThat(inputStream7.read(buff7, 0, 10)).isEqualTo(5);
        Assertions.assertThat(buff7).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);
        Assertions.assertThat(inputStream7.read(buff7, 0, 10)).isEqualTo(0);
        Assertions.assertThat(buff7).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);

        InputStream inputStream8 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setSkipException("ex").buildInputStream();
        byte[] buff8 = new byte[10];
        Assertions.assertThat(inputStream8.read(buff8, 0, 10)).isEqualTo(5);
        Assertions.assertThat(buff8).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);
        Assertions.assertThat(inputStream8.read(buff8, 0, 10)).isEqualTo(0);
        Assertions.assertThat(buff8).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);

        InputStream inputStream9 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setCloseException("ex").buildInputStream();
        byte[] buff9 = new byte[10];
        Assertions.assertThat(inputStream9.read(buff9, 0, 10)).isEqualTo(5);
        Assertions.assertThat(buff9).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);
        Assertions.assertThat(inputStream9.read(buff9, 0, 10)).isEqualTo(0);
        Assertions.assertThat(buff9).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);
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
