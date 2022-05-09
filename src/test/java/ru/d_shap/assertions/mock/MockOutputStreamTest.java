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
        OutputStream outputStream01 = DataHelper.createOutputStreamBuilder().setContentSize(10).buildOutputStream();
        outputStream01.write(new byte[]{11, 12, 13}, 0, 3);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(11, 12, 13);
        outputStream01.write(new byte[]{}, 0, 0);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(11, 12, 13);
        outputStream01.write(new byte[]{21, 22, 23}, 1, 2);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(11, 12, 13, 22, 23);
        outputStream01.write(new byte[]{31, 32, 33}, 0, 2);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(11, 12, 13, 22, 23, 31, 32);
        outputStream01.write(new byte[]{41, 0, 43}, 1, 1);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(11, 12, 13, 22, 23, 31, 32, 0);

        OutputStream outputStream02 = DataHelper.createOutputStreamBuilder().setContentSize(6).buildOutputStream();
        outputStream02.write(new byte[]{11, 12, 13}, 0, 3);
        Assertions.assertThat(((MockOutputStream) outputStream02).getContent()).containsExactlyInOrder(11, 12, 13);
        outputStream02.write(new byte[]{21, 22, 23}, 1, 2);
        Assertions.assertThat(((MockOutputStream) outputStream02).getContent()).containsExactlyInOrder(11, 12, 13, 22, 23);
        outputStream02.write(new byte[]{31, 32, 33}, 1, 0);
        Assertions.assertThat(((MockOutputStream) outputStream02).getContent()).containsExactlyInOrder(11, 12, 13, 22, 23);
        outputStream02.write(new byte[]{41, 42, 43}, 0, 2);
        Assertions.assertThat(((MockOutputStream) outputStream02).getContent()).containsExactlyInOrder(11, 12, 13, 22, 23, 41);
        outputStream02.write(new byte[]{51, 0, 52}, 1, 1);
        Assertions.assertThat(((MockOutputStream) outputStream02).getContent()).containsExactlyInOrder(11, 12, 13, 22, 23, 41);

        OutputStream outputStream03 = DataHelper.createOutputStreamBuilder().setContentSize(0).buildOutputStream();
        outputStream03.write(new byte[]{11, 12, 13}, 0, 3);
        Assertions.assertThat(((MockOutputStream) outputStream03).getContent()).containsExactlyInOrder();
        outputStream03.write(new byte[]{21, 22, 23}, 1, 2);
        Assertions.assertThat(((MockOutputStream) outputStream03).getContent()).containsExactlyInOrder();

        OutputStream outputStream04 = DataHelper.createOutputStreamBuilder().buildOutputStream();
        outputStream04.write(new byte[]{11, 12, 13}, 0, 3);
        Assertions.assertThat(((MockOutputStream) outputStream04).getContent()).containsExactlyInOrder();
        outputStream04.write(new byte[]{21, 22, 23}, 1, 2);
        Assertions.assertThat(((MockOutputStream) outputStream04).getContent()).containsExactlyInOrder();

        OutputStream outputStream05 = DataHelper.createOutputStreamBuilder().setContentSize(2).setFlushException("ex").buildOutputStream();
        outputStream05.write(new byte[]{11, 12, 13}, 0, 3);
        Assertions.assertThat(((MockOutputStream) outputStream05).getContent()).containsExactlyInOrder(11, 12);
        outputStream05.write(new byte[]{21, 22, 23}, 1, 2);
        Assertions.assertThat(((MockOutputStream) outputStream05).getContent()).containsExactlyInOrder(11, 12);

        OutputStream outputStream06 = DataHelper.createOutputStreamBuilder().setContentSize(2).setCloseException("ex").buildOutputStream();
        outputStream06.write(new byte[]{11, 12, 13}, 0, 3);
        Assertions.assertThat(((MockOutputStream) outputStream06).getContent()).containsExactlyInOrder(11, 12);
        outputStream06.write(new byte[]{21, 22, 23}, 1, 2);
        Assertions.assertThat(((MockOutputStream) outputStream06).getContent()).containsExactlyInOrder(11, 12);

        try {
            DataHelper.createOutputStreamBuilder().buildOutputStream().write(null, 0, 10);
            Assertions.fail("MockOutputStream test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).hasMessage("buffer is null");
        }
        try {
            DataHelper.createOutputStreamBuilder().buildOutputStream().write(null, -1, 10);
            Assertions.fail("MockOutputStream test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).hasMessage("buffer is null");
        }
        try {
            DataHelper.createOutputStreamBuilder().buildOutputStream().write(new byte[]{1, 2, 3, 4, 5}, -1, 10);
            Assertions.fail("MockOutputStream test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("offset is out of bounds");
        }
        try {
            DataHelper.createOutputStreamBuilder().buildOutputStream().write(new byte[]{1, 2, 3, 4, 5}, 5, 10);
            Assertions.fail("MockOutputStream test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("offset is out of bounds");
        }
        try {
            DataHelper.createOutputStreamBuilder().buildOutputStream().write(new byte[]{1, 2, 3, 4, 5}, 0, -1);
            Assertions.fail("MockOutputStream test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("length is out of bounds");
        }
        try {
            DataHelper.createOutputStreamBuilder().buildOutputStream().write(new byte[]{1, 2, 3, 4, 5}, 0, 6);
            Assertions.fail("MockOutputStream test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("length is out of bounds");
        }
        try {
            DataHelper.createOutputStreamBuilder().buildOutputStream().write(new byte[]{1, 2, 3, 4, 5}, 4, 2);
            Assertions.fail("MockOutputStream test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("length is out of bounds");
        }
        try {
            DataHelper.createOutputStreamBuilder().buildOutputStream().write(new byte[]{}, 1, 0);
            Assertions.fail("MockOutputStream test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("offset is out of bounds");
        }
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

        OutputStream outputStream07 = DataHelper.createOutputStreamBuilder().setContentSize(5).setWriteException("fail").buildOutputStream();
        outputStream07.write(new byte[]{11, 12, 13}, 0, 3);
        Assertions.assertThat(((MockOutputStream) outputStream07).getContent()).containsExactlyInOrder(11, 12, 13);
        try {
            outputStream07.write(new byte[]{21, 22, 23}, 0, 3);
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        Assertions.assertThat(((MockOutputStream) outputStream07).getContent()).containsExactlyInOrder(11, 12, 13, 21, 22);
    }

    /**
     * {@link MockOutputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void flushTest() throws IOException {
        OutputStream outputStream01 = DataHelper.createOutputStreamBuilder().setContentSize(5).buildOutputStream();
        outputStream01.flush();

        OutputStream outputStream02 = DataHelper.createOutputStreamBuilder().setContentSize(5).buildOutputStream();
        outputStream02.write(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 0, 9);
        outputStream02.flush();

        OutputStream outputStream03 = DataHelper.createOutputStreamBuilder().setWriteException("ex").buildOutputStream();
        outputStream03.flush();

        OutputStream outputStream04 = DataHelper.createOutputStreamBuilder().setCloseException("ex").buildOutputStream();
        outputStream04.flush();

        try {
            DataHelper.createOutputStreamBuilder().setFlushException(new IOException("fail")).buildOutputStream().flush();
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createOutputStreamBuilder().setFlushException("fail").buildOutputStream().flush();
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        OutputStream outputStream05 = DataHelper.createOutputStreamBuilder().setContentSize(5).setFlushException("fail").buildOutputStream();
        outputStream05.flush();
        outputStream05.write(1);
        outputStream05.flush();
        outputStream05.write(2);
        outputStream05.flush();
        outputStream05.write(3);
        outputStream05.flush();
        Assertions.assertThat(((MockOutputStream) outputStream05).getContent()).containsExactlyInOrder(1, 2, 3);
        outputStream05.write(4);
        outputStream05.flush();
        outputStream05.write(5);
        try {
            outputStream05.flush();
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        Assertions.assertThat(((MockOutputStream) outputStream05).getContent()).containsExactlyInOrder(1, 2, 3, 4, 5);
    }

    /**
     * {@link MockOutputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void closeTest() throws IOException {
        OutputStream outputStream01 = DataHelper.createOutputStreamBuilder().setContentSize(5).buildOutputStream();
        outputStream01.close();

        OutputStream outputStream02 = DataHelper.createOutputStreamBuilder().setContentSize(5).buildOutputStream();
        outputStream02.write(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 0, 9);
        outputStream02.close();

        OutputStream outputStream03 = DataHelper.createOutputStreamBuilder().setWriteException("ex").buildOutputStream();
        outputStream03.close();

        OutputStream outputStream04 = DataHelper.createOutputStreamBuilder().setContentSize(5).setFlushException("ex").buildOutputStream();
        outputStream04.close();

        try {
            DataHelper.createOutputStreamBuilder().setCloseException(new IOException("fail")).buildOutputStream().close();
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createOutputStreamBuilder().setCloseException("fail").buildOutputStream().close();
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createOutputStreamBuilder().setContentSize(5).setCloseException("fail").buildOutputStream().close();
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        OutputStream outputStream05 = DataHelper.createOutputStreamBuilder().setContentSize(5).setFlushException("fail").buildOutputStream();
        outputStream05.write(1);
        outputStream05.write(2);
        outputStream05.write(3);
        outputStream05.write(4);
        outputStream05.write(5);
        try {
            outputStream05.close();
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        OutputStream outputStream06 = DataHelper.createOutputStreamBuilder().setContentSize(5).setFlushException("fail 1").setCloseException("fail 2").buildOutputStream();
        outputStream06.write(1);
        outputStream06.write(2);
        outputStream06.write(3);
        outputStream06.write(4);
        outputStream06.write(5);
        try {
            outputStream06.close();
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail 1");
        }
        try {
            outputStream06.close();
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail 2");
        }
    }

    /**
     * {@link MockOutputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void isClosedTest() throws IOException {
        OutputStream outputStream01 = DataHelper.createOutputStreamBuilder().setContentSize(5).buildOutputStream();
        Assertions.assertThat(((IsCloseable) outputStream01).isClosed()).isFalse();
        outputStream01.write(1);
        Assertions.assertThat(((IsCloseable) outputStream01).isClosed()).isFalse();
        outputStream01.write(2);
        Assertions.assertThat(((IsCloseable) outputStream01).isClosed()).isFalse();
        outputStream01.close();
        Assertions.assertThat(((IsCloseable) outputStream01).isClosed()).isTrue();
        outputStream01.close();
        Assertions.assertThat(((IsCloseable) outputStream01).isClosed()).isTrue();

        OutputStream outputStream02 = DataHelper.createOutputStreamBuilder().setCloseException("fail").buildOutputStream();
        Assertions.assertThat(((IsCloseable) outputStream02).isClosed()).isFalse();
        try {
            outputStream02.close();
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        Assertions.assertThat(((IsCloseable) outputStream02).isClosed()).isTrue();

        OutputStream outputStream03 = DataHelper.createOutputStreamBuilder().setFlushException("fail 1").setCloseException("fail 2").buildOutputStream();
        Assertions.assertThat(((IsCloseable) outputStream03).isClosed()).isFalse();
        try {
            outputStream03.close();
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail 1");
        }
        Assertions.assertThat(((IsCloseable) outputStream03).isClosed()).isTrue();
        try {
            outputStream03.close();
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail 2");
        }
        Assertions.assertThat(((IsCloseable) outputStream03).isClosed()).isTrue();
    }

}
