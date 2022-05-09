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
import java.io.OutputStream;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link MockOutputStream}.
 *
 * @author Dmitry Shapovalov
 */
public final class MockOutputStreamTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public MockOutputStreamTest() {
        super();
    }

    /**
     * {@link MockOutputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void writeByteTest() throws IOException {
        OutputStream outputStream01 = DataHelper.createOutputStreamBuilder().setContentSize(11).buildOutputStream();
        outputStream01.write(0);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(0);
        outputStream01.write(1);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(0, 1);
        outputStream01.write(2);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(0, 1, 2);
        outputStream01.write(3);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(0, 1, 2, 3);
        outputStream01.write(4);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(0, 1, 2, 3, 4);
        outputStream01.write(5);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(0, 1, 2, 3, 4, 5);
        outputStream01.write(6);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(0, 1, 2, 3, 4, 5, 6);
        outputStream01.write(7);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(0, 1, 2, 3, 4, 5, 6, 7);
        outputStream01.write(8);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(0, 1, 2, 3, 4, 5, 6, 7, 8);
        outputStream01.write(9);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        outputStream01.write(10);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        outputStream01.write(11);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        outputStream01.write(0);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        OutputStream outputStream02 = DataHelper.createOutputStreamBuilder().setContentSize(1).buildOutputStream();
        outputStream02.write(1);
        Assertions.assertThat(((MockOutputStream) outputStream02).getContent()).containsExactlyInOrder(1);
        outputStream02.write(2);
        Assertions.assertThat(((MockOutputStream) outputStream02).getContent()).containsExactlyInOrder(1);
        outputStream02.write(3);
        Assertions.assertThat(((MockOutputStream) outputStream02).getContent()).containsExactlyInOrder(1);

        OutputStream outputStream03 = DataHelper.createOutputStreamBuilder().setContentSize(0).buildOutputStream();
        outputStream03.write(1);
        Assertions.assertThat(((MockOutputStream) outputStream03).getContent()).containsExactlyInOrder();
        outputStream03.write(2);
        Assertions.assertThat(((MockOutputStream) outputStream03).getContent()).containsExactlyInOrder();

        OutputStream outputStream04 = DataHelper.createOutputStreamBuilder().setContentSize(-1).buildOutputStream();
        outputStream04.write(1);
        Assertions.assertThat(((MockOutputStream) outputStream04).getContent()).containsExactlyInOrder();
        outputStream04.write(2);
        Assertions.assertThat(((MockOutputStream) outputStream04).getContent()).containsExactlyInOrder();

        OutputStream outputStream05 = DataHelper.createOutputStreamBuilder().buildOutputStream();
        outputStream05.write(1);
        Assertions.assertThat(((MockOutputStream) outputStream05).getContent()).containsExactlyInOrder();
        outputStream05.write(2);
        Assertions.assertThat(((MockOutputStream) outputStream05).getContent()).containsExactlyInOrder();

        OutputStream outputStream06 = DataHelper.createOutputStreamBuilder().setContentSize(1).setFlushException("ex").buildOutputStream();
        outputStream06.write(1);
        outputStream06.write(2);
        Assertions.assertThat(((MockOutputStream) outputStream06).getContent()).containsExactlyInOrder(1);

        OutputStream outputStream07 = DataHelper.createOutputStreamBuilder().setContentSize(1).setCloseException("ex").buildOutputStream();
        outputStream07.write(1);
        outputStream07.write(2);
        Assertions.assertThat(((MockOutputStream) outputStream07).getContent()).containsExactlyInOrder(1);

        try {
            DataHelper.createOutputStreamBuilder().setWriteException(new IOException("fail")).buildOutputStream().write(1);
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createOutputStreamBuilder().setWriteException("fail").buildOutputStream().write(1);
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        OutputStream outputStream08 = DataHelper.createOutputStreamBuilder().setContentSize(5).setWriteException("fail").buildOutputStream();
        outputStream08.write(1);
        outputStream08.write(2);
        outputStream08.write(0);
        Assertions.assertThat(((MockOutputStream) outputStream08).getContent()).containsExactlyInOrder(1, 2, 0);
        outputStream08.write(3);
        outputStream08.write(4);
        Assertions.assertThat(((MockOutputStream) outputStream08).getContent()).containsExactlyInOrder(1, 2, 0, 3, 4);
        try {
            outputStream08.write(5);
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        Assertions.assertThat(((MockOutputStream) outputStream08).getContent()).containsExactlyInOrder(1, 2, 0, 3, 4);
    }

    /**
     * {@link MockOutputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void writeByteArrayTest() throws IOException {
        OutputStream outputStream01 = DataHelper.createOutputStreamBuilder().setContentSize(100).buildOutputStream();
        byte[] buff011 = new byte[]{11, 12, 13};
        outputStream01.write(buff011, 0, 3);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(11, 12, 13);
        byte[] buff012 = new byte[]{21, 22, 23};
        outputStream01.write(buff012, 1, 2);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(11, 12, 13, 22, 23);
        byte[] buff013 = new byte[]{31, 32, 33};
        outputStream01.write(buff013, 0, 2);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(11, 12, 13, 22, 23, 31, 32);
        byte[] buff014 = new byte[]{41, 0, 43};
        outputStream01.write(buff014, 1, 1);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(11, 12, 13, 22, 23, 31, 32, 0);

        OutputStream outputStream02 = DataHelper.createOutputStreamBuilder().setContentSize(6).buildOutputStream();
        byte[] buff021 = new byte[]{11, 12, 13};
        outputStream02.write(buff021, 0, 3);
        Assertions.assertThat(((MockOutputStream) outputStream02).getContent()).containsExactlyInOrder(11, 12, 13);
        byte[] buff022 = new byte[]{21, 22, 23};
        outputStream02.write(buff022, 1, 2);
        Assertions.assertThat(((MockOutputStream) outputStream02).getContent()).containsExactlyInOrder(11, 12, 13, 22, 23);
        byte[] buff023 = new byte[]{31, 32, 33};
        outputStream02.write(buff023, 0, 2);
        Assertions.assertThat(((MockOutputStream) outputStream02).getContent()).containsExactlyInOrder(11, 12, 13, 22, 23, 31);
        byte[] buff024 = new byte[]{41, 0, 43};
        outputStream02.write(buff024, 1, 1);
        Assertions.assertThat(((MockOutputStream) outputStream02).getContent()).containsExactlyInOrder(11, 12, 13, 22, 23, 31);

        OutputStream outputStream03 = DataHelper.createOutputStreamBuilder().setContentSize(0).buildOutputStream();
        byte[] buff031 = new byte[]{11, 12, 13};
        outputStream03.write(buff031, 0, 3);
        Assertions.assertThat(((MockOutputStream) outputStream03).getContent()).containsExactlyInOrder();
        byte[] buff032 = new byte[]{21, 22, 23};
        outputStream03.write(buff032, 1, 2);
        Assertions.assertThat(((MockOutputStream) outputStream03).getContent()).containsExactlyInOrder();

        OutputStream outputStream04 = DataHelper.createOutputStreamBuilder().buildOutputStream();
        byte[] buff041 = new byte[]{11, 12, 13};
        outputStream04.write(buff041, 0, 3);
        Assertions.assertThat(((MockOutputStream) outputStream04).getContent()).containsExactlyInOrder();
        byte[] buff042 = new byte[]{21, 22, 23};
        outputStream04.write(buff042, 1, 2);
        Assertions.assertThat(((MockOutputStream) outputStream04).getContent()).containsExactlyInOrder();

        OutputStream outputStream05 = DataHelper.createOutputStreamBuilder().setContentSize(2).setFlushException("ex").buildOutputStream();
        byte[] buff051 = new byte[]{11, 12, 13};
        outputStream05.write(buff051, 0, 3);
        Assertions.assertThat(((MockOutputStream) outputStream05).getContent()).containsExactlyInOrder(11, 12);
        byte[] buff052 = new byte[]{21, 22, 23};
        outputStream05.write(buff052, 1, 2);
        Assertions.assertThat(((MockOutputStream) outputStream05).getContent()).containsExactlyInOrder(11, 12);

        OutputStream outputStream06 = DataHelper.createOutputStreamBuilder().setContentSize(2).setCloseException("ex").buildOutputStream();
        byte[] buff061 = new byte[]{11, 12, 13};
        outputStream06.write(buff061, 0, 3);
        Assertions.assertThat(((MockOutputStream) outputStream06).getContent()).containsExactlyInOrder(11, 12);
        byte[] buff062 = new byte[]{21, 22, 23};
        outputStream06.write(buff062, 1, 2);
        Assertions.assertThat(((MockOutputStream) outputStream06).getContent()).containsExactlyInOrder(11, 12);

        try {
            DataHelper.createOutputStreamBuilder().setWriteException(new IOException("fail")).buildOutputStream().write(new byte[]{1}, 0, 1);
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createOutputStreamBuilder().setWriteException("fail").buildOutputStream().write(new byte[]{1}, 0, 1);
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
    }

    /**
     * {@link MockOutputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void flushTest() throws IOException {
        // TODO
    }

    /**
     * {@link MockOutputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void closeTest() throws IOException {
        // TODO
    }

    /**
     * {@link MockOutputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void getContentTest() throws IOException {
        // TODO
    }

    /**
     * {@link MockOutputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void isClosedTest() throws IOException {
        // TODO
    }

}
