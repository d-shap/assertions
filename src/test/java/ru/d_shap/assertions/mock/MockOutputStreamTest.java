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
        OutputStream outputStream01 = DataHelper.createOutputStreamBuilder().setContentSize(10).buildOutputStream();
        outputStream01.write(1);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(1);
        outputStream01.write(2);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(1, 2);
        outputStream01.write(3);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(1, 2, 3);
        outputStream01.write(4);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(1, 2, 3, 4);
        outputStream01.write(5);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(1, 2, 3, 4, 5);
        outputStream01.write(6);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(1, 2, 3, 4, 5, 6);
        outputStream01.write(7);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(1, 2, 3, 4, 5, 6, 7);
        outputStream01.write(8);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(1, 2, 3, 4, 5, 6, 7, 8);
        outputStream01.write(9);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(1, 2, 3, 4, 5, 6, 7, 8, 9);
        outputStream01.write(10);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        outputStream01.write(11);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        outputStream01.write(12);
        Assertions.assertThat(((MockOutputStream) outputStream01).getContent()).containsExactlyInOrder(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

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

        OutputStream outputStream05 = DataHelper.createOutputStreamBuilder().setFlushException("ex").buildOutputStream();
        outputStream05.write(1);
        Assertions.assertThat(((MockOutputStream) outputStream05).getContent()).containsExactlyInOrder();

        OutputStream outputStream06 = DataHelper.createOutputStreamBuilder().setCloseException("ex").buildOutputStream();
        outputStream06.write(1);
        Assertions.assertThat(((MockOutputStream) outputStream06).getContent()).containsExactlyInOrder();

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

        OutputStream outputStream07 = DataHelper.createOutputStreamBuilder().setContentSize(5).setWriteException("fail").buildOutputStream();
        outputStream07.write(1);
        outputStream07.write(2);
        outputStream07.write(3);
        Assertions.assertThat(((MockOutputStream) outputStream07).getContent()).containsExactlyInOrder(1, 2, 3);
        outputStream07.write(4);
        outputStream07.write(5);
        Assertions.assertThat(((MockOutputStream) outputStream07).getContent()).containsExactlyInOrder(1, 2, 3, 4, 5);
        try {
            outputStream07.write(6);
            Assertions.fail("MockOutputStream test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        Assertions.assertThat(((MockOutputStream) outputStream07).getContent()).containsExactlyInOrder(1, 2, 3, 4, 5);
    }

    /**
     * {@link MockOutputStream} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void writeByteArrayTest() throws IOException {
        // TODO
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
