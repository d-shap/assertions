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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link MockReader}.
 *
 * @author Dmitry Shapovalov
 */
public final class MockReaderTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public MockReaderTest() {
        super();
    }

    /**
     * {@link MockReader} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void readCharTest() throws IOException {
        Reader reader01 = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader();
        Assertions.assertThat(reader01.read()).isEqualTo('1');
        Assertions.assertThat(reader01.read()).isEqualTo('2');
        Assertions.assertThat(reader01.read()).isEqualTo('3');
        Assertions.assertThat(reader01.read()).isEqualTo('4');
        Assertions.assertThat(reader01.read()).isEqualTo('5');
        Assertions.assertThat(reader01.read()).isEqualTo(-1);
        Assertions.assertThat(reader01.read()).isEqualTo(-1);

        Reader reader02 = DataHelper.createReaderBuilder().setContent(new char[]{}).buildReader();
        Assertions.assertThat(reader02.read()).isEqualTo(-1);

        Reader reader03 = DataHelper.createReaderBuilder().setContent(new char[]{'1'}).setSkipException("ex").buildReader();
        Assertions.assertThat(reader03.read()).isEqualTo('1');
        Assertions.assertThat(reader03.read()).isEqualTo(-1);

        Reader reader04 = DataHelper.createReaderBuilder().setContent(new char[]{'1'}).setCloseException("ex").buildReader();
        Assertions.assertThat(reader04.read()).isEqualTo('1');
        Assertions.assertThat(reader04.read()).isEqualTo(-1);

        try {
            DataHelper.createReaderBuilder().setReadException(new IOException("fail")).buildReader().read();
            Assertions.fail("MockReader test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createReaderBuilder().setReadException("fail").buildReader().read();
            Assertions.fail("MockReader test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        try {
            Reader reader = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).setReadException("fail").buildReader();
            reader.read();
            reader.read();
            reader.read();
            Assertions.assertThat(reader.read()).isEqualTo('4');
            reader.read();
            reader.read();
            Assertions.fail("MockReader test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
    }

    /**
     * {@link MockReader} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void readCharArrayTest() throws IOException {
        Reader reader01 = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader();
        char[] buff01 = new char[3];
        Assertions.assertThat(reader01.read(buff01, 0, 3)).isEqualTo(3);
        Assertions.assertThat(buff01).containsExactlyInOrder('1', '2', '3');
        Assertions.assertThat(reader01.read(buff01, 0, 3)).isEqualTo(2);
        Assertions.assertThat(buff01).containsExactlyInOrder('4', '5', '3');

        Reader reader02 = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader();
        char[] buff02 = new char[3];
        Assertions.assertThat(reader02.read(buff02, 0, 2)).isEqualTo(2);
        Assertions.assertThat(buff02).containsExactlyInOrder('1', '2', 0);
        Assertions.assertThat(reader02.read(buff02, 0, 2)).isEqualTo(2);
        Assertions.assertThat(buff02).containsExactlyInOrder('3', '4', 0);
        Assertions.assertThat(reader02.read(buff02, 0, 2)).isEqualTo(1);
        Assertions.assertThat(buff02).containsExactlyInOrder('5', '4', 0);

        Reader reader03 = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader();
        char[] buff03 = new char[3];
        Assertions.assertThat(reader03.read(buff03, 1, 2)).isEqualTo(2);
        Assertions.assertThat(buff03).containsExactlyInOrder(0, '1', '2');
        Assertions.assertThat(reader03.read(buff03, 1, 2)).isEqualTo(2);
        Assertions.assertThat(buff03).containsExactlyInOrder(0, '3', '4');
        Assertions.assertThat(reader03.read(buff03, 1, 2)).isEqualTo(1);
        Assertions.assertThat(buff03).containsExactlyInOrder(0, '5', '4');

        Reader reader04 = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader();
        char[] buff04 = new char[5];
        Assertions.assertThat(reader04.read(buff04, 0, 5)).isEqualTo(5);
        Assertions.assertThat(buff04).containsExactlyInOrder('1', '2', '3', '4', '5');
        Assertions.assertThat(reader04.read(buff04, 0, 5)).isEqualTo(-1);
        Assertions.assertThat(buff04).containsExactlyInOrder('1', '2', '3', '4', '5');

        Reader reader05 = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader();
        char[] buff05 = new char[10];
        Assertions.assertThat(reader05.read(buff05, 0, 10)).isEqualTo(5);
        Assertions.assertThat(buff05).containsExactlyInOrder('1', '2', '3', '4', '5', 0, 0, 0, 0, 0);
        Assertions.assertThat(reader05.read(buff05, 0, 10)).isEqualTo(-1);
        Assertions.assertThat(buff05).containsExactlyInOrder('1', '2', '3', '4', '5', 0, 0, 0, 0, 0);

        Reader reader06 = DataHelper.createReaderBuilder().setContent(new char[]{}).buildReader();
        char[] buff06 = new char[10];
        Assertions.assertThat(reader06.read(buff06, 0, 10)).isEqualTo(-1);
        Assertions.assertThat(buff06).containsExactlyInOrder(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Assertions.assertThat(reader06.read(buff06, 0, 10)).isEqualTo(-1);
        Assertions.assertThat(buff06).containsExactlyInOrder(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        Reader reader07 = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).setSkipException("ex").buildReader();
        char[] buff07 = new char[10];
        Assertions.assertThat(reader07.read(buff07, 0, 10)).isEqualTo(5);
        Assertions.assertThat(buff07).containsExactlyInOrder('1', '2', '3', '4', '5', 0, 0, 0, 0, 0);
        Assertions.assertThat(reader07.read(buff07, 0, 10)).isEqualTo(-1);
        Assertions.assertThat(buff07).containsExactlyInOrder('1', '2', '3', '4', '5', 0, 0, 0, 0, 0);

        Reader reader08 = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).setCloseException("ex").buildReader();
        char[] buff08 = new char[10];
        Assertions.assertThat(reader08.read(buff08, 0, 10)).isEqualTo(5);
        Assertions.assertThat(buff08).containsExactlyInOrder('1', '2', '3', '4', '5', 0, 0, 0, 0, 0);
        Assertions.assertThat(reader08.read(buff08, 0, 10)).isEqualTo(-1);
        Assertions.assertThat(buff08).containsExactlyInOrder('1', '2', '3', '4', '5', 0, 0, 0, 0, 0);

        try {
            DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader().read(null, 0, 10);
            Assertions.fail("MockReader test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        try {
            DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader().read(null, -1, 10);
            Assertions.fail("MockReader test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        try {
            DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader().read(new char[5], -1, 10);
            Assertions.fail("MockReader test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        try {
            DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader().read(new char[5], 0, -1);
            Assertions.fail("MockReader test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        try {
            DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader().read(new char[5], 0, 6);
            Assertions.fail("MockReader test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        try {
            Reader reader = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).setReadException(new IOException("fail")).buildReader();
            char[] buff = new char[10];
            reader.read(buff, 0, 10);
            Assertions.fail("MockReader test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            Reader reader = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).setReadException("fail").buildReader();
            char[] buff = new char[10];
            reader.read(buff, 0, 10);
            Assertions.fail("MockReader test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        Reader reader10 = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).setReadException("fail").buildReader();
        char[] buff10 = new char[10];
        try {
            reader10.read(buff10, 0, 10);
            Assertions.fail("MockReader test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        Assertions.assertThat(buff10).containsExactlyInOrder('1', '2', '3', '4', '5', 0, 0, 0, 0, 0);
    }

    /**
     * {@link MockReader} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void skipTest() throws IOException {
        Reader reader01 = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader();
        Assertions.assertThat(reader01.skip(1)).isEqualTo(1);
        Assertions.assertThat(reader01.skip(1)).isEqualTo(1);
        Assertions.assertThat(reader01.skip(1)).isEqualTo(1);
        Assertions.assertThat(reader01.skip(1)).isEqualTo(1);
        Assertions.assertThat(reader01.skip(1)).isEqualTo(1);
        Assertions.assertThat(reader01.skip(1)).isEqualTo(0);
        Assertions.assertThat(reader01.skip(1)).isEqualTo(0);

        Reader reader02 = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader();
        Assertions.assertThat(reader02.skip(3)).isEqualTo(3);
        Assertions.assertThat(reader02.skip(3)).isEqualTo(2);
        Assertions.assertThat(reader02.skip(3)).isEqualTo(0);
        Assertions.assertThat(reader02.skip(3)).isEqualTo(0);

        Reader reader03 = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader();
        Assertions.assertThat(reader03.skip(5)).isEqualTo(5);
        Assertions.assertThat(reader03.skip(5)).isEqualTo(0);
        Assertions.assertThat(reader03.skip(5)).isEqualTo(0);

        Reader reader04 = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader();
        Assertions.assertThat(reader04.skip(10)).isEqualTo(5);
        Assertions.assertThat(reader04.skip(10)).isEqualTo(0);
        Assertions.assertThat(reader04.skip(10)).isEqualTo(0);

        Reader reader05 = DataHelper.createReaderBuilder().setContent(new char[]{}).buildReader();
        Assertions.assertThat(reader05.skip(3)).isEqualTo(0);

        Reader reader06 = DataHelper.createReaderBuilder().setContent(new char[]{'1'}).setReadException("ex").buildReader();
        Assertions.assertThat(reader06.skip(2)).isEqualTo(1);
        Assertions.assertThat(reader06.skip(2)).isEqualTo(0);

        Reader reader07 = DataHelper.createReaderBuilder().setContent(new char[]{'1'}).setCloseException("ex").buildReader();
        Assertions.assertThat(reader07.skip(2)).isEqualTo(1);
        Assertions.assertThat(reader07.skip(2)).isEqualTo(0);

        try {
            DataHelper.createReaderBuilder().setSkipException(new IOException("fail")).buildReader().skip(1);
            Assertions.fail("MockReader test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createReaderBuilder().setSkipException("fail").buildReader().skip(1);
            Assertions.fail("MockReader test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        try {
            Reader reader = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).setSkipException("fail").buildReader();
            reader.skip(3);
            reader.skip(2);
            reader.skip(1);
            Assertions.fail("MockReader test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            Reader reader = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).setSkipException("fail").buildReader();
            reader.skip(10);
            Assertions.fail("MockReader test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
    }

    /**
     * {@link MockReader} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void closeTest() throws IOException {
        DataHelper.createReaderBuilder().buildReader().close();
        DataHelper.createReaderBuilder().setContent(new char[]{}).buildReader().close();
        DataHelper.createReaderBuilder().setContent(new char[]{'1'}).buildReader().close();
        DataHelper.createReaderBuilder().setContent(new char[]{'1'}).setReadException("ex").buildReader().close();
        DataHelper.createReaderBuilder().setContent(new char[]{'1'}).setSkipException("ex").buildReader().close();

        try {
            DataHelper.createReaderBuilder().setCloseException(new IOException("fail")).buildReader().close();
            Assertions.fail("MockReader test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createReaderBuilder().setCloseException("fail").buildReader().close();
            Assertions.fail("MockReader test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).setCloseException("fail").buildReader().close();
            Assertions.fail("MockReader test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        try (Reader reader = DataHelper.createReaderBuilder().setContent(new char[]{'1'}).setCloseException("fail").buildReader()) {
            Assertions.assertThat(reader.read()).isEqualTo('1');
            Assertions.assertThat(reader.read()).isEqualTo(-1);
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try (Reader reader = DataHelper.createReaderBuilder().setContent(new char[]{'1'}).setReadException("fail 1").setCloseException("fail 2").buildReader()) {
            Assertions.assertThat(reader.read()).isEqualTo('1');
            reader.read();
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail 1");
            Assertions.assertThat(ex.getSuppressed()[0]).hasMessage("fail 2");
        }
    }

    /**
     * {@link MockReader} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void isClosedTest() throws IOException {
        Reader reader01 = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).buildReader();
        Assertions.assertThat(((IsCloseable) reader01).isClosed()).isFalse();
        Assertions.assertThat(reader01.read()).isEqualTo('1');
        Assertions.assertThat(((IsCloseable) reader01).isClosed()).isFalse();
        Assertions.assertThat(reader01.read()).isEqualTo('2');
        Assertions.assertThat(((IsCloseable) reader01).isClosed()).isFalse();
        Assertions.assertThat(reader01.read()).isEqualTo('3');
        Assertions.assertThat(((IsCloseable) reader01).isClosed()).isFalse();
        Assertions.assertThat(reader01.read()).isEqualTo('4');
        Assertions.assertThat(((IsCloseable) reader01).isClosed()).isFalse();
        Assertions.assertThat(reader01.read()).isEqualTo('5');
        Assertions.assertThat(((IsCloseable) reader01).isClosed()).isFalse();
        Assertions.assertThat(reader01.read()).isEqualTo(-1);
        Assertions.assertThat(((IsCloseable) reader01).isClosed()).isFalse();
        reader01.close();
        Assertions.assertThat(((IsCloseable) reader01).isClosed()).isTrue();

        Reader reader02 = DataHelper.createReaderBuilder().setContent(new char[]{'1', '2', '3', '4', '5'}).setCloseException("fail").buildReader();
        Assertions.assertThat(((IsCloseable) reader02).isClosed()).isFalse();
        try {
            reader02.close();
            Assertions.fail("MockReader test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        Assertions.assertThat(((IsCloseable) reader02).isClosed()).isTrue();
    }

    /**
     * {@link MockReader} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void bufferedReaderTest() throws IOException {
        BufferedReader reader01 = DataHelper.createReaderBuilder().setContent("row1\r\nrow2\r\nrow3\r\n").buildBufferedReader();
        Assertions.assertThat(reader01.readLine()).isEqualTo("row1");
        Assertions.assertThat(reader01.readLine()).isEqualTo("row2");
        Assertions.assertThat(reader01.readLine()).isEqualTo("row3");
        Assertions.assertThat(reader01.readLine()).isNull();

        BufferedReader reader02 = DataHelper.createReaderBuilder().setContent("row1\nrow2\nrow3\n").buildBufferedReader();
        Assertions.assertThat(reader02.readLine()).isEqualTo("row1");
        Assertions.assertThat(reader02.readLine()).isEqualTo("row2");
        Assertions.assertThat(reader02.readLine()).isEqualTo("row3");
        Assertions.assertThat(reader02.readLine()).isNull();

        BufferedReader reader03 = DataHelper.createReaderBuilder().setContent("row1\rrow2\rrow3\r").buildBufferedReader();
        Assertions.assertThat(reader03.readLine()).isEqualTo("row1");
        Assertions.assertThat(reader03.readLine()).isEqualTo("row2");
        Assertions.assertThat(reader03.readLine()).isEqualTo("row3");
        Assertions.assertThat(reader03.readLine()).isNull();

        BufferedReader reader04 = DataHelper.createReaderBuilder().setContent("row1\r\nrow2\r\nrow3").buildBufferedReader();
        Assertions.assertThat(reader04.readLine()).isEqualTo("row1");
        Assertions.assertThat(reader04.readLine()).isEqualTo("row2");
        Assertions.assertThat(reader04.readLine()).isEqualTo("row3");
        Assertions.assertThat(reader04.readLine()).isNull();
    }

}