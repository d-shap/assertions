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
import java.io.Writer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link MockWriter}.
 *
 * @author Dmitry Shapovalov
 */
public final class MockWriterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public MockWriterTest() {
        super();
    }

    /**
     * {@link MockWriter} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void writeCharTest() throws IOException {
        Writer writer01 = DataHelper.createWriterBuilder().setContentSize(11).buildWriter();
        writer01.write('0');
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('0');
        writer01.write('1');
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('0', '1');
        writer01.write('2');
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('0', '1', '2');
        writer01.write('3');
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('0', '1', '2', '3');
        writer01.write('4');
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('0', '1', '2', '3', '4');
        writer01.write('5');
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('0', '1', '2', '3', '4', '5');
        writer01.write('6');
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('0', '1', '2', '3', '4', '5', '6');
        writer01.write('7');
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('0', '1', '2', '3', '4', '5', '6', '7');
        writer01.write('8');
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('0', '1', '2', '3', '4', '5', '6', '7', '8');
        writer01.write('9');
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        writer01.write('a');
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a');
        writer01.write('b');
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a');
        writer01.write('0');
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a');

        Writer writer02 = DataHelper.createWriterBuilder().setContentSize(1).buildWriter();
        writer02.write('1');
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1');
        writer02.write('2');
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1');
        writer02.write('3');
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1');

        Writer writer03 = DataHelper.createWriterBuilder().setContentSize(0).buildWriter();
        writer03.write('1');
        Assertions.assertThat(((MockWriter) writer03).getContent()).containsExactlyInOrder();
        writer03.write('2');
        Assertions.assertThat(((MockWriter) writer03).getContent()).containsExactlyInOrder();

        Writer writer04 = DataHelper.createWriterBuilder().setContentSize(-1).buildWriter();
        writer04.write('1');
        Assertions.assertThat(((MockWriter) writer04).getContent()).containsExactlyInOrder();
        writer04.write('2');
        Assertions.assertThat(((MockWriter) writer04).getContent()).containsExactlyInOrder();

        Writer writer05 = DataHelper.createWriterBuilder().buildWriter();
        writer05.write('1');
        Assertions.assertThat(((MockWriter) writer05).getContent()).containsExactlyInOrder();
        writer05.write('2');
        Assertions.assertThat(((MockWriter) writer05).getContent()).containsExactlyInOrder();

        Writer writer06 = DataHelper.createWriterBuilder().setContentSize(1).setFlushException("ex").buildWriter();
        writer06.write('1');
        writer06.write('2');
        Assertions.assertThat(((MockWriter) writer06).getContent()).containsExactlyInOrder('1');

        Writer writer07 = DataHelper.createWriterBuilder().setContentSize(1).setCloseException("ex").buildWriter();
        writer07.write('1');
        writer07.write('2');
        Assertions.assertThat(((MockWriter) writer07).getContent()).containsExactlyInOrder('1');

        try {
            DataHelper.createWriterBuilder().setWriteException(new IOException("fail")).buildWriter().write('1');
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createWriterBuilder().setWriteException("fail").buildWriter().write('1');
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        Writer writer08 = DataHelper.createWriterBuilder().setContentSize(5).setWriteException("fail").buildWriter();
        writer08.write('1');
        writer08.write('2');
        writer08.write('0');
        Assertions.assertThat(((MockWriter) writer08).getContent()).containsExactlyInOrder('1', '2', '0');
        writer08.write('3');
        writer08.write('4');
        Assertions.assertThat(((MockWriter) writer08).getContent()).containsExactlyInOrder('1', '2', '0', '3', '4');
        try {
            writer08.write('5');
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        Assertions.assertThat(((MockWriter) writer08).getContent()).containsExactlyInOrder('1', '2', '0', '3', '4');
    }

    /**
     * {@link MockWriter} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void writeCharArrayTest() throws IOException {
        Writer writer01 = DataHelper.createWriterBuilder().setContentSize(10).buildWriter();
        writer01.write(new char[]{'1', '2', '3'}, 0, 3);
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('1', '2', '3');
        writer01.write(new char[]{'4', '5', '6'}, 1, 2);
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6');
        writer01.write(new char[]{'7', '8', '9'}, 0, 2);
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6', '7', '8');
        writer01.write(new char[]{'a', 0, 'b'}, 1, 1);
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6', '7', '8', 0);

        Writer writer02 = DataHelper.createWriterBuilder().setContentSize(6).buildWriter();
        writer02.write(new char[]{'1', '2', '3'}, 0, 3);
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1', '2', '3');
        writer02.write(new char[]{'4', '5', '6'}, 1, 2);
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6');
        writer02.write(new char[]{'7', '8', '9'}, 1, 0);
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6');
        writer02.write(new char[]{'a', 'b', 'c'}, 0, 2);
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6', 'a');
        writer02.write(new char[]{'d', 'e', 'f'}, 1, 1);
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6', 'a');

        Writer writer03 = DataHelper.createWriterBuilder().setContentSize(0).buildWriter();
        writer03.write(new char[]{'1', '2', '3'}, 0, 3);
        Assertions.assertThat(((MockWriter) writer03).getContent()).containsExactlyInOrder();
        writer03.write(new char[]{'4', '5', '6'}, 1, 2);
        Assertions.assertThat(((MockWriter) writer03).getContent()).containsExactlyInOrder();

        Writer writer04 = DataHelper.createWriterBuilder().buildWriter();
        writer04.write(new char[]{'1', '2', '3'}, 0, 3);
        Assertions.assertThat(((MockWriter) writer04).getContent()).containsExactlyInOrder();
        writer04.write(new char[]{'4', '5', '6'}, 1, 2);
        Assertions.assertThat(((MockWriter) writer04).getContent()).containsExactlyInOrder();

        Writer writer05 = DataHelper.createWriterBuilder().setContentSize(2).setFlushException("ex").buildWriter();
        writer05.write(new char[]{'1', '2', '3'}, 0, 3);
        Assertions.assertThat(((MockWriter) writer05).getContent()).containsExactlyInOrder('1', '2');
        writer05.write(new char[]{'4', '5', '6'}, 1, 2);
        Assertions.assertThat(((MockWriter) writer05).getContent()).containsExactlyInOrder('1', '2');

        Writer writer06 = DataHelper.createWriterBuilder().setContentSize(2).setCloseException("ex").buildWriter();
        writer06.write(new char[]{'1', '2', '3'}, 0, 3);
        Assertions.assertThat(((MockWriter) writer06).getContent()).containsExactlyInOrder('1', '2');
        writer06.write(new char[]{'4', '5', '6'}, 1, 2);
        Assertions.assertThat(((MockWriter) writer06).getContent()).containsExactlyInOrder('1', '2');

        try {
            DataHelper.createWriterBuilder().buildWriter().write((char[]) null, 0, 10);
            Assertions.fail("MockWriter test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).hasMessage("buffer is null");
        }
        try {
            DataHelper.createWriterBuilder().buildWriter().write((char[]) null, -1, 10);
            Assertions.fail("MockWriter test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).hasMessage("buffer is null");
        }
        try {
            DataHelper.createWriterBuilder().buildWriter().write(new char[]{'1', '2', '3', '4', '5'}, -1, 10);
            Assertions.fail("MockWriter test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("offset is out of bounds");
        }
        try {
            DataHelper.createWriterBuilder().buildWriter().write(new char[]{'1', '2', '3', '4', '5'}, 5, 10);
            Assertions.fail("MockWriter test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("offset is out of bounds");
        }
        try {
            DataHelper.createWriterBuilder().buildWriter().write(new char[]{'1', '2', '3', '4', '5'}, 0, -1);
            Assertions.fail("MockWriter test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("length is out of bounds");
        }
        try {
            DataHelper.createWriterBuilder().buildWriter().write(new char[]{'1', '2', '3', '4', '5'}, 0, 6);
            Assertions.fail("MockWriter test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("length is out of bounds");
        }
        try {
            DataHelper.createWriterBuilder().buildWriter().write(new char[]{'1', '2', '3', '4', '5'}, 4, 2);
            Assertions.fail("MockWriter test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("length is out of bounds");
        }
        try {
            DataHelper.createWriterBuilder().setWriteException(new IOException("fail")).buildWriter().write(new char[]{'1'}, 0, 1);
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createWriterBuilder().setWriteException("fail").buildWriter().write(new char[]{'1'}, 0, 1);
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        Writer writer07 = DataHelper.createWriterBuilder().setContentSize(5).setWriteException("fail").buildWriter();
        writer07.write(new char[]{'1', '2', '3'}, 0, 3);
        Assertions.assertThat(((MockWriter) writer07).getContent()).containsExactlyInOrder('1', '2', '3');
        try {
            writer07.write(new char[]{'4', '5', '6'}, 0, 3);
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        Assertions.assertThat(((MockWriter) writer07).getContent()).containsExactlyInOrder('1', '2', '3', '4', '5');
    }

    /**
     * {@link MockWriter} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void writeStringTest() throws IOException {
        Writer writer01 = DataHelper.createWriterBuilder().setContentSize(10).buildWriter();
        writer01.write("123");
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('1', '2', '3');
        writer01.write("56");
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6');
        writer01.write("78");
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6', '7', '8');
        writer01.write("\u0000");
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6', '7', '8', 0);

        Writer writer02 = DataHelper.createWriterBuilder().setContentSize(6).buildWriter();
        writer02.write("123");
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1', '2', '3');
        writer02.write("56");
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6');
        writer02.write("");
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6');
        writer02.write("ab");
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6', 'a');
        writer02.write("e");
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6', 'a');

        Writer writer03 = DataHelper.createWriterBuilder().setContentSize(0).buildWriter();
        writer03.write("123");
        Assertions.assertThat(((MockWriter) writer03).getContent()).containsExactlyInOrder();
        writer03.write("56");
        Assertions.assertThat(((MockWriter) writer03).getContent()).containsExactlyInOrder();

        Writer writer04 = DataHelper.createWriterBuilder().buildWriter();
        writer04.write("123");
        Assertions.assertThat(((MockWriter) writer04).getContent()).containsExactlyInOrder();
        writer04.write("56");
        Assertions.assertThat(((MockWriter) writer04).getContent()).containsExactlyInOrder();

        Writer writer05 = DataHelper.createWriterBuilder().setContentSize(2).setFlushException("ex").buildWriter();
        writer05.write("123");
        Assertions.assertThat(((MockWriter) writer05).getContent()).containsExactlyInOrder('1', '2');
        writer05.write("56");
        Assertions.assertThat(((MockWriter) writer05).getContent()).containsExactlyInOrder('1', '2');

        Writer writer06 = DataHelper.createWriterBuilder().setContentSize(2).setCloseException("ex").buildWriter();
        writer06.write("123");
        Assertions.assertThat(((MockWriter) writer06).getContent()).containsExactlyInOrder('1', '2');
        writer06.write("56");
        Assertions.assertThat(((MockWriter) writer06).getContent()).containsExactlyInOrder('1', '2');

        try {
            DataHelper.createWriterBuilder().buildWriter().write((String) null);
            Assertions.fail("MockWriter test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).hasMessage("value is null");
        }
        try {
            DataHelper.createWriterBuilder().setWriteException(new IOException("fail")).buildWriter().write("1");
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createWriterBuilder().setWriteException("fail").buildWriter().write("1");
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        Writer writer07 = DataHelper.createWriterBuilder().setContentSize(5).setWriteException("fail").buildWriter();
        writer07.write("123");
        Assertions.assertThat(((MockWriter) writer07).getContent()).containsExactlyInOrder('1', '2', '3');
        try {
            writer07.write("456");
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        Assertions.assertThat(((MockWriter) writer07).getContent()).containsExactlyInOrder('1', '2', '3', '4', '5');
    }

    /**
     * {@link MockWriter} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void writeStringArrayTest() throws IOException {
        Writer writer01 = DataHelper.createWriterBuilder().setContentSize(10).buildWriter();
        writer01.write("123", 0, 3);
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('1', '2', '3');
        writer01.write("456", 1, 2);
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6');
        writer01.write("789", 0, 2);
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6', '7', '8');
        writer01.write("a\u0000b", 1, 1);
        Assertions.assertThat(((MockWriter) writer01).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6', '7', '8', 0);

        Writer writer02 = DataHelper.createWriterBuilder().setContentSize(6).buildWriter();
        writer02.write("123", 0, 3);
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1', '2', '3');
        writer02.write("456", 1, 2);
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6');
        writer02.write("789", 1, 0);
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6');
        writer02.write("abc", 0, 2);
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6', 'a');
        writer02.write("def", 1, 1);
        Assertions.assertThat(((MockWriter) writer02).getContent()).containsExactlyInOrder('1', '2', '3', '5', '6', 'a');

        Writer writer03 = DataHelper.createWriterBuilder().setContentSize(0).buildWriter();
        writer03.write("123", 0, 3);
        Assertions.assertThat(((MockWriter) writer03).getContent()).containsExactlyInOrder();
        writer03.write("456", 1, 2);
        Assertions.assertThat(((MockWriter) writer03).getContent()).containsExactlyInOrder();

        Writer writer04 = DataHelper.createWriterBuilder().buildWriter();
        writer04.write("123", 0, 3);
        Assertions.assertThat(((MockWriter) writer04).getContent()).containsExactlyInOrder();
        writer04.write("456", 1, 2);
        Assertions.assertThat(((MockWriter) writer04).getContent()).containsExactlyInOrder();

        Writer writer05 = DataHelper.createWriterBuilder().setContentSize(2).setFlushException("ex").buildWriter();
        writer05.write("123", 0, 3);
        Assertions.assertThat(((MockWriter) writer05).getContent()).containsExactlyInOrder('1', '2');
        writer05.write("456", 1, 2);
        Assertions.assertThat(((MockWriter) writer05).getContent()).containsExactlyInOrder('1', '2');

        Writer writer06 = DataHelper.createWriterBuilder().setContentSize(2).setCloseException("ex").buildWriter();
        writer06.write("123", 0, 3);
        Assertions.assertThat(((MockWriter) writer06).getContent()).containsExactlyInOrder('1', '2');
        writer06.write("456", 1, 2);
        Assertions.assertThat(((MockWriter) writer06).getContent()).containsExactlyInOrder('1', '2');

        try {
            DataHelper.createWriterBuilder().buildWriter().write((String) null, 0, 10);
            Assertions.fail("MockWriter test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).hasMessage("value is null");
        }
        try {
            DataHelper.createWriterBuilder().buildWriter().write((String) null, -1, 10);
            Assertions.fail("MockWriter test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).hasMessage("value is null");
        }
        try {
            DataHelper.createWriterBuilder().buildWriter().write("12345", -1, 10);
            Assertions.fail("MockWriter test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("offset is out of bounds");
        }
        try {
            DataHelper.createWriterBuilder().buildWriter().write("12345", 5, 10);
            Assertions.fail("MockWriter test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("offset is out of bounds");
        }
        try {
            DataHelper.createWriterBuilder().buildWriter().write("12345", 0, -1);
            Assertions.fail("MockWriter test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("length is out of bounds");
        }
        try {
            DataHelper.createWriterBuilder().buildWriter().write("12345", 0, 6);
            Assertions.fail("MockWriter test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("length is out of bounds");
        }
        try {
            DataHelper.createWriterBuilder().buildWriter().write("12345", 4, 2);
            Assertions.fail("MockWriter test fail");
        } catch (IndexOutOfBoundsException ex) {
            Assertions.assertThat(ex).hasMessage("length is out of bounds");
        }
        try {
            DataHelper.createWriterBuilder().setWriteException(new IOException("fail")).buildWriter().write("1", 0, 1);
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createWriterBuilder().setWriteException("fail").buildWriter().write("1", 0, 1);
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        Writer writer07 = DataHelper.createWriterBuilder().setContentSize(5).setWriteException("fail").buildWriter();
        writer07.write("123", 0, 3);
        Assertions.assertThat(((MockWriter) writer07).getContent()).containsExactlyInOrder('1', '2', '3');
        try {
            writer07.write("456", 0, 3);
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        Assertions.assertThat(((MockWriter) writer07).getContent()).containsExactlyInOrder('1', '2', '3', '4', '5');
    }

    /**
     * {@link MockWriter} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void flushTest() throws IOException {
        Writer writer01 = DataHelper.createWriterBuilder().setContentSize(5).buildWriter();
        writer01.flush();

        Writer writer02 = DataHelper.createWriterBuilder().setContentSize(5).buildWriter();
        writer02.write(new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'}, 0, 9);
        writer02.flush();

        Writer writer03 = DataHelper.createWriterBuilder().setWriteException("ex").buildWriter();
        writer03.flush();

        Writer writer04 = DataHelper.createWriterBuilder().setCloseException("ex").buildWriter();
        writer04.flush();

        try {
            DataHelper.createWriterBuilder().setFlushException(new IOException("fail")).buildWriter().flush();
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createWriterBuilder().setFlushException("fail").buildWriter().flush();
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        Writer writer05 = DataHelper.createWriterBuilder().setContentSize(5).setFlushException("fail").buildWriter();
        writer05.flush();
        writer05.write('1');
        writer05.flush();
        writer05.write('2');
        writer05.flush();
        writer05.write('3');
        writer05.flush();
        Assertions.assertThat(((MockWriter) writer05).getContent()).containsExactlyInOrder('1', '2', '3');
        writer05.write('4');
        writer05.flush();
        writer05.write('5');
        try {
            writer05.flush();
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        Assertions.assertThat(((MockWriter) writer05).getContent()).containsExactlyInOrder('1', '2', '3', '4', '5');
    }

    /**
     * {@link MockWriter} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void closeTest() throws IOException {
        Writer writer01 = DataHelper.createWriterBuilder().setContentSize(5).buildWriter();
        writer01.close();

        Writer writer02 = DataHelper.createWriterBuilder().setContentSize(5).buildWriter();
        writer02.write(new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'}, 0, 9);
        writer02.close();

        Writer writer03 = DataHelper.createWriterBuilder().setWriteException("ex").buildWriter();
        writer03.close();

        Writer writer04 = DataHelper.createWriterBuilder().setContentSize(5).setFlushException("ex").buildWriter();
        writer04.close();

        try {
            DataHelper.createWriterBuilder().setCloseException(new IOException("fail")).buildWriter().close();
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        try {
            DataHelper.createWriterBuilder().setCloseException("fail").buildWriter().close();
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        Writer writer05 = DataHelper.createWriterBuilder().setContentSize(5).setFlushException("fail").buildWriter();
        writer05.write('1');
        writer05.write('2');
        writer05.write('3');
        writer05.write('4');
        writer05.write('5');
        try {
            writer05.close();
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }

        Writer writer06 = DataHelper.createWriterBuilder().setContentSize(5).setFlushException("fail 1").setCloseException("fail 2").buildWriter();
        writer06.write('1');
        writer06.write('2');
        writer06.write('3');
        writer06.write('4');
        writer06.write('5');
        try {
            writer06.close();
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail 1");
        }
        try {
            writer06.close();
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail 2");
        }
    }

    /**
     * {@link MockWriter} class test.
     *
     * @throws IOException exception in test.
     */
    @Test
    public void isClosedTest() throws IOException {
        Writer writer01 = DataHelper.createWriterBuilder().setContentSize(5).buildWriter();
        Assertions.assertThat(((IsCloseable) writer01).isClosed()).isFalse();
        writer01.write('1');
        Assertions.assertThat(((IsCloseable) writer01).isClosed()).isFalse();
        writer01.write('2');
        Assertions.assertThat(((IsCloseable) writer01).isClosed()).isFalse();
        writer01.close();
        Assertions.assertThat(((IsCloseable) writer01).isClosed()).isTrue();
        writer01.close();
        Assertions.assertThat(((IsCloseable) writer01).isClosed()).isTrue();

        Writer writer02 = DataHelper.createWriterBuilder().setCloseException("fail").buildWriter();
        Assertions.assertThat(((IsCloseable) writer02).isClosed()).isFalse();
        try {
            writer02.close();
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail");
        }
        Assertions.assertThat(((IsCloseable) writer02).isClosed()).isTrue();

        Writer writer03 = DataHelper.createWriterBuilder().setFlushException("fail 1").setCloseException("fail 2").buildWriter();
        Assertions.assertThat(((IsCloseable) writer03).isClosed()).isFalse();
        try {
            writer03.close();
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail 1");
        }
        Assertions.assertThat(((IsCloseable) writer03).isClosed()).isTrue();
        try {
            writer03.close();
            Assertions.fail("MockWriter test fail");
        } catch (IOException ex) {
            Assertions.assertThat(ex).hasMessage("fail 2");
        }
        Assertions.assertThat(((IsCloseable) writer03).isClosed()).isTrue();
    }

}
