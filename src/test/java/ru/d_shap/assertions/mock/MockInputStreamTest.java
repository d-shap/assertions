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

import java.io.ByteArrayInputStream;
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
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setAvailableException(false, new IOException("ex")).buildInputStream().available()).isEqualTo(0);
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setAvailableException(false, "ex").buildInputStream().available()).isEqualTo(0);
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3}).setAvailableException(false, new IOException("ex")).buildInputStream().available()).isEqualTo(3);
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3}).setAvailableException(false, "ex").buildInputStream().available()).isEqualTo(3);
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3}).setReadException("ex").buildInputStream().available()).isEqualTo(3);
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3}).setSkipException("ex").buildInputStream().available()).isEqualTo(3);
        Assertions.assertThat(DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3}).setCloseException("ex").buildInputStream().available()).isEqualTo(3);

        InputStream inputStream01 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream();
        Assertions.assertThat(inputStream01.available()).isEqualTo(5);
        inputStream01.read();
        Assertions.assertThat(inputStream01.available()).isEqualTo(4);
        inputStream01.read();
        Assertions.assertThat(inputStream01.available()).isEqualTo(3);
        inputStream01.read();
        Assertions.assertThat(inputStream01.available()).isEqualTo(2);
        inputStream01.read();
        Assertions.assertThat(inputStream01.available()).isEqualTo(1);
        inputStream01.read();
        Assertions.assertThat(inputStream01.available()).isEqualTo(0);
        inputStream01.read();
        Assertions.assertThat(inputStream01.available()).isEqualTo(0);

        try {
            DataHelper.createInputStreamBuilder().setAvailableException(new IOException("fail")).buildInputStream().available();
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createInputStreamBuilder().setAvailableException(true, new IOException("fail")).buildInputStream().available();
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
            DataHelper.createInputStreamBuilder().setAvailableException(true, "fail").buildInputStream().available();
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        InputStream inputStream02 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setAvailableException("fail").buildInputStream();
        Assertions.assertThat(inputStream02.available()).isEqualTo(5);
        inputStream02.read();
        inputStream02.read();
        inputStream02.read();
        Assertions.assertThat(inputStream02.available()).isEqualTo(2);
        inputStream02.read();
        inputStream02.read();
        try {
            inputStream02.available();
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
        InputStream inputStream01 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5, 0, 6, -5, -3}).buildInputStream();
        Assertions.assertThat(inputStream01.read()).isEqualTo(1);
        Assertions.assertThat(inputStream01.read()).isEqualTo(2);
        Assertions.assertThat(inputStream01.read()).isEqualTo(3);
        Assertions.assertThat(inputStream01.read()).isEqualTo(4);
        Assertions.assertThat(inputStream01.read()).isEqualTo(5);
        Assertions.assertThat(inputStream01.read()).isEqualTo(0);
        Assertions.assertThat(inputStream01.read()).isEqualTo(6);
        Assertions.assertThat(inputStream01.read()).isEqualTo(251);
        Assertions.assertThat(inputStream01.read()).isEqualTo(253);
        Assertions.assertThat(inputStream01.read()).isEqualTo(-1);
        Assertions.assertThat(inputStream01.read()).isEqualTo(-1);

        ByteArrayInputStream bais01 = new ByteArrayInputStream(new byte[]{1, 2, 3, 4, 5, 0, 6, -5, -3});
        Assertions.assertThat(bais01.read()).isEqualTo(1);
        Assertions.assertThat(bais01.read()).isEqualTo(2);
        Assertions.assertThat(bais01.read()).isEqualTo(3);
        Assertions.assertThat(bais01.read()).isEqualTo(4);
        Assertions.assertThat(bais01.read()).isEqualTo(5);
        Assertions.assertThat(bais01.read()).isEqualTo(0);
        Assertions.assertThat(bais01.read()).isEqualTo(6);
        Assertions.assertThat(bais01.read()).isEqualTo(251);
        Assertions.assertThat(bais01.read()).isEqualTo(253);
        Assertions.assertThat(bais01.read()).isEqualTo(-1);
        Assertions.assertThat(bais01.read()).isEqualTo(-1);

        InputStream inputStream02 = DataHelper.createInputStreamBuilder().setContent(new byte[]{}).buildInputStream();
        Assertions.assertThat(inputStream02.read()).isEqualTo(-1);

        InputStream inputStream03 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setAvailableException("ex").buildInputStream();
        Assertions.assertThat(inputStream03.read()).isEqualTo(1);
        Assertions.assertThat(inputStream03.read()).isEqualTo(-1);

        InputStream inputStream04 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setReadException(false, new IOException("ex")).buildInputStream();
        Assertions.assertThat(inputStream04.read()).isEqualTo(1);
        Assertions.assertThat(inputStream04.read()).isEqualTo(-1);

        InputStream inputStream05 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setReadException(false, "ex").buildInputStream();
        Assertions.assertThat(inputStream05.read()).isEqualTo(1);
        Assertions.assertThat(inputStream05.read()).isEqualTo(-1);

        InputStream inputStream06 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setSkipException("ex").buildInputStream();
        Assertions.assertThat(inputStream06.read()).isEqualTo(1);
        Assertions.assertThat(inputStream06.read()).isEqualTo(-1);

        InputStream inputStream07 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setCloseException("ex").buildInputStream();
        Assertions.assertThat(inputStream07.read()).isEqualTo(1);
        Assertions.assertThat(inputStream07.read()).isEqualTo(-1);

        try {
            DataHelper.createInputStreamBuilder().setReadException(new IOException("fail")).buildInputStream().read();
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createInputStreamBuilder().setReadException(true, new IOException("fail")).buildInputStream().read();
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
            DataHelper.createInputStreamBuilder().setReadException(true, "fail").buildInputStream().read();
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        InputStream inputStream08 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setReadException("fail").buildInputStream();
        inputStream08.read();
        inputStream08.read();
        inputStream08.read();
        Assertions.assertThat(inputStream08.read()).isEqualTo(4);
        inputStream08.read();
        try {
            inputStream08.read();
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
        InputStream inputStream01 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 0, 5, 6, -5}).buildInputStream();
        byte[] buff0111 = new byte[0];
        Assertions.assertThat(inputStream01.read(buff0111, 0, 0)).isEqualTo(0);
        Assertions.assertThat(buff0111).containsExactlyInOrder();
        byte[] buff0112 = new byte[3];
        Assertions.assertThat(inputStream01.read(buff0112, 0, 3)).isEqualTo(3);
        Assertions.assertThat(buff0112).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(inputStream01.read(buff0112, 0, 3)).isEqualTo(3);
        Assertions.assertThat(buff0112).containsExactlyInOrder(4, 0, 5);
        Assertions.assertThat(inputStream01.read(buff0112, 0, 3)).isEqualTo(2);
        Assertions.assertThat(buff0112).containsExactlyInOrder(6, -5, 5);

        ByteArrayInputStream bais01 = new ByteArrayInputStream(new byte[]{1, 2, 3, 4, 0, 5, 6, -5});
        byte[] buff0121 = new byte[0];
        Assertions.assertThat(bais01.read(buff0121, 0, 0)).isEqualTo(0);
        Assertions.assertThat(buff0121).containsExactlyInOrder();
        byte[] buff0122 = new byte[3];
        Assertions.assertThat(bais01.read(buff0122, 0, 3)).isEqualTo(3);
        Assertions.assertThat(buff0122).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(bais01.read(buff0122, 0, 3)).isEqualTo(3);
        Assertions.assertThat(buff0122).containsExactlyInOrder(4, 0, 5);
        Assertions.assertThat(bais01.read(buff0122, 0, 3)).isEqualTo(2);
        Assertions.assertThat(buff0122).containsExactlyInOrder(6, -5, 5);

        InputStream inputStream02 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream();
        byte[] buff02 = new byte[3];
        Assertions.assertThat(inputStream02.read(buff02, 0, 2)).isEqualTo(2);
        Assertions.assertThat(buff02).containsExactlyInOrder(1, 2, 0);
        Assertions.assertThat(inputStream02.read(buff02, 0, 2)).isEqualTo(2);
        Assertions.assertThat(buff02).containsExactlyInOrder(3, 4, 0);
        Assertions.assertThat(inputStream02.read(buff02, 0, 2)).isEqualTo(1);
        Assertions.assertThat(buff02).containsExactlyInOrder(5, 4, 0);

        InputStream inputStream03 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream();
        byte[] buff03 = new byte[3];
        Assertions.assertThat(inputStream03.read(buff03, 1, 2)).isEqualTo(2);
        Assertions.assertThat(buff03).containsExactlyInOrder(0, 1, 2);
        Assertions.assertThat(inputStream03.read(buff03, 1, 2)).isEqualTo(2);
        Assertions.assertThat(buff03).containsExactlyInOrder(0, 3, 4);
        Assertions.assertThat(inputStream03.read(buff03, 1, 2)).isEqualTo(1);
        Assertions.assertThat(buff03).containsExactlyInOrder(0, 5, 4);

        InputStream inputStream04 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream();
        byte[] buff04 = new byte[5];
        Assertions.assertThat(inputStream04.read(buff04, 0, 5)).isEqualTo(5);
        Assertions.assertThat(buff04).containsExactlyInOrder(1, 2, 3, 4, 5);
        Assertions.assertThat(inputStream04.read(buff04, 0, 5)).isEqualTo(-1);
        Assertions.assertThat(buff04).containsExactlyInOrder(1, 2, 3, 4, 5);

        InputStream inputStream05 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5, 0, 6}).buildInputStream();
        byte[] buff05 = new byte[10];
        Assertions.assertThat(inputStream05.read(buff05, 0, 10)).isEqualTo(7);
        Assertions.assertThat(buff05).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 6, 0, 0, 0);
        Assertions.assertThat(inputStream05.read(buff05, 0, 10)).isEqualTo(-1);
        Assertions.assertThat(buff05).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 6, 0, 0, 0);

        InputStream inputStream06 = DataHelper.createInputStreamBuilder().setContent(new byte[]{}).buildInputStream();
        byte[] buff06 = new byte[10];
        Assertions.assertThat(inputStream06.read(buff06, 0, 10)).isEqualTo(-1);
        Assertions.assertThat(buff06).containsExactlyInOrder(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Assertions.assertThat(inputStream06.read(buff06, 0, 10)).isEqualTo(-1);
        Assertions.assertThat(buff06).containsExactlyInOrder(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        InputStream inputStream07 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setAvailableException("ex").buildInputStream();
        byte[] buff07 = new byte[10];
        Assertions.assertThat(inputStream07.read(buff07, 0, 10)).isEqualTo(5);
        Assertions.assertThat(buff07).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);
        Assertions.assertThat(inputStream07.read(buff07, 0, 10)).isEqualTo(-1);
        Assertions.assertThat(buff07).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);

        InputStream inputStream08 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setReadException(false, new IOException("ex")).buildInputStream();
        byte[] buff08 = new byte[10];
        Assertions.assertThat(inputStream08.read(buff08, 0, 10)).isEqualTo(5);
        Assertions.assertThat(buff08).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);
        Assertions.assertThat(inputStream08.read(buff08, 0, 10)).isEqualTo(-1);
        Assertions.assertThat(buff08).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);

        InputStream inputStream09 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setReadException(false, "ex").buildInputStream();
        byte[] buff09 = new byte[10];
        Assertions.assertThat(inputStream09.read(buff09, 0, 10)).isEqualTo(5);
        Assertions.assertThat(buff09).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);
        Assertions.assertThat(inputStream09.read(buff09, 0, 10)).isEqualTo(-1);
        Assertions.assertThat(buff09).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);

        InputStream inputStream10 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setSkipException("ex").buildInputStream();
        byte[] buff10 = new byte[10];
        Assertions.assertThat(inputStream10.read(buff10, 0, 10)).isEqualTo(5);
        Assertions.assertThat(buff10).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);
        Assertions.assertThat(inputStream10.read(buff10, 0, 10)).isEqualTo(-1);
        Assertions.assertThat(buff10).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);

        InputStream inputStream11 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setCloseException("ex").buildInputStream();
        byte[] buff11 = new byte[10];
        Assertions.assertThat(inputStream11.read(buff11, 0, 0)).isEqualTo(0);
        Assertions.assertThat(buff11).containsExactlyInOrder(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Assertions.assertThat(inputStream11.read(buff11, 0, 10)).isEqualTo(5);
        Assertions.assertThat(buff11).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);
        Assertions.assertThat(inputStream11.read(buff11, 0, 10)).isEqualTo(-1);
        Assertions.assertThat(buff11).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);

        try {
            DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream().read(null, 0, 10);
            Assertions.fail("MockInputStream test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).hasMessage("buffer is null");
        }
        try {
            DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream().read(null, -1, 10);
            Assertions.fail("MockInputStream test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).hasMessage("buffer is null");
        }
        try {
            DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream().read(new byte[5], -1, 10);
            Assertions.fail("MockInputStream test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("offset is out of bounds");
        }
        try {
            DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream().read(new byte[5], 5, 10);
            Assertions.fail("MockInputStream test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("offset is out of bounds");
        }
        try {
            DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream().read(new byte[5], 0, -1);
            Assertions.fail("MockInputStream test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("length is out of bounds");
        }
        try {
            DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream().read(new byte[5], 0, 6);
            Assertions.fail("MockInputStream test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("length is out of bounds");
        }
        try {
            DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream().read(new byte[5], 4, 2);
            Assertions.fail("MockInputStream test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("length is out of bounds");
        }
        try {
            DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream().read(new byte[0], 1, 0);
            Assertions.fail("MockInputStream test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("offset is out of bounds");
        }
        try {
            InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setReadException(new IOException("fail")).buildInputStream();
            byte[] buff = new byte[10];
            inputStream.read(buff, 0, 10);
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setReadException(true, new IOException("fail")).buildInputStream();
            byte[] buff = new byte[10];
            inputStream.read(buff, 0, 10);
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setReadException("fail").buildInputStream();
            byte[] buff = new byte[10];
            inputStream.read(buff, 0, 10);
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setReadException(true, "fail").buildInputStream();
            byte[] buff = new byte[10];
            inputStream.read(buff, 0, 10);
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        InputStream inputStream12 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setReadException("fail").buildInputStream();
        byte[] buff12 = new byte[10];
        try {
            inputStream12.read(buff12, 0, 10);
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        Assertions.assertThat(buff12).containsExactlyInOrder(1, 2, 3, 4, 5, 0, 0, 0, 0, 0);
    }

    /**
     * {@link MockInputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void skipTest() throws IOException {
        InputStream inputStream01 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream();
        Assertions.assertThat(inputStream01.skip(1)).isEqualTo(1);
        Assertions.assertThat(inputStream01.skip(1)).isEqualTo(1);
        Assertions.assertThat(inputStream01.skip(1)).isEqualTo(1);
        Assertions.assertThat(inputStream01.skip(1)).isEqualTo(1);
        Assertions.assertThat(inputStream01.skip(1)).isEqualTo(1);
        Assertions.assertThat(inputStream01.skip(1)).isEqualTo(0);
        Assertions.assertThat(inputStream01.skip(1)).isEqualTo(0);

        InputStream inputStream02 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream();
        Assertions.assertThat(inputStream02.skip(3)).isEqualTo(3);
        Assertions.assertThat(inputStream02.skip(3)).isEqualTo(2);
        Assertions.assertThat(inputStream02.skip(3)).isEqualTo(0);
        Assertions.assertThat(inputStream02.skip(3)).isEqualTo(0);

        InputStream inputStream03 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream();
        Assertions.assertThat(inputStream03.skip(5)).isEqualTo(5);
        Assertions.assertThat(inputStream03.skip(5)).isEqualTo(0);
        Assertions.assertThat(inputStream03.skip(5)).isEqualTo(0);

        InputStream inputStream04 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5, 0, 6}).buildInputStream();
        Assertions.assertThat(inputStream04.skip(10)).isEqualTo(7);
        Assertions.assertThat(inputStream04.skip(10)).isEqualTo(0);
        Assertions.assertThat(inputStream04.skip(10)).isEqualTo(0);

        InputStream inputStream05 = DataHelper.createInputStreamBuilder().setContent(new byte[]{}).buildInputStream();
        Assertions.assertThat(inputStream05.skip(3)).isEqualTo(0);

        InputStream inputStream06 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setAvailableException("ex").buildInputStream();
        Assertions.assertThat(inputStream06.skip(2)).isEqualTo(1);
        Assertions.assertThat(inputStream06.skip(2)).isEqualTo(0);

        InputStream inputStream07 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setReadException("ex").buildInputStream();
        Assertions.assertThat(inputStream07.skip(2)).isEqualTo(1);
        Assertions.assertThat(inputStream07.skip(2)).isEqualTo(0);

        InputStream inputStream08 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setSkipException(false, new IOException("ex")).buildInputStream();
        Assertions.assertThat(inputStream08.skip(2)).isEqualTo(1);
        Assertions.assertThat(inputStream08.skip(2)).isEqualTo(0);

        InputStream inputStream09 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setSkipException(false, "ex").buildInputStream();
        Assertions.assertThat(inputStream09.skip(2)).isEqualTo(1);
        Assertions.assertThat(inputStream09.skip(2)).isEqualTo(0);

        InputStream inputStream10 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setCloseException("ex").buildInputStream();
        Assertions.assertThat(inputStream10.skip(2)).isEqualTo(1);
        Assertions.assertThat(inputStream10.skip(2)).isEqualTo(0);

        try {
            DataHelper.createInputStreamBuilder().setSkipException(new IOException("fail")).buildInputStream().skip(1);
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createInputStreamBuilder().setSkipException(true, new IOException("fail")).buildInputStream().skip(1);
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createInputStreamBuilder().setSkipException("fail").buildInputStream().skip(1);
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createInputStreamBuilder().setSkipException(true, "fail").buildInputStream().skip(1);
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        InputStream inputStream11 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setSkipException("fail").buildInputStream();
        inputStream11.skip(3);
        inputStream11.skip(2);
        try {
            inputStream11.skip(1);
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setSkipException("fail").buildInputStream();
            inputStream.skip(10);
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
    public void closeTest() throws IOException {
        DataHelper.createInputStreamBuilder().buildInputStream().close();
        DataHelper.createInputStreamBuilder().setContent(new byte[]{}).buildInputStream().close();
        DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).buildInputStream().close();
        DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setAvailableException("ex").buildInputStream().close();
        DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setReadException("ex").buildInputStream().close();
        DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setSkipException("ex").buildInputStream().close();
        DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setCloseException(false, new IOException("ex")).buildInputStream().close();
        DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setCloseException(false, "ex").buildInputStream().close();

        try {
            DataHelper.createInputStreamBuilder().setCloseException(new IOException("fail")).buildInputStream().close();
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createInputStreamBuilder().setCloseException(true, new IOException("fail")).buildInputStream().close();
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createInputStreamBuilder().setCloseException("fail").buildInputStream().close();
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createInputStreamBuilder().setCloseException(true, "fail").buildInputStream().close();
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setCloseException("fail").buildInputStream().close();
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        try (InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setCloseException("fail").buildInputStream()) {
            Assertions.assertThat(inputStream.read()).isEqualTo(1);
            Assertions.assertThat(inputStream.read()).isEqualTo(-1);
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try (InputStream inputStream = DataHelper.createInputStreamBuilder().setContent(new byte[]{1}).setReadException("fail 1").setCloseException("fail 2").buildInputStream()) {
            Assertions.assertThat(inputStream.read()).isEqualTo(1);
            inputStream.read();
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail 1");
            Assertions.assertThat(ex.getSuppressed()[0]).hasMessage("fail 2");
        }
    }

    /**
     * {@link MockInputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void isClosedTest() throws IOException {
        InputStream inputStream01 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).buildInputStream();
        Assertions.assertThat(((IsCloseable) inputStream01).isClosed()).isFalse();
        Assertions.assertThat(inputStream01.read()).isEqualTo(1);
        Assertions.assertThat(((IsCloseable) inputStream01).isClosed()).isFalse();
        Assertions.assertThat(inputStream01.read()).isEqualTo(2);
        Assertions.assertThat(((IsCloseable) inputStream01).isClosed()).isFalse();
        Assertions.assertThat(inputStream01.read()).isEqualTo(3);
        Assertions.assertThat(((IsCloseable) inputStream01).isClosed()).isFalse();
        Assertions.assertThat(inputStream01.read()).isEqualTo(4);
        Assertions.assertThat(((IsCloseable) inputStream01).isClosed()).isFalse();
        Assertions.assertThat(inputStream01.read()).isEqualTo(5);
        Assertions.assertThat(((IsCloseable) inputStream01).isClosed()).isFalse();
        Assertions.assertThat(inputStream01.read()).isEqualTo(-1);
        Assertions.assertThat(((IsCloseable) inputStream01).isClosed()).isFalse();
        inputStream01.close();
        Assertions.assertThat(((IsCloseable) inputStream01).isClosed()).isTrue();
        inputStream01.close();
        Assertions.assertThat(((IsCloseable) inputStream01).isClosed()).isTrue();

        InputStream inputStream02 = DataHelper.createInputStreamBuilder().setContent(new byte[]{1, 2, 3, 4, 5}).setCloseException("fail").buildInputStream();
        Assertions.assertThat(((IsCloseable) inputStream02).isClosed()).isFalse();
        try {
            inputStream02.close();
            Assertions.fail("MockInputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        Assertions.assertThat(((IsCloseable) inputStream02).isClosed()).isTrue();
    }

}
